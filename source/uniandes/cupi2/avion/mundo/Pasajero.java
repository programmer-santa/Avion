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
 * Pasajero del avi�n.
 */
public class Pasajero
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * C�dula del pasajero.
     */
    private String cedula;

    /**
     * Nombre del pasajero.
     */
    private String nombre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un pasajero con su c�dula y nombre. <br>
     * <b>post: </b> El pasajero tiene sus datos b�sicos c�dula y nombre asignados.
     * @param pCedula C�dula del pasajero. pCedula > 0.
     * @param pNombre Nombre del pasajero. pNombre != null && pNombre != "".
     */
    public Pasajero( String pCedula, String pNombre )
    {
        cedula = pCedula;
        nombre = pNombre;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la c�dula del pasajero.
     * @return La c�dula del pasajero.
     */
    public String darCedula( )
    {
        return cedula;
    }

    /**
     * Retorna el nombre del pasajero.
     * @return El nombre del pasajero.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Indica si el pasajero es igual a otro.
     * @param pOtroPasajero Pasajero a comparar. pOtroPasajero != null.
     * @return Retorna true si es el mismo pasajero, false en caso contrario.
     */
    public boolean igualA( Pasajero pOtroPasajero )
    {
        boolean esIgual = false;
        if( cedula.equals( pOtroPasajero.darCedula( ) ) )
        {
            esIgual = true;
        }

        return esIgual;
    }
}