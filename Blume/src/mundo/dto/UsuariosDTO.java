package mundo.dto;

public class UsuariosDTO implements IDto
{
	
	private int codigo;
	private String userName; 
	private String nombre;
	private String pais;

	public UsuariosDTO() 
	{
		//Easter egg 0.
	}
	
	public UsuariosDTO(int pCodigo,String pUserName ,String pNombre, String pPais)
	{
		super();
		
		this.nombre = pNombre;
		this.codigo = pCodigo;
		this.pais = pPais;
		this.userName = pUserName;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = userName;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pPais) {
		this.pais = pais;
	}

	
	
	
	
	
	@Override
	public String insertar() {
		// TODO Auto-generated method stub
		return "INSERT INTO USUARIOS (ID_USER, USERNAME, NOMBRE, PAIS)VALUES ('+id+','"+userName.trim()+"','"+nombre.trim()+"','"+pais.trim()+"')";

	}

	@Override
	public String eliminar() {
		// TODO Auto-generated method stub
		return "DELETE FROM USUARIOS a WHERE a.ID_USER =" +codigo;
	}

	@Override
	public String actualizar() {
		// TODO Auto-generated method stub
		return "UPDATE USUARIOS a SET ID_USER = '+codigo+',USERNAME = '"+userName.trim()+"',NOMBRE = '"+nombre.trim()+"',PAIS = '"+pais.trim()+"'WHERE ID_USER ="+codigo;

	}

	@Override
	public String consultar() {
		// TODO Auto-generated method stub
		return "SELECT * FROM USUARIOS";
	}

	@Override
	public String consultarPorID() {
		// TODO Auto-generated method stub
		return "SELECT CODIGO, USERNAME, NOMBRE, PAIS FROM ARTICULOS WHERE ID_ARTICULO ="+codigo;
	}

}
