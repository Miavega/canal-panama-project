
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para pujaVO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pujaVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="f_puja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_identificacion" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_puja" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_subasta" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_tipoid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="n_estadopuja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="v_puja" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pujaVO", propOrder = {
    "fPuja",
    "kIdentificacion",
    "kPuja",
    "kSubasta",
    "kTipoid",
    "nEstadopuja",
    "vPuja"
})
public class PujaVO {

    @XmlElement(name = "f_puja")
    protected String fPuja;
    @XmlElement(name = "k_identificacion")
    protected long kIdentificacion;
    @XmlElement(name = "k_puja")
    protected long kPuja;
    @XmlElement(name = "k_subasta")
    protected long kSubasta;
    @XmlElement(name = "k_tipoid")
    protected String kTipoid;
    @XmlElement(name = "n_estadopuja")
    protected String nEstadopuja;
    @XmlElement(name = "v_puja")
    protected long vPuja;

    /**
     * Obtiene el valor de la propiedad fPuja.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFPuja() {
        return fPuja;
    }

    /**
     * Define el valor de la propiedad fPuja.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFPuja(String value) {
        this.fPuja = value;
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
     * Obtiene el valor de la propiedad kPuja.
     * 
     */
    public long getKPuja() {
        return kPuja;
    }

    /**
     * Define el valor de la propiedad kPuja.
     * 
     */
    public void setKPuja(long value) {
        this.kPuja = value;
    }

    /**
     * Obtiene el valor de la propiedad kSubasta.
     * 
     */
    public long getKSubasta() {
        return kSubasta;
    }

    /**
     * Define el valor de la propiedad kSubasta.
     * 
     */
    public void setKSubasta(long value) {
        this.kSubasta = value;
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

    /**
     * Obtiene el valor de la propiedad nEstadopuja.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEstadopuja() {
        return nEstadopuja;
    }

    /**
     * Define el valor de la propiedad nEstadopuja.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEstadopuja(String value) {
        this.nEstadopuja = value;
    }

    /**
     * Obtiene el valor de la propiedad vPuja.
     * 
     */
    public long getVPuja() {
        return vPuja;
    }

    /**
     * Define el valor de la propiedad vPuja.
     * 
     */
    public void setVPuja(long value) {
        this.vPuja = value;
    }

}
