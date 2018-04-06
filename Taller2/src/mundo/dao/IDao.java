package mundo.dao;

import java.util.Collection;
import mundo.dto.LibroDTO;
import mundo.db.Conexion;

public interface IDao {
	
	public void insertar(Conexion con, LibroDTO libro);
	public void eliminar(Conexion con, LibroDTO libro);
	public void modificar(Conexion con, LibroDTO libro);
	public Collection<LibroDTO> consultarLibros(Conexion con);
	public LibroDTO consultarLibrosPorId(Conexion con, LibroDTO libro);

}
