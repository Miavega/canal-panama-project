<%-- 
    Document   : indexLogin
    Created on : 25/09/2018, 08:48:23 AM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0043)https://semantic-ui.com/examples/login.html -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Standard Meta -->
    <a href="login.jsp"></a>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-witdth, initial-scale=1.0, maximum-scale=1.0">

    <!-- Site Properties -->
    <title>Sistema de Reservas Canal Panamá</title>
    <link rel="shortcut icon" href="images/ship.ico" />
    <link rel="stylesheet" type="text/css" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.3/semantic.js"></script>
    <!--<script src="./Login Example - Semantic_files/jquery.min.js.descarga"></script>
    <!--<script src="./Login Example - Semantic_files/form.js.descarga"></script>
    <script src="./Login Example - Semantic_files/transition.js.descarga"></script>
    <!--<script src="js/login.js"></script>-->

</head>
<body>

    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <h2 class="ui blue image header">
                <img src="./images/logo.png" class="image">
                <div class="content">
                    Sistema de Reserva y Tránsito
                </div>
            </h2>
            <form class="ui large form" method="POST" action="login.jsp">
                <div class="ui stacked segment">
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="user icon"></i>
                            <input type="text" name="usuario" id="usuario" placeholder="Usuario">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <i class="lock icon"></i>
                            <input type="password" name="password"  id="password" placeholder="Contraseña">
                        </div>
                    </div>
                    <button name="confirmar" id="confirmar" type="submit" class="ui fluid large blue submit button">Entrar</button>

                </div>

                <div class="ui error message"></div>

                <%-- start web service invocation --%>
                <%
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
                %>
                <div class="ui negative message">
                    <i class="close icon"></i>
                    <div class="header">
                        Error al iniciar sesión
                    </div>
                    <p><%=ex%></p>
                </div>
                <%
                        }
                    }
                %>
                <%-- end web service invocation --%>

            </form>

            <div class="ui message">
                ¿No está registrado? <a href="https://semantic-ui.com/examples/login.html#">Registrese</a>
            </div>
        </div>
    </div>

</body></html>
