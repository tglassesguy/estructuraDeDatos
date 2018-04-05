package mundo.facade;

import mundo.dto.*;

import java.util.Collection;

import mundo.db.*;

public interface IFacade {
	
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
	 * Informa por consola la informaci�n de todos los libros registrados en la tabla LIBROS.
	 */
	public Collection<LibrosDTO> consultarLibros(Conexion con);
	
	/*
	 * Informa por consola la informaci�n del libro encontrado por ISBN.
	 */
	public LibrosDTO consultarLibroPorIsbn(Conexion con, LibrosDTO libro);
	
	
	//----------------//
	/*
	 * Insetar un nuevo usuario a la tabla USUARIOS.
	 */
	public void insertarUsuario(Conexion con, UsuariosDTO usuario);
	
	/*
	 * Elimina un usuario encontrado por su c�digo.
	 */
	public void eliminarUsuario(Conexion con, UsuariosDTO usuario);
	
	/*
	 * Actualiza un usuario encontrado por su c�digo.
	 */
	public void actualizarUsuario(Conexion con, UsuariosDTO usuario);
	
	/*
	 * Informa por consola la informaci�n de todos los usuarios registrados en la tabla USUARIOS.
	 */
	public Collection<UsuariosDTO> consultarUsuarios(Conexion con);
	
	/*
	 * Informa por consola la informaci�n del usuario encontrador por c�digo.
	 */
	public UsuariosDTO consultarUsuarioPorCodigo(Conexion con, UsuariosDTO usuario);
	
}
