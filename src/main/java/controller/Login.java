package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.tomcat.jni.Mmap;

import jdbc.Connexion;
import mapping.Membre;
import mapping.ParticipationPhoto;
import metier.GestionEntity;
import metier.GestionEvenement;
import metier.GestionParticipation;
import utilitaire.Daty;


public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
                 
		String mail =req.getParameter("mail");
		String mdp =req.getParameter("mdp");
               
		try 	
		{
                    Membre m = Login.login(mail, mdp);
                    if(m==null){
                        
                        PrintWriter out = resp.getWriter();
                       
                        req.getRequestDispatcher("index.jsp").forward(req, resp);
                    }
                    else
                    {
                        HttpSession session = req.getSession();
                        session.setAttribute("login", m);
                       
                       
                        ArrayList<Object> arrParticipation = GestionEvenement.getAllParticipationAmi(m.getIdmembre());
                                //  ArrayList<Object> arrUrlPhoto = new ArrayList<>();
                                  for(int i=0;i<arrParticipation.size();i++){
                                      String sq= GestionParticipation.getUrlPhotoById(((ParticipationPhoto)arrParticipation.get(i)).getIdphotomembre());
                                     // arrUrlPhoto.add(sq);
                                     ((ParticipationPhoto) arrParticipation.get(i)).setUrl(sq);
                                      System.out.println(sq);
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
            req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	public static Membre login(String mail, String motDePasse) throws Exception
	{
		Membre valiny = null;
		String sql = "SELECT membre.* FROM profilmembre JOIN membre on membre.idmembre = profilmembre.idmembre "
				+ " WHERE profilmembre.mail = ? AND profilmembre.motdepasse = ?";
                Connection c = jdbc.Connexion.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, mail);
		ps.setString(2, motDePasse);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
                    valiny = new Membre(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7));
		}
                ps.close();
                c.close();
		return valiny;
	}
}
