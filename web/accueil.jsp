<%-- 
    Document   : pageAccueil
    Created on : 2017-04-23, 14:22:25
    Author     : Edson Lima
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
                        <h3>Stock Analysis</h3>
                        <h1 class="police">Accueil</h1><br>
                    </div>
                    <div class="col-sm-8 text-left"> 
                        <br><br>

                        <%--<c:if test="${not empty requestScope.errorMessage}" >
                            <div class="alert alert-warning ">
                                <span class="glyphicon glyphicon-alert" aria-hidden="true"></span>
                                <span class="sr-only">Warning:</span>
                                <strong> ${requestScope.errorMessage}</strong> 
                            </div>
                        </c:if>--%>

                        <div class="margin">
                            <form name="frmTypeAnalyse" action="Preparation" method="post" > 
                                <div class="row">
                                    <table>
                                        <tr>
                                            <td><label class="" >Action </label>
                                                <select class="form-control position" name="action" >
                                                    <option value="0">Faire un choix ...</option>
                                                    <option value="bbas3">BBAS3</option>
                                                    <option value="bbse3">BBSE3</option>
                                                    <option value="bova11">BOVA11</option>
                                                    <option value="brkm5">BRKM5</option>
                                                    <option value="eqtl3">EQTL3</option>
                                                    <option value="flry3">FLRY3</option>
                                                    <option value="lren3">LREN3</option>
                                                    <option value="mglu3">MGLU3</option>
                                                    <option value="pcar4">PCAR4</option>
                                                    <option value="petr4">PETR4</option>

                                                </select></td>
                                                <td id="stylishTD">
                                                    <a href="RapportActions">Plus d'informations par rapport les actions disponibles.</a>
                                                </td>
                                        </tr>
                                    </table>  
                                </div>

                                <br><br>
                                <h4>Type d'analyse</h4>
                                <hr class="divider">	
                                <br>
                                <input type="radio" name="typeAnalyse" value="Historique" checked="checked" /> Visualisation de l'historique </br>
                                <input type="radio" name="typeAnalyse" value="Comparaison" /> Comparaison de performance d'une liste d'actions </br>
                                <input type="radio" name="typeAnalyse" value="Opportunites" /> Visualisation des opportunités d'investissement </br>
                                </br>
                                <input type="submit" class="btn btn-primary" name="submit" id="submit" value="Continuer"/>
                                <input type='hidden' name="comparable" value='Non' />
                                <br><br>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>		

        <footer class="container text-center roundBottom">
            <p>© 2017 Tous droits réservés </p>
            <!--<a href="Debut">Debut</a>-->           
        </footer>

    </body>
</html>
