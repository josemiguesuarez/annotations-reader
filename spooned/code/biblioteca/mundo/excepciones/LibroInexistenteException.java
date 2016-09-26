

package code.biblioteca.mundo.excepciones;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class LibroInexistenteException extends java.lang.Exception {
    private static final long serialVersionUID = -3643531559677936939L;

    public LibroInexistenteException(java.lang.String referencia) {
        super(("No existe ning�n libro con la referencia: " + referencia));
    }
}

