
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cupoPasoVO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cupoPasoVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="f_asignacioncupos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_cupopaso" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_paso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="q_cdisponibles" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="q_ctotales" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cupoPasoVO", propOrder = {
    "fAsignacioncupos",
    "kCupopaso",
    "kPaso",
    "qCdisponibles",
    "qCtotales"
})
public class CupoPasoVO {

    @XmlElement(name = "f_asignacioncupos")
    protected String fAsignacioncupos;
    @XmlElement(name = "k_cupopaso")
    protected long kCupopaso;
    @XmlElement(name = "k_paso")
    protected String kPaso;
    @XmlElement(name = "q_cdisponibles")
    protected int qCdisponibles;
    @XmlElement(name = "q_ctotales")
    protected int qCtotales;

    /**
     * Obtiene el valor de la propiedad fAsignacioncupos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAsignacioncupos() {
        return fAsignacioncupos;
    }

    /**
     * Define el valor de la propiedad fAsignacioncupos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAsignacioncupos(String value) {
        this.fAsignacioncupos = value;
    }

    /**
     * Obtiene el valor de la propiedad kCupopaso.
     * 
     */
    public long getKCupopaso() {
        return kCupopaso;
    }

    /**
     * Define el valor de la propiedad kCupopaso.
     * 
     */
    public void setKCupopaso(long value) {
        this.kCupopaso = value;
    }

    /**
     * Obtiene el valor de la propiedad kPaso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKPaso() {
        return kPaso;
    }

    /**
     * Define el valor de la propiedad kPaso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKPaso(String value) {
        this.kPaso = value;
    }

    /**
     * Obtiene el valor de la propiedad qCdisponibles.
     * 
     */
    public int getQCdisponibles() {
        return qCdisponibles;
    }

    /**
     * Define el valor de la propiedad qCdisponibles.
     * 
     */
    public void setQCdisponibles(int value) {
        this.qCdisponibles = value;
    }

    /**
     * Obtiene el valor de la propiedad qCtotales.
     * 
     */
    public int getQCtotales() {
        return qCtotales;
    }

    /**
     * Define el valor de la propiedad qCtotales.
     * 
     */
    public void setQCtotales(int value) {
        this.qCtotales = value;
    }

}
