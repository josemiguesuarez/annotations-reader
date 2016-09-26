

package code.biblioteca.mundo.implementacion1;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class NodoIndice implements java.lang.Comparable<code.biblioteca.mundo.implementacion1.NodoIndice> {
    private java.lang.String llave;

    private uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> libros;

    public NodoIndice(java.lang.String nLlave) {
        llave = nLlave;
        libros = new uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>();
    }

    public java.lang.String darLlave() {
        return llave;
    }

    public int compareTo(code.biblioteca.mundo.implementacion1.NodoIndice nodo) {
        java.lang.String llave = ((code.biblioteca.mundo.implementacion1.NodoIndice) (nodo)).darLlave();
        return code.biblioteca.mundo.implementacion1.NodoIndice.this.llave.compareTo(((java.lang.String) (llave)));
    }

    public void agregarLibro(code.biblioteca.mundo.ILibro libro) {
        libros.agregar(libro);
    }

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> darLibros() {
        return libros.darIterador();
    }
}

