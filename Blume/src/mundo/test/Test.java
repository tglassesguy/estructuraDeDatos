package mundo.test;

import java.util.ArrayList;
import java.util.List;

import mundo.db.Servicio;
import mundo.facade.Facade;

public class Test {

	Servicio servicio;
	Facade facade;
	public Test()
	{
		servicio = new Servicio();
		facade = new Facade();
		
		
		
		
		Mensaje mensaje = new Mensaje("INSERT INTO ARTICULOS (ID_ARTICULO, TITULO, AUTOR, FECHA_PUBLICACION)VALUES (2,'Javier','Felipe el crack','18/02/1998')");
		facade.insertar(servicio.getCon(), mensaje);	
	}
	public static void main(String[] args) {
		new Test();
	}

}
