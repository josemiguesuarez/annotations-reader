

package code.biblioteca.interfaz;


@code.annotation.MyAnnotation(mandatory = "true", myAttribute = "Class")
public class PanelLibro extends javax.swing.JPanel implements java.awt.event.ActionListener {
    private static final long serialVersionUID = 1L;

    private static final java.lang.String PEDIR_LIBRO = "Pedir Libro";

    private code.biblioteca.mundo.ILibro libro;

    private code.biblioteca.interfaz.InterfazBiblioteca principal;

    private javax.swing.JLabel labelTitulo;

    private javax.swing.JLabel labelAutores;

    private javax.swing.JLabel labelDescriptores;

    private javax.swing.JLabel labelDisponibles;

    private javax.swing.JLabel labelDTitulo;

    private javax.swing.JLabel labelDAutores;

    private javax.swing.JLabel labelDDescriptores;

    private javax.swing.JLabel labelDDisponibles;

    private javax.swing.JButton botonPedir;

    public PanelLibro(code.biblioteca.mundo.ILibro elLibro, code.biblioteca.interfaz.InterfazBiblioteca laInterfaz) {
        principal = laInterfaz;
        libro = elLibro;
        java.awt.GridBagConstraints gridBagConstraints9 = new java.awt.GridBagConstraints();
        gridBagConstraints9.gridx = 2;
        gridBagConstraints9.gridheight = 2;
        gridBagConstraints9.gridy = 1;
        java.awt.GridBagConstraints gridBagConstraints8 = new java.awt.GridBagConstraints();
        gridBagConstraints8.gridx = 1;
        gridBagConstraints8.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints8.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints8.gridwidth = 2;
        gridBagConstraints8.ipadx = 0;
        gridBagConstraints8.ipady = 46;
        gridBagConstraints8.gridy = 4;
        labelDDisponibles = new javax.swing.JLabel();
        labelDDisponibles.setText(((libro.darCopiasDisponibles()) + ""));
        labelDDisponibles.setBackground(new java.awt.Color(218, 208, 197));
        labelDDisponibles.setOpaque(true);
        labelDDisponibles.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 24));
        java.awt.GridBagConstraints gridBagConstraints7 = new java.awt.GridBagConstraints();
        gridBagConstraints7.gridx = 1;
        gridBagConstraints7.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints7.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints7.gridy = 2;
        labelDDescriptores = new javax.swing.JLabel();
        labelDDescriptores.setText(libro.darDescriptores());
        labelDDescriptores.setMaximumSize(new java.awt.Dimension(360, 14));
        labelDDescriptores.setMinimumSize(new java.awt.Dimension(360, 14));
        labelDDescriptores.setPreferredSize(new java.awt.Dimension(360, 14));
        labelDDescriptores.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 10));
        java.awt.GridBagConstraints gridBagConstraints5 = new java.awt.GridBagConstraints();
        gridBagConstraints5.gridx = 1;
        gridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints5.gridy = 1;
        labelDAutores = new javax.swing.JLabel();
        labelDAutores.setText(libro.darAutores());
        labelDAutores.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 10));
        java.awt.GridBagConstraints gridBagConstraints4 = new java.awt.GridBagConstraints();
        gridBagConstraints4.gridx = 1;
        gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints4.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints4.gridy = 0;
        labelDTitulo = new javax.swing.JLabel();
        labelDTitulo.setText(libro.darTitulo());
        labelDTitulo.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 10));
        java.awt.GridBagConstraints gridBagConstraints3 = new java.awt.GridBagConstraints();
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints3.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints3.insets = new java.awt.Insets(0, 0, 0, 0);
        gridBagConstraints3.ipadx = 0;
        gridBagConstraints3.ipady = 46;
        gridBagConstraints3.gridwidth = 1;
        gridBagConstraints3.gridy = 4;
        labelDisponibles = new javax.swing.JLabel();
        labelDisponibles.setText("Disponibles:");
        labelDisponibles.setBackground(new java.awt.Color(218, 208, 197));
        labelDisponibles.setOpaque(true);
        labelDisponibles.setForeground(java.awt.Color.black);
        java.awt.GridBagConstraints gridBagConstraints2 = new java.awt.GridBagConstraints();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints2.gridy = 2;
        labelDescriptores = new javax.swing.JLabel();
        labelDescriptores.setText("Descriptores:");
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.gridx = 0;
        gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints1.gridy = 1;
        labelAutores = new javax.swing.JLabel();
        labelAutores.setText("Autores:");
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 0);
        gridBagConstraints.gridy = 0;
        labelTitulo = new javax.swing.JLabel();
        labelTitulo.setText("T�tulo:");
        setSize(517, 144);
        setLayout(new java.awt.GridBagLayout());
        setBackground(new java.awt.Color(245, 235, 214));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, libro.darReferencia(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), java.awt.Color.blue));
        add(labelTitulo, gridBagConstraints);
        add(labelAutores, gridBagConstraints1);
        add(labelDescriptores, gridBagConstraints2);
        add(labelDisponibles, gridBagConstraints3);
        add(labelDTitulo, gridBagConstraints4);
        add(labelDAutores, gridBagConstraints5);
        add(labelDDescriptores, gridBagConstraints7);
        add(labelDDisponibles, gridBagConstraints8);
        botonPedir = new javax.swing.JButton();
        botonPedir.setText("Pedir");
        botonPedir.setActionCommand(code.biblioteca.interfaz.PanelLibro.PEDIR_LIBRO);
        botonPedir.addActionListener(code.biblioteca.interfaz.PanelLibro.this);
        code.biblioteca.interfaz.PanelLibro.this.add(botonPedir, gridBagConstraints9);
        if ((libro.darCopiasDisponibles()) == 0)
            botonPedir.setEnabled(false);
        
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getActionCommand().equals(code.biblioteca.interfaz.PanelLibro.PEDIR_LIBRO))
            try {
                principal.alquilar(libro.darReferencia());
                labelDDisponibles.setText(((libro.darCopiasDisponibles()) + ""));
            } catch (code.biblioteca.mundo.excepciones.CopiasInsuficientesException e1) {
                javax.swing.JOptionPane.showMessageDialog(code.biblioteca.interfaz.PanelLibro.this, e1.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        
    }
}

