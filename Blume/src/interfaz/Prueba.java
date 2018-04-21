package interfaz;

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

public class Prueba extends JFrame implements ActionListener
{
	
	 /**
     * Comando Opción 1
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2
     */
    private static final String OPCION_2 = "OPCION_2";
    
    
    private static final String OPCION_3 = "OPCION_3";

    
    private Facade facade;
    /**
     * Botón Opción 1
     */
   static JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;
    
    
    private JButton btnOpcion3;

    
    private JLabel lblId;
    private JLabel lblUserName;
    private JLabel lblNombre;
    private JLabel lblPais;
   
    
    private JTextField txtID;
	private JTextField txtUserName;
	private JTextField txtNombre;
	private JTextField txtPais;


	
	public Prueba()
	{
		setTitle("Formulario");
		setSize(250, 200);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(6,2));
		
		lblNombre = new JLabel("Nombre");
		lblUserName = new JLabel ("User Name");
		lblId = new JLabel ("ID");
		lblPais = new JLabel ("Pais");
	
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
        btnOpcion2.addActionListener( this );
       
        btnOpcion3 = new JButton( "Consultar" );
        btnOpcion3.setActionCommand( OPCION_3);
        btnOpcion3.addActionListener( this );
        
        
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
    
	}




	@Override
	public void actionPerformed(ActionEvent evento)
	{
		// TODO Auto-generated method stub
		String comando = evento.getActionCommand( );
		Servicio servicio = new Servicio();
		Nodo nodo = new Nodo();
		
		facade = new Facade();
		
		//mensaje.setTabla(Tabla.ARTICULOS);

		int ID = Integer.parseInt(txtID.getText());
		String nombre = txtNombre.getText();
		String userName = txtUserName.getText();
		String pais = txtPais.getText();
		
			if(OPCION_1.equals(comando))
			{
				Mensaje mensaje =  new Mensaje();
				
				mensaje.funcionUsuario(Funcion.INSERT, ID, userName, nombre, pais);
				facade.insertar(servicio.getCon(), mensaje);
				JOptionPane.showMessageDialog(null, "Se inserto");
			}
			if(OPCION_2.equals(comando))
			{
				Mensaje mensaje =  new Mensaje();
				
				mensaje.funcionUsuario(Funcion.DELETE, ID, "", "", "");
				facade.eliminar(servicio.getCon(), mensaje);
				JOptionPane.showMessageDialog(null, "Se Elimino");
			}
			if(OPCION_3.equals(comando))
			{
				Mensaje mensaje =  new Mensaje();
				
				nodo = facade.consultarTodos(servicio.getCon(), mensaje);
				
				while(nodo != null)
				{
					System.out.println(nodo.getValor().toString());
					nodo = nodo.getSiguiente();
				}

			}
		
		
	}
	 public static void main( String[] args )
	    {
	        Prueba interfaz = new Prueba( );
	        interfaz.setVisible(true);
	    }

	

}
