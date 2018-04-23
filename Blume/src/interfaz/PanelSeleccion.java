package interfaz;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import mundo.db.Servicio;
import mundo.facade.Facade;
import mundo.server.Usuario;
import mundo.test.Funcion;
import mundo.test.Mensaje;
import mundo.test.Nodo;
import mundo.test.Tabla;

import mundo.facade.Facade;

public class PanelSeleccion extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
		private InterfazPrincipal interfaz;

	    private static final String EJECUCION = "EJECUCION";
	    private static final String INSERTAR = "INSERTAR";	    
	    private static final String ELIMINAR = "ELIMINAR";	   
	    private static final String CONSULTAR = "CONSULTAR";
	    private static final String ACTUALIZAR = "ACTUALIZAR";
	    private static final String USUARIO = "USUARIO";
	    private static final String ARCHIVOS = "ARCHIVOS";
	    	    
	    
	    private JLabel lblId;
	    private JLabel lblUserName;
	    private JLabel lblNombre;
	    private JLabel lblPais;
	    private JLabel lblVacio;
	    private JLabel lblVacio2;
	    
	    private JLabel lblId_Articulo;
	    private JLabel lblTitulo;
	    private JLabel lblAutor;
	    private JLabel lblFecha_Pubicacion;
	    
	    private JTextField txtID;
	    private JTextField txtUserName;
		private JTextField txtNombre;
		private JTextField txtPais;
	   
		private JTextField txtId_Articulo;;
		private JTextField txtTitulo;
		private JTextField txtAutor;
		private JTextField txtFecha_Publicacion;
		
	    private Facade facade;
	    
	    private JButton btnEjecutar;
	    private JButton btnInsertar;
	    private JButton btnEliminar;
	    private JButton btnConsultar;
	    private JButton btnActualizar;
	    
	    private JCheckBox chkUsuario;
	    private JButton btnTabla;
	    private JButton btnUsuario;
	    
	    private JTextField txtEjecucion;
	    private JTextField txtRespuesta;
	    
	    private Tabla tabla = null;
	    private Funcion funcion = null;
	    
	    
	    public PanelSeleccion(InterfazPrincipal ia)
	    {
	    	interfaz = ia;
	    	setBorder(new TitledBorder(BorderFactory.createTitledBorder("Informacion")));
	    	setLayout(new BorderLayout());
	    	
	    	txtEjecucion = new JTextField();
	    	txtEjecucion.setEditable(true);
	    	
	    	lblVacio = new JLabel(" ");
	    	lblVacio2 = new JLabel(" ");
	    	
	    	lblAutor = new JLabel("Autor");
			lblTitulo = new JLabel ("Titulo");
			lblId_Articulo = new JLabel ("ID articulo");
			lblFecha_Pubicacion = new JLabel ("Fecha publicacion");
			
			txtAutor = new JTextField ();
			txtTitulo = new JTextField ();
			txtId_Articulo = new JTextField ();    
			txtFecha_Publicacion = new JTextField ();    
	    	
	    	JPanel der1 = new JPanel();
			der1.setLayout(new GridLayout(4, 2));
			
			der1.add(lblId_Articulo);
			der1.add(txtId_Articulo);
			der1.add(lblTitulo);
			der1.add(txtTitulo);
			der1.add(lblAutor);
			der1.add(txtAutor);
			der1.add(lblFecha_Pubicacion);
			der1.add(txtFecha_Publicacion);
	    	
	    	lblNombre = new JLabel("Nombre");
			lblUserName = new JLabel ("User Name");
			lblId = new JLabel ("ID");
			lblPais = new JLabel ("Pais");
			
			txtNombre = new JTextField ();
			txtUserName = new JTextField ();
			txtID = new JTextField ();    
			txtPais = new JTextField ();    
			
			JPanel iz1 = new JPanel();
			iz1.setLayout(new GridLayout(4, 2));
			
			iz1.add(lblNombre);
			iz1.add(txtNombre);
			iz1.add(lblUserName);
			iz1.add(txtUserName);
			iz1.add(lblId);
			iz1.add(txtID);
			iz1.add(lblPais);
			iz1.add(txtPais);
			
			JPanel formularios = new JPanel();
			formularios.setLayout(new GridLayout(1, 4));
			
			formularios.add(iz1);
			formularios.add(lblVacio);
			formularios.add(der1);
			formularios.add(lblVacio2);
			
				    	
	    	btnEjecutar = new JButton(new ImageIcon("Data/if_Inkcontober_Screech_Psyduck_2730368.png"));
	    	btnEjecutar.setActionCommand(EJECUCION);  
	    	btnEjecutar.addActionListener(this);
	    	
	    	JPanel mitadSuperior = new JPanel();
	    	mitadSuperior.setLayout(new GridLayout(1, 2));
	    	
	    	mitadSuperior.add(txtEjecucion);
	    	mitadSuperior.add(btnEjecutar);
	    	
	    	btnInsertar = new JButton(new ImageIcon("Data/if_document_text_add_103511.png"));
	    	btnInsertar.setActionCommand(INSERTAR);
	    	btnInsertar.addActionListener(this);
	    	
	    	btnEliminar = new JButton(new ImageIcon("Data/if_basket_1814090.png"));
	    	btnEliminar.setActionCommand(ELIMINAR);
	    	btnEliminar.addActionListener(this);
	    	
	    	btnConsultar = new JButton(new ImageIcon("Data/if_337-Document_Search_2124221.png"));
	    	btnConsultar.setActionCommand(CONSULTAR);
	    	btnConsultar.addActionListener(this);
	    	
	    	btnActualizar = new JButton(new ImageIcon("Data/if_update_172618.png"));
	    	btnActualizar.setActionCommand(ACTUALIZAR);
	    	btnActualizar.addActionListener(this);
	    	
	    	JPanel mitadMedia = new JPanel();
	    	mitadMedia.setLayout(new GridLayout(1, 4));
	    	
	    	mitadMedia.add(btnInsertar);
	    	mitadMedia.add(btnEliminar);
	    	mitadMedia.add(btnActualizar);
	    	mitadMedia.add(btnConsultar);
	    	
	    	chkUsuario = new JCheckBox ("Usuarios", false);
	    	
	    	btnTabla = new JButton(new ImageIcon("Data/if_document_1055071.png"));
	    	btnTabla.setActionCommand(ARCHIVOS);
	    	btnTabla.addActionListener(this);
	    	
	    	btnUsuario = new JButton(new ImageIcon("Data/if_JD-06_2625478.png"));
	    	btnUsuario.setActionCommand(USUARIO);
	    	btnUsuario.addActionListener(this);
	    
	    	
	    	JPanel mitadBaja = new JPanel();
	    	mitadBaja.setLayout(new GridLayout(1,2));
	    	
	    	mitadBaja.add(btnUsuario);
	    	mitadBaja.add(btnTabla);

	    	JPanel top = new JPanel();
	    	top.setLayout(new GridLayout(2, 1));
	    	
	    	top.add(mitadSuperior);
	    	top.add(mitadMedia);
	    	
	    	JPanel ala = new JPanel();
	    	ala.setLayout(new GridLayout(2, 1));
	    	
	    	add(top, BorderLayout.NORTH);
	    	add(formularios , BorderLayout.SOUTH);
	    	add(mitadBaja , BorderLayout.CENTER);
	    	
	    	estadoInicial();
	    }

//	    public boolean si(ActionEvent evento)
//	    {
//	    	String comando = evento.getActionCommand( );
//			
//	    	if(USUARIO.equals(comando))
//			{
//				ex = true;
//				
//			}
//	    	return ex;
//	    }
		@Override
		public void actionPerformed(ActionEvent evento)
		{
			// TODO Auto-generated method stub
			String comando = evento.getActionCommand( );
			Usuario user= new Usuario();
				
			if(INSERTAR.equals(comando) )
			{
				
				btnActualizar.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnConsultar.setEnabled(false);
				
				btnTabla.setEnabled(true);
				btnUsuario.setEnabled(true);
				
				funcion  = Funcion.INSERT;
		
			}
			if(ELIMINAR.equals(comando))
			{
				
				btnActualizar.setEnabled(false);
				btnInsertar.setEnabled(false);
				btnConsultar.setEnabled(false);
				
				btnTabla.setEnabled(true);
				btnUsuario.setEnabled(true);
				
				funcion  = Funcion.DELETE;
		
			}
			if(ACTUALIZAR.equals(comando))
			{
				
				btnEliminar.setEnabled(false);
				btnInsertar.setEnabled(false);
				btnConsultar.setEnabled(false);
				
				btnTabla.setEnabled(true);
				btnUsuario.setEnabled(true);
				
				funcion  = Funcion.UPDATE;
		
			}
			if(CONSULTAR.equals(comando))
			{
				
				btnEliminar.setEnabled(false);
				btnInsertar.setEnabled(false);
				btnActualizar.setEnabled(false);
				
				btnTabla.setEnabled(true);
				btnUsuario.setEnabled(true);
				
				int reply = JOptionPane.showConfirmDialog(null, "�Desea consultar por ID?", "|Consulta en Blume|",  JOptionPane.YES_NO_OPTION);
				if(reply == JOptionPane.YES_OPTION)
				{
					funcion = Funcion.SELECT_ID;
				}
				else
				{
					funcion = Funcion.SELECT;
				}
		
			}
			if(USUARIO.equals(comando))
			{
				tabla = Tabla.USUARIOS;
				btnTabla.setEnabled(false);
				activarFormulario();
			}
			if(ARCHIVOS.equals(comando))
			{
				tabla = Tabla.ARTICULOS;
				btnUsuario.setEnabled(false);
				activarFormulario();
			}
			
			if(EJECUCION.equals(comando)) 
			{
				try {
					Mensaje m = crearMensaje();
					estadoInicial();
					Nodo n = user.enviar(m);
					
					if(n != null)
					{
						String mensajeNodo = "";
						
						while(n != null)
						{
							mensajeNodo += n.getValor().toString() + "\n";
							n = n.getSiguiente();
						}
						
						//TODO - PONE mensajeNodo EN EL TXT CORRESPONDIENTE.
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
			
		
				
			
//			if(OPCION_2.equals(comando))
//			{
//				
//				try
//				{
//					Mensaje mensaje = crearMensaje(Tabla.USUARIOS, Funcion.DELETE);
//					
//					Nodo n = user.enviar(mensaje);
//					
//					JOptionPane.showMessageDialog(null, "Se elimin� correctamente.");
//					
//				}
//				catch(Exception e)
//				{
//					JOptionPane.showMessageDialog(null, e.getMessage());
//				}
//				
//			}
//			if(OPCION_3.equals(comando))
//			{
//				
//				
//				try
//				{
//					Mensaje mensaje =  crearMensaje(Tabla.USUARIOS, Funcion.SELECT_ID);
//					Nodo n = user.enviar(mensaje);
//					
//					
//					
//				}
//				catch (Exception e)
//				{
//					JOptionPane.showMessageDialog(null, e.getMessage());
//				}
//			}
//			if(OPCION_4.equals(comando))
//			{
//				Mensaje mensaje = new Mensaje();
//				mensaje.setTabla(Tabla.USUARIOS);
//				mensaje.setFuncion(Funcion.SELECT);
//				
//				try
//				{
//					Nodo n = user.enviar(mensaje);
//					
//					String aviso = "";
//					
//					while(n != null)
//					{
//						aviso += n.getValor().toString() + "\n";
//						n = n.getSiguiente();
//					}
//					
//					JOptionPane.showMessageDialog(null,  aviso);
//				}
//				catch(Exception e)
//				{
//					
//				}
//				
//			}
//			if(OPCION_5.equals(comando))
//			{
//				Mensaje mensaje = new Mensaje();
//				mensaje.setFuncion(Funcion.CLOSE);
//				
//				try 
//				{
//					Nodo n = user.enviar(mensaje);	
//				}
//				catch (Exception e)
//				{
//					JOptionPane.showMessageDialog(null, e.getMessage());
//				}
//				
//				dispose();
//				
//			}
//		
//		
//		
//		
		}
			
			
		public Mensaje crearMensaje() throws Exception
		{
			Mensaje mensaje = new Mensaje();
			
			if(tabla.equals(Tabla.USUARIOS))
			{
				if(funcion.equals(Funcion.SELECT))
				{
					mensaje.funcionUsuario(funcion, 0, "", "", "");
				}
				else if(txtID.getText().equals(null)) // ;3
				{
					throw new Exception ("Debe ingresar un ID para ejecutar una funci�n.");
				}
				else
				{
					int ID = Integer.parseInt(txtID.getText());
					String nombre = txtNombre.getText();
					String userName = txtUserName.getText();
					String pais = txtPais.getText();
					
					mensaje.funcionUsuario(funcion, ID, userName, nombre, pais);
				}
				
			}
			else
			{
				throw new Exception("Debe indicar una tabla para realizar la operaci�n.");
			}
			
			return mensaje;
			
		}
		
		public void estadoInicial() 
		{
			// Tablas
			btnTabla.setEnabled(false);
			btnUsuario.setEnabled(false);
			
			// Formulario.
			txtID.setText("");
			txtID.setEnabled(false);
			txtNombre.setText("");
			txtNombre.setEnabled(false);
			txtPais.setText("");
			txtPais.setEnabled(false);
			txtUserName.setText("");
			txtUserName.setEnabled(false);
			
			// Atributos.
			funcion = null;
			tabla = null;
			
			//Botones
			btnInsertar.setEnabled(true);
			btnActualizar.setEnabled(true);
			btnEliminar.setEnabled(true);
			btnConsultar.setEnabled(true);
			
		}
		
		public void activarFormulario()
		{
			if(tabla.equals(Tabla.USUARIOS))
			{
				if(funcion.equals(Funcion.DELETE) || funcion.equals(Funcion.SELECT_ID))
				{
					txtID.setEnabled(true);
				}
				else if(funcion.equals(Funcion.UPDATE) || funcion.equals(Funcion.INSERT))
				{
					txtID.setEnabled(true);
					txtNombre.setEnabled(true);
					txtPais.setEnabled(true);
					txtUserName.setEnabled(true);
					
				}
				else if(funcion.equals(Funcion.SELECT))
				{
					//Easter egg 98.
					System.out.println("Se van a consultar todos los usuarios de la tabla seleccionada.");
				}
			}
			
		}
		
			
	
			
}


		
		
		//public Mensaje crearMensaje(Tabla pTabla , Funcion pFuncion,) throws Exception
		//{
		//	Mensaje mensaje = new Mensaje();
			
			
			
			
	//		return mensaje;
			
//		}

	
