/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import modele.Cotisation;
import modele.ListeCotisations;
import rentabilite.DonneesRentabilite;
import rentabilite.Rentabilite;

/**
 *
 * @author edson
 */
public class DaoCotisation {

    private static Connection connexion = null;
    private static Statement stmt = null;

    private Cotisation cotisation;

    double valeur1 = 0;
    double valeur2 = 0;
    Rentabilite rent;

    private String[] tables = {"bbas3", "bbse3", "bova11", "brkm5", "eqtl3", "flry3", "lren3", "mglu3", "pcar4", "petr4", "radl3", "smle3", "vale5", "wege3"};

    public DaoCotisation() {
    }

    public void chargeDonnees(ListeCotisations liste) throws SQLException, ClassNotFoundException, java.io.IOException {

        for (int i = 0; i < tables.length; i++) {
            lireBD(tables[i], liste);
        }
    }

    public void chargeRentabilite(DonneesRentabilite infoRentabilite) throws SQLException, ClassNotFoundException, java.io.IOException {

        rent = new Rentabilite();
        
        for (int i = 0; i < tables.length; i++) {
            lireBD(tables[i], infoRentabilite);
            rent.setCodeAction(tables[i]);
            rent.setValeurRentabilite((valeur2 / valeur1) - 1);
            
            infoRentabilite.add(rent);
        }
        
        
        
    }

    public void lireBD(String code, DonneesRentabilite infoRentabilite) throws SQLException, ClassNotFoundException, java.io.IOException {

        try {

            connexion = SetupDB.getConnection("infoconnexion.prp");
            stmt = connexion.createStatement();
            ResultSet rset = stmt.executeQuery(
                    "SELECT "
                    + "`" + code + "`.`data`, `" + code + "`.`abertura`, `" + code + "`.`max`, `" + code + "`.`min`, `" + code + "`.`fechamento`, `" + code + "`.`volFin`, `" + code + "`.`volQte` "//,  job_id "
                    + "FROM `acoes`.`" + code + "` ");

            while (rset.next()) {

                
                Date date = rset.getDate(1);

                if (date.toString().equals("2017-03-27")) {
                    valeur2 = rset.getDouble(5);
                }

                if (date.toString().equals("2016-03-28")) {
                    valeur1 = rset.getDouble(5);
                }

                // ATENCAO AS DATAS. O MES COMECA DO 0 (ZERO)=> JANEIRO = 0.
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connexion != null) {
                connexion.close();
            }

            valeur1 = 0;
            valeur2 = 0;

        }
    }

    public void lireBD(String code, ListeCotisations liste) throws SQLException, ClassNotFoundException, java.io.IOException {

        try {

            connexion = SetupDB.getConnection("infoconnexion.prp");
            stmt = connexion.createStatement();
            ResultSet rset = stmt.executeQuery(
                    "SELECT "
                    + "`" + code + "`.`data`, `" + code + "`.`abertura`, `" + code + "`.`max`, `" + code + "`.`min`, `" + code + "`.`fechamento`, `" + code + "`.`volFin`, `" + code + "`.`volQte` "//,  job_id "
                    + "FROM `acoes`.`" + code + "` ");

            while (rset.next()) {

                cotisation = new Cotisation();

                cotisation.setCodeAction(code);// Adaptation à la base de données

                Date date = rset.getDate(1);
//                Calendar cal = new GregorianCalendar();
//                cal.setTime(date);

                cotisation.setDate(date);

//                System.out.println(date.toString());
                cotisation.setOuverture(rset.getDouble(2));
                cotisation.setMax(rset.getDouble(3));
                cotisation.setMin(rset.getDouble(4));
                cotisation.setFermeture(rset.getDouble(5));
                cotisation.setVolFin(rset.getDouble(6));
                //cotisation.setVolQte(rset.getDouble(7));

                // ATENCAO AS DATAS. O MES COMECA DO 0 (ZERO)=> JANEIRO = 0.
                liste.ajouterCotisation(cotisation);

            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connexion != null) {
                connexion.close();
            }

        }
    }

}
