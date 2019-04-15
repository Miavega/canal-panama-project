CREATE OR REPLACE PACKAGE BODY PK_RESERVASCP AS

    PROCEDURE PR_PROGRAMARPASODIARIO(
    pk_reserva reserva.k_reserva%type,
    pk_puertosalida puerto.k_puerto%type,
    pk_puertollegada puerto.k_puerto%type,
    pf_progyhorallegada programaciondiaria.f_progyhorallegada%type,
    pf_progyhorasalida programaciondiaria.f_progyhorasalida%type,
    pk_identificacion empleado.k_identificacion%type,
    pk_tipoid empleado.k_tipoid%type)
    as
    BEGIN
        INSERT 
        INTO programaciondiaria
        VALUES (NULL,
                pk_puertollegada,
                pk_puertosalida,
                pf_progyhorallegada,
                pf_progyhorasalida,
                pk_identificacion,
                pk_tipoid,            
                pk_reserva);
        COMMIT;
    END PR_PROGRAMARPASODIARIO;

    FUNCTION FU_CALCULOPAGORESERVA(pk_buque buque.k_buque%type)
    RETURN NUMBER
    as 
        lv_manga buque.v_manga%type:=0;
        lv_loa buque.v_loa%type:=0;
        lv_tarifa NUMBER:=0;
    BEGIN
        SELECT v_manga,v_loa
        INTO lv_manga,lv_loa
        FROM BUQUE
        WHERE k_buque=pk_buque;       
        SELECT V_TARIFARESERVA
        INTO lv_tarifa
        FROM TARIFARESERVA
        WHERE (lv_manga BETWEEN V_MANGAINICIAL AND V_MANGAFINAL)
        AND (lv_loa BETWEEN V_LOAINICIAL AND V_LOAFINAL);
        RETURN lv_tarifa;    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20001,'NO EXISTEN DATOS EN LA TABLA BUQUE O EN LA TABLA TARIFA RESERVA PARA EL BUQUE '||pk_buque);
    END FU_CALCULOPAGORESERVA;

    PROCEDURE PR_GENORDENESDEPAGO(
            pk_buque reserva.k_buque%type,
            pf_transito reserva.f_transito%type)
        as
        lk_reserva reserva.k_reserva%type;
        lv_pagoreserva NUMBER :=0;
        BEGIN
        SELECT R.k_reserva
        INTO lk_reserva
        FROM RESERVA R
        WHERE R.K_BUQUE = pk_buque AND R.F_TRANSITO = pf_transito;
        lv_pagoreserva := FU_CALCULOPAGORESERVA(pk_buque);
        --GENERAR ORDEN DE PAGO PARA LA RESERVA
        INSERT INTO ORDENDEPAGO
        VALUES (NULL, lk_reserva, 'RESV',
        lv_pagoreserva, SYSDATE, pf_transito - 1 ,'NPG');

        --GENERAR ORDEN DE PAGO PARA PEAJE NPG, EL VALOR SE ACTUALIZA MÁS ADELANTE
        INSERT INTO ORDENDEPAGO
        VALUES (NULL, lk_reserva, 'PEAJ',
        1, pf_transito, pf_transito ,'NPG');

        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20030,'NO EXISTEN EN RESERVA PARA LOS DATOS DE ENTRADA');
            ROLLBACK;
        WHEN OTHERS THEN
            RAISE_APPLICATION_ERROR(-20031,'ERROR DE TIPO: '|| SQLCODE || SQLERRM);
            ROLLBACK;

    END PR_GENORDENESDEPAGO;

    FUNCTION FU_PASOBARCO(pk_buque buque.k_buque%type)
    RETURN VARCHAR
    as 
        lv_manga buque.v_manga%type;
        lv_loa buque.v_loa%type;
        lk_paso varchar(3):=' ';
    BEGIN
        SELECT v_manga,v_loa
        INTO lv_manga,lv_loa
        FROM BUQUE
        WHERE k_buque=pk_buque;

        SELECT K_PASO
        INTO lk_paso
        FROM PASO
        WHERE (lv_manga BETWEEN V_MINMANGA AND V_MAXMANGA)
        AND (lv_loa BETWEEN V_MINLOA AND V_MAXLOA);
    RETURN lk_paso;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20002,'NO SE PUEDE DETERMINAR EL PASO DE LA EMBARCACIÓN '||pk_buque||' NO EXISTEN DATOS EN LA TABLA BUQUE O EN LA TABLA PASO PARA EL BUQUE ');
    END FU_PASOBARCO;

    FUNCTION FU_CUPOSFECHA(pk_buque buque.k_buque%type, pf_transito reserva.f_transito%type)
    RETURN number
    as 
        lv_manga buque.v_manga%type;
        lv_loa buque.v_loa%type;
        lq_cdisponibles number:=0;
        lk_pasobarco varchar(3);
    BEGIN
    lk_pasobarco := FU_PASOBARCO(pk_buque);
    SELECT Q_CDISPONIBLES
    INTO lq_cdisponibles
    FROM PASO P, CUPOPASO C
    WHERE P.K_PASO = lk_pasobarco
    AND P.K_PASO = C.K_PASO
    AND C.F_ASIGNACIONCUPOS = pf_transito;
    RETURN lq_cdisponibles;
    EXCEPTION
    WHEN no_data_found THEN
        RAISE_APPLICATION_ERROR(-20007,'No existen cupos programados para la fecha '||pf_transito);     
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20002,'ERROR DE TIPO: '|| SQLCODE || SQLERRM);
    END FU_CUPOSFECHA;


    FUNCTION FU_NUMRESERVAS(pk_buque buque.k_buque%type, pf_transito reserva.f_transito%type)
    RETURN number
    as 
        lq_reservas number;
    BEGIN
    SELECT COUNT(R.K_RESERVA)
    INTO lq_reservas
    FROM RESERVA R
    WHERE R.K_BUQUE = pk_buque
    AND R.F_TRANSITO = pf_transito;  
        RETURN lq_reservas;
    END FU_NUMRESERVAS;



    PROCEDURE PR_DESCONTARCUPO(    
        pk_paso paso.k_paso%type,
        pf_transito reserva.f_transito%type,
        pq_disponibles cupopaso.q_cdisponibles%type)
    as
    BEGIN
    IF pk_paso = 'NEO' THEN  
        UPDATE CUPOPASO C
        SET Q_CDISPONIBLES = (pq_disponibles - 1)
        WHERE C.F_ASIGNACIONCUPOS = pf_transito
        AND C.K_PASO = 'NEO';
    ElSIF pk_paso = 'SUP' THEN
        UPDATE CUPOPASO C
        SET Q_CDISPONIBLES = (pq_disponibles - 1)
        WHERE C.F_ASIGNACIONCUPOS = pf_transito
        AND C.K_PASO = 'SUP';
    ELSE      
        UPDATE CUPOPASO C
        SET Q_CDISPONIBLES = (pq_disponibles - 1)
        WHERE C.F_ASIGNACIONCUPOS = pf_transito
        AND C.K_PASO = 'REG';   
    END IF;
    END PR_DESCONTARCUPO;

    PROCEDURE PR_DATOS_EMPRESA(pn_empresa OUT empresacp.n_empresa%type,
                               po_dirempresa OUT  empresacp.o_dirempresa%type,
                               po_telempresa OUT empresacp.o_telempresa%type)
    AS
    BEGIN
        SELECT N_EMPRESA, O_TELEMPRESA, O_DIREMPRESA
        INTO pn_empresa, po_dirempresa, po_telempresa
        FROM EMPRESACP
        WHERE K_IDEMPRESA='EM01';
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20010,'NO EXISTEN DATOS EN LA TABLA EMPRESA PARA GENERAR LA FACTURA');
    END PR_DATOS_EMPRESA;

    PROCEDURE PR_DATOS_CLIENTE(pk_reserva IN reserva.k_reserva%type,
                               PK_IDENTIFICACION OUT RESPONSABLE.K_IDENTIFICACION%TYPE,
                               PK_TIPOID OUT RESPONSABLE.K_TIPOID%TYPE,
                               PK_TELEFONO OUT VARCHAR,
                               PO_EMAIL OUT RESPONSABLE.O_EMAIL%TYPE,
                               PN_OPERADOR OUT OPERADORBARCO.N_OPERADOR%TYPE,
                               PN_RESPONSABLEBARCO OUT VARCHAR)
    AS
    BEGIN
        SELECT R.K_IDENTIFICACION, R.K_TIPOID, R.O_TELEFONOFIJO ||' - '|| R.O_CELULAR, R.O_EMAIL, O.N_OPERADOR, P.N_NOMBRE1 ||' '|| P.N_NOMBRE2 ||' '|| P.N_APELLIDO1 ||' '|| P.N_APELLIDO2
        INTO PK_IDENTIFICACION, PK_TIPOID, PK_TELEFONO, PO_EMAIL, PN_OPERADOR, PN_RESPONSABLEBARCO
        FROM RESPONSABLE R, RESERVA RE, OPERADORBARCO O, PERSONA P
        WHERE pk_reserva = RE.K_RESERVA  
        AND RE.K_IDENTIFICACION = R.K_IDENTIFICACION
        AND RE.K_TIPOID = R.K_TIPOID
        AND O.K_CRN = R.K_CRN
        AND R.K_IDENTIFICACION = P.K_IDENTIFICACION
        AND RE.K_TIPOID = P.K_TIPOID;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20011,'NO EXISTEN DATOS DEL RESPONSABLE O DEL OPERARIO ASOCIADO A LA RESERVA: '||pk_reserva);
    END PR_DATOS_CLIENTE;

    PROCEDURE PR_DATOS_BUQUE(pk_reserva IN reserva.k_reserva%type,
                               PK_BUQUE OUT BUQUE.K_BUQUE%TYPE,
                               PN_BUQUE OUT BUQUE.N_BUQUE%TYPE,
                               PN_CATEGORA OUT CATEGORIABUQUE.N_CATEGORIA%TYPE)
    AS
    BEGIN
        SELECT B.K_BUQUE, B.N_BUQUE, CB.N_CATEGORIA
        INTO PK_BUQUE, PN_BUQUE, PN_CATEGORA
        FROM BUQUE B, CATEGORIABUQUE CB, RESERVA R
        WHERE pk_reserva = R.K_RESERVA  
        AND R.K_BUQUE=B.K_BUQUE
        AND B.K_CATEGORIA=CB.K_CATEGORIA;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20012,'NO EXISTEN DATOS ASOCIADOS AL BUQUE DE LA RESERVA:'||pk_reserva);
    END PR_DATOS_BUQUE;

    PROCEDURE PR_DATOS_ORDENPAGO(pk_reserva IN reserva.k_reserva%type,
                               PK_CONCEPTO VARCHAR,
                               PK_ORDENDEPAGO OUT ORDENDEPAGO.K_ORDENDEPAGO%TYPE)
    AS
    BEGIN
        SELECT K_ORDENDEPAGO
        INTO PK_ORDENDEPAGO
        FROM ORDENDEPAGO O
        WHERE pk_reserva = O.K_RESERVA
        AND O.K_CONCEPTO = PK_CONCEPTO;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20013,'NO EXISTEN DATOS ASOCIADOS A LA ORDEN DE PAGO DE LA RESERVA:'||pk_reserva||' DEL CONCEPTO: '||PK_CONCEPTO);
    END PR_DATOS_ORDENPAGO;

    
    PROCEDURE PR_DATOS_ORDENDEPAGO(pk_reserva IN reserva.k_reserva%type,
                               PK_BUQUE OUT BUQUE.K_BUQUE%TYPE,
                               PN_BUQUE OUT BUQUE.N_BUQUE%TYPE,
                               PN_CATEGORA OUT CATEGORIABUQUE.N_CATEGORIA%TYPE)
    AS
    BEGIN
        SELECT B.K_BUQUE, B.N_BUQUE, CB.N_CATEGORIA
        INTO PK_BUQUE, PN_BUQUE, PN_CATEGORA
        FROM BUQUE B, CATEGORIABUQUE CB, RESERVA R
        WHERE pk_reserva = R.K_RESERVA  
        AND R.K_BUQUE=B.K_BUQUE
        AND B.K_CATEGORIA=CB.K_CATEGORIA;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20014,'NO EXISTEN DATOS ASOCIADOS AL BUQUE DE LA RESERVA:'||pk_reserva);
    END PR_DATOS_ORDENDEPAGO;

    PROCEDURE PR_DATOS_CONCEPTO_ORDEN_PAGO(pk_reserva IN reserva.k_reserva%type,
                               PK_ORDENDEPAGO IN ORDENDEPAGO.K_ORDENDEPAGO%TYPE,
                               PN_CONCEPTO OUT CONCEPTO.N_CONCEPTO%TYPE,
                               PV_ORDENDEPAGO OUT ORDENDEPAGO.V_ORDENDEPAGO%TYPE)
    AS
    BEGIN
        SELECT C.N_CONCEPTO, O.V_ORDENDEPAGO
        INTO PN_CONCEPTO, PV_ORDENDEPAGO
        FROM RESERVA R, ORDENDEPAGO O, CONCEPTO C
        WHERE pk_reserva = R.K_RESERVA
        AND O.K_ORDENDEPAGO = PK_ORDENDEPAGO
        AND O.K_CONCEPTO = C.K_CONCEPTO;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20015,'NO SE ENCONTRO CONCEPTO NI VALOR DE LA ORDEN DE PAGO ASOCIADO A LA RESERVA:'||pk_reserva);
    END PR_DATOS_CONCEPTO_ORDEN_PAGO;

    PROCEDURE PR_DATOS_DEL_PAGO(pk_reserva IN reserva.k_reserva%type,
                               PK_ORDENDEPAGO IN ORDENDEPAGO.K_ORDENDEPAGO%TYPE,
                               PO_CUENTAORIGEN OUT PAGO.O_CUENTAORIGEN%TYPE,
                               PF_PAGO OUT PAGO.F_PAGO%TYPE,
                               PV_PAGO OUT PAGO.V_PAGO%TYPE,
                               PI_FORMAPAGO OUT PAGO.I_FORMAPAGO%TYPE)
    AS
    BEGIN
        SELECT P.O_CUENTAORIGEN, P.F_PAGO, P.V_PAGO, P.I_FORMAPAGO
        INTO PO_CUENTAORIGEN, PF_PAGO, PV_PAGO, PI_FORMAPAGO
        FROM RESERVA R, ORDENDEPAGO O, PAGO P
        WHERE pk_reserva = R.K_RESERVA
        AND R.K_RESERVA = O.K_RESERVA
        AND O.K_ORDENDEPAGO = P.K_ORDENDEPAGO
        AND O.K_ORDENDEPAGO=PK_ORDENDEPAGO;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20016,'NO SE ENCONTRARON DATOS DEL PAGO PARA LA RESERVA'||pk_reserva||' Y ORDEN: '|| PK_ORDENDEPAGO);
    END PR_DATOS_DEL_PAGO;


    
    PROCEDURE PR_GENFACTURA(    
        pk_reserva reserva.k_reserva%type
    )
    as
    ln_empresa empresacp.n_empresa%type;
    lo_dirempresa empresacp.o_dirempresa%type;
    lo_telempresa empresacp.o_telempresa%type;
    LK_IDENTIFICACION RESPONSABLE.K_IDENTIFICACION%TYPE;
    LK_TIPOID RESPONSABLE.K_TIPOID%TYPE;
    LK_TELEFONO VARCHAR(43);
    LO_EMAIL RESPONSABLE.O_EMAIL%TYPE;
    LN_OPERADOR OPERADORBARCO.N_OPERADOR%TYPE;
    LN_RESPONSABLEBARCO VARCHAR(204);
    LK_BUQUE BUQUE.K_BUQUE%TYPE;
    LN_BUQUE BUQUE.N_BUQUE%TYPE;
    LN_CATEGORA CATEGORIABUQUE.N_CATEGORIA%TYPE;
    LN_CONCEPTO CONCEPTO.N_CONCEPTO%TYPE;
    LV_ORDENDEPAGO ORDENDEPAGO.V_ORDENDEPAGO%TYPE;
    LK_ORDENDEPAGO ORDENDEPAGO.K_ORDENDEPAGO%TYPE;
    LO_CUENTAORIGEN PAGO.O_CUENTAORIGEN%TYPE;
    LF_PAGO PAGO.F_PAGO%TYPE;
    LV_PAGO PAGO.V_PAGO%TYPE;
    LI_FORMAPAGO PAGO.I_FORMAPAGO%TYPE;

    BEGIN

    --Obtener datos de la empresa del canal de panamá
    PR_DATOS_EMPRESA(ln_empresa,lo_dirempresa,lo_telempresa);
    --Obtener datos del cliente, persona responsable y operador al que pertenece el responsable
    PR_DATOS_CLIENTE(pk_reserva,LK_IDENTIFICACION,LK_TIPOID,LK_TELEFONO,LO_EMAIL,LN_OPERADOR,LN_RESPONSABLEBARCO);
    --Obtener datos del buque 
    PR_DATOS_BUQUE(pk_reserva,LK_BUQUE,LN_BUQUE,LN_CATEGORA);
    --Obtener el K_ORDENDEPAGO DE LA RESV
    PR_DATOS_ORDENPAGO(pk_reserva, 'RESV', LK_ORDENDEPAGO);
    --Obtener datos de la orden de pago    
    PR_DATOS_CONCEPTO_ORDEN_PAGO(pk_reserva,LK_ORDENDEPAGO,LN_CONCEPTO,LV_ORDENDEPAGO);
    --Obtener datos del pago
    PR_DATOS_DEL_PAGO(pk_reserva,LK_ORDENDEPAGO,LO_CUENTAORIGEN,LF_PAGO,LV_PAGO,LI_FORMAPAGO);

    --Encabezado
    as_pdf3.init;
    as_pdf3.put_image( 'PDF', 'logocp2.png', 650, 715);
    as_pdf3.set_font( 'helvetica', 8 );
    as_pdf3.put_txt( 300, 708, ln_empresa );
    as_pdf3.put_txt( 285, 698, 'Dir.: '||lo_dirempresa );
    as_pdf3.put_txt( 285, 690, 'Tel.: '||lo_telempresa );
    as_pdf3.set_font( 'helvetica', 'b' );
    as_pdf3.write( 'Orden de pago No.:' || LK_ORDENDEPAGO, p_y => 680, p_alignment => 'right' );
    as_pdf3.write( 'Fecha: '||SYSDATE, p_y => 675, p_alignment => 'right' );
    as_pdf3.write( 'Cliente.:', p_y => 650, p_alignment => 'left' );

    --Datos Responsable Buque
    as_pdf3.set_font( 'helvetica', 'b' );
    as_pdf3.put_txt( 70, 630, LN_RESPONSABLEBARCO);
    as_pdf3.set_font( 'helvetica', 8 );
    as_pdf3.put_txt( 70, 620, LK_TIPOID || ': '|| LK_IDENTIFICACION);
    as_pdf3.put_txt( 70, 610, 'TEL: '|| LK_TELEFONO);
    as_pdf3.put_txt( 70, 600, 'EMAIL: '|| LO_EMAIL);
    as_pdf3.set_font( 'helvetica', 'b' );
    as_pdf3.put_txt( 70, 590, 'Rep. Legal: '|| LN_OPERADOR);
    as_pdf3.put_txt( 350, 640, 'Buque.:');

    --Datos Buque
    as_pdf3.set_font( 'helvetica', 8 );
    as_pdf3.put_txt( 370, 630, 'Id. Barco: '|| LK_BUQUE);
    as_pdf3.put_txt( 370, 620, LN_BUQUE);
    as_pdf3.put_txt( 370, 610, 'Categoria: '|| LN_CATEGORA);  

    --Lineas Tabla
    for i in 1 .. 2 loop
        -- (X ini, Y inicial , X Largo Fin, Grosor linea)
        as_pdf3.horizontal_line(50, 580 - i * 15, 500, 1 );
    end loop;
    for i in 1 .. 2 loop    
        as_pdf3.horizontal_line(50, 200 - i * 15, 500, 1 );
    end loop;
    as_pdf3.vertical_line(50 + 0 * 250, 170, 395.5, 1);
    as_pdf3.vertical_line(50 + 1 * 300, 170, 395.5, 1);
    as_pdf3.vertical_line(50 + 2 * 250, 170, 395.5, 1);

    --Titulos Tabla
    as_pdf3.set_font( 'helvetica', 'b', 10 );
    as_pdf3.put_txt( 160, 555, 'Descripcion');
    as_pdf3.put_txt( 440, 555, 'Valor');
    as_pdf3.put_txt( 310, 175, 'Total');

    --Detalle / Valor
    as_pdf3.set_font( 'helvetica', 8 );
    as_pdf3.put_txt( 60, 530, LN_CONCEPTO);
    as_pdf3.put_txt( 370, 530, LV_ORDENDEPAGO);
    as_pdf3.put_txt( 370, 175, 'U$D ' || LV_ORDENDEPAGO);

    --Datos Pago
    as_pdf3.set_font( 'helvetica', 'b' );
    as_pdf3.write( 'Detalle Pago.:', p_y => 150, p_alignment => 'left' );
    as_pdf3.set_font( 'helvetica', 8 );
    as_pdf3.put_txt( 100, 140, 'Cta Origen: ' || LO_CUENTAORIGEN);
    as_pdf3.put_txt( 100, 130, 'Fecha de Pago: ' || LF_PAGO);
    as_pdf3.put_txt( 100, 120, 'Forma de Pago: ' || LI_FORMAPAGO);
    as_pdf3.put_txt( 100, 110, 'Valor de Pago: ' || LV_PAGO);

    --Pie de pagina
    as_pdf3.set_font( 'helvetica', 8 );
    as_pdf3.put_txt( 230, 60, 'Gracias por hacer negocios con nosotros!');
    as_pdf3.set_font( 'helvetica','I',10 );
    as_pdf3.put_txt( 220, 40, 'Canal de Panama, Nos encantan los Retos');


    as_pdf3.save_pdf(p_dir=>'PDF',p_filename=>'ORDENPAGO_'||LK_ORDENDEPAGO||'.pdf');
    
    EXCEPTION
        WHEN no_data_found THEN     
        RAISE_APPLICATION_ERROR(-20032,'No se encontraron datos para la orden de pago'); 
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20033,'ERROR DE TIPO: '|| SQLCODE || SQLERRM);
    END PR_GENFACTURA;
       
    FUNCTION FU_GETCRNOPERADOR
    RETURN NUMBER
    AS  
        LK_CRN OPERADORBARCO.K_CRN%TYPE;
        LN_USUARIO VARCHAR(20);
    BEGIN 
    SELECT SYS_CONTEXT ('USERENV', 'SESSION_USER') 
    INTO LN_USUARIO
    FROM DUAL;

    SELECT O.K_CRN
    INTO LK_CRN
    FROM OPERADORBARCO O
    WHERE N_OPERADOR = (SUBSTR(LN_USUARIO,3));

    RETURN LK_CRN;

    EXCEPTION 
        WHEN NOT_LOGGED_ON THEN
            RAISE_APPLICATION_ERROR(-20034,'No esta conectado a la DB'); 
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20035,'No se pudo encontrar el CRN del operador del barco asociado'); 
    END FU_GETCRNOPERADOR;

   PROCEDURE PR_ACTUALIZARPAGOSRESERVA(    
        pk_reserva reserva.k_reserva%type,
        po_cuentaorigen pago.o_cuentaorigen%type)
    as
        LK_ORDENDEPAGO ORDENDEPAGO.K_ORDENDEPAGO%TYPE;
        LV_ORDENDEPAGO ORDENDEPAGO.V_ORDENDEPAGO%TYPE;
    BEGIN
        SELECT O.K_ORDENDEPAGO, O.V_ORDENDEPAGO
        INTO LK_ORDENDEPAGO, LV_ORDENDEPAGO
        FROM ORDENDEPAGO O, RESERVA R
        WHERE R.K_RESERVA = pk_reserva
        AND R.K_RESERVA = O.K_RESERVA
        AND O.K_CONCEPTO = 'RESV';

        INSERT INTO PAGO VALUES (NULL, LK_ORDENDEPAGO, SYSDATE, LV_ORDENDEPAGO, 'TC', po_cuentaorigen);
        UPDATE ORDENDEPAGO SET N_ESTADOPAGO = 'PAG' WHERE K_ORDENDEPAGO = LK_ORDENDEPAGO;

        COMMIT;

        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                RAISE_APPLICATION_ERROR(-20036,'No se encontro una orden de pago para la reserva '||pk_reserva); 

    END PR_ACTUALIZARPAGOSRESERVA;

    PROCEDURE PR_REGISTRARSUBASTA(    
        pk_reserva reserva.k_reserva%type,
        pf_transito reserva.f_transito%type)
    as
        LF_RESERVA RESERVA.F_RESERVA%TYPE;
        LF_TRANSITO RESERVA.F_TRANSITO%TYPE;
        LN_SUBASTA SUBASTA.K_SUBASTA%TYPE;
        LK_SUBASTA SUBASTA.K_SUBASTA%TYPE;
    BEGIN
    --OBTENER DATOS DE LAS FECHAS
        SELECT F_RESERVA, F_TRANSITO
        INTO LF_RESERVA , LF_TRANSITO
        FROM RESERVA
        WHERE K_RESERVA=pk_reserva;
    --VERIFICAMOS SI EXISTE O NO LA SUBASTA REGISTRADA
        SELECT COUNT(K_SUBASTA)
        INTO LN_SUBASTA 
        FROM SUBASTA
        WHERE F_CUPOSUBASTA=pf_transito;
    --SI NO HAY REGISTRO INSERTA EN RESERVASUBASTA
        IF (LN_SUBASTA=0) THEN
            --REGISTRO EN SUBASTA
            --LA SUBASTA SE VENCE 5 DÍAS ANTES DE LA FECHA DE TRÁNSITO DE LA RESERVA
            --EL VALOR DE LA PUJA INICIAL SERÁ DE $15000 Y EL INCREMENTO MÍNIMO SERÁ DE $1000 
            INSERT INTO SUBASTA VALUES (NULL,LF_RESERVA,LF_TRANSITO - 5,LF_TRANSITO,15000,1000);
        END IF;
        --CONSULTAMOS EL K_SUBASTA 
        SELECT K_SUBASTA
        INTO LK_SUBASTA 
        FROM SUBASTA
        WHERE F_CUPOSUBASTA=pf_transito;
        --INSERTA DATOS EN RESERVASUBASTA
        INSERT INTO RESERVASUBASTA VALUES(LK_SUBASTA, pk_reserva);  

        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20006,'NO SE ENCONTRARON DATOS DE FECHAS EN LA TABLA RESERVA PARA LA RESERVA '||pk_reserva);

    END PR_REGISTRARSUBASTA;

    PROCEDURE PR_RESERVA(
        pk_buque buque.k_buque%type,
        pk_identificacion responsable.k_identificacion%type,
        pk_tipoid responsable.k_tipoid%type,
        pi_tiporeserva reserva.i_tiporeserva%type,
        pi_dirtransito reserva.i_dirtransito%type,
        pf_transito reserva.f_transito%type)
    as
        lq_cuposdisponibles number:=0;
        ln_estadoreserva reserva.n_estadoreserva%type;
        lq_panxtotales number := 0;
        lk_esclusa varchar(4);
        lk_paso varchar(3);
        le_sincupos EXCEPTION;
        le_existereserva EXCEPTION;  
        ex_cuposubasta EXCEPTION;
        lk_reserva reserva.k_reserva%type;
    --variable que determina si hay que ejecutar procedimiento de subasta luego de reservar (0=false,1=true)
        ln_registrarsubasta number :=0;
    BEGIN
        --CheckPoint
        --Revisar que no existe una reserva para la misma fecha y el mismo barco
        IF FU_NUMRESERVAS(pk_buque, pf_transito) = 1 THEN
            RAISE le_existereserva;
        END IF;
        --Definir el tipo de buque
        lk_paso := FU_PASOBARCO(pk_buque);
        /*Consulta de cupo paso disponible para el buque seleccionado*/
        lq_cuposdisponibles := FU_CUPOSFECHA(pk_buque,pf_transito);
        --Se obtiene la esclusa por la que puede pasar el barco, si no es neopanamx, pasa por panamax
        IF (lk_paso= 'NEO') THEN
            lk_esclusa:='NEOX';
        ELSE
            lk_esclusa:='PANX';
        END IF;
        
        IF lk_paso = 'NEO' AND lq_cuposdisponibles = 0 THEN
            --No hay Cupos Exception
            RAISE le_sincupos;
        ElSIF lk_paso = 'NEO' AND lq_cuposdisponibles > 0 THEN
            --Descontar 1 cupo de NEO
            PR_DESCONTARCUPO('NEO', pf_transito, lq_cuposdisponibles);
            ln_estadoreserva:= 'ACE';
            --Insertar Reserva
        ElSIF lk_paso = 'SUP' OR lk_paso = 'REG' THEN
            --Consulta numero de cupos SUP+REG = PANX
            SELECT SUM(C.Q_CDISPONIBLES)
            INTO lq_panxtotales
            FROM CUPOPASO C
            WHERE (C.K_PASO = 'REG' OR C.K_PASO = 'SUP') AND C.F_ASIGNACIONCUPOS = pf_transito;    
            IF lq_panxtotales = 0 THEN
            --Significa que no hay cupos / ya se subasto.
            RAISE le_sincupos;
            ELSIF lq_panxtotales = 1 THEN
            --Significa que pasa a subasta.
            ln_estadoreserva:= 'PEN';
            dbms_output.put_line('Se tramita reserva por subasta.');
            ln_registrarsubasta:=1;
            --Llamar funcion Subastar    
            ELSE
            --Revisamos en donde quedan cupos
            IF lk_paso = 'SUP' and lq_cuposdisponibles > 0 THEN
                --Descontar 1 cupo de SUP
                PR_DESCONTARCUPO('SUP', pf_transito, lq_cuposdisponibles);
                ln_estadoreserva:= 'ACE';
            ELSIF lk_paso = 'SUP' and lq_cuposdisponibles = 0 THEN
                --No hay Cupos Exception
                RAISE le_sincupos;
            ELSIF lk_paso = 'REG' and lq_cuposdisponibles > 0 THEN
                --Descontar 1 cupo de REG
                PR_DESCONTARCUPO('REG', pf_transito, lq_cuposdisponibles);
                ln_estadoreserva:= 'ACE';
            ELSE
                --No hay Cupos Exception
                RAISE le_sincupos;
            END IF;
            END IF;
        END IF;
        --Se realiza la reserva si no se llego a ninguna Exception
        --Arriba se define si el estado es ACE / PEN
            INSERT 
            INTO reserva
            VALUES (NULL,
                    pk_buque,
                    ln_estadoreserva,
                    pk_identificacion,
                    pk_tipoid,
                    pi_tiporeserva,
                    pi_dirtransito,
                    SYSDATE,
                    pf_transito,
                    lk_esclusa
                );
        --Hay que registrar una subasta si el valor es 1
        IF(ln_registrarsubasta=1) THEN
            SELECT R.K_RESERVA
            INTO lk_reserva
            FROM RESERVA R
            WHERE K_BUQUE = pk_buque
            AND R.F_TRANSITO = pf_transito;
            dbms_output.put_line('K_reserva para subasta'||lk_reserva||'pftransito'||pf_transito); 
            PR_REGISTRARSUBASTA(lk_reserva, pf_transito);
            dbms_output.put_line('Su cupo esta en tramite para subasta.'); 
        ELSE
            --Llamar funcion calcular pago resrva    
            PR_GENORDENESDEPAGO(pk_buque, pf_transito);
        END IF;
        
        dbms_output.put_line('Reserva realizada con exito.');
        COMMIT;
    EXCEPTION
        WHEN le_sincupos THEN
            RAISE_APPLICATION_ERROR(-20037,'No se puede realizar la reserva, no hay cupos para la fecha.');
            ROLLBACK; 
        WHEN le_existereserva THEN 
            RAISE_APPLICATION_ERROR(-20038,'Ya existe una reserva para el buque en la fecha de tránsito.'); 
            ROLLBACK;   
        WHEN OTHERS THEN 
            RAISE_APPLICATION_ERROR(-20039,'ERROR DE TIPO: '|| SQLCODE || SQLERRM);
            ROLLBACK;

    END PR_RESERVA;

    /*Lógica del negocio para pujar: cuando una reserva queda tramitada por subasta su estado qeuda en PEN=pendiente
    por lo que el cliente tiene la opción de pujar o no por el cupo, para pujar se llama el procedimiento a continuación, sin embargo
    la idea es la siguiente, existe un menú en el que le deja consultar las reservas del cliente, cuando selecciona una reserva con estado ACE
    se cargan los detalles de la reserva y un botón pujar bloqueado, si se selecciona una reserva con estado PEN sale el botón pujar desbloqueado
    ese botón cargará una ventana con los detalles de la subasta, el valor de la última puja y el incremento mínimo*/

    FUNCTION FU_VALPUJA(pk_subasta subasta.k_subasta%type)
    RETURN NUMBER
    AS  
        LV_PUJA PUJA.V_PUJA%TYPE:=0;
        LV_REGISTROS PUJA.V_PUJA%TYPE:=1;
    BEGIN 
        SELECT COUNT(P.V_PUJA)
        INTO LV_REGISTROS
        FROM PUJA P
        WHERE P.K_SUBASTA = pk_subasta;

        IF LV_REGISTROS = 0 THEN 
            SELECT S.V_PUJAINICIAL
            INTO LV_PUJA
            FROM SUBASTA S
            WHERE S.K_SUBASTA = pk_subasta;
        ELSE
            SELECT *
            INTO LV_PUJA
            FROM (SELECT P.V_PUJA
            FROM PUJA P
            WHERE P.K_SUBASTA = pk_subasta
            ORDER BY 1 DESC)
            WHERE ROWNUM <= 1;
        END IF;
        RETURN LV_PUJA;
    END FU_VALPUJA;


    PROCEDURE PR_REGISTRARPUJAS(    
        pk_subasta subasta.k_subasta%type,
        pv_puja puja.v_puja%type,
        pk_identificacion responsable.k_identificacion%type,
        pk_tipoid responsable.k_tipoid%type)
    as
        LV_INCREMENTOMINIMO SUBASTA.V_INCREMENTOMINIMO%TYPE;
        LV_ULTIMAPUJA PUJA.V_PUJA%TYPE;
        LV_PUJAVALIDA PUJA.V_PUJA%TYPE:=0;
        LV_PUJAINICIAL SUBASTA.V_PUJAINICIAL%TYPE;
        EX_PUJAINSUFICIENTE EXCEPTION;
    BEGIN
    --CONSULTA INCREMENTO MÍNIMO
        SELECT S.V_INCREMENTOMINIMO, S.V_PUJAINICIAL
        INTO LV_INCREMENTOMINIMO, LV_PUJAINICIAL
        FROM SUBASTA S
        WHERE S.K_SUBASTA = pk_subasta;
        --CONSULTA VALOR ULTIMA PUJA
        LV_ULTIMAPUJA := FU_VALPUJA(pk_subasta);
        LV_PUJAVALIDA:=LV_ULTIMAPUJA + LV_INCREMENTOMINIMO;
        --REVISAR QUE LA NUEVA PUJA SEA MAYOR QUE ULTIMA + INCREMENTO
        IF(pv_puja >= LV_PUJAVALIDA OR LV_ULTIMAPUJA = LV_PUJAINICIAL) THEN
            INSERT INTO PUJA VALUES (pk_subasta, NULL, SYSTIMESTAMP, pv_puja, 'PCS',pk_identificacion,pk_tipoid);
        ELSE
            RAISE EX_PUJAINSUFICIENTE;
        END IF;
        COMMIT;
        EXCEPTION
        WHEN EX_PUJAINSUFICIENTE THEN
            RAISE_APPLICATION_ERROR(-20040,'LA PUJA DE '||pv_puja||' NO PUEDE SER INFERIOR A '||LV_PUJAVALIDA);        
    END PR_REGISTRARPUJAS;


    PROCEDURE PR_CERRARSUBASTA(    
        pk_subasta subasta.k_subasta%type)
    as 
        LV_FACTORMAYORO NUMBER(12,10);
        LV_FACTORMAYORP NUMBER(12,10);
        LV_PORCENTAJEO NUMBER(6,5) := 0.75;
        LV_PORCENTAJEP NUMBER(6,5) := 0.35;
        LV_FACTORMAXO NUMBER(7,5);
        LV_FACTORMAXP NUMBER(7,5);
        LV_MAYORTRANSITO NUMBER(5);
        LV_ITERACION NUMBER:=0;
        LK_RESERVA RESERVA.K_RESERVA%TYPE;
        LV_PUJAMAYOR PUJA.V_PUJA%TYPE;
        LF_TRANSITOSUBASTA RESERVA.F_TRANSITO%TYPE;
        LK_CUPOPASO CUPOPASO.K_CUPOPASO%TYPE;
        LV_AUXCUPOPASO CUPOPASO.Q_CDISPONIBLES%TYPE;
    CURSOR C_CLASPUJA IS
        SELECT FINALC.ID, FINALC.TIPO, FINALC.FACTOROFERTA + FINALC.FACTORTRANSITO
        FROM(
        SELECT T_OFERTA.K_IDENTIFICACION AS ID , T_OFERTA.K_TIPOID AS TIPO, T_OFERTA.VALPUJA, T_OFERTA.VALPUJA2 AS FACTOROFERTA, T_TRANSITO.T_TRANS, T_TRANSITO.T_TRANS * LV_FACTORMAYORP AS FACTORTRANSITO
        FROM(
        SELECT K_IDENTIFICACION, K_TIPOID, VALPUJA, (VALPUJA * LV_FACTORMAYORO) AS VALPUJA2
        FROM(  
        SELECT K_IDENTIFICACION, K_TIPOID, MAX(V_PUJA) AS VALPUJA
        FROM PUJA
        WHERE K_SUBASTA=pk_subasta
        GROUP BY K_IDENTIFICACION, K_TIPOID) CONS
        ) T_OFERTA, (
        SELECT COUNT(T.K_TRANSITO) AS T_TRANS, R.K_IDENTIFICACION
        FROM (SELECT DISTINCT K_IDENTIFICACION , K_TIPOID
        FROM PUJA 
        WHERE K_SUBASTA = pk_subasta) CON, RESPONSABLE R, RESERVA RE, TRANSITO T
        WHERE RE.K_IDENTIFICACION = R.K_IDENTIFICACION
        AND RE.K_TIPOID = R.K_TIPOID
        AND RE.K_RESERVA = T.K_RESERVA
        AND CON.K_IDENTIFICACION = R.K_IDENTIFICACION
        AND CON.K_TIPOID = R.K_TIPOID
        GROUP BY R.K_IDENTIFICACION) T_TRANSITO
        WHERE T_OFERTA.K_IDENTIFICACION = T_TRANSITO.K_IDENTIFICACION) FINALC
        ORDER BY 3 DESC;
    
    BEGIN
        -- 50 ES LA MAXIMA CALIFICACION
        --CALCULO LV_FACTORMAXO
        LV_FACTORMAXO := LV_PORCENTAJEO * 50;
        --CALCULO LV_FACTORMAXP
        LV_FACTORMAXP := LV_PORCENTAJEP * 50;

        --CALCULO FACTOR SUBASTA CONCRETA OFERTA
        LV_FACTORMAYORO := LV_FACTORMAXO / FU_VALPUJA(pk_subasta);
        --CALCULO FACTOR NUMERO TRANSITOS
        SELECT *
        INTO LV_MAYORTRANSITO
        FROM
        (SELECT COUNT(T.K_TRANSITO) AS T_TRANS
        FROM (SELECT DISTINCT K_IDENTIFICACION , K_TIPOID
        FROM PUJA 
        WHERE K_SUBASTA = pk_subasta) CON, RESPONSABLE R, RESERVA RE, TRANSITO T
        WHERE RE.K_IDENTIFICACION = R.K_IDENTIFICACION
        AND RE.K_TIPOID = R.K_TIPOID
        AND RE.K_RESERVA = T.K_RESERVA
        AND CON.K_IDENTIFICACION = R.K_IDENTIFICACION
        AND CON.K_TIPOID = R.K_TIPOID
        GROUP BY R.K_IDENTIFICACION
        ORDER BY T_TRANS DESC)
        WHERE ROWNUM <= 1;

        LV_FACTORMAYORP := LV_FACTORMAXP / LV_MAYORTRANSITO;

        --RECORRER CURSOR PARTICIPANTES
        --EL PRIMER REGISTRO ES EL GANADOR
        FOR RC_CLASPUJA IN C_CLASPUJA LOOP
            IF LV_ITERACION = 0 THEN 
            --ACTUALIZAR PUJA GANADORA     
            SELECT * INTO LV_PUJAMAYOR FROM(
                SELECT V_PUJA FROM PUJA
                WHERE K_SUBASTA = pk_subasta 
                AND K_IDENTIFICACION = RC_CLASPUJA.ID
                AND K_TIPOID = RC_CLASPUJA.TIPO
                ORDER BY 1 DESC) LIMITAR
            WHERE ROWNUM <= 1; 

            UPDATE PUJA SET N_ESTADOPUJA = 'GAN'
            WHERE K_SUBASTA = pk_subasta 
            AND K_IDENTIFICACION = RC_CLASPUJA.ID
            AND K_TIPOID = RC_CLASPUJA.TIPO
            AND V_PUJA = LV_PUJAMAYOR;
            --ACTUALIZAR ESTADO DE LAS DEMÁS PUJAS
            UPDATE PUJA SET N_ESTADOPUJA = 'PER'
            WHERE K_SUBASTA = pk_subasta 
            AND K_IDENTIFICACION = RC_CLASPUJA.ID
            AND K_TIPOID = RC_CLASPUJA.TIPO
            AND N_ESTADOPUJA = 'PCS';

            --ACTUALIZAR RESERVA GANADORA
            SELECT R.K_RESERVA, R.F_TRANSITO
            INTO LK_RESERVA, LF_TRANSITOSUBASTA
            FROM RESERVA R, SUBASTA S
            WHERE R.K_IDENTIFICACION = RC_CLASPUJA.ID
            AND R.K_TIPOID = RC_CLASPUJA.TIPO
            AND R.N_ESTADORESERVA = 'PEN'
            AND S.K_SUBASTA = pk_subasta
            AND R.F_TRANSITO = S.F_CUPOSUBASTA;

            UPDATE RESERVA SET N_ESTADORESERVA = 'ACE'
            WHERE K_RESERVA = LK_RESERVA;

            --GENERAR ORDENES DE PAGO
            --GENERAR ORDEN DE PAGO PARA LA RESERVA
            INSERT INTO ORDENDEPAGO
            VALUES (NULL, LK_RESERVA, 'RESV', LV_PUJAMAYOR, SYSDATE, SYSDATE + 3 ,'NPG');
            --GENERAR ORDEN DE PAGO PARA PEAJE NPG, EL VALOR SE ACTUALIZA MÁS ADELANTE
            INSERT INTO ORDENDEPAGO
            VALUES (NULL, LK_RESERVA, 'PEAJ', 1, LF_TRANSITOSUBASTA, LF_TRANSITOSUBASTA, 'NPG');

            --DESCONTAR CUPO
            SELECT K_CUPOPASO, Q_CDISPONIBLES
            INTO LK_CUPOPASO, LV_AUXCUPOPASO 
            FROM CUPOPASO
            WHERE F_ASIGNACIONCUPOS = LF_TRANSITOSUBASTA
            AND K_PASO = 'REG';

            IF LV_AUXCUPOPASO = 1 THEN
                UPDATE CUPOPASO SET Q_CDISPONIBLES = 0
                WHERE K_CUPOPASO = LK_CUPOPASO;
            ELSE
                UPDATE CUPOPASO SET Q_CDISPONIBLES = 0
                WHERE F_ASIGNACIONCUPOS = LF_TRANSITOSUBASTA
                AND K_PASO = 'SUP';
            END IF;
            --CAMBIAR LV_ITERACION
            LV_ITERACION := 1;
            ELSE
            --PARA TODOS LOS DEMAS PARTICIPANTES EL ESTADO RESERVA SE CAMBIA A CANCELADO Y TODAS LAS PUJAS PASAN A ESTADO PERDIDAS
            --ACTUALIZAR ESTADO DE LAS DEMÁS PUJAS
            UPDATE PUJA SET N_ESTADOPUJA = 'PER'
            WHERE K_SUBASTA = pk_subasta 
            AND K_IDENTIFICACION = RC_CLASPUJA.ID
            AND K_TIPOID = RC_CLASPUJA.TIPO
            AND N_ESTADOPUJA = 'PCS';
            --ACTUALIZAR ESTADO RESERVA CANCELADA
            SELECT R.K_RESERVA, R.F_TRANSITO
            INTO LK_RESERVA, LF_TRANSITOSUBASTA
            FROM RESERVA R, SUBASTA S
            WHERE R.K_IDENTIFICACION = RC_CLASPUJA.ID
            AND R.K_TIPOID = RC_CLASPUJA.TIPO
            AND R.N_ESTADORESERVA = 'PEN'
            AND S.K_SUBASTA = pk_subasta
            AND R.F_TRANSITO = S.F_CUPOSUBASTA;

            UPDATE RESERVA SET N_ESTADORESERVA = 'CAN'
            WHERE K_RESERVA = LK_RESERVA;

            END IF;
        END LOOP;
        --COMO EL PROCEDIMIENTO SE EJECUTA MANUALMENTE, LA SUBASTA VENCE EL MISMO DIA QUE SE EJECUTA EL PROCEDIMIENTO Y SE SELECCIONA EL GANADOR
        --ESTO FACILITA QUE EL BOTÓN DE CERRAR SUBASTA SE HABILITE O SE BLOQUEE CUANDO SEA NECESARIO
        UPDATE SUBASTA SET F_VENCIMIENTOSUBASTA = SYSDATE
        WHERE K_SUBASTA = pk_subasta;
        COMMIT; 
    EXCEPTION
        WHEN no_data_found THEN     
            RAISE_APPLICATION_ERROR(-20041,'No se encontraron datos para la subasta');
            ROLLBACK; 
        WHEN CURSOR_ALREADY_OPEN THEN
            RAISE_APPLICATION_ERROR(-20042,'Revisar que otro procedimiento no tenga el cursor abierto C_CLASPUJA');
            ROLLBACK;
        WHEN OTHERS THEN 
            RAISE_APPLICATION_ERROR(-20043,'ERROR DE TIPO: '|| SQLCODE || SQLERRM);
            ROLLBACK;
    END PR_CERRARSUBASTA;


END PK_RESERVASCP;
/
SHOW ERRORS