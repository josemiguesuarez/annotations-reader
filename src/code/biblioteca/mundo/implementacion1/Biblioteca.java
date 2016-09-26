/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Biblioteca.java,v 1.3 2008/09/03 16:06:13 jua-gome Exp $
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import code.annotation.MyAnnotation;
import code.biblioteca.mundo.AbstractBiblioteca;
import code.biblioteca.mundo.ILibro;
import code.biblioteca.mundo.IUsuario;
import code.biblioteca.mundo.excepciones.CargarBibliotecaException;
import code.biblioteca.mundo.excepciones.CopiasInsuficientesException;
import code.biblioteca.mundo.excepciones.LibroInexistenteException;
import code.biblioteca.mundo.excepciones.LibroYaExisteException;
import code.biblioteca.mundo.excepciones.SalvarBibliotecaException;
import code.biblioteca.mundo.excepciones.UsuarioPreexistenteException;
import uniandes.cupi2.collections.arbol.ElementoExisteException;
import uniandes.cupi2.collections.arbol.avl.ArbolAVL;
import uniandes.cupi2.collections.conjunto.Conjunto;
import uniandes.cupi2.collections.iterador.Iterador;
import uniandes.cupi2.collections.lista.Lista;
import uniandes.cupi2.collections.tablaHashing.ITablaHashing;
import uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica;

/**
 * Clase que representa una biblioteca.
 */
@MyAnnotation(myAttribute="Class", mandatory ="true")
public class Biblioteca extends AbstractBiblioteca
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    // -----------------------------------------------------------------
    // Atributos necesarios para la persistencia
    // -----------------------------------------------------------------

    /**
     * Usuarios registrados en el sistema.
     */
    private Lista<IUsuario> usuariosSerializacion;

    /**
     * Libros registrados en el sistema.
     */
    private Lista<ILibro> librosSerializacion;

    /**
     * Archivo donde se encuentran serializados los usuarios.
     */
    private File archivoBinarioUsuarios;

    /**
     * Archivo donde se encuentran serializados los libros.
     */
    private File archivoBinarioLibros;

    // -----------------------------------------------------------------
    // Atributos necesarios para el acceso directo de los libros
    // -----------------------------------------------------------------

    /**
     * Tabla de hashing con los libros que hay en la Biblioteca ordenados por referencia.
     */
    private ITablaHashing<String, ILibro> tablaLibroReferencia;

    /**
     * Tabla de hashing con los libros que hay en la Biblioteca ordenados por el autor.
     */
    private ITablaHashing<String, Lista<ILibro>> tablaLibrosAutor;

    /**
     * Tabla de hashing con los libros que hay en la Biblioteca ordenados por el t�tulo.
     */
    private ITablaHashing<String, Lista<ILibro>> tablaLibrosTitulo;

    // -----------------------------------------------------------------
    // Atributos necesarios para la indexaci�n
    // -----------------------------------------------------------------

    /**
     * �rbol AVL de libros ordenado por palabras en el t�tulo.
     */
    private ArbolAVL<NodoIndice> indiceNombre;

    /**
     * �rbol AVL de libros ordenado por palabras en el autor.
     */
    private ArbolAVL<NodoIndice> indiceAutor;

    /**
     * �rbol AVL de libros ordenado por por palabras clave.
     */
    private ArbolAVL<NodoIndice> indicePalabraClave;

    // -----------------------------------------------------------------
    // Atributos necesarios para la gesti�n de usuarios
    // -----------------------------------------------------------------

    /**
     * Tabla de hashing con los usuarios que hay en la Biblioteca ordenados por el login.
     */
    private ITablaHashing<String, Usuario> tablaUsuario;

    /**
     * N�mero de total de libros.
     */
    private int numeroCopiasPrestamo;

    /**
     * N�mero de libros en pr�stamo.
     */
    private int numeroTotalCopias;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye una biblioteca vac�a.
     * @param rutaArchivoLibros Ruta donde est�n archivados los libros.
     * @param rutaArchivosUsuarios Ruta donde est�n archivados los usuarios.
     */
    public Biblioteca( String rutaArchivoLibros, String rutaArchivosUsuarios )
    {
        // Serializaci�n
        archivoBinarioLibros = new File( rutaArchivoLibros );
        archivoBinarioUsuarios = new File( rutaArchivosUsuarios );
        usuariosSerializacion = new Lista<IUsuario>( );
        librosSerializacion = new Lista<ILibro>( );

        // Tablas
        tablaLibroReferencia = new TablaHashingEstatica<String, ILibro>( );
        tablaLibrosAutor = new TablaHashingEstatica<String, Lista<ILibro>>( );
        tablaLibrosTitulo = new TablaHashingEstatica<String, Lista<ILibro>>( );

        // Indices
        indiceAutor = new ArbolAVL<NodoIndice>( );
        indiceNombre = new ArbolAVL<NodoIndice>( );
        indicePalabraClave = new ArbolAVL<NodoIndice>( );

        // Usuarios
        tablaUsuario = new TablaHashingEstatica<String, Usuario>( );
        numeroTotalCopias = 0;
        numeroCopiasPrestamo = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#agregarCopia(java.lang.String)
     */
    public void agregarCopia( String referencia ) throws LibroInexistenteException
    {
        ILibro libro = tablaLibroReferencia.dar( referencia );
        if( libro == null )
            throw new LibroInexistenteException( referencia );
        libro.aumentarCopiasDisponibles( );
        numeroTotalCopias++;
        setChanged( );
        int[] arreglo = { numeroTotalCopias, numeroCopiasPrestamo };
        notifyObservers( arreglo );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#darLibro(java.lang.String)
     */
    public ILibro darLibro( String referencia )
    {
        return tablaLibroReferencia.dar( referencia );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#autenticar(java.lang.String, java.lang.String)
     */
    public boolean autenticar( String login, String clave )
    {
        Usuario usuario = tablaUsuario.dar( login );
        return usuario != null && usuario.darClave( ).equals( clave );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#insertarUsuario(java.lang.String, java.lang.String, java.lang.String)
     */
    public void insertarUsuario( String login, String clave, String nombre ) throws UsuarioPreexistenteException
    {
        Usuario usuario = new Usuario( login, clave, nombre );
        insertarUsuario( usuario );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#insertarLibro(java.lang.String, java.lang.String[], java.lang.String[], int, java.lang.String)
     */
    public void insertarLibro( String titulo, String[] autores, String[] descriptores, int ejemplares, String ref ) throws LibroYaExisteException
    {
        Libro libro = new Libro( titulo, autores, descriptores, ejemplares, ref );
        insertarLibro( libro );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorTituloExacto(java.lang.String)
     */
    public Iterador<ILibro> buscarPorTituloExacto( String titulo )
    {
        Lista<ILibro> libros = tablaLibrosTitulo.dar( titulo );
        if( libros == null )
            libros = new Lista<ILibro>( );
        return libros.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorTitulo(java.lang.String[])
     */
    public Iterador<ILibro> buscarPorTitulo( String[] datos )
    {
        Conjunto<ILibro> resultados = new Conjunto<ILibro>( );
        for( int i = 0; i < datos.length; i++ )
        {
            NodoIndice nodo = indiceNombre.buscar( new NodoIndice( datos[ i ] ) );
            if( nodo != null )
            {
                Iterador<ILibro> iterador = nodo.darLibros( );
                while( iterador.haySiguiente( ) )
                    resultados.insertar( iterador.darSiguiente( ) );
            }
        }
        return resultados.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorAutoresExacto(java.lang.String)
     */
    public Iterador<ILibro> buscarPorAutoresExacto( String nombreAutor )
    {
        Lista<ILibro> libros = tablaLibrosAutor.dar( nombreAutor );
        return libros.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorAutores(java.lang.String[])
     */
    public Iterador<ILibro> buscarPorAutores( String[] datos )
    {
        Conjunto<ILibro> resultados = new Conjunto<ILibro>( );
        for( int i = 0; i < datos.length; i++ )
        {
            NodoIndice nodo = indiceAutor.buscar( new NodoIndice( datos[ i ] ) );
            if( nodo != null )
            {
                Iterador<ILibro> iterador = nodo.darLibros( );
                while( iterador.haySiguiente( ) )
                    resultados.insertar( iterador.darSiguiente( ) );
            }
        }
        return resultados.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorDescriptoresExacto(java.lang.String[])
     */
    public Iterador<ILibro> buscarPorDescriptoresExacto( String[] datos )
    {
        Conjunto<ILibro> resultados = new Conjunto<ILibro>( );
        if( datos.length > 0 )
        {
            Iterador<ILibro> iterador = indicePalabraClave.buscar( new NodoIndice( datos[ 0 ] ) ).darLibros( );
            while( iterador.haySiguiente( ) )
            {
                ILibro libro = iterador.darSiguiente( );
                boolean todosDescriptores = true;
                for( int i = 0; i < datos.length && todosDescriptores; i++ )
                    if( !libro.esDescriptor( datos[ i ] ) )
                        todosDescriptores = false;
                if( todosDescriptores )
                    resultados.insertar( libro );
            }
        }
        return resultados.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#buscarPorDescriptores(java.lang.String[])
     */
    public Iterador<ILibro> buscarPorDescriptores( String[] datos )
    {
        Conjunto<ILibro> resultados = new Conjunto<ILibro>( );
        for( int i = 0; i < datos.length; i++ )
        {
            NodoIndice nodoResultante = indicePalabraClave.buscar( new NodoIndice( datos[ i ] ) );
            if( nodoResultante != null )
            {
                Iterador<ILibro> iterador = nodoResultante.darLibros( );
                while( iterador.haySiguiente( ) )
                    resultados.insertar( iterador.darSiguiente( ) );
            }
        }
        return resultados.darIterador( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#alquilarLibro(java.lang.String, java.lang.String)
     */
    public void alquilarLibro( String elUsuario, String referencia ) throws CopiasInsuficientesException
    {
        IUsuario usuario = tablaUsuario.dar( elUsuario );
        ILibro libro = tablaLibroReferencia.dar( referencia );

        libro.reducirCopiasDisponibles( );
        libro.aumentarCopiasEnPrestamo( );
        usuario.alquilar( libro );
        numeroCopiasPrestamo++;
        setChanged( );
        int[] arreglo = { numeroTotalCopias, numeroCopiasPrestamo };
        notifyObservers( arreglo );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#devolverLibro(java.lang.String, java.lang.String)
     */
    public void devolverLibro( String elUsuario, String referencia )
    {
        Usuario usuario = tablaUsuario.dar( elUsuario );
        ILibro libro = tablaLibroReferencia.dar( referencia );
        libro.reducirCopiasEnPrestamo( );
        libro.aumentarCopiasDisponibles( );
        usuario.devolver( libro );
        numeroCopiasPrestamo--;
        setChanged( );
        int[] arreglo = { numeroTotalCopias, numeroCopiasPrestamo };
        notifyObservers( arreglo );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#darTotalLibros()
     */
    public int darTotalLibros( )
    {
        return numeroTotalCopias;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#darTotalLibrosEnPrestamo()
     */
    public int darTotalLibrosEnPrestamo( )
    {
        return numeroCopiasPrestamo;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#darAlquilados(java.lang.String)
     */
    public Iterador<ILibro> darAlquilados( String elUsuario )
    {
        Usuario usuario = tablaUsuario.dar( elUsuario );
        return usuario.darLibrosAlquilados( );
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#salvar()
     */
    public void salvar( ) throws SalvarBibliotecaException
    {
        try
        {
            ObjectOutputStream oos2 = new ObjectOutputStream( new FileOutputStream( archivoBinarioUsuarios ) );
            ObjectOutputStream oos1 = new ObjectOutputStream( new FileOutputStream( archivoBinarioLibros ) );
            oos1.writeObject( librosSerializacion );
            oos2.writeObject( usuariosSerializacion );
            oos1.close( );
            oos2.close( );
        }
        catch( FileNotFoundException e )
        {
            e.printStackTrace( );
            throw new SalvarBibliotecaException( "Error al salvar la biblioteca" );
        }
        catch( IOException e )
        {
            e.printStackTrace( );
            throw new SalvarBibliotecaException( "Error al salvar la biblioteca" );
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see uniandes.cupi2.biblioteca.mundo.AbstractBiblioteca#cargar()
     */
    public void cargar( ) throws CargarBibliotecaException
    {
        // Cargar los libros
        try
        {
            ObjectInputStream ois2;
            ois2 = new ObjectInputStream( new FileInputStream( archivoBinarioLibros ) );
            Lista<ILibro> librosSerializacion = ( Lista<ILibro> )ois2.readObject( );
            // Inserci�n libros serializaci�n.
            for( Iterador<ILibro> iter = librosSerializacion.darIterador( ); iter.haySiguiente( ); )
            {
                ILibro libro = iter.darSiguiente( );
                insertarLibro( libro.darTitulo( ), libro.darArregloAutores( ), libro.darArregloDescriptores( ), libro.darCopiasDisponibles( ) + libro.darCopiasPrestamo( ), libro.darReferencia( ) );
            }
            ois2.close( );
        }
        catch( FileNotFoundException e )
        {
            throw new CargarBibliotecaException( "El archivo binario de libros no existe." );
        }
        catch( IOException e )
        {
            throw new CargarBibliotecaException( "Problemas en la lectura del archivo binario de libros." );
        }
        catch( ClassNotFoundException e )
        {
            throw new CargarBibliotecaException( "Problemas en la versi�n del archivo binario de libros." );
        }
        catch( LibroYaExisteException e )
        {
            throw new CargarBibliotecaException( "El archivo de libros es inconsistente: " + e.getMessage( ) );
        }

        // Cargar los usuarios
        try
        {
            ObjectInputStream ois1;
            ois1 = new ObjectInputStream( new FileInputStream( archivoBinarioUsuarios ) );
            Lista<IUsuario> usuariosSerializacion = ( Lista<IUsuario> )ois1.readObject( );
            // Inserci�n usuarios serializaci�n.
            for( Iterador<IUsuario> iter = usuariosSerializacion.darIterador( ); iter.haySiguiente( ); )
            {
                IUsuario usuario = iter.darSiguiente( );

                // Insertar el usuario
                insertarUsuario( usuario.darLogin( ), usuario.darClave( ), usuario.darNombre( ) );

                // Registrar los prestamos del usuario
                Iterador<ILibro> librosAlquilados = usuario.darLibrosAlquilados( );
                while( librosAlquilados.haySiguiente( ) )
                    alquilarLibro( usuario.darLogin( ), librosAlquilados.darSiguiente( ).darReferencia( ) );
            }
            ois1.close( );
        }
        catch( FileNotFoundException e )
        {
            throw new CargarBibliotecaException( "El archivo binario de usuarios no existe." );
        }
        catch( IOException e )
        {
            throw new CargarBibliotecaException( "Problemas en la lectura del archivo binario de usuarios." );
        }
        catch( ClassNotFoundException e )
        {
            throw new CargarBibliotecaException( "Problemas en la versi�n del archivo binario de usuarios." );
        }
        catch( UsuarioPreexistenteException e )
        {
            throw new CargarBibliotecaException( "El archivo de usuarios es incosistente: " + e.getMessage( ) );
        }
        catch( CopiasInsuficientesException e )
        {
            throw new CargarBibliotecaException( "El archivo de usuarios es incosistente: " + e.getMessage( ) );
        }
    }

    // -----------------------------------------------------------------
    // M�todos auxiliares
    // -----------------------------------------------------------------

    /**
     * Agrega Usuario a la biblioteca.
     * @param usuario Usuario que se va insertar en el sistema de bibliotecas - usuario != null.
     * @throws UsuarioPreexistenteException Si se intenta ingresar un usuario con login repetido.
     */
    private void insertarUsuario( Usuario usuario ) throws UsuarioPreexistenteException
    {
        if( tablaUsuario.dar( usuario.darLogin( ) ) != null )
            throw new UsuarioPreexistenteException( usuario );
        tablaUsuario.agregar( usuario.darLogin( ), usuario );
        usuariosSerializacion.agregar( usuario );
    }

    /**
     * Agrega un libro a la biblioteca.
     * @param libro Libro a insertar en el sistema - libro != null.
     * @throws LibroYaExisteException Si ya existe un libro con la referencia ingresada.
     */
    private void insertarLibro( ILibro libro ) throws LibroYaExisteException
    {
        if( tablaLibroReferencia.dar( libro.darReferencia( ) ) != null )
            throw new LibroYaExisteException( libro.darReferencia( ) );

        // Inserci�n en la tabla de referencias.
        tablaLibroReferencia.agregar( libro.darReferencia( ), libro );

        // Inserci�n en la tabla de autores.
        String[] autores = libro.darArregloAutores( );
        for( int i = 0; i < autores.length; i++ )
        {
            Lista<ILibro> libros = tablaLibrosAutor.dar( autores[ i ] );
            if( libros == null )
            {
                libros = new Lista<ILibro>( );
                libros.agregar( libro );
                tablaLibrosAutor.agregar( autores[ i ], libros );
            }
            else if( libros.buscar( libro ) == -1 )
                libros.agregar( libro );
        }

        // Inserci�n en la tabla de t�tulos.
        String titulo = libro.darTitulo( );
        Lista<ILibro> libros = tablaLibrosTitulo.dar( titulo );
        if( libros == null )
        {
            libros = new Lista<ILibro>( );
            libros.agregar( libro );
            tablaLibrosTitulo.agregar( titulo, libros );
        }
        else
            libros.agregar( libro );

        // Inserci�n en �ndice de autor.
        for( int i = 0; i < autores.length; i++ )
            insertarEnIndice( libro, indiceAutor, autores[ i ].split( " " ) );

        // Inserci�n en �ndice de descriptores
        insertarEnIndice( libro, indicePalabraClave, libro.darArregloDescriptores( ) );

        // Inserci�n en �ndice de t�tulo
        insertarEnIndice( libro, indiceNombre, titulo.split( " " ) );

        numeroTotalCopias += ( libro.darCopiasDisponibles( ) + libro.darCopiasPrestamo( ) );
        setChanged( );
        int[] arreglo = { numeroTotalCopias, numeroCopiasPrestamo };
        notifyObservers( arreglo );
        librosSerializacion.agregar( libro );
    }

    /**
     * Inserta un libro en un �ndice.
     * @param libro Libro que se quiere insertar.
     * @param indice �ndice en donde se quiere insertar el libro.
     * @param llaves Llaves con las que se quiere asociar el libro dentro del indice.
     */
    private void insertarEnIndice( ILibro libro, ArbolAVL<NodoIndice> indice, String[] llaves )
    {
        try
        {
            for( int i = 0; i < llaves.length; i++ )
            {
                NodoIndice nodoTemp = new NodoIndice( llaves[ i ] );
                NodoIndice nodo = indice.buscar( new NodoIndice( llaves[ i ] ) );
                if( nodo == null )
                {
                    nodoTemp.agregarLibro( libro );
                    indice.insertar( nodoTemp );
                }
                else
                    nodo.agregarLibro( libro );
            }
        }
        catch( ElementoExisteException e )
        {
            // Esto no va a suceder
        }
    }

}
