/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donneesAffichage;

import indicateur.MoyenneMobile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import modele.ListeCotisations;

/**
 *
 * @author edsonjl
 */
public class CreationDonneesMM {

    private static MoyenneMobile mmRapide;
    private static MoyenneMobile mmLente;
    private static ValeurMMjour mmJour;

    public static void genererMM(ListeCotisations listeCotisations, int periodeRapide, int periodeLent, DonneesAffichageMM donneesMM) {
        /*
        On doit limiter la fin de la bascule parce que après listeCotisations.size()-N_PERIODES
        il n'aura plus d'éléments pour calculer les moyennes
        
         */
        for (int i = periodeLent; i < listeCotisations.size(); i++) {

            
            // Calcul moyenneLente rapide
            double sommeFermeturesR = 0;
            for (int j = i; j > i - periodeRapide; j--) {
                sommeFermeturesR += listeCotisations.get(j).getFermeture();
            }
            double moyenneRapide = ((int) ((sommeFermeturesR / periodeRapide) * 100)) / 100.0;

            // Calcul moyenneLente lente
            double sommeFermeturesL = 0;
            for (int k = i; k > i - periodeLent; k--) {
                sommeFermeturesL += listeCotisations.get(k).getFermeture();
            }

            double moyenneLente = ((int) ((sommeFermeturesL / periodeLent) * 100)) / 100.0;

            mmRapide = new MoyenneMobile(moyenneRapide);
            mmLente = new MoyenneMobile(moyenneLente);

            mmJour = new ValeurMMjour(listeCotisations.get(i), mmLente, mmRapide);
            donneesMM.add(mmJour);
        }
    }
}


