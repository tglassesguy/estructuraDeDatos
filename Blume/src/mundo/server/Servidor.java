package mundo.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import mundo.db.Conexion;
import mundo.db.Servicio;

public class Servidor {

	public final static int PUERTO = 9999;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Servicio ser = new Servicio();
		Conexion con = ser.getCon();
		
		Socket so;
		DataOutputStream out;
		Mensaje mensajeSql;
		Nodo respuesta;
		BufferedReader in;
		
		ServerSocket servidor = new ServerSocket(PUERTO);
		
		
		
		
		

	}

}
