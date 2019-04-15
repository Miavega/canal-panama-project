
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
    private final static QName _Hello_QNAME = new QName("http://Servidor/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://Servidor/", "helloResponse");
    private final static QName _LeerPuertoPorID_QNAME = new QName("http://Servidor/", "leerPuertoPorID");
    private final static QName _LeerPuertoPorIDResponse_QNAME = new QName("http://Servidor/", "leerPuertoPorIDResponse");
    private final static QName _LeerPuertos_QNAME = new QName("http://Servidor/", "leerPuertos");
    private final static QName _LeerPuertosResponse_QNAME = new QName("http://Servidor/", "leerPuertosResponse");

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
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link LeerPuertoPorID }
     * 
     */
    public LeerPuertoPorID createLeerPuertoPorID() {
        return new LeerPuertoPorID();
    }

    /**
     * Create an instance of {@link LeerPuertoPorIDResponse }
     * 
     */
    public LeerPuertoPorIDResponse createLeerPuertoPorIDResponse() {
        return new LeerPuertoPorIDResponse();
    }

    /**
     * Create an instance of {@link LeerPuertos }
     * 
     */
    public LeerPuertos createLeerPuertos() {
        return new LeerPuertos();
    }

    /**
     * Create an instance of {@link LeerPuertosResponse }
     * 
     */
    public LeerPuertosResponse createLeerPuertosResponse() {
        return new LeerPuertosResponse();
    }

    /**
     * Create an instance of {@link PuertoVO }
     * 
     */
    public PuertoVO createPuertoVO() {
        return new PuertoVO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerPuertoPorID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerPuertoPorID")
    public JAXBElement<LeerPuertoPorID> createLeerPuertoPorID(LeerPuertoPorID value) {
        return new JAXBElement<LeerPuertoPorID>(_LeerPuertoPorID_QNAME, LeerPuertoPorID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerPuertoPorIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerPuertoPorIDResponse")
    public JAXBElement<LeerPuertoPorIDResponse> createLeerPuertoPorIDResponse(LeerPuertoPorIDResponse value) {
        return new JAXBElement<LeerPuertoPorIDResponse>(_LeerPuertoPorIDResponse_QNAME, LeerPuertoPorIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerPuertos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerPuertos")
    public JAXBElement<LeerPuertos> createLeerPuertos(LeerPuertos value) {
        return new JAXBElement<LeerPuertos>(_LeerPuertos_QNAME, LeerPuertos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerPuertosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerPuertosResponse")
    public JAXBElement<LeerPuertosResponse> createLeerPuertosResponse(LeerPuertosResponse value) {
        return new JAXBElement<LeerPuertosResponse>(_LeerPuertosResponse_QNAME, LeerPuertosResponse.class, null, value);
    }

}
