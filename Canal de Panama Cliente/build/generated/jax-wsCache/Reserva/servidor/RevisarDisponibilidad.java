
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para revisarDisponibilidad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="revisarDisponibilidad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_buque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "revisarDisponibilidad", propOrder = {
    "kBuque",
    "fAsignacioncupos"
})
public class RevisarDisponibilidad {

    @XmlElement(name = "k_buque")
    protected String kBuque;
    @XmlElement(name = "f_asignacioncupos")
    protected String fAsignacioncupos;

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
