package interfaz;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame1 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	JFrame Frame = new JFrame();
    JTextField txtArea = new JTextField();
    JButton Button1 = new JButton();
    
    private final static String MENSAJE = "MENSAJE";

    public Frame1()
    {
    	super("The title");
    	
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(500, 200));
		setResizable(false);
		setTitle("Informacion");
        
        Frame = new JFrame();
        
        txtArea = new JTextField();
        txtArea.setEditable(true);
        
        Button1 = new JButton();
        Button1.setActionCommand(MENSAJE);
        Button1.addActionListener(this);

        JPanel intento = new JPanel();
        intento.setLayout(new GridLayout(1, 2));
      
        intento.add(txtArea);
        intento.add(Button1);
        
        add(intento);
    }

	public String  getTxtArea() {
		return txtArea.getText();
	}

	public void setTxtArea(JTextField txtArea) {
		this.txtArea = txtArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals(MENSAJE))
		{
			this.dispose();
		}
		
	}
    
    



    
    
}