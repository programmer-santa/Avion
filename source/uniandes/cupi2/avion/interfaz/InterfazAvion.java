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
import java.text.*;

import javax.swing.*;

import uniandes.cupi2.avion.mundo.*;

/**
 * Ventana principal del avi�n.
 */
@SuppressWarnings("serial")
public class InterfazAvion extends JFrame
{

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
     * Panel que contiene el banner de la aplicaci�n.
     */
    private PanelImagen panelImagen;

    /**
     * Panel que contiene el avi�n.
     */
    private PanelAvion panelAvion;

    /**
     * Panel de botones.
     */
    private PanelBotonesAvion panelBotones;

    /**
     * Di�logo de nuevo pasajero.
     */
    private DialogoAsignacion dAsignacion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la interfaz del avi�n. <br>
     * <b>post: </b> Se crea el avi�n y se presenta en una gr�fica su estado inicial.
     */
    public InterfazAvion( )
    {
        setTitle( "El Avi�n" );
        setSize( 580, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Crea al avi�n
        avion = new Avion( );

        // Configura la interfaz
        setLayout( new BorderLayout( ) );

        // Panel del banner
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        // Panel del avi�n
        panelAvion = new PanelAvion( avion );
        add( panelAvion, BorderLayout.CENTER );

        // Panel de botones
        panelBotones = new PanelBotonesAvion( this );
        add( panelBotones, BorderLayout.SOUTH );

        setResizable( false );
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Procesa el registro un pasajero.
     */
    public void registrarPasajero( )
    {
        dAsignacion = new DialogoAsignacion( this, avion );
        dAsignacion.setVisible( true );
        actualizar( );
    }

    /**
     * Procesa la anulaci�n del registro de un pasajero.
     */
    public void eliminarPasajero( )
    {
        // Pregunta el n�mero de c�dula

        String cedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula", "Eliminar pasajero", JOptionPane.QUESTION_MESSAGE );
        if( cedula != null && !cedula.isEmpty( ) )
        {
            Pasajero pasajero = new Pasajero( cedula, "no importa" );
            if( !avion.desasignarSilla( pasajero ) )
            {
                JOptionPane.showMessageDialog( this, "El pasajero no ten�a silla asignada", "Eliminar pasajero", JOptionPane.ERROR_MESSAGE );
            }
            JOptionPane.showMessageDialog( this, "Pasajero eliminado.", "Eliminar pasajero", JOptionPane.INFORMATION_MESSAGE );
        }

        actualizar( );
    }

    /**
     * Muestra el porcentaje de ocupaci�n que tiene el avi�n.
     */
    public void mostrarPorcentajeOcupacion( )
    {
        double porcentaje;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );
        JOptionPane.showMessageDialog( this, "El porcentaje de ocupaci�n es " + df.format( porcentaje ) + "%", "Ocupaci�n del avi�n", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Procesa la b�squeda de un pasajero.
     */
    public void buscarPasajero( )
    {
        // Pregunta el n�mero de c�dula
        String cedula = JOptionPane.showInputDialog( this, "Ingrese el n�mero de c�dula", "Buscar pasajero", JOptionPane.QUESTION_MESSAGE );
        if( cedula != null && !cedula.isEmpty( ) )
        {
            Pasajero pasajero = new Pasajero( cedula, "no importa" );

            Silla silla = avion.buscarPasajero( pasajero );

            if( silla != null )
            {
                DialogoDatosPasajero vDatos = new DialogoDatosPasajero( this, silla );
                vDatos.setVisible( true );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "El pasajero no se encuentra registrado", "Buscar pasajero", JOptionPane.INFORMATION_MESSAGE );
            }

        }
    }

    /**
     * Repinta la gr�fica del avi�n.
     */
    public void actualizar( )
    {
        remove( panelAvion );

        // Panel del avi�n
        panelAvion = new PanelAvion( avion );
        add( panelAvion, BorderLayout.CENTER );
        validate( );
    }

    /**
     * M�todo 1 de extensi�n para el ejemplo.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = avion.metodo1( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo 2 de extensi�n para el ejemplo.
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = avion.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicaci�n.
     * @param pArgs Par�metros de la ejecuci�n. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazAvion interfaz = new InterfazAvion( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}