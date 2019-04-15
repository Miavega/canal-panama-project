package Modelo.VO;

/**
 * Clase que encapsula los datos del OPERADOR
 *
 */
public class OperadorVO {

    /*
     * Atributos de las columnas de la tabla
     */
    private long k_crn;
    private int k_pais;
    private String n_operador;
    private String o_tel;
    private String o_direccion;
    private String o_email;

    /*
     * Constructor paramétrico de la clase
     */
    public OperadorVO(long k_crn, int k_pais, String n_operador, String o_tel, String o_direccion, String o_email) {
        this.k_crn = k_crn;
        this.k_pais = k_pais;
        this.n_operador = n_operador;
        this.o_tel = o_tel;
        this.o_direccion = o_direccion;
        this.o_email = o_email;
    }

    /*
     * Constructor de la clase
     */
    public OperadorVO() {
    }

    /*
     * Getters & Setters
     */
    public long getK_crn() {
        return k_crn;
    }

    public int getK_pais() {
        return k_pais;
    }

    public String getN_operador() {
        return n_operador;
    }

    public String getO_tel() {
        return o_tel;
    }

    public String getO_direccion() {
        return o_direccion;
    }

    public String getO_email() {
        return o_email;
    }

    public void setK_crn(long k_crn) {
        this.k_crn = k_crn;
    }

    public void setK_pais(int k_pais) {
        this.k_pais = k_pais;
    }

    public void setN_operador(String n_operador) {
        this.n_operador = n_operador;
    }

    public void setO_tel(String o_tel) {
        this.o_tel = o_tel;
    }

    public void setO_direccion(String o_direccion) {
        this.o_direccion = o_direccion;
    }

    public void setO_email(String o_email) {
        this.o_email = o_email;
    }

}
