
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
@WebServiceClient(name = "Subasta", targetNamespace = "http://Servidor/", wsdlLocation = "http://localhost:8083/CanalPanamaServer/Subasta?WSDL")
public class Subasta_Service
    extends Service
{

    private final static URL SUBASTA_WSDL_LOCATION;
    private final static WebServiceException SUBASTA_EXCEPTION;
    private final static QName SUBASTA_QNAME = new QName("http://Servidor/", "Subasta");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8083/CanalPanamaServer/Subasta?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SUBASTA_WSDL_LOCATION = url;
        SUBASTA_EXCEPTION = e;
    }

    public Subasta_Service() {
        super(__getWsdlLocation(), SUBASTA_QNAME);
    }

    public Subasta_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SUBASTA_QNAME, features);
    }

    public Subasta_Service(URL wsdlLocation) {
        super(wsdlLocation, SUBASTA_QNAME);
    }

    public Subasta_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SUBASTA_QNAME, features);
    }

    public Subasta_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Subasta_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Subasta
     */
    @WebEndpoint(name = "SubastaPort")
    public Subasta getSubastaPort() {
        return super.getPort(new QName("http://Servidor/", "SubastaPort"), Subasta.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Subasta
     */
    @WebEndpoint(name = "SubastaPort")
    public Subasta getSubastaPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Servidor/", "SubastaPort"), Subasta.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SUBASTA_EXCEPTION!= null) {
            throw SUBASTA_EXCEPTION;
        }
        return SUBASTA_WSDL_LOCATION;
    }

}