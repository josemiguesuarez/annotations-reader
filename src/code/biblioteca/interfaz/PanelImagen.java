/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelImagen.java,v 1.2 2008/09/03 14:46:49 jua-gome Exp $
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

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.annotation.MyAnnotation;

/**
 * Panel donde est� la imagen superior de la aplicaci�n.
 */
@MyAnnotation(myAttribute="Class")
public class PanelImagen extends JPanel
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
     * Label donde est� la imagen.
     */
    private JLabel labelImagen = null;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor por defecto del panel.
     */
    public PanelImagen( )
    {
        super( );
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        labelImagen = new JLabel( );
        labelImagen.setText( "" );
        labelImagen.setPreferredSize( new Dimension( 800, 100 ) );
        labelImagen.setMaximumSize( new Dimension( 800, 100 ) );
        labelImagen.setMinimumSize( new Dimension( 800, 100 ) );
        labelImagen.setIcon( new ImageIcon( "data/imagen.jpg" ) );
        setSize( 640, 100 );
        setLayout( new GridBagLayout( ) );
        add( labelImagen, gridBagConstraints );
    }

}
