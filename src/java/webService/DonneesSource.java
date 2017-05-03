/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import java.util.ArrayList;

/**
 *
 * @author 1695625
 */
public class DonneesSource extends ArrayList<CotisationSource>{
    
public void afficherDonnees(){
    for(CotisationSource cs:this){
        System.out.println(cs);
    }
}
    
}
