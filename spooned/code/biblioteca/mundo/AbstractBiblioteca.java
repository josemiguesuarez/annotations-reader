

package code.biblioteca.mundo;


@code.annotation.MyAnnotation(mandatory = "true", myAttribute = "Class")
public abstract class AbstractBiblioteca extends java.util.Observable {
    public abstract void insertarUsuario(java.lang.String login, java.lang.String clave, java.lang.String nombre) throws code.biblioteca.mundo.excepciones.UsuarioPreexistenteException;

    public abstract void insertarLibro(java.lang.String titulo, java.lang.String[] autores, java.lang.String[] descriptores, int ejemplares, java.lang.String ref) throws code.biblioteca.mundo.excepciones.LibroYaExisteException;

    public abstract uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorTituloExacto(java.lang.String titulo);

    public abstract uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorTitulo(java.lang.String[] datos);

    public abstract uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorAutoresExacto(java.lang.String autor);

    public abstract uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorAutores(java.lang.String[] datos);

    public abstract uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorDescriptoresExacto(java.lang.String[] datos);

    public abstract uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorDescriptores(java.lang.String[] datos);

    public abstract void alquilarLibro(java.lang.String usuario, java.lang.String referencia) throws code.biblioteca.mundo.excepciones.CopiasInsuficientesException;

    public abstract uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> darAlquilados(java.lang.String usuario);

    public abstract void devolverLibro(java.lang.String usuario, java.lang.String referencia);

    public abstract int darTotalLibros();

    public abstract int darTotalLibrosEnPrestamo();

    public abstract boolean autenticar(java.lang.String login, java.lang.String clave);

    public abstract code.biblioteca.mundo.ILibro darLibro(java.lang.String ref);

    public abstract void agregarCopia(java.lang.String referencia) throws code.biblioteca.mundo.excepciones.LibroInexistenteException;

    public abstract void salvar() throws code.biblioteca.mundo.excepciones.SalvarBibliotecaException;

    public abstract void cargar() throws code.biblioteca.mundo.excepciones.CargarBibliotecaException;
}

