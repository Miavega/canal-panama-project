/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.BuqueVO;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * Esta clase encapsula el acceso a las entidades
 * relacionadas con el Buque en la Base de Datos
 */
public class BuqueDAO {

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
    public BuqueDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Lee una fila específica en la tabla Buque por medio de su PK k_buque.
     *
     * @param k_buque PK
     * @return información de la fila solicitada.
     * @throws RHException dice si no se pudo consultar la información
     */
    public BuqueVO leerBuque(int k_buque) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String consulta = "SELECT * FROM BUQUE WHERE k_buque = " + k_buque + "";
            rs = st.executeQuery(consulta);
            BuqueVO buque = new BuqueVO();
            while (rs.next()) {
                buque.setK_buque((int) rs.getLong("k_buque"));
                buque.setN_buque(rs.getString("n_buque"));
                buque.setV_manga(rs.getFloat("v_manga"));
                buque.setV_loa(rs.getFloat("v_loa"));
                buque.setV_pesomuerto(rs.getFloat("v_pesomuerto"));
                buque.setV_velocidad(rs.getFloat("v_velocidad"));
                buque.setK_categoria(rs.getString("k_categoria"));
                buque.setK_crn(rs.getString("k_crn"));
            }
            rs = st.executeQuery(consulta);
            st.close();
            Conexion.getInstance().commit();
            return buque;
        } catch (SQLException ex) {
            throw new RHException("BuqueDAO", "No pudo cargar el buque: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    /**
     * Lee todos los buques que le pertenecen a un operario por medio de su FK
     * k_crn.
     *
     * @param k_crn FK del operador del buque
     * @return lista de todos los buques del operador
     * @throws RHException dice si no se pudo consultar la información
     */
    public ArrayList leerBuques(long k_crn) throws RHException {
        ArrayList listaBuques = new ArrayList();
        String consulta = "SELECT k_buque FROM Buque b, Operadorbarco O WHERE b.k_crn = o.k_crn AND o.k_crn = " + k_crn + "";
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                listaBuques.add(rs.getInt("k_buque"));
            }
            st.close();
            return listaBuques;
        } catch (SQLException ex) {
            throw new RHException("BuqueDAO", "No pudo leer los buques: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

}
