/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: IFabricaBiblioteca.java,v 1.4 2008/09/03 10:38:24 jua-gome Exp $
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
package code.biblioteca.mundo;

import code.annotation.MyAnnotation;
import code.biblioteca.mundo.excepciones.CargarBibliotecaException;

/**
 * Interfaz que modela el comportamiento de una f�brica de bibliotecas.
 */
@MyAnnotation(myAttribute="Class", mandatory ="true")
public interface IFabricaBiblioteca
{

    /**
     * Fabrica una biblioteca nueva.
     * @param archivoSerializacionLibros Ruta al archivo donde se encuentran los libros serializados.
     * @param archivoSerializacionUsuarios Ruta al archivo donde se encuentran los usuarios serializados.
     * @return Una biblioteca con la informaci�n presente en los archivos.
     * @throws CargarBibliotecaException Si se presenta alg�n error al cargar la informaci�n de la biblioteca.
     */
    public abstract AbstractBiblioteca darBiblioteca( String archivoSerializacionLibros, String archivoSerializacionUsuarios ) throws CargarBibliotecaException;

}
