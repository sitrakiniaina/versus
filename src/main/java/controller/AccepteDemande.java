package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.Connexion;
import mapping.DemandeAmi;
import mapping.EvenementPhoto;
import mapping.EvenementTexte;
import mapping.Membre;
import metier.GestionEntity;
import metier.GestionEvenement;
import metier.GestionMembre;
import utilitaire.Daty;

public class AccepteDemande extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String idDemande = req.getParameter("idDemande");
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
				AccepteDemande.accepter(idDemande);
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
	
	public static void accepter(String idDemande) throws Exception
	{
		DemandeAmi dem = GestionMembre.getDemandeByIdDemande(Long.parseLong(idDemande));
		GestionEntity.update("demandeami", "iddemandeami", Long.parseLong(idDemande), 
				new String[]{"iddemandeami", "idmembre", "mem_idmembre", "datedemandeami", "accepte", "vue"}
		, new Object[]{dem.getIddemandeami(), dem.getIdmembre(), dem.getMem_idmembre(), dem.getDatedemandeami(), true, true });
		
		long idAmitie = GestionEntity.getMaxId("amitie")+1;
		GestionEntity.inserer("amitie", new Object[]{idAmitie, dem.getIdmembre(), dem.getMem_idmembre() , Daty.getDatySQLAndroany(), true});
	}
	
}
