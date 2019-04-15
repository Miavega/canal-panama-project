/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author miguelangel
 */
public class ConexionPostgres {

    //Objeto que proporciona un vinculo entre la base de datos y la aplicacion
    private static Connection cn = null;
    //Driver del servidor de la base de datos
    private static String driver = "org.postgresql.Driver";
    //Direccion de la base de datos
    private static String URLBD = "jdbc:postgresql://localhost:5432/BancoCanalPanama";
    //Usuario de la base de datos
    private static String usuario = "postgres";
    //Contrase�a de la base de datos
    private static String contrasena = "271096";

    //Metodo para obtener la conexion con la base de datos
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        return cn;
    }

    //Metodo para cerrar la conexion con la base de datos
    public static void desconectar() {
        cn = null;
    }

}

