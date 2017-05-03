/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donneesAffichage;

import webService.DonneesSource;

/**
 *
 * @author edson
 */
public class Reference {
    
    private static String codeAction="";
    private static String optionAnalyse="";
    private static String[] comparables={};
    
    private static String destination="";
    
    private static String[] tables = {"bbas3", "bbse3", "bova11", "brkm5", "eqtl3", "flry3", "lren3", "mglu3", "pcar4", "petr4", "radl3", "smle3", "vale5", "wege3"};
    
    private static DonneesSource donneeSource;

    public static String getCodeAction() {
        return codeAction;
    }

    public static void setCodeAction(String codeAction) {
        Reference.codeAction = codeAction;
    }

    public static String getOptionAnalyse() {
        return optionAnalyse;
    }

    public static void setOptionAnalyse(String optionAnalyse) {
        Reference.optionAnalyse = optionAnalyse;
    }

    public static String[] getComparables() {
        return comparables;
    }

    public static void setComparables(String[] comparables) {
        Reference.comparables = comparables;
    }

    public static String getDestination() {
        return destination;
    }

    public static void setDestination(String destination) {
        Reference.destination = destination;
    }

    public static String[] getTables() {
        return tables;
    }

    public static void setTables(String[] tables) {
        Reference.tables = tables;
    }

    public static DonneesSource getDonneeSource() {
        return donneeSource;
    }

    public static void setDonneeSource(DonneesSource donneeSource) {
        Reference.donneeSource = donneeSource;
    }


    
    
    
}
