
package controllers;

import DAO.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    private Database basedatos;
    //Boolean para comprobar la existencia del usuario
    private boolean exists = false;
    
    public LoginController() throws Exception {
        basedatos = new Database();
    }
    
    
    public boolean userExists(String username, String password) throws Exception {
        //Corroborar si los datos ingresados existen.
        try {
            consultUser(username, password); 
        } catch (Exception e){
            System.out.println(e.getMessage());}
        return getExists();
    }

    public void consultUser(String username, String password){
        //Intentar la consulta a la base de datos con el usuario y contraseña ingresados
        try {
            //Crear la sentencia SQL
            String sql = "SELECT * FROM users WHERE Username=? AND Password=?";
            PreparedStatement s = getBasedatos().crearSentencia(sql);
            s.setString(1, username);
            s.setString(2, password);
            //Corroborar los resultados, si existe el usuario ( hay resultado ) se setea exists a true
            ResultSet rows = getBasedatos().consultar(s);
            if (rows.next()) 
                setExists(true);
        } catch (Exception e){
            e.getMessage();
        }
    }
    
    //Get - set database
    public Database getBasedatos() {
        return basedatos;
    }
    public void setBasedatos(Database basedatos) {
        this.basedatos = basedatos;
    }
    public boolean getExists() {
        return exists;
    }
    public void setExists(boolean exists) {
        this.exists = exists;
    }    
}
