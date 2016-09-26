/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazBiblioteca.java,v 1.2 2008/09/03 15:52:02 jua-gome Exp $
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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.annotation.MyAnnotation;
import code.biblioteca.mundo.AbstractBiblioteca;
import code.biblioteca.mundo.IFabricaBiblioteca;
import code.biblioteca.mundo.ILibro;
import code.biblioteca.mundo.excepciones.CargarBibliotecaException;
import code.biblioteca.mundo.excepciones.CopiasInsuficientesException;
import code.biblioteca.mundo.excepciones.LibroInexistenteException;
import code.biblioteca.mundo.excepciones.LibroYaExisteException;
import code.biblioteca.mundo.excepciones.UsuarioPreexistenteException;
import code.biblioteca.mundo.implementacion1.FabricaBiblioteca;
import uniandes.cupi2.collections.iterador.Iterador;

/**
 * Interfaz principal de la aplicaci�n.
 */
@MyAnnotation(myAttribute="Class", mandatory ="true")
public class InterfazBiblioteca extends JFrame
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
     * F�brica que construye la clase principal del mundo.
     */
    
    private IFabricaBiblioteca fabrica;

    /**
     * Interfaz de la clase principal del mundo.
     */
    private AbstractBiblioteca biblioteca;

    /**
     * Login del usuario que est� utilizando la aplicaci�n.
     */
    private String loginUsuario;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel principal.
     */
    private JPanel panelPrincipal;

    /**
     * Panel donde est� la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Scroll donde est� la lista de libros.
     */
    private PanelLibros panelLibros;

    /**
     * Panel donde est�n ubicadas las acciones.
     */
    private PanelAccionesContenedora panelAccionesContenedora;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor de interfaz principal de la aplicaci�n.
     */
    public InterfazBiblioteca( )
    {
        try
        {
            fabrica = new FabricaBiblioteca( );
            loginUsuario = "";
            biblioteca = fabrica.darBiblioteca( "./data/bibliotecaLibros.data", "./data/bibliotecaUsuarios.data" );
            biblioteca.cargar( );
        }
        catch( CargarBibliotecaException e )
        {
            JOptionPane.showMessageDialog( this, "Error cargando el archivo: " + e.getMessage( ) + "\nSe reinicir�n los datos del sistema", "Error", JOptionPane.ERROR_MESSAGE );
        }
        setSize( 779, 710 );
        setBackground( new Color( 238, 238, 179 ) );
        setResizable( true );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );

        GridBagConstraints gridBagConstraints12 = new GridBagConstraints( );
        gridBagConstraints12.fill = GridBagConstraints.BOTH;
        gridBagConstraints12.gridy = 1;
        gridBagConstraints12.weightx = 1.0;
        gridBagConstraints12.weighty = 1.0;
        gridBagConstraints12.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints12.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 0;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints( );
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.fill = GridBagConstraints.BOTH;
        gridBagConstraints1.gridwidth = 1;
        gridBagConstraints1.gridy = 1;
        panelPrincipal = new JPanel( );
        panelPrincipal.setLayout( new GridBagLayout( ) );
        panelPrincipal.setMinimumSize( new Dimension( 700, 478 ) );

        // Agregar el panel de la imagen
        panelImagen = new PanelImagen( );
        panelPrincipal.add( panelImagen, gridBagConstraints );

        // Agregar el Scroll de los libros
        panelLibros = new PanelLibros( this );
        panelPrincipal.add( panelLibros, gridBagConstraints12 );

        // Agregar el panel donde est�n las acciones
        panelAccionesContenedora = new PanelAccionesContenedora( this );
        panelPrincipal.add( panelAccionesContenedora, gridBagConstraints1 );
        add( panelPrincipal );

        setTitle( "Biblioteca" );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Registra un nuevo usuario en el sistemas de biblioteca.
     * @param login Login del usuario.
     * @param contrasenia Contrase�a del usuario.
     * @param nombre Nombre del usuario.
     * @throws UsuarioPreexistenteException Si ya existe un usuario con el login ingresado.
     */
    public void registrarUsuario( String login, String contrasenia, String nombre ) throws UsuarioPreexistenteException
    {
        biblioteca.insertarUsuario( login, contrasenia, nombre );
    }

    /**
     * M�todo para la autenticaci�n del usuario.
     * @param login Login del usuario.
     * @param contrasenia Contrase�a de usuario.
     */
    public void autenticar( String login, String contrasenia )
    {
        boolean correcto = biblioteca.autenticar( login, contrasenia );
        if( correcto )
        {
            loginUsuario = login;
            panelLibros.cambiarUsuario( login );
            panelAccionesContenedora.login( login, biblioteca, biblioteca.darTotalLibros( ), biblioteca.darTotalLibrosEnPrestamo( ) );
            JOptionPane.showMessageDialog( this, "Sesi�n iniciada con exito", "Bienvenido " + login, JOptionPane.INFORMATION_MESSAGE );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Nombre de usuario o contrase�a incorrectos", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega una copia de un libro a la biblioteca.<br>
     * <b>post:</b> En caso que exista el libro aumenta en uno el n�mero de copias.
     * @param referencia Referencia del libro.
     * @throws LibroInexistenteException Se lanza esta excepci�n cuando se intenta ingresar la copia de un libro que no existe
     */
    public void insertarCopiaLibro( String referencia ) throws LibroInexistenteException
    {
        biblioteca.agregarCopia( referencia );
    }

    /**
     * Agrega un libro a la biblioteca. <br>
     * <b>post:</b> La biblioteca tiene un nuevo libro con los datos dados.
     * @param titulo Nombre del libro.
     * @param autores Autores del libro.
     * @param descriptores Palabras que describen el libro.
     * @param referencia Referencia del libro.
     */
    public void insertarLibro( String titulo, String autores[], String descriptores[], String referencia )
    {
        try
        {
            biblioteca.insertarLibro( titulo, autores, descriptores, 1, referencia );
            JOptionPane.showMessageDialog( this, "Libro agregado con exito", "Libro agregado", JOptionPane.INFORMATION_MESSAGE );
        }
        catch( LibroYaExisteException e )
        {
            JOptionPane.showMessageDialog( this, "El libro ya exist�a previamente", "Libro agregado", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Termina la sesi�n.
     */
    public void salir( )
    {
        loginUsuario = null;
        panelAccionesContenedora.salir( );
    }

    /**
     * Hace la b�squeda de un libro por palabras del t�tulo.
     * @param datos Datos de la b�squeda.
     */
    public void buscarTituloPorPalabra( String datos[] )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorTitulo( datos );
        panelLibros.actualizarListaBusqueda( libros );

    }

    /**
     * Hace la b�squeda de un libro por el t�tulo exacto del libro.
     * @param titulo T�tulo a buscar.
     */
    public void buscarTituloExacto( String titulo )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorTituloExacto( titulo );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Busca los libros descritos por los autores que tienen las palabras dadas.
     * @param datos Datos de la b�squeda.
     */
    public void buscarAutoresPorPalabra( String datos[] )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorAutores( datos );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Hace la b�squeda de los libros por el nombre exacto del autor del libro.
     * @param datos Datos de la b�squeda.
     */
    public void buscarAutoresExacto( String datos )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorAutoresExacto( datos );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Busca los libros descritos por los descriptores que tienen las palabras dadas.
     * @param datos Datos de la b�squeda.
     */
    public void buscarDescriptoresPorPalabra( String datos[] )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorDescriptores( datos );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Hace la b�squeda de los libros por los descriptores exactos del autor del libro.
     * @param datos Datos de la b�squeda.
     */
    public void buscarDescriptoresExacto( String datos[] )
    {
        Iterador<ILibro> libros = biblioteca.buscarPorDescriptoresExacto( datos );
        panelLibros.actualizarListaBusqueda( libros );
    }

    /**
     * Acci�n que se ejecuta cuando el usuario que est� autenticado alquila un libro.
     * @param libro Libro que va alquilar el usuario.
     * @throws CopiasInsuficientesException Se lanza esta excepci�n cuando no hay copias suficientes.
     */
    public void alquilar( String libro ) throws CopiasInsuficientesException
    {
        biblioteca.alquilarLibro( loginUsuario, libro );
        JOptionPane.showMessageDialog( this, "Petici�n realizada con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Acci�n que se ejecuta cuando el usuario que est� autenticado devuelve un libro alquilado.
     * @param libro Libro alquilado que se va devolver.
     */
    public void devolver( String libro )
    {
        biblioteca.devolverLibro( loginUsuario, libro );
        panelLibros.actualizarListaAlquilados( biblioteca.darAlquilados( loginUsuario ) );
        JOptionPane.showMessageDialog( this, "Petici�n realizada con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Borra un libro que se devolvi� de la lista de libros.
     * @param panelLibroAlquilado Panel donde se muestran los datos del libro alquilado.
     */
    public void borrarDevuelto( PanelLibroAlquilado panelLibroAlquilado )
    {
        panelLibros.remove( panelLibroAlquilado );
    }

    /**
     * Muestra los libros que est� alquilados por el usuario que est� autenticado.
     */
    public void verAlquilados( )
    {
        panelLibros.actualizarListaAlquilados( biblioteca.darAlquilados( loginUsuario ) );
    }

    /**
     * M�todo que se ejecuta cuando se cierra la aplicaci�n.
     */
    public void dispose( )
    {
        try
        {
            biblioteca.salvar( );
            super.dispose( );
        }
        catch( Exception e )
        {
            setVisible( true );
            int respuesta = JOptionPane.showConfirmDialog( this, "Problemas salvando la informaci�n de la biblioteca:\n" + e.getMessage( ) + "\n�Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION );
            if( respuesta == JOptionPane.YES_OPTION )
            {
                super.dispose( );
            }
        }
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Main de la aplicaci�n.
     * @param args Lista de argumentos con las que corre la aplicaci�n.
     */
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater( new Runnable( )
        {
            public void run( )
            {
                InterfazBiblioteca thisClass = new InterfazBiblioteca( );
                thisClass.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
                thisClass.setVisible( true );
            }
        } );
    }

}
