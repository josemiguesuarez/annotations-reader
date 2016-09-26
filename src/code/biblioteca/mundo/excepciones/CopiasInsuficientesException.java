/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: CopiasInsuficientesException.java,v 1.2 2008/09/03 10:38:04 jua-gome Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n15_biblioteca
 * Autor: Jose Felipe Vargas - 23-Jul-2007
 * Autor: Juan Sebastian Montes - 23-Jul-2007
 * Modificado por: Juan Erasmo G�mez - 20-Ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package code.biblioteca.mundo.excepciones;

import code.annotation.MyAnnotation;
import code.biblioteca.mundo.implementacion1.Libro;

/**
 * Excepci�n lanzada cuando se intenta prestar un libro que no tiene copias disponibles.
 */
@MyAnnotation(myAttribute="Class")
public class CopiasInsuficientesException extends Exception
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = -3638303840577988228L;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor de la excepci�n.
     * @param libro Libro que gener� el error de pr�stamo.
     */
    public CopiasInsuficientesException( Libro libro )
    {
        super( "El libro " + libro.darTitulo( ) + " no tiene copias disponibles" );
    }

}
