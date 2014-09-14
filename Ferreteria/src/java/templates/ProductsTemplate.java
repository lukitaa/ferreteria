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

import entity.Products;
import java.util.List;
import servlets.SessionUser;

/**
 *
 * @author Lucio Martinez <luciomartinez at openmailbox dot org>
 */
public class ProductsTemplate extends Template {

    private List<Products> products;

    public ProductsTemplate(List<Products> products) {
        this.products = products;
    }

    private String printProducstInRows() {
        String rows = "";

        for (Products p : products) {
            rows += "<tr>"
                + "<td>" + p.getProduct() + "</td>" // PRODUCT NAME
                + "<td class=\"price\">" + p.getPrice() + "</td>" // PRODUCT PRICE
                + "<td class=\"stock\">" + p.getStock() + "</td>" // PRODUCT STOCK
                + "<td><input type=\"number\" name=\"product-" + p.getIdProduct() + "\" min=\"0\" max=\"" + p.getStock() + "\" value=\"0\"></td>"
                + "</tr>";
        }

        return rows;
    }

    @Override
    public String printContent(Object data) {
        String content = "";

        content += "<div class=\"jumbotron presentation products\">                     <h1 class=\"header\">Comprar productos</h1>                     <form class=\"products\" action=\"javascript:console.log(0)\">                         <table class=\"table table-bordered\">                             <thead>                                 <tr>                                     <th>Producto</th>                                     <th>Precio</th>                                     <th>Unidades</th>                                     <th>Agregar</th>                                 </tr>                             </thead>"
                + "<tbody>"
                + printProducstInRows()
                + "</tbody>                         </table>                         <button type=\"submit\" class=\"btn btn-primary\">Comprar</button>                     </form>                 </div>";

        return content;
    }

    @Override
    public String printBreadcrumbs() {
        return "<ol class=\"breadcrumb\">"
                + "<li><a href=\"" + APP_ROOT + "\">Home</a></li>"
                + "<li class=\"active\">Compras</li>"
                + "</ol>";
    }

    @Override
    public String printNav(Object data) {
        String username = ((SessionUser)data).getUsername();
        return "<ul class=\"nav navbar-nav\">"
                + "<li><a href=\"inicio\">Inicio</a></li>"
                + "<li class=\"active\"><a href=\"productos\">Productos</a></li>"
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
