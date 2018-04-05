package mundo.facade;

import java.util.Collection;


import mundo.dao.LibrosDAO;
import mundo.dao.UsuariosDAO;
import mundo.db.Conexion;
import mundo.dto.LibrosDTO;
import mundo.dto.UsuariosDTO;


public class LibroFacade implements IFacade 
{
	private LibrosDAO libroDao;
	private UsuariosDAO usuarioDao;

	public LibroFacade() 
	{
		// TODO Auto-generated constructor stub
		libroDao = new LibrosDAO();
		usuarioDao = new UsuariosDAO();
	}

	public void insertarLibro(Conexion con, LibrosDTO libro) {
		
		libroDao.insertarLibro(con, libro);
	}
	
	public void eliminarLibro(Conexion con, LibrosDTO libro)
	{
		libroDao.eliminarLibro(con, libro);
	}
	
	public void actualizarLibro(Conexion con, LibrosDTO libro) {
		
		libroDao.actualizarLibro(con, libro);
		
	}
	
	public Collection<LibrosDTO> consultarLibros(Conexion con) {
		return libroDao.consultarLibros(con);
	}
	
	public LibrosDTO consultarLibroPorIsbn(Conexion con, LibrosDTO libro) {
		return libroDao.consultarLibroPorIsbn(con, libro);
	}
	
	//-----//

	@Override
	public void insertarUsuario(Conexion con, UsuariosDTO usuario) {
		// TODO Auto-generated method stub
		usuarioDao.insertarUsuario(con, usuario);
	}

	@Override
	public void eliminarUsuario(Conexion con, UsuariosDTO usuario) {
		// TODO Auto-generated method stub
		usuarioDao.eliminarUsuario(con, usuario);
		
	}

	@Override
	public void actualizarUsuario(Conexion con, UsuariosDTO usuario) {
		// TODO Auto-generated method stub
		usuarioDao.actualizarUsuario(con, usuario);
		
	}

	@Override
	public Collection<UsuariosDTO> consultarUsuarios(Conexion con) {
		// TODO Auto-generated method stub
		return usuarioDao.consultarUsuarios(con);
	}

	@Override
	public UsuariosDTO consultarUsuarioPorCodigo(Conexion con, UsuariosDTO usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.consultarUsuarioPorCodigo(con, usuario);
	}
}
