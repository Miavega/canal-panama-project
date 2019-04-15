
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cargarBuque complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cargarBuque"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_buque" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cargarBuque", propOrder = {
    "kBuque"
})
public class CargarBuque {

    @XmlElement(name = "k_buque")
    protected int kBuque;

    /**
     * Obtiene el valor de la propiedad kBuque.
     * 
     */
    public int getKBuque() {
        return kBuque;
    }

    /**
     * Define el valor de la propiedad kBuque.
     * 
     */
    public void setKBuque(int value) {
        this.kBuque = value;
    }

}
