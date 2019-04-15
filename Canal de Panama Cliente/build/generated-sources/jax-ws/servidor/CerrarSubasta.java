
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cerrarSubasta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cerrarSubasta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_subasta" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cerrarSubasta", propOrder = {
    "kSubasta"
})
public class CerrarSubasta {

    @XmlElement(name = "k_subasta")
    protected long kSubasta;

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

}
