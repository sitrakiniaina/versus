package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.Connexion;

public class GestionEntity 
{
	public static void inserer(String nomTable, Object[] valeur) throws Exception
	{
		if(valeur!=null && valeur.length>0 && nomTable!=null && nomTable.length()>0)
		{
			Connection c = Connexion.getConnection();
			String requette = "INSERT INTO "+nomTable+" VALUES (";
			int i=0;
			for(i=0; i<valeur.length-1; i++)
			{
				requette+= " ?, ";
			}
			requette+=" ?) ";
			
			PreparedStatement ps = c.prepareStatement(requette);
			for(i=0; i<valeur.length; i++)
			{
				ps.setObject(i+1, valeur[i]);
			}
			ps.executeUpdate();
                        ps.close();
                        c.close();
		}
		else if(nomTable==null || nomTable.length()==0)
		{
			throw new Exception("Entr� le nom de la table");
		}
		else if(valeur==null || valeur.length==0)
		{
			throw new Exception("Entrer des valeurs � inserer");
		}
	}
	
	public static void update(String nomTable, String clePrimaire, Object valeur, String[] attributs, Object[] nouvelleValeur) throws Exception
	{
		if(nomTable!=null && nomTable.length()>0 && clePrimaire!=null && clePrimaire.length()>0 && valeur!=null 
				&& nouvelleValeur!=null && nouvelleValeur.length>0 && attributs!=null && attributs.length == nouvelleValeur.length)
		{
			Connection c = Connexion.getConnection();
			String sql = " UPDATE "+nomTable+" SET ";
			int i = 0;
			for(i=0; i<attributs.length-1; i++)
			{
				sql+= attributs[i] + " = ?, ";
			}
			sql+= attributs[i] + " = ? ";
			sql+=" WHERE "+clePrimaire+" = ?";
			
			PreparedStatement ps = c.prepareStatement(sql);
			for(i=0; i<nouvelleValeur.length; i++)
			{
				ps.setObject(i+1, nouvelleValeur[i]);
			}
			ps.setObject(i+1, valeur);
			ps.executeUpdate();
                        ps.close();
                        c.close();
		}
	}
	
	public static long getMaxId(String nomTable) throws Exception
	{
		long valiny = 0; 
		String sql = "SELECT MAX(id"+nomTable+") FROM "+nomTable;
                Connection c = jdbc.Connexion.getConnection();
		ResultSet rs = c.prepareStatement(sql).executeQuery();
		if(rs.next())
		{
			valiny = rs.getLong(1);
		}
                c.close();
		return valiny;
	}
        public static void delete(String nomTable) throws Exception{
            /*long maxid= GestionEntity.getMaxId(nomTable);
            String sql = "delete from "+nomTable;
                sql+=" where id"+nomTable+" = "+maxid;
            Connection c = jdbc.Connexion.getConnection();
            Statement s = c.createStatement();
            s.executeUpdate(sql);
            c.close();*/
        }
}
