
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
    private final static QName _LeerEstadoOrdenPago_QNAME = new QName("http://Servidor/", "leerEstadoOrdenPago");
    private final static QName _LeerEstadoOrdenPagoResponse_QNAME = new QName("http://Servidor/", "leerEstadoOrdenPagoResponse");
    private final static QName _LeerOrdenPago_QNAME = new QName("http://Servidor/", "leerOrdenPago");
    private final static QName _LeerOrdenPagoResponse_QNAME = new QName("http://Servidor/", "leerOrdenPagoResponse");

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
     * Create an instance of {@link LeerEstadoOrdenPago }
     * 
     */
    public LeerEstadoOrdenPago createLeerEstadoOrdenPago() {
        return new LeerEstadoOrdenPago();
    }

    /**
     * Create an instance of {@link LeerEstadoOrdenPagoResponse }
     * 
     */
    public LeerEstadoOrdenPagoResponse createLeerEstadoOrdenPagoResponse() {
        return new LeerEstadoOrdenPagoResponse();
    }

    /**
     * Create an instance of {@link LeerOrdenPago }
     * 
     */
    public LeerOrdenPago createLeerOrdenPago() {
        return new LeerOrdenPago();
    }

    /**
     * Create an instance of {@link LeerOrdenPagoResponse }
     * 
     */
    public LeerOrdenPagoResponse createLeerOrdenPagoResponse() {
        return new LeerOrdenPagoResponse();
    }

    /**
     * Create an instance of {@link OrdenPagoVO }
     * 
     */
    public OrdenPagoVO createOrdenPagoVO() {
        return new OrdenPagoVO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerEstadoOrdenPago }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerEstadoOrdenPago")
    public JAXBElement<LeerEstadoOrdenPago> createLeerEstadoOrdenPago(LeerEstadoOrdenPago value) {
        return new JAXBElement<LeerEstadoOrdenPago>(_LeerEstadoOrdenPago_QNAME, LeerEstadoOrdenPago.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerEstadoOrdenPagoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerEstadoOrdenPagoResponse")
    public JAXBElement<LeerEstadoOrdenPagoResponse> createLeerEstadoOrdenPagoResponse(LeerEstadoOrdenPagoResponse value) {
        return new JAXBElement<LeerEstadoOrdenPagoResponse>(_LeerEstadoOrdenPagoResponse_QNAME, LeerEstadoOrdenPagoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerOrdenPago }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerOrdenPago")
    public JAXBElement<LeerOrdenPago> createLeerOrdenPago(LeerOrdenPago value) {
        return new JAXBElement<LeerOrdenPago>(_LeerOrdenPago_QNAME, LeerOrdenPago.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerOrdenPagoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerOrdenPagoResponse")
    public JAXBElement<LeerOrdenPagoResponse> createLeerOrdenPagoResponse(LeerOrdenPagoResponse value) {
        return new JAXBElement<LeerOrdenPagoResponse>(_LeerOrdenPagoResponse_QNAME, LeerOrdenPagoResponse.class, null, value);
    }

}
