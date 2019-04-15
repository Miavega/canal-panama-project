
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para generarPDFReserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="generarPDFReserva"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_reserva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generarPDFReserva", propOrder = {
    "kReserva"
})
public class GenerarPDFReserva {

    @XmlElement(name = "k_reserva")
    protected int kReserva;

    /**
     * Obtiene el valor de la propiedad kReserva.
     * 
     */
    public int getKReserva() {
        return kReserva;
    }

    /**
     * Define el valor de la propiedad kReserva.
     * 
     */
    public void setKReserva(int value) {
        this.kReserva = value;
    }

}
