
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para leerPuertoPorID complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="leerPuertoPorID"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_buque" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leerPuertoPorID", propOrder = {
    "kBuque"
})
public class LeerPuertoPorID {

    @XmlElement(name = "k_buque")
    protected Long kBuque;

    /**
     * Obtiene el valor de la propiedad kBuque.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getKBuque() {
        return kBuque;
    }

    /**
     * Define el valor de la propiedad kBuque.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setKBuque(Long value) {
        this.kBuque = value;
    }

}
