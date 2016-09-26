

package code.biblioteca.interfaz;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class PanelAccionesUsuario extends javax.swing.JPanel implements java.awt.event.ActionListener , java.util.Observer {
    private static final long serialVersionUID = 1L;

    private static final java.lang.String AGREGAR_LIBRO = "Agregar libro";

    private static final java.lang.String BUSCAR_LIBROS = "Buscar libros";

    private static final java.lang.String VER_LIBROS = "Ver alquilados";

    private static final java.lang.String SALIR = "Terminar sesi�n";

    private code.biblioteca.interfaz.InterfazBiblioteca principal;

    private javax.swing.JComboBox comboAcciones;

    private javax.swing.JLabel labelAcciones;

    private code.biblioteca.interfaz.PanelAccionesContenedoraLibro accionesContenedora;

    private javax.swing.JLabel labelTotal;

    private javax.swing.JLabel labelLibrosTotal;

    private javax.swing.JLabel labelPrestados;

    private javax.swing.JLabel labelLibrosPrestados = null;

    public PanelAccionesUsuario(code.biblioteca.interfaz.InterfazBiblioteca nPrincipal, java.lang.String nombre, int total, int prestados, code.biblioteca.mundo.AbstractBiblioteca bibliteca) {
        principal = nPrincipal;
        bibliteca.addObserver(code.biblioteca.interfaz.PanelAccionesUsuario.this);
        java.awt.GridBagConstraints gridBagConstraints9 = new java.awt.GridBagConstraints();
        gridBagConstraints9.gridx = 1;
        gridBagConstraints9.gridy = 4;
        labelLibrosPrestados = new javax.swing.JLabel();
        labelLibrosPrestados.setText("");
        java.awt.GridBagConstraints gridBagConstraints8 = new java.awt.GridBagConstraints();
        gridBagConstraints8.gridx = 0;
        gridBagConstraints8.gridy = 4;
        labelPrestados = new javax.swing.JLabel();
        labelPrestados.setText("Total prestados:");
        java.awt.GridBagConstraints gridBagConstraints7 = new java.awt.GridBagConstraints();
        gridBagConstraints7.gridx = 1;
        gridBagConstraints7.gridy = 3;
        labelLibrosTotal = new javax.swing.JLabel();
        labelLibrosTotal.setText("");
        java.awt.GridBagConstraints gridBagConstraints6 = new java.awt.GridBagConstraints();
        gridBagConstraints6.gridx = 0;
        gridBagConstraints6.gridy = 3;
        labelTotal = new javax.swing.JLabel();
        labelTotal.setText("Total libros:");
        java.awt.GridBagConstraints gridBagConstraints5 = new java.awt.GridBagConstraints();
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints5.gridwidth = 2;
        gridBagConstraints5.gridy = 2;
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints1.insets = new java.awt.Insets(0, 10, 0, 0);
        gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints1.gridwidth = 2;
        gridBagConstraints1.gridy = 0;
        labelAcciones = new javax.swing.JLabel();
        labelAcciones.setText("Acciones");
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridx = 0;
        labelLibrosTotal.setText(("" + total));
        labelLibrosPrestados.setText(("" + prestados));
        setSize(244, 378);
        setLayout(new java.awt.GridBagLayout());
        setBackground(new java.awt.Color(255, 255, 204));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, nombre, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51, 51, 51)));
        setMaximumSize(new java.awt.Dimension(244, 378));
        setMinimumSize(new java.awt.Dimension(244, 378));
        setPreferredSize(new java.awt.Dimension(244, 378));
        comboAcciones = new javax.swing.JComboBox();
        comboAcciones.addItem(code.biblioteca.interfaz.PanelAccionesUsuario.AGREGAR_LIBRO);
        comboAcciones.addItem(code.biblioteca.interfaz.PanelAccionesUsuario.BUSCAR_LIBROS);
        comboAcciones.addItem(code.biblioteca.interfaz.PanelAccionesUsuario.VER_LIBROS);
        comboAcciones.addItem(code.biblioteca.interfaz.PanelAccionesUsuario.SALIR);
        comboAcciones.setActionCommand("COMBO");
        comboAcciones.addActionListener(code.biblioteca.interfaz.PanelAccionesUsuario.this);
        add(comboAcciones, gridBagConstraints);
        add(labelAcciones, gridBagConstraints1);
        accionesContenedora = new code.biblioteca.interfaz.PanelAccionesContenedoraLibro(principal);
        add(accionesContenedora, gridBagConstraints5);
        add(labelTotal, gridBagConstraints6);
        add(labelLibrosTotal, gridBagConstraints7);
        code.biblioteca.interfaz.PanelAccionesUsuario.this.add(labelPrestados, gridBagConstraints8);
        code.biblioteca.interfaz.PanelAccionesUsuario.this.add(labelLibrosPrestados, gridBagConstraints9);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (comboAcciones.getSelectedItem().equals(code.biblioteca.interfaz.PanelAccionesUsuario.AGREGAR_LIBRO))
            accionesContenedora.cambiarVentana("AGREGAR");
        else if (comboAcciones.getSelectedItem().equals(code.biblioteca.interfaz.PanelAccionesUsuario.BUSCAR_LIBROS))
            accionesContenedora.cambiarVentana("BUSCAR");
        else if (comboAcciones.getSelectedItem().equals(code.biblioteca.interfaz.PanelAccionesUsuario.VER_LIBROS)) {
            principal.verAlquilados();
            accionesContenedora.cambiarVentana("BLANCO");
        } else if (comboAcciones.getSelectedItem().equals(code.biblioteca.interfaz.PanelAccionesUsuario.SALIR))
            principal.salir();
        
    }

    public void update(java.util.Observable observable, java.lang.Object objeto) {
        if (objeto instanceof int[]) {
            int[] arreglo = ((int[]) (objeto));
            labelLibrosTotal.setText(("" + (arreglo[0])));
            labelLibrosPrestados.setText(("" + (arreglo[1])));
        } 
    }
}

