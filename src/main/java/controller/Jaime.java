/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.PreparedStatement;
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
import mapping.ParticipationPhoto;
import metier.GestionEvenement;
import metier.GestionJAime;
import metier.GestionParticipation;

/**
 *
 * @author herinihaja
 */
public class Jaime extends HttpServlet {
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
                long idParticipation = Long.parseLong(req.getParameter("idParticipation"));
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
                                GestionJAime.jaime(idParticipation,m.getIdmembre());
				ArrayList<Object> arrParticipation = GestionEvenement.getAllParticipationAmi(m.getIdmembre());
                                //  ArrayList<Object> arrUrlPhoto = new ArrayList<>();
                                  for(int i=0;i<arrParticipation.size();i++){
                                      String sq= GestionParticipation.getUrlPhotoById(((ParticipationPhoto)arrParticipation.get(i)).getIdphotomembre());
                                     // arrUrlPhoto.add(sq);
                                     ((ParticipationPhoto) arrParticipation.get(i)).setUrl(sq);
                                     // System.out.println(sq);
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
