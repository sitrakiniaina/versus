package mapping;

import java.sql.Date;

public class Membre 
{
	 long idmembre;
	 String nom;
	 String prenom;
	 Date datenaissance;
	 String sexe;
	 String mail;
	 String motdepasse;
	 
	public Membre(long idmembre, String nom, String prenom, Date datenaissance, String sexe, String mail,
			String motdepasse) {
		super();
		this.idmembre = idmembre;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.sexe = sexe;
		this.mail = mail;
		this.motdepasse = motdepasse;
	}
	public long getIdmembre() {
		return idmembre;
	}
	public void setIdmembre(long idmembre) {
		this.idmembre = idmembre;
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
	public Date getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(Date datenaissance) {
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
	 
	 
}
