/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.VO;


public class PuertoVO {
    private long k_puerto;
    private String n_puerto;

    public PuertoVO(long k_puerto, String n_puerto) {
        this.k_puerto = k_puerto;
        this.n_puerto = n_puerto;
    }

    public PuertoVO() {
    }

    public long getK_puerto() {
        return k_puerto;
    }

    public void setK_puerto(long k_puerto) {
        this.k_puerto = k_puerto;
    }

    public String getN_puerto() {
        return n_puerto;
    }

    public void setN_puerto(String n_puerto) {
        this.n_puerto = n_puerto;
    }
    
    
    
}
