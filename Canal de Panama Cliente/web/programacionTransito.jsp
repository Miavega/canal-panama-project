<%-- 
    Document   : programacionTransito
    Created on : 7/11/2018, 09:41:19 PM
--%>

<%@page import="servidor.CargaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Programación del Tránsito</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="images/ship.ico" />
        <link rel="stylesheet" type="text/css" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.css" />
        <link rel="stylesheet" type="text/css" href="css/styles.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.js"></script>
    </head>

    <body>
        <div class="ui fullscreen modal">
            <div class="header">Añadir Carga para Tránsito de Buque</div>
            <div class="content">
                <form class="ui form" method="POST" id="formCarga" action="programacionTransito.jsp">
                    <div class="four fields">

                        <div class="field">
                            <label>
                                Tipo de Carga
                            </label>
                            <select name="tCarga" id="tCarga">
                                <option value="NA">NO APLICA</option>
                                <option value="GRANO">Granos</option>
                                <option value="CARBO">Carbon</option>
                                <option value="HIERR">Mineral de Hierro</option>
                                <option value="LPG">LPG</option>
                                <option value="CTRAN">CTRAN</option>
                                <option value="CPERM">CPERM</option>
                            </select>
                        </div>
                        <div class="field">
                            <label>
                                Peso
                            </label>
                            <input type="text" name="pesoC" id="pesoC">
                        </div>
                        <div class="field">
                            <label>
                                Unidad de medida
                            </label>
                            <select name="uMedida" id="uMedida">
                                <option value="TON">Toneladas</option>
                                <option value="DWT">Peso Muerto</option>
                                <option value="TM">Carga transportada</option>
                                <option value="MTC">Metros Cúbicos</option>
                                <option value="TEU">20 Pies</option>
                            </select>
                        </div>
                        <div class="field">
                            <label>
                                Lastre
                            </label>
                            <select name="enLastre" id="enLastre">
                                <option value="1">SI</option>
                                <option value="0">NO</option>
                            </select>
                        </div>
                    </div>
                    <div class="actions">
                        <button  id="anadir" name="anadir" class="ui inverted orange button">Añadir</button>
                    </div>
                </form>
            </div>

        </div>


        <div class="ui blue top fixed inverted menu">
            <div class="item">
                <img src="images/logo.png">
            </div>
            <a href="inicio.jsp" class="item">Inicio</a>
            <a href="reservas.jsp" class="item">Mis reservas</a>
            <a href="cupos.jsp" class="item">Programación Cupos</a>
            <a href="programacionDiaria.jsp" class="item" > Programación Diaria</a>
            <a href="#" class="item">Programación Tránsito</a>
            <a href="transaccionesCoordinador.jsp" class="item">Transacciones</a>
            <a href="subastaCliente.jsp" class="item">Subasta</a>

            <form method="POST" action="programacionDiaria.jsp">
                <div class="right menu">
                    <a class="ui item">
                        <button class="ui blue button" name="cerrar" id="cerrar">CERRAR</button>
                    </a>
                </div>
        </div>
    </form>

    <div class="encabezado">
        <h1>Programación Tránsito</h1>
    </div>

    <div class="ui container">

        <div class="ui vertically divided grid">
            <div class="column row">
                <div class="column">
                    <form method="POST" class="ui form" id="formulario" action="programacionTransito.jsp">
                        <h4 class="ui dividing header">Formulario Programación Tránsito</h4>
                        <div class="inline fields">
                            <div class="field">
                                <label>Fecha</label>
                                <input type="date" id="fechita" name="fechita">
                            </div>

                            <div class="field">
                                <button  class="ui red button" name="buscar" id="buscar">BUSCAR</button>
                            </div>

                        </div>


                        <table class="ui inverted yellow table">
                            <thead>
                                <tr>
                                    <th>ID Reserva</th>
                                    <th>ID Buque</th>
                                    <th>Buque</th>
                                    <th>Puerto Llegada</th>
                                    <th>Puerto Salida</th>
                                    <th>Hora Llegada</th>
                                    <th>Hora Salida</th>
                                    <th>Añadir Carga</th>
                                    <th>Tiene Carga</th>
                                </tr>
                            </thead>
                            <tbody>


                            <%-- start web service invocation --%><hr/>
                            <%
                                if (request.getParameter("buscar") != null) {
                                    try {
                                        servidor.ProgDiaria service = new servidor.ProgDiaria();
                                        servidor.ProgramacionDiaria port = service.getProgramacionDiariaPort();
                                        // TODO initialize WS operation arguments here
                                        java.lang.String fTransito = request.getParameter("fechita");
                            %>
                            <script>
                                window.onload = function guardarFecha() {
                                    document.getElementById("fechita").value = '<%=fTransito%>';
                                };
                            </script>
                            <%
                                // TODO process result here
                                java.util.List<servidor.ProgramacionDiariaVO> listaPD = port.leerProgramacionDiaria(fTransito);
                                for (int i = 0; i < listaPD.size(); i++) {
                            %>
                            <tr name="" id="">
                                <td id="k_reserva" name="k_reserva"><%=String.valueOf(listaPD.get(i).getKReserva())%></td>
                                <td id="k_buque" name="k_buque"><%=String.valueOf(listaPD.get(i).getCampoExtra1())%></td>
                                <td id="n_buque" name="n_buque"><%=String.valueOf(listaPD.get(i).getCampoExtra2())%></td>                              
                                <td id="k_puertollegada" name="k_puertollegada"><%=String.valueOf(listaPD.get(i).getKPuertollegada())%></td>
                                <td id="k_puertosalida" name="k_puertosalida"><%=String.valueOf(listaPD.get(i).getKPuertosalida())%></td>
                                <td id="f_horallegada" name="f_horallegada"><%=String.valueOf(listaPD.get(i).getFProgyhorallegada())%></td>
                                <td id="f_horasalida" name="f_horasalida"><%=String.valueOf(listaPD.get(i).getFProgyhorasalida())%></td>


                                <td>
                                    <button class="ui green button anadirCarga" name="anadirCarga" id="anadirCarga">Añadir
                                        Carga</button>
                                </td>
                                <td>
                                    <div class="ui toggle checkbox">
                                        <input type="checkbox" name="confirmarCarga" id="confirmarCarga">
                                        <label>Confirmar</label>
                                    </div>
                                </td>
                            </tr>

                            <%
                                        }
                                    } catch (Exception ex) {
                                        System.out.println("Algo paso" + ex.getMessage());
                                    }
                                }
                            %>

                            </tbody>
                        </table>
                        <button type="submit" id="x" name="x" class="fluid ui  black button">Insertar Programación Transito</button>
                    </form>

                </div>

            </div>
        </div>
    </div>


    <script>

        $(document).ready(function () {

            $('.anadirCarga').click(function () {
                $('.fullscreen.modal').modal('show');
                //alert("sali");
                return false;
            });
        });
    </script>

    <%
        if (request.getParameter("anadir") != null) {
    %>
    <script>alert('<%out.print(request.getParameter("tCarga") + request.getParameter("pesoC") + request.getParameter("uMedida") + request.getParameter("enLastre"));%>');</script>
    <%
            try {
                servidor.Carga_Service service = new servidor.Carga_Service();
                servidor.Carga port = service.getCargaPort();
                // TODO initialize WS operation arguments here
                servidor.CargaVO carga = new servidor.CargaVO();

                //Aqui sería cambiar el setKReserva fijo por un request.getParameter (k_reserva{i} donde {i} es la fila)
                carga.setKReserva(31);
                carga.setNTipocarga(request.getParameter("tCarga"));
                carga.setVPeso(Long.parseLong(request.getParameter("pesoC")));
                carga.setIUnidadmedida(request.getParameter("uMedida"));
                int lastre = Character.getNumericValue(request.getParameter("enLastre").charAt(0));
                carga.setILastre(lastre);

                port.insertarCarga(carga);
            } catch (Exception ex) {
                System.out.println("Sucedió un problema" + ex);
            }
        } else {
            System.out.println("No funciona el botón de Añadir Carga");
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

    <%-- start web service invocation --%><hr/>
    <%
        if(request.getParameter("x")!= null){
        try {
            servidor.Transito_Service service = new servidor.Transito_Service();
            servidor.Transito port = service.getTransitoPort();
            // TODO initialize WS operation arguments here
            long kReserva = 32L;
            port.insertTransitoR(kReserva);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        }
    %>
    <%-- end web service invocation --%><hr/>


</body>

</html>