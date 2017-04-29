/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentabilite;

/**
 *
 * @author edson
 */
public class Rentabilite {
    
    private String codeAction;
    private double valeurRentabilite;

    public Rentabilite() {
    }

    public String getCodeAction() {
        return codeAction;
    }

    public void setCodeAction(String codeAction) {
        this.codeAction = codeAction;
    }

    public double getValeurRentabilite() {
        return valeurRentabilite;
    }

    public void setValeurRentabilite(double valeurRentabilite) {
        this.valeurRentabilite = valeurRentabilite;
    }

    @Override
    public String toString() {
        return "Rentabilite{" + "codeAction=" + codeAction + ", valeurRentabilite=" + valeurRentabilite + '}';
    }
    
    
    
}
