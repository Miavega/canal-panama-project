package Modelo.VO;

/**
 * Clase que encapsula los datos de la ESCLUSA
 *
 */
public class EsclusaVO {

    /*
     * Atributos de las columnas de la tabla
     */
    private String k_esclusa;
    private String n_esclusa;
    private float v_maxloa;
    private float v_minloa;
    private float v_maxmanga;
    private float v_minmanga;

    /*
     * Constructor paramétrico de la clase
     */
    public EsclusaVO(String k_esclusa, String n_esclusa, float v_maxloa, float v_minloa, float v_maxmanga, float v_minmanga) {
        this.k_esclusa = k_esclusa;
        this.n_esclusa = n_esclusa;
        this.v_maxloa = v_maxloa;
        this.v_minloa = v_minloa;
        this.v_maxmanga = v_maxmanga;
        this.v_minmanga = v_minmanga;
    }

    /*
     * Constructor de la clase
     */
    public EsclusaVO() {
    }

    /*
     * Getters & Setters
     */
    public String getK_esclusa() {
        return k_esclusa;
    }

    public String getN_esclusa() {
        return n_esclusa;
    }

    public float getV_maxloa() {
        return v_maxloa;
    }

    public float getV_minloa() {
        return v_minloa;
    }

    public float getV_maxmanga() {
        return v_maxmanga;
    }

    public float getV_minmanga() {
        return v_minmanga;
    }

    public void setK_esclusa(String k_esclusa) {
        this.k_esclusa = k_esclusa;
    }

    public void setN_esclusa(String n_esclusa) {
        this.n_esclusa = n_esclusa;
    }

    public void setV_maxloa(float v_maxloa) {
        this.v_maxloa = v_maxloa;
    }

    public void setV_minloa(float v_minloa) {
        this.v_minloa = v_minloa;
    }

    public void setV_maxmanga(float v_maxmanga) {
        this.v_maxmanga = v_maxmanga;
    }

    public void setV_minmanga(float v_minmanga) {
        this.v_minmanga = v_minmanga;
    }

}
