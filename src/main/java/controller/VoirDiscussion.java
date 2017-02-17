
package controller;


import java.io.IOException;
import java.sql.Connection;
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

public class VoirDiscussion extends HttpServlet
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
				req.getRequestDispatcher("inc/discussion.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public static ArrayList<Object> voirListeEvenementByIdMembre() throws Exception
	{
		ArrayList<Object> valiny = new ArrayList<>();
		String sql = "SELECT * FROM evenementphoto ORDER BY dateevenement DESC";
                Connection c = jdbc.Connexion.getConnection();
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
