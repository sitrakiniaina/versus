/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import static controller.VoirListeEvenement.voirListeEvenementByIdMembre;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapping.Membre;
import metier.GestionEvenement;

/**
 *
 * @author herinihaja
 */
public class CreerEvenementMobile extends HttpServlet {
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
		String titre = req.getParameter("titre");
		String description = req.getParameter("description");
                try 
                {
                    String rep=GestionEvenement.creerEvenement(titre, description);
                    if(rep!=null){
                        Gson gson = new Gson();
                        PrintWriter out = resp.getWriter();
                        out.print(gson.toJson("1"));
                    }else{
                        Gson gson = new Gson();
                        PrintWriter out = resp.getWriter();
                        out.print(gson.toJson("0"));
                    }
                    
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
