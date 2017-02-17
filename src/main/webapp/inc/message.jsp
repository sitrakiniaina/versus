
<!DOCTYPE html>
<%@page import="mapping.Membre"%>
<html>
    <head>
        <title>PostVersus</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="assets/css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="assets/css/index.css" rel='stylesheet' type='text/css' />
        <script src="assets/js/jquery.min.js"></script>
    </head>
    <body style='overflow-x: hidden;overflow: scroll'>

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
                            <tr><td><form action="voirListeEvenement"> <input class="btn btn-block btn-info" type="submit" value="Evenement"></form></td></tr>
                            <tr><td><form action="voirMessage"> <input class="btn btn-block " type="submit" value="Messages"></form></td></tr>
                            <tr><td><form action="voirDiscussion"> <input class="btn btn-block btn-info" type="submit" value="Discussion"></form></td></tr>
                            <tr><td><form action="voirAmis"> <input class="btn btn-block btn-info" type="submit" value="Mes amis"></form></td></tr>
                            <tr><td><form action="affichageCreationEvenement"> <input class="btn btn-block btn-info" type="submit" value="Création Evenement"></form></td></tr>
                            <tr><td><form action="voirListeMembre"> <input class="btn btn-block btn-info" type="submit" value="Membre"></form></td></tr>
                        </table>
                    </div>
                </div>

                <div class="col col-md-10 col-sm-10 col-lg-10" style="overflow: scroll;margin-top:50px;max-height: 600px;height: 600px">
                    <br>
                    <div class="row panelMessage" style="border: 1px black; background-color: #E6E6FA;">
                        <div class="col-md-2">
                            <img alt="photo" src="image/pdp/91.jpg" width="100px" height="100px">	
                        </div>
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4><% out.print(((Membre) request.getSession().getAttribute("login")).getPrenom());%></h4>
                                </div>
                                <div class="col-md-12">
                                    <a href="messagePerso.jsp?idExpediteur=2"><p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zd zd zdz dzd zd zd zdzd zd zd ...</p></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label>Il y a 30 minutes</label><br>
                            <label>Date d'envoye : 01-01-2017</label><br>
                            <label>Sexe : Homme</label><br>
                            <label>Nombre non vu : 0</label><br>
                        </div>
                    </div>

                    <br>
                    <div class="row panelMessage" style="border: 1px black; background-color: #E6E6FA;">
                        <div class="col-md-2">
                            <img alt="photo" src="../assets/image/pdp/91.jpg" width="100px" height="100px">	
                        </div>
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4>Rakotomanana Hery</h4>
                                </div>
                                <div class="col-md-12">
                                    <p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zd zd zdz dzd zd zd zdzd zd zd ...</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label>Il y a 30 minutes</label><br>
                            <label>Date d'envoye : 01-01-2017</label><br>
                            <label>Sexe : Homme</label><br>
                            <label>Nombre non vu : 0</label><br>
                        </div>
                    </div>

                    <br>
                    <div class="row panelMessage" style="border: 1px black; background-color: #E6E6FA;">
                        <div class="col-md-2">
                            <img alt="photo" src="image/pdp/91.jpg" width="100px" height="100px">	
                        </div>
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4>Rasolofo Tojo</h4>
                                </div>
                                <div class="col-md-12">
                                    <p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zd zd zdz dzd zd zd zdzd zd zd ...</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label>Il y a 30 minutes</label><br>
                            <label>Date d'envoye : 01-01-2017</label><br>
                            <label>Sexe : Homme</label><br>
                            <label>Nombre non vu : 0</label><br>
                        </div>
                    </div>

                    <br>
                    <div class="row panelMessage" style="border: 1px black; background-color: #E6E6FA;">
                        <div class="col-md-2">
                            <img alt="photo" src="image/pdp/91.jpg" width="100px" height="100px">	
                        </div>
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4>Rabarison Haja</h4>
                                </div>
                                <div class="col-md-12">
                                    <p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zd zd zdz dzd zd zd zdzd zd zd ...</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label>Il y a 30 minutes</label><br>
                            <label>Date d'envoye : 01-01-2017</label><br>
                            <label>Sexe : Homme</label><br>
                            <label>Nombre non vu : 0</label><br>
                        </div>
                    </div>

                    <br>
                    <div class="row panelMessage" style="border: 1px black; background-color: #E6E6FA;">
                        <div class="col-md-2">
                            <img alt="photo" src="image/pdp/91.jpg" width="100px" height="100px">	
                        </div>
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-12">
                                    <h4>Rakotobe Christinah </h4>
                                </div>
                                <div class="col-md-12">
                                    <a href=""><p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zd zd zdz dzd zd zd zdzd zd zd ...</p></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <label>Il y a 30 minutes</label><br>
                            <label>Date d'envoye : 01-01-2017</label><br>
                            <label>Sexe : Femme</label><br>
                            <label>Nombre non vu : 0</label><br>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" id="footer" style='background-color: #269abc;height: 80px;padding-top: 5px;margin-top:5px' >
            <div class="col-md-12">

            </div>
        </div>


    </body>
</html>