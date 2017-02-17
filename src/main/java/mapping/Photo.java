package mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.Connexion;

/***********************************************************************

 * Module:  Photo.java
 * Author:  Jonathan
 * Purpose: Defines the Class Photo
 ***********************************************************************/


/** @pdOid 76082423-586f-487d-81f2-ff001d6a7033 */
public class Photo 
{
	 long idphoto;
	 String url;
	 
	public Photo(long idphoto, String url) {
		super();
		this.idphoto = idphoto;
		this.url = url;
	}
	public long getIdphoto() {
		return idphoto;
	}
	public void setIdphoto(long idphoto) {
		this.idphoto = idphoto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	 
	public static Photo getPdpParDefaut() throws Exception
	{
		Photo valiny = null;
		String requette = "SELECT * FROM photo WHERE idphoto = 1";
		ResultSet rs = Connexion.getConnection().prepareStatement(requette).executeQuery();
		if(rs.next())
		{
			valiny = new Photo(rs.getLong(1), rs.getString(2));
		}
		return valiny;
	}
	
	
}