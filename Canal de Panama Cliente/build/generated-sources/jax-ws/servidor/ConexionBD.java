
package servidor;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "conexionBD", targetNamespace = "http://Servidor/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ConexionBD {


    /**
     * 
     * @param pas
     * @param usu
     * @return
     *     returns boolean
     * @throws RHException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "realizarConexion", targetNamespace = "http://Servidor/", className = "servidor.RealizarConexion")
    @ResponseWrapper(localName = "realizarConexionResponse", targetNamespace = "http://Servidor/", className = "servidor.RealizarConexionResponse")
    @Action(input = "http://Servidor/conexionBD/realizarConexionRequest", output = "http://Servidor/conexionBD/realizarConexionResponse", fault = {
        @FaultAction(className = RHException_Exception.class, value = "http://Servidor/conexionBD/realizarConexion/Fault/RHException")
    })
    public boolean realizarConexion(
        @WebParam(name = "usu", targetNamespace = "")
        String usu,
        @WebParam(name = "pas", targetNamespace = "")
        String pas)
        throws RHException_Exception
    ;

    /**
     * 
     * @throws RHException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "cerrarConexion", targetNamespace = "http://Servidor/", className = "servidor.CerrarConexion")
    @ResponseWrapper(localName = "cerrarConexionResponse", targetNamespace = "http://Servidor/", className = "servidor.CerrarConexionResponse")
    @Action(input = "http://Servidor/conexionBD/cerrarConexionRequest", output = "http://Servidor/conexionBD/cerrarConexionResponse", fault = {
        @FaultAction(className = RHException_Exception.class, value = "http://Servidor/conexionBD/cerrarConexion/Fault/RHException")
    })
    public void cerrarConexion()
        throws RHException_Exception
    ;

}
