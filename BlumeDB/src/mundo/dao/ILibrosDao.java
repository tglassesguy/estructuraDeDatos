package mundo.dao;

import java.util.Collection;

import mundo.db.Conexion;
import mundo.dto.LibrosDTO;

public interface ILibrosDao
{
	
	/*
	 * Inserta un nuevo libro a la tabla LIBROS.
	 */
	public void insertarLibro(Conexion con, LibrosDTO libro);
	
	/*
	 * Elimina un libro encontrado por su ISBN.
	 */
	public void eliminarLibro(Conexion con, LibrosDTO libro);
	
	/*
	 * Actualiza un libro encontrado por su ISBN.
	 */
	public void actualizarLibro(Conexion con, LibrosDTO libro);
	
	/*
	 * Informa por consola la información de todos los libros registrados en la tabla LIBROS.
	 */
	public Collection<LibrosDTO> consultarLibros(Conexion con);
	
	/*
	 * Informa por consola la información del libro encontrado por ISBN.
	 */
	public LibrosDTO consultarLibroPorIsbn(Conexion con, LibrosDTO libro);
	
	
	//----------------//
	

}
