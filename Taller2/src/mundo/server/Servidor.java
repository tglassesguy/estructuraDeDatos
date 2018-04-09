package mundo.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import mundo.db.Servicio;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		Servicio ser = new Servicio();
		
		Socket so;
        DataOutputStream salida;
        String mensajeRecibido;
        String respuesta = "";
        BufferedReader entrada;

        ServerSocket servidor = new ServerSocket(12345);

        so = new Socket();

        System.out.println("Esperando conexion con el cliente.");


        so = servidor.accept();
        System.out.println("El cliente se ha conectado.");
        
        salida = new DataOutputStream(so.getOutputStream());
        entrada = new BufferedReader( new InputStreamReader(so.getInputStream()));
        
        mensajeRecibido = entrada.readLine();
        
        mensajeRecibido = mensajeRecibido.trim().toUpperCase();
        
        if(mensajeRecibido.contains("FIN"))
        {
        	respuesta= "Se cerrará el programa.";
        }
        else if(mensajeRecibido.contains("INSERTAR"))
        {
        	try {
        		
        		ser.getCon().ejecutaActualizacion(mensajeRecibido);
        		
        		respuesta= "Se ha insertado el elemento.";
        		
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
        else if(mensajeRecibido.contains("ELIMINAR"))
        {
        	try {
        		
        		ser.getCon().ejecutaActualizacion(mensajeRecibido);
        		
        		respuesta= "Se ha eliminado el elemento.";
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
        else if(mensajeRecibido.contains("UPDATE")) 
        {
        	try {
        		
        		ser.getCon().ejecutaActualizacion(mensajeRecibido);
        		
        		respuesta= "Se ha actualizado el elemento.";
        		
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
        else
        {
        	respuesta= "La operación no correspone a un comando SQL.";
        }
        
        JOptionPane.showMessageDialog(null, respuesta);
        
        salida.close();
        entrada.close();
        so.close();
        servidor.close();
       
	}

}
