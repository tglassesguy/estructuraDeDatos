package mundo.server;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.omg.CORBA.portable.ApplicationException;

import mundo.db.Servicio;

public class Servidor {
	
	public final static int PUERTO = 9999;

	public static void main(String[] args) throws IOException {
		
		Servicio ser = new Servicio();
		
		Socket so;
        DataOutputStream salida;
        String mensajeRecibido;
        String respuesta = " ";
        BufferedReader entrada;

        ServerSocket servidor = new ServerSocket(PUERTO);
        
        String verificar = " ";
		boolean iterar = true;
		
        so = new Socket();

        System.out.println("Esperando conexion con el cliente.");
     
        System.out.println("El cliente se ha conectado.");
        
        
        while( iterar == true )
		{
	    	so = servidor.accept();
	        salida = new DataOutputStream(so.getOutputStream());
	        entrada = new BufferedReader( new InputStreamReader(so.getInputStream()));
            
	        mensajeRecibido = entrada.readLine();
	        
	        if(mensajeRecibido.contains("FIN"))
	        {
	        	respuesta = "El servidor cerrará.";
	    		iterar = true;
	        }
	        else if(mensajeRecibido.contains("INSERT"))
	        {
	        	try {
	        		
	        		ser.getCon().ejecutaActualizacion(mensajeRecibido);
	        		respuesta= "Se ha insertado el elemento.";
	        		
	        	}
	        	catch(Exception e)
	        	{
	        		respuesta = e.getMessage();
	        	}
	        }
	        else if(mensajeRecibido.contains("DELETE"))
	        {
	        	try {
	        		
	        		ser.getCon().ejecutaActualizacion(mensajeRecibido);
	        		
	        		respuesta= "Se ha eliminado el elemento.";
	        	}
	        	catch(Exception e)
	        	{
	        		respuesta = e.getMessage();
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
	        		respuesta = e.getMessage();
	        	}
	        }
	        else if(mensajeRecibido.contains("CONSULT")) 
	        {
	        	try {
	        		
	        		ser.getCon().ejecutaConsulta(mensajeRecibido);
	        		
	        		respuesta= "Se ha actualizado el elemento.";
	        		
	        	}
	        	catch(Exception e)
	        	{
	        		respuesta = e.getMessage();
	        	}
	        }
	        else
	        {
	        	 respuesta = "La operación no correspone a un comando SQL.";
	        }
	        
	        JOptionPane.showMessageDialog(null, respuesta);
	        
	    	salida.close();
	    	entrada.close();
	       
		}
        
        so.close();
        servidor.close();
	}

}
