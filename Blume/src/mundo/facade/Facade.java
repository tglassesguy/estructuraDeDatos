package mundo.facade;

import mundo.dao.ArticulosDAO;
import mundo.dao.UsuariosDAO;
import mundo.db.Conexion;
import mundo.test.Funcion;
import mundo.test.Mensaje;
import mundo.test.Nodo;
import mundo.test.Tabla;

public class Facade implements IFacade {
	
	private ArticulosDAO articuloDao;
	private UsuariosDAO usuarioDao;

	public Facade() 
	{
		// TODO Auto-generated constructor stub
		articuloDao = new ArticulosDAO();
		usuarioDao = new UsuariosDAO();
			
	}

	@Override
	public void insertar(Conexion con, Mensaje sms) {
		// TODO VERIFICAR SI SE VA A USAR ENUM O NO.
		
		if(sms.getTabla().equals(Tabla.ARTICULOS))
		{
			articuloDao.insertar(con, sms);
		}
		//else if (sms.getTabla().equals(Tabla.USUARIOS));
		else
		{
			usuarioDao.insertar(con, sms);
		}
	}

	@Override
	public void eliminar(Conexion con, Mensaje sms) {
		// TODO Auto-generated method stub
		
		if(sms.getTabla().equals(Tabla.ARTICULOS))
		{
			articuloDao.eliminar(con, sms);
		}
		else
		{
			usuarioDao.eliminar(con, sms);
		}
	}

	@Override
	public void actualizar(Conexion con, Mensaje sms) {
		// TODO Auto-generated method stub
		if(sms.getTabla().equals(Tabla.ARTICULOS))
		{
			articuloDao.actualizar(con, sms);
		}
		else
		{
			usuarioDao.actualizar(con, sms);
		}
		
	}

	@Override
	public Nodo consultar(Conexion con, Mensaje sms) {
		// TODO HACER RETURN DEL NODO.
		
		Nodo nodo = new Nodo();
		
		if(sms.getTabla().equals(Tabla.ARTICULOS)) 
		{
			nodo = articuloDao.consultar(con, sms);
		}
		else
		{
			nodo = usuarioDao.consultar(con, sms);
		}
		
		return nodo;
		
	}

	@Override
	public Nodo consultarTodos(Conexion con, Mensaje sms) {
		// TODO HACER RETURN DEL NODO.
		
		Nodo nodo = new Nodo();
		
		if(sms.getTabla().equals(Tabla.ARTICULOS)) 
		{
			nodo = articuloDao.consultarTodos(con, sms);	
		}
		else
		{
			nodo = usuarioDao.consultarTodos(con, sms);
		}
		
		return nodo;
		
	}

}
