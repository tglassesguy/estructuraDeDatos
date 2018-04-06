package mundo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author SALAS
 *
 */
public class Conexion {
	private Connection  con;
	private Statement st;
	private ResultSet rs;

	/**
	 * Crea una conexion a la base de datos
	 * @param url ruta de la base de datos. url != null
	 * @param usuario usuario a conectar en la base de datos. usuario != null
	 * @param clave password del usuario. clave != null
	 */
	public Conexion(String url, String usuario, String clave){
		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
			System.out.println("Registre el driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No Registre el driver");
		}
		try {
			con= DriverManager.getConnection(url, usuario, clave);
			System.out.println("Conexión Exitosa");
		} catch (SQLException e) {
			System.out.println("Error al conectar: "+e.getMessage());
		}
	}
	
	/**
	 * Ejecuta una instrucciï¿½n dml y retorna la consulta
	 * @param instruccionSql consulta a ejecutar. instruccionSql != null 
	 * @return El resultado de la consulta. 
	 */
	public ResultSet ejecutaConsulta(String instruccionSql){
		rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(instruccionSql);
			System.out.println("Consulta Exitosa");
		} catch (SQLException e) {
			System.out.println("Error en la Consulta: "+e.getMessage());
		}
		return rs;
	}
	/**
	 * Ejecuta una instrucciï¿½n dml de actualizaciï¿½n y retorna falso o verdadero
	 * @param instruccionSql consulta a ejecutar. instruccionSql != null 
	 * @return true si se efectuo la actualizaciï¿½n de lo contrario false. 
	 */
	public boolean ejecutaActualizacion(String instruccionSql){
		int filas = 0;
		try {
			st = con.createStatement();
			filas = st.executeUpdate(instruccionSql);
			System.out.println("Consulta Exitosa");
			return true;
		} catch (SQLException e) {
			System.out.println("Error en la Consulta: "+e.getMessage());
			return false;
		}
	}

    /**
     * retorna un LinkedHashMap con los datos de la consulta, para ser utilizado en los JComboBox,
     * en la consulta debe venir primero el nombre y despues el cÃ³digo
     * @param consulta
     * @return Map<String ,Integer>
     */
    public Map<String ,Integer> creaMap(String consulta){
    	Map<String ,Integer> lk = new LinkedHashMap<String ,Integer>();
    	ResultSet rs = ejecutaConsulta(consulta);
    	try {
			while(rs.next()){
				lk.put(rs.getString(1).trim(), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return lk;
    }
    public boolean estaCerrada() {
        try {
            return con.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
