
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
    private final static QName _InsertarCarga_QNAME = new QName("http://Servidor/", "insertarCarga");
    private final static QName _InsertarCargaResponse_QNAME = new QName("http://Servidor/", "insertarCargaResponse");

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
     * Create an instance of {@link InsertarCarga }
     * 
     */
    public InsertarCarga createInsertarCarga() {
        return new InsertarCarga();
    }

    /**
     * Create an instance of {@link InsertarCargaResponse }
     * 
     */
    public InsertarCargaResponse createInsertarCargaResponse() {
        return new InsertarCargaResponse();
    }

    /**
     * Create an instance of {@link CargaVO }
     * 
     */
    public CargaVO createCargaVO() {
        return new CargaVO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarCarga }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertarCarga")
    public JAXBElement<InsertarCarga> createInsertarCarga(InsertarCarga value) {
        return new JAXBElement<InsertarCarga>(_InsertarCarga_QNAME, InsertarCarga.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarCargaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertarCargaResponse")
    public JAXBElement<InsertarCargaResponse> createInsertarCargaResponse(InsertarCargaResponse value) {
        return new JAXBElement<InsertarCargaResponse>(_InsertarCargaResponse_QNAME, InsertarCargaResponse.class, null, value);
    }

}
