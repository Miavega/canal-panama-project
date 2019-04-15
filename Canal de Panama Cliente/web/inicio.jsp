<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <link rel="shortcut icon" href="images/ship.ico" />

        <title>Inicio</title>

        <link rel="stylesheet" type="text/css" href="css/styles.css" />
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/reset.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/site.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/container.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/grid.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/header.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/image.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/menu.css">

        <link rel="stylesheet" type="text/css" href="paginaInicio_files/divider.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/dropdown.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/segment.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/button.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/list.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/icon.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/sidebar.css">
        <link rel="stylesheet" type="text/css" href="paginaInicio_files/transition.css">

        <script src="paginaInicio_files/jquery.js"></script>
        <script src="paginaInicio_files/visibility.js"></script>
        <script src="paginaInicio_files/sidebar.js"></script>
        <script src="paginaInicio_files/transition.js"></script>
        <script src="js/index.js"></script>
    </head>

    <body class="pushable">

        <!-- Following Menu -->
        <div class="ui blue top fixed inverted menu">
            <div class="item">
                <img src="images/logo.png">
            </div>
            <a href="#" class="item">Inicio</a>
            <a href="reserva.jsp" class="item">Mis reservas</a>
            <a href="cupos.jsp" class="item">Programación Cupos</a>
            <a href="programacionDiaria.jsp" class="item" > Programación Diaria</a>
            <a href="programacionTransito.jsp" class="item">Programación Tránsito</a>
            <a href="transaccionesCliente.jsp" class="item">Transacciones</a>
            <a href="subastaCliente.jsp" class="item">Subasta</a>


            <form method="POST" action="inicio.jsp">
                <div class="right menu">
                    <a class="ui item">
                        <button class="ui blue button" name="cerrar" id="cerrar">CERRAR</button>
                    </a>
                </div>
            </form>
        </div>


        <!-- Page Contents -->
        <div class="pusher">
            <div class="ui inverted vertical masthead center aligned segment">
                <div class="ui text container">
                    <h1 class="ui  white inverted header">
                        Información General del Canal de Panamá
                    </h1>
                    <h2>Un vistazo a los retos del pasado , presente y futuro.</h2>
                    <div class="ui red button">Leer Más</div>
                </div>

            </div>

            <div class="ui vertical stripe segment">
                <div class="ui middle aligned stackable grid container">
                    <div class="row">
                        <div class="eight wide column">
                            <h3 class="ui header">El Canal</h3>
                            <p align="justify">Considerado como una de las grandes obras de la ingeniería mundial del siglo XX,el canal
                                funciona a
                                través de esclusas en cada extremo
                                que elevan los barcos hasta el lago Gatún, un lago artificial creado para reducir la cantidad de trabajo
                                requerido para la excavación del
                                canal, a 26 metros sobre el nivel del mar, para después descenderlos hasta el nivel del Pacífico o el
                                Atlántico. Antes de su apertura,
                                los pasos naturales utilizados entre los océanos Atlántico y Pacífico eran el estrecho de Magallanes y el
                                cabo de Hornos,
                                ubicados en el extremo austral de Chile y Argentina.?</p>
                        </div>
                        <div class="six wide right floated column">
                            <img src="images/canal.jpg" class="ui large bordered rounded image">
                        </div>
                    </div>
                    <div class="row">
                        <div class="center aligned column">
                            <a class="ui huge button" href="https://micanaldepanama.com/">Página Oficial del Canal de Panamá</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="ui inverted vertical footer segment">
                <div class="ui container">
                    <div class="ui stackable inverted divided equal height stackable grid">
                        <div class="three wide column">
                            <h4 class="ui inverted header">Sobre Nosotros</h4>
                            <div class="ui inverted link list">
                                <a href="#" class="item">Mapa del sitio</a>
                                <a href="#" class="item">Contactenos</a>
                                <a href="#" class="item">Chat </a>
                                <a href="#" class="item">NARVAL y Cia.</a>
                            </div>
                        </div>
                        <div class="three wide column">
                            <h4 class="ui inverted header">Servicios</h4>
                            <div class="ui inverted link list">
                                <a href="#" class="item">Old Man</a>
                                <a href="#" class="item">PQR</a>
                                <a href="#" class="item">Tutorial</a>
                                <a href="#" class="item">Universidad Distrital</a>
                            </div>
                        </div>
                        <div class="seven wide column">
                            <h4 class="ui inverted header">M3R Team</h4>
                            <p>Proyecto Final para la Asignatura Bases de Datos II . Año 2018</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>




    </body>

</html>

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

