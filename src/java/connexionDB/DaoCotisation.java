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
    private double valeurRentabilite=0;
    DecimalFormat formatation = new DecimalFormat("#.##");
    
    private Rentabilite rent;

    private String[] tables = {"bbas3", "bbse3", "bova11", "brkm5", "eqtl3", "flry3", "lren3", "mglu3", "pcar4", "petr4", "radl3", "smle3", "vale5", "wege3"};

    // "bbas3"1, "bbse3"2, "bova11"3, "brkm5"4, "eqtl3"5, "flry3"6, "lren37", "mglu3"8, "pcar4"9, "petr4"10, "radl3"11, "smle3"12, "vale5"13, "wege3"14};
    
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

    public void lireBD(String code, DonneesRentabilite infoRentabilite) throws SQLException, ClassNotFoundException, java.io.IOException {

        try {

            connexion = SetupDB.getConnection("infoconnexion.prp");
            stmt = connexion.createStatement();
            ResultSet rset = stmt.executeQuery(
                    "SELECT "
                    + "`" + code + "`.`data`, `" + code + "`.`abertura`, `" + code + "`.`max`, `" + code + "`.`min`, `" + code + "`.`fechamento`, `" + code + "`.`volFin`, `" + code + "`.`volQte` "//,  job_id "
                    + "FROM `acoes`.`" + code + "` ");

            rent = new Rentabilite();
            
            while (rset.next()) {

                
                Date date = rset.getDate(1);

                if (date.toString().equals("2017-03-27")) {
                    valeur2 = rset.getDouble(5);
                    System.out.println(code + " valeur2: " + valeur2);
                }

                if (date.toString().equals("2016-03-28")) {
                    valeur1 = rset.getDouble(5);
                    System.out.println(code + " valeur1: " + valeur1);
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
            
            
            valeurRentabilite = ((int)(((valeur2/valeur1)-1)*10000))/100.0;
            
            //valeurRentabilite = Double.valueOf(formatation.format(valeurRentabilite));
            
            rent.setCodeAction(code.toUpperCase());
            rent.setValeurRentabilite(valeurRentabilite);
            infoRentabilite.add(rent);

            valeur1 = 0;
            valeur2 = 0;

        }
    }
    
    public void lireBD2(String code, DonneesRentabilite infoRentabilite) {
        
        System.out.println("lireBD2----------InfoRentabilite-----------" + code);
        
        int codeAction = Arrays.asList(tables).indexOf(code)+1;
        
                    rent = new Rentabilite();
                    
                    
            for(CotisationSource cs: Reference.getDonneeSource()){
            if(cs.getCodeAction()==codeAction){
                Date date = cs.getDateCotisation();

                if (date.toString().equals("2017-03-27")) {
                    valeur2 = cs.getFermeture();
                    System.out.println(code + " valeur2: " + valeur2);
                }

                if (date.toString().equals("2016-03-28")) {
                    valeur1 = cs.getFermeture();
                    System.out.println(code + " valeur1: " + valeur1);
                }

                // ATENCAO AS DATAS. O MES COMECA DO 0 (ZERO)=> JANEIRO = 0.
            }

            
            valeurRentabilite = ((int)(((valeur2/valeur1)-1)*10000))/100.0;
            
            //valeurRentabilite = Double.valueOf(formatation.format(valeurRentabilite));
            
            rent.setCodeAction(code.toUpperCase());
            rent.setValeurRentabilite(valeurRentabilite);
            infoRentabilite.add(rent);

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
    
    public void lireBD2(String code, ListeCotisations liste){
        
        System.out.println("lireBD2----------LISTE-----------" + code);
        
        int codeAction = Arrays.asList(tables).indexOf(code)+1;
        
        for(CotisationSource cs: Reference.getDonneeSource()){
            if(cs.getCodeAction()==codeAction){
            cotisation = new Cotisation(cs);
            cotisation.setCodeAction(code);
            liste.ajouterCotisation(cotisation);
            }

        }
        
        
        
        
    }
           

}
