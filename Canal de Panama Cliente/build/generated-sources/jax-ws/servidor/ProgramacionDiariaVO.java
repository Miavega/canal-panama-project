
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para programacionDiariaVO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="programacionDiariaVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="campoExtra1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="campoExtra2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="f_progyhorallegada" type="{http://Servidor/}timestamp" minOccurs="0"/&gt;
 *         &lt;element name="f_progyhorasalida" type="{http://Servidor/}timestamp" minOccurs="0"/&gt;
 *         &lt;element name="k_identificacion" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_programacion" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_puertollegada" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_puertosalida" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_reserva" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_tipoid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "programacionDiariaVO", propOrder = {
    "campoExtra1",
    "campoExtra2",
    "fProgyhorallegada",
    "fProgyhorasalida",
    "kIdentificacion",
    "kProgramacion",
    "kPuertollegada",
    "kPuertosalida",
    "kReserva",
    "kTipoid"
})
public class ProgramacionDiariaVO {

    protected String campoExtra1;
    protected String campoExtra2;
    @XmlElement(name = "f_progyhorallegada")
    protected Timestamp fProgyhorallegada;
    @XmlElement(name = "f_progyhorasalida")
    protected Timestamp fProgyhorasalida;
    @XmlElement(name = "k_identificacion")
    protected long kIdentificacion;
    @XmlElement(name = "k_programacion")
    protected long kProgramacion;
    @XmlElement(name = "k_puertollegada")
    protected long kPuertollegada;
    @XmlElement(name = "k_puertosalida")
    protected long kPuertosalida;
    @XmlElement(name = "k_reserva")
    protected long kReserva;
    @XmlElement(name = "k_tipoid")
    protected String kTipoid;

    /**
     * Obtiene el valor de la propiedad campoExtra1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampoExtra1() {
        return campoExtra1;
    }

    /**
     * Define el valor de la propiedad campoExtra1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampoExtra1(String value) {
        this.campoExtra1 = value;
    }

    /**
     * Obtiene el valor de la propiedad campoExtra2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampoExtra2() {
        return campoExtra2;
    }

    /**
     * Define el valor de la propiedad campoExtra2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampoExtra2(String value) {
        this.campoExtra2 = value;
    }

    /**
     * Obtiene el valor de la propiedad fProgyhorallegada.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getFProgyhorallegada() {
        return fProgyhorallegada;
    }

    /**
     * Define el valor de la propiedad fProgyhorallegada.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setFProgyhorallegada(Timestamp value) {
        this.fProgyhorallegada = value;
    }

    /**
     * Obtiene el valor de la propiedad fProgyhorasalida.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getFProgyhorasalida() {
        return fProgyhorasalida;
    }

    /**
     * Define el valor de la propiedad fProgyhorasalida.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setFProgyhorasalida(Timestamp value) {
        this.fProgyhorasalida = value;
    }

    /**
     * Obtiene el valor de la propiedad kIdentificacion.
     * 
     */
    public long getKIdentificacion() {
        return kIdentificacion;
    }

    /**
     * Define el valor de la propiedad kIdentificacion.
     * 
     */
    public void setKIdentificacion(long value) {
        this.kIdentificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad kProgramacion.
     * 
     */
    public long getKProgramacion() {
        return kProgramacion;
    }

    /**
     * Define el valor de la propiedad kProgramacion.
     * 
     */
    public void setKProgramacion(long value) {
        this.kProgramacion = value;
    }

    /**
     * Obtiene el valor de la propiedad kPuertollegada.
     * 
     */
    public long getKPuertollegada() {
        return kPuertollegada;
    }

    /**
     * Define el valor de la propiedad kPuertollegada.
     * 
     */
    public void setKPuertollegada(long value) {
        this.kPuertollegada = value;
    }

    /**
     * Obtiene el valor de la propiedad kPuertosalida.
     * 
     */
    public long getKPuertosalida() {
        return kPuertosalida;
    }

    /**
     * Define el valor de la propiedad kPuertosalida.
     * 
     */
    public void setKPuertosalida(long value) {
        this.kPuertosalida = value;
    }

    /**
     * Obtiene el valor de la propiedad kReserva.
     * 
     */
    public long getKReserva() {
        return kReserva;
    }

    /**
     * Define el valor de la propiedad kReserva.
     * 
     */
    public void setKReserva(long value) {
        this.kReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad kTipoid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKTipoid() {
        return kTipoid;
    }

    /**
     * Define el valor de la propiedad kTipoid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKTipoid(String value) {
        this.kTipoid = value;
    }

}
