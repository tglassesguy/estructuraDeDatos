package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mundo.serverTest.Server;

public class InterfazServer extends JFrame
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel ip;
	private JTextField txtip;
	private static Server server;
	private static boolean centry = false;
	
	public InterfazServer() throws UnknownHostException
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(170, 100));
		setResizable(false);
		
		setLayout(new BorderLayout());
		ip = new JLabel("IP");
	  
		txtip = new JTextField();
		txtip.setText(InetAddress.getLocalHost().toString());
	  
		add(ip);
		add(txtip);
		
		centry = true;
	}
	
	public static void main(String[] args) throws UnknownHostException 
	{
		InterfazServer interServer = new InterfazServer();
		interServer.setVisible(true);
		
		if(centry)
		{
			server = new Server();	
		}
		
		
	}
}
