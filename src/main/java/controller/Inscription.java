package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapping.Photo;
import mapping.PhotoMembre;
import metier.GestionEntity;
import utilitaire.Daty;

public class Inscription extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom =req.getParameter("prenom");
		String dateNaissance =req.getParameter("dateNaissance");
		String sexe =req.getParameter("sexe");
		String mail =req.getParameter("mail");
		String mdp1 =req.getParameter("mdp1");
		String mdp2 =req.getParameter("mdp2");
		PrintWriter pw = resp.getWriter();
		//pw.write(nom+" "+prenom+" "+dateNaissance+" "+sexe+" "+mail+" "+mdp1+" "+mdp2);
		
		try 
		{
			Inscription.inscription(nom, prenom, dateNaissance, sexe, mail, mdp1, mdp2);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException 
	{
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	public static void inscription(String nom, String prenom, String dateNaissance, String sexe, 
			String mail, String mdp1, String mdp2) throws Exception
	{
		if(nom!=null && nom.length()>0 && prenom!=null && prenom.length()>0 && sexe!=null 
				&& (sexe.compareToIgnoreCase("F")==0 || sexe.compareToIgnoreCase("H")==0) && mdp1!=null && mdp2!=null 
				&& mdp1.compareTo(mdp2)==0 && mdp1.length()>=4)
		{
			Date dNaissance = Date.valueOf(Daty.corrigeDate(dateNaissance));
			Photo p = Photo.getPdpParDefaut();
			if(p!=null)
			{
				long idPhotombr = GestionEntity.getMaxId("photomembre")+1;
				long idMembre = GestionEntity.getMaxId("membre")+1;
				long idProfilMembre = GestionEntity.getMaxId("profilmembre")+1;
				
				Object[] membreInsert = new Object[]{idMembre, nom, prenom, dNaissance, sexe, mail, mdp1};
				GestionEntity.inserer("membre", membreInsert);
				
				Object[] photoMembreInsert = new Object[]{idPhotombr, idMembre, p.getUrl(), Daty.getDatySQLAndroany()};
				GestionEntity.inserer("photomembre", photoMembreInsert);
				
				Object[] profilMembreInsert = new Object[]{idProfilMembre, idMembre, idPhotombr, mail, mdp1};
				GestionEntity.inserer("profilmembre", profilMembreInsert);
			}
		}
	}
}
