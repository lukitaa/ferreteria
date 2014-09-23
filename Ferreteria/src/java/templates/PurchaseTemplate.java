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

import entity.Details;
import java.util.HashMap;
import java.util.List;
import servlets.SessionUser;
import servlets.ShoppingCart;

/**
 *
 * @author alumno
 */
public class PurchaseTemplate extends Template {

    List<Details> purchaseDetails;
    int purchaseTotal;
    
    public PurchaseTemplate(List<Details> purchaseDetails, int purchaseTotal){
        this.purchaseDetails = purchaseDetails;
        this.purchaseTotal = purchaseTotal;
    }
    
    private String printAllDetailsInRow(){
        String rows = "";
        
        for (Details d : purchaseDetails) {
            rows += "<tr>"
                + "<td>" + d.getProducts().getProduct() + "</td>" 
                + "<td class=\"price\">" + d.getPrice() + "</td>" 
                + "<td class=\"stock\">" + d.getAmount() + "</td>" 
                + "</tr>";
        }

        return rows;
    }
    
    @Override
    public String printContent(Object data) {
        return "<div class=\"jumbotron presentation products\">                    <h1 class=\"header\">Detalle compra</h1>                    <table class=\"table table-bordered\">                        <thead>                            <tr>                                <th>Producto</th>                                <th>Precio</th>                                <th>Unidades</th>                            </tr>                        </thead>"
                + "<tbody>"
                + printAllDetailsInRow()
                + "</tbody>                    </table>                    <p class=\"lead\">Total: $" + purchaseTotal + "</p>                </div>";
    }

    @Override
    public String printBreadcrumbs() {
        return "<ol class=\"breadcrumb\">"
                + "<li><a href=\"" + APP_ROOT + "\">Home</a></li>"
                + "<li class=\"active\">Compras</li>"
                + "</ol>";
    }

    @Override
    public String printNav(Object data, ShoppingCart shoppingCart) {
        int totalProducts = (shoppingCart != null) ? shoppingCart.getTotalProducts() : 0;
        String username = ((SessionUser)data).getUsername(),
               content  = "";
        
        content += "<ul class=\"nav navbar-nav\">"
                + "<li><a href=\"inicio\">Inicio</a></li>"
                + "<li class=\"active\"><a href=\"productos\">Productos</a></li>"
                + "</ul>                     <ul class=\"nav navbar-nav navbar-right\">";
        
        // DO NOT display the products amount when it is already detailed on this view!
        /*
        if (totalProducts > 0)
            content += "<li><a href=\"productos\">Carrito <span class=\"badge\">" + totalProducts + "</span></a></li>";
        */
        
        content += "<li><a>Hola, " + username + "!</a></li>"
                + "<li><a href=\"logout\">Salir</a></li>                     </ul>";
        
        return content;
    }

    @Override
    public String printPage(String title, Object data, ShoppingCart shoppingCart) {
        return Template.printHeader(title)
                + Template.printInitNav()
                + this.printNav(data, shoppingCart)
                + Template.printEndNav()
                + Template.printInitContainer()
                + this.printBreadcrumbs()
                + this.printContent(null)
                + Template.printEndContainer()
                + Template.printFooter();
    }
    
}
