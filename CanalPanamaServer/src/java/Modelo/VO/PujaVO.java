/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.VO;

import java.sql.Timestamp;


public class PujaVO {
    
    private long k_subasta;
    private long k_puja;
    private String f_puja;
    private long v_puja;
    private String n_estadopuja;
    private long k_identificacion;
    private String k_tipoid;

    public long getK_subasta() {
        return k_subasta;
    }

    public void setK_subasta(long k_subasta) {
        this.k_subasta = k_subasta;
    }

    public long getK_puja() {
        return k_puja;
    }

    public void setK_puja(long k_puja) {
        this.k_puja = k_puja;
    }

    public String getF_puja() {
        return f_puja;
    }

    public void setF_puja(String f_puja) {
        this.f_puja = f_puja;
    }

    public long getV_puja() {
        return v_puja;
    }

    public void setV_puja(long v_puja) {
        this.v_puja = v_puja;
    }

    public String getN_estadopuja() {
        return n_estadopuja;
    }

    public void setN_estadopuja(String n_estadopuja) {
        this.n_estadopuja = n_estadopuja;
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

    public PujaVO(long k_subasta, long k_puja, String f_puja, long v_puja, String n_estadopuja) {
        this.k_subasta = k_subasta;
        this.k_puja = k_puja;
        this.f_puja = f_puja;
        this.v_puja = v_puja;
        this.n_estadopuja = n_estadopuja;
    }

    public PujaVO() {
    }
    
    
    
}
