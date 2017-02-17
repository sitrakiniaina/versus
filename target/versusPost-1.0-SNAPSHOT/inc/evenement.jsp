<%@page import="mapping.Membre"%>
<%@page import="mapping.EvenementTexte"%>
<%@page import="mapping.EvenementPhoto"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Object> arrEvenement = (ArrayList<Object>) request.getAttribute("listeEvenement");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>PostVersus</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="assets/css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="assets/css/evenement.css" rel='stylesheet' type='text/css' />
        <script src="assets/js/jquery.min.js"></script>
    </head>
    <body style='overflow: hidden'>

        <div class="nav navbar-fixed-top" id="header" style='background-color: #269abc;height: 45px;padding-top: 5px'>
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
                <div class="col col-md-2 col-sm-2 col-lg-2 center" style="margin-top:50px;">
                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <h4> <% out.print(((Membre) request.getSession().getAttribute("login")).getPrenom()); %></h4>
                        </div>
                    </div>
                    <div class="row">
                         <div class="col-md-12 col-sm-12">
                           <%
                                if(((Membre) request.getSession().getAttribute("login")).getSexe().compareToIgnoreCase("h")==0){
                            %>
                                <a href="profil.jsp"><img alt="PDP" src="../assets/image/pdp/91.jpg" width="150px" height="150px"></a>
                            <% }else{ %>
                                <a href="profil.jsp"><img alt="PDP" src="../assets/image/pdp/92.jpg" width="150px" height="150px"></a>
                            <% } %>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <table class="table">
                            <tr><td><form action="lienAccueil"> <input class="btn btn-block btn-info" type="submit" value="Accueil"></form></td></tr>
                            <tr><td><form action="voirListeEvenement"> <input class="btn btn-block " type="submit" value="Evenement"></form></td></tr>
                            <tr><td><form action="voirMessage"> <input class="btn btn-block btn-info" type="submit" value="Messages"></form></td></tr>
                            <tr><td><form action="voirDiscussion"> <input class="btn btn-block btn-info" type="submit" value="Discussion"></form></td></tr>
                            <tr><td><form action="voirAmis"> <input class="btn btn-block btn-info" type="submit" value="Mes amis"></form></td></tr>
                            <tr><td><form action="affichageCreationEvenement"> <input class="btn btn-block btn-info" type="submit" value="Création Evenement"></form></td></tr>
                            <tr><td><form action="voirListeMembre"> <input class="btn btn-block btn-info" type="submit" value="Membre"></form></td></tr>
                        </table>
                    </div>
                </div>

                <div class="col col-md-10 col-sm-10 col-lg-10" style="overflow: scroll;margin-top:50px;max-height: 600px;height: 600px">
                    <%
                        int i = 0;
                        for (i = 0; i < arrEvenement.size(); i++) {
                            if (arrEvenement.get(i) instanceof EvenementPhoto) {
                                EvenementPhoto event = (EvenementPhoto) arrEvenement.get(i);
                    %>
                    <br>
                    <div class="row panelEvenement" style="border: 1px black; background-color: #E6E6FA;">
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <h5><% out.print(event.getTitre()); %></h5>
                                </div>
                                <div class="col-md-12">
                                    <p> <% out.print(event.getDescription()); %></p>
                                </div>
                                <div class="col-md-12">
                                    <form action="lienParticipationPhoto" method="POST"> 
                                        <input type="hidden" name="idevenementphoto" value="<% out.print(event.getIdevenementphoto()); %>">
                                        <input class="btn btn-primary" type="submit" value="Participer">
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Il y a 30 minutes</label><br>
                            <label>Date publication :<% out.print(event.getDateevenement()); %></label><br>
                            <label>Categorie VS : Photos</label><br>
                            <label>Participants : 334</label><br>
                            <label>Durée : 3 jours</label>
                        </div>
                    </div>
                    <%
                    } else if (arrEvenement.get(i) instanceof EvenementTexte) {
                        EvenementTexte event = (EvenementTexte) arrEvenement.get(i);
                    %>
                    <br>
                    <div class="row panelEvenement" style="border: 1px black; background-color: #E6E6FA;">
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <h5><% out.print(event.getTitre()); %></h5>
                                </div>
                                <div class="col-md-12">
                                    <p> <% out.print(event.getDescription()); %></p>
                                </div>
                                <div class="col-md-12">
                                    <form action="lienParticipationTexte" method="POST"> 
                                        <input type="hidden" name="idevenementtexte" value="<% out.print(event.getIdevenementtexte()); %>">
                                        <input class="btn btn-primary" type="submit" value="Participer">
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <label>Il y a 30 minutes</label><br>
                            <label>Date publication :<% out.print(event.getDateevenement()); %></label><br>
                            <label>Categorie VS : Photos</label><br>
                            <label>Participants : 334</label><br>
                            <label>Durée : 3 jours</label>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>



                </div>
            </div>
        </div>   
        <div class="row" id="footer" style='background-color: #269abc;height: 80px;padding-top: 5px;margin-top:5px' >
            <div class="col-md-12">

            </div>
        </div>


    </body>
</html>