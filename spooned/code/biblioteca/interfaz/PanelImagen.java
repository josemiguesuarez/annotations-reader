

package code.biblioteca.interfaz;


@code.annotation.MyAnnotation(myAttribute = "Class")
public class PanelImagen extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    private javax.swing.JLabel labelImagen = null;

    public PanelImagen() {
        super();
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        labelImagen = new javax.swing.JLabel();
        labelImagen.setText("");
        labelImagen.setPreferredSize(new java.awt.Dimension(800, 100));
        labelImagen.setMaximumSize(new java.awt.Dimension(800, 100));
        labelImagen.setMinimumSize(new java.awt.Dimension(800, 100));
        labelImagen.setIcon(new javax.swing.ImageIcon("data/imagen.jpg"));
        setSize(640, 100);
        setLayout(new java.awt.GridBagLayout());
        add(labelImagen, gridBagConstraints);
    }
}

