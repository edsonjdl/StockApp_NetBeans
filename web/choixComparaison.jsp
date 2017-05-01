<%-- 
    Document   : choixComparaison
    Created on : Apr 29, 2017, 10:01:42 AM
    Author     : edson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actions pour comparer</title>
    </head>
    <body>
        <h1>Choisir les actions à comparer</h1>

        <p> Choisissez jusqu'à 3 actions:</p>

        <form action="Preparation" >
            
            <table border="1">
                <thead>
                    <tr>
                        <th>Choix 1</th>
                        <th>Choix 2</th>
                        <th>Choix 3</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <select name="choix1" >
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
                <option value="radl3">RADL3</option>
                <option value="smle3">SMLE3</option>
                <option value="vale5">VALE5</option>
                <option value="wege3">WEGE3</option>
            </select>
                        </td>
                        <td>
                                        <select name="choix2" >
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
                <option value="radl3">RADL3</option>
                <option value="smle3">SMLE3</option>
                <option value="vale5">VALE5</option>
                <option value="wege3">WEGE3</option>
            </select>
                        </td>
                        <td>
                                        <select name="choix3" >
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
                <option value="radl3">RADL3</option>
                <option value="smle3">SMLE3</option>
                <option value="vale5">VALE5</option>
                <option value="wege3">WEGE3</option>
            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>

                </tbody>
            </table>

            

            </br>
            </br>
            <input type="submit">
            <input type='hidden' name="comparable" value='Oui' />
            <input type='hidden' name="typeAnalyse" value='Comparaison' />
        </form>
            </br>
            </br>
        <a href="accueil.jsp">Retour</a>
    </body>
</html>
