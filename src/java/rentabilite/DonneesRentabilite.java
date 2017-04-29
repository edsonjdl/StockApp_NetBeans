/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentabilite;

import java.util.ArrayList;

/**
 *
 * @author edson
 */
public class DonneesRentabilite extends ArrayList<Rentabilite>{

    public DonneesRentabilite() {
    }
    
        public void afficherRentabilite() {
        for (Rentabilite r : this) {
            System.out.println(r);
        }

    }
    
}
