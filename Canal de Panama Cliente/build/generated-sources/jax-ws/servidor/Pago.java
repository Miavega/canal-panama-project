
package servidor;

import java.util.List;
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
@WebService(name = "Pago", targetNamespace = "http://Servidor/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Pago {


    /**
     * 
     * @param kReserva
     * @throws RHException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "generarPDFReserva", targetNamespace = "http://Servidor/", className = "servidor.GenerarPDFReserva")
    @ResponseWrapper(localName = "generarPDFReservaResponse", targetNamespace = "http://Servidor/", className = "servidor.GenerarPDFReservaResponse")
    @Action(input = "http://Servidor/Pago/generarPDFReservaRequest", output = "http://Servidor/Pago/generarPDFReservaResponse", fault = {
        @FaultAction(className = RHException_Exception.class, value = "http://Servidor/Pago/generarPDFReserva/Fault/RHException")
    })
    public void generarPDFReserva(
        @WebParam(name = "k_reserva", targetNamespace = "")
        int kReserva)
        throws RHException_Exception
    ;

    /**
     * 
     * @param kReserva
     * @throws RHException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "pagarOrdenReserva", targetNamespace = "http://Servidor/", className = "servidor.PagarOrdenReserva")
    @ResponseWrapper(localName = "pagarOrdenReservaResponse", targetNamespace = "http://Servidor/", className = "servidor.PagarOrdenReservaResponse")
    @Action(input = "http://Servidor/Pago/pagarOrdenReservaRequest", output = "http://Servidor/Pago/pagarOrdenReservaResponse", fault = {
        @FaultAction(className = RHException_Exception.class, value = "http://Servidor/Pago/pagarOrdenReserva/Fault/RHException")
    })
    public void pagarOrdenReserva(
        @WebParam(name = "k_reserva", targetNamespace = "")
        int kReserva)
        throws RHException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<servidor.PagoVO>
     * @throws RHException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "leerPagosCoord", targetNamespace = "http://Servidor/", className = "servidor.LeerPagosCoord")
    @ResponseWrapper(localName = "leerPagosCoordResponse", targetNamespace = "http://Servidor/", className = "servidor.LeerPagosCoordResponse")
    @Action(input = "http://Servidor/Pago/leerPagosCoordRequest", output = "http://Servidor/Pago/leerPagosCoordResponse", fault = {
        @FaultAction(className = RHException_Exception.class, value = "http://Servidor/Pago/leerPagosCoord/Fault/RHException")
    })
    public List<PagoVO> leerPagosCoord()
        throws RHException_Exception
    ;

    /**
     * 
     * @param kTipoid
     * @param kIdentificacion
     * @return
     *     returns java.util.List<servidor.PagoVO>
     * @throws RHException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "leerPagosCliente", targetNamespace = "http://Servidor/", className = "servidor.LeerPagosCliente")
    @ResponseWrapper(localName = "leerPagosClienteResponse", targetNamespace = "http://Servidor/", className = "servidor.LeerPagosClienteResponse")
    @Action(input = "http://Servidor/Pago/leerPagosClienteRequest", output = "http://Servidor/Pago/leerPagosClienteResponse", fault = {
        @FaultAction(className = RHException_Exception.class, value = "http://Servidor/Pago/leerPagosCliente/Fault/RHException")
    })
    public List<PagoVO> leerPagosCliente(
        @WebParam(name = "k_identificacion", targetNamespace = "")
        long kIdentificacion,
        @WebParam(name = "k_tipoid", targetNamespace = "")
        String kTipoid)
        throws RHException_Exception
    ;

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://Servidor/", className = "servidor.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://Servidor/", className = "servidor.HelloResponse")
    @Action(input = "http://Servidor/Pago/helloRequest", output = "http://Servidor/Pago/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
