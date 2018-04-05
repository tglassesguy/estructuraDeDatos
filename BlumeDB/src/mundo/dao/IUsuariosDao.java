package mundo.dao;

import java.util.Collection;

import mundo.db.Conexion;
import mundo.dto.UsuariosDTO;

public interface IUsuariosDao {
	
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
