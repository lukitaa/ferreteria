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

import controllers.StorageException;
import controllers.UsersController;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class EditUserServlet extends HttpServlet {


    void loadEditUserView(HttpServletResponse response, SessionUser session, ShoppingCart shoppingCart, int userId) throws IOException {
        try {
            Users u = UsersController.getUser(userId);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                out.println(new templates.EditUserTemplate(u).printPage("Editar usuarios", session, shoppingCart));
            } finally {
                out.close();
            }
        } catch (StorageException ex) {//TODO: do something
            Logger.getLogger(EditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void loadUserEditedView(HttpServletResponse response, SessionUser session, ShoppingCart shoppingCart, int userId, String newUsername, String newPassword, boolean newAdminPolicy) throws IOException {
        boolean error = false;

        try {
            // Recover user
            Users u = UsersController.getUser(userId);
            // Update user attributes
            UsersController.updateAllUsersAttributes(u, newUsername, newPassword, newAdminPolicy);
        } catch (StorageException ex) {
            error = true;
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println(new templates.UserEditedTemplate(error).printPage("Editar usuarios", session, shoppingCart));
        } finally {
            out.close();
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

        // An admin must be logged in to access this page!
        if (!Common.adminIsLogged(request)) {
            response.sendRedirect("/Ferreteria/login");
            return;
        }

        SessionUser session = Common.getSessionUser(request);
        ShoppingCart shoppingCart = Common.getCart(request);

        // Get the user to edit
        String userIdToEdit = request.getParameter("usuario"),
               userIdEdited = request.getParameter("user-id");

        if (userIdToEdit != null && !userIdToEdit.isEmpty()) {
            loadEditUserView(response, session, shoppingCart, Integer.parseInt(userIdToEdit));
        } else if (userIdEdited != null && !userIdEdited.isEmpty()) {

            String username = request.getParameter("username"),
                   password = request.getParameter("password");
            boolean admin   = (request.getParameter("admin") != null && request.getParameter("admin").equals("on"));

            loadUserEditedView(response, session, shoppingCart, Integer.parseInt(userIdEdited), username, password, admin);
        } else {
            // WTF do the user want to?? Go to ...
            response.sendRedirect("/Ferreteria/usuarios");
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
