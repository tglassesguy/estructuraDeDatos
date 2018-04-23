package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class InterfazPrincipal extends JFrame {
	
	private PanelTitulo panelTitulo;
	private PanelSeleccion panelSeleccion;
	private PanelMostrar panelMostrar;
	
	private static final long serialVersionUID = 1L;
	
	public InterfazPrincipal()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(600, 600));
		setResizable(false);
		setTitle("Blume");
		
		setLayout(new BorderLayout());
		
		panelTitulo = new PanelTitulo();
		panelSeleccion = new PanelSeleccion(this);
		panelMostrar =  new PanelMostrar();
		
		
		add(panelTitulo,BorderLayout.NORTH);
		add(panelSeleccion, BorderLayout.CENTER);
	//	add(panelMostrar, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		InterfazPrincipal ia = new InterfazPrincipal();
		ia.setVisible(true);
	}

}
