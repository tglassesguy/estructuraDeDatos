package interfaz;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.resource.spi.ApplicationServerInternalException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.omg.PortableServer.ThreadPolicyOperations;

import mundo.db.Servicio;
import mundo.facade.Facade;
import mundo.server.Servidor;
import mundo.server.Usuario;
import mundo.test.Funcion;
import mundo.test.Mensaje;
import mundo.test.Nodo;
import mundo.test.Tabla;

public class Prueba extends JFrame implements ActionListener
{
	
    private static final String OPCION_1 = "OPCION_1";

    private static final String OPCION_2 = "OPCION_2";
    
    private static final String OPCION_3 = "OPCION_3";

    private static final String OPCION_4 = "OPCION_4";

    private static final String OPCION_5 = "OPCION_5";

    
    private Facade facade;
    /**
     * Botón Opción 1
     */

   private JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;
    
    /**
     * Botón Opción 3
     */
    private JButton btnOpcion3;
    
    /**
     * Botón Opción 4
     */
    private JButton btnOpcion4;

    /**
     * Botón Opción 5
     */
    private JButton btnOpcion5;
    
    
    private JLabel lblId;
    private JLabel lblUserName;
    private JLabel lblNombre;
    private JLabel lblPais;
    private JLabel lblVacio;
    
    private JTextField txtID;
	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(JTextField txtUserName) {
		this.txtUserName = txtUserName;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtPais() {
		return txtPais;
	}

	public void setTxtPais(JTextField txtPais) {
		this.txtPais = txtPais;
	}

	private JTextField txtUserName;
	private JTextField txtNombre;
	private JTextField txtPais;


	
	public Prueba()
	{
		setTitle("Formulario");
		setSize(250, 200);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(7,2));
		
		lblNombre = new JLabel("Nombre");
		lblUserName = new JLabel ("User Name");
		lblId = new JLabel ("ID");
		lblPais = new JLabel ("Pais");
		lblVacio = new JLabel("");
		
		txtNombre = new JTextField ();
		txtUserName = new JTextField ();
		txtID = new JTextField ();    
		txtPais = new JTextField ();    
		
		
		// Botón opción 1
        btnOpcion1 = new JButton( "Insertar" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
       
        // Botón opción 2
        btnOpcion2 = new JButton( "Eliminar" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener(this);
       
        btnOpcion3 = new JButton( "Consultar por ID" );
        btnOpcion3.setActionCommand( OPCION_3);
        btnOpcion3.addActionListener( this );
        
        btnOpcion4 = new JButton( "Consultar" );
        btnOpcion4.setActionCommand( OPCION_4);
        btnOpcion4.addActionListener( this );
        
        btnOpcion5 = new JButton( "Exit" );
        btnOpcion5.setActionCommand( OPCION_5);
        btnOpcion5.addActionListener( this );
        
        
        
        add(lblId);
        add(txtID);
        
        add(lblNombre);
        add(txtNombre);
        
        add(lblUserName);
        add(txtUserName);
        
        add(lblPais);
        add(txtPais);
        
        add( btnOpcion1 );
        add(btnOpcion2);
        add( btnOpcion3 );
        add(btnOpcion4);
        add(lblVacio);
        add(btnOpcion5);
    
	}

	@Override
	public void actionPerformed(ActionEvent evento)
	{
		// TODO Auto-generated method stub
		String comando = evento.getActionCommand( );
		
		Nodo nodo = new Nodo();
		Usuario user= new Usuario();
		
			if(OPCION_1.equals(comando))
			{
				
				try
				{
					Mensaje mensaje =  crearMensaje(Tabla.USUARIOS, Funcion.INSERT);

					/Nodo n = user.enviar(mensaje);
					
					JOptionPane.showMessageDialog(null, "Se insertó correctamente.");
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
			if(OPCION_2.equals(comando))
			{
				
				try
				{
					Mensaje mensaje = crearMensaje(Tabla.USUARIOS, Funcion.DELETE);
					
					Nodo n = user.enviar(mensaje);
					
					JOptionPane.showMessageDialog(null, "Se eliminó correctamente.");
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
			if(OPCION_3.equals(comando))
			{
				
				
				try
				{
					Mensaje mensaje =  crearMensaje(Tabla.USUARIOS, Funcion.SELECT_ID);
					Nodo n = user.enviar(mensaje);
					
					String aviso = "";
					
					while(n != null)
					{
						aviso += n.getValor().toString() + "\n";
						n = n.getSiguiente();
					}
					
					JOptionPane.showMessageDialog(null, "La consulta por ID: "+ "\n" + aviso);
					
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
			if(OPCION_4.equals(comando))
			{
				Mensaje mensaje = new Mensaje();
				mensaje.setTabla(Tabla.USUARIOS);
				mensaje.setFuncion(Funcion.SELECT);
				
				try
				{
					Nodo n = user.enviar(mensaje);
					
					String aviso = "";
					
					while(n != null)
					{
						aviso += n.getValor().toString() + "\n";
						n = n.getSiguiente();
					}
					
					JOptionPane.showMessageDialog(null,  aviso);
				}
				catch(Exception e)
				{
					
				}
				
			}
			if(OPCION_5.equals(comando))
			{
				Mensaje mensaje = new Mensaje();
				mensaje.setFuncion(Funcion.CLOSE);
				
				try 
				{
					Nodo n = user.enviar(mensaje);	
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				dispose();
				
			}
		
		
	}
	
	public static void main( String[] args )
    {
        Prueba interfaz = new Prueba( );
        interfaz.setVisible(true);
    }
	
	public Mensaje crearMensaje(Tabla pTabla , Funcion pFuncion) throws Exception
	{
		Mensaje mensaje = new Mensaje();	
		
		if(pTabla.equals(Tabla.USUARIOS))
		{
			if(txtID.getText().equals(null)) // ;3
			{
				throw new Exception ("Debe ingresar un ID para ejecutar una función.");
			}
			else {
				int ID = Integer.parseInt(txtID.getText());
				String nombre = txtNombre.getText();
				String userName = txtUserName.getText();
				String pais = txtPais.getText();
				
				mensaje.funcionUsuario(pFuncion, ID, userName, nombre, pais);
			}
		}
		
		return mensaje;
		
	}
	

	

}
