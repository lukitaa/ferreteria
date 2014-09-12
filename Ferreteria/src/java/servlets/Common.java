/*
 * Copyright (C) 2014 Lucio Martinez <luciomartinez at openmailbox dot org>
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucio Martinez <luciomartinez at openmailbox dot org>
 */
public class Common {

    public static boolean userIsLogged(HttpServletRequest request) {
        // Get the session if any but do not generate it otherwise
        HttpSession session = request.getSession(false);
        // Check for user already logged in
        return (session != null && session.getAttribute("user") != null);
    }
    
    public static HttpSession generateSession(HttpServletRequest request) {
        HttpSession session = null;

        // Generate new session
        session = request.getSession(true);
        
        session.setAttribute("user", "pepe");

        return session;
    }

}
