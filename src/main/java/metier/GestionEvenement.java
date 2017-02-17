package metier;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.Connexion;
import mapping.EvenementPhoto;
import mapping.EvenementTexte;
import mapping.Membre;
import mapping.ParticipationPhoto;
import mapping.ParticipationTexte;
import utilitaire.Daty;
import utilitaire.GestionTexte;

public class GestionEvenement 
{
	public static ArrayList<Object> getAllParticipationAmi(long idMembre) throws Exception
	{
		ArrayList<Membre> amisDesAmis = new ArrayList<>();
		ArrayList<Membre> listeAmi = GestionEvenement.amisEnCommun(idMembre, idMembre);
		amisDesAmis.addAll(listeAmi);
		int i=0;
		for(i=0; i<listeAmi.size(); i++)
		{
			ArrayList<Membre> namanNamana = GestionEvenement.amisEnCommun(listeAmi.get(i).getIdmembre(), listeAmi.get(i).getIdmembre());
			amisDesAmis.addAll(namanNamana);
		}
		ArrayList<Object> listeIdMembre = new ArrayList<>();
		for(i=0; i<amisDesAmis.size(); i++)
		{
			listeIdMembre.add((Object)new Long(amisDesAmis.get(i).getIdmembre()));
		}
		listeIdMembre = GestionTexte.suppressionDoublon(listeIdMembre);
		
		ArrayList<Object> valiny = new ArrayList<>();
		for(i=0; i<listeIdMembre.size(); i++)
		{
			ParticipationPhoto partPh = GestionEvenement.getLastParticipationPhotoByIdMembre(((Long)listeIdMembre.get(i)).longValue());
			ParticipationTexte partTexte = GestionEvenement.getLastParticipationTexteByIdMembre(((Long)listeIdMembre.get(i)).longValue());
			if(partPh!=null)
			{
				valiny.add(partPh);
			}
			if(partTexte!=null)
			{
				valiny.add(partTexte);
			}
		}
		return valiny;
	}
	
	public static ArrayList<Membre> amisEnCommun(long idMembre1, long idMembre2) throws Exception
	{
		String sql = "SELECT * FROM ( SELECT idmembre AS amis_commun FROM amitie WHERE mem_idmembre = ? AND amitie.ami = true "
				+" UNION SELECT mem_idmembre AS amis_commun FROM amitie WHERE idmembre = ?  AND amitie.ami = true) vue1 "
				+" JOIN "
				+ " ( SELECT idmembre AS amis_commun2 FROM amitie WHERE mem_idmembre = ? AND amitie.ami = true "
				+ "  UNION SELECT mem_idmembre AS amis_commun2 FROM amitie WHERE idmembre = ? AND amitie.ami = true) vue2 "
				 + "  ON vue1.amis_commun=vue2.amis_commun2 ";
		Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idMembre1);
		ps.setLong(2, idMembre1);
		ps.setLong(3, idMembre2);
		ps.setLong(4, idMembre2);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Membre> valiny = new ArrayList<>();
		
		while(rs.next())
		{
			Membre m = GestionMembre.getMembreById(rs.getLong(1));
			valiny.add(m);
		}
                ps.close();
                c.close();
		return valiny;
	}
	
	public static ParticipationPhoto getLastParticipationPhotoByIdMembre(long idMembre) throws Exception
	{
		ParticipationPhoto valiny = null;
		String sql = "SELECT participationphoto.* FROM participationphoto JOIN photomembre "
				+ " ON participationphoto.idphotomembre = photomembre.idphotomembre "
				+ " JOIN membre ON photomembre.idmembre = membre.idmembre "
				+ " WHERE membre.idmembre = ? ORDER by idparticipationphoto DESC LIMIT 1";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idMembre);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
                    valiny = new ParticipationPhoto(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getDate(4), rs.getLong(5));
		}
                ps.close();
                c.close();
		return valiny;
	}
	
	public static ParticipationTexte getLastParticipationTexteByIdMembre(long idMembre) throws Exception
	{
		ParticipationTexte valiny = null;
		String sql = "SELECT participationtexte.* FROM participationtexte JOIN textemembre "
				+ " ON participationtexte.idtextemembre = textemembre.idtextemembre "
				+ " JOIN membre ON textemembre.idmembre = membre.idmembre "
				+ " WHERE membre.idmembre = ? ORDER by dateparticipationtexte DESC LIMIT 1";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idMembre);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			valiny = new ParticipationTexte(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getDate(4), rs.getLong(5));
		}
                ps.close();
                c.close();
		return valiny;
	}
	
	public static EvenementPhoto getEvenementPhotoById(long idEvenement) throws Exception
	{
		EvenementPhoto valiny = null;
		String sql = "SELECT * FROM evenementphoto WHERE idevenementphoto = ?";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idEvenement);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			valiny = new EvenementPhoto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5));
		}
                ps.close();
                c.close();
		return valiny;
	}
	
	public static EvenementTexte getEvenementTexteById(long idEvenement) throws Exception
	{
		EvenementTexte valiny = null;
		String sql = "SELECT * FROM evenementtexte WHERE idevenementtexte = ?";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idEvenement);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			valiny = new EvenementTexte(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5));
		}
                ps.close();
                c.close();
		return valiny;
	}
	
	public static String creerEvenement(String titre, String description) throws Exception
	{
            String valiny=null;
		if(titre!=null && titre.length()>0 && description!=null && description.length()>0)
		{
			long idEvent = GestionEntity.getMaxId("evenementphoto")+1;
			Date dEvent = Daty.getDatySQLAndroany();
			Date dExpiration = new Date(dEvent.getYear(), dEvent.getMonth(), dEvent.getDate()+2);
			GestionEntity.inserer("evenementphoto", new Object[]{idEvent, titre, description,dEvent, dExpiration });
                        return "ok";
		}
             return valiny;
	}
}
