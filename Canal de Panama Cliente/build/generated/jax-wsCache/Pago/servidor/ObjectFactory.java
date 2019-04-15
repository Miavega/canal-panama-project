
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
    private final static QName _GenerarPDFReserva_QNAME = new QName("http://Servidor/", "generarPDFReserva");
    private final static QName _GenerarPDFReservaResponse_QNAME = new QName("http://Servidor/", "generarPDFReservaResponse");
    private final static QName _Hello_QNAME = new QName("http://Servidor/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://Servidor/", "helloResponse");
    private final static QName _LeerPagosCliente_QNAME = new QName("http://Servidor/", "leerPagosCliente");
    private final static QName _LeerPagosClienteResponse_QNAME = new QName("http://Servidor/", "leerPagosClienteResponse");
    private final static QName _LeerPagosCoord_QNAME = new QName("http://Servidor/", "leerPagosCoord");
    private final static QName _LeerPagosCoordResponse_QNAME = new QName("http://Servidor/", "leerPagosCoordResponse");
    private final static QName _PagarOrdenReserva_QNAME = new QName("http://Servidor/", "pagarOrdenReserva");
    private final static QName _PagarOrdenReservaResponse_QNAME = new QName("http://Servidor/", "pagarOrdenReservaResponse");

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
     * Create an instance of {@link GenerarPDFReserva }
     * 
     */
    public GenerarPDFReserva createGenerarPDFReserva() {
        return new GenerarPDFReserva();
    }

    /**
     * Create an instance of {@link GenerarPDFReservaResponse }
     * 
     */
    public GenerarPDFReservaResponse createGenerarPDFReservaResponse() {
        return new GenerarPDFReservaResponse();
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
     * Create an instance of {@link LeerPagosCliente }
     * 
     */
    public LeerPagosCliente createLeerPagosCliente() {
        return new LeerPagosCliente();
    }

    /**
     * Create an instance of {@link LeerPagosClienteResponse }
     * 
     */
    public LeerPagosClienteResponse createLeerPagosClienteResponse() {
        return new LeerPagosClienteResponse();
    }

    /**
     * Create an instance of {@link LeerPagosCoord }
     * 
     */
    public LeerPagosCoord createLeerPagosCoord() {
        return new LeerPagosCoord();
    }

    /**
     * Create an instance of {@link LeerPagosCoordResponse }
     * 
     */
    public LeerPagosCoordResponse createLeerPagosCoordResponse() {
        return new LeerPagosCoordResponse();
    }

    /**
     * Create an instance of {@link PagarOrdenReserva }
     * 
     */
    public PagarOrdenReserva createPagarOrdenReserva() {
        return new PagarOrdenReserva();
    }

    /**
     * Create an instance of {@link PagarOrdenReservaResponse }
     * 
     */
    public PagarOrdenReservaResponse createPagarOrdenReservaResponse() {
        return new PagarOrdenReservaResponse();
    }

    /**
     * Create an instance of {@link PagoVO }
     * 
     */
    public PagoVO createPagoVO() {
        return new PagoVO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarPDFReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "generarPDFReserva")
    public JAXBElement<GenerarPDFReserva> createGenerarPDFReserva(GenerarPDFReserva value) {
        return new JAXBElement<GenerarPDFReserva>(_GenerarPDFReserva_QNAME, GenerarPDFReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerarPDFReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "generarPDFReservaResponse")
    public JAXBElement<GenerarPDFReservaResponse> createGenerarPDFReservaResponse(GenerarPDFReservaResponse value) {
        return new JAXBElement<GenerarPDFReservaResponse>(_GenerarPDFReservaResponse_QNAME, GenerarPDFReservaResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerPagosCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerPagosCliente")
    public JAXBElement<LeerPagosCliente> createLeerPagosCliente(LeerPagosCliente value) {
        return new JAXBElement<LeerPagosCliente>(_LeerPagosCliente_QNAME, LeerPagosCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerPagosClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerPagosClienteResponse")
    public JAXBElement<LeerPagosClienteResponse> createLeerPagosClienteResponse(LeerPagosClienteResponse value) {
        return new JAXBElement<LeerPagosClienteResponse>(_LeerPagosClienteResponse_QNAME, LeerPagosClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerPagosCoord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerPagosCoord")
    public JAXBElement<LeerPagosCoord> createLeerPagosCoord(LeerPagosCoord value) {
        return new JAXBElement<LeerPagosCoord>(_LeerPagosCoord_QNAME, LeerPagosCoord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerPagosCoordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerPagosCoordResponse")
    public JAXBElement<LeerPagosCoordResponse> createLeerPagosCoordResponse(LeerPagosCoordResponse value) {
        return new JAXBElement<LeerPagosCoordResponse>(_LeerPagosCoordResponse_QNAME, LeerPagosCoordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagarOrdenReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "pagarOrdenReserva")
    public JAXBElement<PagarOrdenReserva> createPagarOrdenReserva(PagarOrdenReserva value) {
        return new JAXBElement<PagarOrdenReserva>(_PagarOrdenReserva_QNAME, PagarOrdenReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PagarOrdenReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "pagarOrdenReservaResponse")
    public JAXBElement<PagarOrdenReservaResponse> createPagarOrdenReservaResponse(PagarOrdenReservaResponse value) {
        return new JAXBElement<PagarOrdenReservaResponse>(_PagarOrdenReservaResponse_QNAME, PagarOrdenReservaResponse.class, null, value);
    }

}
