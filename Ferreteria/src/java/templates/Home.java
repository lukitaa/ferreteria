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

/**
 *
 * @author Lucio Martinez <luciomartinez at openmailbox dot org>
 */
public class Home extends Template {

    @Override
    public String printContent() {
        return "<div class=\"jumbotron presentation\">                     <h1>Bienvenido a Ferreter&iacute;a!</h1>                     <p>Desde aqu&iacute; puede acceder a las siguientes opciones: </p>                     <div class=\"container menu\">                         <div class=\"row\">                             <a href=\"#first\" class=\"col-md-3 btn-block btn btn-lg text-uppercase\">usuarios</a>                             <a href=\"#second\" class=\"col-md-3 btn-block btn btn-lg text-uppercase\">historial</a>                             <a href=\"#third\" class=\"col-md-3 btn-block btn btn-lg text-uppercase\">productos</a>                         </div>                     </div>                 </div>";
    }

    @Override
    public String printContent(boolean error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String printBreadcrumbs() {
        // Home page doesn't have breadcrumbs!
        return "";
    }

    @Override
    public String printNav(String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String printNav() {
        return "<nav class=\"navbar navbar-default\" role=\"navigation\">             <div class=\"container-fluid\">                 <div class=\"navbar-header\">                     <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">                         <span class=\"sr-only\">Activar navegaci&oacute;n</span>                         <span class=\"icon-bar\"></span>                         <span class=\"icon-bar\"></span>                         <span class=\"icon-bar\"></span>                     </button>                     <a class=\"navbar-brand\" href=\"inicio\">Ferreter&iacute;a</a>                 </div>                  <!-- Collect the nav links, forms, and other content for toggling -->                 <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">                     <ul class=\"nav navbar-nav\">                         <li class=\"active\"><a href=\"inicio\">Inicio</a></li>                         <li><a>Some day..</a></li>                     </ul>                     <ul class=\"nav navbar-nav navbar-right\">                         <li><a>Hola, YO!</a></li>                         <li><a href=\"logout\">Salir</a></li>                     </ul>                 </div>             </div>         </nav>";
    }

    @Override
    public String printPage(String title) {
        return Template.printHeader(title)
                + this.printNav()
                + Template.printInitContainer()
                + this.printBreadcrumbs()
                + this.printContent()
                + Template.printEndContainer()
                + Template.printFooter();
    }

    @Override
    public String printPage(String title, boolean error) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String printPage(String title, Object data) {
        String username = (String) data;

        return Template.printHeader(title)
                + this.printNav()
                + Template.printInitContainer()
                + this.printBreadcrumbs()
                + this.printContent()
                + Template.printEndContainer()
                + Template.printFooter();
    }

}
