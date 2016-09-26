

package code.biblioteca.interfaz;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class PanelAccionesContenedoraLibro extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private code.biblioteca.interfaz.PanelAccionAgregarLibro panelAccionAgregarLibro;

    private java.awt.CardLayout cartas;

    private code.biblioteca.interfaz.InterfazBiblioteca principal;

    public PanelAccionesContenedoraLibro(code.biblioteca.interfaz.InterfazBiblioteca nPrincipal) {
        principal = nPrincipal;
        setSize(244, 320);
        setMinimumSize(new java.awt.Dimension(244, 320));
        setMaximumSize(new java.awt.Dimension(244, 320));
        setPreferredSize(new java.awt.Dimension(244, 320));
        cartas = new java.awt.CardLayout();
        setLayout(cartas);
        setBackground(new java.awt.Color(255, 255, 214));
        panelAccionAgregarLibro = new code.biblioteca.interfaz.PanelAccionAgregarLibro(principal);
        panelAccionAgregarLibro.setName("accionAgregarLibro");
        add(panelAccionAgregarLibro, panelAccionAgregarLibro.getName());
    }

    public void cambiarVentana(java.lang.String accion) {
        if (accion.equals("BUSCAR")) {
            code.biblioteca.interfaz.PanelAccionBuscarLibro abl = new code.biblioteca.interfaz.PanelAccionBuscarLibro(principal);
            add(abl, "Buscar");
            cartas.show(code.biblioteca.interfaz.PanelAccionesContenedoraLibro.this, "Buscar");
        } else if (accion.equals("AGREGAR")) {
            code.biblioteca.interfaz.PanelAccionAgregarLibro abl = new code.biblioteca.interfaz.PanelAccionAgregarLibro(principal);
            add(abl, "accionAgregarLibro");
            cartas.show(code.biblioteca.interfaz.PanelAccionesContenedoraLibro.this, "accionAgregarLibro");
        } else if (accion.equals("BLANCO")) {
            javax.swing.JPanel panel = new javax.swing.JPanel();
            panel.setOpaque(false);
            add(panel, "blanco");
            cartas.show(code.biblioteca.interfaz.PanelAccionesContenedoraLibro.this, "blanco");
        } 
    }
}

