/*Consulta reservas X día*/
SELECT * FROM RESERVA WHERE F_TRANSITO='31/12/18';

/*Consulta reservas X día, X exclusa*/
SELECT * FROM RESERVA WHERE F_TRANSITO='31/12/18' AND K_ESCLUSA='PANX';

/*===========================================================================================================*/
/*==============================Consulta de los tránsitos programados y no pagados para un día particula ====*/
/*===========================================================================================================*/
/*CONSULTA UTILIZADA EN LA PROGRAMACIÓN DEL MÓDULO TRÁNSITO*/

SELECT R.K_RESERVA, B.K_BUQUE, B.N_BUQUE, P.K_PUERTOLLEGADA, P.K_PUERTOSALIDA, P.F_PROGYHORALLEGADA, P.F_PROGYHORASALIDA
FROM PROGRAMACIONDIARIA P, BUQUE B, RESERVA R, ORDENDEPAGO O
WHERE P.K_RESERVA = R.K_RESERVA 
AND R.K_BUQUE=B.K_BUQUE
AND R.K_RESERVA=O.K_RESERVA
AND R.F_TRANSITO = '21-11-2018'
AND (O.K_CONCEPTO='RESV' AND O.N_ESTADOPAGO = 'PAG')
INTERSECT
SELECT R.K_RESERVA, B.K_BUQUE, B.N_BUQUE, P.K_PUERTOLLEGADA, P.K_PUERTOSALIDA, P.F_PROGYHORALLEGADA, P.F_PROGYHORASALIDA
FROM PROGRAMACIONDIARIA P, BUQUE B, RESERVA R, ORDENDEPAGO O
WHERE P.K_RESERVA = R.K_RESERVA 
AND R.K_BUQUE=B.K_BUQUE
AND R.K_RESERVA=O.K_RESERVA
AND R.F_TRANSITO = '21-11-2018'
AND (O.K_CONCEPTO='PEAJ' AND O.N_ESTADOPAGO = 'NPG');


SELECT P.K_PROGRAMACION FROM PROGRAMACIONDIARIA P, RESERVA R, ORDENDEPAGO O
WHERE R.K_RESERVA = P.K_RESERVA AND (R.K_RESERVA = O.K_RESERVA OR NOT EXISTS
(SELECT O.K_RESERVA FROM RESERVA R, ORDENDEPAGO O WHERE R.K_RESERVA = O.K_RESERVA))
AND (O.K_CONCEPTO = 'PEAJ' OR  NOT EXISTS (O.K_CONCEPTO))
AND (O.N_ESTADOPAGO =  'NPG' OR  NOT EXISTS (O.N_ESTADOPAGO)) AND R.F_TRANSITO = '31-12-2018';

/*===========================================================================================================*/
/*==============================CONSULTAS TRANSACCIONES CANAL DE PANAMÁ =====================================*/
/*===========================================================================================================*/

--Consulta de transacciones de todo el canal de panamá, CORRE DESDE EL ROL DE COORDINADOR
SELECT O.K_ORDENDEPAGO, O.K_RESERVA, O.K_CONCEPTO, O.V_ORDENDEPAGO AS VALORTOTAL , O.N_ESTADOPAGO, P.F_PAGO, P.V_PAGO AS VALOR_PAGADO, P.O_CUENTAORIGEN
FROM ORDENDEPAGO O, PAGO P
WHERE O.N_ESTADOPAGO = 'PAG' AND O.K_ORDENDEPAGO = P.K_ORDENDEPAGO;
--Consulta de transacciones cliente específico las que se han pagado y las que no. Corre desde el rol cliente
SELECT O.K_ORDENDEPAGO, O.K_RESERVA, O.K_CONCEPTO, O.V_ORDENDEPAGO AS VALORTOTAL , O.N_ESTADOPAGO, P.F_PAGO, P.V_PAGO AS VALOR_PAGADO, P.O_CUENTAORIGEN
FROM ORDENDEPAGO O, PAGO P, RESERVA R
WHERE O.K_ORDENDEPAGO = P.K_ORDENDEPAGO
AND R.K_IDENTIFICACION = 1009228
AND R.K_TIPOID = 'CC'
AND R.K_RESERVA = O.K_RESERVA
AND O.N_ESTADOPAGO = 'PAG'
UNION
SELECT O.K_ORDENDEPAGO, O.K_RESERVA, O.K_CONCEPTO, O.V_ORDENDEPAGO AS VALORTOTAL , O.N_ESTADOPAGO, NULL AS F_PAGO, NULL AS VALOR_PAGADO, NULL AS O_CUENTAORIGEN
FROM ORDENDEPAGO O, RESERVA R
WHERE R.K_IDENTIFICACION = 1009228
AND R.K_TIPOID = 'CC'
AND R.K_RESERVA = O.K_RESERVA
AND O.N_ESTADOPAGO = 'NPG';


/*===========================================================================================================*/
/*==============================FIN CONSULTAS TRANSACCIONES CANAL DE PANAMÁ ==================================*/
/*===========================================================================================================*/

/*===========================================================================================================*/
/*==============================CONSULTA ORDENES DE PAGO TIPO RESERVA SIN PAGAR==============================*/
/*===========================================================================================================*/

SELECT R.K_RESERVA, O.V_ORDENDEPAGO
FROM RESERVA R, ORDENDEPAGO O, RESPONSABLE RE
WHERE R.K_RESERVA = O.K_RESERVA
AND O.K_CONCEPTO = 'RESV'
AND O.N_ESTADOPAGO = 'NPG'
AND R.K_IDENTIFICACION = RE.K_IDENTIFICACION
AND R.K_TIPOID = RE.K_TIPOID
AND RE.K_CRN = FU_GETCRNOPERADOR;

/*===========================================================================================================*/
/*===========================FIN CONSULTA ORDENES DE PAGO TIPO RESERVA SIN PAGAR==============================*/
/*===========================================================================================================*/

/*===========================================================================================================*/
/*==============================CONSULTA VALOR ORDEN DE PAGO TRANSITO==============================*/
/*===========================================================================================================*/


SELECT O.V_ORDENDEPAGO
FROM RESERVA R, ORDENDEPAGO O, RESPONSABLE RE
WHERE R.K_RESERVA = LLEGA
AND O.K_CONCEPTO = 'PEAJ'
AND O.N_ESTADOPAGO = 'NPG'
AND R.K_IDENTIFICACION = RE.K_IDENTIFICACION
AND R.K_TIPOID = RE.K_TIPOID
AND RE.K_CRN = CRN CONSULTA ANTERIOR;

/*===========================================================================================================*/
/*==============================FIN CONSULTA VALOR ORDEN DE PAGO TRANSITO==============================*/
/*===========================================================================================================*/


/*===========================================================================================================*/
/*==============================Consulta detalle subasta y valor ultima puja==============================*/
/*===========================================================================================================*/
SELECT S.K_SUBASTA
FROM RESERVASUBASTA R, SUBASTA S
WHERE R.K_RESERVA = PK_RESERVA
AND R.K_SUBASTA = S.K_SUBASTA

SELECT S.F_APERTURASUBASTA, S.F_VENCIMIENTOSUBASTA, S.V_INCREMENTOMINIMO, FU_VALPUJA(3)
FROM RESERVASUBASTA R, SUBASTA S
WHERE R.K_RESERVA = 34
AND R.K_SUBASTA = S.K_SUBASTA;

/*===========================================================================================================*/
/*==============================FIN Consulta detalle subasta y valor ultima puja==============================*/
/*===========================================================================================================*/

/*===========================================================================================================*/
/*==============================CONSULTA TODAS LAS PUJAS DE UN CLIENTE==============================*/
/*===========================================================================================================*/
SELECT K_SUBASTA, K_PUJA, F_PUJA, V_PUJA, N_ESTADOPUJA FROM PUJA
WHERE K_IDENTIFICACION=1276165
AND K_TIPOID='CC';

/*===========================================================================================================*/
/*==============================FIN CONSULTA TODAS LAS PUJAS DE UN CLIENTE==============================*/
/*===========================================================================================================*/



/*CODIGO OPCIONAL: SI SE EJECUTÓ EL SCRIPT DE INSERCIÓN DE DATOS CON ANTERIORIDAD*/
DELETE FROM CUPOPASO;
DELETE FROM PASO;
ALTER TABLE PASO DROP CONSTRAINT CK_MAXLOA;
ALTER TABLE PASO DROP CONSTRAINT CK_MAXMANGA;
ALTER TABLE PASO DROP CONSTRAINT CK_MINLOA;
ALTER TABLE PASO DROP CONSTRAINT CK_MINMANGA;
ALTER TABLE  Paso 
 ADD CONSTRAINT CK_MAXLOA CHECK (V_MAXLOA > 0)
;

ALTER TABLE  Paso 
 ADD CONSTRAINT CK_MAXMANGA CHECK (V_MAXMANGA > 0)
;

ALTER TABLE  Paso 
 ADD CONSTRAINT CK_MINLOA CHECK (V_MINLOA > 0 )
;

ALTER TABLE  Paso 
 ADD CONSTRAINT CK_MINMANGA CHECK (V_MINMANGA > 0)
;

--OPCIONAL SI NO ACEPTA TEU EN LA TABLA Carga
ALTER TABLE CARGA DROP CONSTRAINT CK_UNIDADESDEMEDIDA;
ALTER TABLE TARIFAPEAJE DROP CONSTRAINT CK_UNIDADMEDIDA;
ALTER TABLE  Carga 
 ADD CONSTRAINT CK_UNIDADESDEMEDIDA CHECK (I_UNIDADMEDIDA IN ('TON','DWT','TM','MTC','TEU'))
;
ALTER TABLE  Carga 
 ADD CONSTRAINT CK_UNIDADESDEMEDIDA CHECK (I_UNIDADMEDIDA IN ('TON','DWT','TM','MTC','TEU'))
;
ALTER TABLE  TARIFAPEAJE 
 ADD CONSTRAINT CK_UNIDADMEDIDA CHECK (I_UNIDADMEDIDA IN ('TON','DWT','TM','MTC','TEU'))
;


--OPCIONAL: SI LA RELACIÓN ENTRE CATEGORÍABUQUE Y TARIFA PEAJE NO EXISTE, EJECUTAR LO SIGUIENTE:
ALTER TABLE TARIFAPEAJE
ADD K_CATEGORIA VARCHAR(3);

ALTER TABLE  TARIFAPEAJE 
 ADD CONSTRAINT FK_TarifaPeaje_CategoriaBuque
	FOREIGN KEY (K_CATEGORIA) REFERENCES  CategoriaBuque (K_CATEGORIA);

ALTER TABLE TARIFAPEAJE
DROP COLUMN K_TIPOCARGA;

DROP TABLE tipocarga CASCADE CONSTRAINTS;

ALTER TABLE CARGA
ADD I_LASTRE NUMBER(1) NOT NULL;

ALTER TABLE  Carga 
 ADD CONSTRAINT CK_LASTRE CHECK (I_LASTRE = 0 OR I_LASTRE = 1)
;

ALTER TABLE TARIFAPEAJE
ADD N_TIPOCARGA VARCHAR(5) NULL;

ALTER TABLE CARGA
ADD I_UNIDADMEDIDA VARCHAR(3) NOT NULL;

ALTER TABLE  Carga 
 ADD CONSTRAINT CK_UNIDADESDEMEDIDA CHECK (I_UNIDADMEDIDA IN ('TON','DWT','TM','MTC'))
;

ALTER TABLE CARGA
ADD N_TIPOCARGA VARCHAR(5) NULL;

/*===========================================================================================================*/
/*================================INSTALACIÓN HERRAMIENTA PDF================================================*/
/*===========================================================================================================*/
--Links utiles: https://technology.amis.nl/2012/04/11/generating-a-pdf-document-with-some-plsql-as_pdf_mini-as_pdf3/
--http://oracle-y-yo.blogspot.com/2015/07/creacion-de-un-archivo-pdf-desde-plsql.html
-- https://plantillas-gratis.net/2016/09/11/factura-simple-con-word/


--Conectarse al system como sysdba
connect system as sysdba
--PASSWORD y ejecutar
GRANT EXECUTE ON SYS.UTL_FILE TO PUBLIC;
--Connectarse a U_ADMIN 
--Correr los siguientes script as_pdf3_4.txt (se encuentran en el drive)
START RUTA--as_pdf3_4.txt
--conectarse al system
GRANT CREATE ANY DIRECTORY TO R_ADMIN;
--Conectarse a u_Admin
--Descargar la carpeta PDF_CP en descargas (está en el drive)
--ejecutar (cambiar ruta de descargas acorde donde se encuentre)
CREATE OR REPLACE DIRECTORY PDF AS 'E:\Descargas\PDF_CP';

--Datos Pago Pruebas

INSERT INTO PAGO VALUES (1, 1, '15-11-2018', 35000, 'TC', '1002020280001345');

--PERMISOS DE EJECUCIÓN PARA GENERACIÓN DE FACTURA RESERVA desde u_admin
CREATE PUBLIC SYNONYM AS_PDF3 FOR AS_PDF3;
GRANT EXECUTE ON AS_PDF3 TO R_CLIENTE;
CREATE PUBLIC SYNONYM pr_genfactura FOR pr_genfactura;
GRANT EXECUTE ON pr_genfactura TO R_CLIENTE;

/*===========================================================================================================*/
/*================================FIN INSTALACIÓN HERRAMIENTA PDF=============================================*/
/*===========================================================================================================*/


/*OPCIONAL: SOLO SE USA PARA PRUEBAS*/
--Para nuestro caso el barco kinoocean id 7119 está programado para pasar el 31/12/2018 con id de reserva 1
--entonces se le registran las cargas
-- https://peajes.panama-canal.com/wcgranelessecos.aspx?d7a622311c89cd2219afb1af03c5f390,gx-no-cache=1541265004637
ALTER TABLE CARGA DROP COLUMN K_TIPOCARGA;
INSERT INTO CARGA VALUES(NULL,25,1000,0,'CARBO','DWT');
INSERT INTO CARGA VALUES(NULL,25,2000,0,'GRANO','DWT');

/*Con esos datos anteriores se tiene ya el valor de la orden de pago y el CRN del cliente para realizar el pago, 
entoncese se hace un llamado a la función FU_PAGAR del archivo  PLSQLPOSTGRES_BANCOsql.psql*/

--Si la funcion retorna FALSE se le indica al cliente que el saldo es insuficiente y no se realiza ninguna otra operacion

--Si la funcion retorna TRUE se llama el siguiente procedimiento para actualizar el pago y el estado pago en la BD de Oracle:


/*===========================================================================================================*/
/*==============================PROCEDIMIENTOS EMULACIÓN PAGO CON EL BANCO=================================*/
/*===========================================================================================================*/

--OPCIONAL: SI LA COLUMNA V_KCN NO EXISTE EN EMPRESA CP EJECUTAR LO SIGUIENTE:
ALTER TABLE EmpresaCP
ADD V_KCN VARCHAR(12);

UPDATE EmpresaCP
SET V_KCN = 1000000
WHERE K_IDEMPRESA='EM01';

/*El pago se efectúa al momento Del tránsito por el canal de panamá  y para la reserva puede pagarlo cuando quiera seleccionando la reserva no pagada de un listado. cuando se realiza la reserva, se paga primero
para ello, se deben efectuar operaciones con la base de datos del banco, para ello entonces se consulta el CRN del cliente actual
y el valor de la reserva o tránsito a pagar*/


SELECT  FU_GETCRNOPERADOR FROM DUAL;

--CONSULTA ORDENES DE PAGO TIPO RESERVA SIN PAGAR
SELECT R.K_RESERVA, O.V_ORDENDEPAGO
FROM RESERVA R, ORDENDEPAGO O, RESPONSABLE RE
WHERE R.K_RESERVA = O.K_RESERVA
AND O.K_CONCEPTO = 'RESV'
AND O.N_ESTADOPAGO = 'NPG'
AND R.K_IDENTIFICACION = RE.K_IDENTIFICACION
AND R.K_TIPOID = RE.K_TIPOID
AND RE.K_CRN = FU_GETCRNOPERADOR;

/*Con esos datos anteriores se tiene ya el valor de la orden de pago y el CRN del cliente para realizar el pago, 
entoncese se hace un llamado a la función FU_PAGAR del archivo  PLSQLPOSTGRES_BANCOsql.psql*/

--Si la funcion retorna FALSE sele indica al cliente que el saldo es insuficiente y no se realiza ninguna otra operacion

--Si la funcion retorna TRUE se llama el siguiente procedimiento para actualizar el pago y el estado pago en la BD de Oracle:


--OPCIONAL: SI HAY DATOS INSERTADOS EN LA TABLA PAGO
SELECT pago_sequence.NEXTVAL FROM DUAL;
alter sequence pago_sequence increment by 3 minvalue 1;





/*OJO: PAGO TRANSITO: EL PAGO DEL TRANSITO SE HACE LUEGO DE GENERAR LA FACTURA CON LA FUNCIÓN PR_GENFACTURAPEAJE, ES DECIR NO SE HA PAGADO Y SE VA A PAGAR AHÍ MISMO, 
A PENAS SE GENERA ESTA FACTURA SE REDIRIGE A LA VENTANA DE PAGO Y SE HACE EL LLAMADO A LA FUNCIÓN FU_PAGAR del archivo  PLSQLPOSTGRES_BANCOsql.psql 
EL QUE REALIZA ESTO ES UN EMPLEADO DEL CANAL, ENTONCES SE CONSULTA EL K_CRN ASOCIADO AL BARCO QUE VA A TRANSITAR
*/
--CONSULTA CRN BARCO QUE TRANSITA

SELECT K_CRN
FROM RESERVA R, BUQUE B
WHERE R.K_RESERVA = LLEGA
AND R.K_BUQUE = B.K_BUQUE;

--CONSULTA VALOR ORDEN DE PAGO TRANSITO

SELECT O.V_ORDENDEPAGO
FROM RESERVA R, ORDENDEPAGO O, RESPONSABLE RE
WHERE R.K_RESERVA = LLEGA
AND O.K_CONCEPTO = 'PEAJ'
AND O.N_ESTADOPAGO = 'NPG'
AND R.K_IDENTIFICACION = RE.K_IDENTIFICACION
AND R.K_TIPOID = RE.K_TIPOID
AND RE.K_CRN = CRN CONSULTA ANTERIOR;

--Se envían los resultados de las dos consultas anteriores a la función de postgres, luego de efectuada se ejecuta el siguiente procedimiento


--Luego de hacer esto si se llama la función PR_GENFACTURAPEAJEPAGO que genera la factura con los detalles del pago para la orden de pago del peaje
/*===========================================================================================================*/
/*==============================FIN  PROCEDIMIENTOS EMULACIÓN PAGO CON EL BANCO=================================*/
/*===========================================================================================================*/


--OPCIONAL SI NO EXISTE LA FORANEA K_IDENTIFICACION,K_TIPOID EN LA TABLA PUJA
ALTER TABLE PUJA ADD K_IDENTIFICACION NUMBER(12) NOT NULL;
ALTER TABLE PUJA ADD K_TIPOID VARCHAR(2) NOT NULL;
ALTER TABLE  Puja 
 ADD CONSTRAINT FK_Puja_Responsable
	FOREIGN KEY (K_IDENTIFICACION,K_TIPOID) REFERENCES  Responsable (K_IDENTIFICACION,K_TIPOID)
;



/*===========================================================================================================*/
/*==============================OPCIONAL NO EJECUTAR, SOLO NECESARIO SI LA PROFESORA LO SOLICITA=============*/
/*===========================================================================================================*/

CREATE OR REPLACE FUNCTION FU_CERRARSUBASTA(    
  pk_subasta subasta.k_subasta%type)
  return SYS_REFCURSOR
as  
  LV_FACTORMAYORO NUMBER(12,10);
  LV_FACTORMAYORP NUMBER(12,10);
  LV_PORCENTAJEO NUMBER(6,5) := 0.75;
  LV_PORCENTAJEP NUMBER(6,5) := 0.35;
  LV_FACTORMAXO NUMBER(7,5);
  LV_FACTORMAXP NUMBER(7,5);
  LV_MAYORTRANSITO NUMBER(5);
  l_cursor SYS_REFCURSOR;
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

--TABLA FACTORES TOTALES
open l_cursor FOR

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

return l_cursor;

END FU_CERRARSUBASTA;
/
show errors
--PRUEBA 
SELECT FU_CERRARSUBASTA(3) FROM DUAL;
/*===========================================================================================================*/
/*==============================FIN OPCIONAL =================================================================*/
/*===========================================================================================================*/