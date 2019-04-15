/*Antes de calcular el peaje, el buque debe estar programado para pasar en la tabla programación diaria
cuando el buque llega al canal, un operario del canal consulta la programación diaria y verifica el buque
y la reserva, allí mismo está realizando el tránsito y el operario registrará las cargas que llevael buque
llenando las tablas craga con el identificador de la reserva, luego de ello se calcula el peaje con 
esas cargas y se genera la factura. Cuando ya culmina todo se genera un registro en tránsito*/

CREATE OR REPLACE PACKAGE BODY PK_TRANSITOCP AS

    FUNCTION FU_CALCULOPEAJEPESOMUERTO(
        PK_ESCLUSA RESERVA.K_ESCLUSA%type,
        DWTBARCO BUQUE.V_PESOMUERTO%type,
        PF_TRANSITO RESERVA.F_TRANSITO%TYPE,
        PK_CATEGORIA BUQUE.K_CATEGORIA%TYPE)
    RETURN NUMBER
    AS  
        DWTBARCO2 NUMBER := 0;
        TEMP NUMBER := 1;
        AUX NUMBER := 1;
        CPOSIBLE NUMBER := 1;
        C_CONTADAS NUMBER := 0;
        TARIFA NUMBER := 0;
        QFINAL NUMBER := 0;
        QINI NUMBER := 0;
        TOTAL NUMBER := 0;    
        lq_total number;
    BEGIN 
        DWTBARCO2 := DWTBARCO;
        WHILE (TEMP > 0 AND C_CONTADAS != DWTBARCO) LOOP
                --CONSULTA
        SELECT V_TARIFAPEAJE, Q_MEDIDAFINAL, Q_MEDIDAINICIAL
        INTO TARIFA, QFINAL, QINI
        FROM TARIFAPEAJE
        WHERE (TEMP BETWEEN Q_MEDIDAINICIAL AND Q_MEDIDAFINAL)
        AND (PF_TRANSITO BETWEEN F_INICIALVIGENTE AND F_FINALVIGENTE)
        AND I_UNIDADMEDIDA ='DWT' AND I_ENLASTRE=1 AND K_ESCLUSA = PK_ESCLUSA
        AND K_CATEGORIA = PK_CATEGORIA;
                --LOGICA			
                IF (DWTBARCO2 <= (QFINAL - QINI)) THEN
                    TOTAL := TOTAL + ((DWTBARCO - C_CONTADAS) * TARIFA);				
                    C_CONTADAS := C_CONTADAS + DWTBARCO2;
                    TEMP := 0;				
                ELSE				
                    C_CONTADAS := C_CONTADAS + (QFINAL - QINI + 1);
                    DWTBARCO2 := DWTBARCO - C_CONTADAS;
                    TOTAL := TOTAL + ((QFINAL - QINI + 1) * TARIFA);				     
                    TEMP := TEMP + (QFINAL - QINI) + 1;				  
                END IF;
        END LOOP;
        RETURN TOTAL;
        EXCEPTION
        WHEN no_data_found THEN     
            RAISE_APPLICATION_ERROR(-20003,'NO SE PUEDE CALCULAR EL VALOR DE PEAJE PARA LA CATEGORIA '||PK_CATEGORIA||', DE BUQUE Y PARA LA ESCLUSA ' || PK_ESCLUSA);
    END FU_CALCULOPEAJEPESOMUERTO;

    FUNCTION FU_CALCULOPEAJECARGA(
        PK_ESCLUSA RESERVA.K_ESCLUSA%type,
        PV_CARGA CARGA.V_PESO%type,
        PF_TRANSITO RESERVA.F_TRANSITO%TYPE,
        PK_CATEGORIA BUQUE.K_CATEGORIA%TYPE,
        PN_TIPOCARGA TARIFAPEAJE.N_TIPOCARGA%TYPE,
        PI_UNIDADMEDIDA TARIFAPEAJE.I_UNIDADMEDIDA%TYPE,
        PI_ENLASTRE TARIFAPEAJE.I_ENLASTRE%TYPE)
    RETURN NUMBER
    AS  
        CARGA2 NUMBER := 0;
        TEMP NUMBER := 1;
        AUX NUMBER := 1;
        CPOSIBLE NUMBER := 1;
        C_CONTADAS NUMBER := 0;
        TARIFA NUMBER := 0;
        QFINAL NUMBER := 0;
        QINI NUMBER := 0;
        TOTAL NUMBER := 0;    
        lq_total number;
    BEGIN 
        CARGA2 := PV_CARGA;
        WHILE (TEMP > 0 AND C_CONTADAS != PV_CARGA) LOOP
                --CONSULTA
            SELECT V_TARIFAPEAJE, Q_MEDIDAFINAL, Q_MEDIDAINICIAL
            INTO TARIFA, QFINAL, QINI
            FROM TARIFAPEAJE
            WHERE (TEMP BETWEEN Q_MEDIDAINICIAL AND Q_MEDIDAFINAL)
            AND (PF_TRANSITO BETWEEN F_INICIALVIGENTE AND F_FINALVIGENTE)
            AND I_UNIDADMEDIDA =PI_UNIDADMEDIDA
            AND I_ENLASTRE=PI_ENLASTRE
            AND K_ESCLUSA = PK_ESCLUSA
            AND K_CATEGORIA = PK_CATEGORIA
            AND N_TIPOCARGA = PN_TIPOCARGA;
                    --LOGICA			
                    IF (CARGA2 <= (QFINAL - QINI)) THEN
                        TOTAL := TOTAL + ((PV_CARGA - C_CONTADAS) * TARIFA);				
                        C_CONTADAS := C_CONTADAS + CARGA2;
                        TEMP := 0;				
                    ELSE				
                        C_CONTADAS := C_CONTADAS + (QFINAL - QINI + 1);
                        CARGA2 := PV_CARGA - C_CONTADAS;
                        TOTAL := TOTAL + ((QFINAL - QINI + 1) * TARIFA);				     
                        TEMP := TEMP + (QFINAL - QINI) + 1;				  
                    END IF;
        END LOOP;
        RETURN TOTAL;
        EXCEPTION
            WHEN no_data_found THEN
                RAISE_APPLICATION_ERROR(-20005,'NO SE PUEDE CALCULAR EL VALOR DE PEAJE PARA LA CATEGORIA '||PK_CATEGORIA||', DE BUQUE Y PARA EL TIPO DE CARGA ' || PN_TIPOCARGA);
    END FU_CALCULOPEAJECARGA; 

    PROCEDURE PR_GENFACTURAPEAJE(    
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
        LV_PESOMUERTO BUQUE.V_PESOMUERTO%TYPE;
        LK_CATEGORIA BUQUE.K_CATEGORIA%TYPE;
        LK_ESCLUSA RESERVA.K_ESCLUSA%TYPE;
        LV_PRECIODWT NUMBER:=0;
        LV_PRECIOCARGAACTUAL NUMBER:=0;
        LV_PRECIOCARGAS NUMBER:=0;
        LV_TOTAL NUMBER:=0;
        LF_TRANSITO RESERVA.F_TRANSITO%TYPE;
        INCREMENTOENY NUMBER:=0;

        CURSOR C_CARGAS IS
        SELECT V_PESO, I_LASTRE, N_TIPOCARGA, I_UNIDADMEDIDA
        FROM CARGA
        WHERE K_RESERVA=pk_reserva;
    BEGIN
        --Obtener datos de la empresa del canal de panamá
        PK_RESERVASCP.PR_DATOS_EMPRESA(ln_empresa,lo_dirempresa,lo_telempresa);
        --Obtener datos del cliente, persona responsable y operador al que pertenece el responsable
        PK_RESERVASCP.PR_DATOS_CLIENTE(pk_reserva,LK_IDENTIFICACION,LK_TIPOID,LK_TELEFONO,LO_EMAIL,LN_OPERADOR,LN_RESPONSABLEBARCO);
        --Obtener datos del buque 
        PK_RESERVASCP.PR_DATOS_BUQUE(pk_reserva,LK_BUQUE,LN_BUQUE,LN_CATEGORA);
        --Obtener el K_ORDENDEPAGO DEL PEAJE
        PK_RESERVASCP.PR_DATOS_ORDENPAGO(pk_reserva, 'PEAJ', LK_ORDENDEPAGO);
        --CALCULAR PRECIO DEL DWT DEL BUQUE  
        SELECT V_PESOMUERTO
        INTO LV_PESOMUERTO
        FROM BUQUE B
        WHERE LK_BUQUE = B.K_BUQUE;

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

        --Detalle FACTURA
        LV_PRECIODWT:=FU_CALCULOPEAJEPESOMUERTO(LK_ESCLUSA,LV_PESOMUERTO,LF_TRANSITO,LK_CATEGORIA);
        as_pdf3.set_font( 'helvetica', 8 );
        --DETALLE PESOMUERTO
        as_pdf3.put_txt( 60, 530, 'PESO MUERTO DE '||LV_PESOMUERTO||' DWT');
        as_pdf3.put_txt( 370, 530,LV_PRECIODWT);

        --DETALLE DE CARGAS
        FOR RC_CARGAS IN C_CARGAS LOOP
            INCREMENTOENY:=INCREMENTOENY+20;
            LV_PRECIOCARGAACTUAL:=FU_CALCULOPEAJECARGA(LK_ESCLUSA,RC_CARGAS.V_PESO,LF_TRANSITO,LK_CATEGORIA,RC_CARGAS.N_TIPOCARGA,RC_CARGAS.I_UNIDADMEDIDA,RC_CARGAS.I_LASTRE);
            LV_PRECIOCARGAS:=LV_PRECIOCARGAS+LV_PRECIOCARGAACTUAL;
            as_pdf3.put_txt( 60, 530-INCREMENTOENY, 'CARGA DE '||RC_CARGAS.N_TIPOCARGA||' DE '||RC_CARGAS.V_PESO||' '||RC_CARGAS.I_UNIDADMEDIDA);
            as_pdf3.put_txt( 370, 530-INCREMENTOENY,LV_PRECIOCARGAACTUAL);
        END LOOP;

        --TOTAL FACTURA
        LV_TOTAL:=LV_PRECIOCARGAS+LV_PRECIODWT;
        as_pdf3.put_txt( 370, 175, 'U$D ' || LV_TOTAL);

        --Pie de pagina
        as_pdf3.set_font( 'helvetica', 8 );
        as_pdf3.put_txt( 230, 60, 'Gracias por hacer negocios con nosotros!');
        as_pdf3.set_font( 'helvetica','I',10 );
        as_pdf3.put_txt( 220, 40, 'Canal de Panama, Nos encantan los Retos');
        as_pdf3.save_pdf(p_dir=>'PDF',p_filename=>'FACTURAPEAJE_NPG_'||LK_ORDENDEPAGO||'.pdf');

        --Finalmente se actualiza el registro de orden de pago en la base de datos
        UPDATE ORDENDEPAGO
        SET V_ORDENDEPAGO=LV_TOTAL
        WHERE K_RESERVA=pk_reserva
        AND K_CONCEPTO='PEAJ';
        COMMIT;
    EXCEPTION
        WHEN no_data_found THEN     
            dbms_output.put_line('No se encontraron datos para el peso muerto del buque '||LK_BUQUE); 
        WHEN OTHERS THEN 
            DBMS_OUTPUT.PUT_LINE('ERROR DE TIPO: '|| SQLCODE || SQLERRM);
    END PR_GENFACTURAPEAJE;

    PROCEDURE PR_GENFACTURAPEAJEPAGO(    
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
    PK_RESERVASCP.PR_DATOS_EMPRESA(ln_empresa,lo_dirempresa,lo_telempresa);
    --Obtener datos del cliente, persona responsable y operador al que pertenece el responsable
    PK_RESERVASCP.PR_DATOS_CLIENTE(pk_reserva,LK_IDENTIFICACION,LK_TIPOID,LK_TELEFONO,LO_EMAIL,LN_OPERADOR,LN_RESPONSABLEBARCO);
    --Obtener datos del buque 
    PK_RESERVASCP.PR_DATOS_BUQUE(pk_reserva,LK_BUQUE,LN_BUQUE,LN_CATEGORA);
    --Obtener el K_ORDENDEPAGO DEL PEAJE
    PK_RESERVASCP.PR_DATOS_ORDENPAGO(pk_reserva, 'PEAJ', LK_ORDENDEPAGO);
    --Obtener datos de la orden de pago    
    PK_RESERVASCP.PR_DATOS_CONCEPTO_ORDEN_PAGO(pk_reserva,LK_ORDENDEPAGO,LN_CONCEPTO,LV_ORDENDEPAGO);
    --Obtener datos del pago
    PK_RESERVASCP.PR_DATOS_DEL_PAGO(pk_reserva,LK_ORDENDEPAGO,LO_CUENTAORIGEN,LF_PAGO,LV_PAGO,LI_FORMAPAGO);

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
            dbms_output.put_line('No se encontraron datos para la orden de pago'); 
        WHEN OTHERS THEN 
            dbms_output.put_line('No se pudo generar la factura, verifique que ningún proceso tenga abierta la factura');
    END PR_GENFACTURAPEAJEPAGO;

    PROCEDURE PR_ACTUALIZARPAGOPEAJE(    
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
        AND O.K_CONCEPTO = 'PEAJ';

        INSERT INTO PAGO VALUES (NULL, LK_ORDENDEPAGO, SYSDATE, LV_ORDENDEPAGO, 'TC', po_cuentaorigen);
        UPDATE ORDENDEPAGO SET N_ESTADOPAGO = 'PAG' WHERE K_ORDENDEPAGO = LK_ORDENDEPAGO;

        COMMIT;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                dbms_output.put_line('No se encontro una orden de pago para la reserva '||pk_reserva); 
                
    END PR_ACTUALIZARPAGOPEAJE;



END PK_TRANSITOCP;
/
SHOW ERRORS;
