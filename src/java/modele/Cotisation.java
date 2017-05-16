/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Calendar;
import java.util.Date;
import webService.CotisationSource;

/**
 *
 * @author edson
 */
public class Cotisation {

    private String codeAction;
    private Date date;
    private double ouverture, max, min, fermeture, volFin, rentabilite;

    public Cotisation() {
    }

    public Cotisation(Date date, double abertura, double max, double min, double fechamento, double volFin, double volQte) {

        this.ouverture = abertura;
        this.fermeture = fechamento;
        this.max = max;
        this.min = min;
        this.volFin = volFin;

    }

    public Cotisation(double ouverture, double max, double min, double fermeture, double volFin) {
        this.ouverture = ouverture;
        this.max = max;
        this.min = min;
        this.fermeture = fermeture;
        this.volFin = volFin;

    }

    public Cotisation(CotisationSource source) {
        this.date = source.getDateCotisation();
        this.ouverture = source.getOuverture();
        this.fermeture = source.getFermeture();
        this.max = source.getMaxval();
        this.min = source.getMinVal();
        this.volFin = source.getVolFinance();
        this.codeAction = "Non défini";
    }

    public String getCodeAction() {
        return codeAction;
    }

    public void setCodeAction(String codeAction) {
        this.codeAction = codeAction;
    }

    public double getRentabilite() {
        return rentabilite;
    }

    public void setRentabilite(double rentabilite) {
        this.rentabilite = rentabilite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getVolFin() {
        return volFin;
    }

    public void setVolFin(double volFin) {
        this.volFin = volFin;
    }

    @Override
    public String toString() {
        return "Acao{" + "codeAction=" + codeAction + ") , abertura=" + ouverture + ", fechamento=" + fermeture + ", max=" + max + ", min=" + min + ", volFin=" + volFin + '}';
    }

}
