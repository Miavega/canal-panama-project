/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.VO.ProgramacionDiariaVO;
import Util.RHException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProgramacionDiariaDAO {

    /*
     * Conexión compartida a la Base de Datos
     */
    private Connection con;

    /*
     * Objeto para procesar la secuencia SQL estática
     */
    private Statement st;

    /*
     * Objeto que contiene los resultados de la ejecución de la secuencia SQL
     */
    private ResultSet rs;

    /*
     * Objeto para hacer llamado a las funciones PL/SQL
     */
    private CallableStatement cs;

    /*
     * Constructor de la clase
     */
    public ProgramacionDiariaDAO() {
        con = null;
        st = null;
        rs = null;
    }

    public void insertarProgramacionDiaria(ArrayList<ProgramacionDiariaVO> progDiaria) throws SQLException, RHException {
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            cs = con.prepareCall("{call U_ADMIN.PK_RESERVASCP.PR_PROGRAMARPASODIARIO (?,?,?,?,?,?,?)}");
            for (int i = 0; i < progDiaria.size(); i++) {
                cs.setLong(1, progDiaria.get(i).getK_reserva());
                cs.setLong(2, progDiaria.get(i).getK_puertosalida());
                cs.setLong(3, progDiaria.get(i).getK_puertollegada());
                cs.setTimestamp(4, progDiaria.get(i).getF_progyhorallegada());
                cs.setTimestamp(5, progDiaria.get(i).getF_progyhorasalida());
                cs.setLong(6, progDiaria.get(i).getK_identificacion());
                cs.setString(7, progDiaria.get(i).getK_tipoid());
                cs.execute();
                System.out.println("creando programacionDiaria N° " + i + "...");
            }
            System.out.println("insertando programacionDiaria...");
            st.close();
            Conexion.getInstance().commit();
        } catch (SQLException ex) {
            throw new RHException("ProgramacionDiariaDAO", "No pudo insertar programacion por " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }
    }

    public ArrayList<ProgramacionDiariaVO> leerProgramacionDiaria(String f_transito) throws RHException {
        ArrayList<ProgramacionDiariaVO> listaProgDiaria = new ArrayList<ProgramacionDiariaVO>();
        String consulta = "SELECT R.K_RESERVA, B.K_BUQUE, B.N_BUQUE, P.K_PUERTOLLEGADA, P.K_PUERTOSALIDA, P.F_PROGYHORALLEGADA, P.F_PROGYHORASALIDA\n"
                + "FROM PROGRAMACIONDIARIA P, BUQUE B, RESERVA R, ORDENDEPAGO O\n"
                + "WHERE P.K_RESERVA = R.K_RESERVA \n"
                + "AND R.K_BUQUE=B.K_BUQUE\n"
                + "AND R.K_RESERVA=O.K_RESERVA\n"
                + "AND R.F_TRANSITO = '" + f_transito + "' \n"
                + "AND (O.K_CONCEPTO='RESV' AND O.N_ESTADOPAGO = 'PAG')\n"
                + "INTERSECT\n"
                + "SELECT R.K_RESERVA, B.K_BUQUE, B.N_BUQUE, P.K_PUERTOLLEGADA, P.K_PUERTOSALIDA, P.F_PROGYHORALLEGADA, P.F_PROGYHORASALIDA\n"
                + "FROM PROGRAMACIONDIARIA P, BUQUE B, RESERVA R, ORDENDEPAGO O\n"
                + "WHERE P.K_RESERVA = R.K_RESERVA \n"
                + "AND R.K_BUQUE=B.K_BUQUE\n"
                + "AND R.K_RESERVA=O.K_RESERVA\n"
                + "AND R.F_TRANSITO = '" + f_transito + "' \n"
                + "AND (O.K_CONCEPTO='PEAJ' AND O.N_ESTADOPAGO = 'NPG')";
               System.out.println("consulta " + consulta);
        try {
            con = Conexion.getInstance().tomarConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                ProgramacionDiariaVO progDiaria = new ProgramacionDiariaVO();
                progDiaria.setK_reserva(rs.getInt("k_reserva"));
                progDiaria.setK_puertollegada(rs.getInt("k_puertollegada"));
                progDiaria.setK_puertosalida(rs.getInt("k_puertosalida"));
                progDiaria.setF_progyhorallegada(rs.getTimestamp("f_progyhorallegada"));
                progDiaria.setF_progyhorasalida(rs.getTimestamp("f_progyhorasalida"));
                // replicado de reservas
                progDiaria.setCampoExtra1(String.valueOf(rs.getInt("k_buque")));
                progDiaria.setCampoExtra2(rs.getString("n_buque"));
                listaProgDiaria.add(progDiaria);
            }
            st.close();

            System.out.println("cargando programacion Diaria ...");
            return listaProgDiaria;
        } catch (SQLException ex) {
            throw new RHException("ProgramacionDiariaDAO", "No se pudo leer las programaciones Diarias " + ex.getMessage());
        } finally {
            Conexion.getInstance().liberarConexion();
        }

    }

}
