/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.TransitoDAO;
import Util.RHException;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Transito")
public class Transito {

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
    @WebMethod(operationName = "insertTransitoR")
    public void insertTransitoR(@WebParam(name = "k_reserva") long k_reserva) throws RHException {
        
        TransitoDAO t = new TransitoDAO();
        t.insertarTransito(k_reserva);
    }
}
