package mundo.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import mundo.db.Servicio;
import mundo.facade.Facade;
import mundo.test.Funcion;
import mundo.test.Mensaje;
import mundo.test.Nodo;

public class ServidorHilo
{
	public final static int PUERTO = 9999;
	private ServerSocket ss = null;
	private Facade facade = null;
	private Servicio ser = null;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		new ServidorHilo().iniciarServer(); //será necesario el new Server() ? 
	}
	
	public void iniciarServer() throws IOException, ClassNotFoundException
	{
		//Iniciar componentes.
		ss = new ServerSocket(PUERTO);
		facade = new Facade();
		ser = new Servicio();
		System.out.println("Esperando conexión...");

		boolean iterar = true;
		while(iterar == true)
		{
			Socket socket = ss.accept(); //recibe conexión.
			System.out.println("Se ha conectado un usuario.");
			
			ObjectInputStream entrada =  new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
			
			Mensaje m = (Mensaje) entrada.readObject();
			Nodo r = new Nodo();
			
			if(m.getFuncion().equals(Funcion.INSERT))
			{
				facade.insertar(ser.getCon(), m);
				r = null;
			}
			else if(m.getFuncion().equals(Funcion.UPDATE))
			{
				facade.actualizar(ser.getCon(), m);
				r = null;
			}
			else if(m.getFuncion().equals(Funcion.DELETE))
			{
				facade.eliminar(ser.getCon(), m);
				r = null;
			}
			else if(m.getFuncion().equals(Funcion.SELECT))
			{
				r = facade.consultarTodos(ser.getCon(), m);
			}
			else if(m.getFuncion().equals(Funcion.SELECT_ID))
			{
				r = facade.consultar(ser.getCon(), m);
			}
			else if(m.getFuncion().equals(Funcion.CLOSE))
			{
				iterar = false;
				r = null;
			}
			
			salida.writeObject(r);
			socket.close();
		}
	}
	
	

}
