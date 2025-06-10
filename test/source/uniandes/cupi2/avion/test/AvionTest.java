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
package uniandes.cupi2.avion.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import uniandes.cupi2.avion.mundo.Avion;
import uniandes.cupi2.avion.mundo.Pasajero;
import uniandes.cupi2.avion.mundo.Silla;
import uniandes.cupi2.avion.mundo.Silla.Clase;
import uniandes.cupi2.avion.mundo.Silla.Ubicacion;

/**
 * Clase de prueba para el Avi�n
 */
public class AvionTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Avi�n
     */
    private Avion avion;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Prepara los datos de prueba para probar el avi�n. <br>
     * <b>post: </b> Se crean dos pasajeros, uno de ellos se asigna a una silla ejecutiva y el otro una silla econ�mica.
     */
    private void setupEscenario1( )
    {
        // Crea el avi�n
        avion = new Avion( );

        // Prepara los nombres y c�dulas
        String nombre1 = "Camilo P�rez";
        String cedula1 = "12345";
        String nombre2 = "Fernando Santander";
        String cedula2 = "23456";

        // Crea los pasajeros
        Pasajero p1 = new Pasajero( cedula1, nombre1 );
        Pasajero p2 = new Pasajero( cedula2, nombre2 );

        // Asigna el primer pasajero en una silla ejecutiva de la ventana
        avion.asignarSilla( Clase.EJECUTIVA, Ubicacion.VENTANA, p1 );

        // Asigna al segundo pasajero en una silla econ�mica del pasillo
        avion.asignarSilla( Clase.ECONOMICA, Ubicacion.PASILLO, p2 );

    }

    /**
     * Verifica que la asignaci�n de una silla ejecutiva haya sido correcta
     */
    @Test
    public void testAsignarSilla1( )
    {
        Silla sillaP1;
        Pasajero p;
        Pasajero p1 = new Pasajero( "12345", "Camilo P�rez" );

        // Configura los datos de prueba
        setupEscenario1( );

        sillaP1 = avion.buscarPasajero( p1 );

        // El pasajero 1 viaja en ejecutivo
        assertEquals( Clase.EJECUTIVA, sillaP1.darClase( ) );

        // El pasajero 1 viaja en ventana
        assertEquals( Ubicacion.VENTANA, sillaP1.darUbicacion( ) );

        // La primera silla ejecutiva en ventana es la n�mero 1
        assertEquals( 1, sillaP1.darNumero( ) );

        // El pasajero debe ser el mismo
        p = sillaP1.darPasajero( );
        assertTrue( p1.igualA( p ) );

    }

    /**
     * Verifica que la asignaci�n de una silla econ�mica haya sido correcta
     */
    @Test
    public void testAsignarSilla( )
    {
        Silla sillaP2;
        Pasajero p;
        Pasajero p2 = new Pasajero( "23456", "Fernando Santander" );

        // Configura los datos de prueba
        setupEscenario1( );

        sillaP2 = avion.buscarPasajero( p2 );

        // El pasajero 2 viaja en econ�mica
        assertEquals( Clase.ECONOMICA, sillaP2.darClase( ) );

        // El pasajero 2 viaja en pasillo
        assertEquals( Ubicacion.PASILLO, sillaP2.darUbicacion( ) );

        // La primera silla econ�mica en pasillo es la n�mero 11
        assertEquals( 11, sillaP2.darNumero( ) );

        // El pasajero debe ser el mismo
        p = sillaP2.darPasajero( );
        assertTrue( p2.igualA( p ) );

    }

    /**
     * Verifica la b�squeda de un pasajero econ�mico que existe
     */
    @Test
    public void testBuscarPasajero1( )
    {
        Pasajero p;
        Silla s;
        Pasajero p2 = new Pasajero( "23456", "Fernando Santander" );

        // Configura los datos de prueba
        setupEscenario1( );

        s = avion.buscarPasajeroEconomico( p2 );
        if( s == null )
            fail( "El pasajero deber�a existir" );
        else
        {
            p = s.darPasajero( );
            assertEquals( "23456", p.darCedula( ) );
            assertEquals( "Fernando Santander", p.darNombre( ) );
        }
    }

    /**
     * Verifica la b�squeda de un pasajero econ�mico que no existe
     */
    @Test
    public void testBuscarPasajero2( )
    {
        Silla s;
        Pasajero p1 = new Pasajero( "Camilo P�rez", "12345" );

        // Configura los datos de prueba
        setupEscenario1( );

        s = avion.buscarPasajeroEconomico( p1 );
        if( s == null )
            assertTrue( true );
        else
        {
            fail( "El pasajero NO deber�a existir" );
        }
    }

    /**
     * Verifica la b�squeda de un pasajero ejecutivo que existe
     */
    @Test
    public void testBuscarPasajero3( )
    {
        Pasajero p;
        Silla s;
        Pasajero p1 = new Pasajero( "12345", "Camilo P�rez" );

        // Configura los datos de prueba
        setupEscenario1( );

        s = avion.buscarPasajeroEjecutivo( p1 );
        if( s == null )
            fail( "El pasajero deber�a existir" );
        else
        {
            p = s.darPasajero( );
            assertEquals( "12345", p.darCedula( ) );
            assertEquals( "Camilo P�rez", p.darNombre( ) );
        }
    }

    /**
     * Verifica la b�squeda de un pasajero ejecutivo que no existe
     */
    @Test
    public void testBuscarPasajero4( )
    {
        Silla s;

        Pasajero p2 = new Pasajero( "Fernando Santander", "23456" );

        // Configura los datos de prueba
        setupEscenario1( );

        s = avion.buscarPasajeroEjecutivo( p2 );
        if( s == null )
            assertTrue( true );
        else
        {
            fail( "El pasajero NO deber�a existir" );
        }
    }

    /**
     * Busca la siguiente silla econ�mica libre
     */
    @Test
    public void testBuscarSillaEconomicaLibre1( )
    {
        Silla s;

        // Configura los datos de prueba
        setupEscenario1( );

        // La siguiente silla econ�mica de pasillo libre es la 12
        s = avion.buscarSillaEconomicaLibre( Ubicacion.PASILLO );
        assertEquals( 12, s.darNumero( ) );

        // La siguiente silla econ�mica de ventana libre es la 9
        s = avion.buscarSillaEconomicaLibre( Ubicacion.VENTANA );
        assertEquals( 9, s.darNumero( ) );

        // La siguiente silla econ�mica de central libre es la 10
        s = avion.buscarSillaEconomicaLibre( Ubicacion.PASILLO );
        assertEquals( 12, s.darNumero( ) );
    }

    /**
     * Busca la siguiente silla ejecutiva libre
     */
    @Test
    public void testBuscarSillaEjecutivaLibre1( )
    {
        Silla s;

        // Configura los datos de prueba
        setupEscenario1( );

        // La siguiente silla ejecutiva de pasillo libre es la 2
        s = avion.buscarSillaEjecutivaLibre( Ubicacion.PASILLO );
        assertEquals( 2, s.darNumero( ) );

        // La siguiente silla ejecutiva de ventana libre es la 4
        s = avion.buscarSillaEjecutivaLibre( Ubicacion.VENTANA );
        assertEquals( 4, s.darNumero( ) );

    }

    /**
     * Prueba el porcentaje de ocupaci�n
     */
    @Test
    public void testCalcularPorcentajeOcupacion1( )
    {
        double porcentajeEsperado, porcentaje;
        Pasajero p3 = new Pasajero( "34567", "Clara Mart�nez" );
        Pasajero p4 = new Pasajero( "56789", "Sonia Osorio" );

        // Configura los datos de prueba
        setupEscenario1( );

        // inicialmente el porcentaje de ocupaci�n es igual a 2*100/50
        porcentajeEsperado = ( 2 * 100 ) / 50;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        assertEquals( porcentajeEsperado, porcentaje, 0 );

        // Asigno otros dos pasajeros
        avion.asignarSilla( Clase.ECONOMICA, Ubicacion.CENTRAL, p3 );
        avion.asignarSilla( Clase.EJECUTIVA, Ubicacion.VENTANA, p4 );

        // Ahora el porcentaje es 4*100/50
        porcentajeEsperado = ( 4 * 100 ) / 50;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        assertEquals( porcentajeEsperado, porcentaje, 0 );
    }

    /**
     * Cuenta las sillas econ�micas ocupadas
     */
    @Test
    public void testContarSillasEconomicasOcupadas1( )
    {

        // Configura los datos de prueba
        setupEscenario1( );
        Pasajero p3 = new Pasajero( "34567", "Clara Mart�nez" );
        Pasajero p4 = new Pasajero( "56789", "Sonia Osorio" );

        // Inicialmente las sillas econ�micas ocupadas son 1
        assertEquals( 1, avion.contarSillasEconomicasOcupadas( ) );

        // Asigno otros dos pasajeros
        avion.asignarSilla( Clase.ECONOMICA, Ubicacion.CENTRAL, p3 );
        avion.asignarSilla( Clase.ECONOMICA, Ubicacion.VENTANA, p4 );

        // Ahora el numero de sillas ocupadas es 3
        assertEquals( 3, avion.contarSillasEconomicasOcupadas( ) );
    }

    /**
     * Cuenta las sillas ejecutivas ocupadas
     */
    @Test
    public void testContarSillasEjecutivasOcupadas1( )
    {

        Silla s;

        // Configura los datos de prueba
        setupEscenario1( );
        Pasajero p3 = new Pasajero( "34567", "Clara Mart�nez" );
        Pasajero p4 = new Pasajero( "56789", "Sonia Osorio" );

        // Inicialmente las sillas econ�micas ocupadas son 1
        assertEquals( 1, avion.contarSillasEjecutivasOcupadas( ) );

        // Asigno otros dos pasajeros
        s = avion.asignarSilla( Clase.EJECUTIVA, Ubicacion.PASILLO, p3 );
        if( s == null )
            fail( "Debi� asignar alguna silla 1" );

        s = avion.asignarSilla( Clase.EJECUTIVA, Ubicacion.VENTANA, p4 );
        if( s == null )
            fail( "Debi� asignar alguna silla 2" );

        // Ahora el numero de sillas ocupadas es 3
        assertEquals( 3, avion.contarSillasEjecutivasOcupadas( ) );
    }

    /**
     * Verifica la desasignaci�n de sillas
     */
    @Test
    public void testDesasignarSilla1( )
    {
        Silla s;
        Pasajero p1 = new Pasajero( "Camilo P�rez", "12345" );

        // Configura los datos de prueba
        setupEscenario1( );

        avion.desasignarSilla( p1 );

        // Ya el pasajero no debe estar en el avi�n
        s = avion.buscarPasajero( p1 );

        if( s == null )
            assertTrue( true );
        else
            fail( "El pasajero no deber�a estar" );
    }

}