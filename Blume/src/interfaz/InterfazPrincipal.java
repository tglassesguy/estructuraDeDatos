package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class InterfazPrincipal extends JFrame {
	
	private PanelTitulo panelTitulo;
	private PanelSeleccion panelSeleccion;
	//private PanelMostrar panelMostrar;
	
	private static final long serialVersionUID = 1L;
	
	public InterfazPrincipal()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		setSize(new Dimension(600, 600));
		setResizable(false);
		setTitle("Blume | DataBase Control System");
		
		setLayout(new BorderLayout());
		
		panelTitulo = new PanelTitulo();
		panelSeleccion = new PanelSeleccion(this);
		//panelMostrar =  new PanelMostrar();
		
		add(panelTitulo,BorderLayout.NORTH);
		add(panelSeleccion, BorderLayout.CENTER);
	//	add(panelMostrar, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		InterfazPrincipal ia = new InterfazPrincipal();
		ia.setVisible(true);
	}

}
