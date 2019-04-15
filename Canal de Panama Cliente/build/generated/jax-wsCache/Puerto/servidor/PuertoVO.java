
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para puertoVO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="puertoVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_puerto" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="n_puerto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "puertoVO", propOrder = {
    "kPuerto",
    "nPuerto"
})
public class PuertoVO {

    @XmlElement(name = "k_puerto")
    protected long kPuerto;
    @XmlElement(name = "n_puerto")
    protected String nPuerto;

    /**
     * Obtiene el valor de la propiedad kPuerto.
     * 
     */
    public long getKPuerto() {
        return kPuerto;
    }

    /**
     * Define el valor de la propiedad kPuerto.
     * 
     */
    public void setKPuerto(long value) {
        this.kPuerto = value;
    }

    /**
     * Obtiene el valor de la propiedad nPuerto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNPuerto() {
        return nPuerto;
    }

    /**
     * Define el valor de la propiedad nPuerto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNPuerto(String value) {
        this.nPuerto = value;
    }

}
