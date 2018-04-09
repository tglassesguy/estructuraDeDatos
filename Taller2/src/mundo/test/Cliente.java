package mundo.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import mundo.db.Servicio;

public class Cliente {
	
	public final static int PUERTO = 9999;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		DataOutputStream salida;
		BufferedReader entrada;
		
		String respuestaServidor = " ";
		boolean iterar = false;
		
		
		while( iterar == false )
		{
			
			Socket cliente = new Socket("localhost", PUERTO);
			
			salida = new DataOutputStream(cliente.getOutputStream());
			entrada = new BufferedReader( new InputStreamReader(cliente.getInputStream())); 
			
			System.out.println("Cliente conectado con el servidor.");
			
			
			String data = JOptionPane.showInputDialog("Inserte el COMANDO SQL operación que desea realizar, FIN para salir");
			data = data.trim().toUpperCase();
		
			salida.writeUTF(data);
			salida.flush();
			
			if(data.contains("FIN")) {
				
				iterar = true;
				
			}

			entrada.close();
			salida.close();
			cliente.close();
			
		}
		
		
	}
}


