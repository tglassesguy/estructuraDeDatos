package mundo.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import mundo.db.Servicio;

public class Cliente {
	
	public final static int PUERTO = 12345;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		DataOutputStream salida;
		//DataInputStream entrada;
		
		Socket cliente = new Socket("localhost", PUERTO);
		
		System.out.println("Cliente conectado con el servidor.");
		
		salida = new DataOutputStream(cliente.getOutputStream());
		//entrada = new DataInputStream(cliente.getInputStream());
		
		String data = JOptionPane.showInputDialog("Inserte el número de la operación que desea realizar, FIN para salir");
		
		salida.writeUTF(data);
		salida.flush();
		
		salida.close();
		cliente.close();
		
	}
}
