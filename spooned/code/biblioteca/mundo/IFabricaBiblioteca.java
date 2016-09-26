

package code.biblioteca.mundo;


@code.annotation.MyAnnotation(mandatory = "true", myAttribute = "Class")
public interface IFabricaBiblioteca {
    public abstract code.biblioteca.mundo.AbstractBiblioteca darBiblioteca(java.lang.String archivoSerializacionLibros, java.lang.String archivoSerializacionUsuarios) throws code.biblioteca.mundo.excepciones.CargarBibliotecaException;
}

