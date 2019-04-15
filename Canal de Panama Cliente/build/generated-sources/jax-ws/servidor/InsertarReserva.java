
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarReserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarReserva"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_buque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_esclusa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_idresponsable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_tiporeserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="i_dirtransito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="f_transito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarReserva", propOrder = {
    "kBuque",
    "kEsclusa",
    "kIdresponsable",
    "kTiporeserva",
    "iDirtransito",
    "fTransito"
})
public class InsertarReserva {

    @XmlElement(name = "k_buque")
    protected String kBuque;
    @XmlElement(name = "k_esclusa")
    protected String kEsclusa;
    @XmlElement(name = "k_idresponsable")
    protected String kIdresponsable;
    @XmlElement(name = "k_tiporeserva")
    protected String kTiporeserva;
    @XmlElement(name = "i_dirtransito")
    protected String iDirtransito;
    @XmlElement(name = "f_transito")
    protected String fTransito;

    /**
     * Obtiene el valor de la propiedad kBuque.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKBuque() {
        return kBuque;
    }

    /**
     * Define el valor de la propiedad kBuque.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKBuque(String value) {
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
     * Obtiene el valor de la propiedad kIdresponsable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKIdresponsable() {
        return kIdresponsable;
    }

    /**
     * Define el valor de la propiedad kIdresponsable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKIdresponsable(String value) {
        this.kIdresponsable = value;
    }

    /**
     * Obtiene el valor de la propiedad kTiporeserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKTiporeserva() {
        return kTiporeserva;
    }

    /**
     * Define el valor de la propiedad kTiporeserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKTiporeserva(String value) {
        this.kTiporeserva = value;
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

}
