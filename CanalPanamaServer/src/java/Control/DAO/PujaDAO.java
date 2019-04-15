/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.PujaVO;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class PujaDAO {

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
    public PujaDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public void crearPuja(long k_subasta, long v_puja, long k_identificacion, String k_tipoid) throws RHException {
        String insercion = "INSERT INTO PUJA VALUES (" + k_subasta + ", NULL, SYSTIMESTAMP, " + v_puja + ", 'PCS'," + k_identificacion + ", '" + k_tipoid + "')";
        System.out.println(insercion);
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            st.executeUpdate(insercion);
            System.out.println("Puja insertada");
            st.close();
            Conexion.getInstance().commit();
            System.out.println("creando una nueva puja...");
        } catch (SQLException ex) {
            throw new RHException("PujaDAO", "No pudo insertar la puja " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public ArrayList<PujaVO> leerMisPujas(long k_identificacion, String k_tipoid) throws RHException {
        ArrayList<PujaVO> pujas = new ArrayList<>();
        String consulta = "SELECT K_SUBASTA, K_PUJA, F_PUJA, V_PUJA, N_ESTADOPUJA FROM PUJA\n"
                + "WHERE K_IDENTIFICACION=" + k_identificacion + " \n"
                + "AND K_TIPOID= '" + k_tipoid + "' ";

        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                PujaVO puja = new PujaVO();
                puja.setK_subasta(rs.getLong("k_subasta"));
                puja.setK_puja(rs.getLong("k_puja"));
                puja.setF_puja(rs.getString("f_puja"));
                puja.setV_puja(rs.getLong("v_puja"));
                puja.setN_estadopuja(rs.getString("n_estadopuja"));
                pujas.add(puja);
            }
            st.close();
            System.out.println("cargando pujas de un cliente ...");
            return pujas;
        } catch (SQLException ex) {
            throw new RHException("PujaDAO", "No se pudo leer las pujas del cliente " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public ArrayList<PujaVO> leerPujas() {
        return null;
    }

}
