/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import connexionDB.DaoCotisation;
import donneesAffichage.CreationDonneesMM;
import donneesAffichage.DonneesAffichageMM;
import donneesAffichage.Reference;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Cotisation;
import modele.ListeCotisations;

/**
 *
 * @author 1695625
 */
public class Debut extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Cotisation c;
    ListeCotisations listeTotale;
    ListeCotisations listePartielle;

    ListeCotisations comparateur1;
    ListeCotisations comparateur2;
    ListeCotisations comparateur3;

    DonneesAffichageMM donneesAction;
    DonneesAffichageMM donneesComp1;
    DonneesAffichageMM donneesComp2;
    DonneesAffichageMM donneesComp3;

    public static final int PERIODE_RAPIDE = 7;
    public static final int PERIODE_LENT = 21;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Servlet Debut");
        String codeReference = Reference.getCodeAction();
        
        
        
        // 1 - Creation des objets Cotisation et une liste de cotisation
        c = new Cotisation();
        listeTotale = new ListeCotisations();

        // 2 - Charger la liste de cotisations dans la liste
        DaoCotisation daoCotisation = new DaoCotisation();

        try {
            daoCotisation.chargeDonnees(listeTotale);
        } catch (SQLException ex) {
            Logger.getLogger(Debut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Debut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Debut.class.getName()).log(Level.SEVERE, null, ex);
        }

//        listeTotale.afficherCotisation();
//        listePartielle = new ListeCotisations();
        //String codeReference = "vale5";
//        String codeReference = request.getParameter("action");

//        String choixPage = request.getParameter("choixPage");
        String dest = "/samples/Menu.html";

//        String dest = Reference.getDestination();
        HttpSession session = request.getSession();
        
        listePartielle = listeTotale.filtrerAction(Reference.getCodeAction());
        donneesAction = new DonneesAffichageMM();
        CreationDonneesMM.genererMM(listePartielle, PERIODE_RAPIDE, PERIODE_LENT, donneesAction);
        session.setAttribute("maListe", donneesAction);

        if (Reference.getOptionAnalyse().equals("Comparaison")) {
            comparateur1 = listeTotale.filtrerAction(Reference.getComparables()[0]);
            donneesComp1 = new DonneesAffichageMM();
            CreationDonneesMM.genererMM(comparateur1, PERIODE_RAPIDE, PERIODE_LENT, donneesComp1);

            comparateur2 = listeTotale.filtrerAction(Reference.getComparables()[1]);
            donneesComp2 = new DonneesAffichageMM();
            CreationDonneesMM.genererMM(comparateur2, PERIODE_RAPIDE, PERIODE_LENT, donneesComp2);

            comparateur3 = listeTotale.filtrerAction(Reference.getComparables()[2]);
            donneesComp3 = new DonneesAffichageMM();
            CreationDonneesMM.genererMM(comparateur3, PERIODE_RAPIDE, PERIODE_LENT, donneesComp3);
            
            session.setAttribute("comp1", donneesComp1);
            session.setAttribute("comp2", donneesComp2);
            session.setAttribute("comp3", donneesComp3);
            
        }
        
        
        
        donneesAction.afficherDonneesMM();

        System.out.println("code: " + codeReference);
        System.out.println("comp1: " + Reference.getComparables()[0]);
        System.out.println("comp2: " + Reference.getComparables()[1]);
        System.out.println("comp3: " + Reference.getComparables()[2]);
        System.out.println("dest: " + dest);

        RequestDispatcher disp = getServletContext().getRequestDispatcher(dest);
        disp.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the codeReference.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
