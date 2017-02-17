package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jdbc.Connexion;
import mapping.Membre;
import mapping.ParticipationPhoto;
import metier.GestionEvenement;
import metier.GestionParticipation;

public class LienAccueil extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		try 	
		{
			Membre m = (Membre)req.getSession().getAttribute("login");
			if(m==null)
			{
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			else
			{
				ArrayList<Object> arrParticipation = GestionEvenement.getAllParticipationAmi(m.getIdmembre());
                                //  ArrayList<Object> arrUrlPhoto = new ArrayList<>();
                                  for(int i=0;i<arrParticipation.size();i++){
                                      String sq= GestionParticipation.getUrlPhotoById(((ParticipationPhoto)arrParticipation.get(i)).getIdphotomembre());
                                     // arrUrlPhoto.add(sq);
                                     ((ParticipationPhoto) arrParticipation.get(i)).setUrl(sq);
                                      System.out.println(sq);
                                      String np=  ((ParticipationPhoto) arrParticipation.get(i)).getMembre().getNom()+ " ";
                                        np+=((ParticipationPhoto) arrParticipation.get(i)).getMembre().getPrenom();
                                        ((ParticipationPhoto) arrParticipation.get(i)).setNomPrenom(np);
                                        
                                        String sexe =  ((ParticipationPhoto) arrParticipation.get(i)).getMembre().getSexe();
                                        if(sexe.compareToIgnoreCase("H")==0)
                                        {
                                            ((ParticipationPhoto) arrParticipation.get(i)).setUrlPDP("https://fathomless-dusk-14550.herokuapp.com/assets/image/pdp/91.jpg");
                                        }
                                        else
                                        {
                                            ((ParticipationPhoto) arrParticipation.get(i)).setUrlPDP("https://fathomless-dusk-14550.herokuapp.com/assets/image/pdp/92.jpg");
                                        }
                                  }
                                req.setAttribute("participation", arrParticipation);
                               
				req.getRequestDispatcher("inc/accueil.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
