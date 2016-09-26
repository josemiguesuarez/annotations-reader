/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelAccionAgregarLibro.java,v 1.2 2008/09/03 15:45:26 jua-gome Exp $
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

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import code.annotation.MyAnnotation;
import code.biblioteca.mundo.excepciones.LibroInexistenteException;

/**
 * Panel que permite agregar libros.
 */
@MyAnnotation(myAttribute="Class")
public class PanelAccionAgregarLibro extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serializaci�n.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante para insertar una copia con los datos dados.
     */
    private static final String AGREGAR_COPIA = "Agregar copia";

    /**
     * Ingreso de un nuevo libro.
     */
    private static final String AGREGAR_LIBRO = "Agregar libro";

    /**
     * Constante para el bot�n Cancelar.
     */
    private static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Interfaz principal de la aplicaci�n.
     */
    private InterfazBiblioteca principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Label "Referencia".
     */
    private JLabel labelReferencia;

    /**
     * Cuadro de texto de referencia.
     */
    private JTextField textoReferencia;

    /**
     * Panel contenedor. Donde est�n todos los elementos.
     */
    private JPanel panelContenedor;

    /**
     * Etiqueta "T�tulo"
     */
    private JLabel labelTitulo;

    /**
     * Cuadro de texto donde se ingresa el t�tulo.
     */
    private JTextField textoTitulo;

    /**
     * Etiqueta autores.
     */
    private JLabel labelAutores;

    /**
     * Cuadro de texto donde se ingresa el autor 1.
     */
    private JTextField textoAutor1;

    /**
     * Cuadro de texto donde se ingresa el autor 2.
     */
    private JTextField textoAutor2;

    /**
     * Cuadro de texto donde se ingresa el autor 3.
     */
    private JTextField textoAutor3;

    /**
     * Etiqueta "Descriptores".
     */
    private JLabel labelDescriptores;

    /**
     * Cuadro de texto donde se ingresa el descriptor 1.
     */
    private JTextField textoDescriptores1;

    /**
     * Cuadro de texto donde se ingresa el descriptor 2.
     */
    private JTextField textoDescriptores2;

    /**
     * Cuadro de texto donde se ingresa el descriptor 3.
     */
    private JTextField textoDescriptores3;

    /**
     * Cuadro de texto donde se ingresa el descriptor 4.
     */
    private JTextField textoDescriptores4;

    /**
     * Bot�n para agregar una nueva copia.
     */
    private JButton botonAgregarCopia;

    /**
     * Bot�n para agregar un nuevo libro.
     */
    private JButton botonAgregarLibroNuevo;

    /**
     * Bot�n para cancelar.
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor de panel.
     * @param nPrincipal Interfaz principal de la aplicaci�n.
     */
    public PanelAccionAgregarLibro( InterfazBiblioteca nPrincipal )
    {
        principal = nPrincipal;
        GridBagConstraints gridBagConstraints31 = new GridBagConstraints( );
        gridBagConstraints31.gridx = 1;
        gridBagConstraints31.gridy = 1;
        labelAutores = new JLabel( );
        labelAutores.setText( "Autores:" );
        GridBagConstraints gridBagConstraints11 = new GridBagConstraints( );
        gridBagConstraints11.gridx = 0;
        gridBagConstraints11.fill = GridBagConstraints.BOTH;
        gridBagConstraints11.gridwidth = 2;
        gridBagConstraints11.insets = new Insets( 40, 6, 0, 6 );
        gridBagConstraints11.gridy = 2;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints( );
        gridBagConstraints1.fill = GridBagConstraints.BOTH;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.insets = new Insets( 0, 0, 0, 10 );
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new Insets( 0, 15, 0, 0 );
        gridBagConstraints.gridy = 0;
        // Inicializaci�n de los elementos de la interfaz.
        labelReferencia = new JLabel( );
        labelReferencia.setText( "Referencia:" );
        setSize( 244, 320 );
        setLayout( new GridBagLayout( ) );
        setBorder( BorderFactory.createTitledBorder( null, "Agregar Libro", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font( "Dialog", Font.BOLD, 12 ), new Color( 51, 51, 51 ) ) );
        setOpaque( false );
        // Inserci�n en el panel de los elementos.
        add( labelReferencia, gridBagConstraints );
        textoReferencia = new JTextField( );
        add( textoReferencia, gridBagConstraints1 );
        armarPanelContenedor( );
        add( panelContenedor, gridBagConstraints11 );
        botonAgregarCopia = new JButton( );
        botonAgregarCopia.setText( "Agregar" );
        botonAgregarCopia.addActionListener( this );
        botonAgregarCopia.setActionCommand( AGREGAR_COPIA );
        add( botonAgregarCopia, gridBagConstraints31 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Arma el panel que contiene los elementos.
     */
    private void armarPanelContenedor( )
    {
        GridBagConstraints gridBagConstraints15 = new GridBagConstraints( );
        gridBagConstraints15.gridx = 2;
        gridBagConstraints15.gridy = 8;
        GridBagConstraints gridBagConstraints14 = new GridBagConstraints( );
        gridBagConstraints14.gridx = 1;
        gridBagConstraints14.gridy = 8;
        GridBagConstraints gridBagConstraints13 = new GridBagConstraints( );
        gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;
        GridBagConstraints gridBagConstraints12 = new GridBagConstraints( );
        gridBagConstraints12.fill = GridBagConstraints.BOTH;
        gridBagConstraints12.gridy = 7;
        gridBagConstraints12.weightx = 1.0;
        gridBagConstraints12.gridwidth = 2;
        gridBagConstraints12.gridx = 1;
        GridBagConstraints gridBagConstraints10 = new GridBagConstraints( );
        gridBagConstraints10.fill = GridBagConstraints.BOTH;
        gridBagConstraints10.gridy = 6;
        gridBagConstraints10.weightx = 1.0;
        gridBagConstraints10.gridwidth = 2;
        gridBagConstraints10.gridx = 1;
        GridBagConstraints gridBagConstraints9 = new GridBagConstraints( );
        gridBagConstraints9.fill = GridBagConstraints.BOTH;
        gridBagConstraints9.gridy = 5;
        gridBagConstraints9.weightx = 1.0;
        gridBagConstraints9.gridwidth = 2;
        gridBagConstraints9.gridx = 1;
        GridBagConstraints gridBagConstraints8 = new GridBagConstraints( );
        gridBagConstraints8.fill = GridBagConstraints.BOTH;
        gridBagConstraints8.gridy = 4;
        gridBagConstraints8.weightx = 1.0;
        gridBagConstraints8.gridwidth = 2;
        gridBagConstraints8.gridx = 1;
        GridBagConstraints gridBagConstraints7 = new GridBagConstraints( );
        gridBagConstraints7.gridx = 0;
        gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints7.gridy = 4;
        labelDescriptores = new JLabel( );
        labelDescriptores.setText( "Descriptores" );
        GridBagConstraints gridBagConstraints6 = new GridBagConstraints( );
        gridBagConstraints6.fill = GridBagConstraints.BOTH;
        gridBagConstraints6.gridy = 3;
        gridBagConstraints6.weightx = 1.0;
        gridBagConstraints6.gridwidth = 2;
        gridBagConstraints6.gridx = 1;
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints( );
        gridBagConstraints5.fill = GridBagConstraints.BOTH;
        gridBagConstraints5.gridy = 2;
        gridBagConstraints5.weightx = 1.0;
        gridBagConstraints5.gridwidth = 2;
        gridBagConstraints5.gridx = 1;
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints( );
        gridBagConstraints4.fill = GridBagConstraints.BOTH;
        gridBagConstraints4.gridy = 1;
        gridBagConstraints4.weightx = 1.0;
        gridBagConstraints4.gridwidth = 2;
        gridBagConstraints4.gridx = 1;
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints( );
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints3.gridy = 1;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints( );
        gridBagConstraints2.fill = GridBagConstraints.BOTH;
        gridBagConstraints2.gridy = 0;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.gridwidth = 2;
        gridBagConstraints2.gridx = 1;
        labelTitulo = new JLabel( );
        labelTitulo.setText( "Titulo:" );
        panelContenedor = new JPanel( );
        panelContenedor.setLayout( new GridBagLayout( ) );
        panelContenedor.setOpaque( false );
        panelContenedor.setVisible( false );
        // Inserci�n de los elementos.
        panelContenedor.add( labelTitulo, gridBagConstraints13 );
        textoTitulo = new JTextField( );
        panelContenedor.add( textoTitulo, gridBagConstraints2 );
        panelContenedor.add( labelAutores, gridBagConstraints3 );
        textoAutor1 = new JTextField( );
        panelContenedor.add( textoAutor1, gridBagConstraints4 );
        textoAutor2 = new JTextField( );
        panelContenedor.add( textoAutor2, gridBagConstraints5 );
        textoAutor3 = new JTextField( );
        panelContenedor.add( textoAutor3, gridBagConstraints6 );
        panelContenedor.add( labelDescriptores, gridBagConstraints7 );
        textoDescriptores1 = new JTextField( );
        panelContenedor.add( textoDescriptores1, gridBagConstraints8 );
        textoDescriptores2 = new JTextField( );
        panelContenedor.add( textoDescriptores2, gridBagConstraints9 );
        textoDescriptores3 = new JTextField( );
        panelContenedor.add( textoDescriptores3, gridBagConstraints10 );
        textoDescriptores4 = new JTextField( );
        panelContenedor.add( textoDescriptores4, gridBagConstraints12 );
        botonAgregarLibroNuevo = new JButton( );
        botonAgregarLibroNuevo.setText( "Agregar" );
        botonAgregarLibroNuevo.setFont( new Font( "Dialog", Font.BOLD, 8 ) );
        botonAgregarLibroNuevo.addActionListener( this );
        botonAgregarLibroNuevo.setActionCommand( AGREGAR_LIBRO );
        panelContenedor.add( botonAgregarLibroNuevo, gridBagConstraints14 );
        botonCancelar = new JButton( );
        botonCancelar.setText( "Cancelar" );
        botonCancelar.setFont( new Font( "Dialog", Font.BOLD, 8 ) );
        botonCancelar.addActionListener( this );
        botonCancelar.setActionCommand( CANCELAR );
        panelContenedor.add( botonCancelar, gridBagConstraints15 );
    }

    /**
     * Manejo de eventos sobre los elementos del panel.
     * @param e Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ).equals( AGREGAR_COPIA ) )
        {
            if( textoReferencia.getText( ).equals( "" ) )
                JOptionPane.showMessageDialog( principal, "Ingrese la referencia", "Error", JOptionPane.ERROR_MESSAGE );
            else
            {
                try
                {
                    principal.insertarCopiaLibro( textoReferencia.getText( ) );
                    textoReferencia.setText( "" );
                }
                catch( LibroInexistenteException e1 )
                {
                    int respuesta = JOptionPane.showConfirmDialog( principal, "El libro con la referencia " + textoReferencia.getText( ) + " no existe.\n�Quiere ingresar un libro con esa referencia?", "Error", JOptionPane.YES_NO_OPTION );
                    if( respuesta == JOptionPane.YES_OPTION )
                    {
                        panelContenedor.setVisible( true );
                        botonAgregarCopia.setEnabled( false );
                        textoReferencia.setEditable( false );
                    }
                }
            }
        }
        if( e.getActionCommand( ).equals( AGREGAR_LIBRO ) )
            accionBotonInsertarNuevoLibro( );
        if( e.getActionCommand( ).equals( CANCELAR ) )
        {
            panelContenedor.setVisible( false );
            botonAgregarCopia.setEnabled( true );
            textoReferencia.setEditable( true );
            textoReferencia.setText( "" );
            textoTitulo.setText( "" );
            textoAutor1.setText( "" );
            textoAutor2.setText( "" );
            textoAutor3.setText( "" );
            textoDescriptores1.setText( "" );
            textoDescriptores2.setText( "" );
            textoDescriptores3.setText( "" );
            textoDescriptores4.setText( "" );
        }
    }

    /**
     * Acci�n que se ejecuta cuando se ingresa un nuevo libro o copia.
     */
    private void accionBotonInsertarNuevoLibro( )
    {
        if( textoTitulo.getText( ).equals( "" ) )
        {
            JOptionPane.showMessageDialog( principal, "Ingrese el t�tulo", "Error", JOptionPane.ERROR_MESSAGE );
            return;
        }
        if( textoAutor1.getText( ).equals( "" ) && textoAutor2.getText( ).equals( "" ) && textoAutor3.getText( ).equals( "" ) )
        {
            JOptionPane.showMessageDialog( principal, "Ingrese al menos un autor", "Error", JOptionPane.ERROR_MESSAGE );
            return;
        }
        if( textoDescriptores1.getText( ).equals( "" ) && textoDescriptores2.getText( ).equals( "" ) && textoDescriptores3.getText( ).equals( "" ) && textoDescriptores4.getText( ).equals( "" ) )
        {
            JOptionPane.showMessageDialog( principal, "Ingrese al menos un descriptor", "Error", JOptionPane.ERROR_MESSAGE );
            return;
        }

        int contador = 0;
        if( !textoAutor1.getText( ).equals( "" ) )
            contador++;
        if( !textoAutor2.getText( ).equals( "" ) )
            contador++;
        if( !textoAutor3.getText( ).equals( "" ) )
            contador++;
        String autores[] = new String[contador];
        contador = 0;
        if( !textoAutor1.getText( ).equals( "" ) )
        {
            autores[ contador ] = textoAutor1.getText( );
            contador++;
        }
        if( !textoAutor2.getText( ).equals( "" ) )
        {
            autores[ contador ] = textoAutor2.getText( );
            contador++;
        }
        if( !textoAutor3.getText( ).equals( "" ) )
            autores[ contador ] = textoAutor3.getText( );
        contador = 0;
        if( !textoDescriptores1.getText( ).equals( "" ) )
            contador++;
        if( !textoDescriptores2.getText( ).equals( "" ) )
            contador++;
        if( !textoDescriptores3.getText( ).equals( "" ) )
            contador++;
        if( !textoDescriptores4.getText( ).equals( "" ) )
            contador++;
        String descriptores[] = new String[contador];
        contador = 0;
        if( !textoDescriptores1.getText( ).equals( "" ) )
        {
            descriptores[ contador ] = textoDescriptores1.getText( );
            contador++;
        }
        if( !textoDescriptores2.getText( ).equals( "" ) )
        {
            descriptores[ contador ] = textoDescriptores2.getText( );
            contador++;
        }
        if( !textoDescriptores3.getText( ).equals( "" ) )
        {
            descriptores[ contador ] = textoDescriptores3.getText( );
            contador++;
        }
        if( !textoDescriptores4.getText( ).equals( "" ) )
            descriptores[ contador ] = textoDescriptores4.getText( );
        principal.insertarLibro( textoTitulo.getText( ), autores, descriptores, textoReferencia.getText( ) );
        panelContenedor.setVisible( false );
        botonAgregarCopia.setEnabled( true );
        textoReferencia.setEditable( true );
        textoReferencia.setText( "" );
        textoTitulo.setText( "" );
        textoAutor1.setText( "" );
        textoAutor2.setText( "" );
        textoAutor3.setText( "" );
        textoDescriptores1.setText( "" );
        textoDescriptores2.setText( "" );
        textoDescriptores3.setText( "" );
        textoDescriptores4.setText( "" );
    }

}
