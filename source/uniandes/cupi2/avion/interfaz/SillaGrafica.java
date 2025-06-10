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

import uniandes.cupi2.avion.mundo.*;
import uniandes.cupi2.avion.mundo.Silla.Clase;

/**
 * Representaci�n gr�fica de una silla del avi�n.
 */
@SuppressWarnings("serial")
public class SillaGrafica extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Imagen de la silla.
     */
    private ImageIcon imagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la representaci�n gr�fica de la silla. <br>
     * <b>post: </b> La imagen de la silla distingue si est� libre u ocupada.
     * @param pSilla Silla a representar. pSilla != null.
     */
    public SillaGrafica( Silla pSilla )
    {
        super( new BorderLayout( ) );
        JLabel lSilla = new JLabel( );
        if( pSilla.darClase( ) == Clase.EJECUTIVA && pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "data/imagenes/silla-ejec-asig.png" );
        }
        else if( pSilla.darClase( ) == Clase.EJECUTIVA && !pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "data/imagenes/silla-ejec-libre.png" );
        }
        else if( pSilla.darClase( ) == Clase.ECONOMICA && pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "data/imagenes/silla-econ-asig.png" );
        }
        else if( pSilla.darClase( ) == Clase.ECONOMICA && !pSilla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "data/imagenes/silla-econ-libre.png" );
            lSilla.setForeground( Color.white );
        }
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );
        lSilla.setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        lSilla.setText( "" + pSilla.darNumero( ) );
        lSilla.setHorizontalAlignment( SwingConstants.CENTER );
        lSilla.setVerticalAlignment( SwingConstants.CENTER );
        add( lSilla );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Dibuja la imagen de la silla.
     * @param pGrafica Gr�fica de la silla.
     */
    public void paint( Graphics pGrafica )
    {
        pGrafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( pGrafica );
    }
}