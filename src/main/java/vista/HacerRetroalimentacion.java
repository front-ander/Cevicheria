package vista;

import dao.RetroalimentacionDAO;
import javax.swing.JOptionPane;
import modelo.Pedido;
import modelo.Retroalimentacion;

public class HacerRetroalimentacion extends javax.swing.JDialog {

    private Retroalimentacion retro;
    private RetroalimentacionDAO retroDAO;
    private boolean existente = false;
    private Pedido pedido;

    public HacerRetroalimentacion(java.awt.Frame parent, boolean modal, Pedido pedido, RetroalimentacionDAO retroDAO) {
        super(parent, modal);
        this.retroDAO = retroDAO;
        this.pedido = pedido;
        initComponents();
        setLocationRelativeTo(null);
    }

    public void abrirVentana() {
        comentario.setText("");
        calificacion.setValue(1);
        cargarRetroalimentacion();
        setVisible(true);
    }

    public void cargarRetroalimentacion() {
        retro = retroDAO.buscarPorIdPedido(pedido.getIdPedido());
        if (retro != null) {
            existente = true;
            comentario.setText(retro.getComentario());
            calificacion.setValue(retro.getCalificacion());
        } else {
            existente = false;
        }
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        comentario = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        regresar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        calificacion = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        comentario.setColumns(30);
        comentario.setRows(10);
        jScrollPane1.setViewportView(comentario);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("Ingrese su comentario sobre el pedido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Retroalimentacion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel2, gridBagConstraints);

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(regresar, gridBagConstraints);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(guardar, gridBagConstraints);

        jLabel3.setText("Calificacion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel3, gridBagConstraints);

        calificacion.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        calificacion.setEditor(new javax.swing.JSpinner.NumberEditor(calificacion, ""));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(calificacion, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if (!comentario.getText().isBlank()) {
            if (existente) {
                retro.setIdPedido(pedido.getIdPedido());
                retro.setComentario(comentario.getText());
                retro.setCalificacion((int) calificacion.getValue());
                retroDAO.update(retro);
            } else {
                retro = new Retroalimentacion();
                retro.setIdPedido(pedido.getIdPedido());
                retro.setComentario(comentario.getText());
                retro.setCalificacion((int) calificacion.getValue());
                retroDAO.create(retro);
            }
            JOptionPane.showMessageDialog(this, "Retroalimentacion guardada");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Escriba un comentario valido");
        }
    }//GEN-LAST:event_guardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner calificacion;
    private javax.swing.JTextArea comentario;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
