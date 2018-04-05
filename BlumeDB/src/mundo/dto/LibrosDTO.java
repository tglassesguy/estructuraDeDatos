package mundo.dto;

public class LibrosDTO implements IDto
{
	private int isbn;
	private String nombre;
	private String autor;
	private int dia;
	private int mes;
	private int año;

	public LibrosDTO() {
		
	}
	
	public LibrosDTO(int isbn, String nombre, String autor, int dia, int mes, int año){
		
		super();
		this.isbn = isbn;
		this.nombre = nombre;
		this.autor = autor;
		this.dia = dia;
		this.mes = mes;
		this.año = año;
		
	}
	

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	@Override
	public String insertar() {
		
		return "INSERT INTO LIBROS (ISBN, NOMBRE, AUTOR, FECHA) VALUES ("+isbn+",'"+nombre.trim()+"','"+autor.trim()+"','"+ createDate()+"')";
		
	}


	@Override
	public String eliminar() {
		// TODO Auto-generated method stub
		return "DELETE FROM LIBROS WHERE ISBN ="+ isbn;
	}

	@Override
	public String actualizar() {
		// TODO Auto-generated method stub
		return "UPDATE LIBROS  SET ISBN ="+isbn+",NOMBRE = '"+nombre.trim()+"',AUTOR = '"+autor.trim()+"',FECHA = '"+ createDate() +"' WHERE ISNB = "+isbn;
	}

	@Override
	public String consultar() {
		// TODO Auto-generated method stub
		
		return "SELECT * FROM LIBROS";
	}
	
	@Override
	public String consultarX() {
		// TODO Auto-generated method stub
		return "SELECT ISBN, NOMBRE, AUTOR, FECHA FROM LIBROS WHERE ISBN ="+isbn;

	}
	
	private String createDate()
	{
		return dia +"/"+ mes +"/"+ año;
	}
	
	public String toString() {
		
		return "[ "+ isbn+" , "+nombre.trim()+" , "+autor.trim()+" , "+createDate()+" ]";
	
	}

}
