
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para leerCupos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="leerCupos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_paso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="f_asignacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leerCupos", propOrder = {
    "kPaso",
    "fAsignacion"
})
public class LeerCupos {

    @XmlElement(name = "k_paso")
    protected String kPaso;
    @XmlElement(name = "f_asignacion")
    protected String fAsignacion;

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
     * Obtiene el valor de la propiedad fAsignacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFAsignacion() {
        return fAsignacion;
    }

    /**
     * Define el valor de la propiedad fAsignacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFAsignacion(String value) {
        this.fAsignacion = value;
    }

}
