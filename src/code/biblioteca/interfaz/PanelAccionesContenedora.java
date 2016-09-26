/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAccionesContenedora.java,v 1.2 2008/09/03 15:23:41 jua-gome Exp $
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
package code.biblioteca.interfaz;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import code.annotation.MyAnnotation;
import code.biblioteca.mundo.AbstractBiblioteca;

/**
 * Panel de control de la aplicaci�n.
 */
@MyAnnotation(myAttribute="Class")
public class PanelAccionesContenedora extends JPanel
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n.
     */
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Interfaz principal de la aplicaci�n.
     */
    private InterfazBiblioteca principal;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Panel donde se hacen las principales acciones que tienen que ver con el manejo de usuario de la aplicaci�n.
     */
    private PanelAcciones panelAcciones;

    /**
     * Panel donde se hacen las principales acciones que tienen que ver con el manejo de libros de la aplicaci�n.
     */
    private PanelAccionesUsuario panelAccionesUsuario;

    /**
     * Layout del panel.
     */
    private CardLayout cartas;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor por defecto del panel.
     */
    public PanelAccionesContenedora( InterfazBiblioteca laInterfaz )
    {
        principal = laInterfaz;
        setSize( 244, 378 );
        cartas = new CardLayout( );
        setLayout( cartas );
        setPreferredSize( new Dimension( 244, 378 ) );
        setMaximumSize( new Dimension( 244, 378 ) );
        setMinimumSize( new Dimension( 244, 378 ) );
        // Se crea y su agrega al panel el panel de acciones.
        panelAcciones = new PanelAcciones( principal );
        panelAcciones.setName( "panelAcciones" );
        add( panelAcciones, "ACCIONES" );
    }

    /**
     * Acci�n que se hace despu�s de la autenticaci�n. Se cambia el panel de las acciones que manejan usuario por las acciones que manejan libros.
     * @param nombre Nombre del usuario que se autentic�.
     * @param biblioteca Biblioteca.
     * @param total N�mero total de libros.
     * @param prestados N�mero total de libros que est�n en pr�stamo.
     */
    public void login( String nombre, AbstractBiblioteca biblioteca, int total, int prestados )
    {
        panelAccionesUsuario = new PanelAccionesUsuario( principal, nombre, total, prestados, biblioteca );
        this.add( panelAccionesUsuario, "USUARIO" );
        cartas.show( this, "USUARIO" );
    }

    /**
     * Acci�n que se hace despu�s hacer log out. Se cambia el panel de las acciones que manejan libros por las acciones que manejan usuarios.
     */
    public void salir( )
    {
        cartas.show( this, "ACCIONES" );
    }

}
