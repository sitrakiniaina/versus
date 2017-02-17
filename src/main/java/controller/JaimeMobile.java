/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapping.Membre;
import mapping.ParticipationPhoto;
import metier.GestionEvenement;
import metier.GestionJAime;
import metier.GestionParticipation;

/**
 *
 * @author herinihaja
 */
public class JaimeMobile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setHeader("Cache-control", "no-cache,no-store");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Expires", "-1");
        resp.setHeader("Access-control-Allow-Origin", "*");
        resp.setHeader("Access-control-Max-Methods", "POST");
        resp.setHeader("Access-control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-control-Max-Age", "86400");
        String idParticipationStr =  req.getParameter("idParticipation");
        System.out.println("idpargvbhnj"+idParticipationStr);
        long idParticipation = Long.parseLong(idParticipationStr);
        long idMembre = Long.parseLong(req.getParameter("idMembre"));

        try {
            GestionJAime.jaime(idParticipation, idMembre);
            
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
