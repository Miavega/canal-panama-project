/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.VO;

import java.sql.Timestamp;
import java.util.Date;


public class TransitoVO {

    private long k_transito;
    private Timestamp y_horallegada;
    private Timestamp y_horasalida;
    private long k_esclusa;
    private long k_reserva;

    public TransitoVO() {
    }

    public TransitoVO(long k_transito, Timestamp y_horallegada, Timestamp y_horasalida, long k_esclusa, long k_reserva) {
        this.k_transito = k_transito;
        this.y_horallegada = y_horallegada;
        this.y_horasalida = y_horasalida;
        this.k_esclusa = k_esclusa;
        this.k_reserva = k_reserva;
    }

    public long getK_transito() {
        return k_transito;
    }

    public void setK_transito(long k_transito) {
        this.k_transito = k_transito;
    }

    public Date getY_horallegada() {
        return y_horallegada;
    }

    public void setY_horallegada(Timestamp y_horallegada) {
        this.y_horallegada = y_horallegada;
    }

    public Date getY_horasalida() {
        return y_horasalida;
    }

    public void setY_horasalida(Timestamp y_horasalida) {
        this.y_horasalida = y_horasalida;
    }

    public long getK_esclusa() {
        return k_esclusa;
    }

    public void setK_esclusa(long k_esclusa) {
        this.k_esclusa = k_esclusa;
    }

    public long getK_reserva() {
        return k_reserva;
    }

    public void setK_reserva(long k_reserva) {
        this.k_reserva = k_reserva;
    }

}
