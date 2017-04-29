/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donneesAffichage;

/**
 *
 * @author edson
 */
public class Reference {
    
    private static String codeAction="";
    private static String optionAnalyse="";
    private static String[] comparables={};
    
    private static String destination="";

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
    
    
    
}
