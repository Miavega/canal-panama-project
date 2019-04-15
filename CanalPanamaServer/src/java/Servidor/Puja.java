/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.PujaDAO;
import Modelo.VO.PujaVO;
import Util.RHException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "Puja")
public class Puja {

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
    @WebMethod(operationName = "crearPuja")
    public void crearPuja(@WebParam(name = "k_subasta") long k_subasta, @WebParam(name = "v_puja") long v_puja, @WebParam(name = "k_identificacion") long k_identificacion, @WebParam(name = "k_tipoid") String k_tipoid) throws RHException {
        PujaDAO puja = new PujaDAO();
        puja.crearPuja(k_subasta, v_puja, k_identificacion, k_tipoid);
    }

    /**
     * Web service operation
     *
     * @param k_identificacion
     * @param k_tipoid
     * @return
     */
    @WebMethod(operationName = "leerMisPujas")
    public ArrayList<PujaVO> leerMisPujas(@WebParam(name = "k_identificacion") long k_identificacion, @WebParam(name = "k_tipoid") String k_tipoid) throws RHException {
        ArrayList<PujaVO> misPujas = new ArrayList<>();
        PujaDAO puja = new PujaDAO();
        misPujas = puja.leerMisPujas(k_identificacion, k_tipoid);
        return misPujas;
    }
}
