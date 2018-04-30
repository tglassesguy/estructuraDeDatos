package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class BarraMenu extends JMenuBar implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
	  /**
     * Constante para los Desarrolladores.
     */
    private static final String DESARROLLADORES = "Desarrolladores";

	
	/**
     * Constante para el Colaborador Javier.
     */
    private static final String JAVIER = "Javier";

    /**
     * Constante para el Colaborador Ffelipe.
     */
    // TODO Parte7 PuntoA. Agregue la constante de Abrir.
    private static final String FELIPE = "Felipe";

    /**
     * Constante para el Colaborador Stiwar.
     */
    // TODO Parte7 PuntoB. Agregue la constante de Guardar.

    private static final String STIWAR = "STIWAR";


    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * La opción Informacion de los Desarrolladores.
     */
    private JMenuItem itemInfo;

    
    
    /**
     * El menú Archivo.
     */
    private JMenu menuArchivo;

    /**
     * La opción Javier del menú Archivo.
     */
    private JMenuItem itemJavier;

    /**
     * La opción Felipe del menú Archivo.
     */
    // TODO Parte7 PuntoE. Agregue el atributo para el item Abrir.
    private JMenuItem itemFelipe;

    /**
     * La opción Stiwar del menú Archivo.
     */
    // TODO Parte7 PuntoF. Agregue el atributo para el item Guardar.

    private JMenuItem itemStiwar;

    private Desarrolladores emergente;
    
    
     private InterfazPrincipal i;
    /**
     * Construye la barra de menú.
     * @param pPrincipal Es una referencia a la clase principal de la interfaz. pPrincipal != null
     */
    public BarraMenu(InterfazPrincipal pi  )
    {
    	i = pi;
    
    	
        // TODO Parte7 PuntoI. Inicialice todos los nuevos items y agreguelos a la barra.
        // Verifique que la interfaz luzca como en el documento de descripción.

        menuArchivo = new JMenu( "Info" );
        add( menuArchivo );

        itemInfo = new JMenuItem("Desarrolladores: ");
        menuArchivo.addSeparator();
        menuArchivo.add( itemInfo );
       
        
        itemJavier = new JMenuItem( "Javier" );
        itemJavier.setActionCommand( JAVIER );
        itemJavier.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_J, ActionEvent.CTRL_MASK ) );
        itemJavier.setMnemonic( KeyEvent.VK_J );
        itemJavier.addActionListener( this );
        menuArchivo.add( itemJavier );
        
        itemFelipe = new JMenuItem( "Felipe" );
        itemFelipe.setActionCommand( FELIPE );
        itemFelipe.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_F, ActionEvent.CTRL_MASK ) );
        itemFelipe.setMnemonic( KeyEvent.VK_F );
        itemFelipe.addActionListener( this );
        menuArchivo.add( itemFelipe );
        
        itemStiwar = new JMenuItem( "Stiwar" );
        itemStiwar.setActionCommand( STIWAR );
        itemStiwar.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK ) );
        itemStiwar.setMnemonic( KeyEvent.VK_S );
        itemStiwar.addActionListener( this );
        menuArchivo.add( itemStiwar );
        
        
}
    public void mostrarEmergente()
	{
	
	emergente = new Desarrolladores();
	emergente.setSize(230,235);
	emergente.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(DESARROLLADORES.equals(comando))
		{
			mostrarEmergente();
			
		}
		if(JAVIER.equals(comando))
		{
			JOptionPane.showMessageDialog(null, "Javier Collazos ");
		}
		if(FELIPE.equals(comando))
		{
			JOptionPane.showMessageDialog(null, "Felipe Garcia ");
		}
		if(STIWAR.equals(comando))
		{
			JOptionPane.showMessageDialog(null, "Stiwar Diaz Riveros ");
		}
		
	}
}
