/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.CupoPasoDAO;
import Modelo.VO.CupoPasoVO;
import Util.RHException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "Paso")
public class Paso {

    /**
     * Web service operation Invoca el método del DAO que permite insertar un
     * cupo paso
     *
     * @param k_paso
     * @param q_ctotales
     * @param f_asignacioncupos
     * @return
     * @throws Util.RHException
     * @throws java.text.ParseException
     */
    @WebMethod(operationName = "insertarCupoPaso")
    public Boolean insertarCupoPaso(@WebParam(name = "k_paso") String k_paso, @WebParam(name = "q_ctotales") int q_ctotales, @WebParam(name = "f_asignacioncupos") String f_asignacioncupos) throws RHException, ParseException {
        CupoPasoVO cupoP = new CupoPasoVO();
        cupoP.setK_paso(k_paso);
        cupoP.setQ_ctotales(q_ctotales);
        cupoP.setQ_cdisponibles(q_ctotales);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(f_asignacioncupos);
        String[] fechaF = f_asignacioncupos.split("-");
        
        try {
            Date utilDate = new Date();
            utilDate = formato.parse(fechaF[2] + "/" + fechaF[1] + "/" + fechaF[0]);
            System.out.println("utilDate:" + utilDate);
            String f_transito2 = formato.format(utilDate);
            cupoP.setF_asignacioncupos(f_transito2);
            CupoPasoDAO cupo = new CupoPasoDAO();
            return cupo.crearCupoPaso(cupoP);
        } catch (SQLException | ParseException ex) {
            System.out.println(ex.getMessage());
            return false;        
        }
        
    }

    /**
     * Web service operation
     * @param k_paso
     * @return 
     * @throws Util.RHException 
     */
    @WebMethod(operationName = "leerFechasCupos")
    public ArrayList<CupoPasoVO> leerFechasCupos(@WebParam(name = "k_paso") String k_paso) throws RHException {
        CupoPasoDAO cupo = new CupoPasoDAO();
        ArrayList<CupoPasoVO> cupos = cupo.leerFechasCupos(k_paso);
        return cupos;
    }

    /**
     * Web service operation
     * @param k_paso
     * @param f_asignacion
     * @return 
     * @throws Util.RHException
     * @throws java.text.ParseException
     */
    @WebMethod(operationName = "leerCupos")
    public ArrayList<CupoPasoVO> leerCupos(@WebParam(name = "k_paso") String k_paso, @WebParam(name = "f_asignacion") String f_asignacion) throws RHException, ParseException {
        CupoPasoDAO cupo = new CupoPasoDAO();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(f_asignacion);
        String fechaF[] = f_asignacion.split("-");
        
        System.out.println("Dia" + fechaF[2]);
        System.out.println("Mes" + fechaF[1]);
        System.out.println("año" + fechaF[0]);
        
        Date utilDate = new Date();
        utilDate = formato.parse(fechaF[2] + "/" + fechaF[1] + "/" + fechaF[0]);
        System.out.println("utilDate:" + utilDate);
        String f_asignacion2 = formato.format(utilDate);
        
        ArrayList<CupoPasoVO> fCupos = cupo.leerCupos(k_paso, f_asignacion2);
        return fCupos;
        
    }

    /**
     * Web service operation
     * @param k_paso
     * @param f_asignacion
     * @param q_ctotales
     * @param q_cdisponibles
     * @throws Util.RHException
     * @throws java.text.ParseException
     */
    @WebMethod(operationName = "modificarCupoPaso")
    public void modificarCupoPaso(@WebParam(name = "k_paso") String k_paso, @WebParam(name = "f_asignacion") String f_asignacion, @WebParam(name = "q_ctotales") int q_ctotales, @WebParam(name = "q_cdisponibles") int q_cdisponibles) throws RHException, ParseException {
        CupoPasoDAO cupito = new CupoPasoDAO();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(f_asignacion);
        String fechaF[] = f_asignacion.split("-");
        
        System.out.println("Dia" + fechaF[2]);
        System.out.println("Mes" + fechaF[1]);
        System.out.println("año" + fechaF[0]);
        
        Date utilDate = new Date();
        utilDate = formato.parse(fechaF[2] + "/" + fechaF[1] + "/" + fechaF[0]);
        System.out.println("utilDate:" + utilDate);
        String f_asignacion2 = formato.format(utilDate);
        
        cupito.modificarCupos(k_paso, f_asignacion2, q_ctotales, q_cdisponibles);
        
    }
    
}
