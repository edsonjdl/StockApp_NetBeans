<%-- 
    Document   : rentabiliteActions
    Created on : Apr 28, 2017, 6:39:29 PM
    Author     : edson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plus d'information</title>
    </head>
    <body>
        <h1>Rentabilité des actions.</h1>
        
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
        
        <a href="accueil.jsp">Retour</a>
    </body>
</html>
