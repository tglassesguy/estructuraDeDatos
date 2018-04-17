package mundo.dao;

import mundo.db.Conexion;
import mundo.test.Mensaje;

public interface IDao {
	
	public void insertar(Conexion con, Mensaje men);
	public void eliminar(Conexion con, Mensaje men);
	public void actualizar(Conexion con, Mensaje men);
	//Los void deben ser los nodo ("Listas") que se deben implementar Luego.
	public void consultar(Conexion con, Mensaje men);
	public void consultarTodos(Conexion con, Mensaje men);

}
