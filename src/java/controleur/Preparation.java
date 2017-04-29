/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import donneesAffichage.Reference;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edson
 */
public class Preparation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        System.out.println("Servlet Preparation");
        
        String[] choix = {"", "", ""};
        String debut = request.getParameter("comparable");
        System.out.println("comparable: " + debut);
        String dest = "/Debut";
        
        String analyse = request.getParameter("typeAnalyse");
        Reference.setOptionAnalyse(analyse);
        
        String codeReference = request.getParameter("action");
        Reference.setCodeAction(codeReference);
        

        if (debut.equals("Non") && analyse.equals("Comparaison")) {
            
            dest = "/choixComparaison.jsp";
        } else {
            choix[0] = request.getParameter("choix1");
            choix[1] = request.getParameter("choix2");
            choix[2] = request.getParameter("choix3");
            Reference.setComparables(choix);
//
//            System.out.println("choix1: " + choix[0]);
//            System.out.println("choix2: " + choix[1]);
//            System.out.println("choix3: " + choix[2]);
        }

        System.out.println("code action: " + Reference.getCodeAction());
        System.out.println("analyse: " + Reference.getOptionAnalyse());

        if (Reference.getOptionAnalyse().equals("Historique")) {
            Reference.setDestination("/samples/afficherHistorique.jsp");
        } else if (Reference.getOptionAnalyse().equals("Comparaison")) {
            Reference.setDestination("/samples/comparerPerformance.jsp");
        } else {
            Reference.setDestination("/samples/definirDeclancheur.jsp");
        }

        //returns an array of all submitted values.
        //HttpSession session = request.getSession();
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
