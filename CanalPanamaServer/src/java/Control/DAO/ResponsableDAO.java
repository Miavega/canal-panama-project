/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.ResponsableVO;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Esta clase encapsula el acceso a las entidades relacionadas
 * con el responsable del buque en la Base de Datos
 */
public class ResponsableDAO {

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
    public ResponsableDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Lee una fila específica en la tabla RESPONSABLE por medio de su PK k_crn.
     *
     * @param k_crn PK
     * @return información de la fila solicitada.
     * @throws RHException dice si no se pudo consultar la información
     */
    public ResponsableVO leerResponsable(long k_crn) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String consulta = "SELECT k_identificacion FROM Responsable WHERE k_crn = " + k_crn + " ";
            rs = st.executeQuery(consulta);
            ResponsableVO responsable = new ResponsableVO();
            while (rs.next()) {
                responsable.setK_identificacion(rs.getLong("k_identificacion"));
            }
            st.close();
            Conexion.getInstance().commit();
            return responsable;
        } catch (SQLException ex) {
            throw new RHException("ResponsableDAO", "No pudo cargar el Responsable " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }

    }

    /**
     * Lee una fila específica en la tabla RESPONSABLE por medio de su
     * identificación k_identificación.
     *
     * @param k_identificacion PK
     * @return información de la fila solicitada.
     * @throws RHException dice si no se pudo consultar la información
     */
    public ResponsableVO leerTipoid(long k_identificacion) throws RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String consulta = "SELECT k_tipoid FROM Responsable WHERE k_identificacion = " + k_identificacion + " ";
            rs = st.executeQuery(consulta);
            ResponsableVO responsable = new ResponsableVO();
            while (rs.next()) {
                responsable.setK_tipoid(rs.getString("k_tipoid"));
            }
            st.close();
            Conexion.getInstance().commit();
            return responsable;
        } catch (SQLException ex) {
            throw new RHException("ResponsableDAO", "No pudo cargar el responsable " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }

    }

}
