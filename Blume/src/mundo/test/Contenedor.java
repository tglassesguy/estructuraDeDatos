package mundo.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Contenedor <K> {
	
	public Nodo crear(ResultSet rs, String clase) {
		
		K data = null;
		ResultSetMetaData metaDatos;
		Nodo nodo = new Nodo();
		
		
		try {
			
			//Crear el objeto.
			
			data = (K) Class.forName(clase).newInstance();
			Method metodos[] = Class.forName(clase).getMethods(); // shhhh ;3
			metaDatos = rs.getMetaData();
			int numColums = metaDatos.getColumnCount();
			
			while(rs.next())
			{
				for(int i = 1; i < numColums ; i++) 
				{
					Method metodo = buscarMetodo(metaDatos.getColumnName(i), metodos);
					
					if(metodo != null) {
						
						asignarValor(data, metodo, rs.getObject(i) );
					}
					
				}
				
				if(nodo.getCabeza() == null)
				{
					nodo.setCabeza(data);
				}
				else 
				{
					nodo.setSiguiente(data);
					nodo = (Nodo) nodo.getSiguiente();
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
		return nodo;
	}
	
	public Method buscarMetodo(String nombre, Method[] metodos)
	{
		Method resultado = null;
		boolean centry = false;
		
		for(int i = 0 ;i < metodos.length && !centry ; i++)
		{
			// TODO - Verificar el nombre de la columna (EX: NOMBRE_CASA) 
			if(metodos[i].getName().equals( "setIsbn"/*"set"+nombre*/)){
				
				resultado = metodos[i];
				centry = true;
			}
		}
		return resultado;
	}
	
	public void asignarValor(K clase, Method metodo, Object info) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		
		//TODO- REVISAR METODO, POSIBLE ERROR.
		 metodo.invoke(clase, info);	
	}
}
