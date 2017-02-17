package mapping;

import java.sql.Date;

public class DemandeAmi 
{
	long iddemandeami;
	long idmembre;
	long mem_idmembre;
	Date datedemandeami;
	boolean accepte;
	boolean vue;
	
	public DemandeAmi(long iddemandeami, long idmembre, long mem_idmembre, Date datedemandeami, boolean accepte,
			boolean vue) {
		super();
		this.iddemandeami = iddemandeami;
		this.idmembre = idmembre;
		this.mem_idmembre = mem_idmembre;
		this.datedemandeami = datedemandeami;
		this.accepte = accepte;
		this.vue = vue;
	}
	public long getIddemandeami() {
		return iddemandeami;
	}
	public void setIddemandeami(long iddemandeami) {
		this.iddemandeami = iddemandeami;
	}
	public long getIdmembre() {
		return idmembre;
	}
	public void setIdmembre(long idmembre) {
		this.idmembre = idmembre;
	}
	public long getMem_idmembre() {
		return mem_idmembre;
	}
	public void setMem_idmembre(long mem_idmembre) {
		this.mem_idmembre = mem_idmembre;
	}
	public Date getDatedemandeami() {
		return datedemandeami;
	}
	public void setDatedemandeami(Date datedemandeami) {
		this.datedemandeami = datedemandeami;
	}
	public boolean isAccepte() {
		return accepte;
	}
	public void setAccepte(boolean accepte) {
		this.accepte = accepte;
	}
	public boolean isVue() {
		return vue;
	}
	public void setVue(boolean vue) {
		this.vue = vue;
	}
	
	
}
