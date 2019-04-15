
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
    private final static QName _InsertarCupoPaso_QNAME = new QName("http://Servidor/", "insertarCupoPaso");
    private final static QName _InsertarCupoPasoResponse_QNAME = new QName("http://Servidor/", "insertarCupoPasoResponse");
    private final static QName _LeerCupos_QNAME = new QName("http://Servidor/", "leerCupos");
    private final static QName _LeerCuposResponse_QNAME = new QName("http://Servidor/", "leerCuposResponse");
    private final static QName _LeerFechasCupos_QNAME = new QName("http://Servidor/", "leerFechasCupos");
    private final static QName _LeerFechasCuposResponse_QNAME = new QName("http://Servidor/", "leerFechasCuposResponse");
    private final static QName _ModificarCupoPaso_QNAME = new QName("http://Servidor/", "modificarCupoPaso");
    private final static QName _ModificarCupoPasoResponse_QNAME = new QName("http://Servidor/", "modificarCupoPasoResponse");

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
     * Create an instance of {@link InsertarCupoPaso }
     * 
     */
    public InsertarCupoPaso createInsertarCupoPaso() {
        return new InsertarCupoPaso();
    }

    /**
     * Create an instance of {@link InsertarCupoPasoResponse }
     * 
     */
    public InsertarCupoPasoResponse createInsertarCupoPasoResponse() {
        return new InsertarCupoPasoResponse();
    }

    /**
     * Create an instance of {@link LeerCupos }
     * 
     */
    public LeerCupos createLeerCupos() {
        return new LeerCupos();
    }

    /**
     * Create an instance of {@link LeerCuposResponse }
     * 
     */
    public LeerCuposResponse createLeerCuposResponse() {
        return new LeerCuposResponse();
    }

    /**
     * Create an instance of {@link LeerFechasCupos }
     * 
     */
    public LeerFechasCupos createLeerFechasCupos() {
        return new LeerFechasCupos();
    }

    /**
     * Create an instance of {@link LeerFechasCuposResponse }
     * 
     */
    public LeerFechasCuposResponse createLeerFechasCuposResponse() {
        return new LeerFechasCuposResponse();
    }

    /**
     * Create an instance of {@link ModificarCupoPaso }
     * 
     */
    public ModificarCupoPaso createModificarCupoPaso() {
        return new ModificarCupoPaso();
    }

    /**
     * Create an instance of {@link ModificarCupoPasoResponse }
     * 
     */
    public ModificarCupoPasoResponse createModificarCupoPasoResponse() {
        return new ModificarCupoPasoResponse();
    }

    /**
     * Create an instance of {@link CupoPasoVO }
     * 
     */
    public CupoPasoVO createCupoPasoVO() {
        return new CupoPasoVO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarCupoPaso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertarCupoPaso")
    public JAXBElement<InsertarCupoPaso> createInsertarCupoPaso(InsertarCupoPaso value) {
        return new JAXBElement<InsertarCupoPaso>(_InsertarCupoPaso_QNAME, InsertarCupoPaso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarCupoPasoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertarCupoPasoResponse")
    public JAXBElement<InsertarCupoPasoResponse> createInsertarCupoPasoResponse(InsertarCupoPasoResponse value) {
        return new JAXBElement<InsertarCupoPasoResponse>(_InsertarCupoPasoResponse_QNAME, InsertarCupoPasoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerCupos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerCupos")
    public JAXBElement<LeerCupos> createLeerCupos(LeerCupos value) {
        return new JAXBElement<LeerCupos>(_LeerCupos_QNAME, LeerCupos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerCuposResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerCuposResponse")
    public JAXBElement<LeerCuposResponse> createLeerCuposResponse(LeerCuposResponse value) {
        return new JAXBElement<LeerCuposResponse>(_LeerCuposResponse_QNAME, LeerCuposResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerFechasCupos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerFechasCupos")
    public JAXBElement<LeerFechasCupos> createLeerFechasCupos(LeerFechasCupos value) {
        return new JAXBElement<LeerFechasCupos>(_LeerFechasCupos_QNAME, LeerFechasCupos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerFechasCuposResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerFechasCuposResponse")
    public JAXBElement<LeerFechasCuposResponse> createLeerFechasCuposResponse(LeerFechasCuposResponse value) {
        return new JAXBElement<LeerFechasCuposResponse>(_LeerFechasCuposResponse_QNAME, LeerFechasCuposResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarCupoPaso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "modificarCupoPaso")
    public JAXBElement<ModificarCupoPaso> createModificarCupoPaso(ModificarCupoPaso value) {
        return new JAXBElement<ModificarCupoPaso>(_ModificarCupoPaso_QNAME, ModificarCupoPaso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModificarCupoPasoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "modificarCupoPasoResponse")
    public JAXBElement<ModificarCupoPasoResponse> createModificarCupoPasoResponse(ModificarCupoPasoResponse value) {
        return new JAXBElement<ModificarCupoPasoResponse>(_ModificarCupoPasoResponse_QNAME, ModificarCupoPasoResponse.class, null, value);
    }

}
