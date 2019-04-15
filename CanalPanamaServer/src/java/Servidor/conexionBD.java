/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.Conexion.Conexion;
import Util.RHException;
import java.sql.Connection;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "conexionBD")
public class conexionBD {

    /**
     * Web service operation
     *
     * @param usu
     * @param pas
     * @return
     * @throws Util.RHException
     */
    @WebMethod(operationName = "realizarConexion")

    public boolean realizarConexion(@WebParam(name = "usu") String usu, @WebParam(name = "pas") String pas) throws RHException {
        System.out.println("usu: " + usu);
        System.out.println("pas: " + pas);
        boolean resul = false;
        Conexion.setUsuario(usu);
        Conexion.setContrasena(pas);
        try {
            Connection conn = Conexion.getInstance().tomarConexion();
            System.out.println("conn: " + conn);
            System.out.println("resulConn: " + resul);
            return true;
        } catch (Exception ex) {
            System.out.println("conexion: " + ex.getMessage());
            throw new RHException("conexion", "No pudo iniciar sesión: " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    /**
     * Web service operation
     *
     * @throws Util.RHException
     */
    @WebMethod(operationName = "cerrarConexion")
    public void cerrarConexion() throws RHException {
        System.out.println("cerrando conexion...");
        Conexion.getInstance().close();
    }
}
