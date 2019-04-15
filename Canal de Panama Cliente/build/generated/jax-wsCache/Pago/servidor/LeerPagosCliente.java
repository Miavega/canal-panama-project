
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para leerPagosCliente complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="leerPagosCliente"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="k_identificacion" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_tipoid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leerPagosCliente", propOrder = {
    "kIdentificacion",
    "kTipoid"
})
public class LeerPagosCliente {

    @XmlElement(name = "k_identificacion")
    protected long kIdentificacion;
    @XmlElement(name = "k_tipoid")
    protected String kTipoid;

    /**
     * Obtiene el valor de la propiedad kIdentificacion.
     * 
     */
    public long getKIdentificacion() {
        return kIdentificacion;
    }

    /**
     * Define el valor de la propiedad kIdentificacion.
     * 
     */
    public void setKIdentificacion(long value) {
        this.kIdentificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad kTipoid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKTipoid() {
        return kTipoid;
    }

    /**
     * Define el valor de la propiedad kTipoid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKTipoid(String value) {
        this.kTipoid = value;
    }

}
