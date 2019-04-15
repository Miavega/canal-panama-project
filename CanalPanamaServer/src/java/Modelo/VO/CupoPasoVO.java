package Modelo.VO;

/**
 * Clase que encapsula los datos del CUPOPASO
 *
 */
public class CupoPasoVO {

    /*
     * Atributos de las columnas de la tabla
     */
    private long k_cupopaso;
    private String k_paso;
    private int q_ctotales;
    private int q_cdisponibles;
    private String f_asignacioncupos;

    /*
     * Constructor paramétrico de la clase
     */
    public CupoPasoVO(long k_cupopaso, String k_paso, int q_ctotales, int q_cdisponibles, String f_asignacioncupos) {
        this.k_cupopaso = k_cupopaso;
        this.k_paso = k_paso;
        this.q_ctotales = q_ctotales;
        this.q_cdisponibles = q_cdisponibles;
        this.f_asignacioncupos = f_asignacioncupos;
    }

    /*
     * Constructor de la clase
     */
    public CupoPasoVO() {
    }

    /*
     * Getters & Setters
     */
    public long getK_cupopaso() {
        return k_cupopaso;
    }

    public void setK_cupopaso(long k_cupopaso) {
        this.k_cupopaso = k_cupopaso;
    }

    public String getK_paso() {
        return k_paso;
    }

    public void setK_paso(String k_paso) {
        this.k_paso = k_paso;
    }

    public int getQ_ctotales() {
        return q_ctotales;
    }

    public void setQ_ctotales(int q_ctotales) {
        this.q_ctotales = q_ctotales;
    }

    public int getQ_cdisponibles() {
        return q_cdisponibles;
    }

    public void setQ_cdisponibles(int q_cdisponibles) {
        this.q_cdisponibles = q_cdisponibles;
    }

    public String getF_asignacioncupos() {
        return f_asignacioncupos;
    }

    public void setF_asignacioncupos(String f_asignacioncupos) {
        this.f_asignacioncupos = f_asignacioncupos;
    }

}
