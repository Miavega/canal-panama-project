/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.PagoVO;
import Util.RHException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PagoDAO {

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
    public PagoDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public void insertarPago(PagoVO pago, long k_buque) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            cs = con.prepareCall("{call PK_RESERVASCP.PR_ACTUALIZARPAGOSRESERVA (?,?)}");
            cs.setLong(1, k_buque);
            cs.setString(2, pago.getO_cuentaorigen());
            cs.execute();
            Conexion.getInstance().commit();
        } catch (SQLException ex) {
            throw new RHException("PagoDAO", "No pudo actualizarse el pago " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public ArrayList<PagoVO> leerPagosCoord() throws RHException {
        ArrayList<PagoVO> pagosCoord = new ArrayList<PagoVO>();
        String consulta = "SELECT O.K_ORDENDEPAGO, O.K_RESERVA, O.K_CONCEPTO, O.V_ORDENDEPAGO AS VALORTOTAL , O.N_ESTADOPAGO, P.F_PAGO, P.V_PAGO AS VALOR_PAGADO, P.O_CUENTAORIGEN\n"
                + "FROM ORDENDEPAGO O, PAGO P \n"
                + "WHERE O.N_ESTADOPAGO = 'PAG' AND O.K_ORDENDEPAGO = P.K_ORDENDEPAGO";

        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                PagoVO pago = new PagoVO();
                pago.setK_ordendepago(rs.getLong("k_ordendepago"));
                pago.setCampoExtra1(String.valueOf(rs.getLong("k_reserva")));
                pago.setCampoExtra2(rs.getString("k_concepto"));
                pago.setCampoExtra3(String.valueOf(rs.getLong("valortotal")));
                pago.setCampoExtra4(rs.getString("n_estadopago"));
                pago.setF_pago(rs.getDate("f_pago"));
                pago.setV_pago(rs.getLong("valor_pagado"));
                pago.setO_cuentaorigen(rs.getString("o_cuentaorigen"));
                pagosCoord.add(pago);
            }
            st.close();
            System.out.println("cargando pagos (COORDINADOR) ...");
            return pagosCoord;
        } catch (SQLException ex) {
            throw new RHException("PagoDAO", "No se pudo leer los pagos del Coordinador " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public ArrayList<PagoVO> leerPagosCliente(long k_identificacion, String k_tipoid) throws RHException {
        ArrayList<PagoVO> pagosCliente = new ArrayList<PagoVO>();
        String consulta = "SELECT O.K_ORDENDEPAGO, O.K_RESERVA, O.K_CONCEPTO, O.V_ORDENDEPAGO AS VALORTOTAL , O.N_ESTADOPAGO, P.F_PAGO, P.V_PAGO AS VALOR_PAGADO, P.O_CUENTAORIGEN\n"
                + "FROM ORDENDEPAGO O, PAGO P, RESERVA R\n"
                + "WHERE O.K_ORDENDEPAGO = P.K_ORDENDEPAGO\n"
                + "AND R.K_IDENTIFICACION = " + k_identificacion + " \n"
                + "AND R.K_TIPOID = '" + k_tipoid + "' \n"
                + "AND R.K_RESERVA = O.K_RESERVA\n"
                + "AND O.N_ESTADOPAGO = 'PAG'\n"
                + "UNION\n"
                + "SELECT O.K_ORDENDEPAGO, O.K_RESERVA, O.K_CONCEPTO, O.V_ORDENDEPAGO AS VALORTOTAL , O.N_ESTADOPAGO, NULL AS F_PAGO, NULL AS VALOR_PAGADO, NULL AS O_CUENTAORIGEN\n"
                + "FROM ORDENDEPAGO O, RESERVA R\n"
                + "WHERE R.K_IDENTIFICACION = " + k_identificacion + " \n"
                + "AND R.K_TIPOID = '" + k_tipoid + "' \n"
                + "AND R.K_RESERVA = O.K_RESERVA\n"
                + "AND O.N_ESTADOPAGO = 'NPG'";

        System.out.println(consulta);
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                PagoVO pago = new PagoVO();
                pago.setK_ordendepago(rs.getLong("k_ordendepago"));
                pago.setCampoExtra1(String.valueOf(rs.getLong("k_reserva")));
                pago.setCampoExtra2(rs.getString("k_concepto"));
                pago.setCampoExtra3(String.valueOf(rs.getLong("valortotal")));
                pago.setCampoExtra4(rs.getString("n_estadopago"));
                pago.setF_pago(rs.getDate("f_pago"));
                pago.setV_pago(rs.getLong("valor_pagado"));
                pago.setO_cuentaorigen(rs.getString("o_cuentaorigen"));
                pagosCliente.add(pago);
            }
            st.close();
            System.out.println("cargando pagos (CLIENTE) ...");
            return pagosCliente;
        } catch (SQLException ex) {
            throw new RHException("PagoDAO", "No se pudo leer los pagos del cliente " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public void insertarPagoReserva(int k_reserva) throws RHException {
        long cuenta = 1002020280001345L;
        try {
            System.out.println("Me llego la reserva: " + k_reserva + " y cuenta " + cuenta);
            con = Conexion.getInstance().tomarConexion();
            cs = con.prepareCall("{call PK_RESERVASCP.PR_ACTUALIZARPAGOSRESERVA (?,?)}");
            cs.setInt(1, k_reserva);
            cs.setLong(2, cuenta);
            System.out.println("PREPARANDO un pago de reserva...");
            cs.execute();
            System.out.println("Insertando un pago de reserva...");
        } catch (SQLException ex) {
            throw new RHException("CargaDAO", "No pudo insertar la reserva" + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public void generarFacturaPagoReserva(int k_reserva) throws RHException {
        try {
            System.out.println("Me llego la reserva: " + k_reserva);
            con = Conexion.getInstance().tomarConexion();
            cs = con.prepareCall("{call PK_RESERVASCP.PR_GENFACTURA (?)}");
            cs.setInt(1, k_reserva);
            cs.execute();
            System.out.println("Generando PDF de la reserva...");
        } catch (SQLException ex) {
            throw new RHException("CargaDAO", "No pudo generar la factura de la reserva" + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }
}
