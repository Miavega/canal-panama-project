package Modelo.VO;

/**
 * Clase que encapsula los datos de la RESERVA
 *
 */
public class ReservaVO {

    /*
     * Atributos de las columnas de la tabla
     */
    private long k_reserva;
    private String f_reserva;
    private String i_tiporeserva;
    private String i_dirtransito;
    private String f_transito;
    private long k_buque;
    private String k_esclusa;
    private String k_estadoreserva;
    private long k_identificacion;
    private String k_tipoid;

    /*
     * Constructor paramétrico de la clase
     */
    public ReservaVO(long k_reserva, String f_reserva, String i_tiporeserva, String i_dirtransito, String f_transito,
            long k_buque, String k_esclusa, String k_estadoreserva,
            long k_identificacion, String k_tipoid) {
        this.k_reserva = k_reserva;
        this.f_reserva = f_reserva;
        this.i_tiporeserva = i_tiporeserva;
        this.i_dirtransito = i_dirtransito;
        this.f_transito = f_transito;
        this.k_buque = k_buque;
        this.k_esclusa = k_esclusa;
        this.k_estadoreserva = k_estadoreserva;
        this.k_identificacion = k_identificacion;
        this.k_tipoid = k_tipoid;
    }

    /*
     * Constructor de la clase
     */
    public ReservaVO() {
    }

    /*
     * Getters & Setters
     */
    public long getK_reserva() {
        return k_reserva;
    }

    public String getF_reserva() {
        return f_reserva;
    }

    public String getI_tiporeserva() {
        return i_tiporeserva;
    }

    public String getI_dirtransito() {
        return i_dirtransito;
    }

    public String getF_transito() {
        return f_transito;
    }

    public long getK_buque() {
        return k_buque;
    }

    public String getK_esclusa() {
        return k_esclusa;
    }

    public String getK_estadoreserva() {
        return k_estadoreserva;
    }

    public long getK_identificacion() {
        return k_identificacion;
    }

    public String getK_tipoid() {
        return k_tipoid;
    }

    public void setK_reserva(long k_reserva) {
        this.k_reserva = k_reserva;
    }

    public void setF_reserva(String f_reserva) {
        this.f_reserva = f_reserva;
    }

    public void setI_tiporeserva(String i_tiporeserva) {
        this.i_tiporeserva = i_tiporeserva;
    }

    public void setI_dirtransito(String i_dirtransito) {
        this.i_dirtransito = i_dirtransito;
    }

    public void setF_transito(String f_transito) {
        this.f_transito = f_transito;
    }

    public void setK_buque(long k_buque) {
        this.k_buque = k_buque;
    }

    public void setK_esclusa(String k_esclusa) {
        this.k_esclusa = k_esclusa;
    }

    public void setK_estadoreserva(String k_estadoreserva) {
        this.k_estadoreserva = k_estadoreserva;
    }

    public void setK_identificacion(long k_identificacion) {
        this.k_identificacion = k_identificacion;
    }

    public void setK_tipoid(String k_tipoid) {
        this.k_tipoid = k_tipoid;
    }

}
