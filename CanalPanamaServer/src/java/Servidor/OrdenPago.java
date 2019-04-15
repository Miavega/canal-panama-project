/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.OrdenPagoDAO;
import Modelo.VO.OrdenPagoVO;
import Util.RHException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "OrdenPago")
public class OrdenPago {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "leerEstadoOrdenPago")
    public String leerEstadoOrdenPago(@WebParam(name = "k_concepto") String k_concepto, @WebParam(name = "k_reserva") long k_reserva) throws RHException {
        OrdenPagoDAO orden = new OrdenPagoDAO();
        String estPago = orden.leerEstadoOrdenPago(k_concepto, k_reserva);
        return estPago;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "leerOrdenPago")
    public OrdenPagoVO leerOrdenPago(@WebParam(name = "k_reserva") String k_reserva, @WebParam(name = "k_concepto") String k_concepto) throws RHException {
        OrdenPagoDAO orden = new OrdenPagoDAO();
        OrdenPagoVO miOrden = new OrdenPagoVO();
        miOrden = orden.leerOrdenPago(k_concepto, Long.parseLong(k_reserva));
        return miOrden;
    }
}
