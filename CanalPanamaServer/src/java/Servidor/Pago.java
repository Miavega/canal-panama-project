/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.PagoDAO;
import Modelo.VO.PagoVO;
import Util.RHException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Pago")
public class Pago {

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
    @WebMethod(operationName = "leerPagosCoord")
    public ArrayList<PagoVO> leerPagosCoord() throws RHException {
        PagoDAO pago = new PagoDAO();
        ArrayList<PagoVO> pagosCoord = pago.leerPagosCoord();
        return pagosCoord;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "leerPagosCliente")
    public ArrayList<PagoVO> leerPagosCliente(@WebParam(name = "k_identificacion") long k_identificacion, @WebParam(name = "k_tipoid") String k_tipoid) throws RHException {
        PagoDAO pago = new PagoDAO();
        ArrayList<PagoVO> pagosCliente = pago.leerPagosCliente(k_identificacion, k_tipoid);
        return pagosCliente;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "pagarOrdenReserva")
    public void pagarOrdenReserva(@WebParam(name = "k_reserva") int k_reserva) throws RHException {
        PagoDAO miPago = new PagoDAO();
        miPago.insertarPagoReserva(k_reserva);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "generarPDFReserva")
    public void generarPDFReserva(@WebParam(name = "k_reserva") int k_reserva) throws RHException {
        PagoDAO miPago = new PagoDAO();
        miPago.generarFacturaPagoReserva(k_reserva);
    }
}
