<%-- 
    Document   : hacerReserva
    Created on : 23/09/2018, 06:49:50 PM
--%>

<%@page import="servidor.ReservaVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Reserva</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="images/ship.ico" />
        <link rel="stylesheet" type="text/css" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/styles.css" />

    </head>

    <body>

        <div class="ui modal pagoReserva">
            <i class="close icon"></i>
            <div class="header">
                <div class="img-banco">

                </div>
                <h3>Registro de pago de reservas Banco CP</h3>
            </div>
            <div class="image content">
                <div class="ui medium image">
                    <img src="images/logo.png">
                </div>
                <div class="description">
                    <div class="ui header">Orden de Pago No. <%=session.getAttribute("numFactura")%>.</div>
                    <form method="POST" action="reserva.jsp" class="ui form">
                        <div class="field">
                            <label>Cliente</label>
                            <input id="numCliente" name="numCliente" type="text" name="Cliente" placeholder="Cliente">
                        </div>
                        <div class="field">
                            <label>Numero de cuenta</label>
                            <input type="text" name="Cuenta" placeholder="Cuenta">
                        </div>
                        <div class="field">
                            <label>Total a pagar</label>
                            <input id="totalPagar" name="totalPagar" type="text" name="cantidad" id="cantidad" readonly="readonly" value="<%=session.getAttribute("valFactura")%>" />
                        </div>
                        <button id="pagarReserva" name="pagarReserva" class="ui button" type="submit">Pagar</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="ui basic modal facturaPDF">
            <div class="ui icon header">
                <i class="archive icon"></i>
                Factura Generada
            </div>
            <div class="content">
                <p>Su Factura ha sido generada correctamente</p>
            </div>
            <div class="actions">
                <div class="ui green ok inverted button">
                    <i class="checkmark icon"></i>
                    Aceptar
                </div>
            </div>
        </div>


        <div class="ui tiny modal">
            <div class="header">Excepción</div>
            <div class="content">
                <p></p>
            </div>

        </div>

        <div class="ui blue top fixed inverted menu">
            <div class="item">
                <img src="images/logo.png">
            </div>
            <a href="inicio.jsp" class="item">Inicio</a>
            <a href="#" class="item">Mis reservas</a>
            <a href="cupos.jsp" class="item">Programación Cupos</a>
            <a href="programacionDiaria.jsp" class="item" > Programación Diaria</a>
            <a href="programacionTransito.jsp" class="item">Programación Tránsito</a>
            <a href="transaccionesCliente.jsp" class="item">Mis Transacciones</a>
            <a href="subastaCliente.jsp" class="item">Subasta</a>

            <form method="POST" action="reserva.jsp">
                <div class="right menu">
                    <a class="ui item">
                        <button class="ui blue button" name="cerrar" id="cerrar">CERRAR</button>
                    </a>
                </div>
            </form>
        </div>

        <div class="encabezado">
            <h1>Solicitud de Reserva</h1>
        </div>

        <div class="ui container">
            <div class="ui vertically divided grid">
                <div class="column row">
                    <div class="column">
                        <form action="reserva.jsp" method="POST" class="ui form" id="formulario" >
                            <h4 class="ui dividing header">Formulario Registro</h4>
                            <div class="field">
                                <div class="five fields">
                                    <div class="field">
                                        <label>ID Buques</label>
                                        <select id="buques" name="buques" value="buques">
                                            <%-- start web service invocation --%>

                                            <%
                                                List listadoBuques = new ArrayList();
                                                String campoS = "";
                                                session.setAttribute("campoN_Buque", "");
                                                String campoN_Buque = session.getAttribute("campoN_Buque").toString();
                                                session.setAttribute("campoC_Buque", "");
                                                String campoC_Buque = session.getAttribute("campoC_Buque").toString();
                                                session.setAttribute("campoN_Operador", "");
                                                String campoN_Operador = session.getAttribute("campoN_Operador").toString();
                                                session.setAttribute("campoN_Responsable", "");
                                                String campoN_Responsable = session.getAttribute("campoN_Responsable").toString();
                                                session.setAttribute("campoV_Manga", "");
                                                String campoV_Manga = session.getAttribute("campoV_Manga").toString();
                                                session.setAttribute("campoV_Loa", "");
                                                String campoV_Loa = session.getAttribute("campoV_Loa").toString();
                                                session.setAttribute("campoV_Pesomuerto", "");
                                                String campoV_Pesomuerto = session.getAttribute("campoV_Pesomuerto").toString();
                                                session.setAttribute("campoV_Velocidad", "");
                                                String campoV_Velocidad = session.getAttribute("campoV_Velocidad").toString();
                                                int campo = 0;
                                                int kBuque = 0;
                                                try {
                                                    servidor.Buque_Service service = new servidor.Buque_Service();
                                                    servidor.Buque port = service.getBuquePort();
                                                    // TODO process result here                                   
                                                    listadoBuques = port.cargarBuques(session.getAttribute("username").toString());
                                                    for (int i = 0; i < listadoBuques.size(); i++) {
                                                        campoS = listadoBuques.get(i).toString();
                                                        campo = Integer.parseInt(campoS);
                                            %>
                                            <option value="<%=campo%>"><%=campo%></option>
                                            <%}
                                            } catch (Exception ex) {
                                            %>
                                            <div class="active ui tiny modal">
                                                <div class="header">Excepción</div>
                                                <div class="content">
                                                    <p>
                                                        Error u excepcion : <%=ex.getMessage()%>
                                                    </p>
                                                </div>

                                            </div>
                                            <%
                                                }
                                                if (request.getParameter("cargarBuque") != null) {
                                                    try {
                                                        servidor.Buque_Service service = new servidor.Buque_Service();
                                                        servidor.Buque port = service.getBuquePort();
                                                        // TODO initialize WS operation arguments here
                                                        kBuque = Integer.valueOf(request.getParameter("buques"));
                                                        for (int i = 0; i < listadoBuques.size(); i++) {
                                                            if (kBuque == Integer.parseInt((listadoBuques.get(i).toString()))) {
                                                                session.setAttribute("buqueSeleccionado", i);
                                                            }
                                                        }
                                            %>
                                            <script>
                                                window.onload = function guardarIDBuque() {
                                                    document.getElementById("buques").selectedIndex = <%=Integer.parseInt(session.getAttribute("buqueSeleccionado").toString())%>;
                                                };
                                            </script>
                                            <%
                                                // TODO process result here
                                                java.util.List< java.lang.Object> result = port.cargarBuque(kBuque);
                                                session.setAttribute("campoN_Buque", result.get(0).toString());
                                                campoN_Buque = session.getAttribute("campoN_Buque").toString();
                                                session.setAttribute("campoC_Buque", result.get(1).toString());
                                                campoC_Buque = session.getAttribute("campoC_Buque").toString();
                                                session.setAttribute("campoN_Operador", result.get(2).toString());
                                                campoN_Operador = session.getAttribute("campoN_Operador").toString();
                                                session.setAttribute("campoN_Responsable", result.get(3).toString());
                                                campoN_Responsable = session.getAttribute("campoN_Responsable").toString();
                                                session.setAttribute("campoV_Manga", result.get(4).toString());
                                                campoV_Manga = session.getAttribute("campoV_Manga").toString();
                                                session.setAttribute("campoV_Loa", result.get(5).toString());
                                                campoV_Loa = session.getAttribute("campoV_Loa").toString();
                                                session.setAttribute("campoV_Pesomuerto", result.get(6).toString());
                                                campoV_Pesomuerto = session.getAttribute("campoV_Pesomuerto").toString();
                                                session.setAttribute("campoV_Velocidad", result.get(7).toString());
                                                campoV_Velocidad = session.getAttribute("campoV_Velocidad").toString();
                                            } catch (Exception ex) {
                                            %>
                                            <div class="active ui tiny modal">
                                                <div class="header">Excepción</div>
                                                <div class="content">
                                                    <p>
                                                        Error u excepcion : <%=ex.getMessage()%>
                                                    </p>
                                                </div>

                                            </div>
                                            <%
                                                    }
                                                }
                                                if (request.getParameter("enviar") != null) {
                                                    try {

                                                        servidor.Reserva_Service service = new servidor.Reserva_Service();
                                                        servidor.Reserva port = service.getReservaPort();
                                                        // TODO initialize WS operation arguments here
                                                        java.lang.String kBuqueR = request.getParameter("buques");
                                                        java.lang.String kEsclusa = request.getParameter("selectE");
                                                        java.lang.String kIdresponsable = request.getParameter("Responsable");
                                                        java.lang.String kTiporeserva = "";

                                                        if (request.getParameter("selectTR") == "Just In Time") {
                                                            kTiporeserva = "J";
                                                        } else {
                                                            kTiporeserva = "O";
                                                        }
                                                        java.lang.String iDirtransito = request.getParameter("selectD");

                                                        java.lang.String fTransito = request.getParameter("fecha");

                                                        // TODO process result here
                                                        port.insertarReserva(kBuqueR, kEsclusa, kIdresponsable, kTiporeserva, iDirtransito, fTransito);

                                                    } catch (Exception ex) {
                                            %>
                                            <script>
                                                alert("Sucedio algo " + "<%=ex%>");
                                            </script>

                                            <%
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
                                            %>
                                            <script>
                                                alert("Sucedio algo " + "<%=ex%>");
                                            </script>

                                            <%
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>

                                    <div class="field">
                                        <label>Nombre Buque</label>
                                        <input type="text" placeholder="Nombre Buque" name="NombreBuque" id="NombreBuque" value="<%=campoN_Buque%>">
                                    </div>

                                    <div class="field">
                                        <label>Categoria Buque</label>
                                        <input type="text" placeholder="Categoria Buque" name="CategoriaBuque" id="CategoriaBuque" value="<%=campoC_Buque%>">
                                    </div>

                                    <div class="field">
                                        <label>Nombre Operador </label>
                                        <input type="text" placeholder="Nombre Operador" name="NOperador" id="NOperador" value="<%=campoN_Operador%>">
                                    </div>

                                    <div class="field">
                                        <label>Responsable</label>
                                        <input type="text" placeholder="Responsable" id="Responsable" name="Responsable" id="Responsable" value="<%=campoN_Responsable%>">
                                    </div>

                                </div>
                            </div>

                            <div class="field">
                                <div class="five fields">
                                    <div class="field">
                                        <label>Valor Manga</label>
                                        <input type="text" placeholder="Valor Manga" name="VManga" id="VManga" value="<%=campoV_Manga%>">
                                    </div>

                                    <div class="field">
                                        <label>Valor Loa</label>
                                        <input type="text" placeholder="Valor Loa" name="VLoa" id="VLoa" value="<%=campoV_Loa%>">
                                    </div>

                                    <div class="field">
                                        <label>Peso Muerto</label>
                                        <input type="text" placeholder="Peso Muerto" name="PMuerto" id="PMuerto" value="<%=campoV_Pesomuerto%>">
                                    </div>

                                    <div class="field">
                                        <label>Velocidad</label>
                                        <input type="text" placeholder="Velocidad" name="Velocidad" id="Velocidad" value="<%=campoV_Velocidad%>">
                                    </div>

                                    <div class="field">
                                        <!--<form methot="POST" target="#" >-->
                                        <label>Validar</label>
                                        <button id="cargarBuque" name="cargarBuque" class="fluid ui blue button" value="cargarBuque">Cargar Datos</button>
                                        <!--</form>-->
                                    </div>

                                </div>
                            </div>


                            <h4 class="ui dividing header">Fecha de solicitud</h4>
                            <div class="two fields">
                                <div class="field">
                                    <input type="date" name="fecha" id="fecha">
                                </div>
                                <div class="field">
                                    <button id="revisarDisponibilidad" name="revisarDisponibilidad" class="fluid ui blue button" value="revisarDisponibilidad" >Revisar Disponibilidad</button>
                                </div>

                            </div>

                            <h4 class="ui dividing header">Información Adicional</h4>
                            <div class="two fields">
                                <div class="field">
                                    <select name="selectTR">
                                        <option name="JustinTime" value="J">Just in Time</option>
                                        <option name="JustinTime" value="O">Ordinario</option>
                                    </select>
                                </div>
                                <div class="field">
                                    <select name="selectD" id="selectD" value="selectD">
                                        <option name="Direccion" value="N">Norte</option>
                                        <option name="Direccion" value="S">Sur</option>
                                    </select>
                                </div>

                            </div>

                            <div class="field">
                                <button class="ui blue button" type="submit" name="enviar" value="enviar">Enviar Solicitud</button>
                                <button class="ui blue button">Guardar como borrador</button>
                                <button class="ui blue button">Regresar a mis visitas/Movimientos</button>
                                <button class="ui orange button">Cerrar</button>                            

                            </div>
                        </form>
                        <form action="reserva.jsp" method="POST">
                            <div id="orden" name="orden" class="ui icon input loading">
                                <input id="txtReserva" name="txtReserva" type="text" placeholder="D?gite el ID de la reserva...">
                                <i class="search icon"></i>
                            </div>
                            <button class="ui blue button" type="submit" name="enviar" value="enviar">Buscar Orden</button>
                        </form>
                        <table class="ui blue table">
                            <thead>
                                <tr>
                                    <th>Identificador Reserva</th>
                                    <th>Buque</th>
                                    <th>Estado de reserva</th>
                                    <th>Tipo  ID</th>
                                    <th>Documento ID</th>
                                    <th>Tipo de Reserva</th>
                                    <th>Direcci?n tr?nsito</th>
                                    <th>Fecha de reserva</th>
                                    <th>Fecha de tr?nsito</th>
                                    <th>Esclusa</th>
                                    <th>Acci?n</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%-- start web service invocation --%>
                                <%
                                    try {
                                        servidor.Reserva_Service service = new servidor.Reserva_Service();
                                        servidor.Reserva port = service.getReservaPort();
                                        // TODO initialize WS operation arguments here
                                        java.util.List<ReservaVO> result = port.leerMisReservas(session.getAttribute("username").toString());

                                        for (int i = 0; i < result.size(); i++) {
                                            session.setAttribute("tipoID", result.get(i).getKTipoid());
                                            session.setAttribute("idR", result.get(i).getKIdentificacion());

                                %>
                                <tr data-valor="<%=result.get(i).getKReserva()%>" class="click">
                                    <td><%=result.get(i).getKReserva()%></td>
                                    <td><%=result.get(i).getKBuque()%></td>
                                    <td><%=result.get(i).getKEstadoreserva()%></td>
                                    <td><%=result.get(i).getKTipoid()%></td>
                                    <td><%=result.get(i).getKIdentificacion()%></td>
                                    <td><%=result.get(i).getITiporeserva()%></td>
                                    <td><%=result.get(i).getIDirtransito()%></td>
                                    <td><%=result.get(i).getFReserva()%></td>
                                    <td><%=result.get(i).getFTransito()%></td>
                                    <td><%=result.get(i).getKEsclusa()%></td>
                                    <td>

                                        <%
                                            try {
                                                servidor.OrdenPago_Service service2 = new servidor.OrdenPago_Service();
                                                servidor.OrdenPago port2 = service2.getOrdenPagoPort();
                                                // TODO initialize WS operation arguments here
                                                java.lang.String kConcepto = "RESV";
                                                long kReserva = result.get(i).getKReserva();
                                                // TODO process result here
                                                java.lang.String result2 = port2.leerEstadoOrdenPago(kConcepto, kReserva);

                                        %>
                                        <% if (result2.equalsIgnoreCase("NPG")) {%>
                                        <button id="pruebaPago" name="pruebaPago <%=result.get(i).getKReserva()%>" class="ui icon button <%=result.get(i).getKReserva()%>" onclick="pagarFactura(this)">
                                            <i id="pagar" name="pagar" class="dollar sign icon"></i>
                                            <input type="hidden" name="hdnbt" />
                                        </button>
                                        <%

                                        } else if (result2.equalsIgnoreCase("PAG")) {
                                        %>
                                        <button id="pruebaPDF" name="pruebaPDF" class="ui icon button" onclick="pagarFactura(this)">
                                            <i id="pdf" name="pdf" class="file pdf outline icon"></i>
                                        </button>
                                        <%
                                        } else {
                                        System.out.println("No hay datos en modal");
                                                }
                                            } catch (Exception ex) {
                                                System.out.println("Ocurri? un error" + ex);
                                            }
                                        %>
                                    </td>
                                </tr>

                                <%                                                  }
                                    } catch (Exception ex) {
                                        // TODO handle custom exceptions here
                                    }
                                %>
                                <%-- end web service invocation --%>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <%
            if (request.getParameter("revisarDisponibilidad") != null) {

                try {

                    servidor.Reserva_Service service = new servidor.Reserva_Service();
                    servidor.Reserva port = service.getReservaPort();
                    // TODO initialize WS operation arguments here
                    java.lang.String kBuque1 = request.getParameter("buques");
                    java.lang.String fAsignacioncupos = request.getParameter("fecha");
                    // TODO process result here
                    servidor.CupoPasoVO result = port.revisarDisponibilidad(String.valueOf(kBuque1), fAsignacioncupos);

                    kBuque = Integer.valueOf(request.getParameter("buques"));
                    for (int i = 0; i < listadoBuques.size(); i++) {
                        if (kBuque == Integer.parseInt((listadoBuques.get(i).toString()))) {
                            session.setAttribute("buqueSeleccionado", i);
                        }
                    }
        %>
        <script>
            window.onload = function guardarIDBuque() {
                document.getElementById("buques").selectedIndex = <%=Integer.parseInt(session.getAttribute("buqueSeleccionado").toString())%>;
            };
        </script>
        <%
            out.println("Result = " + result.getQCdisponibles());
        %><script>alert("<%=result.getQCdisponibles()%>")</script><%
        } catch (Exception ex) {
        %>
        <script>
            alert("Sucedio algo " + "<%=ex%>");
        </script>

        <%
                }
            }
        %>       

        <!-- SCRIPTS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>

        <%
            if (request.getParameter("revisarDisponibilidad") != null) {
                try {
                    servidor.Reserva_Service service = new servidor.Reserva_Service();
                    servidor.Reserva port = service.getReservaPort();
                    // TODO initialize WS operation arguments here
                    java.lang.String kBuque1 = request.getParameter("buques");
                    java.lang.String fAsignacioncupos = request.getParameter("fecha");
                    // TODO process result here
                    servidor.CupoPasoVO result = port.revisarDisponibilidad(String.valueOf(kBuque1), fAsignacioncupos);
                    out.println("Result = " + result.getQCdisponibles());
        %><script>alert("<%=result.getQCdisponibles()%>")</script><%
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
            }

            if (request.getParameter("orden") != null) {
                session.setAttribute("miReserva", request.getParameter("txtReserva"));
            }

            if (request.getParameter("pagarReserva") != null) {
                try {
                    servidor.BancoCP_Service service = new servidor.BancoCP_Service();
                    servidor.BancoCP port = service.getBancoCPPort();
                    // TODO initialize WS operation arguments here
                    long pkCrn = Long.parseLong(request.getParameter("numCliente"));
                    long pvPagar = Long.parseLong(request.getParameter("totalPagar"));
                    // TODO process result here
                    java.lang.Boolean result = port.pagarReserva(pkCrn, pvPagar);
                    if (result) {
                        try {
                            servidor.Pago_Service service2 = new servidor.Pago_Service();
                            servidor.Pago port2 = service2.getPagoPort();
                            // TODO initialize WS operation arguments here
                            int kReserva = Integer.parseInt(session.getAttribute("numFactura").toString());
                            port2.pagarOrdenReserva(kReserva);
                        } catch (Exception ex) {
                            // TODO handle custom exceptions here
                        }

                    }
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
            }
        %>
        <%-- end web service invocation --%>  

        <!-- SCRIPTS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.js"></script>
        <!-- CUSTOMS -->
        <script>
            function pagarFactura(boton) {
                $(boton).click(function (e) {
                    e.preventDefault();
                    var data = $(this).attr("data-valor");
                    $('#txtReserva').val(data);
                    if (boton.id === 'pruebaPDF') {
                        $(".facturaPDF").modal('show');
                        return false;
                    } else {
            <%                try {
                    servidor.OrdenPago_Service service3 = new servidor.OrdenPago_Service();
                    servidor.OrdenPago port3 = service3.getOrdenPagoPort();
                    // TODO initialize WS operation arguments here
                    java.lang.String kReservaModal = request.getParameter("txtReserva");
                    java.lang.String kConceptoModal = "RESV";
                    // TODO process result here
                    if (kReservaModal != null) {
                        servidor.OrdenPagoVO result3 = port3.leerOrdenPago(kReservaModal, kConceptoModal);
                        session.setAttribute("numFactura", result3.getKOrdendepago());
                        session.setAttribute("valFactura", result3.getVOrdendepago());
                    }
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
            %>
                        $(".pagoReserva").modal('show');
                        return false;
                    }
                });
            }
        </script>

    </body>

</html>
