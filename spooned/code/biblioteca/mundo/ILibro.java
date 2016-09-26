

package code.biblioteca.mundo;


@code.annotation.MyAnnotation(myAttribute = "Class")
public interface ILibro extends java.io.Serializable , java.lang.Comparable<code.biblioteca.mundo.ILibro> {
    public void reducirCopiasDisponibles() throws code.biblioteca.mundo.excepciones.CopiasInsuficientesException;

    public void reducirCopiasEnPrestamo();

    public void aumentarCopiasDisponibles();

    public void aumentarCopiasEnPrestamo();

    public java.lang.String darReferencia();

    public java.lang.String darTitulo();

    public java.lang.String darAutores();

    public java.lang.String[] darArregloAutores();

    public java.lang.String darDescriptores();

    public int darCopiasDisponibles();

    public int darCopiasPrestamo();

    public java.lang.String[] darArregloDescriptores();

    public boolean esDescriptor(java.lang.String descriptor);
}

