/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.CupoPasoDAO;
import Control.DAO.OperadorDAO;
import Control.DAO.PasoDAO;
import Control.DAO.ReservaDAO;
import Control.DAO.ResponsableDAO;
import Modelo.VO.CupoPasoVO;
import Modelo.VO.OperadorVO;
import Modelo.VO.ReservaVO;
import Util.RHException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * Clase controladora de la aplicación
 *
 */
@WebService(serviceName = "Reserva")
public class Reserva {

    /**
     * Web service operation Invoca el método del DAO que permite cargar las
     * esclusas
     *
     * @return
     * @throws Util.RHException
     */
    @WebMethod(operationName = "cargarEsclusa")
    public ArrayList cargarEsclusa() throws RHException {
        PasoDAO miEsclusa = new PasoDAO();
        return miEsclusa.leerPasos();
    }

    /**
     * Web service operation Invoca el método del DAO que permite insertar una
     * reserva
     *
     * @param k_buque
     * @param k_esclusa
     * @param k_idresponsable
     * @param k_tiporeserva
     * @param i_dirtransito
     * @param f_transito
     * @throws Util.RHException
     */
    @WebMethod(operationName = "insertarReserva")
    @RequestWrapper(className = "Servidor.insertarReserva_1")
    @ResponseWrapper(className = "Servidor.insertarReserva_1Response")
    public void insertarReserva(@WebParam(name = "k_buque") String k_buque, @WebParam(name = "k_esclusa") String k_esclusa, @WebParam(name = "k_idresponsable") String k_idresponsable, @WebParam(name = "k_tiporeserva") String k_tiporeserva, @WebParam(name = "i_dirtransito") String i_dirtransito, @WebParam(name = "f_transito") String f_transito) throws RHException, ParseException {
        ReservaDAO servi = new ReservaDAO();
        ResponsableDAO responsable = new ResponsableDAO();
        String tipoDoc = responsable.leerTipoid(Long.valueOf(k_idresponsable)).getK_tipoid();
        System.out.println("fech" + f_transito);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaF[] = f_transito.split("-");
        Date fechaTemp = new Date();
        fechaTemp = formato.parse(fechaF[2] + "/" + fechaF[1] + "/" + fechaF[0]);
        String f_transito2 = formato.format(fechaTemp);
        System.out.println("fech" + f_transito2);
        ReservaVO reserva = new ReservaVO();
        reserva.setK_buque(Integer.parseInt(k_buque));
        reserva.setK_identificacion(Integer.parseInt(k_idresponsable));
        reserva.setK_tipoid(tipoDoc);
        reserva.setI_tiporeserva(k_tiporeserva);
        reserva.setI_dirtransito(i_dirtransito);
        reserva.setF_transito(f_transito2);
        servi.crearReserva(reserva);
    }

    /**
     * Web service operation Invoca el método del DAO que permite cargar las
     * reservas de un operador
     *
     * @param usuario
     * @return
     * @throws Util.RHException
     */
    @WebMethod(operationName = "leerMisReservas")
    public ArrayList<ReservaVO> leerMisReservas(@WebParam(name = "usuario") String usuario) throws RHException {
        OperadorDAO operador = new OperadorDAO();
        OperadorVO miOperador = operador.leerOperadorBuque(usuario);
        ReservaDAO reserva = new ReservaDAO();
        ArrayList<ReservaVO> listaR = reserva.leerReservas(miOperador.getK_crn());
        return listaR;
    }

    /**
     * Web service operation
     *
     * @param f_transito
     * @return
     */
    @WebMethod(operationName = "leerReservasPorDia")
    public ArrayList<ReservaVO> leerReservasPorDia(@WebParam(name = "f_transito") String f_transito) throws RHException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(f_transito);
        String fechaF[] = f_transito.split("-");
        
        System.out.println("Dia" + fechaF[2]);
        System.out.println("Mes" + fechaF[1]);
        System.out.println("año" + fechaF[0]);
        
        Date utilDate = new Date();
        utilDate = formato.parse(fechaF[2] + "/" + fechaF[1] + "/" + fechaF[0]);
        System.out.println("utilDate:" + utilDate);
        String f_transito2 = formato.format(utilDate);
        System.out.println("La fecha para oracle es " + f_transito2);
        ReservaDAO reserva = new ReservaDAO();
        ArrayList<ReservaVO> reservaDia = reserva.leerReservasDia(f_transito2);
        return reservaDia;
    }

    /**
     * Web service operation
     *
     * @param k_buque PK del buque
     * @param f_asignacioncupos fecha de solicitud de la reserva
     * @return objeto CupoPasoVO que contiene la información de los cupos para
     * la fecha solicitada
     * @throws Util.RHException
     * @throws java.text.ParseException
     */
    @WebMethod(operationName = "revisarDisponibilidad")
    public CupoPasoVO revisarDisponibilidad(@WebParam(name = "k_buque") String k_buque, @WebParam(name = "f_asignacioncupos") String f_asignacioncupos) throws RHException, ParseException {
        CupoPasoDAO cupos = new CupoPasoDAO();
        System.out.println("FechaLOCA" + f_asignacioncupos);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaF[] = f_asignacioncupos.split("-");
        System.out.println("Dia" + fechaF[2]);
        System.out.println("Mes" + fechaF[1]);
        System.out.println("año" + fechaF[0]);
        Date utilDate = new Date();
        utilDate = formato.parse(fechaF[2] + "/" + fechaF[1] + "/" + fechaF[0]);
        String f_asignacion2 = formato.format(utilDate);
        System.out.println(f_asignacion2);
        CupoPasoVO misCupos = cupos.verificarCupos(Long.valueOf(k_buque), f_asignacion2);
        return misCupos;
    }
    
    
    
    
}
