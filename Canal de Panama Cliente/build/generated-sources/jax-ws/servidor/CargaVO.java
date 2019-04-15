
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cargaVO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cargaVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="i_lastre" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="i_unidadmedida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_reserva" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="n_tipocarga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="v_peso" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cargaVO", propOrder = {
    "iLastre",
    "iUnidadmedida",
    "kReserva",
    "nTipocarga",
    "vPeso"
})
public class CargaVO {

    @XmlElement(name = "i_lastre")
    protected int iLastre;
    @XmlElement(name = "i_unidadmedida")
    protected String iUnidadmedida;
    @XmlElement(name = "k_reserva")
    protected long kReserva;
    @XmlElement(name = "n_tipocarga")
    protected String nTipocarga;
    @XmlElement(name = "v_peso")
    protected long vPeso;

    /**
     * Obtiene el valor de la propiedad iLastre.
     * 
     */
    public int getILastre() {
        return iLastre;
    }

    /**
     * Define el valor de la propiedad iLastre.
     * 
     */
    public void setILastre(int value) {
        this.iLastre = value;
    }

    /**
     * Obtiene el valor de la propiedad iUnidadmedida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIUnidadmedida() {
        return iUnidadmedida;
    }

    /**
     * Define el valor de la propiedad iUnidadmedida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIUnidadmedida(String value) {
        this.iUnidadmedida = value;
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

    /**
     * Obtiene el valor de la propiedad nTipocarga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNTipocarga() {
        return nTipocarga;
    }

    /**
     * Define el valor de la propiedad nTipocarga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNTipocarga(String value) {
        this.nTipocarga = value;
    }

    /**
     * Obtiene el valor de la propiedad vPeso.
     * 
     */
    public long getVPeso() {
        return vPeso;
    }

    /**
     * Define el valor de la propiedad vPeso.
     * 
     */
    public void setVPeso(long value) {
        this.vPeso = value;
    }

}
