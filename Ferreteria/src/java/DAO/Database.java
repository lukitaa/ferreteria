/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ara
 */
public class Database
{
    private String driver   = "com.mysql.jdbc.Driver";
    private String url      = "jdbc:mysql://";
    private String servidor = "localhost";
    private String username = "root";
    private String password = "";
    private String dbName   = "ferreteria";
    private String port     = "3306";

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;


    public Database()
            throws Exception {

        url = url + servidor + ":" + port + "/" + dbName;
        this.conectar();
    }

    //Attemp to connect
    public final void conectar()
            throws Exception {

        try {
            Class.forName(driver).newInstance();
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver error: " + e.getMessage());
        }

        try {
            conexion = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new Exception("Connection error: " + e.getMessage());
        }
    }

    public int actualizar(PreparedStatement sentencia)
            throws Exception {

        try {
            return sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Update error: " + e.getMessage());
        }
    }

    public PreparedStatement crearSentencia(String sql)
            throws Exception {

        try {
            PreparedStatement s = conexion.prepareStatement(sql);
            return s;
        } catch (SQLException e) {
            throw e;
        }
    }

    public ResultSet consultar(PreparedStatement sentencia)
            throws Exception {

        try {
            ResultSet rows = sentencia.executeQuery();
            return rows;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException e) {
            conexion = null;
        }
    }
}
