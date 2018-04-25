package mundo.dto;

import java.io.Serializable;
import java.util.Collection;
import mundo.db.Conexion;

public class ArticulosDTO implements IDto, Serializable
{
	
	private static final long serialVersionUID = -5399605122490343339L;

	
	private int id;
	private String titulo;
	private int autor;
	private String fecha;
	
	public ArticulosDTO()
	{
		
	}
	
	public ArticulosDTO (int pID, String pTitulo, int pAutor, String pFecha)
	{
		super();
		
		this.id = pID;
		this.titulo = pTitulo;
		this.autor = pAutor;
		this.fecha = pFecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAutor() {
		return autor;
	}

	public void setAutor(int autor) {
		this.autor = autor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String insertar() {
		// TODO Auto-generated method stub
		return "INSERT INTO ARTICULOS (ID_ARTICULO, TITULO, AUTOR, FECHA_PUBLICACION)VALUES ("+id+",'"+titulo.trim()+"',"+autor+",'"+fecha.trim()+"')";

	}

	@Override
	public String eliminar() {
		// TODO Auto-generated method stub
		return "DELETE FROM ARTICULOS a WHERE ID_ARTICULO ="+id;
	}

	@Override
	public String actualizar() {
		// TODO Auto-generated method stub
		return "UPDATE ARTICULOS SET ID_ARTICULO = "+id+",TITULO = '"+titulo.trim()+"',AUTOR = "+autor+",FECHA_PUBLICACION = '"+fecha.trim()+"' WHERE ID_ARTICULO = "+id;
		
	}

	@Override
	public String consultar() 
	{
		// TODO Auto-generated method stub
		return "SELECT * FROM ARTICULOS";
	}
	
	@Override
	public String consultarPorID() 
	{
		// TODO Auto-generated method stub
		return "SELECT ID, TITULO, AUTOR, FECHA FROM ARTICULOS WHERE ID_ARTICULO ="+id;
	}
	
	public String toString()	
	{ 
		return "[ "+ id + " | " + titulo + " | " + autor + " | " + fecha + " ]";
	}

}
