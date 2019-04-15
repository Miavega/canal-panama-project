
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para reservaVO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="reservaVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="f_reserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="f_transito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="i_dirtransito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="i_tiporeserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_buque" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_esclusa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_estadoreserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_identificacion" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
@XmlType(name = "reservaVO", propOrder = {
    "fReserva",
    "fTransito",
    "iDirtransito",
    "iTiporeserva",
    "kBuque",
    "kEsclusa",
    "kEstadoreserva",
    "kIdentificacion",
    "kReserva",
    "kTipoid"
})
public class ReservaVO {

    @XmlElement(name = "f_reserva")
    protected String fReserva;
    @XmlElement(name = "f_transito")
    protected String fTransito;
    @XmlElement(name = "i_dirtransito")
    protected String iDirtransito;
    @XmlElement(name = "i_tiporeserva")
    protected String iTiporeserva;
    @XmlElement(name = "k_buque")
    protected long kBuque;
    @XmlElement(name = "k_esclusa")
    protected String kEsclusa;
    @XmlElement(name = "k_estadoreserva")
    protected String kEstadoreserva;
    @XmlElement(name = "k_identificacion")
    protected long kIdentificacion;
    @XmlElement(name = "k_reserva")
    protected long kReserva;
    @XmlElement(name = "k_tipoid")
    protected String kTipoid;

    /**
     * Obtiene el valor de la propiedad fReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFReserva() {
        return fReserva;
    }

    /**
     * Define el valor de la propiedad fReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFReserva(String value) {
        this.fReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad fTransito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTransito() {
        return fTransito;
    }

    /**
     * Define el valor de la propiedad fTransito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTransito(String value) {
        this.fTransito = value;
    }

    /**
     * Obtiene el valor de la propiedad iDirtransito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDirtransito() {
        return iDirtransito;
    }

    /**
     * Define el valor de la propiedad iDirtransito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDirtransito(String value) {
        this.iDirtransito = value;
    }

    /**
     * Obtiene el valor de la propiedad iTiporeserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITiporeserva() {
        return iTiporeserva;
    }

    /**
     * Define el valor de la propiedad iTiporeserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITiporeserva(String value) {
        this.iTiporeserva = value;
    }

    /**
     * Obtiene el valor de la propiedad kBuque.
     * 
     */
    public long getKBuque() {
        return kBuque;
    }

    /**
     * Define el valor de la propiedad kBuque.
     * 
     */
    public void setKBuque(long value) {
        this.kBuque = value;
    }

    /**
     * Obtiene el valor de la propiedad kEsclusa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKEsclusa() {
        return kEsclusa;
    }

    /**
     * Define el valor de la propiedad kEsclusa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKEsclusa(String value) {
        this.kEsclusa = value;
    }

    /**
     * Obtiene el valor de la propiedad kEstadoreserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKEstadoreserva() {
        return kEstadoreserva;
    }

    /**
     * Define el valor de la propiedad kEstadoreserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKEstadoreserva(String value) {
        this.kEstadoreserva = value;
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
