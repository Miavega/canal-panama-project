/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.CargaVO;
import Util.RHException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargaDAO {
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
    public CargaDAO() {
        con = null;
        st = null;
        rs = null;
    }
    
    public void insertarCarga (CargaVO carga) throws RHException{
     try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO CARGA(k_reserva,v_peso,i_lastre,i_unidadmedida,n_tipocarga) VALUES (" + carga.getK_reserva() + " , " + carga.getV_peso() + " ,  " + carga.getI_lastre() + " , '"+ carga.getI_unidadmedida()+ "' ,'"+ carga.getN_tipocarga()+ "' ) ";
            st.executeUpdate(insercion);
            st.close();
            Conexion.getInstance().commit();
             } catch (SQLException ex) {
            throw new RHException("CargaDAO", "No pudo insertar la carga" + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

}
