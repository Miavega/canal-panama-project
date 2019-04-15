
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
    private final static QName _CerrarConexion_QNAME = new QName("http://Servidor/", "cerrarConexion");
    private final static QName _CerrarConexionResponse_QNAME = new QName("http://Servidor/", "cerrarConexionResponse");
    private final static QName _RealizarConexion_QNAME = new QName("http://Servidor/", "realizarConexion");
    private final static QName _RealizarConexionResponse_QNAME = new QName("http://Servidor/", "realizarConexionResponse");

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
     * Create an instance of {@link CerrarConexion }
     * 
     */
    public CerrarConexion createCerrarConexion() {
        return new CerrarConexion();
    }

    /**
     * Create an instance of {@link CerrarConexionResponse }
     * 
     */
    public CerrarConexionResponse createCerrarConexionResponse() {
        return new CerrarConexionResponse();
    }

    /**
     * Create an instance of {@link RealizarConexion }
     * 
     */
    public RealizarConexion createRealizarConexion() {
        return new RealizarConexion();
    }

    /**
     * Create an instance of {@link RealizarConexionResponse }
     * 
     */
    public RealizarConexionResponse createRealizarConexionResponse() {
        return new RealizarConexionResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CerrarConexion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cerrarConexion")
    public JAXBElement<CerrarConexion> createCerrarConexion(CerrarConexion value) {
        return new JAXBElement<CerrarConexion>(_CerrarConexion_QNAME, CerrarConexion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CerrarConexionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cerrarConexionResponse")
    public JAXBElement<CerrarConexionResponse> createCerrarConexionResponse(CerrarConexionResponse value) {
        return new JAXBElement<CerrarConexionResponse>(_CerrarConexionResponse_QNAME, CerrarConexionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarConexion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "realizarConexion")
    public JAXBElement<RealizarConexion> createRealizarConexion(RealizarConexion value) {
        return new JAXBElement<RealizarConexion>(_RealizarConexion_QNAME, RealizarConexion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RealizarConexionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "realizarConexionResponse")
    public JAXBElement<RealizarConexionResponse> createRealizarConexionResponse(RealizarConexionResponse value) {
        return new JAXBElement<RealizarConexionResponse>(_RealizarConexionResponse_QNAME, RealizarConexionResponse.class, null, value);
    }

}
