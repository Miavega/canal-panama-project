CREATE OR REPLACE PACKAGE PK_RESERVASCP AS 

    /*----------------------------------------------------------------------------------
    /  Contiene los procedimientos asociados a la gestión de reservas del Canal de Panamá (CP)
    /    Autor: Ladino, Rivera, Guerrero, Vega.
    /    Fecha de creacion: 16/02/2019
    /    Fecha de ultima modificacion:16/02/2019
    /-------------------------------------------------------------------------------------*/
    /*---------------------------------------------------------------------
     Procedimiento en el que un operario del canal de panamá registra los pasos diarios disponibles
     Parametros de Entrada: 
            pk_reserva              Identificacion de la reserva
            pk_puertosalida         Identificador del puesto de salida
            pk_puertollegada        Identificador del puerto de llegada
            pf_progyhorallegada     Fecha programacion y hora de llegada 
            pf_progyhorasalida      Fecha programacion y hora de salida
            pk_identificacion       Identificacion empleado CP
            pk_tipoid               Tipo id empleado CP
      Parametros de Salida:  Ninguno
      Precondicion: Existe una reserva y existe un operario del CP registrado
      Excepcion: Ninguna
     -----------------------------------------------------------------------*/
    PROCEDURE PR_PROGRAMARPASODIARIO(
        pk_reserva reserva.k_reserva%type,
        pk_puertosalida puerto.k_puerto%type,
        pk_puertollegada puerto.k_puerto%type,
        pf_progyhorallegada programaciondiaria.f_progyhorallegada%type,
        pf_progyhorasalida programaciondiaria.f_progyhorasalida%type,
        pk_identificacion empleado.k_identificacion%type,
        pk_tipoid empleado.k_tipoid%type);

    /*---------------------------------------------------------------------
    Funcion para calcular el valor del pago correspondiente a una reserva dependiendo de las dimensiones del buque
     Parametros de Entrada: 
            pk_buque        Identificador del buque que realizó la reserva
     Parametros de Salida:  Ninguno
     Retorna :  Valor a pagar del buque
     Precondicion: Existen datos en la tabla buque para el buque en cuestión y existen datos en tabla tarifa reserva
     Excepcion: Si no existen datos en las tablas de la precondición
    -----------------------------------------------------------------------*/
    FUNCTION FU_CALCULOPAGORESERVA(
        pk_buque buque.k_buque%type)
        RETURN NUMBER;

    /*---------------------------------------------------------------------
     Procedimiento en el que se genera la orden de pago de la reserva para un buque en una fecha de transito en concreto
     Parametros de Entrada: 
            pk_buque        Identificador del buque
            pf_transito     Fecha de transito
      Parametros de Salida:  Ninguno
      Precondicion: Existe una reserva, no se generan excepciones en FU_CALCULOPAGORESERVA
      Excepcion: Que no exista la reserva, exepciones FU_CALCULOPAGORESERVA
     -----------------------------------------------------------------------*/
    PROCEDURE PR_GENORDENESDEPAGO(
        pk_buque reserva.k_buque%type,
        pf_transito reserva.f_transito%type);

    /*---------------------------------------------------------------------
     Funcion que retorna el paso (SUP-REG-NEO) por el que pasaría el buque a transitar
     Parametros de Entrada: 
            pk_buque        Identificador del buque
      Parametros de Salida:  Ninguno
      Retorna :  String del Paso que cumple las condiciones del buque
      Precondicion: Existe una buque y existen datos en tabla paso
      Excepcion: Que no existan datos asociados en la precondición
     -----------------------------------------------------------------------*/
    
    FUNCTION FU_PASOBARCO(
        pk_buque buque.k_buque%type)
        RETURN VARCHAR;
    /*---------------------------------------------------------------------
     Funcion que retorna la cantidad de cupos disponibles programados para cierto buque en una fecha dada
     Parametros de Entrada: 
            pk_buque        Identificador del buque
            pf_transito     Fecha de tránsito de la reserva
      Parametros de Salida:  Ninguno
      Retorna :  Número de cupos disponibles programados
      Precondicion: Existen cupos programados en cupopaso para el paso del barco y la fecha de entrada
      Excepcion: Ninguna
     -----------------------------------------------------------------------*/
    FUNCTION FU_CUPOSFECHA(
        pk_buque buque.k_buque%type,
        pf_transito reserva.f_transito%type)
        RETURN number;
    /*---------------------------------------------------------------------
     Funcion que retorna la cantidad de reservas registradas para determinado buque en determianda fecha
     Parametros de Entrada: 
            pk_buque        Identificador del buque
            pf_transito     Fecha de tránsito de la reserva
      Parametros de Salida:  Ninguno
      Retorna :  Número reservas registradas para el buque en la fecha
      Precondicion: Existen el identificador del buque
      Excepcion: El buque no existe
     -----------------------------------------------------------------------*/
    FUNCTION FU_NUMRESERVAS(
        pk_buque buque.k_buque%type,
        pf_transito reserva.f_transito%type)
        RETURN number;
    /*---------------------------------------------------------------------
     Procedimiento en el que se decuentan cupos para determinado tipo de paso en una fecha concreta, de la tabla cuposdisponibles
     Parametros de Entrada: 
            pk_paso         Identificador del tipo de paso: NEO,SUP,REG
            pf_transito     Fecha de transito
            pq_disponibles  Cantidad de cupos disponibles
      Parametros de Salida:  Ninguno
      Precondicion: Existen registros en la tabla cupopaso para la fecha
      Excepcion: Ninguna
     -----------------------------------------------------------------------*/

    PROCEDURE PR_DESCONTARCUPO(    
        pk_paso paso.k_paso%type,
        pf_transito reserva.f_transito%type,
        pq_disponibles cupopaso.q_cdisponibles%type);
    /*---------------------------------------------------------------------
     Procedimiento para generar la informacion de la empresa del canal de panama
     Parametros de Entrada:  Ninguno
      Parametros de Salida:  
                            pn_empresa      Nombre de la empresa
                            po_dirempresa   Direccion de la empresa
                            po_telempresa   Telefono de la empresa
      Precondicion: Ninguna
      Excepcion:    No hay datos asociados a la Empresa CP
     -----------------------------------------------------------------------*/
    PROCEDURE PR_DATOS_EMPRESA(
        pn_empresa OUT empresacp.n_empresa%type,
        po_dirempresa OUT  empresacp.o_dirempresa%type,
        po_telempresa OUT empresacp.o_telempresa%type);
    
    /*---------------------------------------------------------------------
     Procedimiento para generar la informacion del responsable y el operador barco asociados a una reserva
     Parametros de Entrada: pk_reserva      Identificador de la reserva
      Parametros de Salida:  
                            PK_IDENTIFICACION       Identificacion del responsable
                            PK_TIPOID               Tipo de identificacion
                            PK_TELEFONO             Telefono del responsable
                            PO_EMAIL                Email del responsable
                            PN_OPERADOR             Nombre operador de barco asociado al responsable
                            PN_RESPONSABLEBARCO     Nombre del responsable

      Precondicion: Existe una reserva
      Excepcion:    No hay datos asociados a el responsable o el operario barco
     -----------------------------------------------------------------------*/
    PROCEDURE PR_DATOS_CLIENTE(
        pk_reserva IN reserva.k_reserva%type,
        PK_IDENTIFICACION OUT RESPONSABLE.K_IDENTIFICACION%TYPE,
        PK_TIPOID OUT RESPONSABLE.K_TIPOID%TYPE,
        PK_TELEFONO OUT VARCHAR,
        PO_EMAIL OUT RESPONSABLE.O_EMAIL%TYPE,
        PN_OPERADOR OUT OPERADORBARCO.N_OPERADOR%TYPE,
        PN_RESPONSABLEBARCO OUT VARCHAR);
    
    /*---------------------------------------------------------------------
     Procedimiento para generar la informacion de un buque asociado a una reserva
     Parametros de Entrada:  pk_reserva      Identificador de la reserva
      Parametros de Salida:  
                            PK_BUQUE      Identificador del buque
                            PN_BUQUE      Nombre del buque
                            PN_CATEGORA   Categoria del buque
      Precondicion: Existe una reserva
      Excepcion:    No hay datos asociados al buque de la reserva
     -----------------------------------------------------------------------*/
    PROCEDURE PR_DATOS_BUQUE(
        pk_reserva IN reserva.k_reserva%type,
        PK_BUQUE OUT BUQUE.K_BUQUE%TYPE,
        PN_BUQUE OUT BUQUE.N_BUQUE%TYPE,
        PN_CATEGORA OUT CATEGORIABUQUE.N_CATEGORIA%TYPE);

    /*---------------------------------------------------------------------
     Procedimiento para generar la informacion de la orden de pago asociada a una reserva de tipo RESV o PEAJ
     Parametros de Entrada: pk_reserva      Identificador de la reserva
                            PK_CONCEPTO     Identificador del cocepto RESV o PEAJ
      Parametros de Salida:  
                            PK_ORDENDEPAGO  Identificador del orden de pago
      Precondicion: Existe una reserva
      Excepcion:    No hay una orden de pago asociada a la reserva
     -----------------------------------------------------------------------*/

    PROCEDURE PR_DATOS_ORDENPAGO(
        pk_reserva IN reserva.k_reserva%type,
        PK_CONCEPTO VARCHAR,
        PK_ORDENDEPAGO OUT ORDENDEPAGO.K_ORDENDEPAGO%TYPE);
    /*---------------------------------------------------------------------
     Procedimiento para obtener la información asociada a la orden de pago
     Parametros de Entrada: pk_reserva      Identificador de la reserva
                            PK_ORDENDEPAGO  Identificador de la orden de pago
     Parametros de Salida:  
                            PN_CONCEPTO     Nombre del concepto de la orden de pago
                            PV_ORDENDEPAGO  Valor de la orden de pago
      Precondicion: Existe una reserva y una orden de pago
      Excepcion:    No se encontro el concepto ni el valor de la orden de pago
     -----------------------------------------------------------------------*/
    PROCEDURE PR_DATOS_CONCEPTO_ORDEN_PAGO(
        pk_reserva IN reserva.k_reserva%type,
        PK_ORDENDEPAGO IN ORDENDEPAGO.K_ORDENDEPAGO%TYPE,
        PN_CONCEPTO OUT CONCEPTO.N_CONCEPTO%TYPE,
        PV_ORDENDEPAGO OUT ORDENDEPAGO.V_ORDENDEPAGO%TYPE);

    /*---------------------------------------------------------------------
     Procedimiento para obtener la información del pago asociado a una reserva y una orden de pago
     Parametros de Entrada: pk_reserva          Identificador de la reserva
                            PK_ORDENDEPAGO      Identificador de la orden de pago
     Parametros de Salida:  
                            PO_CUENTAORIGEN     Nombre del concepto de la orden de pago
                            PF_PAGO             Fecha en la que se realizo el pago
                            PV_PAGO             Valor pagado
                            PI_FORMAPAGO        Forma de pago

      Precondicion: Existe una reserva y una orden de pago
      Excepcion:    No se encontraron datos asociados a la reserva o orden de pago
     -----------------------------------------------------------------------*/
    PROCEDURE PR_DATOS_DEL_PAGO(
        pk_reserva IN reserva.k_reserva%type,
        PK_ORDENDEPAGO IN ORDENDEPAGO.K_ORDENDEPAGO%TYPE,
        PO_CUENTAORIGEN OUT PAGO.O_CUENTAORIGEN%TYPE,
        PF_PAGO OUT PAGO.F_PAGO%TYPE,
        PV_PAGO OUT PAGO.V_PAGO%TYPE,
        PI_FORMAPAGO OUT PAGO.I_FORMAPAGO%TYPE);


    /*---------------------------------------------------------------------
     Procedimiento para generar la factura en PDF de una reserva luego de haberla pagado
     Parametros de Entrada: 
            pk_reserva         Identificador de la reserva
      Parametros de Salida:  Ninguno
      Precondicion: Existen una reserva y un pago asociado a esta
      Excepcion:    No hay datos asociados a la Empresa CP
                    No hay datos del Reponsable y el Operador en el cual esta registrado el responsable
                    No hay datos del buque para el que se solicita la factura
                    No hay datos de la orden de pago para la reserva solicitada
                    No hay datos del pago realizado asociado a la orden de pago
                    Errores asociados o propagados por el generador de PDF's

     -----------------------------------------------------------------------*/
    PROCEDURE PR_GENFACTURA(    
        pk_reserva reserva.k_reserva%type);

    /*---------------------------------------------------------------------
     Funcion que retorna el CRN del cliente loggeado para usarse en la consulta de reservas sin pagar
     Parametros de Entrada: NA
      Parametros de Salida:  Ninguno
      Retorna :  el CRN del cliente loggeado
      Precondicion: El cliente está loggeado en el sistema
      Excepcion: Que el cliente no esté conectado o la sesión haya expirado
                 Que el cliente loggeado no esté registrado en la tabla operadorbarco
     -----------------------------------------------------------------------*/
    FUNCTION FU_GETCRNOPERADOR
        RETURN NUMBER;

    /*---------------------------------------------------------------------
     Procedimiento en el que se actualizan los pagos de la reserva, una vez se ha pagado mediante el banco
     Parametros de Entrada: 
            pk_reserva         Identificador de la reserva
            po_cuentaorigen    Numero de cuenta de origen(la que efectuó el pago)
      Parametros de Salida:  Ninguno
      Precondicion: Se ha realizado el pago en el banco, Existe una orden de pago
      Excepcion: No se encontró una orden de pago asociada a los parámetros de entrada
     -----------------------------------------------------------------------*/
    PROCEDURE PR_ACTUALIZARPAGOSRESERVA(    
        pk_reserva reserva.k_reserva%type,
        po_cuentaorigen pago.o_cuentaorigen%type);

    /*---------------------------------------------------------------------
     Procedimiento en el que crea una subasta
     Parametros de Entrada: 
            pk_reserva         Identificador de la reserva
            pf_transito        Fecha de transito
      Parametros de Salida:  Ninguno
      Precondicion: Que al solicitar una reserva la cantidad de cupos para PANX sea 1, es decir el último cupo
                    Que los demás datos de la reserva sean validos
      Excepcion: No se pueden encontrar datos asociados a las fechas de la reserva
     -----------------------------------------------------------------------*/
    PROCEDURE PR_REGISTRARSUBASTA(    
        pk_reserva reserva.k_reserva%type,
        pf_transito reserva.f_transito%type);

    /*---------------------------------------------------------------------
     Procedimiento que realiza la resreva
     Parametros de Entrada: 
            pk_buque            Identificador del buque
            pk_identificacion   Identificador del responsable del buque
            pk_tipoid           Tipo de identificacion del responsable
            pi_tiporeserva      Indice del tipo de la reserva
            pi_dirtransito      Indice direccion de transito
            pf_transito         Fecha de transito
      Parametros de Salida:  Ninguno
      Precondicion: Que no exista una reserva previa
                    Que existan cupos disponibles para el día de tránsito
                    
      Excepcion:   Sin cupos
                   Ya existe una reserva registrada
                   Propagación de excepciones en otros subprocedimientos o funciones
     -----------------------------------------------------------------------*/
    PROCEDURE PR_RESERVA(
        pk_buque buque.k_buque%type,
        pk_identificacion responsable.k_identificacion%type,
        pk_tipoid responsable.k_tipoid%type,
        pi_tiporeserva reserva.i_tiporeserva%type,
        pi_dirtransito reserva.i_dirtransito%type,
        pf_transito reserva.f_transito%type);
    
    /*---------------------------------------------------------------------
      Funcion que retorna el valor del ultima puja
      Parametros de Entrada: pk_subasta   identificador de la subasta
      Parametros de Salida:  Ninguno
      Retorna :  el valor del ultima puja
      Precondicion: Que exista una subasta registrada
      Excepcion: Ninguna
     -----------------------------------------------------------------------*/
    FUNCTION FU_VALPUJA(
        pk_subasta subasta.k_subasta%type)
        RETURN NUMBER;

    /*---------------------------------------------------------------------
     Procedimiento que realiza el registro de una puja
     Parametros de Entrada: 
            pk_subasta          Identificador de la Subasta
            pv_puja             Valor de la puja
            pk_identificacion   Identificacion responsable buque
            pk_tipoid           Tipo identificacion
      Parametros de Salida:  Ninguno
      Precondicion: Que exista una subasta
                    Que existan valores en Subasta                    
      Excepcion:   Que el monto pujado sea inferior a la ultima puja + incremento minimo
     -----------------------------------------------------------------------*/

    PROCEDURE PR_REGISTRARPUJAS(    
        pk_subasta subasta.k_subasta%type,
        pv_puja puja.v_puja%type,
        pk_identificacion responsable.k_identificacion%type,
        pk_tipoid responsable.k_tipoid%type);
    /*---------------------------------------------------------------------
     Procedimiento que realiza el cierre de una subasta
     Parametros de Entrada: 
            pk_subasta          Identificador de la Subasta
      Parametros de Salida:  Ninguno
      Precondicion: Que exista una subasta
                    Que existan datos de transito para el buque que participa en la subasta                  
      Excepcion:    Que no exista el identificador de subasta
                    
     -----------------------------------------------------------------------*/
    PROCEDURE PR_CERRARSUBASTA(    
        pk_subasta subasta.k_subasta%type);



END PK_RESERVASCP;
/
SHOW ERRORS

EXECUTE PK_RESERVASCP.PR_RESERVA(4329,1009228,'CC','O','N','23-11-2019');

EXECUTE PK_RESERVASCP.PR_REGISTRARPUJAS(3,17000,1276165,'CC');