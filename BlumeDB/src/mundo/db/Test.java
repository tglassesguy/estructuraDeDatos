package mundo.db;

import java.util.ArrayList;
import java.util.List;


import mundo.dto.LibrosDTO;
import mundo.dto.UsuariosDTO;
import mundo.facade.LibroFacade;

public class Test {
	
	public Test()
	{
		Servicio ser = new Servicio();
		LibroFacade libroFacade = new LibroFacade();
		
		UsuariosDTO usuarioNuevo = new UsuariosDTO(22, "tglassesguy", 30);
		LibrosDTO busqueda = new LibrosDTO(34,"casa","temp", 1,1,1);
		
	//	----------------------------------------------------------------------------------------------------
		
		LibrosDTO nuevo = libroFacade.consultarLibroPorIsbn(ser.getCon(), busqueda);
		
		
		
	}
	public static void main(String[] args) {
		new Test();
	}

}
