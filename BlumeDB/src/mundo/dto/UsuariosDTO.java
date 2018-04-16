package mundo.dto;

public class UsuariosDTO implements IDto {
	
	
	private int codigo;
	private String nombre;
	private int pais;

	public UsuariosDTO() 
	{
		//Easter egg 0.
	}
	
	public UsuariosDTO(int pCodigo, String pNombre)
	{
		super();
		
		this.nombre = pNombre;
		this.codigo = pCodigo;
		
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

	
	
	//TODO - Copiar los comandos sql según el FlameRobin. (Importante).

	@Override


}
