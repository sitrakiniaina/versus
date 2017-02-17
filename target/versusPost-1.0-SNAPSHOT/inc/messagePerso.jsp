
<!DOCTYPE html>
<%@page import="mapping.Membre"%>
<html>
<head>
	<title>PostVersus</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="../assets/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="../assets/css/index.css" rel='stylesheet' type='text/css' />
	<script src="../assets/js/jquery.min.js"></script>
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
	<div class="row " id="center">
		<div class="col-md-2 nav navbar-fixed-top"  style="border: 1px solid black; margin-top: 50px;">
			<div class="row">
				<div class="col-md-12">
					<h4> <% out.print(((Membre)request.getSession().getAttribute("login")).getPrenom()); %></h4>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<img alt="PDP" src="" width="200px" height="200px">
				</div>
			</div>
			<hr>
			<div class="row">
				<table class="table">
					<tr><td><form action="lienAccueil"> <input class="btn btn-block btn-info" type="submit" value="Accueil"></form></td></tr>
					<tr><td><form action="voirListeEvenement"> <input class="btn btn-block btn-info" type="submit" value="Evenement"></form></td></tr>
					<tr><td><form action="voirMessage"> <input class="btn btn-block" type="submit" value="Messages"></form></td></tr>
					<tr><td><form action="voirDiscussion"> <input class="btn btn-block btn-info" type="submit" value="Discussion"></form></td></tr>
					<tr><td><form action="voirAmis"> <input class="btn btn-block btn-info" type="submit" value="Mes amis"></form></td></tr>
					<tr><td><form action="affichageCreationEvenement"> <input class="btn btn-block btn-info" type="submit" value="Création Evenement"></form></td></tr>
                                        <tr><td><form action="voirListeMembre"> <input class="btn btn-block btn-info" type="submit" value="Membre"></form></td></tr>
				</table>
			</div>
		</div>
		<div class="col-md-10" style="overflow: scroll; margin-left: 250px; margin-top: 20px;">
			<br>
			<div class="row panelMessageMien" style="border: 1px black; background-color: #E6E6FA;">
				<div class="col-md-2">
					<img alt="photo" src="image/pdp/91.jpg" style="margin-top: 5px;" width="50px" height="50px">	
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-12">
							<p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zd zd zdz dzd zd zd zdzd zd zd ...</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<label>Il y a 30 minutes</label><br>
				</div>
			</div>
			
			<br>
			<div class="row panelMessageAutre" style="border: 1px black; background-color: #E0FFFF; width: 90%; margin-left: 10%;">
				<div class="col-md-2">
					<img alt="photo" src="image/pdp/91.jpg" width="90px" height="90px">	
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-12">
							<h4>Jonathan Kevin</h4>
						</div>
						<div class="col-md-12">
							<p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zSD SDF DF SDF SDF SD FSD F SDF  SDF DS F SD F SDF  SF  SDF SD F SDF  SDF DS F  G G GH D FHDFH F DH DFH  DFH FD H FDH F DHF DH DF d zd zdz dzd zd zd zdzd zd zd ...</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<label>Il y a 30 minutes</label><br>
					<label>Date d'envoye : 01-01-2017</label><br>
					<label>Sexe : Homme</label><br>
				</div>
			</div>
			<br>
			
			<br>
			<div class="row panelMessageMien" style="border: 1px black; background-color: #E6E6FA;">
				<div class="col-md-2">
					<img alt="photo" src="image/pdp/91.jpg" style="margin-top: 5px;" width="50px" height="50px">	
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-12">
							<p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zd zd zdz dzd zd zd zdzd zd zd ...</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<label>Il y a 30 minutes</label><br>
				</div>
			</div>
			
			<br>
			<div class="row panelMessageAutre" style="border: 1px black; background-color: #E0FFFF; width: 90%; margin-left: 10%;">
				<div class="col-md-2">
					<img alt="photo" src="image/pdp/91.jpg" width="90px" height="90px">	
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-12">
							<h4>Jonathan Kevin</h4>
						</div>
						<div class="col-md-12">
							<p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zSD SDF DF SDF SDF SD FSD F SDF  SDF DS F SD F SDF  SF  SDF SD F SDF  SDF DS F  G G GH D FHDFH F DH DFH  DFH FD H FDH F DHF DH DF d zd zdz dzd zd zd zdzd zd zd ...</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<label>Il y a 30 minutes</label><br>
					<label>Date d'envoye : 01-01-2017</label><br>
					<label>Sexe : Homme</label><br>
				</div>
			</div>
			<br>
			
			<br>
			<div class="row panelMessageMien" style="border: 1px black; background-color: #E6E6FA;">
				<div class="col-md-2">
					<img alt="photo" src="image/pdp/91.jpg" style="margin-top: 5px;" width="50px" height="50px">	
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-12">
							<p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zd zd zdz dzd zd zd zdzd zd zd ...</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<label>Il y a 30 minutes</label><br>
				</div>
			</div>
			
			<br>
			<div class="row panelMessageAutre" style="border: 1px black; background-color: #E0FFFF; width: 90%; margin-left: 10%;">
				<div class="col-md-2">
					<img alt="photo" src="image/pdp/91.jpg" width="90px" height="90px">	
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-12">
							<h4>Jonathan Kevin</h4>
						</div>
						<div class="col-md-12">
							<p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zSD SDF DF SDF SDF SD FSD F SDF  SDF DS F SD F SDF  SF  SDF SD F SDF  SDF DS F  G G GH D FHDFH F DH DFH  DFH FD H FDH F DHF DH DF d zd zdz dzd zd zd zdzd zd zd ...</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<label>Il y a 30 minutes</label><br>
					<label>Date d'envoye : 01-01-2017</label><br>
					<label>Sexe : Homme</label><br>
				</div>
			</div>
			<br>
			
			<br>
			<div class="row panelMessageMien" style="border: 1px black; background-color: #E6E6FA;">
				<div class="col-md-2">
					<img alt="photo" src="image/pdp/91.jpg" style="margin-top: 5px;" width="50px" height="50px">	
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-12">
							<p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zd zd zdz dzd zd zd zdzd zd zd ...</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<label>Il y a 30 minutes</label><br>
				</div>
			</div>
			
			<br>
			<div class="row panelMessageAutre" style="border: 1px black; background-color: #E0FFFF; width: 90%; margin-left: 10%;">
				<div class="col-md-2">
					<img alt="photo" src="image/pdp/91.jpg" width="90px" height="90px">	
				</div>
				<div class="col-md-7">
					<div class="row">
						<div class="col-md-12">
							<h4>Jonathan Kevin</h4>
						</div>
						<div class="col-md-12">
							<p>Kaiza zandry e! aaaaaaaaaaaaaaaaaaaaa zzzzzzzzzzzzzzzz ddddddddddddddddd ffffff d d dd  d zSD SDF DF SDF SDF SD FSD F SDF  SDF DS F SD F SDF  SF  SDF SD F SDF  SDF DS F  G G GH D FHDFH F DH DFH  DFH FD H FDH F DHF DH DF d zd zdz dzd zd zd zdzd zd zd ...</p>
						</div>
					</div>
				</div>
				
				<div class="col-md-3">
					<label>Il y a 30 minutes</label><br>
					<label>Date d'envoye : 01-01-2017</label><br>
					<label>Sexe : Homme</label><br>
				</div>
			</div>
			<br>
			
			<div class="row" id="texto">
				<div class="col-md-12">
					<form action="" method="POST">
						<textarea name="message" class="form-control"></textarea><br>
						<input type="submit" class="btn btn-info" value="Envoyer">
					</form>
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