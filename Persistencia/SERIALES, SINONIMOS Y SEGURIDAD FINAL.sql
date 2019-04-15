/*OJO: TODO SE EJECUTA DESDE U_ADMIN A MENOS QUE UN COMENTARIO DIGA LO CONTRARIO*/

/*===========================================================================================================*/
/*=============================================TRIGGERS DE SERIALES==========================================*/
/*===========================================================================================================*/

/*TRIGGER SERIAL PROGRAMACIÓN DIARIA*/
create sequence programaciondiaria_sequence;
CREATE OR REPLACE TRIGGER tr_programaciondiaria_serial
  BEFORE INSERT ON programaciondiaria
  FOR EACH ROW
BEGIN
  SELECT programaciondiaria_sequence.nextval
  INTO :new.k_programacion
  FROM dual;
END;
/


/*TRIGGER SERIAL TARIFA RESERVA*/
create sequence tarifareserva_sequence;
CREATE OR REPLACE TRIGGER tr_tarifareserva_serial
  BEFORE INSERT ON tarifareserva
  FOR EACH ROW
BEGIN
  SELECT tarifareserva_sequence.nextval
  INTO :new.k_tarifareserva
  FROM dual;
END;
/


/*TRIGGER ORDEN DE PAGO*/
create sequence ordendepago_sequence;
CREATE OR REPLACE TRIGGER tr_ordendepago_serial
  BEFORE INSERT ON ordendepago
  FOR EACH ROW
BEGIN
  SELECT ordendepago_sequence.nextval
  INTO :new.k_ordendepago
  FROM dual;
END;
/


/*TRIGGER SERIAL RESERVA*/
create sequence reserva_sequence;
CREATE OR REPLACE TRIGGER tr_reserva_serial
  BEFORE INSERT ON reserva
  FOR EACH ROW
BEGIN
  SELECT reserva_sequence.nextval
  INTO :new.k_reserva
  FROM dual;
END;
/

--TRIGGER TARIFAPEAJE
create sequence tarifapeaje_sequence;
CREATE OR REPLACE TRIGGER tr_tarifapeaje_serial
  BEFORE INSERT ON TARIFAPEAJE
  FOR EACH ROW
BEGIN
  SELECT tarifapeaje_sequence.nextval
  INTO :new.k_tarifapeaje
  FROM dual;
END;
/

--TRIGGER CARGA
create sequence carga_sequence;
CREATE OR REPLACE TRIGGER tr_carga_serial
  BEFORE INSERT ON CARGA
  FOR EACH ROWS
BEGIN
  SELECT carga_sequence.nextval
  INTO :new.k_carga
  FROM dual;
END;
/

--TRIGGER tabla pago
create sequence pago_sequence;
CREATE OR REPLACE TRIGGER tr_pago_serial
  BEFORE INSERT ON PAGO
  FOR EACH ROW
BEGIN
  SELECT pago_sequence.nextval
  INTO :new.k_PAGO
  FROM dual;
END;
/


/*TRIGGER SUBASTA*/
create sequence subasta_sequence;
CREATE OR REPLACE TRIGGER tr_subasta_serial
  BEFORE INSERT ON subasta
  FOR EACH ROW
BEGIN
  SELECT subasta_sequence.nextval
  INTO :new.k_subasta
  FROM dual;
END;
/


/*TRIGGER PUJA*/
create sequence puja_sequence;
CREATE OR REPLACE TRIGGER tr_puja_serial
  BEFORE INSERT ON puja
  FOR EACH ROW
BEGIN
  SELECT puja_sequence.nextval
  INTO :new.k_puja
  FROM dual;
END;
/


/*TRIGGER TRANSITO*/
create sequence transito_sequence;
CREATE OR REPLACE TRIGGER tr_transito_serial
  BEFORE INSERT ON transito
  FOR EACH ROW
BEGIN
  SELECT transito_sequence.nextval
  INTO :new.k_transito
  FROM dual;
END;
/

/*===========================================================================================================*/
/*=============================================FIN TRIGGERS DE SERIALES======================================*/
/*===========================================================================================================*/

/*===========================================================================================================*/
/*==================================SINONIMOS PROCEDIMIENTOS Y FUNCIONES======================================*/
/*===========================================================================================================*/

CREATE PUBLIC SYNONYM AS_PDF3 FOR AS_PDF3;
CREATE PUBLIC SYNONYM PK_RESERVASCP FOR U_ADMIN.PK_RESERVASCP;
CREATE PUBLIC SYNONYM PK_TRANSITOCP FOR U_ADMIN.PK_TRANSITOCP;

/*===========================================================================================================*/
/*==================================FIN SINONIMOS PROCEDIMIENTOS Y FUNCIONES======================================*/
/*===========================================================================================================*/

/*===========================================================================================================*/
/*==================================SEGURIDAD PROCEDIMIENTOS Y FUNCIONES======================================*/
/*===========================================================================================================*/


GRANT EXECUTE ON PK_RESERVASCP TO R_CLIENTE;
GRANT EXECUTE ON PK_TRANSITOCP TO R_CLIENTE;

GRANT EXECUTE ON PK_RESERVASCP TO R_COORDINADOR;
GRANT EXECUTE ON PK_TRANSITOCP TO R_COORDINADOR;

GRANT EXECUTE ON PK_RESERVASCP TO R_OPERARIOCP;
GRANT EXECUTE ON PK_TRANSITOCP TO R_OPERARIOCP;


