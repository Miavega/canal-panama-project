/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.VO;

import java.sql.Timestamp;
import java.util.Date;


public class ProgramacionDiariaVO {

    private long k_programacion;
    private long k_puertollegada;
    private long k_puertosalida;
    private Timestamp f_progyhorallegada;
    private Timestamp f_progyhorasalida;
    private long k_identificacion;
    private String k_tipoid;
    private long k_reserva;
    private String campoExtra1;
    private String campoExtra2;

    public ProgramacionDiariaVO(long k_programacion, long k_puertollegada, long k_puertosalida, Timestamp f_progyhorallegada, Timestamp f_progyhorasalida, long k_identificacion, String k_tipoid, long k_reserva) {
        this.k_programacion = k_programacion; 
        this.k_puertollegada = k_puertollegada; 
        this.k_puertosalida = k_puertosalida; 
        this.f_progyhorallegada = f_progyhorallegada; 
        this.f_progyhorasalida = f_progyhorasalida; 
        this.k_identificacion = k_identificacion; 
        this.k_tipoid = k_tipoid; 
        this.k_reserva = k_reserva; 
    }

    public ProgramacionDiariaVO() {
    }

    public long getK_programacion() {
        return k_programacion;
    }

    public void setK_programacion(long k_programacion) {
        this.k_programacion = k_programacion;
    }

    public long getK_puertollegada() {
        return k_puertollegada;
    }

    public void setK_puertollegada(long k_puertollegada) {
        this.k_puertollegada = k_puertollegada;
    }

    public long getK_puertosalida() {
        return k_puertosalida;
    }

    public void setK_puertosalida(long k_puertosalida) {
        this.k_puertosalida = k_puertosalida;
    }

    public Timestamp getF_progyhorallegada() {
        return f_progyhorallegada;
    }

    public void setF_progyhorallegada(Timestamp f_progyhorallegada) {
        this.f_progyhorallegada = f_progyhorallegada;
    }

    public Timestamp getF_progyhorasalida() {
        return f_progyhorasalida;
    }

    public void setF_progyhorasalida(Timestamp f_progyhorasalida) {
        this.f_progyhorasalida = f_progyhorasalida;
    }

    public long getK_identificacion() {
        return k_identificacion;
    }

    public void setK_identificacion(long k_identificacion) {
        this.k_identificacion = k_identificacion;
    }

    public String getK_tipoid() {
        return k_tipoid;
    }

    public void setK_tipoid(String k_tipoid) {
        this.k_tipoid = k_tipoid;
    }

    public long getK_reserva() {
        return k_reserva;
    }

    public void setK_reserva(long k_reserva) {
        this.k_reserva = k_reserva;
    }

    public String getCampoExtra1() {
        return campoExtra1;
    }

    public void setCampoExtra1(String campoExtra1) {
        this.campoExtra1 = campoExtra1;
    }

    public String getCampoExtra2() {
        return campoExtra2;
    }

    public void setCampoExtra2(String campoExtra2) {
        this.campoExtra2 = campoExtra2;
    }

    
}
