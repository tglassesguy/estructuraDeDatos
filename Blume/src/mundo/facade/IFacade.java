package mundo.facade;

import mundo.db.Conexion;
import mundo.test.Nodo;
import mundo.test.Mensaje;

public interface IFacade {
	
	public void insertar(Conexion con, Mensaje sms);
	public void eliminar(Conexion con, Mensaje sms);
	public void actualizar(Conexion con, Mensaje sms);
	//Los void serán la clase nodo ("Lista") que se retorna.
	public Nodo consultar(Conexion con, Mensaje sms);
	public Nodo consultarTodos(Conexion con, Mensaje sms);

}
