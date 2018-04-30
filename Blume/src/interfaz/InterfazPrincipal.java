package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InterfazPrincipal extends JFrame {
	
	private PanelTitulo panelTitulo;
	private PanelSeleccion panelSeleccion;
	private static boolean aviso = false; 
	
	private static final long serialVersionUID = 1L;
	
	public InterfazPrincipal()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(650, 600));
		setResizable(true);
		setTitle("Blume | DataBase Control System");
		setIconImage(new ImageIcon(getClass().getResource("/Data/database.png")).getImage());
		
		setLayout(new BorderLayout());
		String ip = JOptionPane.showInputDialog("Ingrese la IP del servidor:");
		if(ip.trim().equals(null) | ip.trim().equals(""))
		{
			aviso = true;
		}
		
		panelTitulo = new PanelTitulo();
		panelSeleccion = new PanelSeleccion(this,ip);
		
		add(panelTitulo,BorderLayout.NORTH);
		add(panelSeleccion, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		InterfazPrincipal ia = new InterfazPrincipal();
		if(!aviso)
		{
			ia.setVisible(true);
		}
		else
		{
			ia.dispose();
		}
		
	}

}
