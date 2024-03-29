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

package controllers;

import dao.DetailsDaoImpl;
import dao.ProductsDaoImpl;
import dao.PurchasesDaoImpl;
import entity.Details;
import entity.Products;
import entity.Purchases;
import entity.Users;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import servlets.ShoppingCart;
import util.HibernateUtil;

/**
 *
 * @author Lucio Martinez <luciomartinez at openmailbox dot org>
 */
public class PurchaseController extends IntermediateController {

    public static List<Details> purchaseProducts(ShoppingCart purchaseDetails, Integer userId) throws StorageException, InvalidParameterException {

        // Check if there are any products to buy and store
        if (purchaseDetails.getProductsId().size() <= 0)
            throw new InvalidParameterException("La cantidad de productos a comprar es nula.");

        Integer productAmount, productId;
        List<Details> detailsToStore = new ArrayList();

        // Get the user how made the purchase
        Users user = UsersController.getUser(userId);
        // Generate a new purchase
        Purchases purchase = new Purchases(user);

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            // Store the purchase to have an ID ;)
            new PurchasesDaoImpl(session).add(purchase);

            Products product = null;

            // Add each product into the purchase's details
            for(int i = 0; i < purchaseDetails.getProductsId().size(); i++){
                productId     = purchaseDetails.getProductsId().get(i);
                productAmount = purchaseDetails.getProductsAmount().get(i);

                // Recover product data
                product = new ProductsDaoImpl(session).get(productId);

                // Check if amount to buy is available,
                // otherwise cancel the procedure
                if (productAmount <= 0 || productAmount > product.getStock())
                    throw new HibernateException("Stock not available.");//TODO: throw an invalid parameter exception

                // Add the detail to the list
                detailsToStore.add(new Details(purchase, product, productAmount, product.getPrice()));

                // Update product stock
                product.setStock(product.getStock() - productAmount);
            }

            // Now the details list is complete and gotta be stored
            new DetailsDaoImpl(session).add(detailsToStore);

            session.getTransaction().commit();

        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }

            throw new StorageException("Error interno al intentar guardar la compra.");
        }

        return detailsToStore;
    }

}
