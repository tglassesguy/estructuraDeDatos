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
		//DataInputStream entrada;}
		String verificar = " ";
		boolean iterar = false;
		
		while( iterar == false )
		{
		Socket cliente = new Socket("localhost", PUERTO);
		
		System.out.println("Cliente conectado con el servidor.");
		
		salida = new DataOutputStream(cliente.getOutputStream());
		//entrada = new DataInputStream(cliente.getInputStream());
		
		String data = JOptionPane.showInputDialog("Inserte el COMANDO SQL operación que desea realizar, FIN para salir");
		
		if(verificar.compareTo("no") == 0)
		{
			salida.writeInt(0);
			salida.flush();
			
		
	        salida.close();
	        cliente.close();
	        
			iterar = true;
		}
		else
		{
			salida.writeUTF(data);
			salida.flush();
			
			salida.close();
			cliente.close();
		
		}
		}
		
	}
}
