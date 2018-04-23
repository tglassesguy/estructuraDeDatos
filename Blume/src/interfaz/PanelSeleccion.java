package interfaz;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import mundo.db.Servicio;
import mundo.facade.Facade;
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
	    	    
	    private Facade facade;
	    
	    private JButton btnEjecutar;
	    private JButton btnInsertar;
	    private JButton btnEliminar;
	    private JButton btnConsultar;
	    private JButton btnActualizar;
	    
	    private JButton btnUsuario;
	    private JButton btnTabla;
	    
	    private JTextField txtEjecucion;
	    private JTextField txtRespuesta;
	    
	    public PanelSeleccion(InterfazPrincipal ia)
	    {
	    	interfaz = ia;
	    	setBorder(new TitledBorder(BorderFactory.createTitledBorder("Informacion")));
	    	setLayout(new BorderLayout());
	    	
	    	txtEjecucion = new JTextField();
	    	txtEjecucion.setEditable(true);
	    	
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
	    	
	    	btnUsuario = new JButton(new ImageIcon("Data/if_JD-06_2625478.png"));
	    	btnUsuario.setActionCommand(USUARIO);
	    	btnUsuario.addActionListener(this);
	    	
	    	btnTabla = new JButton(new ImageIcon("Data/if_document_1055071.png"));
	    	btnTabla.setActionCommand(ARCHIVOS);
	    	btnTabla.addActionListener(this);
	    	
	    	JPanel mitadBaja = new JPanel();
	    	mitadBaja.setLayout(new GridLayout(1,2));
	    	
	    	mitadBaja.add(btnUsuario);
	    	mitadBaja.add(btnTabla);
	    	
	    	JPanel top = new JPanel();
	    	top.setLayout(new GridLayout(2, 1));
	    	
	    	top.add(mitadSuperior);
	    	top.add(mitadMedia);
	    	
	    	add(top, BorderLayout.NORTH);
	    	add(mitadBaja , BorderLayout.SOUTH);
	    	
	    		
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}


	
}
