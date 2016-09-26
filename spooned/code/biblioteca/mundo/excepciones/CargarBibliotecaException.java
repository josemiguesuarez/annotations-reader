

package code.biblioteca.mundo.excepciones;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class CargarBibliotecaException extends java.lang.Exception {
    private static final long serialVersionUID = 354958047650021157L;

    public CargarBibliotecaException(java.lang.String mensaje) {
        super(mensaje);
    }
}

