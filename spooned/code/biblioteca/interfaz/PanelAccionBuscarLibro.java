

package code.biblioteca.interfaz;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class PanelAccionBuscarLibro extends javax.swing.JPanel implements java.awt.event.ActionListener {
    private static final long serialVersionUID = 1L;

    private static final java.lang.String BOTON_BUSCAR = "Buscar";

    private static final java.lang.String RADIO_TODOS = "Descripci�n";

    private static final java.lang.String RADIO_EXACTO = "Exacto";

    private static final java.lang.String TITULO = "Por t�tulo";

    private static final java.lang.String AUTOR = "Por autor";

    private static final java.lang.String DESCRIPTORES = "Por descriptores";

    private static final java.lang.String COMBO_ACCIONES = "Combo Acciones";

    private code.biblioteca.interfaz.InterfazBiblioteca principal;

    private javax.swing.JLabel labelPalabras;

    private javax.swing.JTextField textoPalabras;

    private javax.swing.JComboBox comboBusqueda;

    private javax.swing.JLabel labelCriterio;

    private javax.swing.JRadioButton radioExacto;

    private javax.swing.JRadioButton radioAlmenos;

    private javax.swing.JLabel labelDescriptores;

    private javax.swing.JTextField textoDescriptor1;

    private javax.swing.JTextField textoDescriptor2;

    private javax.swing.JTextField textoDescriptor3;

    private javax.swing.JButton botonBuscar = null;

    public PanelAccionBuscarLibro(code.biblioteca.interfaz.InterfazBiblioteca principal) {
        super();
        code.biblioteca.interfaz.PanelAccionBuscarLibro.this.principal = principal;
        initialize();
    }

    private void initialize() {
        java.awt.GridBagConstraints gridBagConstraints10 = new java.awt.GridBagConstraints();
        gridBagConstraints10.gridx = 1;
        gridBagConstraints10.insets = new java.awt.Insets(43, 0, 0, 0);
        gridBagConstraints10.gridy = 6;
        java.awt.GridBagConstraints gridBagConstraints9 = new java.awt.GridBagConstraints();
        gridBagConstraints9.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints9.gridy = 5;
        gridBagConstraints9.weightx = 1.0;
        gridBagConstraints9.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints8 = new java.awt.GridBagConstraints();
        gridBagConstraints8.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints8.gridy = 4;
        gridBagConstraints8.weightx = 1.0;
        gridBagConstraints8.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints7 = new java.awt.GridBagConstraints();
        gridBagConstraints7.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints7.gridy = 3;
        gridBagConstraints7.weightx = 1.0;
        gridBagConstraints7.insets = new java.awt.Insets(11, 0, 0, 0);
        gridBagConstraints7.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints6 = new java.awt.GridBagConstraints();
        gridBagConstraints6.gridx = 0;
        gridBagConstraints6.insets = new java.awt.Insets(11, 0, 0, 0);
        gridBagConstraints6.gridy = 3;
        java.awt.GridBagConstraints gridBagConstraints5 = new java.awt.GridBagConstraints();
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.gridy = 2;
        java.awt.GridBagConstraints gridBagConstraints4 = new java.awt.GridBagConstraints();
        gridBagConstraints4.gridx = 1;
        gridBagConstraints4.gridy = 2;
        java.awt.GridBagConstraints gridBagConstraints3 = new java.awt.GridBagConstraints();
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 1;
        java.awt.GridBagConstraints gridBagConstraints2 = new java.awt.GridBagConstraints();
        gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints1 = new java.awt.GridBagConstraints();
        gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.gridx = 1;
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        code.biblioteca.interfaz.PanelAccionBuscarLibro.this.setSize(244, 320);
        code.biblioteca.interfaz.PanelAccionBuscarLibro.this.setLayout(new java.awt.GridBagLayout());
        code.biblioteca.interfaz.PanelAccionBuscarLibro.this.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Libro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51, 51, 51)));
        code.biblioteca.interfaz.PanelAccionBuscarLibro.this.setOpaque(false);
        labelPalabras = new javax.swing.JLabel();
        labelPalabras.setText("Palabras:");
        labelPalabras.setToolTipText("Palabras:");
        add(labelPalabras, gridBagConstraints);
        textoPalabras = new javax.swing.JTextField();
        add(textoPalabras, gridBagConstraints1);
        comboBusqueda = new javax.swing.JComboBox();
        comboBusqueda.addItem(code.biblioteca.interfaz.PanelAccionBuscarLibro.TITULO);
        comboBusqueda.addItem(code.biblioteca.interfaz.PanelAccionBuscarLibro.AUTOR);
        comboBusqueda.addItem(code.biblioteca.interfaz.PanelAccionBuscarLibro.DESCRIPTORES);
        comboBusqueda.addActionListener(code.biblioteca.interfaz.PanelAccionBuscarLibro.this);
        comboBusqueda.setActionCommand(code.biblioteca.interfaz.PanelAccionBuscarLibro.COMBO_ACCIONES);
        add(comboBusqueda, gridBagConstraints2);
        labelCriterio = new javax.swing.JLabel();
        labelCriterio.setText("Criterio:");
        add(labelCriterio, gridBagConstraints3);
        radioExacto = new javax.swing.JRadioButton();
        radioExacto.setText("Todas las palabras");
        radioExacto.setOpaque(false);
        radioExacto.addActionListener(code.biblioteca.interfaz.PanelAccionBuscarLibro.this);
        add(radioExacto, gridBagConstraints4);
        radioAlmenos = new javax.swing.JRadioButton();
        radioAlmenos.setText("Por palabra");
        radioAlmenos.setOpaque(false);
        radioAlmenos.setSelected(true);
        radioAlmenos.addActionListener(code.biblioteca.interfaz.PanelAccionBuscarLibro.this);
        add(radioAlmenos, gridBagConstraints5);
        javax.swing.ButtonGroup grupoRadio = new javax.swing.ButtonGroup();
        grupoRadio.add(radioAlmenos);
        grupoRadio.add(radioExacto);
        labelDescriptores = new javax.swing.JLabel();
        labelDescriptores.setText("Descriptores:");
        add(labelDescriptores, gridBagConstraints6);
        textoDescriptor1 = new javax.swing.JTextField();
        textoDescriptor1.setEnabled(false);
        add(textoDescriptor1, gridBagConstraints7);
        textoDescriptor2 = new javax.swing.JTextField();
        textoDescriptor2.setEnabled(false);
        add(textoDescriptor2, gridBagConstraints8);
        textoDescriptor3 = new javax.swing.JTextField();
        textoDescriptor3.setEnabled(false);
        add(textoDescriptor3, gridBagConstraints9);
        botonBuscar = new javax.swing.JButton();
        botonBuscar.setText("Buscar");
        botonBuscar.setActionCommand(code.biblioteca.interfaz.PanelAccionBuscarLibro.BOTON_BUSCAR);
        botonBuscar.addActionListener(code.biblioteca.interfaz.PanelAccionBuscarLibro.this);
        add(botonBuscar, gridBagConstraints10);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getActionCommand().equals(code.biblioteca.interfaz.PanelAccionBuscarLibro.BOTON_BUSCAR))
            buscar();
        
        if (e.getActionCommand().equals(code.biblioteca.interfaz.PanelAccionBuscarLibro.RADIO_EXACTO)) {
            radioAlmenos.setSelected(true);
            radioExacto.setSelected(false);
        } 
        if (e.getActionCommand().equals(code.biblioteca.interfaz.PanelAccionBuscarLibro.RADIO_TODOS)) {
            radioAlmenos.setSelected(false);
            radioExacto.setSelected(true);
        } 
        if (e.getActionCommand().equals(code.biblioteca.interfaz.PanelAccionBuscarLibro.COMBO_ACCIONES))
            seleccionCombo();
        
    }

    public void seleccionCombo() {
        if ((comboBusqueda.getSelectedItem().equals(code.biblioteca.interfaz.PanelAccionBuscarLibro.TITULO)) || (comboBusqueda.getSelectedItem().equals(code.biblioteca.interfaz.PanelAccionBuscarLibro.AUTOR))) {
            textoPalabras.setEnabled(true);
            textoDescriptor1.setEnabled(false);
            textoDescriptor2.setEnabled(false);
            textoDescriptor3.setEnabled(false);
        } else {
            textoPalabras.setEnabled(false);
            textoDescriptor1.setEnabled(true);
            textoDescriptor2.setEnabled(true);
            textoDescriptor3.setEnabled(true);
        }
    }

    public void buscar() {
        if (comboBusqueda.getSelectedItem().equals(code.biblioteca.interfaz.PanelAccionBuscarLibro.TITULO)) {
            if (textoPalabras.getText().equals("")) {
                javax.swing.JOptionPane.showMessageDialog(principal, "Ingrese las palabras", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return ;
            } 
            if (radioAlmenos.isSelected())
                principal.buscarTituloPorPalabra(textoPalabras.getText().split(" "));
            else
                principal.buscarTituloExacto(textoPalabras.getText());
            
        } 
        if (comboBusqueda.getSelectedItem().equals(code.biblioteca.interfaz.PanelAccionBuscarLibro.AUTOR)) {
            if (textoPalabras.getText().equals("")) {
                javax.swing.JOptionPane.showMessageDialog(principal, "Ingrese las palabras", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return ;
            } 
            if (radioAlmenos.isSelected())
                principal.buscarAutoresPorPalabra(textoPalabras.getText().split(" "));
            else
                principal.buscarAutoresExacto(textoPalabras.getText());
            
        } 
        if (comboBusqueda.getSelectedItem().equals(code.biblioteca.interfaz.PanelAccionBuscarLibro.DESCRIPTORES)) {
            if (((textoDescriptor1.getText().equals("")) && (textoDescriptor2.getText().equals(""))) && (textoDescriptor3.getText().equals(""))) {
                javax.swing.JOptionPane.showMessageDialog(principal, "Ingrese al menos un descriptor", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return ;
            } 
            int contador = 0;
            if (!(textoDescriptor1.getText().equals("")))
                contador++;
            
            if (!(textoDescriptor2.getText().equals("")))
                contador++;
            
            if (!(textoDescriptor3.getText().equals("")))
                contador++;
            
            java.lang.String[] datos = new java.lang.String[contador];
            contador = 0;
            if (!(textoDescriptor1.getText().equals(""))) {
                datos[contador] = textoDescriptor1.getText().trim();
                contador++;
            } 
            if (!(textoDescriptor2.getText().equals(""))) {
                datos[contador] = textoDescriptor2.getText().trim();
                contador++;
            } 
            if (!(textoDescriptor3.getText().equals("")))
                datos[contador] = textoDescriptor3.getText().trim();
            
            if (radioAlmenos.isSelected())
                principal.buscarDescriptoresPorPalabra(datos);
            else
                principal.buscarDescriptoresExacto(datos);
            
        } 
    }
}

