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

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Socket socket = new Socket("localhost", PUERTO);
		System.out.println("Cliente conectado.");
		
		ObjectOutputStream salida =  new ObjectOutputStream(socket.getOutputStream());
		Mensaje m = new Mensaje();
		m.funcionUsuario(Funcion.SELECT, 5, "Roblemiau", "Rock Lee", "Oman");
		
		System.out.println("Se va a enviar un mensaje.");

		salida.writeObject(m);
		
		ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

		Nodo n = (Nodo) entrada.readObject();
		
		if(n == null)
		{
			JOptionPane.showMessageDialog(null, "Se ha realizado la operación.");
		}
		else
		{
			String aviso = "";
			
			while(n != null)
			{
				aviso += n.getValor().toString() + "\n";
				n = n.getSiguiente();
			}
			
			JOptionPane.showMessageDialog(null, aviso);
		}
	 
	}

}
