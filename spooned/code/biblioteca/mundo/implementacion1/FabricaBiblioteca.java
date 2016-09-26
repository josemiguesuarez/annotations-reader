

package code.biblioteca.mundo.implementacion1;


@code.annotation.MyAnnotation(mandatory = "true", myAttribute = "Class")
public class FabricaBiblioteca implements code.biblioteca.mundo.IFabricaBiblioteca {
    public code.biblioteca.mundo.AbstractBiblioteca darBiblioteca(java.lang.String archivoSerializacionLibros, java.lang.String archivoSerializacionUsuarios) {
        return new code.biblioteca.mundo.implementacion1.Biblioteca(archivoSerializacionLibros, archivoSerializacionUsuarios);
    }
}

