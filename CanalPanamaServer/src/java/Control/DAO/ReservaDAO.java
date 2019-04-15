package Control.DAO;

import Control.Conexion.Conexion;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.VO.ReservaVO;
import java.sql.CallableStatement;
import java.util.ArrayList;

/**
 *
 * Esta clase encapsula el acceso a las entidades
 * relacionadas con la reserva en la Base de Datos
 */
public class ReservaDAO {

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
    public ReservaDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Lee todas las reservas asociadas a un cliente.
     *
     * @param k_crn identificación del cliente
     * @return lista de reservas
     * @throws RHException dice si no se pudo consultar la información
     */
    public ArrayList<ReservaVO> leerReservas(long k_crn) throws RHException {
        ArrayList<ReservaVO> listaReservas = new ArrayList<ReservaVO>();
        String consulta = "SELECT r.k_reserva, r.k_buque, r.n_estadoreserva, r.k_identificacion, r.k_tipoid, r.i_tiporeserva, r.i_dirtransito, r.f_reserva, r.f_transito, r.k_esclusa FROM RESERVA R ,BUQUE B,OPERADORBARCO O WHERE R.K_BUQUE = B.K_BUQUE AND B.K_CRN= O.K_CRN AND O.K_CRN = " + k_crn + " ";
        System.out.println(consulta);
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                ReservaVO reserva = new ReservaVO();
                reserva.setK_reserva(rs.getInt("k_reserva"));
                reserva.setK_buque(rs.getInt("k_buque"));
                reserva.setK_estadoreserva(rs.getString("n_estadoreserva"));
                reserva.setK_identificacion(rs.getInt("k_identificacion"));
                reserva.setK_tipoid(rs.getString("k_tipoid"));
                reserva.setI_tiporeserva(rs.getString("i_tiporeserva"));
                reserva.setI_dirtransito(rs.getString("i_dirtransito"));
                reserva.setF_reserva(String.valueOf(rs.getDate("f_reserva")));
                reserva.setF_transito(String.valueOf(rs.getDate("f_transito")));
                reserva.setK_esclusa(rs.getString("k_esclusa"));
                listaReservas.add(reserva);
            }
            st.close();
            System.out.println("cargando reservas del operador...");
        } catch (SQLException ex) {
            throw new RHException("ReservaDAO", "No se pudo leer las reservas del Operador " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
        return listaReservas;
    }

    public ArrayList<ReservaVO> leerReservasDia(String f_transito) throws RHException {
        ArrayList<ReservaVO> listaReservasDia = new ArrayList<ReservaVO>();
        String consulta = "SELECT r.k_reserva, r.k_buque , r.k_esclusa , r.k_identificacion , r.k_tipoid , B.n_buque, o.n_operador FROM RESERVA R ,BUQUE B,OPERADORBARCO O WHERE R.K_BUQUE = B.K_BUQUE AND B.K_CRN= O.K_CRN AND R.F_TRANSITO= '" + f_transito + "' AND r.n_estadoreserva='ACE' ORDER BY R.K_RESERVA ASC";
        System.out.println("consulta es" + consulta);
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                ReservaVO reserva = new ReservaVO();
                reserva.setK_reserva(rs.getInt("k_reserva"));
                reserva.setK_buque(rs.getInt("k_buque"));
                reserva.setK_esclusa(rs.getString("k_esclusa"));
                reserva.setK_identificacion(rs.getInt("k_identificacion"));
                reserva.setK_tipoid(rs.getString("k_tipoid"));
                reserva.setI_dirtransito(rs.getString("n_buque"));
                reserva.setI_tiporeserva(String.valueOf(rs.getString("n_operador")));
                listaReservasDia.add(reserva);
            }
            st.close();

            System.out.println("cargando reservas  para un dia x de tránsito...");
            return listaReservasDia;
        } catch (SQLException ex) {
            throw new RHException("ReservaDAO", "No se pudo leer las reservas de x día de transito " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }

    }

    /**
     * Incluye una nueva fila en la tabla RESERVA. Para calcular la PK, se hace
     * una consulta en la tabla para saber el último valor tomado para la PK y
     * se incrementa su valor en 1.
     *
     * @param reserva información que se va a insertar
     * @throws RHException dice si no se pudo consultar la información
     */
    public void crearReserva(ReservaVO reserva) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            cs = con.prepareCall("{call PK_RESERVASCP.PR_RESERVA (?,?,?,?,?,?)}");
            System.out.println("Hola datos" + reserva.getK_buque() + reserva.getK_identificacion() + reserva.getK_tipoid() + reserva.getI_tiporeserva() + reserva.getI_dirtransito() + reserva.getF_transito());
            cs.setLong(1, reserva.getK_buque());
            cs.setLong(2, reserva.getK_identificacion());
            cs.setString(3, reserva.getK_tipoid());
            cs.setString(4, reserva.getI_tiporeserva());
            cs.setString(5, reserva.getI_dirtransito());
            cs.setString(6, reserva.getF_transito());
            cs.execute();
        } catch (SQLException ex) {
            throw new RHException("ReservaDAO", "No pudo insertar esa reserva por " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }

    }
}
