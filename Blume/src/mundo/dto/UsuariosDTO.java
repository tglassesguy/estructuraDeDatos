package mundo.dto;

import java.io.Serializable;

public class UsuariosDTO implements IDto, Serializable
{
	private static final long serialVersionUID = -5399605122490343339L;

	private int id;
	private String username; 
	private String nombre;
	private String pais;

	public UsuariosDTO() 
	{
		//Easter egg 0.
	}
	
	public UsuariosDTO(int pId,String pUserName ,String pNombre, String pPais)
	{
		super();
		
		this.nombre = pNombre;
		this.id = pId;
		this.pais = pPais;
		this.username = pUserName;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int pId) {
		this.id = pId;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pPais) {
		this.pais = pPais;
	}
	
	
	@Override
	public String insertar() {
		// TODO Auto-generated method stub
		return "INSERT INTO USUARIOS (ID_USER, USERNAME, NOMBRE, PAIS)VALUES ("+id+",'"+username.trim()+"','"+nombre.trim()+"','"+pais.trim()+"')";

	}

	@Override
	public String eliminar() {
		// TODO Auto-generated method stub
		return "DELETE FROM USUARIOS WHERE ID_USER =" +id;
	}

	@Override
	public String actualizar() {
		// TODO Auto-generated method stub
		return "UPDATE USUARIOS a SET ID_USER = '+codigo+',USERNAME = '"+username.trim()+"',NOMBRE = '"+nombre.trim()+"',PAIS = '"+pais.trim()+"'WHERE ID_USER ="+id;

	}

	@Override
	public String consultar() {
		// TODO Auto-generated method stub
		return "SELECT * FROM USUARIOS";
	}

	@Override
	public String consultarPorID() {
		// TODO Auto-generated method stub
		return "SELECT CODIGO, USERNAME, NOMBRE, PAIS FROM ARTICULOS WHERE ID_ARTICULO = "+id;
	}
	
	public String toString()
	{
		return "[ ID: " + id + " | " + "Username: " + username + " | " + "Nombre: " + nombre + " | " + "Pais: " + pais + " ]";
	}

}
