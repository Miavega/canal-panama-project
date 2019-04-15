
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para leerProgramacionDiaria complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="leerProgramacionDiaria"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="f_transito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leerProgramacionDiaria", propOrder = {
    "fTransito"
})
public class LeerProgramacionDiaria {

    @XmlElement(name = "f_transito")
    protected String fTransito;

    /**
     * Obtiene el valor de la propiedad fTransito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTransito() {
        return fTransito;
    }

    /**
     * Define el valor de la propiedad fTransito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTransito(String value) {
        this.fTransito = value;
    }

}
