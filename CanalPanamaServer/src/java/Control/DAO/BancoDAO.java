/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.ConexionPostgres;
import Util.RHException;
import java.net.UnknownHostException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDAO {

    //Objeto que proporciona un vinculo entre la base de datos y la aplicacion
    private Connection con;
    //Objeto para enviar sentencias SQL a la base de datos
    private Statement st;
    //Objeto que proporciona los metodos necesarios para obtener los datos de una columna correspondiente a una fila de la base de datos
    private ResultSet rs;
    /*
     * Objeto para hacer llamado a las funciones PL/SQL
     */
    private CallableStatement cs;

    /**
     * Metodo para hacer la inserción del pago
     *
     * @param pk_crn
     * @param pv_pagar
     * @return
     * @throws ClassNotFoundException
     * @throws Util.RHException
     */
    public boolean pagarReserva(long pk_crn, long pv_pagar) throws RHException, ClassNotFoundException {
        boolean resultado;
        try {
            con = ConexionPostgres.getConexion();
            cs = con.prepareCall("{? = call FU_PAGAR (?,?)}");
            cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
            cs.setLong(2, pk_crn);
            cs.setLong(3, pv_pagar);
            cs.execute();
            resultado = cs.getBoolean(1);
            return resultado;
        } catch (SQLException ex) {
            throw new RHException("BancoDAO", "No pudo realizar el pago por " + ex.getMessage());
        } finally {
            ConexionPostgres.desconectar();
        }
    }

}

