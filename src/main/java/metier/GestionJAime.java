package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jdbc.Connexion;
import mapping.ParticipationPhoto;
import utilitaire.Daty;

public class GestionJAime 
{
	public static ParticipationPhoto getParticipationPhotoById(long idParticipation) throws Exception
	{
		ParticipationPhoto valiny = null;
		String sql = "SELECT * FROM participationphoto WHERE idparticipationphoto = ? ";
                Connection c=jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idParticipation);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			valiny = new ParticipationPhoto(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getDate(4), rs.getLong(5));
		}
                ps.close();
                c.close();
		return valiny;
	}
	
	public static void jaime(long idParticipation, long idMembre) throws Exception
	{
		ParticipationPhoto partPh = GestionJAime.getParticipationPhotoById(idParticipation);
		if(partPh==null)
		{
			throw new Exception("ParticipationPhoto inéxistant pour ID = "+Long.toString(idParticipation));
		}
		else
		{
			int compte = 0;
			String sqlMembreJaime = "SELECT count(*) FROM jaimephoto WHERE idmembre = ? AND idparticipationphoto = ?";
                        Connection c = jdbc.Connexion.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlMembreJaime);
			ps.setLong(1, idMembre);
			ps.setLong(2, idParticipation);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				compte = rs.getInt(1);
			}
			if(compte==0)
			{
				long nbrVote = partPh.getNombrevote()+1;
				GestionEntity.update("participationphoto", "idparticipationphoto", new Long(idParticipation), 
						new String[]{
								"idparticipationphoto","idevenementphoto", "idphotomembre", "dateparticipationphoto", "nombrevote"
						}, 
						new Object[]{
								partPh.getIdparticipationphoto(), partPh.getIdevenementphoto(), partPh.getIdphotomembre(), 
								partPh.getDateparticipationphoto(), nbrVote
						});
				
				long idJaime = GestionEntity.getMaxId("jaimephoto")+1;
				GestionEntity.inserer("jaimephoto", new Object[]{
						idJaime,
						idMembre, 
						idParticipation, 
						Daty.getDatyTimesTampAndroany(),
						Daty.getDatyTimesTampAndroany()
				});
			}
                        ps.close();
                        c.close();
			
		}
	}
	
	public static void jeNaimePas(long idParticipation, long idMembre) throws Exception
	{
		ParticipationPhoto partPh = GestionJAime.getParticipationPhotoById(idParticipation);
		if(partPh==null)
		{
			throw new Exception("ParticipationPhoto inéxistant pour ID = "+Long.toString(idParticipation));
		}
		else
		{
			int compte = 0;
			String sqlMembreJaime = "SELECT count(*) FROM jaimephoto WHERE idmembre = ? AND idparticipationphoto = ?";
                        Connection c = jdbc.Connexion.getConnection();
			PreparedStatement ps = c.prepareStatement(sqlMembreJaime);
			ps.setLong(1, idMembre);
			ps.setLong(2, idParticipation);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				compte = rs.getInt(1);
			}
			if(compte==0)
			{
				long nbrVote = partPh.getNombrevote()-1;
				GestionEntity.update("participationphoto", "idparticipationphoto", new Long(idParticipation), 
						new String[]{
								"idparticipationphoto","idevenementphoto", "idphotomembre", "dateparticipationphoto", "nombrevote"
						}, 
						new Object[]{
								partPh.getIdparticipationphoto(), partPh.getIdevenementphoto(), partPh.getIdphotomembre(), 
								partPh.getDateparticipationphoto(), nbrVote
						});
				long idJaime = GestionEntity.getMaxId("jaimephoto")+1;
				GestionEntity.inserer("jaimephoto", new Object[]{
						idJaime,
						idMembre, 
						idParticipation, 
						Daty.getDatyTimesTampAndroany(),
						Daty.getDatyTimesTampAndroany()
				});
			}
                        ps.close();
                        c.close();
		}
	}
}
