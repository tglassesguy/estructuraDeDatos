package mundo.dao;

import javax.resource.cci.ResultSet;

import mundo.db.Conexion;
import mundo.dto.ArticulosDTO;
import mundo.dto.UsuariosDTO;
import mundo.test.Contenedor;
import mundo.test.Mensaje;
import mundo.test.Nodo;

public class UsuariosDAO implements IDao{

	@Override
	public void insertar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		int id = men.getIdUsuario(); 
		String username = men.getUsernameUsuario();
		String nombre = men.getNombreUsuario();
		String pais = men.getPaisUsuario();
		
		UsuariosDTO temp = new UsuariosDTO(id, username, nombre, pais);
	
		con.ejecutaActualizacion(temp.insertar());
		
	}

	@Override
	public void eliminar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		UsuariosDTO temp = new UsuariosDTO();
		temp.setCodigo(men.getIdUsuario());
	
		con.ejecutaActualizacion(temp.eliminar());
		
	}

	@Override
	public void actualizar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		int id = men.getIdUsuario(); 
		String username = men.getUsernameUsuario();
		String nombre = men.getNombreUsuario();
		String pais = men.getPaisUsuario();
		
		UsuariosDTO temp = new UsuariosDTO(id, username, nombre, pais);
	
		con.ejecutaActualizacion(temp.actualizar());
		
	}

	@Override
	public Nodo consultar(Conexion con, Mensaje men) {
		// TODO implementar try-catch
		
		UsuariosDTO temp = new UsuariosDTO();
		temp.setCodigo(men.getIdUsuario());
		
		ResultSet rs = (ResultSet) con.ejecutaConsulta(temp.consultarPorID());
		
		Nodo contenedor = new Contenedor<>().crear(rs, "mundo.dto.UsuariosDTO");
		
		return contenedor;
		
		
	}

	@Override
	public Nodo consultarTodos(Conexion con, Mensaje men) {
		// TODO implementar try-catch
		
		UsuariosDTO temp = new UsuariosDTO();
		
		ResultSet rs = (ResultSet) con.ejecutaConsulta(temp.consultarPorID());
		
		Nodo contenedor = new Contenedor<>().crear(rs, "mundo.dto.UsuariosDTO");
		
		return contenedor;
		
	}

	

}
