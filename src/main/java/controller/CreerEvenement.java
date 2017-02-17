
package controller;


import com.google.gson.Gson;
import static controller.VoirListeEvenement.voirListeEvenementByIdMembre;
import java.io.IOException;
import java.io.PrintWriter;
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
import metier.GestionEvenement;

public class CreerEvenement extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String titre = req.getParameter("titre");
		String description = req.getParameter("description");
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
                        GestionEvenement.creerEvenement(titre, description);
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
		doPost(req, resp);
	}
	
	
}
