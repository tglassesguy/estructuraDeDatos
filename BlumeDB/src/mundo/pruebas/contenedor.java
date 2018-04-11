package mundo.pruebas;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class contenedor <K> {
	
	public K contenedor(ResultSet rs, String clase) {
		
		K data = null;
		ResultSetMetaData metaDatos;
		
		try {
			
			//Crear el objeto.
			
			data = (K) Class.forName(clase).newInstance();
			Method metodos[] = Class.forName(clase).getMethods();
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
			}
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
		return data;
	}
	
	public Method buscarMetodo(String nombre, Method[] metodos)
	{
		Method resultado = null;
		boolean centry = false;
		
		for(int i = 0 ;i < metodos.length && !centry ; i++)
		{
			if(metodos[i].getName().equals("set"+nombre)){
				
				resultado = metodos[i];
				centry = true;
			}
		}
		return resultado;
	}
	
	public void asignarValor(K clase, Method metodo, Object info)
	{
		metodo.invoke(obj, args)
	}

}
