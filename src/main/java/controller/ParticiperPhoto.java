package controller;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import mapping.EvenementPhoto;
import mapping.Membre;
import mapping.ParticipationPhoto;
import metier.GestionEntity;
import metier.GestionEvenement;
import metier.GestionParticipation;
import utilitaire.Daty;

public class ParticiperPhoto extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "upload";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String appPath = req.getServletContext().getRealPath("/");
        //System.out.println("apppPatth" + appPath);
        String savePath = appPath + UPLOAD_DIRECTORY;
        //System.out.println("tena izy    " + savePath);
        HttpSession session = req.getSession();
        Object oSession = session.getAttribute("login");
        if (oSession == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            Membre m = (Membre) oSession;
            try {
                String idevenementphoto = req.getSession().getAttribute("idevenementphoto").toString();
                participer(req, "", "", idevenementphoto, m, savePath);
                //System.out.println(savePath);
                ArrayList<Object> arrParticipation = GestionEvenement.getAllParticipationAmi(m.getIdmembre());
                //  ArrayList<Object> arrUrlPhoto = new ArrayList<>();
                for (int i = 0; i < arrParticipation.size(); i++) {
                    String sq = GestionParticipation.getUrlPhotoById(((ParticipationPhoto) arrParticipation.get(i)).getIdphotomembre());
                    // arrUrlPhoto.add(sq);
                    ((ParticipationPhoto) arrParticipation.get(i)).setUrl(sq);
                    //System.out.println(sq);
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

    public static String upload(HttpServletRequest req, String idEvenement, Membre m, String root, String nomFichier) throws Exception {
        String url = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (isMultipart) {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                // Parse the request
                List /* FileItem */ items = upload.parseRequest(req);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {

                        String filename = nomFichier + item.getName();
                        File path = new File(root + "/image");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + filename);
                        item.write(uploadedFile);

                        System.out.println(uploadedFile.getAbsolutePath());
                        //url =  uploadedFile.getAbsolutePath();
                        url = filename;
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    public static void participer(HttpServletRequest request, String surnom, String phrase,
            String idEvenement, Membre m, String chemin) throws Exception {
        long idPhotoMembre = GestionEntity.getMaxId("photomembre") + 1;
        String url = ParticiperPhoto.upload(request, idEvenement, m, chemin, m.getPrenom() + m.getNom() + Long.toString(idPhotoMembre));

        GestionEntity.inserer("photomembre", new Object[]{idPhotoMembre, m.getIdmembre(),
            url, Daty.getDatySQLAndroany()});

        long idParticipation = GestionEntity.getMaxId("participationphoto") + 1;
        GestionEntity.inserer("participationphoto", new Object[]{
            idParticipation,
            Long.parseLong(idEvenement),
            idPhotoMembre,
            Daty.getDatySQLAndroany(),
            0
        });
    }
}
