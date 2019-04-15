/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.CupoPasoVO;
import Util.RHException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * Esta clase encapsula el acceso a las entidades relacionadas
 * con los cupos en la Base de Datos
 */
public class CupoPasoDAO {

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
    public CupoPasoDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Incluye una nueva fila en la tabla CUPOPASO. Para calcular la PK, se hace
     * una consulta en la tabla para saber el último valor tomado para la PK y
     * se incrementa su valor en 1.
     *
     * @param cupo información que se va a insertar
     * @return si la inserción es exitosa
     * @throws SQLException
     * @throws RHException dice si no se pudo consultar la información
     */
    public boolean crearCupoPaso(CupoPasoVO cupo) throws SQLException, RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String consulta = "SELECT count(k_paso) as cuenta FROM v_cupopaso";
            rs = st.executeQuery(consulta);
            int numero = 0;
            while (rs.next()) {
                numero = Integer.parseInt(rs.getString("cuenta"));
            }
            numero++;
            String insercion = "INSERT INTO CUPOPASO (k_cupopaso, k_paso, q_ctotales, q_cdisponibles, f_asignacioncupos) VALUES ( " + numero + " , '" + cupo.getK_paso() + "' , " + cupo.getQ_ctotales() + " , " + cupo.getQ_ctotales() + ", '" + cupo.getF_asignacioncupos() + "')";
            st.executeUpdate(insercion);
            st.close();
            Conexion.getInstance().commit();
            return true;
        } catch (SQLException ex) {
            throw new RHException("CupoPasoDAO", "No pudo leer los pasos " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    /**
     * Lee las fechas de los periodos para la asignación de cupos. Hace una
     * consulta en la BD a partir de el identificador de esclusas para traer
     * todas las fechas en las que se asignaron cupos a esa esclusa.
     *
     * @param k_paso Es el identificador de la esclusa por la que se realzara el
     * paso
     * @return ArrayList que contiene las fechas de asignación de cupos para una
     * esclusa
     * @throws RHException dice si no se pudo consultar la información
     */
    public ArrayList<CupoPasoVO> leerFechasCupos(String k_paso) throws RHException {
        ArrayList<CupoPasoVO> listaFechas = new ArrayList<>();
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String consulta = "SELECT F_ASIGNACIONCUPOS from V_CUPOPASO where K_PASO='" + k_paso + "' ";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                CupoPasoVO cupoPaso = new CupoPasoVO();
                cupoPaso.setK_paso(k_paso);
                cupoPaso.setF_asignacioncupos(String.valueOf(rs.getDate("f_asignacioncupos")));
                listaFechas.add(cupoPaso);
            }
            st.close();
            

        } catch (SQLException ex) {
            System.out.println("No pudo leer las fechas cupos de esa esclusa" + ex.getMessage());
            throw new RHException("CupoPasoDAO", "No pudo leer las fechas cupos de esa esclusa" + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
        return listaFechas;
    }

    /**
     * Lee los cupos que tienen las fechas de los periodos para la asignación de
     * cupos. Hace una consulta en la BD a partir de el identificador de
     * esclusas y la fecha de asignación para traer la información de los cupos
     * totales y disponibles en esa fecha para esa esclusa.
     *
     * @param k_paso Es el identificador de la esclusa por la que se realzara el
     * paso
     * @param f_asignacion Es la fecha de asignación de cupos para una esclusa
     * @return ArrayList que contiene los cupos totales y disponibles para una
     * esclusa en determinada fecha
     * @throws RHException dice si no se pudo consultar la información
     */
    public ArrayList<CupoPasoVO> leerCupos(String k_paso, String f_asignacion) throws RHException {
        ArrayList<CupoPasoVO> listaCupos = new ArrayList<>();
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String consulta = "SELECT Q_CTOTALES, Q_CDISPONIBLES from V_CUPOPASO where K_PASO='" + k_paso + "' AND F_ASIGNACIONCUPOS = '" + f_asignacion + "' ";
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                CupoPasoVO cupoPaso = new CupoPasoVO();
                cupoPaso.setQ_ctotales(rs.getInt("q_ctotales"));
                cupoPaso.setQ_cdisponibles(rs.getInt("q_cdisponibles"));
                listaCupos.add(cupoPaso);
            }
            st.close();
          } catch (SQLException ex) {
            throw new RHException("CupoPasoDAO", "No pudo leer cupos de esa esclusa" + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
        return listaCupos;
    }

    /**
     * Realiza modificaciones de cupos disponibles y totales para una esclusa en
     * determinada fecha. Hace una actualización de los cupos totales y
     * disponibles que tiene asignada una esclusa para cierta fecha
     *
     * @param k_paso Es el identificador de la esclusa por la que se realzara el
     * paso
     * @param f_asignacion Es la fecha de asignación de cupos para una esclusa
     * @param q_ctotales Es la cantidad de cupos totales nuevos que el operador
     * desea ingresar
     * @param q_cdisponibles Es la cantidad de cupos disponibles nuevos que el
     * operador desea ingresar
     * @throws RHException dice si no se pudo consultar la información
     */
    public void modificarCupos(String k_paso, String f_asignacion, int q_ctotales, int q_cdisponibles) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String actualizacion = "UPDATE CUPOPASO SET Q_CTOTALES= " + q_ctotales + ", Q_CDISPONIBLES= " + q_cdisponibles + " WHERE K_PASO='" + k_paso + "' AND F_ASIGNACIONCUPOS='" + f_asignacion + "'";
            System.out.println("Update" + actualizacion);
            st.executeUpdate(actualizacion);
            st.close();
            Conexion.getInstance().commit();

        } catch (SQLException ex) {
            throw new RHException("CupoPasoDAO", "No se pudo actualizar los cupos pasos " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    /**
     * Lee los cupos que tienen las fechas de los periodos para la asignación de
     * cupos. Hace una consulta en la BD a partir de el identificador de
     * esclusas y la fecha de asignación para traer la información de los cupos
     * totales y disponibles en esa fecha para esa esclusa.
     *
     * @param k_buque Es el identificador del buque
     * @param f_asignacion Es la fecha de asignación de cupos para una esclusa
     * @return ArrayList que contiene los cupos totales y disponibles para una
     * esclusa en determinada fecha
     * @throws RHException dice si no se pudo consultar la información
     */
    public CupoPasoVO verificarCupos(long k_buque, String f_asignacion) throws RHException {
        CupoPasoVO listaCupos = new CupoPasoVO();
        try {
            con = Conexion.getInstance().tomarConexion();
            cs = con.prepareCall("{? = call PK_RESERVASCP.FU_CUPOSFECHA (?,?)}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setLong(2, k_buque);
            cs.setString(3, f_asignacion);
            cs.execute();
            listaCupos.setQ_cdisponibles(cs.getInt(1));
        } catch (SQLException ex) {
            throw new RHException("CupoPasoDAO", "No pudo verificar cupos de esa esclusa " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
        return listaCupos;
    }

}
