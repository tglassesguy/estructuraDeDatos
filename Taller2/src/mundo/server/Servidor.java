package mundo.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import mundo.db.Conexion;
import mundo.db.Servicio;

public class Servidor {
	
	public final static int PUERTO = 9999;

	public static void main(String[] args) throws IOException {
		
		Servicio ser = new Servicio();
		Conexion con = ser.getCon();
		
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
	        mensajeRecibido = mensajeRecibido.substring(2, mensajeRecibido.length());
	        
	        if(mensajeRecibido.contains("FIN"))
	        {
	        	respuesta = "El servidor cerrará.";
	    		iterar = true;
	        }
	        else if(mensajeRecibido.contains("INSERT"))
	        {
	        	try {
	        		
	        		con.ejecutaActualizacion(mensajeRecibido);//TODO - cambiar esto.
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
	        		
	        		con.ejecutaActualizacion(mensajeRecibido);
	        		
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
	        		
	        		con.ejecutaActualizacion(mensajeRecibido);
	        		
	        		respuesta= "Se ha actualizado el elemento.";
	        		
	        	}
	        	catch(Exception e)
	        	{
	        		respuesta = e.getMessage();
	        	}
	        }
	        else if(mensajeRecibido.contains("SELECT") && mensajeRecibido.contains("FROM")) 
	        {
	        	try {
	        		
	        		ResultSet rs = con.ejecutaConsulta(mensajeRecibido);
	        		String nuevoMensaje ="";
	        		
	        		
	        		while (rs.next()) {
	    				
	    				nuevoMensaje += "[ "+ rs.getInt(1) +" , "+ rs.getString(2) +" , "+ rs.getString(3) +" , "+ rs.getString(4) + "]"+ '\n';
	    				
	    			}
	        		
	        		if(nuevoMensaje.isEmpty()) {
	        			
	        			respuesta = "Está vacia la tabla.";
	        			
	        		}
	        		else {
	        			
	        			respuesta = nuevoMensaje;
	        			
	        		}	        		
	        		
	        		
	        	}
	        	catch(Exception e)
	        	{
	        		respuesta = e.getMessage();
	        	}
	        }
	        else if(mensajeRecibido.contains("SELECT") && mensajeRecibido.contains("WHERE")) 
	        {
	        		try {
	        		
	        		ResultSet rs = con.ejecutaConsulta(mensajeRecibido);
	        		String nuevoMensaje = "";
	        		
	        		
	        		while (rs.next()) {
	    				
	    				nuevoMensaje += "[ "+ rs.getInt(1) +" , "+ rs.getString(2) +" , "+ rs.getString(3) +" , "+ rs.getString(4) +" , "+ " ]"+ '\n';
	    				
	    			}
	        		
	        		respuesta = nuevoMensaje;
	        		
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
