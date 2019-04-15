/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.CargaDAO;
import Modelo.VO.CargaVO;
import Util.RHException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "Carga")
public class Carga {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarCarga")
    public void insertarCarga(@WebParam(name = "carga") CargaVO carga) throws RHException {
        CargaDAO objCargaDao = new CargaDAO();
        System.out.println(carga.getK_reserva() + carga.getV_peso() + carga.getI_lastre() + carga.getI_unidadmedida() + carga.getN_tipocarga());
        objCargaDao.insertarCarga(carga);

    }
}
