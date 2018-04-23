package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelMostrar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtMostrar;
	
	public JTextField getTxtMostrar() {
		return txtMostrar;
	}

	public void setTxtMostrar(JTextField txtMostrar) {
		this.txtMostrar = txtMostrar;
	}

	public PanelMostrar() {
		// TODO Auto-generated constructor stub
		
		setBorder(new TitledBorder(BorderFactory.createTitledBorder("Mostrar")));
    	setLayout(new BorderLayout());
    	//setLayout(new GridLayout(7,1));
		
    	txtMostrar = new JTextField();
    	//txtMostrar.setBounds(200,200, 12, 21);
    	add(txtMostrar);
		
	}

	
	



}
