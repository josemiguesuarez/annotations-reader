/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: NodoIndice.java,v 1.2 2008/09/03 11:24:32 jua-gome Exp $
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
package code.biblioteca.mundo.implementacion1;

import code.annotation.MyAnnotation;
import code.biblioteca.mundo.ILibro;
import uniandes.cupi2.collections.iterador.Iterador;
import uniandes.cupi2.collections.lista.Lista;

/**
 * Clase usada para indexar los libros.
 */
@MyAnnotation(myAttribute="Class")
public class NodoIndice implements Comparable<NodoIndice>
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Llave del nodo.
     */
    private String llave;

    /**
     * Lista de libros que est�n identificados con la llave del nodo.
     */
    private Lista<ILibro> libros;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del nodo.
     * @param nLlave Llave del nodo.
     */
    public NodoIndice( String nLlave )
    {
        llave = nLlave;
        libros = new Lista<ILibro>( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna la llave del nodo.
     * @return la llave del nodo.
     */
    public String darLlave( )
    {
        return llave;
    }

    /**
     * M�todo donde se comparan las llaves de los nodos.
     * @param nodo Nodo con la llave que se quiere comparar.
     */
    public int compareTo( NodoIndice nodo )
    {
        String llave = ( ( NodoIndice )nodo ).darLlave( );
        return this.llave.compareTo( ( String )llave );
    }

    /**
     * Agrega un libro al nodo.
     * @param libro Libro que se va a agregar al nodo - libro != null.
     */
    public void agregarLibro( ILibro libro )
    {
        libros.agregar( libro );
    }

    /**
     * Retorna los libros del nodo.
     * @return Los libros del nodo.
     */
    public Iterador<ILibro> darLibros( )
    {
        return libros.darIterador( );
    }

}
