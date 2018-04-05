package mundo.db;

import mundo.db.Conexion;

public class Servicio {
	
	private Conexion con;

	/**
	 * crea un objeto para la conxion de la base de datos crear un Map con los
	 * departamentos crear un Map con los tipos de documentos
	 */
	public Servicio() {
		con = new Conexion("jdbc:firebirdsql://localhost:3050/c:/DataBases/Blume.fdb", "SYSDBA", "masterkey");
	}

	public Conexion getCon() {
		return con;
	}

	public void setCon(Conexion con) {
		this.con = con;
	}
}