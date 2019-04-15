/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.VO;



public class OrdenPagoVO {

     private long k_ordendepago;
     private long k_reserva;
     private String k_concepto;
     private long v_ordendepago;
     private String f_emision;
     private String f_maxpago;
     private String n_estadopago;

    public long getK_ordendepago() {
        return k_ordendepago;
    }

    public void setK_ordendepago(long k_ordendepago) {
        this.k_ordendepago = k_ordendepago;
    }

    public long getK_reserva() {
        return k_reserva;
    }

    public void setK_reserva(long k_reserva) {
        this.k_reserva = k_reserva;
    }

    public String getK_concepto() {
        return k_concepto;
    }

    public void setK_concepto(String k_concepto) {
        this.k_concepto = k_concepto;
    }

    public long getV_ordendepago() {
        return v_ordendepago;
    }

    public void setV_ordendepago(long v_ordendepago) {
        this.v_ordendepago = v_ordendepago;
    }

    public String getF_emision() {
        return f_emision;
    }

    public void setF_emision(String f_emision) {
        this.f_emision = f_emision;
    }

    public String getF_maxpago() {
        return f_maxpago;
    }

    public void setF_maxpago(String f_maxpago) {
        this.f_maxpago = f_maxpago;
    }

    public String getN_estadopago() {
        return n_estadopago;
    }

    public void setN_estadopago(String n_estadopago) {
        this.n_estadopago = n_estadopago;
    }

    public OrdenPagoVO() {
    }

    public OrdenPagoVO(long k_ordendepago, long k_reserva, String k_concepto, long v_ordendepago, String f_emision, String f_maxpago, String n_estadopago) {
        this.k_ordendepago = k_ordendepago;
        this.k_reserva = k_reserva;
        this.k_concepto = k_concepto;
        this.v_ordendepago = v_ordendepago;
        this.f_emision = f_emision;
        this.f_maxpago = f_maxpago;
        this.n_estadopago = n_estadopago;
    }
     
     
     
}
