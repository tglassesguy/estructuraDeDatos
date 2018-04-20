package mundo.test;

public class Mensaje {
	
	Funcion funcion;
	Tabla tabla;
	
	int idArticulo;
	String tituloArticulo;
	int autorArticulo;
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
	
	public void funcionArticulo(Funcion pFuncion, int pId, String pTitulo, int pAutor, String pFecha )
	{
		tabla = Tabla.ARTICULOS;
		funcion = pFuncion;
		this.idArticulo = pId;
		this.tituloArticulo = pTitulo;
		this.autorArticulo = pAutor;
		this.fechaArticulo = pFecha;
		
	}
	
	

	

}
