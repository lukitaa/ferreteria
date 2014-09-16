/*
 * Copyright (C) 2014 Luca Giordano, Lucio Martínez.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class PurchaseServlet extends HttpServlet {

    void udpateProductsUnities(HttpServletRequest request, Map<Integer, Integer> purchaseDetails) {
        Integer productAmount, productId;

        for (Map.Entry<Integer, Integer> entry : purchaseDetails.entrySet()) {
                productId     = entry.getKey();

                // Get the amount of unities for the product from the request parameters
                productAmount = Integer.parseInt(request.getParameter("product-" + productId));

                // Update the value of unities in the map
                purchaseDetails.put(productId, productAmount);
        }
    }

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

        // User must be logged in to access this page!
        if (!Common.userIsLogged(request)) {
            response.sendRedirect("/Ferreteria/login");
            return;
        }

        SessionUser session = Common.getSessionUser(request);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //TODO: get products to buy from POST
            HashMap purchaseDetails = Common.getPurchaseDetails(request);

            udpateProductsUnities(request, purchaseDetails);

            Integer id, cant;

            for (Map.Entry<Integer, Integer> entry : ((Map<Integer, Integer>)purchaseDetails).entrySet()) {
                id   = entry.getKey();
                cant = entry.getValue();

                out.println("Producto de ID:" + id + " cantidad comprada:" + cant + " <br>");
            }


            //out.println(new templates.PurchaseTemplate().printPage("Compra", session));
        } finally {
            out.close();
        }
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
