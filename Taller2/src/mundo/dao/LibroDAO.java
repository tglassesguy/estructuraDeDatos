package mundo.dao;

import java.util.Collection;

import mundo.db.Conexion;
import mundo.dto.LibroDTO;

public class LibroDAO implements IDao{
	
	LibroDTO libroDto;
	
	public LibroDAO()
	{
	   libroDto = new LibroDTO();
	}

	@Override
	public void insertar(Conexion con, LibroDTO libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Conexion con, LibroDTO libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Conexion con, LibroDTO libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<LibroDTO> consultarLibros(Conexion con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LibroDTO consultarLibrosPorId(Conexion con, LibroDTO libro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//TODO- implementar métodos interface.

	

}
