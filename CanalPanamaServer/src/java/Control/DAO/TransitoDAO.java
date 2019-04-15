/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Util.RHException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransitoDAO {

    /*
     * Conexión compartida a la Base de Datos
     */
    private Connection con;

    /*
     * Objeto para procesar la secuencia SQL estática
     */
    private Statement st;

    /*
     * Objeto que contiene los resultados de la ejecución de la secuencia SQL
     */
    private ResultSet rs;

    /*
     * Objeto para hacer llamado a las funciones PL/SQL
     */
    private CallableStatement cs;

    /*
     * Constructor de la clase
     */
    public TransitoDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public void insertarTransito(long k_reserva) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            cs = con.prepareCall("{call PK_TRANSITOCP.PR_GENFACTURAPEAJE (?)}");
            cs.setLong(1, k_reserva);
            System.out.println("PREPARANDO generacion transito...");
            cs.execute();
            System.out.println("Insertando un transito...");
        } catch (SQLException ex) {
            throw new RHException("TransitoDAO", "No pudo insertar la transito" + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }

    }

}
