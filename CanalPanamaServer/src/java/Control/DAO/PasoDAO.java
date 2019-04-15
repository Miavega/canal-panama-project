/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.PasoVO;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * Esta clase encapsula el acceso a las entidades relacionadas
 * con el paso del buque en la Base de Datos
 */
public class PasoDAO {

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
    public PasoDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Lee todas los pasos.
     *
     * @return lista de pasos por el canal
     * @throws RHException dice si no se pudo consultar la información
     */
    public ArrayList<PasoVO> leerPasos() throws RHException {
        ArrayList listaPasos = new ArrayList();
        String consulta = "SELECT k_paso FROM paso";
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                listaPasos.add(rs.getString("k_paso"));
            }
            st.close();
            System.out.println("cargando pasos por el canal...");
            return listaPasos;
        } catch (SQLException ex) {
            throw new RHException("PasosDAO", "No pudo leer los pasos: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }

    }
}
