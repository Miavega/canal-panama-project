package Modelo.VO;

/**
 * Clase que encapsula los datos del PASO
 *
 */
public class PasoVO {

    /*
     * Atributos de las columnas de la tabla
     */
    private String k_paso;
    private String n_paso;
    private float v_minloa;
    private float v_maxloa;
    private float v_minmanga;
    private float v_maxmanga;
    private String k_idempresa;

    /*
     * Constructor paramétrico de la clase
     */
    public PasoVO(String k_paso, String n_paso, float v_minloa, float v_maxloa, float v_minmanga, float v_maxmanga, String k_idempresa) {
        this.k_paso = k_paso;
        this.n_paso = n_paso;
        this.v_minloa = v_minloa;
        this.v_maxloa = v_maxloa;
        this.v_minmanga = v_minmanga;
        this.v_maxmanga = v_maxmanga;
        this.k_idempresa = k_idempresa;
    }

    /*
     * Constructor de la clase
     */
    public PasoVO() {
    }

    /*
     * Getters & Setters
     */
    public String getK_paso() {
        return k_paso;
    }

    public void setK_paso(String k_paso) {
        this.k_paso = k_paso;
    }

    public String getN_paso() {
        return n_paso;
    }

    public void setN_paso(String n_paso) {
        this.n_paso = n_paso;
    }

    public float getV_minloa() {
        return v_minloa;
    }

    public void setV_minloa(float v_minloa) {
        this.v_minloa = v_minloa;
    }

    public float getV_maxloa() {
        return v_maxloa;
    }

    public void setV_maxloa(float v_maxloa) {
        this.v_maxloa = v_maxloa;
    }

    public float getV_minmanga() {
        return v_minmanga;
    }

    public void setV_minmanga(float v_minmanga) {
        this.v_minmanga = v_minmanga;
    }

    public float getV_maxmanga() {
        return v_maxmanga;
    }

    public void setV_maxmanga(float v_maxmanga) {
        this.v_maxmanga = v_maxmanga;
    }

    public String getK_idempresa() {
        return k_idempresa;
    }

    public void setK_idempresa(String k_idempresa) {
        this.k_idempresa = k_idempresa;
    }

}
