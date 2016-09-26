

package code.biblioteca.mundo.excepciones;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class SalvarBibliotecaException extends java.lang.Exception {
    private static final long serialVersionUID = -4720386525812340814L;

    public SalvarBibliotecaException(java.lang.String mensaje) {
        super(mensaje);
    }
}

