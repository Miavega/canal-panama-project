/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.OrdenPagoVO;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OrdenPagoDAO {

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
    public OrdenPagoDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public String leerEstadoOrdenPago(String k_concepto, long k_reserva) throws RHException {
        String estado = "";
        String consulta = "SELECT n_estadopago FROM ORDENDEPAGO WHERE K_RESERVA = " + k_reserva + " and k_concepto = '" + k_concepto + "'";
        System.out.println(consulta);
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                estado = rs.getString("n_estadopago");
            }
        } catch (SQLException ex) {
            throw new RHException("OrdenPagoDAO", "No pudo leer la orden de pago para tal reserva: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
        System.out.println(estado);
        return estado;
    }

    public OrdenPagoVO leerOrdenPago(String k_concepto, long k_reserva) throws RHException {
        String consulta = "SELECT * FROM ORDENDEPAGO WHERE K_RESERVA = " + k_reserva + " AND k_concepto = '" + k_concepto + "'";
        OrdenPagoVO orden = new OrdenPagoVO();
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                orden = new OrdenPagoVO();
                orden.setK_ordendepago(rs.getInt("k_ordendepago"));
                orden.setK_reserva(rs.getInt("k_reserva"));
                orden.setK_concepto(rs.getString("k_concepto"));
                orden.setV_ordendepago(rs.getLong("v_ordendepago"));
                orden.setF_emision(rs.getString("f_emision"));
                orden.setF_maxpago(rs.getString("f_maxpago"));
                orden.setN_estadopago(rs.getString("n_estadopago"));
            }
            st.close();

        } catch (SQLException ex) {
            throw new RHException("OrdenPagoDAO", "No pudo leer la orden de pago para tal reserva: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
        return orden;
    }
}
