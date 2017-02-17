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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.Connexion;
import mapping.EvenementPhoto;
import mapping.EvenementTexte;
import mapping.Membre;

/**
 *
 * @author herinihaja
 */
public class VoirListeEventMobile extends HttpServlet{
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("application/json;charset=UTF-8");
                resp.setHeader("Cache-control", "no-cache,no-store");
                resp.setHeader("Pragma", "no-cache");
                resp.setHeader("Expires", "-1");
                resp.setHeader("Access-control-Allow-Origin", "*");
                resp.setHeader("Access-control-Max-Methods", "POST");
                resp.setHeader("Access-control-Allow-Headers", "Content-Type");
                resp.setHeader("Access-control-Max-Age", "86400");
                try {
                    ArrayList<Object> listevent=voirListeEvenementByIdMembre();
                    Gson gson = new Gson();
                    PrintWriter out = resp.getWriter();
                    out.print(gson.toJson(listevent));
                } catch (Exception ex) {
                    Logger.getLogger(VoirListeEventMobile.class.getName()).log(Level.SEVERE, null, ex);
                }
                
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	public static ArrayList<Object> voirListeEvenementByIdMembre() throws Exception
	{
		ArrayList<Object> valiny = new ArrayList<>();
                Connection c = jdbc.Connexion.getConnection();
		String sql = "SELECT * FROM evenementphoto ORDER BY dateevenement DESC";
		ResultSet rs = c.prepareStatement(sql).executeQuery();
		while(rs.next())
		{
			EvenementPhoto evtPh = new EvenementPhoto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5));
			valiny.add(evtPh);
		}
		
		String sqlTexte = "SELECT * FROM evenementtexte ORDER BY dateevenement DESC";
		ResultSet rsTexte = c.prepareStatement(sqlTexte).executeQuery();
		while(rsTexte.next())
		{
			EvenementTexte evtTexte = new EvenementTexte(rsTexte.getLong(1), rsTexte.getString(2), rsTexte.getString(3), rsTexte.getDate(4), rsTexte.getDate(5));
			valiny.add(evtTexte);
		}
                c.close();
		return valiny;
	}
	
}
