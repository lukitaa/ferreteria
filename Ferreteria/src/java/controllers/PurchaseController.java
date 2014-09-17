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
import dao.UsersDaoImpl;
import entity.Details;
import entity.Products;
import entity.Purchases;
import entity.Users;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Lucio Martinez <luciomartinez at openmailbox dot org>
 */
public class PurchaseController extends IntermediateController {
    
    public static Products getProduct(Integer productId, Session session) throws StorageException {
        try {
            session.beginTransaction();

            Products p = new ProductsDaoImpl(session).get(productId);

            session.getTransaction().commit();

            return p;

        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }

            throw new StorageException("Error al intentar cargar el producto.");
        }
    }
    
    public static Purchases storePurchase(Purchases purchase, Session session) throws StorageException {
        try {
            session.beginTransaction();

            new PurchasesDaoImpl(session).add(purchase);

            session.getTransaction().commit();

            return purchase;

        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }

            throw new StorageException("Error interno al intentar guardar la compra.");
        }
    }
    
    public static List<Details> storeDetail(List<Details> details, Session session) throws StorageException {
        try {
            session.beginTransaction();

            new DetailsDaoImpl(session).add(details);

            session.getTransaction().commit();

            return details;

        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }

            throw new StorageException("Error interno al intentar guardar el detalle de compra.");
        }
    }
    
    public static Users getUser(Integer userId, Session session) throws StorageException {
        try {
            session.beginTransaction();

            Users u = new UsersDaoImpl(session).get(userId);

            session.getTransaction().commit();

            return u;

        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }

            throw new StorageException("Error al intentar cargar el usuario.");
        }
    }
    
    public static List<Details> purchaseProducts(Map<Integer, Integer> purchaseDetails, Integer userId) throws StorageException {
        Integer productAmount, productId;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        // Generate Purchase
        Purchases purchase = new Purchases(getUser(userId, session));
        // Store the purchase to have an ID ;)
        storePurchase(purchase, session);
                
                
        List<Details> detailsToStore = new ArrayList();
        Products product = null;

        for (Map.Entry<Integer, Integer> entry : purchaseDetails.entrySet()) {
            productId     = entry.getKey();
            productAmount = entry.getValue();
            
            try {
                product = getProduct(productId, session);
                
                detailsToStore.add(new Details(purchase, product, productAmount, product.getPrice()));
            } catch (StorageException ex) {
                throw ex;
            }
        }
        
        return storeDetail(detailsToStore, session);
    }

}
