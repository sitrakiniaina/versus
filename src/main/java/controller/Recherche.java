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

import jdbc.Connexion;
import mapping.EvenementPhoto;
import mapping.EvenementTexte;
import mapping.Membre;

public class Recherche extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String categorieRecherche = req.getParameter("categorieRecherche");
		String zoneRecherche =req.getParameter("zoneRecherche");
		HttpSession session = req.getSession();
		Object oSession = session.getAttribute("login");
		
		if(oSession==null)
		{
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else
		{
			try 
			{
				ArrayList<Object> valinyReche = recherche(categorieRecherche, zoneRecherche);
				req.setAttribute("resultatRecherche", valinyReche);
				req.getRequestDispatcher("resultatRecherche.jsp").forward(req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			PrintWriter pw= resp.getWriter();
			pw.write(categorieRecherche+" "+zoneRecherche);
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException 
	{
		doPost(req, resp);
	}
	
	public static ArrayList<Object> recherche(String categorie, String value) throws Exception
	{
		ArrayList<Object> valiny = new ArrayList<>();
		if(categorie!=null && categorie.compareToIgnoreCase("Tous")==0)
		{
			ArrayList<Object> arrPers = recherchePersonne(value);
			ArrayList<Object> arrEvt = rechercheEvenement(value);
			int i=0;
			for(i=0; i<arrPers.size(); i++)
			{
				valiny.add(arrPers.get(i));
			}
			for(i=0; i<arrEvt.size(); i++)
			{
				valiny.add(arrEvt.get(i));
			}
		}
		else if(categorie!=null && categorie.compareToIgnoreCase("personne")==0)
		{
			ArrayList<Object> arrPers = recherchePersonne(value);
			int i=0;
			for(i=0; i<arrPers.size(); i++)
			{
				valiny.add(arrPers.get(i));
			}
		}
		else if(categorie!=null && categorie.compareToIgnoreCase("evenement")==0)
		{
			ArrayList<Object> arrEvt = rechercheEvenement(value);
			int i=0;
			for(i=0; i<arrEvt.size(); i++)
			{
				valiny.add(arrEvt.get(i));
			}
		}
		return valiny;
	}
	
	private static ArrayList<Object> recherchePersonne(String value) throws Exception
	{
		String requette = "SELECT * FROM membre WHERE nom ILIKE ? OR prenom ILIKE ?";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(requette);
		ps.setString(1, value);
		ps.setString(2, value);
		ResultSet rs = ps.executeQuery();
		ArrayList<Object> valiny = new ArrayList<>();
		while(rs.next())
		{
			Membre m = new Membre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
			valiny.add(m);
		}
                ps.close();
                c.close();
		return valiny;
	}
	
	private static ArrayList<Object> rechercheEvenement(String value) throws Exception
	{
		String requette = "SELECT * FROM evenementphoto WHERE titre ILIKE ? OR description ILIKE ?";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(requette);
		ps.setString(1, value);
		ps.setString(2, value);
		ResultSet rs = ps.executeQuery();
		ArrayList<Object> valiny = new ArrayList<>();
		while(rs.next())
		{
			EvenementPhoto evtPh = new EvenementPhoto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5));
			valiny.add(evtPh);
		}
		
		String requetteTexte = "SELECT * FROM evenementtexte WHERE titre ILIKE ? OR description ILIKE ?";
		PreparedStatement psTexte = c.prepareStatement(requetteTexte);
		psTexte.setString(1, value);
		psTexte.setString(2, value);
		ResultSet rsTexte = psTexte.executeQuery();
		while(rsTexte.next())
		{
			EvenementTexte evtTexte = new EvenementTexte(rsTexte.getLong(1), rsTexte.getString(2), rsTexte.getString(3), rsTexte.getDate(4), rsTexte.getDate(5));
			valiny.add(evtTexte);
		}
                ps.close();
                psTexte.close();
                c.close();
		return valiny;
	}
}
