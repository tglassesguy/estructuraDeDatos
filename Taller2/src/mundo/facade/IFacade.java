package mundo.facade;

import java.util.Collection;

import mundo.db.Conexion;
import mundo.dto.LibroDTO;

public interface IFacade {
	
	public void insertar(Conexion con, LibroDTO libro);
	public void eliminar(Conexion con, LibroDTO libro);
	public void modificar(Conexion con, LibroDTO libro);
	public Collection<LibroDTO> consultarLibros(Conexion con);
	public LibroDTO consultarLibrosPorId(Conexion con, LibroDTO libro);
	

}
