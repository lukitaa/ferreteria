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

package templates;

import servlets.SessionUser;

/**
 *
 * @author alumno
 */
public class AddUserTemplate extends Template {
    
    private boolean error;
    
    public AddUserTemplate(boolean error) {
        this.error = error;
    }

    @Override
    public String printContent(Object data) {
        String content = "";
        
        content += "<div class=\"jumbotron\">                    <h1>Agregar Usuario</h1>";
        
        if (!error) {
            content += "<p class=\"lead\">Usuario agregado exitosamente.</p>";
        } else {
            content += "<p class=\"lead\">Usuario no agregado</p>";
        }
                
        content += "</div>";
        
        return content;
    }

    @Override
    public String printBreadcrumbs() {
        return "<ol class=\"breadcrumb\">"
                + "<li><a href=\"" + APP_ROOT + "\">Inicio</a></li>"
                + "<li><a href=\"" + APP_ROOT + "usuarios\">Usuarios</a></li>"
                + "<li class=\"active\">Agregar usuario</li>"
                + "</ol>";
    }

    @Override
    public String printNav(Object data) {
        String username = ((SessionUser)data).getUsername();
        return "<ul class=\"nav navbar-nav\">"
                + "<li><a href=\"inicio\">Inicio</a></li>"
                + "<li><a href=\"productos\">Productos</a></li>"
                + "<li class=\"active\"><a href=\"usuarios\">Usuarios</a></li>"
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