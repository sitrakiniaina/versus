
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapping.EvenementTexte;
import mapping.Membre;
import metier.GestionEvenement;

public class LienParticipationTexte extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String idevenementtexte =req.getParameter("idevenementtexte");
		
		try 	
		{
			HttpSession session = req.getSession();
			Object oSession = session.getAttribute("login");
			if(oSession == null)
			{
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			else
			{
				Membre mem = (Membre) oSession;
				PrintWriter pw = resp.getWriter();
				pw.write("idevenementtexte = "+ idevenementtexte);
				EvenementTexte event = GestionEvenement.getEvenementTexteById(Long.parseLong(idevenementtexte));
				req.setAttribute("evenement", event);
				req.getRequestDispatcher("inc/participation.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}
