package mundo.test;

import java.io.Serializable;

public class Mensaje implements Serializable {
	 
	private static final long serialVersionUID = -5399605122490343339L;
	
	
	Funcion funcion;
	Tabla tabla;
	
	int idArticulo;
	String tituloArticulo;
	String autorArticulo;
	String fechaArticulo;
	
	int idUsuario;
	String usernameUsuario;
	String nombreUsuario;
	String paisUsuario;
	
	public Mensaje()
	{
	
	}
	
	public void funcionUsuario(Funcion pFuncion, int pId, String pUsername, String pNombre, String pPais )
	{
		tabla = Tabla.USUARIOS;
		funcion = pFuncion;
		this.idUsuario = pId;
		this.usernameUsuario = pUsername;
		this.nombreUsuario = pNombre;
		this.paisUsuario = pPais;
		
	}

	public void funcionArticulo(Funcion pFuncion, int pId, String pTitulo, String pAutor, String pFecha )
	{
		tabla = Tabla.ARTICULOS;
		funcion = pFuncion;
		this.idArticulo = pId;
		this.tituloArticulo = pTitulo;
		this.autorArticulo = pAutor;
		this.fechaArticulo = pFecha;
		
	}
	
	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getTituloArticulo() {
		return tituloArticulo;
	}

	public void setTituloArticulo(String tituloArticulo) {
		this.tituloArticulo = tituloArticulo;
	}

	public String getAutorArticulo() {
		return autorArticulo;
	}

	public void setAutorArticulo(String autorArticulo) {
		this.autorArticulo = autorArticulo;
	}

	public String getFechaArticulo() {
		return fechaArticulo;
	}

	public void setFechaArticulo(String fechaArticulo) {
		this.fechaArticulo = fechaArticulo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsernameUsuario() {
		return usernameUsuario;
	}

	public void setUsernameUsuario(String usernameUsuario) {
		this.usernameUsuario = usernameUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPaisUsuario() {
		return paisUsuario;
	}

	public void setPaisUsuario(String paisUsuario) {
		this.paisUsuario = paisUsuario;
	}

	
	

	

}
