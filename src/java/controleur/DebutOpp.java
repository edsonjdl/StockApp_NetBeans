/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import connexionDB.DaoCotisation;
import donneesAffichage.CreationDonneesMM;
import donneesAffichage.DonneesAffichageMM;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author edson
 */
public class DebutOpp extends HttpServlet {

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

    DonneesAffichageMM donneesAction;

    public static final int PERIODE_RAPIDE = 7;
    public static final int PERIODE_LENT = 21;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



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
        //String code = "vale5";
        
        String code = request.getParameter("action");
        
        
        listePartielle = listeTotale.filtrerAction(code);
        
        

        donneesAction = new DonneesAffichageMM();
        CreationDonneesMM.genererMM(listePartielle, PERIODE_RAPIDE, PERIODE_LENT, donneesAction);

//        String choixPage = request.getParameter("choixPage");

        String dest = "/samples/definirDeclancheur.jsp";
        //String dest = request.getParameter("typeAnalyse");
        
        
        
        HttpSession session = request.getSession();
        session.setAttribute("maListe", donneesAction);
        
        System.out.println("code: " + code);
        System.out.println("dest: " + dest);

        RequestDispatcher disp = getServletContext().getRequestDispatcher(dest);
        disp.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
