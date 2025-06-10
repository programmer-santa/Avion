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

import javax.swing.*;
import javax.swing.border.*;

import uniandes.cupi2.avion.mundo.*;

/**
 * Panel para el dibujo del avi�n.
 */
@SuppressWarnings("serial")
public class PanelAvion extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Avi�n del modelo del mundo.
     */
    private Avion avion;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Imagen del avi�n.
     */
    private ImageIcon imagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel del avi�n. <br>
     * <b>post: <b> Se dibujan el avi�n y todas las sillas.
     * @param pAvion Avi�n que se va a dibujar. pAvion != null.
     */
    public PanelAvion( Avion pAvion )
    {
        super( new BorderLayout( ) );
        avion = pAvion;
        imagen = new ImageIcon( "data/imagenes/avion.png" );
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );

        // Adiciona las im�genes de las sillas ejecutivas
        JPanel panelEjecutivas = new JPanel( );
        dibujarSillasEjecutivas( panelEjecutivas );
        add( panelEjecutivas, BorderLayout.NORTH );

        // Adiciona las im�genes de las sillas econ�micas
        JPanel panelEconomicas = new JPanel( );
        dibujarSillasEconomicas( panelEconomicas );
        add( panelEconomicas, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Dibuja la gr�fica del avi�n.
     * @param pGrafica Gr�ficos del avi�n. pGrafica != null
     */
    public void paint( Graphics pGrafica )
    {
        pGrafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( pGrafica );
    }

    /**
     * Crea las gr�ficas de las sillas ejecutivas del avi�n. <br>
     * <b>pre: </b> avion != null. <br>
     * <b>post: </b> Se dibujan las sillas ejecutivas del avi�n.
     * @param pPanel Panel donde se pintan las sillas.
     */
    private void dibujarSillasEjecutivas( JPanel pPanel )
    {
        pPanel.setLayout( new GridLayout( Avion.SILLAS_EJECUTIVAS / 4, 5, 8, 5 ) );
        pPanel.setBorder( new EmptyBorder( 90, 210, 20, 210 ) );

        Silla[] ejecutivas = avion.obtenerSillasEjecutivas( );
        Silla silla;

        for( int i = 0; i < ejecutivas.length; i++ )
        {
            silla = ejecutivas[ i ];
            SillaGrafica sillaG = new SillaGrafica( silla );
            pPanel.add( sillaG );
            if( i % 4 == 1 )
            {
                pPanel.add( new JLabel( " " ) );
            }
        }
        pPanel.setOpaque( false );
    }

    /**
     * Crea las gr�ficas de las sillas econ�micas del avi�n. <br>
     * <b>pre: </b> avion != null. <br>
     * <b>post: </b> Se dibujan las sillas econ�micas del avi�n.
     * @param pPanel Panel donde se pintan las sillas.
     */
    private void dibujarSillasEconomicas( JPanel pPanel )
    {
        pPanel.setLayout( new GridLayout( Avion.SILLAS_ECONOMICAS / 6, 7, 5, 4 ) );
        pPanel.setBorder( new EmptyBorder( 0, 200, 100, 200 ) );

        Silla[] economicas = avion.obtenerSillasEconomicas( );
        Silla silla;

        for( int i = 0; i < economicas.length; i++ )
        {
            silla = economicas[ i ];

            SillaGrafica sillaG = new SillaGrafica( silla );
            pPanel.add( sillaG );
            if( i % 6 == 2 )
            {
                pPanel.add( new JLabel( " " ) );
            }
        }
        pPanel.setOpaque( false );
    }
}