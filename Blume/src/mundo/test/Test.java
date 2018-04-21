package mundo.test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import mundo.db.Servicio;
import mundo.facade.Facade;

public class Test {

	Servicio servicio;
	Facade facade;
	public Test()
	{
		servicio = new Servicio();
		facade = new Facade();
		Nodo nodo = new Nodo();
		
		Mensaje mensaje =  new Mensaje();
		//mensaje.setTabla(Tabla.ARTICULOS);

//		mensaje.funcionUsuario(Funcion.INSERT, 1, "DepredatorZ", "Stiwar", "Korea ");
//		facade.insertar(servicio.getCon(), mensaje);
//
//		
//		mensaje.funcionUsuario(Funcion.INSERT, 2, "RenBrack", "Felipe", "Espana ");  // el Comando no Acepta Caracteres como la Ñ toca con N
//		facade.insertar(servicio.getCon(), mensaje);
//		
//		mensaje.funcionUsuario(Funcion.INSERT, 3, "The GlassesGuy", "Javier", "Colombia ");
//		facade.insertar(servicio.getCon(), mensaje);
		
		mensaje.funcionUsuario(Funcion.DELETE, 1, "", "", "");
		facade.eliminar(servicio.getCon(), mensaje);
		
		mensaje.funcionUsuario(Funcion.DELETE, 2, "", "", "");
		facade.eliminar(servicio.getCon(), mensaje);
		
		mensaje.funcionUsuario(Funcion.DELETE, 4, "", "", "");
		facade.eliminar(servicio.getCon(), mensaje);
		
		/*mensaje.funcionArticulo(Funcion.INSERT, 8 , "casa", 2 , "19/19/1999");
		facade.insertar(servicio.getCon(), mensaje);*/
		
		nodo = facade.consultarTodos(servicio.getCon(), mensaje);
		
		while(nodo != null)
		{
			System.out.println(nodo.getValor().toString());
			nodo = nodo.getSiguiente();
		}
		
		
		
		/*
		System.out.println("por lo menos recibio un nodo. ");
		System.out.println(nodo.getValor().toString());
		*/
		
	
		
		/*try
		{
			
			
		}
		catch (Exception e)
		{
			System.out.println("Esa mierda valio madres.");
			JOptionPane.showMessageDialog(null, e.getMessage());
		}*/
		
		
		
		
		
	}
	public static void main(String[] args) {
		new Test();
	}

}
