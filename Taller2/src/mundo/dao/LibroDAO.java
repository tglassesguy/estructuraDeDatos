package mundo.dao;

import java.sql.ResultSet;
import java.util.Collection;

import mundo.db.Conexion;
import mundo.dto.LibroDTO;

public class LibroDAO implements IDao{
	
	


	@Override
	public void insertar(Conexion con, LibroDTO libro) {
		// TODO Auto-generated method stub
		con.ejecutaActualizacion(libro.insertar());
	}

	@Override
	public void eliminar(Conexion con, LibroDTO libro) {
		// TODO Auto-generated method stub
		con.ejecutaActualizacion(libro.eliminar());
	}

	@Override
	public void modificar(Conexion con, LibroDTO libro) {
		// TODO Auto-generated method stub
		con.ejecutaActualizacion(libro.modificar());
	}

	//NO SE PUEDE HACER COLLECTION SI NO GENERICIDAD Y PATRON DE DISEÑO REFACTORY
	@Override
	public Collection<LibroDTO> consultarLibros(Conexion con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LibroDTO consultarLibrosPorId(Conexion con, LibroDTO libro) {
		// TODO Auto-generated method stub
		ResultSet rs = con.ejecutaConsulta(libro.consultarTodos());
		
		try {
			
			while(rs.next())
			{
				String[] fecha = rs.getString(4).split("/");
				
				libro.setNombre(rs.getString(2));
				libro.setAutor(rs.getString(3));
				libro.setISBN(rs.getString(3));
				libro.setFecha(Integer.parseInt(fecha[0]));
				libro.setMes(Integer.parseInt(fecha[1]));
				libro.setAño(Integer.parseInt(fecha[2]));
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return libro;
		return null;
	}
	
	//TODO- implementar métodos interface.

	

}
