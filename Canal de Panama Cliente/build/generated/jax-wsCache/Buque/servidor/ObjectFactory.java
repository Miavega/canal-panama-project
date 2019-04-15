
package servidor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servidor package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RHException_QNAME = new QName("http://Servidor/", "RHException");
    private final static QName _CargarBuque_QNAME = new QName("http://Servidor/", "cargarBuque");
    private final static QName _CargarBuqueResponse_QNAME = new QName("http://Servidor/", "cargarBuqueResponse");
    private final static QName _CargarBuques_QNAME = new QName("http://Servidor/", "cargarBuques");
    private final static QName _CargarBuquesResponse_QNAME = new QName("http://Servidor/", "cargarBuquesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servidor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RHException }
     * 
     */
    public RHException createRHException() {
        return new RHException();
    }

    /**
     * Create an instance of {@link CargarBuque }
     * 
     */
    public CargarBuque createCargarBuque() {
        return new CargarBuque();
    }

    /**
     * Create an instance of {@link CargarBuqueResponse }
     * 
     */
    public CargarBuqueResponse createCargarBuqueResponse() {
        return new CargarBuqueResponse();
    }

    /**
     * Create an instance of {@link CargarBuques }
     * 
     */
    public CargarBuques createCargarBuques() {
        return new CargarBuques();
    }

    /**
     * Create an instance of {@link CargarBuquesResponse }
     * 
     */
    public CargarBuquesResponse createCargarBuquesResponse() {
        return new CargarBuquesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RHException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "RHException")
    public JAXBElement<RHException> createRHException(RHException value) {
        return new JAXBElement<RHException>(_RHException_QNAME, RHException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarBuque }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cargarBuque")
    public JAXBElement<CargarBuque> createCargarBuque(CargarBuque value) {
        return new JAXBElement<CargarBuque>(_CargarBuque_QNAME, CargarBuque.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarBuqueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cargarBuqueResponse")
    public JAXBElement<CargarBuqueResponse> createCargarBuqueResponse(CargarBuqueResponse value) {
        return new JAXBElement<CargarBuqueResponse>(_CargarBuqueResponse_QNAME, CargarBuqueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarBuques }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cargarBuques")
    public JAXBElement<CargarBuques> createCargarBuques(CargarBuques value) {
        return new JAXBElement<CargarBuques>(_CargarBuques_QNAME, CargarBuques.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarBuquesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cargarBuquesResponse")
    public JAXBElement<CargarBuquesResponse> createCargarBuquesResponse(CargarBuquesResponse value) {
        return new JAXBElement<CargarBuquesResponse>(_CargarBuquesResponse_QNAME, CargarBuquesResponse.class, null, value);
    }

}
