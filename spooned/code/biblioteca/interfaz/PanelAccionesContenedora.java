

package code.biblioteca.interfaz;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class PanelAccionesContenedora extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private code.biblioteca.interfaz.InterfazBiblioteca principal;

    private code.biblioteca.interfaz.PanelAcciones panelAcciones;

    private code.biblioteca.interfaz.PanelAccionesUsuario panelAccionesUsuario;

    private java.awt.CardLayout cartas;

    public PanelAccionesContenedora(code.biblioteca.interfaz.InterfazBiblioteca laInterfaz) {
        principal = laInterfaz;
        setSize(244, 378);
        cartas = new java.awt.CardLayout();
        setLayout(cartas);
        setPreferredSize(new java.awt.Dimension(244, 378));
        setMaximumSize(new java.awt.Dimension(244, 378));
        setMinimumSize(new java.awt.Dimension(244, 378));
        panelAcciones = new code.biblioteca.interfaz.PanelAcciones(principal);
        panelAcciones.setName("panelAcciones");
        add(panelAcciones, "ACCIONES");
    }

    public void login(java.lang.String nombre, code.biblioteca.mundo.AbstractBiblioteca biblioteca, int total, int prestados) {
        panelAccionesUsuario = new code.biblioteca.interfaz.PanelAccionesUsuario(principal, nombre, total, prestados, biblioteca);
        code.biblioteca.interfaz.PanelAccionesContenedora.this.add(panelAccionesUsuario, "USUARIO");
        cartas.show(code.biblioteca.interfaz.PanelAccionesContenedora.this, "USUARIO");
    }

    public void salir() {
        cartas.show(code.biblioteca.interfaz.PanelAccionesContenedora.this, "ACCIONES");
    }
}

