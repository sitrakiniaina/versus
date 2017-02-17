package mapping;

import java.sql.Date;

public class TexteMembre 
{
	 long idtextemembre;
	 long idmembre;
	 String titre;
	 String contenu;
	 Date datetexte;
	 
	public TexteMembre(long idtextemembre, long idmembre, String titre, String contenu, Date datetexte) {
		super();
		this.idtextemembre = idtextemembre;
		this.idmembre = idmembre;
		this.titre = titre;
		this.contenu = contenu;
		this.datetexte = datetexte;
	}
	public long getIdtextemembre() {
		return idtextemembre;
	}
	public void setIdtextemembre(long idtextemembre) {
		this.idtextemembre = idtextemembre;
	}
	public long getIdmembre() {
		return idmembre;
	}
	public void setIdmembre(long idmembre) {
		this.idmembre = idmembre;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDatetexte() {
		return datetexte;
	}
	public void setDatetexte(Date datetexte) {
		this.datetexte = datetexte;
	}
	 
	 
}
