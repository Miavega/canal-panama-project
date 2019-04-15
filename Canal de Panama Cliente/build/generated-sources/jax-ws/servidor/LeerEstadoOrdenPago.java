
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para leerEstadoOrdenPago complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="leerEstadoOrdenPago"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_concepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_reserva" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leerEstadoOrdenPago", propOrder = {
    "kConcepto",
    "kReserva"
})
public class LeerEstadoOrdenPago {

    @XmlElement(name = "k_concepto")
    protected String kConcepto;
    @XmlElement(name = "k_reserva")
    protected long kReserva;

    /**
     * Obtiene el valor de la propiedad kConcepto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKConcepto() {
        return kConcepto;
    }

    /**
     * Define el valor de la propiedad kConcepto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKConcepto(String value) {
        this.kConcepto = value;
    }

    /**
     * Obtiene el valor de la propiedad kReserva.
     * 
     */
    public long getKReserva() {
        return kReserva;
    }

    /**
     * Define el valor de la propiedad kReserva.
     * 
     */
    public void setKReserva(long value) {
        this.kReserva = value;
    }

}
