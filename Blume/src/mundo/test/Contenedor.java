package mundo.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Contenedor <K> {
	
	Nodo<K> cabeza;
	
	public Contenedor()
	{
		cabeza = null;
	}
	
	public Nodo crear(ResultSet rs, String clase) {
		
		K data = null;
		ResultSetMetaData metaDatos;
		
		
		try {
			
			//Crear el objeto.
			
			data = (K) Class.forName(clase).newInstance();
			Method metodos[] = Class.forName(clase).getMethods(); // shhhh ;3
			metaDatos = rs.getMetaData();
			int numColums = metaDatos.getColumnCount();
			
			while(rs.next())
			{
				for(int i = 1; i <= numColums ; i++) 
				{
					String nombreColumna = metaDatos.getColumnName(i);
					
					if(nombreColumna.contains("_"))
					{
						int num = nombreColumna.indexOf('_');
						nombreColumna = nombreColumna.substring(0, num);
					}
					
					Method metodo = buscarMetodo(nombreColumna, metodos);
					
					if(metodo != null) {
						
						asignarValor(data, metodo, rs.getObject(i) );
					}
					
				}
				
		        if (cabeza == null)
		        {
		            Nodo<K> temp = new Nodo<K>();
		            temp.setValor(data);
		            
		            cabeza = temp;
					data = (K) Class.forName(clase).newInstance();
		            
		        }
		        else
		        {
		            Nodo<K> actual = cabeza;

		            while (actual.getSiguiente() != null)
		            {
		                actual = actual.getSiguiente();
		            }
		            
		            Nodo<K> nuevo = new Nodo<K>();
		            nuevo.setValor(data);
		            
		            actual.setSiguiente(nuevo);
					data = (K) Class.forName(clase).newInstance();

		        }				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
		System.out.println("Se va a retornar un nodo.");
		return cabeza;
	}
	
	public Method buscarMetodo(String nombre, Method[] metodos)
	{
		Method resultado = null;
		boolean centry = false;
		
		String nuevoNombre = "set"+nombre; //setFECHA
		
		for(int i = 0 ;i < metodos.length && !centry ; i++)
		{
			// TODO - Verificar el nombre de la columna (EX: NOMBRE_CASA) 
			if(metodos[i].getName().compareToIgnoreCase(nuevoNombre) == 0){
				
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
	
	public Nodo<K> getCabeza()
	{
		return cabeza;
	}
	
	public void setCabeza( Nodo<K> pCabeza)
	{
		cabeza = pCabeza;
	}
}
