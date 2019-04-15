/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.SubastaDAO;
import Modelo.VO.SubastaVO;
import Util.RHException;
import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Subasta")
public class Subasta {


    /**
     * Web service operation
     * @param k_reserva
     * @return 
     * @throws Util.RHException 
     */
    @WebMethod(operationName = "buscarSubasta")
    public ArrayList<SubastaVO> buscarSubasta(@WebParam(name = "k_reserva") long k_reserva) throws RHException {
        SubastaDAO subi = new SubastaDAO();
        ArrayList<SubastaVO> su = subi.buscarSubasta(k_reserva);
        return su;
    }

    /**
     * Web service operation
     * @param k_subasta
     */
    @WebMethod(operationName = "cerrarSubasta")
    public void cerrarSubasta(@WebParam(name = "k_subasta") long k_subasta) throws RHException {
        SubastaDAO sub = new SubastaDAO();
        sub.cerrarSubasta(k_subasta);
    }

    /**
     * Web service operation
     * @param k_subasta
     */
    @WebMethod(operationName = "buscarSubastaEspecifica")
    public SubastaVO buscarSubastaEspecifica(@WebParam(name = "k_subasta") long k_subasta) throws RHException {
        SubastaVO subvo = new SubastaVO(); 
        SubastaDAO sub = new SubastaDAO();
        subvo = sub.buscarSubastaEspecifica(k_subasta);
        return subvo;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "listarSubastas")
    public ArrayList<Long> listarSubastas() throws RHException {
        ArrayList<Long> k_subastas = new ArrayList<>();
        SubastaDAO sub = new SubastaDAO();
        k_subastas = sub.listarSubastas();
        return k_subastas;
    }
}
