
package servidor;

import java.io.BufferedReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import mundo.dto.Persona;

public class HiloServidor extends Thread{

	private BufferedReader inString;
	private PrintWriter outString;
	private ObjectOutputStream outObject;
	private Conexion con;
	// Lista de los usuarios conectados al servidor

	public HiloServidor(Conexion con, BufferedReader inString, PrintWriter outString,
			ObjectOutputStream outObject) {
		this.con = con;
		this.inString = inString;
		this.outString = outString;
		this.outObject = outObject;
	}

	@Override
	public void run() {
		try {
			procesaSentencias();
		} catch (Exception e) {
		}
	}

	private void procesaSentencias() throws Exception{
		while (true) {
			String sql = inString.readLine();
			
			if (sql.contains("insert") || sql.contains("update") || sql.contains("delete")) {
				boolean ok = con.ejecutaActualizacion(sql);
				if (ok)
					outString.println("OK");
				else
					outString.println("FAIL");
			} else {
				ResultSet rs = con.ejecutaConsulta(sql);
				Persona persona = null;
				try {
					if (rs.next()) {
						persona = new Persona(rs.getBigDecimal(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				outObject.writeObject(persona);
			}
		}
	}
}
