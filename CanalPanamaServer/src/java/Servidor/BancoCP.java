/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.BancoDAO;
import Util.RHException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "BancoCP")
public class BancoCP {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @param pk_crn
     * @param pv_pagar
     */
    @WebMethod(operationName = "pagarReserva")
    public Boolean pagarReserva(@WebParam(name = "pk_crn") long pk_crn, @WebParam(name = "pv_pagar") long pv_pagar) throws RHException, ClassNotFoundException {
        BancoDAO banco = new BancoDAO();
        return banco.pagarReserva(pk_crn, pv_pagar);
    }
}
