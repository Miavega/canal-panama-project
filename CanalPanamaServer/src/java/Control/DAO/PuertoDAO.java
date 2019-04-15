/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.PuertoVO;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PuertoDAO {

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
    public PuertoDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Lee todas los puertos.
     *
     * @return lista de puertos del canal
     * @throws RHException dice si no se pudo consultar la información
     */
    public ArrayList<PuertoVO> leerPuertos() throws RHException {
        ArrayList listaPuertos = new ArrayList();
        String consulta = "SELECT k_puerto, n_puerto FROM puerto ORDER BY k_puerto ASC";
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);

            while (rs.next()) {
                PuertoVO puerto = new PuertoVO();
                puerto.setK_puerto(rs.getInt("k_puerto"));
                puerto.setN_puerto(rs.getString("n_puerto"));
                listaPuertos.add(puerto);
            }
            st.close();
            System.out.println("cargando puertos del canal...");

        } catch (SQLException ex) {
            throw new RHException("PuertosDAO", "No pudo leer los puertos: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
        return listaPuertos;

    }

    /**
     * Lee un puerto.
     *
     * @param n_puerto
     * @return Información de un puerto del canal
     * @throws RHException dice si no se pudo consultar la información
     */
    public PuertoVO leerPuerto(String n_puerto) throws RHException {
        PuertoVO puerto = new PuertoVO();
        String consulta = "SELECT k_puerto, n_puerto FROM puerto WHERE n_puerto = " + n_puerto + "";
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                puerto.setK_puerto(rs.getInt("k_puerto"));
                puerto.setN_puerto(rs.getString("n_puerto"));
            }
            st.close();
            System.out.println("cargando puerto del canal...");
        } catch (SQLException ex) {
            throw new RHException("PuertosDAO", "No pudo leer el puerto: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
        return puerto;
    }
    
    public PuertoVO leerPuertoPorID(Long k_puerto) throws RHException {
        PuertoVO puerto = new PuertoVO();
        String consulta = "SELECT n_puerto FROM puerto WHERE k_puerto = '" + k_puerto + "'";
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                puerto.setK_puerto(k_puerto);
                puerto.setN_puerto(rs.getString("n_puerto"));
            }
            st.close();
            System.out.println("cargando puerto por ID del canal...");
        } catch (SQLException ex) {
            throw new RHException("PuertosDAO", "No pudo leer el puerto del id asociado: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
        return puerto;
    }
}
