package mundo.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import mundo.test.Funcion;
import mundo.test.Mensaje;
import mundo.test.Nodo;

public class Usuario {
	
	public final static int PUERTO = 9999;	

	public Usuario()
	{
		//easter egg 15.
	}
	
	public Nodo enviar(Mensaje m) throws UnknownHostException, IOException, ClassNotFoundException {
		
		Socket socket = new Socket("localhost", PUERTO);
		System.out.println("Cliente conectado.");
		
		ObjectOutputStream salida =  new ObjectOutputStream(socket.getOutputStream());
		
		System.out.println("Se va a enviar un mensaje.");

		salida.writeObject(m);
		
		ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

		Nodo n = (Nodo) entrada.readObject();
		
		return n;
	}

}
