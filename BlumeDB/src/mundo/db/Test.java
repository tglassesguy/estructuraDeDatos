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
		
		libroFacade.eliminarUsuario(ser.getCon(), usuarioNuevo);
		
		List<UsuariosDTO> depto = new ArrayList<UsuariosDTO>(libroFacade.consultarUsuarios(ser.getCon()));
		
		for (int i = 0; i < depto.size(); i++) 
		{
			System.out.println(depto.get(i).toString());
		}
		
	}
	public static void main(String[] args) {
		new Test();
	}

}
