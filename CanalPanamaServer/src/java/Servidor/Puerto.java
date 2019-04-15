/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.PuertoDAO;
import Modelo.VO.PuertoVO;
import Util.RHException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "Puerto")
public class Puerto {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "leerPuertos")
    public ArrayList<PuertoVO> leerPuertos() throws RHException {
        PuertoDAO puertos = new PuertoDAO();
        ArrayList<PuertoVO> listaPuertos = puertos.leerPuertos();
        return listaPuertos;
    }

    /**
     * Web service operation
     * @param k_buque
     * @return 
     * @throws Util.RHException
     */
    @WebMethod(operationName = "leerPuertoPorID")
    public PuertoVO leerPuertoPorID(@WebParam(name = "k_buque") Long k_buque) throws RHException {
        PuertoDAO puerto = new PuertoDAO();
        PuertoVO puertoObj = puerto.leerPuertoPorID(k_buque);
        return puertoObj;
    }
}
