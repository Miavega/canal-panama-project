/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.OperadorVO;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author miguelangel Esta clase encapsula el acceso a las entidades
 * relacionadas con el operador del buque en la Base de Datos
 */
public class OperadorDAO {

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
    public OperadorDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Lee una fila específica en la tabla OPERADORBARCO por medio de su PK
     * k_crn.
     *
     * @param k_crn PK
     * @return información de la fila solicitada.
     * @throws RHException dice si no se pudo consultar la información
     */
    public OperadorVO leerOperador(long k_crn) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String consulta = "SELECT * FROM OPERADORBARCO WHERE k_crn = " + k_crn + "";
            rs = st.executeQuery(consulta);
            OperadorVO operador = new OperadorVO();
            while (rs.next()) {
                operador.setK_crn((int) rs.getLong("k_crn"));
                operador.setK_pais((int) rs.getLong("k_pais"));
                operador.setN_operador(rs.getString("n_operador"));
                operador.setO_tel(rs.getString("o_tel"));
                operador.setO_direccion(rs.getString("o_direccion"));
                operador.setO_email(rs.getString("o_email"));
            }
            st.close();
            Conexion.getInstance().commit();
            return operador;
        } catch (SQLException ex) {
            throw new RHException("OperadorDAO", "No pudo cargar el operador: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    /**
     * Lee una fila específica en la tabla OPERADORBARCO por medio de su usuario
     * n_operador.
     *
     * @param usuario nombre del operador
     * @return información de la fila solicitada.
     * @throws RHException dice si no se pudo consultar la información
     */
    public OperadorVO leerOperadorBuque(String usuario) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String n_operador = usuario.split("_")[1];
            String consulta = "SELECT * FROM OPERADORBARCO WHERE n_operador = '" + n_operador + "'";
            rs = st.executeQuery(consulta);
            OperadorVO operador = new OperadorVO();
            while (rs.next()) {
                operador.setK_crn(rs.getLong("k_crn"));
                operador.setK_pais((int) rs.getLong("k_pais"));
                operador.setN_operador(rs.getString("n_operador"));
                operador.setO_tel(rs.getString("o_tel"));
                operador.setO_direccion(rs.getString("o_direccion"));
                operador.setO_email(rs.getString("o_email"));
            }
            st.close();
            Conexion.getInstance().commit();
            return operador;
        } catch (SQLException ex) {
            throw new RHException("OperadorDAO", "No pudo cargar el operador: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

}
