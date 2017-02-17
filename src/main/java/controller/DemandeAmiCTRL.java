package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapping.Membre;
import metier.GestionEntity;
import metier.GestionMembre;
import utilitaire.Daty;

public class DemandeAmiCTRL extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String idAmi = req.getParameter("idAmi");
		HttpSession session = req.getSession();
		Object oLogin = session.getAttribute("login");
		if(oLogin==null)
		{
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		else
		{
			Membre m = (Membre) oLogin;
			try 
			{
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException 
	{
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	
}
