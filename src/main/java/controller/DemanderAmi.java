package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mapping.Membre;
import metier.GestionEntity;
import metier.GestionMembre;
import utilitaire.Daty;

public class DemanderAmi extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String idAmi = req.getParameter("idAmi");
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
				DemanderAmi.demande(m.getIdmembre(), idAmi);
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
	
	public static void demande(long idMembreDemandeur, String idAmi) throws Exception
	{
		Membre mm = GestionMembre.getMembreById(Long.parseLong(idAmi));
		if(mm==null)
		{
			throw new Exception("Membre inéxistant");
		}
		else
		{
			long idDemande = GestionEntity.getMaxId("demandeami")+1;
			Object[] demandeInsert = new Object[]{idDemande, idMembreDemandeur, Long.parseLong(idAmi), Daty.getDatySQLAndroany(), false, false};
			GestionEntity.inserer("demandeami", demandeInsert);
		}
	}
	
	
}
