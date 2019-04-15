
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para pagarReserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pagarReserva"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pk_crn" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="pv_pagar" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagarReserva", propOrder = {
    "pkCrn",
    "pvPagar"
})
public class PagarReserva {

    @XmlElement(name = "pk_crn")
    protected long pkCrn;
    @XmlElement(name = "pv_pagar")
    protected long pvPagar;

    /**
     * Obtiene el valor de la propiedad pkCrn.
     * 
     */
    public long getPkCrn() {
        return pkCrn;
    }

    /**
     * Define el valor de la propiedad pkCrn.
     * 
     */
    public void setPkCrn(long value) {
        this.pkCrn = value;
    }

    /**
     * Obtiene el valor de la propiedad pvPagar.
     * 
     */
    public long getPvPagar() {
        return pvPagar;
    }

    /**
     * Define el valor de la propiedad pvPagar.
     * 
     */
    public void setPvPagar(long value) {
        this.pvPagar = value;
    }

}
