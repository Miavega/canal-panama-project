<%-- 
    Document   : programacionDiaria
    Created on : 7/11/2018, 09:40:13 PM

--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Programación Diaria</title>
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
            <a href="#" class="item" > Programación Diaria</a>
            <a href="programacionTransito.jsp" class="item">Programación Tránsito</a>
            <a href="transaccionesCoordinador.jsp" class="item">Transacciones</a>
            <a href="subastaCoordinador.jsp" class="item">Subasta</a>


            <form method="POST" action="programacionDiaria.jsp">
                <div class="right menu">
                    <a class="ui item">
                        <button class="ui blue button" name="cerrar" id="cerrar">CERRAR</button>
                    </a>
                </div>
            </form>
        </div>
    </form>

    <div class="encabezado">
        <h1>Programación Diaria</h1>
    </div>

    <div class="ui container">

        <div class="ui vertically divided grid">
            <div class="column row">
                <div class="column">
                    <form method="POST" action="programacionDiaria.jsp"  class="ui form" id="formulario" >
                        <h4 class="ui dividing header">Formulario Programación Diaria</h4>
                        <div class="inline fields">
                            <div class="field">
                                <label>Fecha</label>
                                <input type="date" id="fecha" name="fecha">
                            </div>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	servidor.Reserva_Service service = new servidor.Reserva_Service();
	servidor.Reserva port = service.getReservaPort();
	 // TODO initialize WS operation arguments here
	java.lang.String usuario = request.getParameter("name");
	// TODO process result here
	java.util.List<servidor.ReservaVO> result = port.leerMisReservas(usuario);

    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

                            
                            <div class="field">
                                <button type="submit" class="ui red button" name="buscar" id="buscar">BUSCAR</button>
                            </div>

                        </div>

                        <table class="ui inverted teal table" name="tablaP" id="tablaP">
                            <thead>
                                <tr>
                                    <th>ID Reserva</th>
                                    <th>ID Buque</th>
                                    <th>Buque</th>
                                    <th>Operador</th>
                                    <th>Responsable</th>
                                    <th>Esclusa</th>
                                    <th>Puerto Salida</th>
                                    <th>Puerto Llegada</th>
                                    <th>Hora Salida</th>
                                    <th>Hora Llegada</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    if (request.getParameter("buscar") != null) {

                                        try {
                                            servidor.Reserva_Service service = new servidor.Reserva_Service();
                                            servidor.Reserva port = service.getReservaPort();
                                            // TODO initialize WS operation arguments here
                                            java.lang.String fTransito = request.getParameter("fecha");
                                %>
                            <script>
                                window.onload = function guardarFecha() {
                                    document.getElementById("fecha").value = '<%=fTransito%>';
                                };
                            </script>
                            <%
                                // TODO process result here
                                java.util.List<servidor.ReservaVO> listaRfecha = port.leerReservasPorDia(fTransito);

                                for (int i = 0; i < listaRfecha.size(); i++) {

                            %>

                            <tr>
                                <td name="kreserva" id="kreserva"><%=String.valueOf(listaRfecha.get(i).getKReserva())%></td>
                            <input type="hidden" name="kreserva" value="<%=String.valueOf(listaRfecha.get(i).getKReserva())%>"/>

                            <td name="kbuque" id="kbuque"><%=String.valueOf(listaRfecha.get(i).getKBuque())%></td>
                            <td name="dir" id="dir"><%=String.valueOf(listaRfecha.get(i).getIDirtransito())%></td>
                            <td name="a" id="a"><%=String.valueOf(listaRfecha.get(i).getITiporeserva())%></td>
                            <td name="b" id="b"><%=String.valueOf(listaRfecha.get(i).getKIdentificacion())%></td>
                            <td name="c" id="c"><%=String.valueOf(listaRfecha.get(i).getKEsclusa())%></td>


                            <td name="puertoS" id="puertoS">
                                <select name="puertoSa" id="puertoSa">

                                    <%
                                        String nPuerto = "";
                                        String kPuerto = "";
                                        try {
                                            servidor.Puerto_Service serviceP = new servidor.Puerto_Service();
                                            servidor.Puerto portP = serviceP.getPuertoPort();
                                            // TODO process result here
                                            java.util.List<servidor.PuertoVO> liPuertos = portP.leerPuertos();

                                            for (int j = 0; j < liPuertos.size(); j++) {
                                                nPuerto = liPuertos.get(j).getNPuerto();
                                                kPuerto = String.valueOf(liPuertos.get(j).getKPuerto());

                                    %>

                                    <option value="<%=kPuerto%>" selected="selected"><%=nPuerto%></option> 
                                    <%}
                                        } catch (Exception ex) {

                                        }
                                    %>
                                </select>
                            </td>

                            <td name="puertoL" id="puertoL">
                                <select name="puertoLl" id="puertoLl">

                                    <%
                                        try {
                                            servidor.Puerto_Service serviceP = new servidor.Puerto_Service();
                                            servidor.Puerto portP = serviceP.getPuertoPort();
                                            // TODO process result here
                                            java.util.List<servidor.PuertoVO> liPuertos = portP.leerPuertos();

                                            for (int j = 0; j < liPuertos.size(); j++) {
                                                nPuerto = liPuertos.get(j).getNPuerto();
                                                kPuerto = String.valueOf(liPuertos.get(j).getKPuerto());
                                    %>


                                    <option  value="<%=kPuerto%>" selected="selected"><%=nPuerto%></option> 
                                    <%}
                                        } catch (Exception ex) {

                                        }
                                    %>

                                </select>

                            </td>

                            <td name="horaS" id="horaS">
                                <select name="horaSa" id="horaSa">
                                    <option id="0" name="0">00:00</option>
                                    <option id="1" name="1">01:00</option>
                                    <option id="2" name="2">02:00</option>
                                    <option id="3" name="3">03:00</option>
                                    <option id="4" name="4">04:00</option>
                                    <option id="5" name="5">05:00</option>
                                    <option id="6" name="6">06:00</option>
                                    <option id="7" name="7">07:00</option>
                                    <option id="8" name="8">08:00</option>
                                    <option id="9" name="9">09:00</option>
                                    <option id="10" name="10">10:00</option>
                                    <option id="11" name="11">11:00</option>
                                    <option id="12" name="12">12:00</option>
                                    <option id="13" name="13">13:00</option>
                                    <option id="14" name="14">14:00</option>
                                    <option id="15" name="15">15:00</option>
                                    <option id="16" name="16">16:00</option>
                                    <option id="17" name="17">17:00</option>
                                    <option id="18" name="18">18:00</option>
                                    <option id="19" name="19">19:00</option>
                                    <option id="20" name="20">20:00</option>
                                    <option id="21" name="21">21:00</option>
                                    <option id="22" name="22">22:00</option>
                                    <option id="23" name="23">23:00</option>

                                </select>
                            </td>
                            <td  name="horaL" id="horaL">
                                <select name="horaLl" id="horaLl">
                                    <option id="0" name="0">00:00</option>
                                    <option id="1" name="1">01:00</option>
                                    <option id="2" name="2">02:00</option>
                                    <option id="3" name="3">03:00</option>
                                    <option id="4" name="4">04:00</option>
                                    <option id="5" name="5">05:00</option>
                                    <option id="6" name="6">06:00</option>
                                    <option id="7" name="7">07:00</option>
                                    <option id="8" name="8">08:00</option>
                                    <option id="9" name="9">09:00</option>
                                    <option id="10" name="10">10:00</option>
                                    <option id="11" name="11">11:00</option>
                                    <option id="12" name="12">12:00</option>
                                    <option id="13" name="13">13:00</option>
                                    <option id="14" name="14">14:00</option>
                                    <option id="15" name="15">15:00</option>
                                    <option id="16" name="16">16:00</option>
                                    <option id="17" name="17">17:00</option>
                                    <option id="18" name="18">18:00</option>
                                    <option id="19" name="19">19:00</option>
                                    <option id="20" name="20">20:00</option>
                                    <option id="21" name="21">21:00</option>
                                    <option id="22" name="22">22:00</option>
                                    <option id="23" name="23">23:00</option>

                                </select>
                            </td>
                            </tr>

                            <% }
                                    } catch (Exception ex) {
                                        out.print(ex);
                                    }
                                }
                            %> 

                            </tbody>
                        </table>
                        <button type="submit" id="x" name="x" class="fluid ui  black button">Insertar Programación Diaria</button>
                    </form>


                </div>

            </div>
        </div>
    </div>


</body>

</html>
<%-- start web service invocation --%>
<%
    if (request.getParameter("x") != null) {
        try {
            servidor.ProgDiaria service = new servidor.ProgDiaria();
            servidor.ProgramacionDiaria port = service.getProgramacionDiariaPort();
            String fecha = request.getParameter("fecha");
%>
<script>
    window.onload = function guardarFecha() {
        document.getElementById("fecha").value = '<%=fecha%>';
    };
</script>
<%
            //String freserva = request.getParameter(name)
            java.util.List<java.lang.String> kreservas = Arrays.asList(request.getParameterValues("kreserva"));
            java.util.List<java.lang.String> puertosS = Arrays.asList(request.getParameterValues("puertoSa"));
            java.util.List<java.lang.String> puertosL = Arrays.asList(request.getParameterValues("puertoLl"));
            java.util.List<java.lang.String> horasS = Arrays.asList(request.getParameterValues("horaSa"));
            java.util.List<java.lang.String> horasL = Arrays.asList(request.getParameterValues("horaLl"));
            out.println(kreservas.get(0) + " " + puertosS.get(0));
            port.insertarProgramacionDiaria(kreservas, puertosS, puertosL, horasS, horasL, fecha);

        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

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



