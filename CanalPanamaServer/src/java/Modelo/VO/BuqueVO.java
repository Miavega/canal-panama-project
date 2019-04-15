package Modelo.VO;

/**
 * Clase que encapsula los datos del BUQUE
 *
 */
public class BuqueVO {

    /*
     * Atributos de las columnas de la tabla
     */
    private int k_buque;
    private String n_buque;
    private float v_manga;
    private float v_loa;
    private float v_velocidad;
    private float v_pesomuerto;
    private String k_categoria;
    private String k_crn;

    /*
     * Constructor paramétrico de la clase
     */
    public BuqueVO(int k_buque, String n_buque, float v_manga, float v_loa, float v_velocidad,
            float v_pesomuerto, String k_categoria, String k_crn) {
        this.k_buque = k_buque;
        this.n_buque = n_buque;
        this.v_manga = v_manga;
        this.v_loa = v_loa;
        this.v_velocidad = v_velocidad;
        this.v_pesomuerto = v_pesomuerto;
        this.k_categoria = k_categoria;
        this.k_crn = k_crn;
    }

    /*
     * Constructor de la clase
     */
    public BuqueVO() {
    }

    /*
     * Getters
     */
    public int getK_buque() {
        return k_buque;
    }

    public String getN_buque() {
        return n_buque;
    }

    public float getV_manga() {
        return v_manga;
    }

    public float getV_loa() {
        return v_loa;
    }

    public float getV_velocidad() {
        return v_velocidad;
    }

    public float getV_pesomuerto() {
        return v_pesomuerto;
    }

    public String getK_categoria() {
        return k_categoria;
    }

    public String getK_crn() {
        return k_crn;
    }

    /*
     * Setters
     */
    public void setK_buque(int k_buque) {
        this.k_buque = k_buque;
    }

    public void setN_buque(String n_buque) {
        this.n_buque = n_buque;
    }

    public void setV_manga(float v_manga) {
        this.v_manga = v_manga;
    }

    public void setV_loa(float v_loa) {
        this.v_loa = v_loa;
    }

    public void setV_velocidad(float v_velocidad) {
        this.v_velocidad = v_velocidad;
    }

    public void setV_pesomuerto(float v_pesomuerto) {
        this.v_pesomuerto = v_pesomuerto;
    }

    public void setK_categoria(String k_categoria) {
        this.k_categoria = k_categoria;
    }

    public void setK_crn(String k_crn) {
        this.k_crn = k_crn;
    }

}
