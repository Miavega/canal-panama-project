/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.VO;

import java.util.Date;

public class SubastaVO {
    private long k_subasta;
    private Date f_aperturasubasta;
    private Date f_vencimientosubasta;
    private Date f_cuposubasta;
    private long v_pujainicial;
    private long v_incrementominimo;

    public long getK_subasta() {
        return k_subasta;
    }

    public void setK_subasta(long k_subasta) {
        this.k_subasta = k_subasta;
    }

    public Date getF_aperturasubasta() {
        return f_aperturasubasta;
    }

    public void setF_aperturasubasta(Date f_aperturasubasta) {
        this.f_aperturasubasta = f_aperturasubasta;
    }

    public Date getF_vencimientosubasta() {
        return f_vencimientosubasta;
    }

    public void setF_vencimientosubasta(Date f_vencimientosubasta) {
        this.f_vencimientosubasta = f_vencimientosubasta;
    }

    public Date getF_cuposubasta() {
        return f_cuposubasta;
    }

    public void setF_cuposubasta(Date f_cuposubasta) {
        this.f_cuposubasta = f_cuposubasta;
    }

    public long getV_pujainicial() {
        return v_pujainicial;
    }

    public void setV_pujainicial(long v_pujainicial) {
        this.v_pujainicial = v_pujainicial;
    }

    public long getV_incrementominimo() {
        return v_incrementominimo;
    }

    public void setV_incrementominimo(long v_incrementominimo) {
        this.v_incrementominimo = v_incrementominimo;
    }

    public SubastaVO(long k_subasta, Date f_aperturasubasta, Date f_vencimientosubasta, Date f_cuposubasta, long v_pujainicial, long v_incrementominimo) {
        this.k_subasta = k_subasta;
        this.f_aperturasubasta = f_aperturasubasta;
        this.f_vencimientosubasta = f_vencimientosubasta;
        this.f_cuposubasta = f_cuposubasta;
        this.v_pujainicial = v_pujainicial;
        this.v_incrementominimo = v_incrementominimo;
    }

    public SubastaVO() {
    }
            
            
}
