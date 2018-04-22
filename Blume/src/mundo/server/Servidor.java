package mundo.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

import mundo.db.Conexion;
import mundo.db.Servicio;
import mundo.facade.Facade;
import mundo.test.Funcion;
import mundo.test.Mensaje;
import mundo.test.Nodo;

public class Servidor {

	public final static int PUERTO = 9999;
	private ServerSocket ss = null;
	private Facade facade = null;
	private Servicio ser = null;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		new Servidor().iniciarServer(); //será necesario el new Server() ? 
	}
	
	public void iniciarServer() throws IOException, ClassNotFoundException
	{
		//Iniciar componentes.
		ss = new ServerSocket(PUERTO);
		facade = new Facade();
		ser = new Servicio();
		System.out.println("Esperando conexión...");

		Socket socket = ss.accept(); //recibe conexión.
		System.out.println("Se ha conectado un usuario.");
		
		ObjectInputStream entrada =  new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
		
		Mensaje m = (Mensaje) entrada.readObject();
		Nodo n = new Nodo();
		
		if(m.getFuncion().equals(Funcion.INSERT))
		{
			facade.insertar(ser.getCon(), m);
			n = null;
		}
		else if(m.getFuncion().equals(Funcion.UPDATE))
		{
			facade.actualizar(ser.getCon(), m);
			n = null;
		}
		else if(m.getFuncion().equals(Funcion.DELETE))
		{
			facade.eliminar(ser.getCon(), m);
			n = null;
		}
		else if(m.getFuncion().equals(Funcion.SELECT))
		{
			n = facade.consultarTodos(ser.getCon(), m);
		}
		else 
		{
			n = facade.consultar(ser.getCon(), m);
		}
		
		salida.writeObject(n);
		socket.close();
	}
}
