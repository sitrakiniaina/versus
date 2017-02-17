package mapping;

import java.sql.Date;

/***********************************************************************

 * Module:  PhotoMembre.java
 * Author:  Jonathan
 * Purpose: Defines the Class PhotoMembre
 ***********************************************************************/


/** @pdOid 980ff881-19d2-4930-83bf-dba78026e681 */
public class PhotoMembre 
{
	 long idphotomembre;
	 long idmembre;
	 String url;
	 Date datePhotoMembre;
	 
	public PhotoMembre(long idphotomembre, long idmembre, String url, Date datePhotoMembre) {
		super();
		this.idphotomembre = idphotomembre;
		this.idmembre = idmembre;
		this.url = url;
		this.datePhotoMembre = datePhotoMembre;
	}
	public long getIdphotomembre() {
		return idphotomembre;
	}
	public void setIdphotomembre(long idphotomembre) {
		this.idphotomembre = idphotomembre;
	}
	public long getIdmembre() {
		return idmembre;
	}
	public void setIdmembre(long idmembre) {
		this.idmembre = idmembre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDatePhotoMembre() {
		return datePhotoMembre;
	}
	public void setDatePhotoMembre(Date datePhotoMembre) {
		this.datePhotoMembre = datePhotoMembre;
	}
	
	 
}