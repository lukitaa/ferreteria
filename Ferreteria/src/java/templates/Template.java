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
public abstract class Template {

    static String appRoot = "/Ferreteria" + "/";

    public abstract String printContent();
    public abstract String printContent(boolean error);
    public abstract String printBreadcrumbs();
    public abstract String printNav();
    public abstract String printNav(String date);
    public abstract String printPage(String title);
    public abstract String printPage(String title, boolean error);
    public abstract String printPage(String title, Object data);

    public static String printHeader(String title) {
        return "<!DOCTYPE html> <html lang=\"es\" dir=\"ltr\">     <head>         <meta charset=\"utf-8\">         <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">         <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">                  <title>Ferreter&iacute;a - " + title + "</title>                  <base href=\"" + appRoot + "\" >                  <link href=\"static/css/styles.css\" rel=\"stylesheet\">         <link href=\"static/vendors/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">         <link href=\"static/vendors/bootstrap/css/bootstrap-theme.min.css\" rel=\"stylesheet\">                  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->         <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->         <!--[if lt IE 9]>             <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>             <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>         <![endif]-->     </head>     <body>";
    }

    public static String printFooter() {
        return "<script src=\"static/vendors/jquery/js/jquery.min.js\"></script> <script src=\"static/vendors/bootstrap/js/bootstrap.min.js\"></script> </body> </html>";
    }

    public static String printInitContainer() {
        return "<main role=\"main\" class=\"container\">             <div class=\"col-md-10 col-md-offset-1\">";
    }

    public static String printEndContainer() {
        return "</div></main>";
    }


}
