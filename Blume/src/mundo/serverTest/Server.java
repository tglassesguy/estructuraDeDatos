package mundo.serverTest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import mundo.db.Conexion;
import mundo.db.Servicio;

public class Server {
	
	private ServerSocket servidor;
	private Servicio servicio;
	
	private static final int PUERTO = 8786;
	private static final int noConexiones = 20;
	
	private void escuchar() {
		try
		{
			servidor = new ServerSocket(PUERTO, noConexiones);
			
			while(true)
			{
				System.out.println("Hola... esperando...");
				Socket cliente = servidor.accept(); //Llega el papu.
				JOptionPane.showMessageDialog(null,cliente.getInetAddress().getLocalHost().getHostAddress());
				
				ObjectInputStream entrada =  new ObjectInputStream(cliente.getInputStream());
				ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
				
				HiloServer hilo = new HiloServer(servicio.getCon(), entrada, salida);
				
				hilo.start();
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public Server()
	{
		servicio = new Servicio();
	}
	
	public static void main (String[] args)
	{
		Server ser = new Server();
		
		ser.escuchar();
	}
	
	
	
}
