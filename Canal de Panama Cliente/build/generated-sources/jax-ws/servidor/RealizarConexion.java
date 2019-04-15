
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para realizarConexion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="realizarConexion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "realizarConexion", propOrder = {
    "usu",
    "pas"
})
public class RealizarConexion {

    protected String usu;
    protected String pas;

    /**
     * Obtiene el valor de la propiedad usu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsu() {
        return usu;
    }

    /**
     * Define el valor de la propiedad usu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsu(String value) {
        this.usu = value;
    }

    /**
     * Obtiene el valor de la propiedad pas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPas() {
        return pas;
    }

    /**
     * Define el valor de la propiedad pas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPas(String value) {
        this.pas = value;
    }

}
