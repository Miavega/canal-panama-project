/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.BuqueDAO;
import Control.DAO.OperadorDAO;
import Control.DAO.ResponsableDAO;
import Modelo.VO.BuqueVO;
import Modelo.VO.OperadorVO;
import Modelo.VO.ResponsableVO;
import Util.RHException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Clase controladora de la aplicación
 *
 */
@WebService(serviceName = "Buque")
public class Buque {

    /**
     * Web service operation Invoca el método del DAO que permite cargar un
     * buque
     *
     * @param k_buque
     * @return
     * @throws Util.RHException
     */
    @WebMethod(operationName = "cargarBuque")
    public ArrayList cargarBuque(@WebParam(name = "k_buque") int k_buque) throws RHException {
        BuqueDAO buque = new BuqueDAO();
        BuqueVO buquev = new BuqueVO();
        System.out.println("ME ESTA LLEGANDO: " + k_buque);
        buquev = buque.leerBuque(k_buque);
        ArrayList infoBuque = new ArrayList();
        infoBuque.add(buquev.getN_buque());
        infoBuque.add(buquev.getK_categoria());

        OperadorDAO operador = new OperadorDAO();
        OperadorVO miOperador = operador.leerOperador(Long.parseLong(buquev.getK_crn()));
        infoBuque.add(miOperador.getN_operador());

        ResponsableDAO responsable = new ResponsableDAO();
        ResponsableVO miResponsable = responsable.leerResponsable(Long.parseLong(buquev.getK_crn()));
        infoBuque.add(miResponsable.getK_identificacion());

        infoBuque.add(String.valueOf(buquev.getV_manga()));
        infoBuque.add(String.valueOf(buquev.getV_loa()));
        infoBuque.add(String.valueOf(buquev.getV_pesomuerto()));
        infoBuque.add(String.valueOf(buquev.getV_velocidad()));
        return infoBuque;
    }

    /**
     * Web service operation Invoca el método del DAO que permite cargar todos
     * los buques de un operador
     *
     * @param usuario
     * @return
     * @throws Util.RHException
     */
    @WebMethod(operationName = "cargarBuques")
    public ArrayList cargarBuques(String usuario) throws RHException {
        BuqueDAO miBuque = new BuqueDAO();
        OperadorDAO operador = new OperadorDAO();
        OperadorVO miOperador = operador.leerOperadorBuque(usuario);
        return miBuque.leerBuques(miOperador.getK_crn());
    }
}
