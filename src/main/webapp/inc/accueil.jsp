<%@page import="mapping.Membre"%>
<%@page import="mapping.ParticipationTexte"%>
<%@page import="mapping.ParticipationPhoto"%>
<%@page import="java.util.ArrayList"%>

<%
    ArrayList<Object> arrParticipation = (ArrayList<Object>) request.getAttribute("participation");

%>

<!DOCTYPE html>
<html>
    <head>
        <title>PostVersus</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="assets/css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="assets/css/accueil.css" rel='stylesheet' type='text/css' />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="assets/font-awesome/css/font-awesome.min.css" rel='stylesheet' type='text/css' />
        <script src="assets/js/jquery.min.js"></script>
    </head>
    <body style='overflow-x: hidden'>

        <div class="nav navbar-fixed-top" id="header" style='background-color: #269abc;height: 55px;padding-top: 8px'>
            <div class="col col-md-2 col-sm-2"><img alt="PostVersus" src="../assets/image/versus/logo.png"></div>
            <div class="col col-md-7 col-sm-7">
                <form class="form-inline" action="recherche" method="GET">
                    <div class="row">
                        <div class="col col-md-4 col-sm-4">
                            Recherche : 
                            <select name="categorieRecherche">
                                <option value="personne">Personne</option>
                                <option value="evenement">Evénement</option>
                                <option value="tous">Tous</option>
                            </select>
                        </div>
                        <div class="col col-md-6 col-sm-6">
                            <input class="form-control" type="text" name="zoneRecherche" style="width: 100%">
                        </div>
                        <div class="col col-md-2 col-sm-2">
                            <input class="btn btn-info" type="submit" value="Rechercher">
                        </div>
                    </div>
                </form>
            </div>
            <div class="col col-md-3 col-sm-3">
                <div class="row">
                    <div class="col-md-6 col-sm-6" ></div>
                    <div class="col-md-6 col-sm-6">
                        <form class="form-inline" action="deconnexion" method="POST">
                            <input class="btn btn-danger" type="submit" value="Deconnexion">
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <div class='container'>
            <div class="row" id="center">
                <div class="col col-md-2 col-sm-2 col-lg-2 center" style="margin-top:60px;">
                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <h4> <% out.print(((Membre) request.getSession().getAttribute("login")).getPrenom()); %></h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                           <%
                                if(((Membre) request.getSession().getAttribute("login")).getSexe().compareToIgnoreCase("h")==0)
                                {
                            %>
                                <a href="profil.jsp"><img alt="PDP" src="../assets/image/pdp/91.jpg" width="150px" height="150px"></a>
                            <% }
                                else
                               { 
                            %>
                                <a href="profil.jsp"><img alt="PDP" src="../assets/image/pdp/92.jpg" width="150px" height="150px"></a>
                            <% } %>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <table class="table">
                            <tr><td><form action="lienAccueil"> <input class="btn btn-block" type="submit" value="Accueil"></form></td></tr>
                            <tr><td><form action="voirListeEvenement"> <input class="btn btn-block btn-info" type="submit" value="Evenement"></form></td></tr>
                            <tr><td><form action="voirMessage"> <input class="btn btn-block btn-info" type="submit" value="Messages"></form></td></tr>
                            <tr><td><form action="voirDiscussion"> <input class="btn btn-block btn-info" type="submit" value="Discussion"></form></td></tr>
                            <tr><td><form action="voirAmis"> <input class="btn btn-block btn-info" type="submit" value="Mes amis"></form></td></tr>
                            <tr><td><form action="affichageCreationEvenement"> <input class="btn btn-block btn-info" type="submit" value="Création Evenement"></form></td></tr>
                            <tr><td><form action="voirListeMembre"> <input class="btn btn-block btn-info" type="submit" value="Membre"></form></td></tr>
                        </table>
                    </div>
                </div>

                <div class="col col-md-10 col-sm-10 col-lg-10" style="overflow: scroll;overflow-x: hidden;margin-top:60px;max-height: 600px;height: 600px">

                    <div></div>
                    <br>
                    <%
                        int i = 0;
                        for (i = 0; i < arrParticipation.size(); i++) {
                    %>
                    <div class='row'>
                        <div class='row'>
                            <div class='col-md-2 col-sm-2'>
                                <img style='margin-left: 35px' src='<% out.print(((ParticipationPhoto)arrParticipation.get(i)).getUrlPDP()); %>' alt='photoProfil' width='70px' height="70px"/>
                            </div>
                            <div class='col-md-10 col-sm-10'>
                                <a href='#'><label class='col-md-12 col-sm-12' style='font-size: 18px'>
                                        <% 
                                            Membre m = ((ParticipationPhoto)arrParticipation.get(i)).getMembre();
                                            out.print(m.getNom()+" "+m.getPrenom());%>
                                </label></a>
                                <label class='col-md-12 col-sm-12' style='font-size: 10px'>1h ago</label>
                                
                            </div>
                        </div>
                        <br>
                        <div class='row' >
                            <div style="margin-left: 50px;">
                                <img src="<% out.print("upload/image/"+((ParticipationPhoto)arrParticipation.get(i)).getUrl());%>" alt='photoPublier' width='300px' height="300px"/>
                                <br>
                                <br>
                                <p> <% out.print(((ParticipationPhoto)arrParticipation.get(i)).getNombrevote());%> vote(s)</p>
                            </div>
                        </div>
                        
                        <div class='row'>
                            <div class='col-md-6' style='margin-left: 60px'>
                                <div class="row">
                                    <form class=" col col-md-6"  action="jaime" method="POST">
                                        <input type="hidden" name="idParticipation" value="<%out.print(((ParticipationPhoto)arrParticipation.get(i)).getIdparticipationphoto());%>"/>
                                        <button type="submit"><i class="fa fa-thumbs-up" style="font-size:24px;"></i></button> 
                                    </form>
                                        <form style="margin-left:-90px" class="col col-md-6" action="jaimepas" method="POST">
                                        <input type="hidden" name="idParticipation" value="<%out.print(((ParticipationPhoto)arrParticipation.get(i)).getIdparticipationphoto());%>"/>
                                        <button type="submit"><i class="fa fa-thumbs-down" style="font-size:24px;"></i></button> 
                                    </form>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                    <hr>
                    <% } %>
                   
                    
                </div>
            </div>
        </div>   
        <div class="row" id="footer" style='background-color: #269abc;height: 80px;padding-top: 5px;margin-top:5px' >
            <div class="col-md-12">

            </div>
        </div>
    </body>
</html>