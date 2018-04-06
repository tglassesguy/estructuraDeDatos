package mundo.facade;

import java.util.Collection;

import mundo.dao.LibroDAO;
import mundo.db.Conexion;
import mundo.dto.LibroDTO;

public class Facade implements IFacade {
	
	public Facade() {
		
		LibroDAO librodao = new LibroDAO();
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
	
}
