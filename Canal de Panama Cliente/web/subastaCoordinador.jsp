<%-- 
    Document   : subastaCoordinador
    Created on : 6/03/2019, 09:29:53 PM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Subasta y Pujas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="images/ship.ico" />
        <link rel="stylesheet" type="text/css" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.css" />
        <link rel="stylesheet" type="text/css" href="css/styles.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.js"></script>
    </head>

    <body>
        <div class="ui blue top fixed inverted menu">
            <div class="item">
                <img src="images/logo.png">
            </div>
            <a href="inicio.jsp" class="item">Inicio</a>
            <a href="reserva.jsp" class="item">Mis reservas</a>
            <a href="cupos.jsp" class="item">Programación Cupos</a>
            <a href="programacionDiaria.jsp" class="item" > Programación Diaria</a>
            <a href="programacionTransito.jsp" class="item">Programación Tránsito</a>
            <a href="transaccionesCliente.jsp" class="item">Transacciones</a>
            <a href="subastaCoordinador.jsp" class="item">Subasta</a>

            <form method="POST" action="subastaCoordinador.jsp">
                <div class="right menu">
                    <a class="ui item">
                        <button class="ui blue button" name="cerrar" id="cerrar">CERRAR</button>
                    </a>
                </div>
            </form>
        </div>
    </form>

    <h2 class="ui center aligned icon header encabezado"><i class="circular red hand point up icon"></i></i>
    Cierre de Subasta</h2>

<div class="ui container">
    <div class="ui vertically divided grid">
        <div class="row">
            <div class="sixteen wide column ">
                <form class="ui form" method="POST" action="subastaCoordinador.jsp">
                    <div class="field">
                        <label>Seleccione la Subasta que desea cerrar</label>
                        <select id="selectSubasta" name="selectSubasta">
                            <%
                                try {
                                    servidor.Subasta_Service service = new servidor.Subasta_Service();
                                    servidor.Subasta port = service.getSubastaPort();
                                    // TODO process result here
                                    java.util.List<java.lang.Long> subReservas = port.listarSubastas();
                                    for (int i = 0; i < subReservas.size(); i++) {


                            %>
                            <option id="opSubasta" name="opSubasta"><%=String.valueOf(subReservas.get(i))%></option>

                            <%
                                    }
                                } catch (Exception ex) {
                                    System.out.println("No se cargaron las subastas para el coordinador" + ex.getMessage());
                                }
                            %>


                        </select>
                    </div>

                    <div class="field">
                        <button class="fluid ui submit button" id="buscarSub" name="buscarSub">Buscar Subasta</button>
                    </div>
                    <div class="two fields">

                        <%-- start web service invocation --%><hr/>
                        <%
                            if (request.getParameter("buscarSub") != null) {
                                session.setAttribute("idSubasta", request.getParameter("selectSubasta"));
                                try {
                                    servidor.Subasta_Service service = new servidor.Subasta_Service();
                                    servidor.Subasta port = service.getSubastaPort();
                                    // TODO initialize WS operation arguments here

                                    long kSubasta = Long.parseLong(String.valueOf(session.getAttribute("idSubasta")));
                                    // TODO process result here
                                    servidor.SubastaVO objeto = port.buscarSubastaEspecifica(kSubasta);
                        %>


                        <div class=" field">
                            <label>Fecha de Apertura</label>
                            <input id="lf_apertura" readonly="" type="text" value="<%=String.valueOf(objeto.getFAperturasubasta())%>">
                        </div>
                        <div class="field">
                            <label>Fecha de Vencimiento</label>
                            <input id="lf_vencimiento" readonly="" type="text" value="<%=String.valueOf(objeto.getFVencimientosubasta())%>">
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <label>Fecha de Tránsito</label>
                            <input id="lf_transito" readonly="" type="text" value="<%=String.valueOf(objeto.getFCuposubasta())%>">
                        </div>
                        <div class="field">
                            <label>Valor Inicial de la Puja</label>
                            <input id="lvi_puja" readonly="" type="text" value="<%=String.valueOf(objeto.getVPujainicial())%>">
                        </div>
                    </div>

                    <div class="two fields">
                        <div class="field">
                            <label>Valor Actuals</label>
                            <input id="lva_puja" readonly="" type="text" value="">
                        </div>
                        <div class="field">
                            <label>Valor de Incremento</label>
                            <input id="lvin_puja" readonly="" type="text" value="<%=String.valueOf(objeto.getVIncrementominimo())%>">
                        </div>
                    </div>
                    <%
                            } catch (Exception ex) {
                                System.out.println("Error" + ex);
                            }
                        }
                    %>
                    <div class="field">
                        <button class="fluid ui submit button" id="cerrarSub" name="cerrarSub">Cerrar Subasta</button>
                    </div>

                </form>
            </div>


        </div>
    </div>
</div>
</div>

<%
    if (request.getParameter("cerrarSub") != null) {
        try {
            servidor.Subasta_Service service = new servidor.Subasta_Service();
            servidor.Subasta port = service.getSubastaPort();
            // TODO initialize WS operation arguments here
            long kSubasta = Long.parseLong(String.valueOf(session.getAttribute("idSubasta")));
            port.cerrarSubasta(kSubasta);
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }
%>

<%
    if (request.getParameter("cerrar") != null) {
        try {
            servidor.ConexionBD_Service service = new servidor.ConexionBD_Service();
            servidor.ConexionBD port = service.getConexionBDPort();
            port.cerrarConexion();
            session.invalidate();
            response.sendRedirect("login.jsp");
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
%>
</body>



</html>