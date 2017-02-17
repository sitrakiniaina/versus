package mapping;

import java.sql.Date;

public class Amitie 
{
	long idamitie;
	long idmembre;
	long mem_idmembre;
	Date dateajout;
	boolean ami;
	
	public Amitie(long idamitie, long idmembre, long mem_idmembre, Date dateajout, boolean ami) {
		super();
		this.idamitie = idamitie;
		this.idmembre = idmembre;
		this.mem_idmembre = mem_idmembre;
		this.dateajout = dateajout;
		this.ami = ami;
	}
	
	public long getIdamitie() {
		return idamitie;
	}
	public void setIdamitie(long idamitie) {
		this.idamitie = idamitie;
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
	public Date getDateajout() {
		return dateajout;
	}
	public void setDateajout(Date dateajout) {
		this.dateajout = dateajout;
	}
	public boolean isAmi() {
		return ami;
	}
	public void setAmi(boolean ami) {
		this.ami = ami;
	}
	
	
}
