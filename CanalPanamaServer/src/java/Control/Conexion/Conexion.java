package Control.Conexion;

import Util.RHException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {

    /**
     * Instancia del ServiceLocator
     */
    private static Conexion instance = null;

    /**
     * Conexion compartida a la Base de Datos
     */
    private Connection conexion = null;

    /**
     * Bandera que indica el estado de la conexion
     */
    private boolean conexionLibre = true;

    /**
     * @return instancia del ServiceLocator para el manejo de la conexion
     */
    private static Driver driver = new oracle.jdbc.driver.OracleDriver();
    private static String URLBD = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String usuario;
    private static String contrasena;

    public static Conexion getInstance() throws RHException {
        if (instance == null) {
            try {
                instance = new Conexion();
            } catch (Exception e) {
                throw new RHException("ServiceLocator", "ERROR_CONEXION_BD " + e);
                //e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * @throws Exception dice si no se pudo crear la conexion
     */
    private Conexion() throws Exception {
        try {
            /**
             * TODO Establecer la conexion a la bd. usuario= hr, password= hr *
             */
            DriverManager.registerDriver(driver);
            conexion = DriverManager.getConnection(URLBD, usuario, contrasena);
            conexion.setAutoCommit(false);
        } catch (Exception e) {
            throw new RHException("ServiceLocator", "ERROR_CONEXION_BD " + e);
        }
    }

    /**
     * Toma la conexion para que ningun otro proceso la puedan utilizar
     *
     * @return da la conexion a la base de datos
     */
    public synchronized Connection tomarConexion() { //throws SQLException {
        while (!conexionLibre) {
            try {
                System.out.println("esperando...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("tomando conexión...");
        conexionLibre = false;
        notify();
        return conexion;
    }

    /**
     * Libera la conexion de la bases de datos para que ningun otro proceso la
     * pueda utilizar
     */
    public synchronized void liberarConexion() {
        while (conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        conexionLibre = true;
        notify();
    }

    /**
     * Cierra la conexion a la base de datos cuando se termina de ejecutar el
     * programa
     */
    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.instance = null;
    }

    /**
     * Realiza los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza cuando el procedimiento de insercion es terminado
     * correctamente y se asegura que los datos en el modelo estan bien
     * relacionados.
     * @throws Util.RHException
     */
    public void commit() throws RHException {
        try {
            conexion.commit();
        } catch (SQLException e) {
            throw new RHException("ServiceLocator", "ERROR_CONEXION_BD " + e);
            //e.printStackTrace();
        }
    }

    /**
     * Deshace los cambios en la base de datos. Con este metodo se asegura que
     * no halla inconsitencias en el modelo relacional de la Base de datos.
     *
     * Se utiliza por lo general cuando se devuelve una Exepcion. Los
     * procedimientos intermedios no deberia quedar almacenados en la base de
     * datos.
     */
    public void rollback() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Conexion.usuario = usuario;
    }

    public static String getContrasena() {
        return contrasena;
    }

    public static void setContrasena(String contrasena) {
        Conexion.contrasena = contrasena;
    }

}
