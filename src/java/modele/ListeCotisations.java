/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author edson
 */
public class ListeCotisations extends ArrayList<Cotisation> {
    
        ListeCotisations actionChoisie;

    public ListeCotisations() {
    }

    public void ajouterCotisation(Cotisation c) {
        this.add(c);
    }

    public void afficherCotisation() {
        for (Cotisation c : this) {
            System.out.println(c);
        }

    }
    
        public ListeCotisations filtrerAction(String code){
        
        actionChoisie = new ListeCotisations();
        
        for(Cotisation c:this){
            if(c.getCodeAction().equals(code)){
               actionChoisie.add(c);
            }
        }
              
        return actionChoisie;
    }

}
