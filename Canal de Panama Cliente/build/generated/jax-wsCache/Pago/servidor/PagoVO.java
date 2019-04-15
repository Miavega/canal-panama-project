
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para pagoVO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pagoVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="campoExtra1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="campoExtra2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="campoExtra3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="campoExtra4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="f_pago" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="i_formapago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="k_ordendepago" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="k_pago" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="o_cuentaorigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="v_pago" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagoVO", propOrder = {
    "campoExtra1",
    "campoExtra2",
    "campoExtra3",
    "campoExtra4",
    "fPago",
    "iFormapago",
    "kOrdendepago",
    "kPago",
    "oCuentaorigen",
    "vPago"
})
public class PagoVO {

    protected String campoExtra1;
    protected String campoExtra2;
    protected String campoExtra3;
    protected String campoExtra4;
    @XmlElement(name = "f_pago")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fPago;
    @XmlElement(name = "i_formapago")
    protected String iFormapago;
    @XmlElement(name = "k_ordendepago")
    protected long kOrdendepago;
    @XmlElement(name = "k_pago")
    protected long kPago;
    @XmlElement(name = "o_cuentaorigen")
    protected String oCuentaorigen;
    @XmlElement(name = "v_pago")
    protected long vPago;

    /**
     * Obtiene el valor de la propiedad campoExtra1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampoExtra1() {
        return campoExtra1;
    }

    /**
     * Define el valor de la propiedad campoExtra1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampoExtra1(String value) {
        this.campoExtra1 = value;
    }

    /**
     * Obtiene el valor de la propiedad campoExtra2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampoExtra2() {
        return campoExtra2;
    }

    /**
     * Define el valor de la propiedad campoExtra2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampoExtra2(String value) {
        this.campoExtra2 = value;
    }

    /**
     * Obtiene el valor de la propiedad campoExtra3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampoExtra3() {
        return campoExtra3;
    }

    /**
     * Define el valor de la propiedad campoExtra3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampoExtra3(String value) {
        this.campoExtra3 = value;
    }

    /**
     * Obtiene el valor de la propiedad campoExtra4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampoExtra4() {
        return campoExtra4;
    }

    /**
     * Define el valor de la propiedad campoExtra4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampoExtra4(String value) {
        this.campoExtra4 = value;
    }

    /**
     * Obtiene el valor de la propiedad fPago.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFPago() {
        return fPago;
    }

    /**
     * Define el valor de la propiedad fPago.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFPago(XMLGregorianCalendar value) {
        this.fPago = value;
    }

    /**
     * Obtiene el valor de la propiedad iFormapago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIFormapago() {
        return iFormapago;
    }

    /**
     * Define el valor de la propiedad iFormapago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIFormapago(String value) {
        this.iFormapago = value;
    }

    /**
     * Obtiene el valor de la propiedad kOrdendepago.
     * 
     */
    public long getKOrdendepago() {
        return kOrdendepago;
    }

    /**
     * Define el valor de la propiedad kOrdendepago.
     * 
     */
    public void setKOrdendepago(long value) {
        this.kOrdendepago = value;
    }

    /**
     * Obtiene el valor de la propiedad kPago.
     * 
     */
    public long getKPago() {
        return kPago;
    }

    /**
     * Define el valor de la propiedad kPago.
     * 
     */
    public void setKPago(long value) {
        this.kPago = value;
    }

    /**
     * Obtiene el valor de la propiedad oCuentaorigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOCuentaorigen() {
        return oCuentaorigen;
    }

    /**
     * Define el valor de la propiedad oCuentaorigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOCuentaorigen(String value) {
        this.oCuentaorigen = value;
    }

    /**
     * Obtiene el valor de la propiedad vPago.
     * 
     */
    public long getVPago() {
        return vPago;
    }

    /**
     * Define el valor de la propiedad vPago.
     * 
     */
    public void setVPago(long value) {
        this.vPago = value;
    }

}
