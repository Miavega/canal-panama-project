/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Control.DAO.ProgramacionDiariaDAO;
import Modelo.VO.ProgramacionDiariaVO;
import Util.RHException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "ProgDiaria")
public class ProgramacionDiaria {

    /**
     * Web service operation
     *
     * @param kreservas
     * @param puertosS
     * @param puertosL
     * @param horasS
     * @param horasL
     * @param fecha
     * @throws Util.RHException
     * @throws java.text.ParseException
     */
    @WebMethod(operationName = "insertarProgramacionDiaria")
    public void insertarProgramacionDiaria(@WebParam(name = "kreservas") String[] kreservas, @WebParam(name = "puertosS") String[] puertosS, @WebParam(name = "puertosL") String[] puertosL, @WebParam(name = "horasS") String[] horasS, @WebParam(name = "horasL") String[] horasL, @WebParam(name = "fecha") String fecha) throws RHException, ParseException {
        ArrayList<ProgramacionDiariaVO> listaProgramacion = new ArrayList();
        Date date = new Date();
        SimpleDateFormat hourFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        ProgramacionDiariaDAO programacion = new ProgramacionDiariaDAO();
        for (int i = 0; i < kreservas.length; i++) {
            ProgramacionDiariaVO objProgramacion = new ProgramacionDiariaVO();
            objProgramacion.setK_reserva(Long.valueOf(kreservas[i]));
            objProgramacion.setK_puertosalida(Long.valueOf(puertosS[i]));
            objProgramacion.setK_puertollegada(Long.valueOf(puertosL[i]));

            // -------------- Lo de las horitas -----------------------------
            String fechaF[] = fecha.split("-");
            String horasLlegada = fechaF[2] + "/" + fechaF[1] + "/" + fechaF[0] + " " + horasL[i] + ":00";
            String horasSalida = fechaF[2] + "/" + fechaF[1] + "/" + fechaF[0] + " " + horasS[i] + ":00";
            System.out.println(horasLlegada);
            date = hourFormat.parse(horasLlegada);
            Timestamp f_horallegada = new Timestamp(date.getTime());
            System.out.println("Hora llegada: " + horasLlegada);
            date = hourFormat.parse(horasSalida);
            Timestamp f_horasalida = new Timestamp(date.getTime());
            System.out.println("Hora salida: " + horasSalida);
            // -------------- Fin Lo de las horitas -----------------------------

            objProgramacion.setF_progyhorasalida(f_horallegada);
            objProgramacion.setF_progyhorallegada(f_horasalida);
            objProgramacion.setK_identificacion(1529967L);
            objProgramacion.setK_tipoid("CC");
            listaProgramacion.add(objProgramacion);
        }
        try {
            programacion.insertarProgramacionDiaria(listaProgramacion);
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }

    }

    /**
     * Web service operation
     * @param f_transito
     * @return 
     * @throws java.text.ParseException
     * @throws Util.RHException
     */
    @WebMethod(operationName = "leerProgramacionDiaria")
    public ArrayList<ProgramacionDiariaVO> leerProgramacionDiaria(@WebParam(name = "f_transito") String f_transito) throws ParseException, RHException {
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
        
        ProgramacionDiariaDAO prog = new ProgramacionDiariaDAO();
        ArrayList<ProgramacionDiariaVO> progDia = prog.leerProgramacionDiaria(f_transito2);
        return progDia;
        
        
    }
}
