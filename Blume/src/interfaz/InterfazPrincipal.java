package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class InterfazPrincipal extends JFrame {
	
	private PanelTitulo panelTitulo;
	private PanelSeleccion panelSeleccion;
	
	private static final long serialVersionUID = 1L;
	
	public InterfazPrincipal()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(750, 1000));
		setResizable(false);
		setTitle("Blume");
		
		setLayout(new BorderLayout());
		
		panelTitulo = new PanelTitulo();
		panelSeleccion = new PanelSeleccion(this);
		
		
		add(panelTitulo,BorderLayout.NORTH);
		add(panelSeleccion, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		InterfazPrincipal ia = new InterfazPrincipal();
		ia.setVisible(true);
	}

}
