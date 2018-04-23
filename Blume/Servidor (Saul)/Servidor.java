package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private Conexion con;
	private ServerSocket servidor;
	
	private final int puerto = 2027;
    private final int noConexiones = 20;
    
       
    public void escuchar(){
        try {
            servidor = new ServerSocket(puerto,noConexiones);
            while(true){
                System.out.println("Escuchando....");
                Socket cliente = servidor.accept();

                BufferedReader inString = new BufferedReader( new InputStreamReader( cliente.getInputStream( ) ) );
                PrintWriter outString = new PrintWriter( cliente.getOutputStream( ), true );
                ObjectOutputStream outObject = new ObjectOutputStream(cliente.getOutputStream());

                HiloServidor hs = new HiloServidor(con, inString, outString, outObject);
                hs.start();
    			
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public Servidor(){
		con = new Conexion("jdbc:oracle:thin:@localhost:1521:xe","rh","rh");
    }
    
    //Funcion main para correr el servidor
    public static void main(String[] args) {

        Servidor servidor= new Servidor();
        servidor.escuchar();
    }
}
