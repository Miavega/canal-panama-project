CREATE OR REPLACE PACKAGE PK_TRANSITOCP AS 
    /*---------------------------------------------------------------------
     Funcion que retorna el total del valor del peaje según el peso muerto del buque
     Parametros de Entrada: 
            PK_ESCLUSA       Identificador de la esclusa
            DWTBARCO         Valor del peso muerto del barco
            PF_TRANSITO      Fecha de tránsito de la reserva
            PK_CATEGORIA     Categoría del buque a calcular el peaje
      Parametros de Salida:  Ninguno
      Retorna :  Total del valor del peaje calculado con los parámetros de entrada
      Precondicion: La tabla TarifaPeaje ya se encuentra parametrizada
      Excepcion: No se encontraron datos en la tabla TarifaPeaje 
     -----------------------------------------------------------------------*/

    FUNCTION FU_CALCULOPEAJEPESOMUERTO(
        PK_ESCLUSA RESERVA.K_ESCLUSA%type,
        DWTBARCO BUQUE.V_PESOMUERTO%type,
        PF_TRANSITO RESERVA.F_TRANSITO%TYPE,
        PK_CATEGORIA BUQUE.K_CATEGORIA%TYPE)
        RETURN NUMBER;

    /*---------------------------------------------------------------------
     Funcion que retorna el total del valor del peaje según el peso de carga del buque
     Parametros de Entrada: 
            PK_ESCLUSA       Identificador de la esclusa
            PV_CARGA         Valor del peso de carga del barco
            PF_TRANSITO      Fecha de tránsito de la reserva
            PK_CATEGORIA     Categoría del buque a calcular el peaje
            PN_TIPOCARGA     Nombre del tipo de carga transportada
            PI_UNIDADMEDIDA  Tipo de medida de la carga
            PI_ENLASTRE      Tipo que indica si esta o no en lastre
      Parametros de Salida:  Ninguno
      Retorna :  Total del valor del peaje calculado con los parámetros de entrada
      Precondicion: La tabla TarifaPeaje ya se encuentra parametrizada
      Excepcion: No se encontraron datos en la tabla TarifaPeaje 
     -----------------------------------------------------------------------*/

    FUNCTION FU_CALCULOPEAJECARGA(
        PK_ESCLUSA RESERVA.K_ESCLUSA%type,
        PV_CARGA CARGA.V_PESO%type,
        PF_TRANSITO RESERVA.F_TRANSITO%TYPE,
        PK_CATEGORIA BUQUE.K_CATEGORIA%TYPE,
        PN_TIPOCARGA TARIFAPEAJE.N_TIPOCARGA%TYPE,
        PI_UNIDADMEDIDA TARIFAPEAJE.I_UNIDADMEDIDA%TYPE,
        PI_ENLASTRE TARIFAPEAJE.I_ENLASTRE%TYPE)
        RETURN NUMBER;
    
    /*---------------------------------------------------------------------
     Procedimiento para generar la factura en PDF de un peaje antes de haberla pagado al momento del transito
     Parametros de Entrada: 
            pk_reserva         Identificador de la reserva
      Parametros de Salida:  Ninguno
      Precondicion: Existen una reserva y se va a efectuar el transito
                    Retorno satisfactorio de FU_CALCULOPEAJEPESOMUERTO
                    Retorno satisfactorio de FU_CALCULOPEAJECARGA
      Excepcion:    No hay datos asociados a la Empresa CP
                    No hay datos del Reponsable y el Operador en el cual esta registrado el responsable
                    No hay datos del buque para el que se solicita la factura
                    No hay datos de la orden de pago para la reserva solicitada
                    No hay datos del DWT del buque
                    Errores asociados o propagados por el generador de PDF's

     -----------------------------------------------------------------------*/
    PROCEDURE PR_GENFACTURAPEAJE(    
        pk_reserva reserva.k_reserva%type);
    

    /*---------------------------------------------------------------------
     Procedimiento para generar la factura en PDF de un peaje despues de haberla pagado al momento del transito
     Parametros de Entrada: 
            pk_reserva         Identificador de la reserva
      Parametros de Salida:  Ninguno
      Precondicion: Existen una reserva y se ha efectuado el pago
      Excepcion:    No hay datos asociados a la Empresa CP
                    No hay datos del Reponsable y el Operador en el cual esta registrado el responsable
                    No hay datos del buque para el que se solicita la factura
                    No hay datos de la orden de pago para la reserva solicitada
                    No hay datos del pago
                    Errores asociados o propagados por el generador de PDF's

     -----------------------------------------------------------------------*/
    PROCEDURE PR_GENFACTURAPEAJEPAGO(    
        pk_reserva reserva.k_reserva%type);

    /*---------------------------------------------------------------------
     Procedimiento en el que se actualizan los pagos deL PEAJE, una vez se ha pagado mediante el banco
     Parametros de Entrada: 
            pk_reserva         Identificador de la reserva
            po_cuentaorigen    Numero de cuenta de origen(la que efectuó el pago)
      Parametros de Salida:  Ninguno
      Precondicion: Se ha realizado el pago en el banco, Existe una orden de pago
      Excepcion: No se encontró una orden de pago asociada a los parámetros de entrada
     -----------------------------------------------------------------------*/
    PROCEDURE PR_ACTUALIZARPAGOPEAJE(    
        pk_reserva reserva.k_reserva%type,
        po_cuentaorigen pago.o_cuentaorigen%type);

END PK_TRANSITOCP;
/
SHOW ERRORS;
