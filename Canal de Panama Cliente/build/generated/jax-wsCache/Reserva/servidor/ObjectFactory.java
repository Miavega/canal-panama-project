
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
    private final static QName _CargarEsclusa_QNAME = new QName("http://Servidor/", "cargarEsclusa");
    private final static QName _CargarEsclusaResponse_QNAME = new QName("http://Servidor/", "cargarEsclusaResponse");
    private final static QName _InsertarReserva_QNAME = new QName("http://Servidor/", "insertarReserva");
    private final static QName _InsertarReservaResponse_QNAME = new QName("http://Servidor/", "insertarReservaResponse");
    private final static QName _LeerMisReservas_QNAME = new QName("http://Servidor/", "leerMisReservas");
    private final static QName _LeerMisReservasResponse_QNAME = new QName("http://Servidor/", "leerMisReservasResponse");
    private final static QName _LeerReservasPorDia_QNAME = new QName("http://Servidor/", "leerReservasPorDia");
    private final static QName _LeerReservasPorDiaResponse_QNAME = new QName("http://Servidor/", "leerReservasPorDiaResponse");
    private final static QName _RevisarDisponibilidad_QNAME = new QName("http://Servidor/", "revisarDisponibilidad");
    private final static QName _RevisarDisponibilidadResponse_QNAME = new QName("http://Servidor/", "revisarDisponibilidadResponse");

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
     * Create an instance of {@link CargarEsclusa }
     * 
     */
    public CargarEsclusa createCargarEsclusa() {
        return new CargarEsclusa();
    }

    /**
     * Create an instance of {@link CargarEsclusaResponse }
     * 
     */
    public CargarEsclusaResponse createCargarEsclusaResponse() {
        return new CargarEsclusaResponse();
    }

    /**
     * Create an instance of {@link InsertarReserva }
     * 
     */
    public InsertarReserva createInsertarReserva() {
        return new InsertarReserva();
    }

    /**
     * Create an instance of {@link InsertarReservaResponse }
     * 
     */
    public InsertarReservaResponse createInsertarReservaResponse() {
        return new InsertarReservaResponse();
    }

    /**
     * Create an instance of {@link LeerMisReservas }
     * 
     */
    public LeerMisReservas createLeerMisReservas() {
        return new LeerMisReservas();
    }

    /**
     * Create an instance of {@link LeerMisReservasResponse }
     * 
     */
    public LeerMisReservasResponse createLeerMisReservasResponse() {
        return new LeerMisReservasResponse();
    }

    /**
     * Create an instance of {@link LeerReservasPorDia }
     * 
     */
    public LeerReservasPorDia createLeerReservasPorDia() {
        return new LeerReservasPorDia();
    }

    /**
     * Create an instance of {@link LeerReservasPorDiaResponse }
     * 
     */
    public LeerReservasPorDiaResponse createLeerReservasPorDiaResponse() {
        return new LeerReservasPorDiaResponse();
    }

    /**
     * Create an instance of {@link RevisarDisponibilidad }
     * 
     */
    public RevisarDisponibilidad createRevisarDisponibilidad() {
        return new RevisarDisponibilidad();
    }

    /**
     * Create an instance of {@link RevisarDisponibilidadResponse }
     * 
     */
    public RevisarDisponibilidadResponse createRevisarDisponibilidadResponse() {
        return new RevisarDisponibilidadResponse();
    }

    /**
     * Create an instance of {@link CupoPasoVO }
     * 
     */
    public CupoPasoVO createCupoPasoVO() {
        return new CupoPasoVO();
    }

    /**
     * Create an instance of {@link ReservaVO }
     * 
     */
    public ReservaVO createReservaVO() {
        return new ReservaVO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarEsclusa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cargarEsclusa")
    public JAXBElement<CargarEsclusa> createCargarEsclusa(CargarEsclusa value) {
        return new JAXBElement<CargarEsclusa>(_CargarEsclusa_QNAME, CargarEsclusa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarEsclusaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cargarEsclusaResponse")
    public JAXBElement<CargarEsclusaResponse> createCargarEsclusaResponse(CargarEsclusaResponse value) {
        return new JAXBElement<CargarEsclusaResponse>(_CargarEsclusaResponse_QNAME, CargarEsclusaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertarReserva")
    public JAXBElement<InsertarReserva> createInsertarReserva(InsertarReserva value) {
        return new JAXBElement<InsertarReserva>(_InsertarReserva_QNAME, InsertarReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "insertarReservaResponse")
    public JAXBElement<InsertarReservaResponse> createInsertarReservaResponse(InsertarReservaResponse value) {
        return new JAXBElement<InsertarReservaResponse>(_InsertarReservaResponse_QNAME, InsertarReservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerMisReservas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerMisReservas")
    public JAXBElement<LeerMisReservas> createLeerMisReservas(LeerMisReservas value) {
        return new JAXBElement<LeerMisReservas>(_LeerMisReservas_QNAME, LeerMisReservas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerMisReservasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerMisReservasResponse")
    public JAXBElement<LeerMisReservasResponse> createLeerMisReservasResponse(LeerMisReservasResponse value) {
        return new JAXBElement<LeerMisReservasResponse>(_LeerMisReservasResponse_QNAME, LeerMisReservasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerReservasPorDia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerReservasPorDia")
    public JAXBElement<LeerReservasPorDia> createLeerReservasPorDia(LeerReservasPorDia value) {
        return new JAXBElement<LeerReservasPorDia>(_LeerReservasPorDia_QNAME, LeerReservasPorDia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LeerReservasPorDiaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "leerReservasPorDiaResponse")
    public JAXBElement<LeerReservasPorDiaResponse> createLeerReservasPorDiaResponse(LeerReservasPorDiaResponse value) {
        return new JAXBElement<LeerReservasPorDiaResponse>(_LeerReservasPorDiaResponse_QNAME, LeerReservasPorDiaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RevisarDisponibilidad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "revisarDisponibilidad")
    public JAXBElement<RevisarDisponibilidad> createRevisarDisponibilidad(RevisarDisponibilidad value) {
        return new JAXBElement<RevisarDisponibilidad>(_RevisarDisponibilidad_QNAME, RevisarDisponibilidad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RevisarDisponibilidadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "revisarDisponibilidadResponse")
    public JAXBElement<RevisarDisponibilidadResponse> createRevisarDisponibilidadResponse(RevisarDisponibilidadResponse value) {
        return new JAXBElement<RevisarDisponibilidadResponse>(_RevisarDisponibilidadResponse_QNAME, RevisarDisponibilidadResponse.class, null, value);
    }

}
