package mapping;

import java.sql.Date;

/***********************************************************************
 * Module:  Inscription.java
 * Author:  Jonathan
 * Purpose: Defines the Class Inscription
 ***********************************************************************/


/** @pdOid 9ba5c269-49fc-4e6f-a38c-d7ca8712554b */
public class Inscription 
{
	long idinscription;
	long idtoken;
	String nom;
	String prenom;
	String datenaissance;
	String sexe;
	String mail;
	String motdepasse;
	Date dateexpiration;
	Date dateinscription;
	
	public long getIdinscription() {
		return idinscription;
	}public Inscription(long idinscription, long idtoken, String nom, String prenom, String datenaissance, String sexe,
			String mail, String motdepasse, Date dateexpiration, Date dateinscription) {
		super();
		this.idinscription = idinscription;
		this.idtoken = idtoken;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.sexe = sexe;
		this.mail = mail;
		this.motdepasse = motdepasse;
		this.dateexpiration = dateexpiration;
		this.dateinscription = dateinscription;
	}

	public void setIdinscription(long idinscription) {
		this.idinscription = idinscription;
	}
	public long getIdtoken() {
		return idtoken;
	}
	public void setIdtoken(long idtoken) {
		this.idtoken = idtoken;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
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
	public Date getDateexpiration() {
		return dateexpiration;
	}
	public void setDateexpiration(Date dateexpiration) {
		this.dateexpiration = dateexpiration;
	}
	public Date getDateinscription() {
		return dateinscription;
	}
	public void setDateinscription(Date dateinscription) {
		this.dateinscription = dateinscription;
	}
	
	
	
}