package mundo.facade;

import mundo.db.Conexion;
import mundo.test.Mensaje

public interface IFacade {
	
	public void insertar(Conexion con, Mensaje sms);
	public void eliminar(Conexion con, Mensaje sms);
	public void actualizar(Conexion con, Mensaje sms);
	public void consultar(Conexion con, Mensaje sms);
	public void consultarTodos(Conexion con, Mensaje sms);

}
