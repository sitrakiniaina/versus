
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
<body>
	<div class="row  nav navbar-fixed-top" id="header" style="border: 1px solid black;">
		<div class="col-md-2"><img alt="PostVersus" src=""></div>
		<div class="col-md-7">
			<form class="form-inline" action="" method="GET">
				<div class="row">
					<div class="col-md-4">
					Recherche : 
					<select name="categorieRecherche">
						<option value="personne">Personne</option>
						<option value="evenement">Evénement</option>
						<option value="tous">Tous</option>
					</select>
					</div>
					<div class="col-md-6">
						<input class="form-control" type="text" name="zoneRecherche" style="width: 100%">
					</div>
					<div class="col-md-2">
					<input class="btn btn-info" type="submit" value="Rechercher">
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-3">
			<div class="row">
			<div class="col-md-6" ></div>
			<div class="col-md-6">
				<form class="form-inline" action="" method="GET">
					<input class="btn btn-danger" type="submit" value="Deconnexion">
				</form>
			</div>
				
			</div>
		</div>
	</div>
	<div class="row" id="center">
		<div class="col-md-2 nav navbar-fixed-top"  style="border: 1px solid black; margin-top: 50px;">
			<div class="row">
				<div class="col-md-12">
					<h4> <% out.print(((Membre)request.getSession().getAttribute("login")).getPrenom()); %></h4>
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
					<tr><td><form action="/PostVersus/lienAccueil"> <input class="btn btn-block" type="submit" value="Accueil"></form></td></tr>
					<tr><td><form action="/PostVersus/voirListeEvenement"> <input class="btn btn-block btn-info" type="submit" value="Evenement"></form></td></tr>
					<tr><td><form action="/PostVersus/voirMessage"> <input class="btn btn-block btn-info" type="submit" value="Messages"></form></td></tr>
					<tr><td><form action="/PostVersus/voirDiscussion"> <input class="btn btn-block btn-info" type="submit" value="Discussion"></form></td></tr>
					<tr><td><form action="/PostVersus/voirAmis"> <input class="btn btn-block btn-info" type="submit" value="Mes amis"></form></td></tr>
					<tr><td><form action="/PostVersus/affichageCreationEvenement"> <input class="btn btn-block btn-info" type="submit" value="Création Evenement"></form></td></tr>
				</table>
			</div>
		</div>
		<div class="col-md-10" style="overflow: scroll; margin-left: 250px; margin-top: 20px;">
			
		</div>
	</div>
	<div class="row" id="footer" style='background-color: #269abc;height: 80px;padding-top: 5px;margin-top:5px' >
            <div class="col-md-12">

            </div>
        </div>
	
	
</body>
</html>