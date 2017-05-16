/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionDB;

import donneesAffichage.Reference;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import modele.Cotisation;
import modele.ListeCotisations;
import rentabilite.DonneesRentabilite;
import rentabilite.Rentabilite;
import webService.ChargeCotisations;
import webService.CotisationSource;

/**
 *
 * @author edson
 */
public class DaoCotisation {

    private static Connection connexion = null;
    private static Statement stmt = null;

    private Cotisation cotisation;

    private double valeur1 = 0;
    private double valeur2 = 0;
    private double valeurRentabilite = 0;
    DecimalFormat formatation = new DecimalFormat("#.##");

    private Rentabilite rent;

    private String[] tables = {"bbas3", "bbse3", "bova11", "brkm5", "eqtl3", "flry3", "lren3", "mglu3", "pcar4", "petr4", "radl3", "smle3", "vale5", "wege3"};

    public DaoCotisation() {
    }

    public void chargeDonnees(ListeCotisations liste) throws SQLException, ClassNotFoundException, java.io.IOException {

        ChargeCotisations.start();

        for (int i = 0; i < tables.length; i++) {
            lireBD2(tables[i], liste);
        }

    }

    public void chargeRentabilite(DonneesRentabilite infoRentabilite) throws SQLException, ClassNotFoundException, java.io.IOException {

        ChargeCotisations.start();

        for (int i = 0; i < tables.length; i++) {
            lireBD2(tables[i], infoRentabilite);

        }

    }

    
    public void lireBD2(String code, DonneesRentabilite infoRentabilite) {

//      

        int codeAction = Arrays.asList(tables).indexOf(code) + 1;

        rent = new Rentabilite();

        String dateString;

        for (CotisationSource cs : Reference.getDonneeSource()) {
            if (cs.getCodeAction() == codeAction) {
                Date date = cs.getDateCotisation();

                dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);

                if (dateString.equals("2017-03-27")) {
                    valeur2 = cs.getFermeture();
                    System.out.println(code + " valeur2: " + valeur2);
                }

                if (dateString.equals("2016-03-28")) {
                    valeur1 = cs.getFermeture();
                    System.out.println(code + " valeur1: " + valeur1);
                }

                // ATENCAO AS DATAS. O MES COMECA DO 0 (ZERO)=> JANEIRO = 0.
            }

        }
        valeurRentabilite = ((int) (((valeur2 / valeur1) - 1) * 10000)) / 100.0;
        System.out.println(code + " valeurRentabilite: " + valeurRentabilite);

        rent.setCodeAction(code.toUpperCase());
        rent.setValeurRentabilite(valeurRentabilite);
        infoRentabilite.add(rent);
        valeur1 = 0;
        valeur2 = 0;
    }

    
    public void lireBD2(String code, ListeCotisations liste) {

        System.out.println("lireBD2----------LISTE-----------" + code);

        int codeAction = Arrays.asList(tables).indexOf(code) + 1;

        for (CotisationSource cs : Reference.getDonneeSource()) {
            if (cs.getCodeAction() == codeAction) {
                cotisation = new Cotisation(cs);
                cotisation.setCodeAction(code);
                liste.ajouterCotisation(cotisation);
            }

        }

    }


}
