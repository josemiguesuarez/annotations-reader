

package code.biblioteca.mundo.implementacion1;


@code.annotation.MyAnnotation(mandatory = "true", myAttribute = "Class")
public class Biblioteca extends code.biblioteca.mundo.AbstractBiblioteca {
    private uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.IUsuario> usuariosSerializacion;

    private uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> librosSerializacion;

    private java.io.File archivoBinarioUsuarios;

    private java.io.File archivoBinarioLibros;

    private uniandes.cupi2.collections.tablaHashing.ITablaHashing<java.lang.String, code.biblioteca.mundo.ILibro> tablaLibroReferencia;

    private uniandes.cupi2.collections.tablaHashing.ITablaHashing<java.lang.String, uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>> tablaLibrosAutor;

    private uniandes.cupi2.collections.tablaHashing.ITablaHashing<java.lang.String, uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>> tablaLibrosTitulo;

    private uniandes.cupi2.collections.arbol.avl.ArbolAVL<code.biblioteca.mundo.implementacion1.NodoIndice> indiceNombre;

    private uniandes.cupi2.collections.arbol.avl.ArbolAVL<code.biblioteca.mundo.implementacion1.NodoIndice> indiceAutor;

    private uniandes.cupi2.collections.arbol.avl.ArbolAVL<code.biblioteca.mundo.implementacion1.NodoIndice> indicePalabraClave;

    private uniandes.cupi2.collections.tablaHashing.ITablaHashing<java.lang.String, code.biblioteca.mundo.implementacion1.Usuario> tablaUsuario;

    private int numeroCopiasPrestamo;

    private int numeroTotalCopias;

    public Biblioteca(java.lang.String rutaArchivoLibros, java.lang.String rutaArchivosUsuarios) {
        archivoBinarioLibros = new java.io.File(rutaArchivoLibros);
        archivoBinarioUsuarios = new java.io.File(rutaArchivosUsuarios);
        usuariosSerializacion = new uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.IUsuario>();
        librosSerializacion = new uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>();
        tablaLibroReferencia = new uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica<java.lang.String, code.biblioteca.mundo.ILibro>();
        tablaLibrosAutor = new uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica<java.lang.String, uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>>();
        tablaLibrosTitulo = new uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica<java.lang.String, uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>>();
        indiceAutor = new uniandes.cupi2.collections.arbol.avl.ArbolAVL<code.biblioteca.mundo.implementacion1.NodoIndice>();
        indiceNombre = new uniandes.cupi2.collections.arbol.avl.ArbolAVL<code.biblioteca.mundo.implementacion1.NodoIndice>();
        indicePalabraClave = new uniandes.cupi2.collections.arbol.avl.ArbolAVL<code.biblioteca.mundo.implementacion1.NodoIndice>();
        tablaUsuario = new uniandes.cupi2.collections.tablaHashing.tablaHashingEstatica.TablaHashingEstatica<java.lang.String, code.biblioteca.mundo.implementacion1.Usuario>();
        numeroTotalCopias = 0;
        numeroCopiasPrestamo = 0;
    }

    public void agregarCopia(java.lang.String referencia) throws code.biblioteca.mundo.excepciones.LibroInexistenteException {
        code.biblioteca.mundo.ILibro libro = tablaLibroReferencia.dar(referencia);
        if (libro == null)
            throw new code.biblioteca.mundo.excepciones.LibroInexistenteException(referencia);
        
        libro.aumentarCopiasDisponibles();
        (numeroTotalCopias)++;
        setChanged();
        int[] arreglo = new int[]{ numeroTotalCopias , numeroCopiasPrestamo };
        notifyObservers(arreglo);
    }

    public code.biblioteca.mundo.ILibro darLibro(java.lang.String referencia) {
        return tablaLibroReferencia.dar(referencia);
    }

    public boolean autenticar(java.lang.String login, java.lang.String clave) {
        code.biblioteca.mundo.implementacion1.Usuario usuario = tablaUsuario.dar(login);
        return (usuario != null) && (usuario.darClave().equals(clave));
    }

    public void insertarUsuario(java.lang.String login, java.lang.String clave, java.lang.String nombre) throws code.biblioteca.mundo.excepciones.UsuarioPreexistenteException {
        code.biblioteca.mundo.implementacion1.Usuario usuario = new code.biblioteca.mundo.implementacion1.Usuario(login, clave, nombre);
        insertarUsuario(usuario);
    }

    public void insertarLibro(java.lang.String titulo, java.lang.String[] autores, java.lang.String[] descriptores, int ejemplares, java.lang.String ref) throws code.biblioteca.mundo.excepciones.LibroYaExisteException {
        code.biblioteca.mundo.implementacion1.Libro libro = new code.biblioteca.mundo.implementacion1.Libro(titulo, autores, descriptores, ejemplares, ref);
        insertarLibro(libro);
    }

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorTituloExacto(java.lang.String titulo) {
        uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> libros = tablaLibrosTitulo.dar(titulo);
        if (libros == null)
            libros = new uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>();
        
        return libros.darIterador();
    }

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorTitulo(java.lang.String[] datos) {
        uniandes.cupi2.collections.conjunto.Conjunto<code.biblioteca.mundo.ILibro> resultados = new uniandes.cupi2.collections.conjunto.Conjunto<code.biblioteca.mundo.ILibro>();
        for (int i = 0; i < (datos.length); i++) {
            code.biblioteca.mundo.implementacion1.NodoIndice nodo = indiceNombre.buscar(new code.biblioteca.mundo.implementacion1.NodoIndice(datos[i]));
            if (nodo != null) {
                uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> iterador = nodo.darLibros();
                while (iterador.haySiguiente())
                    resultados.insertar(iterador.darSiguiente());
            } 
        }
        return resultados.darIterador();
    }

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorAutoresExacto(java.lang.String nombreAutor) {
        uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> libros = tablaLibrosAutor.dar(nombreAutor);
        return libros.darIterador();
    }

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorAutores(java.lang.String[] datos) {
        uniandes.cupi2.collections.conjunto.Conjunto<code.biblioteca.mundo.ILibro> resultados = new uniandes.cupi2.collections.conjunto.Conjunto<code.biblioteca.mundo.ILibro>();
        for (int i = 0; i < (datos.length); i++) {
            code.biblioteca.mundo.implementacion1.NodoIndice nodo = indiceAutor.buscar(new code.biblioteca.mundo.implementacion1.NodoIndice(datos[i]));
            if (nodo != null) {
                uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> iterador = nodo.darLibros();
                while (iterador.haySiguiente())
                    resultados.insertar(iterador.darSiguiente());
            } 
        }
        return resultados.darIterador();
    }

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorDescriptoresExacto(java.lang.String[] datos) {
        uniandes.cupi2.collections.conjunto.Conjunto<code.biblioteca.mundo.ILibro> resultados = new uniandes.cupi2.collections.conjunto.Conjunto<code.biblioteca.mundo.ILibro>();
        if ((datos.length) > 0) {
            uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> iterador = indicePalabraClave.buscar(new code.biblioteca.mundo.implementacion1.NodoIndice(datos[0])).darLibros();
            while (iterador.haySiguiente()) {
                code.biblioteca.mundo.ILibro libro = iterador.darSiguiente();
                boolean todosDescriptores = true;
                for (int i = 0; (i < (datos.length)) && todosDescriptores; i++)
                    if (!(libro.esDescriptor(datos[i])))
                        todosDescriptores = false;
                    
                if (todosDescriptores)
                    resultados.insertar(libro);
                
            }
        } 
        return resultados.darIterador();
    }

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> buscarPorDescriptores(java.lang.String[] datos) {
        uniandes.cupi2.collections.conjunto.Conjunto<code.biblioteca.mundo.ILibro> resultados = new uniandes.cupi2.collections.conjunto.Conjunto<code.biblioteca.mundo.ILibro>();
        for (int i = 0; i < (datos.length); i++) {
            code.biblioteca.mundo.implementacion1.NodoIndice nodoResultante = indicePalabraClave.buscar(new code.biblioteca.mundo.implementacion1.NodoIndice(datos[i]));
            if (nodoResultante != null) {
                uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> iterador = nodoResultante.darLibros();
                while (iterador.haySiguiente())
                    resultados.insertar(iterador.darSiguiente());
            } 
        }
        return resultados.darIterador();
    }

    public void alquilarLibro(java.lang.String elUsuario, java.lang.String referencia) throws code.biblioteca.mundo.excepciones.CopiasInsuficientesException {
        code.biblioteca.mundo.IUsuario usuario = tablaUsuario.dar(elUsuario);
        code.biblioteca.mundo.ILibro libro = tablaLibroReferencia.dar(referencia);
        libro.reducirCopiasDisponibles();
        libro.aumentarCopiasEnPrestamo();
        usuario.alquilar(libro);
        (numeroCopiasPrestamo)++;
        setChanged();
        int[] arreglo = new int[]{ numeroTotalCopias , numeroCopiasPrestamo };
        notifyObservers(arreglo);
    }

    public void devolverLibro(java.lang.String elUsuario, java.lang.String referencia) {
        code.biblioteca.mundo.implementacion1.Usuario usuario = tablaUsuario.dar(elUsuario);
        code.biblioteca.mundo.ILibro libro = tablaLibroReferencia.dar(referencia);
        libro.reducirCopiasEnPrestamo();
        libro.aumentarCopiasDisponibles();
        usuario.devolver(libro);
        (numeroCopiasPrestamo)--;
        setChanged();
        int[] arreglo = new int[]{ numeroTotalCopias , numeroCopiasPrestamo };
        notifyObservers(arreglo);
    }

    public int darTotalLibros() {
        return numeroTotalCopias;
    }

    public int darTotalLibrosEnPrestamo() {
        return numeroCopiasPrestamo;
    }

    public uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> darAlquilados(java.lang.String elUsuario) {
        code.biblioteca.mundo.implementacion1.Usuario usuario = tablaUsuario.dar(elUsuario);
        return usuario.darLibrosAlquilados();
    }

    public void salvar() throws code.biblioteca.mundo.excepciones.SalvarBibliotecaException {
        try {
            java.io.ObjectOutputStream oos2 = new java.io.ObjectOutputStream(new java.io.FileOutputStream(archivoBinarioUsuarios));
            java.io.ObjectOutputStream oos1 = new java.io.ObjectOutputStream(new java.io.FileOutputStream(archivoBinarioLibros));
            oos1.writeObject(librosSerializacion);
            oos2.writeObject(usuariosSerializacion);
            oos1.close();
            oos2.close();
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            throw new code.biblioteca.mundo.excepciones.SalvarBibliotecaException("Error al salvar la biblioteca");
        } catch (java.io.IOException e) {
            e.printStackTrace();
            throw new code.biblioteca.mundo.excepciones.SalvarBibliotecaException("Error al salvar la biblioteca");
        }
    }

    public void cargar() throws code.biblioteca.mundo.excepciones.CargarBibliotecaException {
        try {
            java.io.ObjectInputStream ois2;
            ois2 = new java.io.ObjectInputStream(new java.io.FileInputStream(archivoBinarioLibros));
            uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> librosSerializacion = ((uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>) (ois2.readObject()));
            for (uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> iter = librosSerializacion.darIterador(); iter.haySiguiente();) {
                code.biblioteca.mundo.ILibro libro = iter.darSiguiente();
                insertarLibro(libro.darTitulo(), libro.darArregloAutores(), libro.darArregloDescriptores(), ((libro.darCopiasDisponibles()) + (libro.darCopiasPrestamo())), libro.darReferencia());
            }
            ois2.close();
        } catch (java.io.FileNotFoundException e) {
            throw new code.biblioteca.mundo.excepciones.CargarBibliotecaException("El archivo binario de libros no existe.");
        } catch (java.io.IOException e) {
            throw new code.biblioteca.mundo.excepciones.CargarBibliotecaException("Problemas en la lectura del archivo binario de libros.");
        } catch (java.lang.ClassNotFoundException e) {
            throw new code.biblioteca.mundo.excepciones.CargarBibliotecaException("Problemas en la versi�n del archivo binario de libros.");
        } catch (code.biblioteca.mundo.excepciones.LibroYaExisteException e) {
            throw new code.biblioteca.mundo.excepciones.CargarBibliotecaException(("El archivo de libros es inconsistente: " + (e.getMessage())));
        }
        try {
            java.io.ObjectInputStream ois1;
            ois1 = new java.io.ObjectInputStream(new java.io.FileInputStream(archivoBinarioUsuarios));
            uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.IUsuario> usuariosSerializacion = ((uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.IUsuario>) (ois1.readObject()));
            for (uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.IUsuario> iter = usuariosSerializacion.darIterador(); iter.haySiguiente();) {
                code.biblioteca.mundo.IUsuario usuario = iter.darSiguiente();
                insertarUsuario(usuario.darLogin(), usuario.darClave(), usuario.darNombre());
                uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> librosAlquilados = usuario.darLibrosAlquilados();
                while (librosAlquilados.haySiguiente())
                    alquilarLibro(usuario.darLogin(), librosAlquilados.darSiguiente().darReferencia());
            }
            ois1.close();
        } catch (java.io.FileNotFoundException e) {
            throw new code.biblioteca.mundo.excepciones.CargarBibliotecaException("El archivo binario de usuarios no existe.");
        } catch (java.io.IOException e) {
            throw new code.biblioteca.mundo.excepciones.CargarBibliotecaException("Problemas en la lectura del archivo binario de usuarios.");
        } catch (java.lang.ClassNotFoundException e) {
            throw new code.biblioteca.mundo.excepciones.CargarBibliotecaException("Problemas en la versi�n del archivo binario de usuarios.");
        } catch (code.biblioteca.mundo.excepciones.UsuarioPreexistenteException e) {
            throw new code.biblioteca.mundo.excepciones.CargarBibliotecaException(("El archivo de usuarios es incosistente: " + (e.getMessage())));
        } catch (code.biblioteca.mundo.excepciones.CopiasInsuficientesException e) {
            throw new code.biblioteca.mundo.excepciones.CargarBibliotecaException(("El archivo de usuarios es incosistente: " + (e.getMessage())));
        }
    }

    private void insertarUsuario(code.biblioteca.mundo.implementacion1.Usuario usuario) throws code.biblioteca.mundo.excepciones.UsuarioPreexistenteException {
        if ((tablaUsuario.dar(usuario.darLogin())) != null)
            throw new code.biblioteca.mundo.excepciones.UsuarioPreexistenteException(usuario);
        
        tablaUsuario.agregar(usuario.darLogin(), usuario);
        usuariosSerializacion.agregar(usuario);
    }

    private void insertarLibro(code.biblioteca.mundo.ILibro libro) throws code.biblioteca.mundo.excepciones.LibroYaExisteException {
        if ((tablaLibroReferencia.dar(libro.darReferencia())) != null)
            throw new code.biblioteca.mundo.excepciones.LibroYaExisteException(libro.darReferencia());
        
        tablaLibroReferencia.agregar(libro.darReferencia(), libro);
        java.lang.String[] autores = libro.darArregloAutores();
        for (int i = 0; i < (autores.length); i++) {
            uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> libros = tablaLibrosAutor.dar(autores[i]);
            if (libros == null) {
                libros = new uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>();
                libros.agregar(libro);
                tablaLibrosAutor.agregar(autores[i], libros);
            } else if ((libros.buscar(libro)) == (-1))
                libros.agregar(libro);
            
        }
        java.lang.String titulo = libro.darTitulo();
        uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro> libros = tablaLibrosTitulo.dar(titulo);
        if (libros == null) {
            libros = new uniandes.cupi2.collections.lista.Lista<code.biblioteca.mundo.ILibro>();
            libros.agregar(libro);
            tablaLibrosTitulo.agregar(titulo, libros);
        } else
            libros.agregar(libro);
        
        for (int i = 0; i < (autores.length); i++)
            insertarEnIndice(libro, indiceAutor, autores[i].split(" "));
        insertarEnIndice(libro, indicePalabraClave, libro.darArregloDescriptores());
        insertarEnIndice(libro, indiceNombre, titulo.split(" "));
        numeroTotalCopias += (libro.darCopiasDisponibles()) + (libro.darCopiasPrestamo());
        setChanged();
        int[] arreglo = new int[]{ numeroTotalCopias , numeroCopiasPrestamo };
        notifyObservers(arreglo);
        librosSerializacion.agregar(libro);
    }

    private void insertarEnIndice(code.biblioteca.mundo.ILibro libro, uniandes.cupi2.collections.arbol.avl.ArbolAVL<code.biblioteca.mundo.implementacion1.NodoIndice> indice, java.lang.String[] llaves) {
        try {
            for (int i = 0; i < (llaves.length); i++) {
                code.biblioteca.mundo.implementacion1.NodoIndice nodoTemp = new code.biblioteca.mundo.implementacion1.NodoIndice(llaves[i]);
                code.biblioteca.mundo.implementacion1.NodoIndice nodo = indice.buscar(new code.biblioteca.mundo.implementacion1.NodoIndice(llaves[i]));
                if (nodo == null) {
                    nodoTemp.agregarLibro(libro);
                    indice.insertar(nodoTemp);
                } else
                    nodo.agregarLibro(libro);
                
            }
        } catch (uniandes.cupi2.collections.arbol.ElementoExisteException e) {
        }
    }
}

