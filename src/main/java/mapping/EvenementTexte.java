package mapping;
/***********************************************************************

 * Module:  EvenementTexte.java
 * Author:  Jonathan
 * Purpose: Defines the Class EvenementTexte
 ***********************************************************************/

import java.sql.Date;

/** @pdOid faea82cb-996e-47cc-82e7-580e97a65d05 */
public class EvenementTexte 
{
	 long idevenementtexte;
	 String titre;
	 String description;
	 Date dateevenement;
	 Date dateexpiration;
	 
	public EvenementTexte(long idevenementtexte, String titre, String description, Date dateevenement,
			Date dateexpiration) {
		super();
		this.idevenementtexte = idevenementtexte;
		this.titre = titre;
		this.description = description;
		this.dateevenement = dateevenement;
		this.dateexpiration = dateexpiration;
	}
	public long getIdevenementtexte() {
		return idevenementtexte;
	}
	public void setIdevenementtexte(long idevenementtexte) {
		this.idevenementtexte = idevenementtexte;
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