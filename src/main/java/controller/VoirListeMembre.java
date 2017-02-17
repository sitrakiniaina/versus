package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class VoirListeMembre extends HttpServlet
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
				ArrayList<Membre> listeMembre = VoirListeMembre.getAllMembre(m.getIdmembre());
				req.setAttribute("listeMembre", listeMembre);
				req.getRequestDispatcher("inc/membre.jsp").forward(req, resp);
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
	
	public static ArrayList<Membre> getAllMembre(long idMembreRegardant) throws Exception
	{
		String sql = "SELECT * FROM membre WHERE idmembre != ? ";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setLong(1, idMembreRegardant);
		ResultSet rs = ps.executeQuery();
		ArrayList<Membre> valiny = new ArrayList<>();
		while(rs.next())
		{
			Membre mm = new Membre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
			valiny.add(mm);
		}
                ps.close();
                c.close();
		return valiny;
	}
	
}
