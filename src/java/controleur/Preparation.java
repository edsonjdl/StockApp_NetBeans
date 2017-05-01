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
        
        String[] choix = {"x", "x", "x"};
        String debut = request.getParameter("comparable");
        System.out.println("comparable: " + debut);
        String dest = "/Debut";
        
            Reference.setComparables(choix);
        System.out.println("comp1: " + Reference.getComparables()[0]);
        System.out.println("comp2: " + Reference.getComparables()[1]);
        System.out.println("comp3: " + Reference.getComparables()[2]);
        
        String analyse = request.getParameter("typeAnalyse");
        Reference.setOptionAnalyse(analyse);
        
       // String codeReference = Reference.getCodeAction();
        String codeReference = request.getParameter("action");
        
        
        if(codeReference!=null){
          Reference.setCodeAction(codeReference);  
        }
        

        if (debut.equals("Non") && analyse.equals("Comparaison")) {
            
//        codeReference = request.getParameter("action");
//        Reference.setCodeAction(codeReference);
        
            dest = "/choixComparaison.jsp";
        } else {
            choix[0] = request.getParameter("choix1");
            choix[1] = request.getParameter("choix2");
            choix[2] = request.getParameter("choix3");
            Reference.setComparables(choix);

        }

        System.out.println("code action: " + Reference.getCodeAction());
        System.out.println("analyse: " + Reference.getOptionAnalyse());

        // Definition de la reference que la servlet Debut ira utiliser
        if (Reference.getOptionAnalyse().equals("Historique")) {
            Reference.setDestination("/StockApp_NetBeans/samples/afficherHistorique.jsp");
        } else if (Reference.getOptionAnalyse().equals("Comparaison")) {
            Reference.setDestination("/StockApp_NetBeans/samples/comparerPerformance.jsp");
        } else {
            Reference.setDestination("/StockApp_NetBeans/samples/definirDeclancheur.jsp");
        }

        System.out.println("Preparation-dest: " + dest);
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
