package mundo.serverTest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import mundo.test.Funcion;
import mundo.test.Mensaje;
import mundo.test.Nodo;

public class ClientePrueba {
	
	
	
	public final static int PUERTO = 8786;	


	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		Socket socket = new Socket("localhost", PUERTO);
		System.out.println("Cliente conectado.");
		Mensaje m = new Mensaje();
		m.funcionUsuario(Funcion.INSERT, 666, "Miaut", "Camila", "Catalandia");
		
		ObjectOutputStream salida =  new ObjectOutputStream(socket.getOutputStream());
		
		System.out.println("Se va a enviar un mensaje.");

		salida.writeObject(m);
		
		ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

		Nodo n = (Nodo) entrada.readObject();

	}

}
