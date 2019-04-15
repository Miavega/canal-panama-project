/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Control.Conexion.Conexion;
import Control.DAO.CupoPasoDAO;
import Control.DAO.ProgramacionDiariaDAO;
import Control.DAO.ReservaDAO;
import Modelo.VO.CupoPasoVO;
import Modelo.VO.ProgramacionDiariaVO;
import Modelo.VO.ReservaVO;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class prueba {

    public static void main(String[] args) throws RHException, SQLException, ParseException {
       Conexion.setUsuario("U_COOCP1");
       Conexion.setContrasena("12345");

        //NO BORRAR ES PARA LA PROGRAMACION DIARIAs
        ProgramacionDiariaDAO p = new ProgramacionDiariaDAO();
        ProgramacionDiariaVO programacionVO = new ProgramacionDiariaVO();

        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = hourFormat.parse("02/01/2019 14:00:00");
        Timestamp f_horallegada = new Timestamp(date.getTime());
        System.out.println("MI HORA DE LLEGADA ES: " + f_horallegada);

        date = hourFormat.parse("02/01/2019 16:00:00");
        Timestamp f_horasalida = new Timestamp(date.getTime());
        System.out.println("MI HORA DE SALIDA ES: " + f_horasalida);

        programacionVO.setK_puertollegada(1L);
        programacionVO.setK_puertosalida(3L);
        programacionVO.setF_progyhorallegada(f_horallegada);
        programacionVO.setF_progyhorasalida(f_horasalida);
        programacionVO.setK_identificacion(1529967L);
        programacionVO.setK_tipoid("CC");
        programacionVO.setK_reserva(4L);

        ArrayList<ProgramacionDiariaVO> lista = new ArrayList<>();
        lista.add(programacionVO);
        p.insertarProgramacionDiaria(lista);

    }

}
