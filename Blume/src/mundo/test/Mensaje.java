package mundo.test;

public class Mensaje {
	
	String funcion;
	String tabla;
	String datos;
	
	public Mensaje(String pFuncion, String pTabla, String pDatos)
	{
		funcion = pFuncion;
		tabla = pTabla;
		datos = pDatos;
		
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

}
