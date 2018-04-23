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

	    private JTextField txtID;
	    private JTextField txtUserName;
		private JTextField txtNombre;
		private JTextField txtPais;
	    
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
	    
	    private boolean ex = false;
	    
	    public PanelSeleccion(InterfazPrincipal ia)
	    {
	    	interfaz = ia;
	    	setBorder(new TitledBorder(BorderFactory.createTitledBorder("Informacion")));
	    	setLayout(new BorderLayout());
	    	
	    	txtEjecucion = new JTextField();
	    	txtEjecucion.setEditable(true);
	    	
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
			
			JPanel der1 = new JPanel();
			der1.setLayout(new GridLayout(4, 1));
				    	
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
	    	add(iz1 , BorderLayout.SOUTH);
	    	add(mitadBaja , BorderLayout.CENTER);
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
//					if(ex == true)
//					{}
						try
							{
								Mensaje mensaje =  crearMensaje(Tabla.USUARIOS, Funcion.INSERT);
			
								Nodo n = user.enviar(mensaje);
								
								JOptionPane.showMessageDialog(null, "Se insertó correctamente.");
								
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, e.getMessage());
							}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Seleccione alguna puta tabla!");
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
//					JOptionPane.showMessageDialog(null, "Se eliminó correctamente.");
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
//					String aviso = "";
//					
//					while(n != null)
//					{
//						aviso += n.getValor().toString() + "\n";
//						n = n.getSiguiente();
//					}
//					
//					JOptionPane.showMessageDialog(null, "La consulta por ID: "+ "\n" + aviso);
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
		
		
		//public Mensaje crearMensaje(Tabla pTabla , Funcion pFuncion,) throws Exception
		//{
		//	Mensaje mensaje = new Mensaje();
			
			
			
			
	//		return mensaje;
			
//		}

	

