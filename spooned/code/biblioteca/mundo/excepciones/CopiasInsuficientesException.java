

package code.biblioteca.mundo.excepciones;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class CopiasInsuficientesException extends java.lang.Exception {
    private static final long serialVersionUID = -3638303840577988228L;

    public CopiasInsuficientesException(code.biblioteca.mundo.implementacion1.Libro libro) {
        super((("El libro " + (libro.darTitulo())) + " no tiene copias disponibles"));
    }
}

