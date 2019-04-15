<%-- 
    Document   : cupos
    Created on : 29/10/2018, 07:53:01 PM
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Programación de Cupos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="images/ship.ico" />
        <link rel="stylesheet" type="text/css" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.css" />
        <link rel="stylesheet" type="text/css" href="css/styles.css" />
    </head>

    <body>
        <div class="ui blue top fixed inverted menu">
            <div class="item">
                <img src="images/logo.png">
            </div>
            <a href="inicio.jsp" class="item">Inicio</a>
            <a href="reserva.jsp" class="item">Mis reservas</a>
            <a href="#" class="item">Programación Cupos</a>
            <a href="programacionDiaria.jsp" class="item" > Programación Diaria</a>
            <a href="programacionTransito.jsp" class="item">Programación Tránsito</a>
            <a class="item">Servicio al Cliente</a>

            <form method="POST" action="cupos.jsp">
                <div class="right menu">
                    <a class="ui item">
                        <button class="ui blue button" name="cerrar" id="cerrar">CERRAR</button>
                    </a>
                </div>
            </form>
        </div>


        <div class="encabezado">
            <h1>Programación de cupos del Canal de Panamá</h1>
        </div>
        <div class="ui container">

            <div class="ui vertically divided grid">
                <div class="column row">
                    <div class="column">
                        <form action="cupos.jsp" method="POST" class="ui form" id="formulario">
                            <h4 class="ui dividing header">Formulario Adición de Cupos</h4>
                            <div class="field">
                                <div class="four fields">

                                    <div class="field">
                                        <label>Esclusa</label>
                                        <select name="selectEs" id="selectEs">
                                            <%-- start web service invocation --%>
                                            <%
                                                String campoEsclusa = "";
                                                try {
                                                    servidor.Reserva_Service service = new servidor.Reserva_Service();
                                                    servidor.Reserva port = service.getReservaPort();
                                                    // TODO process result here
                                                    java.util.List<java.lang.Object> resultEsclusa = port.cargarEsclusa();

                                                    for (int i = 0; i < resultEsclusa.size(); i++) {
                                                        campoEsclusa = resultEsclusa.get(i).toString();

                                            %>
                                            <option value="<%=campoEsclusa%>" selected="selected"><%=campoEsclusa%></option>
                                            <%
                                                    }
                                                } catch (Exception ex) {
                                                    // Aqui deberia haber una excepcion
                                                }
                                            %>
                                            <%-- end web service invocation --%>
                                        </select>
                                    </div>

                                    <div class="field">
                                        <label>Cupos Totales</label>
                                        <input type="text" placeholder="Número de Cupos" name="numCupos" id="numCupos">
                                    </div>


                                    <div class="field">
                                        <label>Fecha</label>
                                        <input type="date" name="fechita" id="fechita">
                                    </div>

                                    <div class="field">
                                        <label>Añadir</label>
                                        <button type="submit" value="anadir" name="anadir" class="ui red button">Añadir cupos</button>
                                    </div>

                                </div>
                            </div>
                        </form>

                        <form method="POST" action="cupos.jsp" class="ui form" id="formularioCambio">
                            <h4 class="ui dividing header">Modificar Programación</h4>

                            <div class=" three field">
                                <div class="field">
                                    <div class="two fields">
                                        <div class="twelve wide field">

                                            <select id="esclusas" name="esclusas">

                                                <%-- start web service invocation --%>
                                                <%
                                                    List li = new ArrayList();
                                                    String esclu = "";
                                                    try {
                                                        servidor.Reserva_Service service = new servidor.Reserva_Service();
                                                        servidor.Reserva port = service.getReservaPort();
                                                        // TODO process result here
                                                        li = port.cargarEsclusa();

                                                        for (int i = 0; i < li.size(); i++) {
                                                            esclu = li.get(i).toString();

                                                %>
                                                <option value="<%=esclu%>"><%=esclu%></option>

                                                <%
                                                        }
                                                    } catch (Exception ex) {
                                                        // Aqui deberia haber una excepcion
                                                    }

                                                    if (request.getParameter("buscar") != null || request.getParameter("buscarF") != null || request.getParameter("modificar") != null) {

                                                        java.lang.String kPaso = request.getParameter("esclusas");
                                                        for (int i = 0; i < li.size(); i++) {
                                                            if (kPaso.equals(li.get(i).toString())) {
                                                                session.setAttribute("esclusaSeleccionada", i);
                                                            }
                                                        }

                                                %>
                                                <script>
                                                    window.onload = function guardarIDBuque() {
                                                        document.getElementById("esclusas").selectedIndex = <%=Integer.parseInt(session.getAttribute("esclusaSeleccionada").toString())%>;
                                                    };
                                                </script>
                                                <%
                                                    }

                                                %>
                                            </select>
                                        </div>

                                        <div class="twelve wide field">
                                            <button type="submit" value="buscar" id="buscar" name="buscar" class="ui red button">Buscar Periodos</button>
                                        </div>
                                    </div>
                                </div>

                                <div class="field">

                                    <div class="two fields">
                                        <div class="twelve wide field">
                                            <select id="fechas" name="fechas">
                                                <%                                                     java.util.List<servidor.CupoPasoVO> lif = new ArrayList();
                                                    String esclusa = request.getParameter("esclusas");
                                                    try {
                                                        servidor.Paso_Service service = new servidor.Paso_Service();
                                                        servidor.Paso port = service.getPasoPort();
                                                        String fecha = "";

                                                        lif = port.leerFechasCupos(esclusa);

                                                        for (int i = 0; i < lif.size(); i++) {
                                                            fecha = lif.get(i).getFAsignacioncupos();
                                                            if (fecha == null) {
                                                                fecha = "";
                                                            }

                                                %>
                                                <option value="<%=fecha%>" ><%=fecha%></option>
                                                <%  }
                                                    } catch (Exception ex) {
                                                        // Aqui deberia haber una excepcion
                                                    }

                                                    if (request.getParameter("buscarF") != null || request.getParameter("modificar") != null) {

                                                        java.lang.String fAsignacion = request.getParameter("fechas");
                                                        for (int i = 0; i < lif.size(); i++) {
                                                            if (fAsignacion.equals(lif.get(i).getFAsignacioncupos())) {
                                                                session.setAttribute("fechaSeleccionada", i);
                                                            }
                                                        }

                                                %>
                                                <script>
                                                    window.onload = function guardarIDFechas() {
                                                        document.getElementById("fechas").selectedIndex = <%=Integer.parseInt(session.getAttribute("fechaSeleccionada").toString())%>;
                                                    };
                                                </script>
                                                <%
                                                    }
                                                %>
                                                <%-- end web service invocation --%>
                                            </select>
                                        </div>

                                        <div class="twelve wide field">
                                            <button type="submit" value="buscarF" name="buscarF" class="ui red button">Seleccionar Fecha</button>
                                        </div>
                                    </div>

                                </div>

                                <%
                                    String ctotales = "";
                                    String cdisponibles = "";
                                    if (request.getParameter("buscarF") != null) {

                                        java.lang.String kPaso = request.getParameter("esclusas");
                                        java.lang.String fAsignacion = request.getParameter("fechas");
                                        request.setAttribute("esclusas", kPaso);
                                        request.setAttribute("fechas", fAsignacion);

                                        try {
                                            servidor.Paso_Service service = new servidor.Paso_Service();
                                            servidor.Paso port = service.getPasoPort();

                                            java.util.List<servidor.CupoPasoVO> res = port.leerCupos(kPaso, fAsignacion);
                                            for (int i = 0; i < res.size(); i++) {
                                                ctotales = String.valueOf(res.get(i).getQCtotales());
                                                cdisponibles = String.valueOf(res.get(i).getQCdisponibles());
                                            }
                                        } catch (Exception ex) {
                                            // TODO handle custom exceptions here
                                        }
                                    }
                                %>
                                <%-- end web service invocation --%>
                                <div class="field">
                                    <div class="three fields">
                                        <div class="six wide field">
                                            <label>Cupos Totales</label>
                                            <input type="text" name="ctotales" placeholder="Cupos Totales" id="ctotales" value="<%=ctotales%>">
                                        </div>

                                        <div class="six wide field">
                                            <label>Cupos Disponibles</label>
                                            <input type="text" name="cdisponibles" placeholder="Cupos Disponibles" id="cdisponibles" value="<%=cdisponibles%>">
                                        </div>

                                        <div class="twelve wide field">
                                            <label>Modificar</label>
                                            <button type="submit" value="modificar" name="modificar" class="ui red button">Modificar Cupos</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- SCRIPTS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.js"></script>

    </body>

</html>



<%-- start web service invocation --%>
<%
    if (request.getParameter("cerrar") != null) {
        try {
            servidor.ConexionBD_Service service = new servidor.ConexionBD_Service();
            servidor.ConexionBD port = service.getConexionBDPort();
            port.cerrarConexion();
            response.sendRedirect("login.jsp");
        } catch (Exception ex) {
            // Aqui deberia haber una excepcion
        }
    }
%>
<%-- end web service invocation --%>


<%-- start web service invocation --%>
<%
    if (request.getParameter("modificar") != null) {
        String kpaso = request.getParameter("esclusas");
        String fasignacion = request.getParameter("fechas");
        int qtotales = Integer.parseInt(request.getParameter("ctotales"));
        int qdisponibles = Integer.parseInt(request.getParameter("cdisponibles"));
        try {
            servidor.Paso_Service service = new servidor.Paso_Service();
            servidor.Paso port = service.getPasoPort();

            port.modificarCupoPaso(kpaso, fasignacion, qtotales, qdisponibles);
%>
<script type="text/javascript">
                                                    alert("Actualización de Cupos exitosa");
</script>
<%
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
%>
<%-- end web service invocation --%>

<%-- start web service invocation --%>
<%
    if (request.getParameter("anadir") != null) {
        try {
            servidor.Paso_Service service = new servidor.Paso_Service();
            servidor.Paso port = service.getPasoPort();
            // TODO initialize WS operation arguments here
            String kPasoI = request.getParameter("selectEs");
            int qCtotalesI = Integer.parseInt(request.getParameter("numCupos"));
            String fAsignacioncuposI = request.getParameter("fechita");
            // TODO process result here
            java.lang.Boolean result = port.insertarCupoPaso(kPasoI, qCtotalesI, fAsignacioncuposI);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
%>
<%-- end web service invocation --%>
