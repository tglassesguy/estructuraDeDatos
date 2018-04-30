package interfaz;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class Desarrolladores extends JFrame
{
	private static final long serialVersionUID = 2L;
	
	private JLabel labelTitulo;
		
	public Desarrolladores() 
	{
			labelTitulo = new JLabel(new ImageIcon(getClass().getResource("/Data/Desarrolladores.png")));
			add(labelTitulo, BorderLayout.NORTH);
			}


}
