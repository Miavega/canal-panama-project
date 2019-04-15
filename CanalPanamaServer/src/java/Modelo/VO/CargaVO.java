/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.VO;


public class CargaVO {
    private long k_reserva;
    private long v_peso;
    private int i_lastre;
    private String i_unidadmedida;
    private String n_tipocarga;

    public long getK_reserva() {
        return k_reserva;
    }

    public void setK_reserva(long k_reserva) {
        this.k_reserva = k_reserva;
    }

    public long getV_peso() {
        return v_peso;
    }

    public void setV_peso(long v_peso) {
        this.v_peso = v_peso;
    }

    public int getI_lastre() {
        return i_lastre;
    }

    public void setI_lastre(int i_lastre) {
        this.i_lastre = i_lastre;
    }

    public String getI_unidadmedida() {
        return i_unidadmedida;
    }

    public void setI_unidadmedida(String i_unidadmedida) {
        this.i_unidadmedida = i_unidadmedida;
    }

    public String getN_tipocarga() {
        return n_tipocarga;
    }

    public void setN_tipocarga(String n_tipocarga) {
        this.n_tipocarga = n_tipocarga;
    }

    public CargaVO() {
    }

    public CargaVO(long k_reserva, long v_peso, int i_lastre, String i_unidadmedida, String n_tipocarga) {
        this.k_reserva = k_reserva;
        this.v_peso = v_peso;
        this.i_lastre = i_lastre;
        this.i_unidadmedida = i_unidadmedida;
        this.n_tipocarga = n_tipocarga;
    }
    
    
    
}
