/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_avion
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.avion.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import uniandes.cupi2.avion.mundo.*;
import uniandes.cupi2.avion.mundo.Silla.Clase;
import uniandes.cupi2.avion.mundo.Silla.Ubicacion;

/**
 * Formulario para la asignaci�n de sillas.
 */
@SuppressWarnings("serial")
public class DialogoAsignacion extends JDialog implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Opci�n Aceptar.
     */
    public final static String ACEPTAR = "ACEPTAR";

    /**
     * Opci�n Cancelar.
     */
    public final static String CANCELAR = "CANCELAR";

    /**
     * Opci�n para la clase ejecutiva.
     */
    private final static String CLASE_EJECUTIVA = "Clase ejecutiva";

    /**
     * Opci�n para la clase econ�mica.
     */
    private final static String CLASE_ECONOMICA = "Clase econ�mica";

    /**
     * Opci�n para la ubicaci�n en ventana.
     */
    private final static String UBICACION_VENTANA = "Ventana";

    /**
     * Opci�n para la ubicaci�n en pasillo.
     */
    private final static String UBICACION_PASILLO = "Pasillo";

    /**
     * Opci�n para la ubicaci�n en el centro.
     */
    private final static String UBICACION_CENTRO = "Centro";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Avi�n.
     */
    private Avion avion;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Interfaz principal.
     */
    private InterfazAvion principal;

    /**
     * Panel con los botones.
     */
    private JPanel panelBotones;

    /**
     * Panel con los datos.
     */
    private JPanel panelDatos;

    /**
     * Bot�n aceptar.
     */
    private JButton botonAceptar;

    /**
     * Bot�n cancelar.
     */
    private JButton botonCancelar;

    /**
     * Combo de selecci�n de la clase.
     */
    private JComboBox cbClase;

    /**
     * Combo de selecci�n de la ubicaci�n.
     */
    private JComboBox cbUbicacion;

    /**
     * Texto de ingreso de c�dula.
     */
    private JTextField txtCedula;

    /**
     * Texto de ingreso de c�dula.
     */
    private JTextField txtNombre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el formulario de asignaci�n de pasajeros.
     * @param pPrincipal Ventana o frame padre del di�logo. pPrincipal != null.
     * @param pAvion Avi�n sobre el que se har� la asignaci�n. pAvion != null.
     */
    public DialogoAsignacion( InterfazAvion pPrincipal, Avion pAvion )
    {
        // Guarda la referencia a la ventana padre
        principal = pPrincipal;

        // Guarda la referencia al avi�n
        avion = pAvion;

        setTitle( "Registro de pasajero" );
        setSize( 300, 230 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        setLayout( new BorderLayout( ) );

        JPanel panelAux = new JPanel( );
        panelAux.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
        panelAux.setLayout( new BorderLayout( ) );
        add( panelAux, BorderLayout.CENTER );

        // Crea el panel de datos
        inicializarPanelDatos( );
        panelAux.add( panelDatos, BorderLayout.CENTER );

        // Crea el panel de botones
        inicializarPanelBotones( );
        panelAux.add( panelBotones, BorderLayout.SOUTH );

        setModal( true );
        setLocationRelativeTo( principal );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Procesa el registro de un pasajero. Recoge los datos del pasajero y de la clase y ubicaci�n en la que desea su silla y procesa su registro. <br>
     * <b>post: </b> Si el pasajero no est� registrado y hay silla con las caracter�sticas solicitadas se asigna el pasajero a una silla del avi�n. <br>
     * Si el registro no se puede hacer correctamente, muestra un mensaje.
     */
    public void registrar( )
    {
         Clase clase;
        Ubicacion ubicacion;
        String nombre;
        String cedula;
        Pasajero pasajero;

        nombre = txtNombre.getText( );
        cedula = txtCedula.getText( );

        if( cedula == null || cedula.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "La c�dula es requerida", "Registro", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
           
                if( nombre == null || nombre.equals( "" ) )
                {
                    JOptionPane.showMessageDialog( this, "El nombre es requerido", "Registro", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    // Crea al pasajero
                    pasajero = new Pasajero( cedula, nombre );

                    // Verifica que no este ya el pasajero registrado
                    Silla silla = avion.buscarPasajero( pasajero );

                    if( silla != null )
                    {
                        JOptionPane.showMessageDialog( this, "El pasajero ya tiene una silla asignada", "Registro", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        // Registra al pasajero
                        String sClase = ( String )cbClase.getSelectedItem( );
                        if( sClase.equals( CLASE_EJECUTIVA ) )
                        {
                            clase = Clase.EJECUTIVA;
                        }
                        else
                        {
                            clase = Clase.ECONOMICA;
                        }

                        String sUbicacion = ( String )cbUbicacion.getSelectedItem( );
                        if( sUbicacion.equals( UBICACION_VENTANA ) )
                        {
                            ubicacion = Ubicacion.VENTANA;
                        }
                        else if( sUbicacion.equals( UBICACION_PASILLO ) )
                        {
                            ubicacion = Ubicacion.PASILLO;
                        }
                        else
                        {
                            ubicacion = Ubicacion.CENTRAL;
                        }

                        silla = avion.asignarSilla( clase, ubicacion, pasajero );

                        if( silla == null )
                        {
                            JOptionPane.showMessageDialog( this, "No hay sillas disponibles con dichas caracter�sticas", "Registro", JOptionPane.ERROR_MESSAGE );
                        }
                        else
                        {
                            principal.actualizar( );
                            dispose( );
                        }
                    }

                }

            

        }

    }

    /**
     * Inicializa el panel con los datos del pasajero.
     */
    public void inicializarPanelDatos( )
    {
        panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 4, 1, 1, 6 ) );
        panelDatos.setBorder( BorderFactory.createTitledBorder( "Datos del pasajero" ) );

        // C�dula
        JPanel panelCedula = new JPanel( );
        panelCedula.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaCedula = new JLabel( "C�dula " );
        txtCedula = new JTextField( );
        txtCedula.setColumns( 15 );
        panelCedula.add( etiquetaCedula );
        panelCedula.add( txtCedula );
        panelDatos.add( panelCedula );

        // Nombre
        JPanel panelNombre = new JPanel( );
        panelNombre.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaNombre = new JLabel( "Nombre " );
        txtNombre = new JTextField( );
        txtNombre.setColumns( 15 );
        panelNombre.add( etiquetaNombre );
        panelNombre.add( txtNombre );
        panelDatos.add( panelNombre );

        // Ubicaci�n en el avi�n

        JPanel pUbicacion = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        pUbicacion.setPreferredSize( new Dimension( 250, 30 ) );
        JLabel lUbicacion = new JLabel( "Ubicaci�n " );
        cbUbicacion = new JComboBox( );
        cbUbicacion.setAlignmentX( Component.LEFT_ALIGNMENT );
        cbUbicacion.setPreferredSize( txtCedula.getPreferredSize( ) );
        cbUbicacion.addActionListener( this );
        pUbicacion.add( lUbicacion );
        pUbicacion.add( cbUbicacion );

        // Clase de silla
        JPanel pClase = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        pClase.setPreferredSize( new Dimension( 250, 30 ) );
        JLabel lClase = new JLabel( "Clase " );
        cbClase = new JComboBox( );
        cbClase.setAlignmentX( Component.LEFT_ALIGNMENT );
        cbClase.addActionListener( this );
        cbClase.addItem( CLASE_ECONOMICA );
        cbClase.addItem( CLASE_EJECUTIVA );
        cbClase.setPreferredSize( txtCedula.getPreferredSize( ) );
        pClase.add( lClase );
        pClase.add( cbClase );

        panelDatos.add( pClase );
        panelDatos.add( pUbicacion );
    }

    /**
     * Inicializa el panel con los botones.
     */
    public void inicializarPanelBotones( )
    {
        panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 1, 2, 8, 1 ) );

        // Aceptar
        botonAceptar = new JButton( );
        botonAceptar.setText( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );
        panelBotones.add( botonAceptar );

        // Cancelar
        botonCancelar = new JButton( );
        botonCancelar.setText( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        panelBotones.add( botonCancelar );
    }

    /**
     * Acciones de respuesta a los eventos de la interfaz.
     * @param pEvento Evento generado por un elemento de la interfaz.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            registrar( );
        }
        else if( comando.equals( CANCELAR ) )
        {
            principal.actualizar( );
            dispose( );
        }
        else
        {
            if( pEvento.getSource( ) == cbClase )
            {
                String sClase = ( String )cbClase.getSelectedItem( );

                if( sClase.equals( CLASE_ECONOMICA ) )
                {
                    cbUbicacion.removeAllItems( );
                    cbUbicacion.addItem( UBICACION_VENTANA );
                    cbUbicacion.addItem( UBICACION_CENTRO );
                    cbUbicacion.addItem( UBICACION_PASILLO );
                }
                else
                {
                    cbUbicacion.removeAllItems( );
                    cbUbicacion.addItem( UBICACION_VENTANA );
                    cbUbicacion.addItem( UBICACION_PASILLO );
                }
                cbUbicacion.validate( );
            }
        }
    }
}