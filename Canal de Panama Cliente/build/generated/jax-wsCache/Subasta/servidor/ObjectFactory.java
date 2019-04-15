
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
    private final static QName _BuscarSubasta_QNAME = new QName("http://Servidor/", "buscarSubasta");
    private final static QName _BuscarSubastaEspecifica_QNAME = new QName("http://Servidor/", "buscarSubastaEspecifica");
    private final static QName _BuscarSubastaEspecificaResponse_QNAME = new QName("http://Servidor/", "buscarSubastaEspecificaResponse");
    private final static QName _BuscarSubastaResponse_QNAME = new QName("http://Servidor/", "buscarSubastaResponse");
    private final static QName _CerrarSubasta_QNAME = new QName("http://Servidor/", "cerrarSubasta");
    private final static QName _CerrarSubastaResponse_QNAME = new QName("http://Servidor/", "cerrarSubastaResponse");
    private final static QName _ListarSubastas_QNAME = new QName("http://Servidor/", "listarSubastas");
    private final static QName _ListarSubastasResponse_QNAME = new QName("http://Servidor/", "listarSubastasResponse");

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
     * Create an instance of {@link BuscarSubasta }
     * 
     */
    public BuscarSubasta createBuscarSubasta() {
        return new BuscarSubasta();
    }

    /**
     * Create an instance of {@link BuscarSubastaEspecifica }
     * 
     */
    public BuscarSubastaEspecifica createBuscarSubastaEspecifica() {
        return new BuscarSubastaEspecifica();
    }

    /**
     * Create an instance of {@link BuscarSubastaEspecificaResponse }
     * 
     */
    public BuscarSubastaEspecificaResponse createBuscarSubastaEspecificaResponse() {
        return new BuscarSubastaEspecificaResponse();
    }

    /**
     * Create an instance of {@link BuscarSubastaResponse }
     * 
     */
    public BuscarSubastaResponse createBuscarSubastaResponse() {
        return new BuscarSubastaResponse();
    }

    /**
     * Create an instance of {@link CerrarSubasta }
     * 
     */
    public CerrarSubasta createCerrarSubasta() {
        return new CerrarSubasta();
    }

    /**
     * Create an instance of {@link CerrarSubastaResponse }
     * 
     */
    public CerrarSubastaResponse createCerrarSubastaResponse() {
        return new CerrarSubastaResponse();
    }

    /**
     * Create an instance of {@link ListarSubastas }
     * 
     */
    public ListarSubastas createListarSubastas() {
        return new ListarSubastas();
    }

    /**
     * Create an instance of {@link ListarSubastasResponse }
     * 
     */
    public ListarSubastasResponse createListarSubastasResponse() {
        return new ListarSubastasResponse();
    }

    /**
     * Create an instance of {@link SubastaVO }
     * 
     */
    public SubastaVO createSubastaVO() {
        return new SubastaVO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarSubasta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "buscarSubasta")
    public JAXBElement<BuscarSubasta> createBuscarSubasta(BuscarSubasta value) {
        return new JAXBElement<BuscarSubasta>(_BuscarSubasta_QNAME, BuscarSubasta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarSubastaEspecifica }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "buscarSubastaEspecifica")
    public JAXBElement<BuscarSubastaEspecifica> createBuscarSubastaEspecifica(BuscarSubastaEspecifica value) {
        return new JAXBElement<BuscarSubastaEspecifica>(_BuscarSubastaEspecifica_QNAME, BuscarSubastaEspecifica.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarSubastaEspecificaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "buscarSubastaEspecificaResponse")
    public JAXBElement<BuscarSubastaEspecificaResponse> createBuscarSubastaEspecificaResponse(BuscarSubastaEspecificaResponse value) {
        return new JAXBElement<BuscarSubastaEspecificaResponse>(_BuscarSubastaEspecificaResponse_QNAME, BuscarSubastaEspecificaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarSubastaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "buscarSubastaResponse")
    public JAXBElement<BuscarSubastaResponse> createBuscarSubastaResponse(BuscarSubastaResponse value) {
        return new JAXBElement<BuscarSubastaResponse>(_BuscarSubastaResponse_QNAME, BuscarSubastaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CerrarSubasta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cerrarSubasta")
    public JAXBElement<CerrarSubasta> createCerrarSubasta(CerrarSubasta value) {
        return new JAXBElement<CerrarSubasta>(_CerrarSubasta_QNAME, CerrarSubasta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CerrarSubastaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "cerrarSubastaResponse")
    public JAXBElement<CerrarSubastaResponse> createCerrarSubastaResponse(CerrarSubastaResponse value) {
        return new JAXBElement<CerrarSubastaResponse>(_CerrarSubastaResponse_QNAME, CerrarSubastaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarSubastas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "listarSubastas")
    public JAXBElement<ListarSubastas> createListarSubastas(ListarSubastas value) {
        return new JAXBElement<ListarSubastas>(_ListarSubastas_QNAME, ListarSubastas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarSubastasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor/", name = "listarSubastasResponse")
    public JAXBElement<ListarSubastasResponse> createListarSubastasResponse(ListarSubastasResponse value) {
        return new JAXBElement<ListarSubastasResponse>(_ListarSubastasResponse_QNAME, ListarSubastasResponse.class, null, value);
    }

}
