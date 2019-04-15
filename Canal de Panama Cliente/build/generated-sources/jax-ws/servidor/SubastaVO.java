
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para subastaVO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="subastaVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="f_aperturasubasta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="f_cuposubasta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="f_vencimientosubasta" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="k_subasta" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="v_incrementominimo" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="v_pujainicial" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subastaVO", propOrder = {
    "fAperturasubasta",
    "fCuposubasta",
    "fVencimientosubasta",
    "kSubasta",
    "vIncrementominimo",
    "vPujainicial"
})
public class SubastaVO {

    @XmlElement(name = "f_aperturasubasta")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fAperturasubasta;
    @XmlElement(name = "f_cuposubasta")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fCuposubasta;
    @XmlElement(name = "f_vencimientosubasta")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fVencimientosubasta;
    @XmlElement(name = "k_subasta")
    protected long kSubasta;
    @XmlElement(name = "v_incrementominimo")
    protected long vIncrementominimo;
    @XmlElement(name = "v_pujainicial")
    protected long vPujainicial;

    /**
     * Obtiene el valor de la propiedad fAperturasubasta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFAperturasubasta() {
        return fAperturasubasta;
    }

    /**
     * Define el valor de la propiedad fAperturasubasta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFAperturasubasta(XMLGregorianCalendar value) {
        this.fAperturasubasta = value;
    }

    /**
     * Obtiene el valor de la propiedad fCuposubasta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFCuposubasta() {
        return fCuposubasta;
    }

    /**
     * Define el valor de la propiedad fCuposubasta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFCuposubasta(XMLGregorianCalendar value) {
        this.fCuposubasta = value;
    }

    /**
     * Obtiene el valor de la propiedad fVencimientosubasta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFVencimientosubasta() {
        return fVencimientosubasta;
    }

    /**
     * Define el valor de la propiedad fVencimientosubasta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFVencimientosubasta(XMLGregorianCalendar value) {
        this.fVencimientosubasta = value;
    }

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

    /**
     * Obtiene el valor de la propiedad vIncrementominimo.
     * 
     */
    public long getVIncrementominimo() {
        return vIncrementominimo;
    }

    /**
     * Define el valor de la propiedad vIncrementominimo.
     * 
     */
    public void setVIncrementominimo(long value) {
        this.vIncrementominimo = value;
    }

    /**
     * Obtiene el valor de la propiedad vPujainicial.
     * 
     */
    public long getVPujainicial() {
        return vPujainicial;
    }

    /**
     * Define el valor de la propiedad vPujainicial.
     * 
     */
    public void setVPujainicial(long value) {
        this.vPujainicial = value;
    }

}
