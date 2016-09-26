

package code.biblioteca.mundo.excepciones;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class LibroYaExisteException extends java.lang.Exception {
    private static final long serialVersionUID = 5325954900283301838L;

    public LibroYaExisteException(java.lang.String referencia) {
        super(("Ya existe un libro con esta referencia: " + referencia));
    }
}

