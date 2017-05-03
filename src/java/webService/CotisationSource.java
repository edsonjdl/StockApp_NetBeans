/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import java.util.Date;

/**
 *
 * @author 1695625
 */
public class CotisationSource {
    
    private int id;
    private Date dateCotisation;
    private double ouverture, fermeture, minVal, maxval, volFinance, volQnt;
    private int codeAction;

    public CotisationSource() {
    }

    public CotisationSource(int id, Date dateCotisation, double ouverture, double fermeture, double minVal, double maxval, double volFinance, double volQnt, int codeAction) {
        this.id = id;
        this.dateCotisation = dateCotisation;
        this.ouverture = ouverture;
        this.fermeture = fermeture;
        this.minVal = minVal;
        this.maxval = maxval;
        this.volFinance = volFinance;
        this.volQnt = volQnt;
        this.codeAction = codeAction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCotisation() {
        return dateCotisation;
    }

    public void setDateCotisation(Date dateCotisation) {
        this.dateCotisation = dateCotisation;
    }

    public double getOuverture() {
        return ouverture;
    }

    public void setOuverture(double ouverture) {
        this.ouverture = ouverture;
    }

    public double getFermeture() {
        return fermeture;
    }

    public void setFermeture(double fermeture) {
        this.fermeture = fermeture;
    }

    public double getMinVal() {
        return minVal;
    }

    public void setMinVal(double minVal) {
        this.minVal = minVal;
    }

    public double getMaxval() {
        return maxval;
    }

    public void setMaxval(double maxval) {
        this.maxval = maxval;
    }

    public double getVolFinance() {
        return volFinance;
    }

    public void setVolFinance(double volFinance) {
        this.volFinance = volFinance;
    }

    public double getVolQnt() {
        return volQnt;
    }

    public void setVolQnt(double volQnt) {
        this.volQnt = volQnt;
    }

    public int getCodeAction() {
        return codeAction;
    }

    public void setCodeAction(int codeAction) {
        this.codeAction = codeAction;
    }

    @Override
    public String toString() {
        return "CotisationSource{" + "id=" + id + ", dateCotisation=" + dateCotisation + ", ouverture=" + ouverture + ", fermeture=" + fermeture + ", minVal=" + minVal + ", maxval=" + maxval + ", volFinance=" + volFinance + ", volQnt=" + volQnt + ", codeAction=" + codeAction + '}';
    }
            
    
}
