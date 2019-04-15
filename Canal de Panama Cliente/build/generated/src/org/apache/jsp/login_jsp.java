package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!-- saved from url=(0043)https://semantic-ui.com/examples/login.html -->\n");
      out.write("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!-- Standard Meta -->\n");
      out.write("    <a href=\"login.jsp\"></a>\n");
      out.write("\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-witdth, initial-scale=1.0, maximum-scale=1.0\">\n");
      out.write("\n");
      out.write("    <!-- Site Properties -->\n");
      out.write("    <title>Sistema de Reservas Canal Panamá</title>\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/ship.ico\" />\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.css\" />\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/login.css\">\n");
      out.write("\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.js\"></script>\n");
      out.write("    <!--<script src=\"./Login Example - Semantic_files/jquery.min.js.descarga\"></script>\n");
      out.write("    <!--<script src=\"./Login Example - Semantic_files/form.js.descarga\"></script>\n");
      out.write("    <script src=\"./Login Example - Semantic_files/transition.js.descarga\"></script>\n");
      out.write("    <!--<script src=\"js/login.js\"></script>-->\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"ui middle aligned center aligned grid\">\n");
      out.write("        <div class=\"column\">\n");
      out.write("            <h2 class=\"ui blue image header\">\n");
      out.write("                <img src=\"./images/logo.png\" class=\"image\">\n");
      out.write("                <div class=\"content\">\n");
      out.write("                    Sistema de Reserva y Tránsito\n");
      out.write("                </div>\n");
      out.write("            </h2>\n");
      out.write("            <form class=\"ui large form\" method=\"POST\" action=\"login.jsp\">\n");
      out.write("                <div class=\"ui stacked segment\">\n");
      out.write("                    <div class=\"field\">\n");
      out.write("                        <div class=\"ui left icon input\">\n");
      out.write("                            <i class=\"user icon\"></i>\n");
      out.write("                            <input type=\"text\" name=\"usuario\" id=\"usuario\" placeholder=\"Usuario\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"field\">\n");
      out.write("                        <div class=\"ui left icon input\">\n");
      out.write("                            <i class=\"lock icon\"></i>\n");
      out.write("                            <input type=\"password\" name=\"password\"  id=\"password\" placeholder=\"Contraseña\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <button name=\"confirmar\" id=\"confirmar\" type=\"submit\" class=\"ui fluid large blue submit button\">Entrar</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"ui error message\"></div>\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");

                    request.setAttribute("confirmar", null);
                    if (request.getParameter("confirmar") != null) {
                        try {
                            servidor.ConexionBD_Service service = new servidor.ConexionBD_Service();
                            servidor.ConexionBD port = service.getConexionBDPort();
                            // TODO initialize WS operation arguments here
                            java.lang.String usu = request.getParameter("usuario");
                            java.lang.String pas = request.getParameter("password");
                            // TODO process result here
                            boolean result = port.realizarConexion(usu, pas);
                            if (result) {
                                if (usu != null && usu.length() > 0) {
                                    session.setAttribute("username", usu);
                                }
                                response.sendRedirect("inicio.jsp");
                            }
                        } catch (Exception ex) {
                
      out.write("\n");
      out.write("                <div class=\"ui negative message\">\n");
      out.write("                    <i class=\"close icon\"></i>\n");
      out.write("                    <div class=\"header\">\n");
      out.write("                        Error al iniciar sesión\n");
      out.write("                    </div>\n");
      out.write("                    <p>");
      out.print(ex);
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("                ");

                        }
                    }
                
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <div class=\"ui message\">\n");
      out.write("                ¿No está registrado? <a href=\"https://semantic-ui.com/examples/login.html#\">Registrese</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body></html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
