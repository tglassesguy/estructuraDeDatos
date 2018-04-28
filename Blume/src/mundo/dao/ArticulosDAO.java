package mundo.dao;

import java.sql.ResultSet;
import mundo.db.Conexion;
import mundo.dto.ArticulosDTO;
import mundo.test.Contenedor;
import mundo.test.Mensaje;
import mundo.test.Nodo;

public class ArticulosDAO implements IDao {	

	@Override
	public void insertar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		int id = men.getIdArticulo(); 
		String titulo = men.getTituloArticulo();
		String autor = men.getAutorArticulo();
		String fecha = men.getFechaArticulo();
		
		ArticulosDTO temp = new ArticulosDTO(id, titulo, autor, fecha);
		
		con.ejecutaActualizacion(temp.insertar());		
		
	}

	@Override
	public void eliminar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		ArticulosDTO temp = new ArticulosDTO();
		temp.setId(men.getIdArticulo());
		
		con.ejecutaActualizacion(temp.eliminar());
		
	}

	@Override
	public void actualizar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		int id = men.getIdArticulo(); 
		String titulo = men.getTituloArticulo();
		String autor = men.getAutorArticulo();
		String fecha = men.getFechaArticulo();
		
		ArticulosDTO temp = new ArticulosDTO(id, titulo, autor, fecha);
		
		con.ejecutaActualizacion(temp.actualizar());
		
	}

	@Override
	public Nodo consultar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		ArticulosDTO temp = new ArticulosDTO();
		temp.setId(men.getIdArticulo());
		
		ResultSet rs = con.ejecutaConsulta(temp.consultarPorID());
		
		Nodo contenedor = new Contenedor<>().crear(rs, "mundo.dto.ArticulosDTO");
		
		return contenedor;
	
	}

	@Override
	public Nodo consultarTodos(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		ArticulosDTO temp = new ArticulosDTO();
		
		ResultSet rs = con.ejecutaConsulta(temp.consultar());
		
		Nodo contenedor = new Contenedor<>().crear(rs, "mundo.dto.ArticulosDTO");
		
		return contenedor;
		
		
	}

}
