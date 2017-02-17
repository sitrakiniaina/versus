
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>PostVersus</title>

        <link href="assets/css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="assets/css/index.css" rel='stylesheet' type='text/css' />
        <script src="assets/js/jquery.min.js"></script>
    </head>
    <body>
        <div class="row" id="header">
            <div class="col-md-12" style='background-color: #269abc;height: 45px;padding-top: 5px'></div>
        </div>
        <div class="row" id="center">
            <div class="col-md-6"></div>
            <div class="col-md-6">
                <h3>Connexion</h3>
                <form class="form-group" action="login" method="POST">
                    <div class="row">
                        <div class="col-md-3">Mail :</div>
                        <div class="col-md-9"><input class="form-control" type="text" name="mail" value="jonathan@gmail.com"></div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3">Mot de passe :</div>
                        <div class="col-md-9"> <input class="form-control" type="password" name="mdp" value="jonathan"></div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-9"> <input class="btn btn-success" type="submit" value="Connexion"></div>
                    </div>
                </form>
                <h3>Inscription</h3>
                <form class="form-group" action="i.inscription" method="POST">
                    <div class="row">
                        <div class="col-md-3">Nom :</div>
                        <div class="col-md-9"><input class="form-control" type="text" name="nom"></div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3">Prenom : </div>
                        <div class="col-md-9"><input class="form-control" type="text" name="prenom"></div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3">Date de naissance : </div>
                        <div class="col-md-9"><input class="form-control" type="date" name="dateNaissance"></div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3">Sexe : </div>
                        <div class="col-md-9"><label><input type="radio" name="sexe" value="H"> Homme</label>
                            <label><input  type="radio" name="sexe" value="F"> Femme</label>
                        </div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3">Mail :</div>
                        <div class="col-md-9"><input class="form-control" type="text" name="mail"></div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3">Mot de passe :</div>
                        <div class="col-md-9"> <input class="form-control" type="password" name="mdp1"></div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3">Confirmation :</div>
                        <div class="col-md-9"> <input class="form-control" type="password" name="mdp2"></div>
                    </div><br>
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-9"> <input class="btn btn-info" type="submit" value="Inscription"></div>
                    </div>

                </form>
            </div>
        </div>
        <div class="row" id="footer" style='background-color: #269abc;height: 45px;padding-top: 5px;margin-top:5px' >
            <div class="col-md-12">

            </div>
        </div>	
    </body>
</html>