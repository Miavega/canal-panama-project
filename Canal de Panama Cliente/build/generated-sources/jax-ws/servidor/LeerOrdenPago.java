
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para leerOrdenPago complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="leerOrdenPago"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_reserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_concepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leerOrdenPago", propOrder = {
    "kReserva",
    "kConcepto"
})
public class LeerOrdenPago {

    @XmlElement(name = "k_reserva")
    protected String kReserva;
    @XmlElement(name = "k_concepto")
    protected String kConcepto;

    /**
     * Obtiene el valor de la propiedad kReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKReserva() {
        return kReserva;
    }

    /**
     * Define el valor de la propiedad kReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKReserva(String value) {
        this.kReserva = value;
    }

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

}
