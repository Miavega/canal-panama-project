/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.VO;

import java.util.Date;


public class PagoVO {

    private long k_pago;
    private long k_ordendepago;
    private Date f_pago;
    private long v_pago;
    private String i_formapago;
    private String o_cuentaorigen;
    private String campoExtra1;
    private String campoExtra2;
    private String campoExtra3;
    private String campoExtra4;

    public long getK_pago() {
        return k_pago;
    }

    public void setK_pago(long k_pago) {
        this.k_pago = k_pago;
    }

    public long getK_ordendepago() {
        return k_ordendepago;
    }

    public void setK_ordendepago(long k_ordendepago) {
        this.k_ordendepago = k_ordendepago;
    }

    public Date getF_pago() {
        return f_pago;
    }

    public void setF_pago(Date f_pago) {
        this.f_pago = f_pago;
    }

    public long getV_pago() {
        return v_pago;
    }

    public void setV_pago(long v_pago) {
        this.v_pago = v_pago;
    }

    public String getI_formapago() {
        return i_formapago;
    }

    public void setI_formapago(String i_formapago) {
        this.i_formapago = i_formapago;
    }

    public String getO_cuentaorigen() {
        return o_cuentaorigen;
    }

    public void setO_cuentaorigen(String o_cuentaorigen) {
        this.o_cuentaorigen = o_cuentaorigen;
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

    public String getCampoExtra3() {
        return campoExtra3;
    }

    public void setCampoExtra3(String campoExtra3) {
        this.campoExtra3 = campoExtra3;
    }

    public String getCampoExtra4() {
        return campoExtra4;
    }

    public void setCampoExtra4(String campoExtra4) {
        this.campoExtra4 = campoExtra4;
    }

    public PagoVO() {
    }

    public PagoVO(long k_pago, long k_ordendepago, Date f_pago, long v_pago, String i_formapago, String o_cuentaorigen) {
        this.k_pago = k_pago;
        this.k_ordendepago = k_ordendepago;
        this.f_pago = f_pago;
        this.v_pago = v_pago;
        this.i_formapago = i_formapago;
        this.o_cuentaorigen = o_cuentaorigen;
    }

}
