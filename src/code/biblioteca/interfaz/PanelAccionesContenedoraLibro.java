/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAccionesContenedoraLibro.java,v 1.2 2008/09/03 15:21:48 jua-gome Exp $
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
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import code.annotation.MyAnnotation;

/**
 * Panel donde se ponen las acciones con los libros.
 */
@MyAnnotation(myAttribute="Class")
public class PanelAccionesContenedoraLibro extends JPanel
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n.
     */
    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Panel donde se agrega un libro.
     */
    private PanelAccionAgregarLibro panelAccionAgregarLibro;

    /**
     * Layout del panel.
     */
    private CardLayout cartas;

    /**
     * Interfaz principal de la aplicaci�n.
     */
    private InterfazBiblioteca principal;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor por defecto del panel.
     * @param nPrincipal Interfaz principal de la aplicaci�n.
     */
    public PanelAccionesContenedoraLibro( InterfazBiblioteca nPrincipal )
    {
        principal = nPrincipal;
        setSize( 244, 320 );
        setMinimumSize( new Dimension( 244, 320 ) );
        setMaximumSize( new Dimension( 244, 320 ) );
        setPreferredSize( new Dimension( 244, 320 ) );
        cartas = new CardLayout( );
        setLayout( cartas );
        setBackground( new Color( 255, 255, 214 ) );
        panelAccionAgregarLibro = new PanelAccionAgregarLibro( principal );
        panelAccionAgregarLibro.setName( "accionAgregarLibro" );
        add( panelAccionAgregarLibro, panelAccionAgregarLibro.getName( ) );
    }

    /**
     * Permita cambiar la ventana seg�n la acci�n que se va hacer.
     * @param accion Acci�n que se va realizar.
     */
    public void cambiarVentana( String accion )
    {
        if( accion.equals( "BUSCAR" ) )
        {
            PanelAccionBuscarLibro abl = new PanelAccionBuscarLibro( principal );
            add( abl, "Buscar" );
            cartas.show( this, "Buscar" );
        }
        else if( accion.equals( "AGREGAR" ) )
        {
            PanelAccionAgregarLibro abl = new PanelAccionAgregarLibro( principal );
            add( abl, "accionAgregarLibro" );
            cartas.show( this, "accionAgregarLibro" );
        }
        else if( accion.equals( "BLANCO" ) )
        {
            JPanel panel = new JPanel( );
            panel.setOpaque( false );
            add( panel, "blanco" );
            cartas.show( this, "blanco" );
        }
    }
}
