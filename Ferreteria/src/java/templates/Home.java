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

package templates;

import servlets.SessionUser;

/**
 *
 * @author Lucio Martinez <luciomartinez at openmailbox dot org>
 */
public class Home extends Template {

    /**
     *
     * @param data Home has no use in this parameter
     * @return
     */
    @Override
    public String printContent(Object data) {
        return "<div class=\"jumbotron presentation home\">                     <h1 header>Bienvenido a Ferreter&iacute;a!</h1>                     <p>Desde aqu&iacute; puede acceder a las siguientes opciones: </p>                     <div class=\"container menu\">                         <div class=\"row\">                             <a href=\"#first\" class=\"col-md-3 btn-block btn btn-lg text-uppercase\">usuarios</a>                             <a href=\"#second\" class=\"col-md-3 btn-block btn btn-lg text-uppercase\">historial</a>                             <a href=\"productos\" class=\"col-md-3 btn-block btn btn-lg text-uppercase\">productos</a>                         </div>                     </div>                 </div>";
    }

    @Override
    public String printBreadcrumbs() {
        // Home page doesn't have breadcrumbs!
        return "";
    }

    /**
     *
     * @param data Session user
     * @return
     */
    @Override
    public String printNav(Object data) {
        String username = ((SessionUser)data).getUsername();
        return "<ul class=\"nav navbar-nav\">"
                + "<li class=\"active\"><a href=\"inicio\">Inicio</a></li>"
                + "<li><a href=\"productos\">Productos</a></li>"
                + "</ul>                     <ul class=\"nav navbar-nav navbar-right\">"
                + "<li><a>Hola, " + username + "!</a></li>"
                + "<li><a href=\"logout\">Salir</a></li>                     </ul>";
    }

    @Override
    public String printPage(String title, Object data) {
        return Template.printHeader(title)
                + Template.printInitNav()
                + this.printNav(data)
                + Template.printEndNav()
                + Template.printInitContainer()
                + this.printBreadcrumbs()
                + this.printContent(null)
                + Template.printEndContainer()
                + Template.printFooter();
    }

}
