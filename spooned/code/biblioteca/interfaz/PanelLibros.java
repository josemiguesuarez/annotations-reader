

package code.biblioteca.interfaz;


@code.annotation.MyAnnotation(mandatory = "true", myAttribute = "Class")
public class PanelLibros extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private code.biblioteca.interfaz.InterfazBiblioteca principal;

    private java.lang.String loginUsuario;

    private javax.swing.JPanel panelCentral;

    private javax.swing.JLabel labelMostrarResultados;

    private javax.swing.JScrollPane scroll;

    private java.awt.GridLayout layout;

    public PanelLibros(code.biblioteca.interfaz.InterfazBiblioteca nPrincipal) {
        principal = nPrincipal;
        setLayout(new java.awt.BorderLayout());
        panelCentral = new javax.swing.JPanel();
        panelCentral.setAlignmentX(0.0F);
        panelCentral.setBackground(java.awt.Color.white);
        panelCentral.setAlignmentY(0.0F);
        layout = new java.awt.GridLayout();
        panelCentral.setLayout(layout);
        scroll = new javax.swing.JScrollPane();
        scroll.setSize(530, 572);
        scroll.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new java.awt.Dimension(530, 572));
        scroll.setViewportView(panelCentral);
        add(scroll, java.awt.BorderLayout.CENTER);
    }

    public void cambiarUsuario(java.lang.String nLoginUsuario) {
        if ((loginUsuario) == null) {
            loginUsuario = nLoginUsuario;
            return ;
        } 
        loginUsuario = nLoginUsuario;
    }

    public void anhanirLabeles() {
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.insets = new java.awt.Insets(0, 34, 0, 0);
        gridBagConstraints1.gridy = 0;
        labelMostrarResultados = new javax.swing.JLabel();
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelCentral.add(labelMostrarResultados);
    }

    public void actualizarListaBusqueda(uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> libros) {
        panelCentral.removeAll();
        anhanirLabeles();
        int i = 0;
        if (libros != null) {
            while (libros.haySiguiente()) {
                code.biblioteca.mundo.ILibro libro = libros.darSiguiente();
                panelCentral.add(new code.biblioteca.interfaz.PanelLibro(libro, principal));
                i++;
            }
            if (i <= 5)
                layout.setRows(7);
            else {
                layout.setRows((i + 2));
                panelCentral.setSize(511, (i * 146));
            }
            for (int j = i + 2; j < 6; j++) {
                javax.swing.JPanel panel = new javax.swing.JPanel();
                panel.setBackground(java.awt.Color.WHITE);
                panelCentral.add(panel);
            }
            labelMostrarResultados.setText(("Resultados de la b�squeda: " + i));
            panelCentral.repaint();
        } 
    }

    public void actualizarListaAlquilados(uniandes.cupi2.collections.iterador.Iterador<code.biblioteca.mundo.ILibro> libros) {
        panelCentral.removeAll();
        anhanirLabeles();
        int i = 0;
        if (libros != null) {
            while (libros.haySiguiente()) {
                code.biblioteca.mundo.ILibro libro = libros.darSiguiente();
                panelCentral.add(new code.biblioteca.interfaz.PanelLibroAlquilado(libro, principal));
                i++;
            }
            if (i <= 5)
                layout.setRows(7);
            else {
                layout.setRows((i + 2));
                panelCentral.setSize(511, (i * 146));
            }
            for (int j = i + 2; j < 6; j++) {
                javax.swing.JPanel panel = new javax.swing.JPanel();
                panel.setBackground(java.awt.Color.WHITE);
                panelCentral.add(panel);
            }
            labelMostrarResultados.setText(("Resultados de la b�squeda: " + i));
            panelCentral.repaint();
        } 
    }
}

