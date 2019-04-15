package Modelo.VO;

/**
 * Clase que encapsula los datos del RESPONSABLE
 *
 */
public class ResponsableVO {

    /*
     * Atributos de las columnas de la tabla
     */
    private long k_identificacion;
    private String k_tipoid;
    private String o_telefonofijo;
    private String o_celular;
    private String o_email;
    private long k_crn;

    /*
     * Constructor paramétrico de la clase
     */
    public ResponsableVO(long k_identificacion, String k_tipoid, String o_telefonofijo, String o_celular, String o_email, long k_crn) {
        this.k_identificacion = k_identificacion;
        this.k_tipoid = k_tipoid;
        this.o_telefonofijo = o_telefonofijo;
        this.o_celular = o_celular;
        this.o_email = o_email;
        this.k_crn = k_crn;
    }

    /*
     * Constructor de la clase
     */
    public ResponsableVO() {
    }

    /*
     * Getters & Setters
     */
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

    public String getO_telefonofijo() {
        return o_telefonofijo;
    }

    public void setO_telefonofijo(String o_telefonofijo) {
        this.o_telefonofijo = o_telefonofijo;
    }

    public String getO_celular() {
        return o_celular;
    }

    public void setO_celular(String o_celular) {
        this.o_celular = o_celular;
    }

    public String getO_email() {
        return o_email;
    }

    public void setO_email(String o_email) {
        this.o_email = o_email;
    }

    public long getK_crn() {
        return k_crn;
    }

    public void setK_crn(long k_crn) {
        this.k_crn = k_crn;
    }

}
