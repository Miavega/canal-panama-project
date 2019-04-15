package Modelo.VO;

/**
 * Clase que encapsula los datos de la EMPRESACPVO
 *
 */
public class EmpresaCPVO {

    /*
     * Atributos de las columnas de la tabla
     */
    private String k_idempresa;
    private String n_empresa;
    private String o_telempresa;
    private String o_dirempresa;

    /*
     * Constructor paramétrico de la clase
     */
    public EmpresaCPVO(String k_idempresa, String n_empresa, String o_telempresa, String o_dirempresa) {
        this.k_idempresa = k_idempresa;
        this.n_empresa = n_empresa;
        this.o_telempresa = o_telempresa;
        this.o_dirempresa = o_dirempresa;
    }

    /*
     * Constructor de la clase
     */
    public EmpresaCPVO() {
    }

    public String getK_idempresa() {
        return k_idempresa;
    }

    /*
     * Getters & Setters
     */
    public void setK_idempresa(String k_idempresa) {
        this.k_idempresa = k_idempresa;
    }

    public String getN_empresa() {
        return n_empresa;
    }

    public void setN_empresa(String n_empresa) {
        this.n_empresa = n_empresa;
    }

    public String getO_telempresa() {
        return o_telempresa;
    }

    public void setO_telempresa(String o_telempresa) {
        this.o_telempresa = o_telempresa;
    }

    public String getO_dirempresa() {
        return o_dirempresa;
    }

    public void setO_dirempresa(String o_dirempresa) {
        this.o_dirempresa = o_dirempresa;
    }

}
