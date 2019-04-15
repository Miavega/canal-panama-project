<%-- 
    Document   : transaccionesCliente
    Created on : 6/03/2019, 11:04:40 AM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Mis Transacciones</title>
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
            <a href="#" class="item">Mis Transacciones</a>
            <a href="subastaCliente.jsp" class="item">Subasta</a>

            <form method="POST" action="transaccionesCliente.jsp">
                <div class="right menu">
                    <a class="ui item">
                        <button class="ui blue button" name="cerrar" id="cerrar">CERRAR</button>
                    </a>
                </div>
            </form>
        </div>


        <h2 class="ui center aligned icon header encabezado"><i class="circular money bill green alternate icon"></i>
            Transacciones</h2>

        <div class="ui container">

            <div class="ui vertically divided grid">
                <div class="column row">
                    <div class="column">
                        <form method="POST" class="ui form" id="formulario" action="transaccionesCliente.jsp">
                            <h4 class="ui dividing header">Consulta de mis movimientos y transacciones</h4>
                            <button class="ui red button" id="cargarPagos" name="cargarPagos">Cargar</button>
                            <table class="ui red fixed table">
                                <thead>
                                    <tr>
                                        <th>Orden Pago</th>
                                        <th>Reserva </th>
                                        <th>Concepto</th>
                                        <th>Valor Total</th>
                                        <th>Estado de Pago</th>
                                        <th>Fecha</th>
                                        <th>Valor Pagado</th>
                                        <th>Cuenta Origen</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                        if (request.getParameter("cargarPagos") != null) {
                                            try {
                                                servidor.Pago_Service service = new servidor.Pago_Service();
                                                servidor.Pago port = service.getPagoPort();
                                                // TODO initialize WS operation arguments here
                                                long kIdentificacion = 1276165;
                                                java.lang.String kTipoid = "CC";
                                                // TODO process result here
                                                java.util.List<servidor.PagoVO> pagos = port.leerPagosCliente(kIdentificacion, kTipoid);

                                                for (int i = 0; i < pagos.size(); i++) {
                                    %>


                                    <tr>
                                        <td id="k_ordenP" name="k_ordenP"><%=String.valueOf(pagos.get(i).getKOrdendepago())%></td>
                                        <td id="k_reserva" name="k_reserva"><%=String.valueOf(pagos.get(i).getCampoExtra1())%></td>
                                        <td id="n_concepto" name="n_concepto"><%=String.valueOf(pagos.get(i).getCampoExtra2())%></td>
                                        <td id="v_ordenP" name="v_ordenP"><%=String.valueOf(pagos.get(i).getCampoExtra3())%></td>
                                        <td id="i_estado" name="i_estado"><%=String.valueOf(pagos.get(i).getCampoExtra4())%></td>
                                        <td id="f_pago" name="f_pago"><%=String.valueOf(pagos.get(i).getFPago())%></td>
                                        <td id="v_pago" name="v_pago"><%=String.valueOf(pagos.get(i).getVPago())%></td>
                                        <td id="o_cuentao" name="o_cuentao"><%=String.valueOf(pagos.get(i).getOCuentaorigen())%></td>

                                    </tr>
                                    <%

                                                }
                                            } catch (Exception ex) {
                                                System.out.println(ex.getMessage());
                                            }
                                        }
                                    %>



                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>

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
