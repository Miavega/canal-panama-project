
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

    private final static QName _ParseException_QNAME = new QName("http://Servidor/", "ParseException");
    private final static QName _RHException_QNAME = new QName("http://Servidor/", "RHException");
    private final static QName _InsertarProgramacionDiaria_QNAME = new QName("http://Servidor/", "insertarProgramacionDiaria");
    private final static QName _InsertarProgramacionDiariaResponse_QNAME = new QName("http://Servidor/", "insertarProgramacionDiariaResponse");
    private final static QName _LeerProgramacionDiaria_QNAME = new QName("http://Servidor/", "leerProgramacionDiaria");
    private final static QName _LeerProgramacionDiariaResponse_QNAME = new QName("http://Servidor/", "leerProgramacionDiariaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servidor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ParseException }
     * 
     */
    public ParseException createParseException() {
        return new ParseException();
    }

    /**
     * Create an instance of {@link RHException }
     * 
     */
    public RHException createRHException() {
        return new RHException();
    }

    /**
     * Create an instance of {@link InsertarProgramacionDiaria }
     * 
     */
    public InsertarProgramacionDiaria createInsertarProgramacionDiaria() {
        return new InsertarProgramacionDiaria();
    }

    /**
     * Create an instance of {@link InsertarProgramacionDiariaResponse }
     * 
     */
    public InsertarProgramacionDiariaResponse createInsertarProgramacionDiariaResponse() {
        return new InsertarProgramacionDiariaResponse();
    }

    /**
     * Create an instance of {@link LeerProgramacionDiaria }
     * 
     */
    public LeerProgramacionDiaria createLeerProgramacionDiaria() {
        return new LeerProgramacionDiaria();
    }

    /**
     * Create an instance of {@link LeerProgramacionDiariaResponse }
     * 
     */
    public LeerProgramacionDiariaResponse createLeerProgramacionDiariaResponse() {
        return new LeerProgramacionDiariaResponse();
    }

    /**
     * Create an instance of {@link ProgramacionDiariaVO }
     * 
     */
    public ProgramacionDiariaVO createProgramacionDiariaVO() {
        return new ProgramacionDiariaVO();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "ParseException")
    public JAXBElement<ParseException> createParseException(ParseException value) {
        return new JAXBElement<ParseException>(_ParseException_QNAME, ParseException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarProgramacionDiaria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertarProgramacionDiaria")
    public JAXBElement<InsertarProgramacionDiaria> createInsertarProgramacionDiaria(InsertarProgramacionDiaria value) {
        return new JAXBElement<InsertarProgramacionDiaria>(_InsertarProgramacionDiaria_QNAME, InsertarProgramacionDiaria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarProgramacionDiariaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertarProgramacionDiariaResponse")
    public JAXBElement<InsertarProgramacionDiariaResponse> createInsertarProgramacionDiariaResponse(InsertarProgramacionDiariaResponse value) {
        return new JAXBElement<InsertarProgramacionDiariaResponse>(_InsertarProgramacionDiariaResponse_QNAME, InsertarProgramacionDiariaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerProgramacionDiaria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerProgramacionDiaria")
    public JAXBElement<LeerProgramacionDiaria> createLeerProgramacionDiaria(LeerProgramacionDiaria value) {
        return new JAXBElement<LeerProgramacionDiaria>(_LeerProgramacionDiaria_QNAME, LeerProgramacionDiaria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerProgramacionDiariaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerProgramacionDiariaResponse")
    public JAXBElement<LeerProgramacionDiariaResponse> createLeerProgramacionDiariaResponse(LeerProgramacionDiariaResponse value) {
        return new JAXBElement<LeerProgramacionDiariaResponse>(_LeerProgramacionDiariaResponse_QNAME, LeerProgramacionDiariaResponse.class, null, value);
    }

}
