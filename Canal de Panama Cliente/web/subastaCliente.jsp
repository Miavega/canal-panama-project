<%-- 
    Document   : subastaCliente
    Created on : 6/03/2019, 03:14:24 PM
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <a href="subastaCliente.jsp" class="item">Subasta</a>
            <form method="POST" action="programacionDiaria.jsp">
                <div class="right menu">
                    <a class="ui item">
                        <button class="ui blue button" name="cerrar" id="cerrar">CERRAR</button>
                    </a>
                </div>
            </form>
        </div>
    </form>

    <h2 class="ui center aligned icon header encabezado"><i class="circular red hand point up icon"></i></i>
    Subasta y Pujas</h2>

<div class="ui container">



    <div class="ui vertically divided grid">
        <div class="row">
            <div class="eight wide column ">
                <div class="ui container">
                    <h2 class="ui header">
                        <i class="red star icon"></i>
                        <div class="content">Subastas
                        </div>
                    </h2>
                    <div class="ui segment">
                        <form class="ui form" method="POST" action="subastaCliente.jsp">
                            <div class=" field">
                                <label>Reserva</label>
                                <select id="select_kReserva" >


                                    <%
                                        try {
                                            servidor.Reserva_Service service = new servidor.Reserva_Service();
                                            servidor.Reserva port = service.getReservaPort();
                                            // TODO initialize WS operation arguments here
                                            java.lang.String usuario = session.getAttribute("username").toString();
                                            // TODO process result here
                                            java.util.List<servidor.ReservaVO> reservasPEN = port.leerMisReservas(usuario);

                                            for (int i = 0; i < reservasPEN.size(); i++) {
                                                if (reservasPEN.get(i).getKEstadoreserva().equalsIgnoreCase("PEN")) {
                                                    session.setAttribute("resSubasta", reservasPEN.get(i).getKReserva());
                                    %>
                                    <option id="reserva"><%=String.valueOf(reservasPEN.get(i).getKReserva())%></option>
                                    <%

                                                }
                                            }
                                        } catch (Exception ex) {
                                            System.out.println("No se pudo buscar las reservas pendientes" + ex.getMessage());
                                        }
                                    %>


                                </select>
                            </div>

                            <div class=" field">
                                <button type="submit" class="fluid ui red button" id="buscarSubasta" name="buscarSubasta">Buscar Subasta</button>
                            </div>
                            <%
                                if (request.getParameter("buscarSubasta") != null) {
                                    try {
                                        servidor.Subasta_Service service = new servidor.Subasta_Service();
                                        servidor.Subasta port = service.getSubastaPort();
                                        // TODO initialize WS operation arguments here
                                        long kReserva = Long.parseLong(session.getAttribute("resSubasta").toString());
                            %>
                            <script>
                                alert('<%=kReserva%>');
                            </script>
                            <%
                                // TODO process result here
                                java.util.List<servidor.SubastaVO> subastaList = port.buscarSubasta(kReserva);

                                for (int i = 0; i < subastaList.size(); i++) {
                                    session.setAttribute("k_subasta", subastaList.get(i).getKSubasta());

                            %>


                            <div class="two fields">
                                <div class=" field">
                                    <label>Fecha de Apertura</label>
                                    <input id="lf_apertura" readonly="" type="text" value="<%=String.valueOf(subastaList.get(i).getFAperturasubasta())%>">
                                </div>
                                <div class="field">
                                    <label>Fecha de Vencimiento</label>
                                    <input id="lf_vencimiento" readonly="" type="text" value="<%=String.valueOf(subastaList.get(i).getFVencimientosubasta())%>">
                                </div>
                            </div>
                            <div class="two fields">
                                <div class="field">
                                    <label>Fecha de Tránsito</label>
                                    <input id="lf_transito" readonly="" type="text" value="<%=String.valueOf(subastaList.get(i).getFCuposubasta())%>">
                                </div>
                                <div class="field">
                                    <label>Valor Actual de la Puja</label>
                                    <input id="lvi_puja" readonly="" type="text" value="<%=String.valueOf(subastaList.get(i).getVPujainicial())%>">
                                </div>
                            </div>

                            <div class="field">
                                <label>Valor de Incremento</label>
                                <input id="lvin_puja" readonly="" type="text" value="<%=String.valueOf(subastaList.get(i).getVIncrementominimo())%>">
                            </div>

                            <%
                                        }
                                    } catch (Exception ex) {
                                        System.out.println("Error" + ex.getMessage());
                                    }
                                }
                            %>
                        </form>
                    </div>
                </div>
            </div>
            <div class="eight wide column ">
                <div class="ui container">
                    <h2 class="ui header">
                        <i class="red dollar sign icon"></i>
                        <div class="content">Hacer puja
                        </div>
                    </h2>
                    <div class="ui segment">
                        <form  method="POST" action="subastaCliente.jsp" class="ui form">
                            <div class="field">
                                <label>Valor de la puja</label>
                                <input id="v_puja" name="v_puja" placeholder="Valor de la puja" type="number">
                            </div>
                            <div class="inline field">
                                <div class="ui checkbox">
                                    <input type="checkbox" tabindex="0" class="hidden">
                                    <label>Acepto los términos y condiciones</label>
                                </div>
                            </div>
                            <button class="fluid ui red button" id="enviarPuja" name="enviarPuja">Hacer puja</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="sixteen wide column ">
                <div class="ui container">
                    <h2 class="ui header">
                        Mis Pujas
                    </h2>
                    <table class="ui red table">
                        <thead>
                            <tr>
                                <th>Subasta</th>
                                <th>ID Puja</th>
                                <th>Fecha Puja</th>
                                <th>Valor Puja</th>
                                <th>Estado Puja</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>


                                <%
                                    try {
                                        servidor.Puja_Service service = new servidor.Puja_Service();
                                        servidor.Puja port = service.getPujaPort();
                                        // TODO initialize WS operation arguments here
                                        long kIdentificacion = Long.parseLong(String.valueOf(session.getAttribute("idR")));
                                        java.lang.String kTipoid = String.valueOf(session.getAttribute("tipoID"));
                                        java.util.List<servidor.PujaVO> misPu = port.leerMisPujas(kIdentificacion, kTipoid);

                                        for (int i = 0; i < misPu.size(); i++) {
                                            String[] fe = misPu.get(i).getFPuja().split(" ");
                                %>

                                <td id="k_subasta" name="k_subasta"> <%=String.valueOf(misPu.get(i).getKSubasta())%></td>
                                <td id="k_puja" name="k_puja"><%= String.valueOf(misPu.get(i).getKPuja())%></td>
                                <td id="f_puja" name="f_puja"><%=fe[0]%></td>
                                <td id="v_puja" name="v_puja"><%= String.valueOf(misPu.get(i).getVPuja())%></td>
                                <td id="n_estado" name="n_estado"><%= String.valueOf(misPu.get(i).getNEstadopuja())%></td>

                                <%
                                        }

                                    } catch (Exception ex) {
                                        // TODO handle custom exceptions here
                                    }
                                %>



                            </tr>

                        </tbody>
                    </table>

                </div>
            </div>
        </div>

    </div>
</div>
</div>


<%
    if (request.getParameter("enviarPuja") != null) {

        try {
            servidor.Puja_Service service = new servidor.Puja_Service();
            servidor.Puja port = service.getPujaPort();
            // TODO initialize WS operation arguments here
            long kSubasta = Long.parseLong(String.valueOf(session.getAttribute("k_subasta")));

            long vPuja = Long.parseLong(String.valueOf(request.getParameter("v_puja")));
%>
<script>
    alert('<%=vPuja%>');
</script>
<%
    long kIdentificacion = Long.parseLong(String.valueOf(session.getAttribute("idR")));
    java.lang.String kTipoid = String.valueOf(session.getAttribute("tipoID"));%>
<script>
    alert('<%=kSubasta%>' + ' vPuja ' + '<%=vPuja%>' + ' kIdentificacion ' + '<%=kIdentificacion%>' + ' tipoID ' + '<%=kTipoid%>');
</script>
<%
            port.crearPuja(kSubasta, vPuja, kIdentificacion, kTipoid);
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    } else {
        System.out.println("No se pudo realizar la puja");
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