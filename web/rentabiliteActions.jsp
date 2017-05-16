<%-- 
    Document   : rentabiliteActions
    Created on : Apr 28, 2017, 6:39:29 PM
    Author     : edson
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
                        <h1 class="police">Rentabilité des actions pendant la dernère année</h1><br>
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
                            <form action="Preparation" method="post" > 
                                
                                <div class="row">
                                    
                                            <table border='1'>
            <thead>
                <tr>
                    <td>Action</td>
                    <td>Rentabilité</td>
                </tr>
            </thead>
    <c:forEach var="action" items="${maListe}"  varStatus="loop">
        <tr>
            <td>${action.codeAction}</td>
            <td>${action.valeurRentabilite} %</td>
        </tr>
    
    
    </c:forEach>
        </table>
                                    
                                </div>

                                <br><br>
                                
                            </form>
                            <a href="accueil.jsp">Retour</a>
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