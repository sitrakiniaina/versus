
package controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapping.DemandeAmi;
import mapping.Membre;
import metier.GestionEvenement;
import metier.GestionMembre;

public class VoirAmis extends HttpServlet
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
				ArrayList<Membre> arrAmis = GestionEvenement.amisEnCommun(m.getIdmembre(), m.getIdmembre());
				ArrayList<Membre> listeAmi = new ArrayList<>();
				int i = 0;
				for(i=0; i<arrAmis.size(); i++)
				{
					if(arrAmis.get(i).getIdmembre()!=m.getIdmembre())
					{
						listeAmi.add(arrAmis.get(i));
					}
				}
				
				ArrayList<DemandeAmi> listeDemande = GestionMembre.getListeDemande(m.getIdmembre());
				req.setAttribute("listeAmi", listeAmi);
				req.setAttribute("listeDemande", listeDemande);
				req.getRequestDispatcher("inc/amis.jsp").forward(req, resp);
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
