package interfaz;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelTitulo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
private JLabel labelTitulo;
	
	public PanelTitulo() {
		labelTitulo = new JLabel(new ImageIcon(getClass().getResource("/Data/Banner Blume.png")));
		setBorder(new TitledBorder(BorderFactory.createTitledBorder("Blume")));
		add(labelTitulo);
		}

}
