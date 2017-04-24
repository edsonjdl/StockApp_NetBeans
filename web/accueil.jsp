<%-- 
    Document   : pageAccueil
    Created on : 2017-04-23, 14:22:25
    Author     : 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Page Accuiel</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="Resources/Styles/style_accueil.css" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

        <header class="container containMenu">
            <!--<img src="Resources/Images/stage.jpg" alt="image" width="20" height="20" class="roundTop roundBottom">-->

        </header>

        <div class="container text-left containCenter roundTop" > 
            <div class="row">						
                <div class="col-sm-12 text-left contain" > 
                    <div id="welcome" class="row">
                        <h3>Bienvenue</h3>
                        <h1 class="police">Stock Analysis</h1><br>
                    </div>
                    <div class="col-sm-8 text-left"> 
                        <br><br>

                        <!--<c:if test="${not empty requestScope.errorMessage}" >
                            <div class="alert alert-warning ">
                                <span class="glyphicon glyphicon-alert" aria-hidden="true"></span>
                                <span class="sr-only">Warning:</span>
                                <strong> ${requestScope.errorMessage}</strong> 
                            </div>
                        </c:if>-->

                        <div class="margin">
                            <form name="frmTypeAnalyse" action="" method="post"> 
                                <div class="row">
                                    <table>
                                        <tr>
                                            <td><label class="" >Action </label>
                                                <select class="form-control position" name="user" id="user" >
                                                    <option value="0">Faire un choix ...</option>
                                                    <option value="BBAS3">BBAS3</option>
                                                    <option value="BBSE3">BBSE3</option>
                                                    <option value="BOVA11">BOVA11</option>
                                                    <option value="BRKM5">BRKM5</option>
                                                    <option value="EQTL3">EQTL3</option>
                                                    <option value="FLRY3">FLRY3</option>
                                                    <option value="LREN3">LREN3</option>
                                                    <option value="MGLU3">MGLU3</option>
                                                    <option value="PCAR4">PCAR4</option>
                                                    <option value="PETR4">PETR4</option>
                                                    <option value="RADL3">RADL3</option>
                                                    <option value="SMLE3">SMLE3</option>
                                                    <option value="VALE5">VALE5</option>
                                                    <option value="WEGE3">WEGE3</option>
                                                </select></td>
                                                <td id="stylishTD">
                                                    <a href="">Consulter la liste des actions</a>
                                                </td>
                                        </tr>
                                    </table>  
                                </div>

                                <br><br>
                                <h4>Type d'analyse</h4>
                                <hr class="divider">	
                                <br>
                                <input type="radio" name="typeAnalyse" value="Visualisation de l'historique" checked="checked" /> Visualisation de l'historique </br>
                                <input type="radio" name="typeAnalyse" value="Comparaison de performance d'une liste d'actions" /> Comparaison de performance d'une liste d'actions </br>
                                <input type="radio" name="typeAnalyse" value="Visualisation des opportunités d'investissement" /> Visualisation des opportunités d'investissement </br>
                                </br>
                                <input type="submit" class="btn btn-primary" name="submit" id="submit" value="Continuer"/>	
                                <br><br>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>		

        <footer class="container text-center roundBottom">
            <p>© 2017 Tous droits réservés </p>
            <a href="Debut">Debut</a>
        </footer>

    </body>
</html>
