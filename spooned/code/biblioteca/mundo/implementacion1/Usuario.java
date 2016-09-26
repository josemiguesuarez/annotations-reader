

package code.biblioteca.mundo.implementacion1;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class Usuario implements code.biblioteca.mundo.IUsuario , java.io.Serializable {
    private static final long serialVersionUID = -7920037289310482998L;

    private java.lang.String nombre;

    private java.lang.String clave;

    private java.lang.String login;

    private uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> librosAlquilados;

    public Usuario(java.lang.String login, java.lang.String clave, java.lang.String nombre) {
        code.biblioteca.mundo.implementacion1.Usuario.this.nombre = nombre;
        code.biblioteca.mundo.implementacion1.Usuario.this.clave = clave;
        code.biblioteca.mundo.implementacion1.Usuario.this.login = login;
        librosAlquilados = new uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>();
    }

    public void alquilar(code.biblioteca.mundo.ILibro libro) {
        librosAlquilados.agregar(libro);
    }

    public void devolver(code.biblioteca.mundo.ILibro libro) {
        librosAlquilados.eliminar(libro);
    }

    public java.lang.String darNombre() {
        return nombre;
    }

    public java.lang.String darLogin() {
        return login;
    }

    public java.lang.String darClave() {
        return clave;
    }

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> darLibrosAlquilados() {
        return librosAlquilados.darIterador();
    }

    public void asignarLibrosAlquilados(uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> nLibrosAlquilados) {
        librosAlquilados = nLibrosAlquilados;
    }
}

