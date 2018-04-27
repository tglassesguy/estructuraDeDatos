package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InterfazPrincipal extends JFrame {
	
	private PanelTitulo panelTitulo;
	private PanelSeleccion panelSeleccion;
	//private PanelMostrar panelMostrar;
	
	private static final long serialVersionUID = 1L;
	
	public InterfazPrincipal()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(600, 600));
		setResizable(false);
		setTitle("Blume | DataBase Control System");
		
		setLayout(new BorderLayout());
		String ip = JOptionPane.showInputDialog("Ingrese la IP del servidor:");
		
		panelTitulo = new PanelTitulo();
		panelSeleccion = new PanelSeleccion(this,ip);
//		panelMostrar =  new PanelMostrar();
		
		add(panelTitulo,BorderLayout.NORTH);
		add(panelSeleccion, BorderLayout.CENTER);
//		add(panelMostrar, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		InterfazPrincipal ia = new InterfazPrincipal();
		ia.setVisible(true);
	}

}
