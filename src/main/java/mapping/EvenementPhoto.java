package mapping;
/***********************************************************************
 * Module:  EvenementPhoto.java
 * Author:  Jonathan
 * Purpose: Defines the Class EvenementPhoto
 ***********************************************************************/

import java.sql.Date;

/** @pdOid 7a2c39f0-ca25-4fc5-a52c-0138b463b3e9 */
public class EvenementPhoto 
{
	long idevenementphoto;
	String titre;
	String description;
	Date dateevenement;
	Date dateexpiration;
	
	public EvenementPhoto(long idevenementphoto, String titre, String description, Date dateevenement,
			Date dateexpiration) {
		super();
		this.idevenementphoto = idevenementphoto;
		this.titre = titre;
		this.description = description;
		this.dateevenement = dateevenement;
		this.dateexpiration = dateexpiration;
	}
	public long getIdevenementphoto() {
		return idevenementphoto;
	}
	public void setIdevenementphoto(long idevenementphoto) {
		this.idevenementphoto = idevenementphoto;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateevenement() {
		return dateevenement;
	}
	public void setDateevenement(Date dateevenement) {
		this.dateevenement = dateevenement;
	}
	public Date getDateexpiration() {
		return dateexpiration;
	}
	public void setDateexpiration(Date dateexpiration) {
		this.dateexpiration = dateexpiration;
	}
	
	

}