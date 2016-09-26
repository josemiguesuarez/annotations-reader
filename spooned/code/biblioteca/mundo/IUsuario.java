

package code.biblioteca.mundo;


@code.annotation.MyAnnotation(myAttribute = "Class")
public interface IUsuario {
    public void alquilar(code.biblioteca.mundo.ILibro libro);

    public void devolver(code.biblioteca.mundo.ILibro libro);

    public java.lang.String darNombre();

    public java.lang.String darLogin();

    public java.lang.String darClave();

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> darLibrosAlquilados();

    public void asignarLibrosAlquilados(uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> nLibrosAlquilados);
}

