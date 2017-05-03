/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import donneesAffichage.Reference;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import org.datacontract.schemas._2004._07.stockanalysis_wcf.ArrayOfCotisation;
import org.datacontract.schemas._2004._07.stockanalysis_wcf.Cotisation;

/**
 *
 * @author 1695625
 */
public class ChargeCotisations {

    private static DonneesSource donneesSource;

    public static DonneesSource getDonneesSource() {
        return donneesSource;
    }

    public static void setDonneesSource(DonneesSource donneesSource) {
        ChargeCotisations.donneesSource = donneesSource;
    }

    public static void start() {

        donneesSource = new DonneesSource();

        List list = getAllCotisations().getCotisation();

        CotisationSource cs = null;
        Date date = new Date();

        for (Object cotisation : list) {

            Cotisation cSharp = (Cotisation) cotisation;

            date = toDate(cSharp.getDateCotisation());
            
            double ouverture = bigDecimal2Double(cSharp.getOuverture());
            double fermeture = bigDecimal2Double(cSharp.getFermeture());
            
            double min = bigDecimal2Double(cSharp.getMinVal());
            double max = bigDecimal2Double(cSharp.getMaxVal());
            double vf = bigDecimal2Double(cSharp.getVolFinance());
            double vqt = bigDecimal2Double(cSharp.getVolQnt());
                      
            cs = new CotisationSource(cSharp.getId(), date, ouverture, fermeture, min, max, vf, vqt, cSharp.getCodeAction());
            donneesSource.add(cs);
        }

        Reference.setDonneeSource(donneesSource);
        
        System.out.println("Afficher les données---------------------------");
        Reference.getDonneeSource().afficherDonnees();

    }

    //        public static void main(String[] args) {
//        List list = getAllActions().getActionStock();
//        Action actStck = null;
//
//        for (Object action : list) {
//            ActionStock act = (ActionStock) action;
//
//            actStck=new Action(act.getCode(),act.getNom().getValue(),act.getQuantite());
//            System.out.println(actStck);
//        }
//    }
//
    private static ArrayOfCotisation getAllCotisations() {
        org.tempuri.StockService service = new org.tempuri.StockService();
        org.tempuri.IStockService port = service.getBasicHttpBindingIStockService();
        return port.getAllCotisations();
    }

    public static Date toDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }

    public static double bigDecimal2Double(BigDecimal bd) {
        double d = bd.doubleValue();

        return d;

    }

}
