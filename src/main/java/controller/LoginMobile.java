/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.Connexion;
import mapping.Membre;

/**
 *
 * @author herinihaja
 */
public class LoginMobile extends HttpServlet{
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.setContentType("application/json;charset=UTF-8");
                resp.setHeader("Cache-control", "no-cache,no-store");
                resp.setHeader("Pragma", "no-cache");
                resp.setHeader("Expires", "-1");
                resp.setHeader("Access-control-Allow-Origin", "*");
                resp.setHeader("Access-control-Max-Methods", "POST");
                resp.setHeader("Access-control-Allow-Headers", "Content-Type");
                resp.setHeader("Access-control-Max-Age", "86400");
                 
		String mail =req.getParameter("username");
		String mdp =req.getParameter("password");
               
               
		try 	
		{
                    Membre m = Login.login(mail, mdp);
                    if(m==null){
                        Gson gson = new Gson();
                        PrintWriter out = resp.getWriter();
                        out.print(gson.toJson("0"));
                    }
                    else
                    {
                        Gson gson = new Gson();
                        gson.toJson(m);
                        PrintWriter out = resp.getWriter();
                        out.print(gson.toJson(m.getIdmembre()));
                        
                    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //req.getRequestDispatcher("index.jsp").forward(req, resp);
            doPost(req, resp);
	}
	
	public static Membre login(String mail, String motDePasse) throws Exception
	{
		Membre valiny = null;
		String sql = "SELECT membre.* FROM profilmembre JOIN membre on membre.idmembre = profilmembre.idmembre "
				+ " WHERE profilmembre.mail = ? AND profilmembre.motdepasse = ?";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, mail);
		ps.setString(2, motDePasse);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
                    valiny = new Membre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
		}
                ps.close();
                c.close();
		return valiny;
	}
}
