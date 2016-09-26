/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: FabricaBiblioteca.java,v 1.1 2008/09/03 10:50:46 jua-gome Exp $
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
import code.biblioteca.mundo.AbstractBiblioteca;
import code.biblioteca.mundo.IFabricaBiblioteca;

/**
 * Fabrica que construye bibliotecas.
 */
@MyAnnotation(myAttribute="Class", mandatory ="true")
public class FabricaBiblioteca implements IFabricaBiblioteca
{

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.IFabricaBiblioteca#darBiblioteca(java.lang.String, java.lang.String)
     */
    public AbstractBiblioteca darBiblioteca( String archivoSerializacionLibros, String archivoSerializacionUsuarios )
    {
        return new Biblioteca( archivoSerializacionLibros, archivoSerializacionUsuarios );
    }

}
