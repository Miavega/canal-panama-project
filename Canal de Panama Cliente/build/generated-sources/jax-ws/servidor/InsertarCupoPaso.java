
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarCupoPaso complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarCupoPaso"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_paso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="q_ctotales" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="f_asignacioncupos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarCupoPaso", propOrder = {
    "kPaso",
    "qCtotales",
    "fAsignacioncupos"
})
public class InsertarCupoPaso {

    @XmlElement(name = "k_paso")
    protected String kPaso;
    @XmlElement(name = "q_ctotales")
    protected int qCtotales;
    @XmlElement(name = "f_asignacioncupos")
    protected String fAsignacioncupos;

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

}
