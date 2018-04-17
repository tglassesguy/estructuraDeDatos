package mundo.facade;

import mundo.dao.ArticulosDAO;
import mundo.dao.UsuariosDAO;
import mundo.db.Conexion;
import mundo.test.Mensaje;

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
		// TODO Auto-generated method stub
		
		if(sms.getMensaje().contains("ARTICULOS"))
		{
			articuloDao.insertar(con, sms);
		}
		else  
		{
			usuarioDao.insertar(con, sms);
		}
	}

	@Override
	public void eliminar(Conexion con, Mensaje sms) {
		// TODO Auto-generated method stub
		
		if(sms.getMensaje().contains("ARTICULOS"))
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
		if(sms.getMensaje().contains("ARTICULOS"))
		{
			articuloDao.actualizar(con, sms);
		}
		else
		{
			usuarioDao.actualizar(con, sms);
		}
		
	}

	@Override
	public void consultar(Conexion con, Mensaje sms) {
		// TODO HACER RETURN DEL NODO.
		
		if(sms.getMensaje().contains("ARTICULOS")) 
		{
			articuloDao.consultar(con, sms);
		}
		else
		{
			usuarioDao.consultar(con, sms);
		}
		
	}

	@Override
	public void consultarTodos(Conexion con, Mensaje sms) {
		// TODO HACER RETURN DEL NODO.
		
		if(sms.getMensaje().contains("ARTICULOS")) 
		{
			articuloDao.consultarTodos(con, sms);
		}
		else 
		{
			usuarioDao.consultarTodos(con, sms);
			
		}
		
	}
	
	
	
	
	
	

}
