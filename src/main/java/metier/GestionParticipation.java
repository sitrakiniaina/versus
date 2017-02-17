/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author herinihaja
 */
public class GestionParticipation {
    public static String getUrlPhotoById(long id_photo) throws Exception{
        String rep="";
        String sql = "select url from photomembre where idphotomembre= ?";
        
        Connection c = jdbc.Connexion.getConnection();
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setLong(1, id_photo);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            rep = rs.getString("url");
        }
        ps.close();
        c.close();
        return rep;    
    }
    public static String getUrlProfil(long id_participation){
        String rep="";
        return rep;
    }
}
