package mundo.serverTest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import mundo.db.Conexion;
import mundo.db.Servicio;
import mundo.facade.Facade;
import mundo.test.Funcion;
import mundo.test.Mensaje;
import mundo.test.Nodo;

public class HiloServer  extends Thread{
	
	private Conexion con;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private Facade facade;
	
	public HiloServer(Conexion pCon, ObjectInputStream pEntrada , ObjectOutputStream pSalida )
	{
		this.con = pCon;
		this.entrada = pEntrada;
		this.salida = pSalida;
		facade = new Facade();
		
	}
	
	public void run()
	{
		try
		{
			iniciarServer();
		}
		catch(Exception e)
		{
			
		}
		
	}
	public void iniciarServer() throws IOException, ClassNotFoundException
	{
		//Iniciar componentes.
	System.out.println("Esperando conexión...");

		while(true)
		{
			System.out.println("Se ha conectado un usuario.");
			
			Mensaje m = (Mensaje) entrada.readObject();
			Nodo r = new Nodo();
			
			if(m.getFuncion().equals(Funcion.INSERT))
			{
				facade.insertar(con, m);
				r = null;
			}
			else if(m.getFuncion().equals(Funcion.UPDATE))
			{
				facade.actualizar(con, m);
				r = null;
			}
			else if(m.getFuncion().equals(Funcion.DELETE))
			{
				facade.eliminar(con, m);
				r = null;
			}
			else if(m.getFuncion().equals(Funcion.SELECT))
			{
				r = facade.consultarTodos(con, m);
			}
			else if(m.getFuncion().equals(Funcion.SELECT_ID))
			{
				r = facade.consultar(con, m);
			}
			
			salida.writeObject(r);
		}
	}

}
