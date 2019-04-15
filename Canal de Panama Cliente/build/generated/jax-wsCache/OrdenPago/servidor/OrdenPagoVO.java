
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ordenPagoVO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ordenPagoVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="f_emision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="f_maxpago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_concepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_ordendepago" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_reserva" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="n_estadopago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="v_ordendepago" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ordenPagoVO", propOrder = {
    "fEmision",
    "fMaxpago",
    "kConcepto",
    "kOrdendepago",
    "kReserva",
    "nEstadopago",
    "vOrdendepago"
})
public class OrdenPagoVO {

    @XmlElement(name = "f_emision")
    protected String fEmision;
    @XmlElement(name = "f_maxpago")
    protected String fMaxpago;
    @XmlElement(name = "k_concepto")
    protected String kConcepto;
    @XmlElement(name = "k_ordendepago")
    protected long kOrdendepago;
    @XmlElement(name = "k_reserva")
    protected long kReserva;
    @XmlElement(name = "n_estadopago")
    protected String nEstadopago;
    @XmlElement(name = "v_ordendepago")
    protected long vOrdendepago;

    /**
     * Obtiene el valor de la propiedad fEmision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEmision() {
        return fEmision;
    }

    /**
     * Define el valor de la propiedad fEmision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEmision(String value) {
        this.fEmision = value;
    }

    /**
     * Obtiene el valor de la propiedad fMaxpago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFMaxpago() {
        return fMaxpago;
    }

    /**
     * Define el valor de la propiedad fMaxpago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFMaxpago(String value) {
        this.fMaxpago = value;
    }

    /**
     * Obtiene el valor de la propiedad kConcepto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKConcepto() {
        return kConcepto;
    }

    /**
     * Define el valor de la propiedad kConcepto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKConcepto(String value) {
        this.kConcepto = value;
    }

    /**
     * Obtiene el valor de la propiedad kOrdendepago.
     * 
     */
    public long getKOrdendepago() {
        return kOrdendepago;
    }

    /**
     * Define el valor de la propiedad kOrdendepago.
     * 
     */
    public void setKOrdendepago(long value) {
        this.kOrdendepago = value;
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
     * Obtiene el valor de la propiedad nEstadopago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEstadopago() {
        return nEstadopago;
    }

    /**
     * Define el valor de la propiedad nEstadopago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEstadopago(String value) {
        this.nEstadopago = value;
    }

    /**
     * Obtiene el valor de la propiedad vOrdendepago.
     * 
     */
    public long getVOrdendepago() {
        return vOrdendepago;
    }

    /**
     * Define el valor de la propiedad vOrdendepago.
     * 
     */
    public void setVOrdendepago(long value) {
        this.vOrdendepago = value;
    }

}
