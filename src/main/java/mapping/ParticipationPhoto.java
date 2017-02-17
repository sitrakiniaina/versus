package mapping;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/***********************************************************************


 * Module:  ParticipationPhoto.java
 * Author:  Jonathan
 * Purpose: Defines the Class ParticipationPhoto
 ***********************************************************************/


/** @pdOid 89a32811-fe4f-47ba-9e10-0abadc5910b6 */
public class ParticipationPhoto 
{
	 long idparticipationphoto;
	 long idevenementphoto;
	 long idphotomembre;
	 Date dateparticipationphoto;
	 long nombrevote;
         String nomPrenom;
	 
	public ParticipationPhoto(long idparticipationphoto, long idevenementphoto, long idphotomembre,
			Date dateparticipationphoto, long nombrevote) {
		super();
		this.idparticipationphoto = idparticipationphoto;
		this.idevenementphoto = idevenementphoto;
		this.idphotomembre = idphotomembre;
		this.dateparticipationphoto = dateparticipationphoto;
		this.nombrevote = nombrevote;
	}

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }
	
        
        
	public long getIdparticipationphoto() {
		return idparticipationphoto;
	}
	public void setIdparticipationphoto(long idparticipationphoto) {
		this.idparticipationphoto = idparticipationphoto;
	}
	public long getIdevenementphoto() {
		return idevenementphoto;
	}
	public void setIdevenementphoto(long idevenementphoto) {
		this.idevenementphoto = idevenementphoto;
	}
	public long getIdphotomembre() {
		return idphotomembre;
	}
	public void setIdphotomembre(long idphotomembre) {
		this.idphotomembre = idphotomembre;
	}
	public Date getDateparticipationphoto() {
		return dateparticipationphoto;
	}
	public void setDateparticipationphoto(Date dateparticipationphoto) {
		this.dateparticipationphoto = dateparticipationphoto;
	}
	public long getNombrevote() {
		return nombrevote;
	}
	public void setNombrevote(long nombrevote) {
		this.nombrevote = nombrevote;
	}
	
        
    private String url;
    private String urlPDP;

    public String getUrlPDP() {
        return urlPDP;
    }

    public void setUrlPDP(String urlPDP) {
        this.urlPDP = urlPDP;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Membre getMembre() throws Exception
    {
        Membre valiny = null;
        String sql = "SELECT membre.* FROM photomembre JOIN membre "
                + " ON photomembre.idmembre = membre.idmembre "
                + " WHERE photomembre.idphotomembre = ?";
        Connection c = jdbc.Connexion.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, this.getIdphotomembre());
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            valiny = new Membre(rs.getLong(1), rs.getString(2),
                    rs.getString(3), 
                    rs.getDate(4),
                    rs.getString(5), 
                    rs.getString(6),
                    rs.getString(7));
        }
        ps.close();
        c.close();
        return valiny;
    }
        
}