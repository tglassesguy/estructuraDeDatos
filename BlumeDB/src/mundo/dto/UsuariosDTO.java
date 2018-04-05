package mundo.dto;

public class UsuariosDTO implements IDto {
	
	
	private int codigo;
	private String nombre;
	private int telefono;

	public UsuariosDTO() 
	{
		//Easter egg 0.
	}
	
	public UsuariosDTO(int pCodigo, String pNombre, int pTelefono)
	{
		super();
		
		this.nombre = pNombre;
		this.codigo = pCodigo;
		this.telefono = pTelefono;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	//TODO - Copiar los comandos sql según el FlameRobin. (Importante).

	@Override
	public String insertar() {
		// TODO Auto-generated method stub
		return "INSERT INTO USUARIOS (CODIGO, NOMBRE, TELEFONO) VALUES ("+codigo+", '"+nombre.trim()+"',"+telefono+")";
	}

	@Override
	public String eliminar() {
		// TODO Auto-generated method stub
		return "DELETE FROM USUARIOS WHERE CODIGO="+codigo;
	}

	@Override
	public String actualizar() {
		// TODO Auto-generated method stub
		return "UPDATE USUARIOS SET CODIGO = "+codigo+", NOMBRE = '"+nombre.trim()+"', TELEFONO = "+telefono+" WHERE CODIGO ="+codigo;

	}

	@Override
	public String consultar() {
		// TODO Auto-generated method stub
		return "SELECT * FROM USUARIOS";
	}

	@Override
	public String consultarX() {
		// TODO Auto-generated method stub
		return "SELECT CODIGO, NOMBRE, TELEFONO FROM USUARIOS WHERE CODIGO ="+codigo;
	}
	
	public String toString()
	{
		return "[ "+codigo+", "+nombre.trim()+" , "+telefono+"]";
	}

}
