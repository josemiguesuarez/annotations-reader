

package code.biblioteca.mundo.implementacion1;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class Libro implements code.biblioteca.mundo.ILibro {
    private static final long serialVersionUID = -8041695659181839380L;

    private int copiasDisponibles;

    private int copiasEnPrestamo;

    private java.lang.String[] autores;

    private java.lang.String[] descriptores;

    private java.lang.String titulo;

    private java.lang.String referencia;

    public Libro(java.lang.String titulo, java.lang.String[] autores, java.lang.String[] descriptores, int ejemplares, java.lang.String referencia) {
        code.biblioteca.mundo.implementacion1.Libro.this.titulo = titulo;
        code.biblioteca.mundo.implementacion1.Libro.this.autores = autores;
        code.biblioteca.mundo.implementacion1.Libro.this.descriptores = descriptores;
        copiasDisponibles = ejemplares;
        code.biblioteca.mundo.implementacion1.Libro.this.referencia = referencia;
        copiasEnPrestamo = 0;
    }

    public void reducirCopiasDisponibles() throws code.biblioteca.mundo.excepciones.CopiasInsuficientesException {
        if ((copiasDisponibles) == 0)
            throw new code.biblioteca.mundo.excepciones.CopiasInsuficientesException(code.biblioteca.mundo.implementacion1.Libro.this);
        
        (copiasDisponibles)--;
    }

    public void reducirCopiasEnPrestamo() {
        (copiasEnPrestamo)--;
    }

    public void aumentarCopiasDisponibles() {
        (copiasDisponibles)++;
    }

    public void aumentarCopiasEnPrestamo() {
        (copiasEnPrestamo)++;
    }

    public java.lang.String darReferencia() {
        return referencia;
    }

    public java.lang.String darTitulo() {
        return titulo;
    }

    public java.lang.String darAutores() {
        java.lang.String autor = ("\"" + (autores[0])) + "\"";
        for (int i = 1; i < (autores.length); i++)
            autor = (((autor + " ") + "\"") + (autores[i])) + "\"";
        return autor;
    }

    public java.lang.String[] darArregloAutores() {
        return autores;
    }

    public java.lang.String darDescriptores() {
        java.lang.String des = ("\"" + (descriptores[0])) + "\"";
        for (int i = 1; i < (descriptores.length); i++)
            des = (((des + " ") + "\"") + (descriptores[i])) + "\"";
        return des;
    }

    public int darCopiasDisponibles() {
        return copiasDisponibles;
    }

    public int darCopiasPrestamo() {
        return copiasEnPrestamo;
    }

    public int compareTo(code.biblioteca.mundo.ILibro libro) {
        if (referencia.equals(libro.darReferencia()))
            return 0;
        else if ((titulo.compareTo(libro.darTitulo())) == 0)
            return libro.darAutores().compareTo(darAutores());
        else
            return titulo.compareTo(libro.darTitulo());
        
    }

    public java.lang.String[] darArregloDescriptores() {
        return descriptores;
    }

    public boolean esDescriptor(java.lang.String descriptor) {
        boolean esDescritor = false;
        for (int i = 0; i < (descriptores.length); i++)
            esDescritor |= descriptores[i].equals(descriptor);
        return esDescritor;
    }
}

