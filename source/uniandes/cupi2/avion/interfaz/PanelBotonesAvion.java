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
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel de botones de interacci�n con el programa del avi�n.
 */
@SuppressWarnings("serial")
public class PanelBotonesAvion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Opci�n registrar.
     */
    public final static String REGISTRAR = "REGISTRAR_PASAJERO";

    /**
     * Opci�n anular.
     */
    public final static String ANULAR = "ANULAR_PASAJERO";

    /**
     * Opci�n buscar.
     */
    public final static String BUSCAR = "BUSCAR_PASAJERO";

    /**
     * Opci�n porcentaje de ocupaci�n.
     */
    public final static String PORCENTAJE = "PORCENTAJE_OCUPACION";

    /**
     * Opci�n extensi�n 1.
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Opci�n extensi�n 2.
     */
    private final static String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n Registro de nuevo pasajero.
     */
    private JButton bRegistro;

    /**
     * Bot�n Anular.
     */
    private JButton bAnular;

    /**
     * Bot�n de b�squeda.
     */
    private JButton bBuscarPasajero;

    /**
     * Bot�n porcentaje de ocupaci�n.
     */
    private JButton bPorcOcupacion;

    /**
     * Bot�n de extensi�n 1.
     */
    private JButton botonOpcion1;

    /**
     * Bot�n de extensi�n 2.
     */
    private JButton botonOpcion2;

    /**
     * Interfaz principal.
     */
    private InterfazAvion ventana;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de botones. <br>
     * <b>post: </b> Se crean y alistan los botones de la interfaz.
     * @param pVentana Ventana o frame padre. pVentana != null.
     */
    public PanelBotonesAvion( InterfazAvion pVentana )
    {
        // Guarda la referencia a la ventana padre
        ventana = pVentana;

        // Configura propiedades visuales
        setLayout( new GridLayout( 2, 3, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        // Bot�n registrar
        bRegistro = new JButton( "Registrar Pasajero" );
        bRegistro.setActionCommand( REGISTRAR );
        bRegistro.addActionListener( this );
        bRegistro.setPreferredSize( new Dimension( 40, 10 ) );
        add( bRegistro );

        // Bot�n anular registro
        bAnular = new JButton( "Eliminar Pasajero" );
        bAnular.setActionCommand( ANULAR );
        bAnular.addActionListener( this );
        add( bAnular );

        // Bot�n buscar pasajero
        bBuscarPasajero = new JButton( "Buscar Pasajero" );
        bBuscarPasajero.setActionCommand( BUSCAR );
        bBuscarPasajero.addActionListener( this );
        add( bBuscarPasajero );

        // Bot�n porcentaje de ocupaci�n
        bPorcOcupacion = new JButton( "Porcentaje Ocupaci�n" );
        bPorcOcupacion.setActionCommand( PORCENTAJE );
        bPorcOcupacion.addActionListener( this );
        add( bPorcOcupacion );

        // Botones de opciones adicionales
        botonOpcion1 = new JButton( "Opci�n 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        add( botonOpcion1 );
        botonOpcion2 = new JButton( "Opci�n 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        add( botonOpcion2 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Acciones de respuesta a los eventos de la interfaz.
     * @param pEvento Evento generado por un elemento de la interfaz.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( REGISTRAR ) )
        {
            ventana.registrarPasajero( );
        }
        else if( comando.equals( ANULAR ) )
        {
            ventana.eliminarPasajero( );
        }
        else if( comando.equals( BUSCAR ) )
        {
            ventana.buscarPasajero( );
        }
        else if( comando.equals( PORCENTAJE ) )
        {
            ventana.mostrarPorcentajeOcupacion( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            ventana.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            ventana.reqFuncOpcion2( );
        }
    }
}