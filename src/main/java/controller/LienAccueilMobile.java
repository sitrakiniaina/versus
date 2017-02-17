/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mapping.Membre;
import mapping.ParticipationPhoto;
import metier.GestionEvenement;
import metier.GestionParticipation;

/**
 *
 * @author herinihaja
 */
public class LienAccueilMobile extends HttpServlet {
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
                String a= req.getParameter("idMembre");
                long idMembre=Long.parseLong(a);
                System.out.println("iqsdfghjklmmbre"+idMembre);
		try 	
		{
                    ArrayList<Object> arrParticipation = GestionEvenement.getAllParticipationAmi(idMembre);
                  //  ArrayList<Object> arrUrlPhoto = new ArrayList<>();
                    for(int i=0;i<arrParticipation.size();i++){
                        String sq= GestionParticipation.getUrlPhotoById(((ParticipationPhoto)arrParticipation.get(i)).getIdphotomembre());
                       // arrUrlPhoto.add(sq);
                       ((ParticipationPhoto) arrParticipation.get(i)).setUrl(sq);
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
                    Gson gson = new Gson();
                    PrintWriter out = resp.getWriter();
                    out.print(gson.toJson(arrParticipation));
                    //System.out.println(gson.toJson(arrParticipation));
                    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
