
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
    private final static QName _CrearPuja_QNAME = new QName("http://Servidor/", "crearPuja");
    private final static QName _CrearPujaResponse_QNAME = new QName("http://Servidor/", "crearPujaResponse");
    private final static QName _Hello_QNAME = new QName("http://Servidor/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://Servidor/", "helloResponse");
    private final static QName _LeerMisPujas_QNAME = new QName("http://Servidor/", "leerMisPujas");
    private final static QName _LeerMisPujasResponse_QNAME = new QName("http://Servidor/", "leerMisPujasResponse");

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
     * Create an instance of {@link CrearPuja }
     * 
     */
    public CrearPuja createCrearPuja() {
        return new CrearPuja();
    }

    /**
     * Create an instance of {@link CrearPujaResponse }
     * 
     */
    public CrearPujaResponse createCrearPujaResponse() {
        return new CrearPujaResponse();
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
     * Create an instance of {@link LeerMisPujas }
     * 
     */
    public LeerMisPujas createLeerMisPujas() {
        return new LeerMisPujas();
    }

    /**
     * Create an instance of {@link LeerMisPujasResponse }
     * 
     */
    public LeerMisPujasResponse createLeerMisPujasResponse() {
        return new LeerMisPujasResponse();
    }

    /**
     * Create an instance of {@link PujaVO }
     * 
     */
    public PujaVO createPujaVO() {
        return new PujaVO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearPuja }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "crearPuja")
    public JAXBElement<CrearPuja> createCrearPuja(CrearPuja value) {
        return new JAXBElement<CrearPuja>(_CrearPuja_QNAME, CrearPuja.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearPujaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "crearPujaResponse")
    public JAXBElement<CrearPujaResponse> createCrearPujaResponse(CrearPujaResponse value) {
        return new JAXBElement<CrearPujaResponse>(_CrearPujaResponse_QNAME, CrearPujaResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerMisPujas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerMisPujas")
    public JAXBElement<LeerMisPujas> createLeerMisPujas(LeerMisPujas value) {
        return new JAXBElement<LeerMisPujas>(_LeerMisPujas_QNAME, LeerMisPujas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerMisPujasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerMisPujasResponse")
    public JAXBElement<LeerMisPujasResponse> createLeerMisPujasResponse(LeerMisPujasResponse value) {
        return new JAXBElement<LeerMisPujasResponse>(_LeerMisPujasResponse_QNAME, LeerMisPujasResponse.class, null, value);
    }

}
