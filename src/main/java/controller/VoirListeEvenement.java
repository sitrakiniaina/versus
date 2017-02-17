package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Mmap;

import jdbc.Connexion;
import mapping.EvenementPhoto;
import mapping.EvenementTexte;
import mapping.Membre;
import metier.GestionEntity;
import metier.GestionEvenement;
import utilitaire.Daty;

public class VoirListeEvenement extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		Object oSession = session.getAttribute("login");
		if(oSession==null)
		{
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else
		{
			Membre m = (Membre) oSession;
			try 
			{
				ArrayList<Object> listeEvent = voirListeEvenementByIdMembre();
				req.setAttribute("listeEvenement", listeEvent);
				req.getRequestDispatcher("inc/evenement.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("index.jsp").forward(req, resp);
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
