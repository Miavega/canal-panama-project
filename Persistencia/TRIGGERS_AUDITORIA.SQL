/*=============================TRIGGER AUDITORÍA TARIFA RESERVA============================================================*/
CREATE OR REPLACE TRIGGER TR_AUDITORIA_TARIFARESERVA
    AFTER INSERT OR UPDATE OR DELETE ON TARIFARESERVA
    FOR EACH ROW
DECLARE
    LF_AUDITORIA UTL_FILE.FILE_TYPE;
BEGIN
    --PARAMETROS: DIRECTORIO, NOMBRE FILE, MODO DE LECTURA
    LF_AUDITORIA := UTL_FILE.FOPEN ('PDF', 'LF_AUDITORIA_TARIFARESERVA.txt','A');
    UTL_FILE.PUT (LF_AUDITORIA,'El usuario ['||SYS_CONTEXT ('USERENV', 'SESSION_USER')||'] el dia y hora ['||TO_CHAR(SYSDATE,' MM/DD/YYYY HH:MI:SS')||']');
    UTL_FILE.NEW_LINE (LF_AUDITORIA);
    IF INSERTING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha insertado un nuevo registro con \n'
                                     ||CHR(9)||'K_TARIFARESERVA ['||:NEW.K_TARIFARESERVA||']  \n'
                                     ||CHR(9)||'V_MANGAINICIAL ['||:NEW.V_MANGAINICIAL||'] \n'
                                     ||CHR(9)||'V_MANGAFINAL ['||:NEW.V_MANGAFINAL||'] \n'
                                     ||CHR(9)||'V_LOAINICIAL ['||:NEW.V_LOAINICIAL||'] \n'
                                     ||CHR(9)||'V_LOAFINAL ['||:NEW.V_LOAFINAL||'] \n'
                                     ||CHR(9)||'F_INICIALVIGENTE ['||:NEW.F_INICIALVIGENTE||'] \n'
                                     ||CHR(9)||'F_FINALVIGENTE ['||:NEW.F_FINALVIGENTE||'] \n'
                                     ||CHR(9)||'V_TARIFARESERVA ['||:NEW.V_TARIFARESERVA||'] \n');
    ELSIF UPDATING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha actualizado el registro con \n'
                                     ||CHR(9)||'K_TARIFARESERVA ['||:OLD.K_TARIFARESERVA||']  \n'
                                     ||CHR(9)||'Con los siguientes valores OLD - NEW \n'
                                     ||CHR(9)||'V_MANGAINICIAL ['||:OLD.V_MANGAINICIAL||'] - ['||:NEW.V_MANGAINICIAL||'] \n'
                                     ||CHR(9)||'V_MANGAFINAL ['||:OLD.V_MANGAFINAL||'] - ['||:NEW.V_MANGAFINAL||'] \n'
                                     ||CHR(9)||'V_LOAINICIAL ['||:OLD.V_LOAINICIAL||'] - ['||:NEW.V_LOAINICIAL||'] \n'
                                     ||CHR(9)||'V_LOAFINAL ['||:OLD.V_LOAFINAL||'] - ['||:NEW.V_LOAFINAL||'] \n'
                                     ||CHR(9)||'F_INICIALVIGENTE ['||:OLD.F_INICIALVIGENTE||'] - ['||:NEW.F_INICIALVIGENTE||'] \n'
                                     ||CHR(9)||'F_FINALVIGENTE ['||:OLD.F_FINALVIGENTE||'] - ['||:NEW.F_FINALVIGENTE||'] \n'
                                     ||CHR(9)||'V_TARIFARESERVA ['||:OLD.V_TARIFARESERVA||'] - ['||:NEW.V_TARIFARESERVA||'] \n');
    ELSIF DELETING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha eliminado el registro con \n'
                                     ||CHR(9)||'K_TARIFARESERVA ['||:OLD.K_TARIFARESERVA||']  \n'
                                     ||CHR(9)||'El cual tenia la siguiente informacion\n'
                                     ||CHR(9)||'V_MANGAINICIAL ['||:OLD.V_MANGAINICIAL||'] \n'
                                     ||CHR(9)||'V_MANGAFINAL ['||:OLD.V_MANGAFINAL||'] \n'
                                     ||CHR(9)||'V_LOAINICIAL ['||:OLD.V_LOAINICIAL||'] \n'
                                     ||CHR(9)||'V_LOAFINAL ['||:OLD.V_LOAFINAL||'] \n'
                                     ||CHR(9)||'F_INICIALVIGENTE ['||:OLD.F_INICIALVIGENTE||'] \n'
                                     ||CHR(9)||'F_FINALVIGENTE ['||:OLD.F_FINALVIGENTE||'] \n'
                                     ||CHR(9)||'V_TARIFARESERVA ['||:OLD.V_TARIFARESERVA||'] \n');
    END IF;
    --CERRAR ARCHIVO
    UTL_FILE.FCLOSE (LF_AUDITORIA);
    EXCEPTION
    WHEN UTL_FILE.INVALID_FILEHANDLE THEN
        DBMS_OUTPUT.PUT_LINE('ARCHIVO INVALIDO');
    WHEN UTL_FILE.WRITE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('NO ES POSIBLE ESCRIBIR SOBRE EL ARCHIVO DE AUDITORIA TARIFARESERVA');
END TR_AUDITORIA_TARIFARESERVA;
/
SHOW ERRORS


/*=============================TRIGGER AUDITORÍA TARIFA PEAJE============================================================*/
CREATE OR REPLACE TRIGGER TR_AUDITORIA_TARIFAPEAJE
    AFTER INSERT OR UPDATE OR DELETE ON TARIFAPEAJE
    FOR EACH ROW
DECLARE
    LF_AUDITORIA UTL_FILE.FILE_TYPE;
BEGIN
    --PARAMETROS: DIRECTORIO, NOMBRE FILE, MODO DE LECTURA
    LF_AUDITORIA := UTL_FILE.FOPEN ('PDF', 'LF_AUDITORIA_TARIFAPEAJE.txt','A');
    UTL_FILE.PUT (LF_AUDITORIA,'El usuario ['||SYS_CONTEXT ('USERENV', 'SESSION_USER')||'] el dia y hora ['||TO_CHAR(SYSDATE,' MM/DD/YYYY HH:MI:SS')||']');
    UTL_FILE.NEW_LINE (LF_AUDITORIA);
    IF INSERTING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha insertado un nuevo registro con\n'
                                     ||CHR(9)||'K_TARIFAPEAJE ['||:NEW.K_TARIFAPEAJE||']  \n'
                                     ||CHR(9)||'Q_MEDIDAINICIAL ['||:NEW.Q_MEDIDAINICIAL||'] \n'
                                     ||CHR(9)||'Q_MEDIDAFINAL ['||:NEW.Q_MEDIDAFINAL||'] \n'
                                     ||CHR(9)||'I_UNIDADMEDIDA ['||:NEW.I_UNIDADMEDIDA||'] \n'
                                     ||CHR(9)||'I_ENLASTRE ['||:NEW.I_ENLASTRE||'] \n'
                                     ||CHR(9)||'F_INICIALVIGENTE ['||:NEW.F_INICIALVIGENTE||'] \n'
                                     ||CHR(9)||'F_FINALVIGENTE ['||:NEW.F_FINALVIGENTE||'] \n'
                                     ||CHR(9)||'V_TARIFAPEAJE ['||:NEW.V_TARIFAPEAJE||'] \n'
                                     ||CHR(9)||'K_ESCLUSA ['||:NEW.K_ESCLUSA||'] \n'
                                     ||CHR(9)||'K_CATEGORIA ['||:NEW.K_CATEGORIA||'] \n'
                                     ||CHR(9)||'N_TIPOCARGA ['||:NEW.N_TIPOCARGA||'] \n');
    ELSIF UPDATING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha actualizado el registro con\n'
                                     ||CHR(9)||'K_TARIFAPEAJE ['||:OLD.K_TARIFAPEAJE||']  \n'
                                     ||CHR(9)||'Con los siguientes valores OLD - NEW \n'
                                     ||CHR(9)||'Q_MEDIDAINICIAL ['||:OLD.Q_MEDIDAINICIAL||'] - ['||:NEW.Q_MEDIDAINICIAL||'] \n'
                                     ||CHR(9)||'Q_MEDIDAFINAL ['||:OLD.Q_MEDIDAFINAL||'] - ['||:NEW.Q_MEDIDAFINAL||'] \n'
                                     ||CHR(9)||'I_UNIDADMEDIDA ['||:OLD.I_UNIDADMEDIDA||'] - ['||:NEW.I_UNIDADMEDIDA||'] \n'
                                     ||CHR(9)||'I_ENLASTRE ['||:OLD.I_ENLASTRE||'] - ['||:NEW.I_ENLASTRE||'] \n'
                                     ||CHR(9)||'F_INICIALVIGENTE ['||:OLD.F_INICIALVIGENTE||'] - ['||:NEW.F_INICIALVIGENTE||'] \n'
                                     ||CHR(9)||'F_FINALVIGENTE ['||:OLD.F_FINALVIGENTE||'] - ['||:NEW.F_FINALVIGENTE||'] \n'
                                     ||CHR(9)||'V_TARIFAPEAJE ['||:OLD.V_TARIFAPEAJE||'] - ['||:NEW.V_TARIFAPEAJE||'] \n'
                                     ||CHR(9)||'K_ESCLUSA ['||:OLD.K_ESCLUSA||'] - ['||:NEW.K_ESCLUSA||'] \n'
                                     ||CHR(9)||'K_CATEGORIA ['||:OLD.K_CATEGORIA||'] - ['||:NEW.K_CATEGORIA||'] \n'
                                     ||CHR(9)||'N_TIPOCARGA ['||:OLD.N_TIPOCARGA||'] - ['||:NEW.N_TIPOCARGA||'] \n');
    ELSIF DELETING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha eliminado el registro con \n'
                                     ||CHR(9)||'K_TARIFAPEAJE ['||:OLD.K_TARIFAPEAJE||']  \n'
                                     ||CHR(9)||'El cual tenia la siguiente informacion\n'
                                     ||CHR(9)||'Q_MEDIDAINICIAL ['||:OLD.Q_MEDIDAINICIAL||'] \n'
                                     ||CHR(9)||'Q_MEDIDAFINAL ['||:OLD.Q_MEDIDAFINAL||'] \n'
                                     ||CHR(9)||'I_UNIDADMEDIDA ['||:OLD.I_UNIDADMEDIDA||'] \n'
                                     ||CHR(9)||'I_ENLASTRE ['||:OLD.I_ENLASTRE||'] \n'
                                     ||CHR(9)||'F_INICIALVIGENTE ['||:OLD.F_INICIALVIGENTE||'] \n'
                                     ||CHR(9)||'F_FINALVIGENTE ['||:OLD.F_FINALVIGENTE||'] \n'
                                     ||CHR(9)||'V_TARIFAPEAJE ['||:OLD.V_TARIFAPEAJE||'] \n'
                                     ||CHR(9)||'K_ESCLUSA ['||:OLD.K_ESCLUSA||'] \n'
                                     ||CHR(9)||'K_CATEGORIA ['||:OLD.K_CATEGORIA||'] \n'
                                     ||CHR(9)||'N_TIPOCARGA ['||:OLD.N_TIPOCARGA||'] \n');
    END IF;
    --CERRAR ARCHIVO
    UTL_FILE.FCLOSE (LF_AUDITORIA);
    EXCEPTION
    WHEN UTL_FILE.INVALID_FILEHANDLE THEN
        DBMS_OUTPUT.PUT_LINE('ARCHIVO INVALIDO');
    WHEN UTL_FILE.WRITE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('NO ES POSIBLE ESCRIBIR SOBRE EL ARCHIVO DE AUDITORIA TARIFARESERVA');
END TR_AUDITORIA_TARIFAPEAJE;
/
SHOW ERRORS

/*=============================TRIGGER AUDITORÍA TARIFA PEAJE============================================================*/
CREATE OR REPLACE TRIGGER TR_AUDITORIA_RESERVA
    AFTER INSERT OR UPDATE OR DELETE ON RESERVA
    FOR EACH ROW
DECLARE
    LF_AUDITORIA UTL_FILE.FILE_TYPE;
BEGIN
    --PARAMETROS: DIRECTORIO, NOMBRE FILE, MODO DE LECTURA
    LF_AUDITORIA := UTL_FILE.FOPEN ('PDF', 'LF_AUDITORIA_RESERVA.txt','A');
    UTL_FILE.PUT (LF_AUDITORIA,'El usuario ['||SYS_CONTEXT ('USERENV', 'SESSION_USER')||'] el dia y hora ['||TO_CHAR(SYSDATE,' MM/DD/YYYY HH:MI:SS')||']');
    UTL_FILE.NEW_LINE (LF_AUDITORIA);
    IF INSERTING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha insertado un nuevo registro con\n'
                                     ||CHR(9)||'K_RESERVA ['||:NEW.K_RESERVA||']  \n'
                                     ||CHR(9)||'K_BUQUE ['||:NEW.K_BUQUE||'] \n'
                                     ||CHR(9)||'N_ESTADORESERVA ['||:NEW.N_ESTADORESERVA||'] \n'
                                     ||CHR(9)||'K_IDENTIFICACION ['||:NEW.K_IDENTIFICACION||'] \n'
                                     ||CHR(9)||'K_TIPOID ['||:NEW.K_TIPOID||'] \n'
                                     ||CHR(9)||'I_TIPORESERVA ['||:NEW.I_TIPORESERVA||'] \n'
                                     ||CHR(9)||'I_DIRTRANSITO ['||:NEW.I_DIRTRANSITO||'] \n'
                                     ||CHR(9)||'F_RESERVA ['||:NEW.F_RESERVA||'] \n'
                                     ||CHR(9)||'F_TRANSITO ['||:NEW.F_TRANSITO||'] \n'
                                     ||CHR(9)||'K_ESCLUSA ['||:NEW.K_ESCLUSA||'] \n');
    ELSIF UPDATING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha actualizado el registro con\n'
                                     ||CHR(9)||'K_RESERVA ['||:OLD.K_RESERVA||']  \n'
                                     ||CHR(9)||'Con los siguientes valores OLD - NEW \n'
                                     ||CHR(9)||'K_BUQUE ['||:OLD.K_BUQUE||'] - ['||:NEW.K_BUQUE||'] \n'
                                     ||CHR(9)||'N_ESTADORESERVA ['||:OLD.N_ESTADORESERVA||'] - ['||:NEW.N_ESTADORESERVA||'] \n'
                                     ||CHR(9)||'K_IDENTIFICACION ['||:OLD.K_IDENTIFICACION||'] - ['||:NEW.K_IDENTIFICACION||'] \n'
                                     ||CHR(9)||'K_TIPOID ['||:OLD.K_TIPOID||'] - ['||:NEW.K_TIPOID||'] \n'
                                     ||CHR(9)||'I_TIPORESERVA ['||:OLD.I_TIPORESERVA||'] - ['||:NEW.I_TIPORESERVA||'] \n'
                                     ||CHR(9)||'I_DIRTRANSITO ['||:OLD.I_DIRTRANSITO||'] - ['||:NEW.I_DIRTRANSITO||'] \n'
                                     ||CHR(9)||'F_RESERVA ['||:OLD.F_RESERVA||'] - ['||:NEW.F_RESERVA||'] \n'
                                     ||CHR(9)||'F_TRANSITO ['||:OLD.F_TRANSITO||'] - ['||:NEW.F_TRANSITO||'] \n'
                                     ||CHR(9)||'K_ESCLUSA ['||:OLD.K_ESCLUSA||'] - ['||:NEW.K_ESCLUSA||'] \n');
    ELSIF DELETING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha eliminado el registro con \n'
                                     ||CHR(9)||'K_RESERVA ['||:OLD.K_RESERVA||']  \n'
                                     ||CHR(9)||'El cual tenia la siguiente informacion\n'
                                     ||CHR(9)||'K_BUQUE ['||:OLD.K_BUQUE||'] \n'
                                     ||CHR(9)||'N_ESTADORESERVA ['||:OLD.N_ESTADORESERVA||'] \n'
                                     ||CHR(9)||'K_IDENTIFICACION ['||:OLD.K_IDENTIFICACION||'] \n'
                                     ||CHR(9)||'K_TIPOID ['||:OLD.K_TIPOID||'] \n'
                                     ||CHR(9)||'I_TIPORESERVA ['||:OLD.I_TIPORESERVA||'] \n'
                                     ||CHR(9)||'I_DIRTRANSITO ['||:OLD.I_DIRTRANSITO||'] \n'
                                     ||CHR(9)||'F_RESERVA ['||:OLD.F_RESERVA||'] \n'
                                     ||CHR(9)||'F_TRANSITO ['||:OLD.F_TRANSITO||'] \n'
                                     ||CHR(9)||'K_ESCLUSA ['||:OLD.K_ESCLUSA||'] \n');
    END IF;
    --CERRAR ARCHIVO
    UTL_FILE.FCLOSE (LF_AUDITORIA);
    EXCEPTION
    WHEN UTL_FILE.INVALID_FILEHANDLE THEN
        DBMS_OUTPUT.PUT_LINE('ARCHIVO INVALIDO');
    WHEN UTL_FILE.WRITE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('NO ES POSIBLE ESCRIBIR SOBRE EL ARCHIVO DE AUDITORIA TARIFARESERVA');
END TR_AUDITORIA_RESERVA;
/
SHOW ERRORS

/*=============================TRIGGER AUDITORÍA CUPOPASO============================================================*/
CREATE OR REPLACE TRIGGER TR_AUDITORIA_CUPOPASO
    AFTER INSERT OR UPDATE OR DELETE ON CUPOPASO
    FOR EACH ROW
DECLARE
    LF_AUDITORIA UTL_FILE.FILE_TYPE;
BEGIN
    --PARAMETROS: DIRECTORIO, NOMBRE FILE, MODO DE LECTURA
    LF_AUDITORIA := UTL_FILE.FOPEN ('PDF', 'LF_AUDITORIA_CUPOPASO.txt','A');
    UTL_FILE.PUT (LF_AUDITORIA,'El usuario ['||SYS_CONTEXT ('USERENV', 'SESSION_USER')||'] el dia y hora ['||TO_CHAR(SYSDATE,' MM/DD/YYYY HH:MI:SS')||']');
    UTL_FILE.NEW_LINE (LF_AUDITORIA);
    IF INSERTING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha insertado un nuevo registro con\n'
                                     ||CHR(9)||'K_CUPOPASO ['||:NEW.K_CUPOPASO||']  \n'
                                     ||CHR(9)||'K_PASO ['||:NEW.K_PASO||'] \n'
                                     ||CHR(9)||'Q_CTOTALES ['||:NEW.Q_CTOTALES||'] \n'
                                     ||CHR(9)||'Q_CDISPONIBLES ['||:NEW.Q_CDISPONIBLES||'] \n'
                                     ||CHR(9)||'F_ASIGNACIONCUPOS ['||:NEW.F_ASIGNACIONCUPOS||'] \n');
    ELSIF UPDATING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha actualizado el registro con\n'
                                     ||CHR(9)||'K_CUPOPASO ['||:OLD.K_CUPOPASO||']  \n'
                                     ||CHR(9)||'Con los siguientes valores OLD - NEW \n'
                                     ||CHR(9)||'K_PASO ['||:OLD.K_PASO||'] - ['||:NEW.K_PASO||'] \n'
                                     ||CHR(9)||'Q_CTOTALES ['||:OLD.Q_CTOTALES||'] - ['||:NEW.Q_CTOTALES||'] \n'
                                     ||CHR(9)||'Q_CDISPONIBLES ['||:OLD.Q_CDISPONIBLES||'] - ['||:NEW.Q_CDISPONIBLES||'] \n'
                                     ||CHR(9)||'F_ASIGNACIONCUPOS ['||:OLD.F_ASIGNACIONCUPOS||'] - ['||:NEW.F_ASIGNACIONCUPOS||'] \n');
    ELSIF DELETING THEN
        UTL_FILE.PUTF (LF_AUDITORIA, CHR(9)||'Ha eliminado el registro con \n'
                                     ||CHR(9)||'K_CUPOPASO ['||:OLD.K_CUPOPASO||']  \n'
                                     ||CHR(9)||'El cual tenia la siguiente informacion\n'
                                     ||CHR(9)||'K_PASO ['||:OLD.K_PASO||'] \n'
                                     ||CHR(9)||'Q_CTOTALES ['||:OLD.Q_CTOTALES||'] \n'
                                     ||CHR(9)||'Q_CDISPONIBLES ['||:OLD.Q_CDISPONIBLES||'] \n'
                                     ||CHR(9)||'F_ASIGNACIONCUPOS ['||:OLD.F_ASIGNACIONCUPOS||'] \n');
    END IF;
    --CERRAR ARCHIVO
    UTL_FILE.FCLOSE (LF_AUDITORIA);
    EXCEPTION
    WHEN UTL_FILE.INVALID_FILEHANDLE THEN
        DBMS_OUTPUT.PUT_LINE('ARCHIVO INVALIDO');
    WHEN UTL_FILE.WRITE_ERROR THEN
        DBMS_OUTPUT.PUT_LINE('NO ES POSIBLE ESCRIBIR SOBRE EL ARCHIVO DE AUDITORIA TARIFARESERVA');
END TR_AUDITORIA_CUPOPASO;
/
SHOW ERRORS

