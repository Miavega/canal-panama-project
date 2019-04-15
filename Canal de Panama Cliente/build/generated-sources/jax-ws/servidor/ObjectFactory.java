
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
    private final static QName _InsertTransitoR_QNAME = new QName("http://Servidor/", "insertTransitoR");
    private final static QName _InsertTransitoRResponse_QNAME = new QName("http://Servidor/", "insertTransitoRResponse");

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
     * Create an instance of {@link InsertTransitoR }
     * 
     */
    public InsertTransitoR createInsertTransitoR() {
        return new InsertTransitoR();
    }

    /**
     * Create an instance of {@link InsertTransitoRResponse }
     * 
     */
    public InsertTransitoRResponse createInsertTransitoRResponse() {
        return new InsertTransitoRResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertTransitoR }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertTransitoR")
    public JAXBElement<InsertTransitoR> createInsertTransitoR(InsertTransitoR value) {
        return new JAXBElement<InsertTransitoR>(_InsertTransitoR_QNAME, InsertTransitoR.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertTransitoRResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertTransitoRResponse")
    public JAXBElement<InsertTransitoRResponse> createInsertTransitoRResponse(InsertTransitoRResponse value) {
        return new JAXBElement<InsertTransitoRResponse>(_InsertTransitoRResponse_QNAME, InsertTransitoRResponse.class, null, value);
    }

}
