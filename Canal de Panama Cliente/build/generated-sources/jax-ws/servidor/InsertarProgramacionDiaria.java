
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertarProgramacionDiaria complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertarProgramacionDiaria"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="kreservas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="puertosS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="puertosL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="horasS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="horasL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertarProgramacionDiaria", propOrder = {
    "kreservas",
    "puertosS",
    "puertosL",
    "horasS",
    "horasL",
    "fecha"
})
public class InsertarProgramacionDiaria {

    @XmlElement(nillable = true)
    protected List<String> kreservas;
    @XmlElement(nillable = true)
    protected List<String> puertosS;
    @XmlElement(nillable = true)
    protected List<String> puertosL;
    @XmlElement(nillable = true)
    protected List<String> horasS;
    @XmlElement(nillable = true)
    protected List<String> horasL;
    protected String fecha;

    /**
     * Gets the value of the kreservas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kreservas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKreservas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKreservas() {
        if (kreservas == null) {
            kreservas = new ArrayList<String>();
        }
        return this.kreservas;
    }

    /**
     * Gets the value of the puertosS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the puertosS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPuertosS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPuertosS() {
        if (puertosS == null) {
            puertosS = new ArrayList<String>();
        }
        return this.puertosS;
    }

    /**
     * Gets the value of the puertosL property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the puertosL property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPuertosL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPuertosL() {
        if (puertosL == null) {
            puertosL = new ArrayList<String>();
        }
        return this.puertosL;
    }

    /**
     * Gets the value of the horasS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the horasS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHorasS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getHorasS() {
        if (horasS == null) {
            horasS = new ArrayList<String>();
        }
        return this.horasS;
    }

    /**
     * Gets the value of the horasL property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the horasL property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHorasL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getHorasL() {
        if (horasL == null) {
            horasL = new ArrayList<String>();
        }
        return this.horasL;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

}
