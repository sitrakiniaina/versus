package mapping;

/***********************************************************************


 * Module:  ProfilMembre.java
 * Author:  Jonathan
 * Purpose: Defines the Class ProfilMembre
 ***********************************************************************/


/** @pdOid 98ca7ca7-339e-423a-aebd-573ca6ac24e8 */
public class ProfilMembre 
{
	 long idprofilmembre;
	 long idphotomembre;
	 long idmembre;
	 String mail;
	 String motdepasse;
	 
	public ProfilMembre(long idprofilmembre, long idphotomembre, long idmembre, String mail, String motdepasse) {
		super();
		this.idprofilmembre = idprofilmembre;
		this.idphotomembre = idphotomembre;
		this.idmembre = idmembre;
		this.mail = mail;
		this.motdepasse = motdepasse;
	}
	public long getIdprofilmembre() {
		return idprofilmembre;
	}
	public void setIdprofilmembre(long idprofilmembre) {
		this.idprofilmembre = idprofilmembre;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	 
	 
	 
}