package mundo.dto;

public class LibroDTO implements IDto{
	
	// TODO - implementar atributos, m�todos constructores, get y set.
	
	private int isbn;
	private String nombre;
	private String autor;
	private int dia;
	private int mes;
	private int a�o;

	
	public LibroDTO()
	{
		super();
	}
	
	public LibroDTO( int isbn, String nombre, String autor, int dia, int mes, int a�o )
	{
		super();
		this.isbn = isbn;
		this.nombre = nombre;
		this.autor = autor;
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
	}


	public int getIsbn() 
	{
		return isbn;
	}

	public void setIsbn(int isbn)
	{
		this.isbn = isbn;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getAutor() 
	{
		return autor;
	}

	public void setAutor(String autor) 
	{
		this.autor = autor;
	}

	public int getDia()
	{
		return dia;
	}

	public void setDia(int dia)
	{
		this.dia = dia;
	}

	public int getMes()
	{
		return mes;
	}

	public void setMes(int mes) 
	{
		this.mes = mes;
	}

	public int getA�o() 
	{
		return a�o;
	}

	public void setA�o(int a�o) 
	{
		this.a�o = a�o;
	}

	@Override
	public String insertar() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modificar()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultarTodos() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultarLibrosPorId()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
