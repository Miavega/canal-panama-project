/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.ProgramacionDiariaVO;
import Modelo.VO.ReservaVO;
import Modelo.VO.SubastaVO;
import Util.RHException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SubastaDAO {

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
    public SubastaDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public ArrayList<SubastaVO> buscarSubasta(long k_reserva) throws RHException {
        ArrayList<SubastaVO> subasta = new ArrayList<>();
        String consulta = "SELECT S.K_SUBASTA, S.F_APERTURASUBASTA, S.F_VENCIMIENTOSUBASTA,S.F_CUPOSUBASTA, S.V_INCREMENTOMINIMO, PK_RESERVASCP.FU_VALPUJA(1) as valoractual\n"
                + "FROM RESERVASUBASTA R, SUBASTA S\n"
                + "WHERE R.K_RESERVA = " + k_reserva + " \n"
                + "AND R.K_SUBASTA = S.K_SUBASTA";
        System.out.println(consulta);
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                SubastaVO sub = new SubastaVO();
                sub.setK_subasta(rs.getLong("k_subasta"));
                sub.setF_aperturasubasta(rs.getDate("f_aperturasubasta"));
                sub.setF_vencimientosubasta(rs.getDate("f_vencimientosubasta"));
                sub.setF_cuposubasta(rs.getDate("f_cuposubasta"));
                sub.setV_incrementominimo(rs.getLong("v_incrementominimo"));
                sub.setV_pujainicial(rs.getLong("valoractual"));
                subasta.add(sub);
            }
            st.close();
            return subasta;
        } catch (SQLException ex) {
            throw new RHException("SubastaDAO", "No se pudo leer la Subasta " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public void cerrarSubasta(long k_subasta) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            cs = con.prepareCall("{call PK_RESERVASCP.PR_CERRARSUBASTA (?)}");
            cs.setLong(1, k_subasta);
            cs.execute();
        } catch (SQLException ex) {
            throw new RHException("SubastaDAO", "No pudo cerrar las subasta por " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public SubastaVO buscarSubastaEspecifica(long k_subasta) throws RHException {
        String consulta = "SELECT K_SUBASTA, F_APERTURASUBASTA, F_VENCIMIENTOSUBASTA,F_CUPOSUBASTA, V_INCREMENTOMINIMO , V_PUJAINICIAL\n"
                + "FROM SUBASTA S\n"
                + "WHERE K_SUBASTA = " + k_subasta + " ";
        System.out.println(consulta);
        SubastaVO subasta = new SubastaVO();
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while(rs.next()){
            subasta.setK_subasta(rs.getLong("k_subasta"));
            subasta.setF_aperturasubasta(rs.getDate("f_aperturasubasta"));
            subasta.setF_vencimientosubasta(rs.getDate("f_vencimientosubasta"));
            subasta.setF_cuposubasta(rs.getDate("f_cuposubasta"));
            subasta.setV_pujainicial(rs.getLong("v_pujainicial"));
            subasta.setV_incrementominimo(rs.getLong("v_incrementominimo"));
            }
            st.close();
            return subasta;
        } catch (SQLException ex) {
            throw new RHException("SubastaDAO", "No se pudo leer la subasta seleccionada " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public ArrayList listarSubastas() throws RHException {
        String consulta = "SELECT K_SUBASTA FROM SUBASTA";
        ArrayList<Long> idSubastas = new ArrayList<>();
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                long id = 0L;
                id = rs.getLong("k_subasta");
                idSubastas.add(id);
            }
            st.close();
            return idSubastas;
        } catch (SQLException ex) {
            throw new RHException("SubastaDAO", "No se pudo leer todas las subastas " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }

    }
}
