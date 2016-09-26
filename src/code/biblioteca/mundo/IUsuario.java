/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: IUsuario.java,v 1.1 2008/09/03 11:21:33 jua-gome Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n15_biblioteca
 * Autor: Juan Erasmo G�mez - 20-Ago-2008
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package code.biblioteca.mundo;

import code.annotation.MyAnnotation;
import uniandes.cupi2.collections.iterador.Iterador;
import uniandes.cupi2.collections.lista.Lista;

/**
 * Interface que modela el comportamiento de un usuario.
 */
@MyAnnotation(myAttribute="Class")
public interface IUsuario
{

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Registra un pr�stamo de libro.
     * @param libro El libro a alquilar - libro != null.
     */
    public void alquilar( ILibro libro );

    /**
     * Registra la devoluci�n de un libro que estaba prestado.<br>
     * <b>pre: </b>El usuario tiene prestado el libro ingresado.
     * @param libro El libro a devolver - libro != null.
     */
    public void devolver( ILibro libro );

    /**
     * Retorna el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String darNombre( );

    /**
     * Retorna el login del usuario.
     * @return El login del usuario.
     */
    public String darLogin( );

    /**
     * Retorna la clave del usuario.
     * @return La clave del usuario.
     */
    public String darClave( );

    /**
     * Retorna las libros alquilados por el usuario.
     * @return Los libros alquilados por el usuario.
     */
    public Iterador<ILibro> darLibrosAlquilados( );

    /**
     * Asigna la lista de los libros alquilados.
     * @param nLibrosAlquilados Lista de libros alquilados.
     */
    public void asignarLibrosAlquilados( Lista<ILibro> nLibrosAlquilados );

}
