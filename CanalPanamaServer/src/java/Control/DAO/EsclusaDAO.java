/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * Esta clase encapsula el acceso a las entidades
 * relacionadas con las esclusas en la Base de Datos
 */
public class EsclusaDAO {

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
     * Constructor de la clase
     */
    public EsclusaDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Lee todas las esclusas.
     *
     * @return lista de esclusas
     * @throws RHException dice si no se pudo consultar la información
     */
    public ArrayList leerEsclusas() throws RHException {
        ArrayList listaEsclusas = new ArrayList();
        String consulta = "SELECT k_esclusa FROM esclusa";
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                listaEsclusas.add(rs.getString("k_esclusa"));
            }
            st.close();
            return listaEsclusas;
        } catch (SQLException ex) {
            throw new RHException("EsclusaDAO", "No pudo leer las esclusas: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

}
