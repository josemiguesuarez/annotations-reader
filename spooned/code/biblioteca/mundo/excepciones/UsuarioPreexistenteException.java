

package code.biblioteca.mundo.excepciones;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class UsuarioPreexistenteException extends java.lang.Exception {
    private static final long serialVersionUID = 9070209798852432330L;

    public UsuarioPreexistenteException(code.biblioteca.mundo.implementacion1.Usuario usuario) {
        super((("El usuario identificado por el login: " + (usuario.darLogin())) + " ya existe en el sistema"));
    }
}

