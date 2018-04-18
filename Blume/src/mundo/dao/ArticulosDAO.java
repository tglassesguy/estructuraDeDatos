package mundo.dao;

import javax.resource.cci.ResultSet;

import mundo.db.Conexion;
import mundo.test.Mensaje;

public class ArticulosDAO implements IDao {

	@Override
	public void insertar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		con.ejecutaActualizacion(men.getMensaje());		
		
	}

	@Override
	public void eliminar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		con.ejecutaActualizacion(men.getMensaje());
		
	}

	@Override
	public void actualizar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		con.ejecutaActualizacion(men.getMensaje());
		
	}

	@Override
	public void consultar(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		ResultSet rs = (ResultSet) con.ejecutaConsulta(men.getMensaje());
		
	}

	@Override
	public void consultarTodos(Conexion con, Mensaje men) {
		// TODO Auto-generated method stub
		
		ResultSet rs = (ResultSet) con.ejecutaConsulta(men.getMensaje());
		
		
	}

}
