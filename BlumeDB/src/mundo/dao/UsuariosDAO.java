package mundo.dao;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;

import mundo.db.Conexion;
import mundo.dto.LibrosDTO;
import mundo.dto.UsuariosDTO;

public class UsuariosDAO implements IUsuariosDao{
	

	public UsuariosDAO() {

	}

	@Override
	public void insertarUsuario(Conexion con, UsuariosDTO usuario) {
		// TODO Auto-generated method stub
		con.ejecutaActualizacion(usuario.insertar());
	}

	@Override
	public void eliminarUsuario(Conexion con, UsuariosDTO usuario) {
		// TODO Auto-generated method stub
		con.ejecutaActualizacion(usuario.eliminar());
		
	}

	@Override
	public void actualizarUsuario(Conexion con, UsuariosDTO usuario) {
		// TODO Auto-generated method stub
		con.ejecutaActualizacion(usuario.actualizar());
	}

	@Override
	public Collection<UsuariosDTO> consultarUsuarios(Conexion con) {
		// TODO Auto-generated method stub
		
		ResultSet rs = con.ejecutaConsulta(new UsuariosDTO().consultar());
		LinkedList<UsuariosDTO> datos = new LinkedList<UsuariosDTO>();
		
		try {
			while(rs.next()) 
			{
				datos.add(new UsuariosDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
		return datos;
	}

	@Override
	public UsuariosDTO consultarUsuarioPorCodigo(Conexion con, UsuariosDTO usuario) {
		// TODO Auto-generated method stub
		
		ResultSet rs = con.ejecutaConsulta(usuario.consultarX());
		
		try {
			while(rs.next()) {
				
				usuario.setNombre(rs.getString(2));
				usuario.setTelefono(rs.getInt(3));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuario;
	}

}
