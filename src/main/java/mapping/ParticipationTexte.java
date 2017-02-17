package mapping;

import java.sql.Date;

/***********************************************************************

 * Module:  ParticipationTexte.java
 * Author:  Jonathan
 * Purpose: Defines the Class ParticipationTexte
 ***********************************************************************/

/** @pdOid 21e1623b-57e9-48d6-be95-c94c509d7188 */
public class ParticipationTexte 
{
	private long idparticipationtexte;
	private long idtextemembre;
	private long idevenementtexte;
	private Date dateparticipationtexte ;
	private long nombrevote;
	
	public ParticipationTexte(long idparticipationtexte, long idtextemembre, long idevenementtexte,
			Date dateparticipationtexte, long nombrevote) {
		super();
		this.idparticipationtexte = idparticipationtexte;
		this.idtextemembre = idtextemembre;
		this.idevenementtexte = idevenementtexte;
		this.dateparticipationtexte = dateparticipationtexte;
		this.nombrevote = nombrevote;
	}
	public long getIdparticipationtexte() {
		return idparticipationtexte;
	}
	public void setIdparticipationtexte(long idparticipationtexte) {
		this.idparticipationtexte = idparticipationtexte;
	}
	public long getIdtextemembre() {
		return idtextemembre;
	}
	public void setIdtextemembre(long idtextemembre) {
		this.idtextemembre = idtextemembre;
	}
	public long getIdevenementtexte() {
		return idevenementtexte;
	}
	public void setIdevenementtexte(long idevenementtexte) {
		this.idevenementtexte = idevenementtexte;
	}
	public Date getDateparticipationtexte() {
		return dateparticipationtexte;
	}
	public void setDateparticipationtexte(Date dateparticipationtexte) {
		this.dateparticipationtexte = dateparticipationtexte;
	}
	public long getNombrevote() {
		return nombrevote;
	}
	public void setNombrevote(long nombrevote) {
		this.nombrevote = nombrevote;
	}
	 
	
	 
}