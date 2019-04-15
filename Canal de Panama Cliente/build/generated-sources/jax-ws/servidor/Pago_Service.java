
package servidor;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Pago", targetNamespace = "http://Servidor/", wsdlLocation = "http://localhost:8083/CanalPanamaServer/Pago?WSDL")
public class Pago_Service
    extends Service
{

    private final static URL PAGO_WSDL_LOCATION;
    private final static WebServiceException PAGO_EXCEPTION;
    private final static QName PAGO_QNAME = new QName("http://Servidor/", "Pago");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8083/CanalPanamaServer/Pago?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PAGO_WSDL_LOCATION = url;
        PAGO_EXCEPTION = e;
    }

    public Pago_Service() {
        super(__getWsdlLocation(), PAGO_QNAME);
    }

    public Pago_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), PAGO_QNAME, features);
    }

    public Pago_Service(URL wsdlLocation) {
        super(wsdlLocation, PAGO_QNAME);
    }

    public Pago_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PAGO_QNAME, features);
    }

    public Pago_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Pago_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Pago
     */
    @WebEndpoint(name = "PagoPort")
    public Pago getPagoPort() {
        return super.getPort(new QName("http://Servidor/", "PagoPort"), Pago.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Pago
     */
    @WebEndpoint(name = "PagoPort")
    public Pago getPagoPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Servidor/", "PagoPort"), Pago.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PAGO_EXCEPTION!= null) {
            throw PAGO_EXCEPTION;
        }
        return PAGO_WSDL_LOCATION;
    }

}