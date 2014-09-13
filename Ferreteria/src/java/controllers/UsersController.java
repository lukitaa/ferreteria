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

import dao.UsersDaoImpl;
import entity.Users;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;
import util.HibernateUtil;

/**
 *
 * @author alumno
 */
public class UsersController extends Controller {

    private static Users addUser(String username, String password, boolean admin) throws InvalidParameterException, StorageException {

        if (!validUsername(username))
            throw new InvalidParameterException("El nombre de usuario ingresado es invalido.");

        if (!validPassword(password))
            throw new InvalidParameterException("La contraseña ingresada es invalida.");

        // Encrypt the password before send it to the DAO
        password = BCrypt.hashpw(password, BCrypt.gensalt(12));

        Users u = new Users(username, password, admin);

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            new UsersDaoImpl(session).add(u);

            session.getTransaction().commit();
            session.close();

            return u;

        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }

            throw new StorageException("Error interno al intentar guardar el usuario.");
        }

    }

    public static Users addCommonUser(String username, String password) throws InvalidParameterException, StorageException {
        return addUser(username, password, false);
    }

    public static void addAdminUser(String username, String password) throws InvalidParameterException, StorageException {
        addUser(username, password, true);
    }
    
    public static List<Users> getUsers() throws StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return getAllTheUsers(session);

        } catch (HibernateException e) {
            throw new StorageException("Error al intentar leer los responsables.");
        }

    }


}