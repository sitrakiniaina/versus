package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.Connexion;
import mapping.DemandeAmi;
import mapping.Membre;

public class GestionMembre 
{
	public static Membre getMembreById(long idMembre) throws Exception
	{
		Membre valiny = null;
		String sql = "SELECT * FROM membre WHERE idmembre = ?";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idMembre);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			valiny = new Membre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
		}
                ps.close();
                c.close();
		return valiny;
	}
	
	public static boolean estAmi(long idMembre1, long idMembre2) throws Exception
	{
		String requette = "SELECT count(*) FROM amitie "
				+ " WHERE (idmembre = ? AND mem_idmembre = ?) OR (idmembre = ? AND mem_idmembre = ?)";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(requette);
		ps.setLong(1, idMembre1);
		ps.setLong(2, idMembre2);
		ps.setLong(3, idMembre2);
		ps.setLong(4, idMembre1);
		ResultSet rs = ps.executeQuery();
		int compte = 0;
		if(rs.next())
		{
			compte = rs.getInt(1);
		}
                ps.close();
                c.close();
		return compte>0;
	}
	
	public static ArrayList<DemandeAmi> getListeDemande(long idMembre) throws Exception
	{
		ArrayList<DemandeAmi> valiny = new ArrayList<>();
		String sql = "SELECT * FROM demandeami WHERE mem_idmembre = ? AND vue = ?";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idMembre);
		ps.setBoolean(2, false);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			DemandeAmi dem = new DemandeAmi(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getDate(4), rs.getBoolean(5), rs.getBoolean(6));
			valiny.add(dem);
		}
                ps.close();
                c.close();
		return valiny;
	}
	
	public static DemandeAmi getDemandeByIdDemande(long idDemande) throws Exception
	{
		DemandeAmi valiny = null;
		String sql = "SELECT * FROM demandeami WHERE iddemandeami = ? ";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idDemande);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			valiny = new DemandeAmi(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getDate(4), rs.getBoolean(5), rs.getBoolean(6));
			
		}
                ps.close();
                c.close();
		return valiny;
	}
}
