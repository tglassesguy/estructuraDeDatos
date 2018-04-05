package mundo.dao;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import mundo.db.Conexion;
import mundo.dto.LibrosDTO;
import mundo.dto.UsuariosDTO;

public class LibrosDAO implements ILibrosDao
{

	@Override
	public void insertarLibro(Conexion con, LibrosDTO libro) {
		// TODO Auto-generated method stub		
		con.ejecutaActualizacion(libro.insertar());
		
	}

	@Override
	public void eliminarLibro(Conexion con, LibrosDTO libro) {
		// TODO Auto-generated method stub
		con.ejecutaActualizacion(libro.eliminar());
	}

	@Override
	public void actualizarLibro(Conexion con, LibrosDTO libro) {
		// TODO Auto-generated method stub
		con.ejecutaActualizacion(libro.actualizar());
	}

	@Override
	public Collection<LibrosDTO> consultarLibros(Conexion con) {
		// TODO Auto-generated method stub
		
		LibrosDTO dpto = new LibrosDTO();
		List<LibrosDTO> datos = new LinkedList<LibrosDTO>();
		ResultSet rs = con.ejecutaConsulta(dpto.consultar());

		try {
			while (rs.next()) {
				
				String[] fecha = rs.getString(4).split("/");
				
				datos.add(new LibrosDTO(rs.getInt(1), rs.getString(2), rs.getString(3), Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]) ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datos;

	}

	@Override
	public LibrosDTO consultarLibroPorIsbn(Conexion con, LibrosDTO libro) {
		// TODO Auto-generated method stub
				
		ResultSet rs = con.ejecutaConsulta(libro.consultarX());
		
		try {
			
			while(rs.next())
			{
				String[] fecha = rs.getString(4).split("/");
				
				libro.setNombre(rs.getString(2));
				libro.setAutor(rs.getString(3));
				libro.setDia(Integer.parseInt(fecha[0]));
				libro.setMes(Integer.parseInt(fecha[1]));
				libro.setAño(Integer.parseInt(fecha[2]));

			}
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return libro;
		
	}


}
