

package code.biblioteca.interfaz;


@code.annotation.MyAnnotation(mandatory = "true", myAttribute = "Class")
public class InterfazBiblioteca extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    private code.biblioteca.mundo.IFabricaBiblioteca fabrica;

    private code.biblioteca.mundo.AbstractBiblioteca biblioteca;

    private java.lang.String loginUsuario;

    private javax.swing.JPanel panelPrincipal;

    private code.biblioteca.interfaz.PanelImagen panelImagen;

    private code.biblioteca.interfaz.PanelLibros panelLibros;

    private code.biblioteca.interfaz.PanelAccionesContenedora panelAccionesContenedora;

    public InterfazBiblioteca() {
        try {
            fabrica = new code.biblioteca.mundo.implementacion1.FabricaBiblioteca();
            loginUsuario = "";
            biblioteca = fabrica.darBiblioteca("./data/bibliotecaLibros.data", "./data/bibliotecaUsuarios.data");
            biblioteca.cargar();
        } catch (code.biblioteca.mundo.excepciones.CargarBibliotecaException e) {
            javax.swing.JOptionPane.showMessageDialog(code.biblioteca.interfaz.InterfazBiblioteca.this, (("Error cargando el archivo: " + (e.getMessage())) + "\nSe reinicir\ufffdn los datos del sistema"), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        setSize(779, 710);
        setBackground(new java.awt.Color(238, 238, 179));
        setResizable(true);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        java.awt.GridBagConstraints gridBagConstraints12 = new java.awt.GridBagConstraints();
        gridBagConstraints12.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints12.gridy = 1;
        gridBagConstraints12.weightx = 1.0;
        gridBagConstraints12.weighty = 1.0;
        gridBagConstraints12.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints12.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 0;
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints1.gridwidth = 1;
        gridBagConstraints1.gridy = 1;
        panelPrincipal = new javax.swing.JPanel();
        panelPrincipal.setLayout(new java.awt.GridBagLayout());
        panelPrincipal.setMinimumSize(new java.awt.Dimension(700, 478));
        panelImagen = new code.biblioteca.interfaz.PanelImagen();
        panelPrincipal.add(panelImagen, gridBagConstraints);
        panelLibros = new code.biblioteca.interfaz.PanelLibros(code.biblioteca.interfaz.InterfazBiblioteca.this);
        panelPrincipal.add(panelLibros, gridBagConstraints12);
        panelAccionesContenedora = new code.biblioteca.interfaz.PanelAccionesContenedora(code.biblioteca.interfaz.InterfazBiblioteca.this);
        panelPrincipal.add(panelAccionesContenedora, gridBagConstraints1);
        add(panelPrincipal);
        setTitle("Biblioteca");
    }

    public void registrarUsuario(java.lang.String login, java.lang.String contrasenia, java.lang.String nombre) throws code.biblioteca.mundo.excepciones.UsuarioPreexistenteException {
        biblioteca.insertarUsuario(login, contrasenia, nombre);
    }

    public void autenticar(java.lang.String login, java.lang.String contrasenia) {
        boolean correcto = biblioteca.autenticar(login, contrasenia);
        if (correcto) {
            loginUsuario = login;
            panelLibros.cambiarUsuario(login);
            panelAccionesContenedora.login(login, biblioteca, biblioteca.darTotalLibros(), biblioteca.darTotalLibrosEnPrestamo());
            javax.swing.JOptionPane.showMessageDialog(code.biblioteca.interfaz.InterfazBiblioteca.this, "Sesi�n iniciada con exito", ("Bienvenido " + login), javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            javax.swing.JOptionPane.showMessageDialog(code.biblioteca.interfaz.InterfazBiblioteca.this, "Nombre de usuario o contrase�a incorrectos", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertarCopiaLibro(java.lang.String referencia) throws code.biblioteca.mundo.excepciones.LibroInexistenteException {
        biblioteca.agregarCopia(referencia);
    }

    public void insertarLibro(java.lang.String titulo, java.lang.String[] autores, java.lang.String[] descriptores, java.lang.String referencia) {
        try {
            biblioteca.insertarLibro(titulo, autores, descriptores, 1, referencia);
            javax.swing.JOptionPane.showMessageDialog(code.biblioteca.interfaz.InterfazBiblioteca.this, "Libro agregado con exito", "Libro agregado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (code.biblioteca.mundo.excepciones.LibroYaExisteException e) {
            javax.swing.JOptionPane.showMessageDialog(code.biblioteca.interfaz.InterfazBiblioteca.this, "El libro ya exist�a previamente", "Libro agregado", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void salir() {
        loginUsuario = null;
        panelAccionesContenedora.salir();
    }

    public void buscarTituloPorPalabra(java.lang.String[] datos) {
        uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> libros = biblioteca.buscarPorTitulo(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }

    public void buscarTituloExacto(java.lang.String titulo) {
        uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> libros = biblioteca.buscarPorTituloExacto(titulo);
        panelLibros.actualizarListaBusqueda(libros);
    }

    public void buscarAutoresPorPalabra(java.lang.String[] datos) {
        uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> libros = biblioteca.buscarPorAutores(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }

    public void buscarAutoresExacto(java.lang.String datos) {
        uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> libros = biblioteca.buscarPorAutoresExacto(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }

    public void buscarDescriptoresPorPalabra(java.lang.String[] datos) {
        uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> libros = biblioteca.buscarPorDescriptores(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }

    public void buscarDescriptoresExacto(java.lang.String[] datos) {
        uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> libros = biblioteca.buscarPorDescriptoresExacto(datos);
        panelLibros.actualizarListaBusqueda(libros);
    }

    public void alquilar(java.lang.String libro) throws code.biblioteca.mundo.excepciones.CopiasInsuficientesException {
        biblioteca.alquilarLibro(loginUsuario, libro);
        javax.swing.JOptionPane.showMessageDialog(code.biblioteca.interfaz.InterfazBiblioteca.this, "Petici�n realizada con �xito", "�xito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    public void devolver(java.lang.String libro) {
        biblioteca.devolverLibro(loginUsuario, libro);
        panelLibros.actualizarListaAlquilados(biblioteca.darAlquilados(loginUsuario));
        javax.swing.JOptionPane.showMessageDialog(code.biblioteca.interfaz.InterfazBiblioteca.this, "Petici�n realizada con �xito", "�xito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    public void borrarDevuelto(code.biblioteca.interfaz.PanelLibroAlquilado panelLibroAlquilado) {
        panelLibros.remove(panelLibroAlquilado);
    }

    public void verAlquilados() {
        panelLibros.actualizarListaAlquilados(biblioteca.darAlquilados(loginUsuario));
    }

    public void dispose() {
        try {
            biblioteca.salvar();
            super.dispose();
        } catch (java.lang.Exception e) {
            setVisible(true);
            int respuesta = javax.swing.JOptionPane.showConfirmDialog(code.biblioteca.interfaz.InterfazBiblioteca.this, (("Problemas salvando la informaci\ufffdn de la biblioteca:\n" + (e.getMessage())) + "\n\ufffdQuiere cerrar el programa sin salvar?"), "Error", javax.swing.JOptionPane.YES_NO_OPTION);
            if (respuesta == (javax.swing.JOptionPane.YES_OPTION)) {
                super.dispose();
            } 
        }
    }

    public static void main(java.lang.String[] args) {
        javax.swing.SwingUtilities.invokeLater(new java.lang.Runnable() {
            public void run() {
                code.biblioteca.interfaz.InterfazBiblioteca thisClass = new code.biblioteca.interfaz.InterfazBiblioteca();
                thisClass.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }
}

