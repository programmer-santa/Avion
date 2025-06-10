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
package uniandes.cupi2.avion.mundo;

/**
 * Silla del avi�n.
 */
public class Silla
{
    // -----------------------------------------------------------------
    // Enumeraciones
    // -----------------------------------------------------------------

    /**
     * Enumeradores para las clases a las que pertenece una silla.
     */
    public enum Clase {
        /**
         * Representa la clase ejecutiva.
         */
        EJECUTIVA,

        /**
         * Representa la clase econ�mica.
         */
        ECONOMICA
    }

    /**
     * Enumeradores para las ubicaciones de las sillas.
     */
    public enum Ubicacion {
        /**
         * Representa la ubicaci�n ventana.
         */
        VENTANA,

        /**
         * Representa la ubicaci�n centro.
         */
        CENTRAL,

        /**
         * Representa la ubicaci�n pasillo.
         */
        PASILLO
    }

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * N�mero de la silla.
     */
    private int numero;

    /**
     * Clase de la silla.
     */
    private Clase clase;

    /**
     * Ubicaci�n de la silla.
     */
    private Ubicacion ubicacion;

    /**
     * Pasajero asignado a la silla.
     */
    private Pasajero pasajero;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la silla con su n�mero identificador. <br>
     * <b>post: </b> El objeto silla tiene sus datos b�sicos n�mero, clase y ubicaci�n asignados. El pasajero no est� asignado y tiene valor null.
     * @param pNumero N�mero de silla. pNumero > 0.
     * @param pClase Clase de silla. pClase pertenece {EJECUTIVA,ECONOMICA}.
     * @param pUbicacion Ubicaci�n de la silla. pUbicacion pertenece {VENTANA, CENTRAL, PASILLO}.
     */
    public Silla( int pNumero, Clase pClase, Ubicacion pUbicacion )
    {
        numero = pNumero;
        clase = pClase;
        ubicacion = pUbicacion;
        // Inicialmente no hay ning�n pasajero en la silla
        pasajero = null;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Asigna la silla al pasajero recibido como par�metro. <br>
     * <b>post: </b> La silla queda asignada al pasajero recibido como par�metro.
     * @param pPasajero Pasajero a asignar en la silla. pPasajero !=null.
     */
    public void asignarAPasajero( Pasajero pPasajero )
    {
        pasajero = pPasajero;
    }

    /**
     * Desasigna la silla al pasajero. La silla queda nuevamente libre. <br>
     * <b>post: </b> La silla queda sin pasajero asignado.
     */
    public void desasignarSilla( )
    {
        pasajero = null;
    }

    /**
     * Indica si la silla est� asignada.
     * @return Retorna true si la silla esta asignada, false en caso contrario.
     */
    public boolean sillaAsignada( )
    {
        boolean asignada = true;
        if( null == pasajero )
        {
            asignada = false;
        }
        return asignada;
    }

    /**
     * Indica si la silla est� asignada al pasajero recibido como par�metro.
     * @param pPasajero Pasajero a comparar con el de la silla.
     * @return Retorna true si el pasajero ocupa la silla, false si la silla est� vac�a o no coincide con el pasajero recibido como par�metro.
     */
    public boolean sillaAsignadaPasajero( Pasajero pPasajero )
    {
        boolean asignadaPasajero = false;
        if( null == pasajero )
        {
            asignadaPasajero = false;
        }
        else if( pasajero.igualA( pPasajero ) )
        {
            asignadaPasajero = true;
        }

        return asignadaPasajero;
    }

    /**
     * Retorna el n�mero de la silla.
     * @return N�mero de la silla.
     */
    public int darNumero( )
    {
        return numero;
    }

    /**
     * Retorna la clase de la silla.
     * @return Clase de la silla.
     */
    public Clase darClase( )
    {
        return clase;
    }

    /**
     * Retorna la ubicaci�n de la silla.
     * @return Ubicaci�n de la silla.
     */
    public Ubicacion darUbicacion( )
    {
        return ubicacion;
    }

    /**
     * Retorna el pasajero asignado a la silla.
     * @return Pasajero asignado a la silla. Si no hay pasajero retorna null.
     */
    public Pasajero darPasajero( )
    {
        return pasajero;
    }
}