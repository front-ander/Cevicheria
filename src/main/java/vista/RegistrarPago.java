package vista;

import dao.PagoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.Instant;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import modelo.Pago;
import modelo.Pedido;

public class RegistrarPago extends javax.swing.JDialog {

    private ButtonGroup grupo = new ButtonGroup();
    private PagoDAO pagoDAO;
    private Pedido pedido;

    private boolean sePago = false;

    public RegistrarPago(java.awt.Frame parent, boolean modal, PagoDAO pagoDAO) {
        super(parent, modal);
        this.pagoDAO = pagoDAO;

        initComponents();
        setLocationRelativeTo(null);
        grupo.add(altEfectivo);
        grupo.add(altTarjeta);
        grupo.add(altMovil);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagar.setEnabled(true);
            }
        };

        altEfectivo.addActionListener(listener);
        altTarjeta.addActionListener(listener);
        altMovil.addActionListener(listener);
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean sePago() {
        return sePago;
    }

    public void abrirVentana() {
        sePago = false;
        altEfectivo.setSelected(false);
        altTarjeta.setSelected(false);
        altMovil.setSelected(false);
        if (pedido == null) {
            total.setText("0");
        } else {
            total.setText(pedido.getTotal() + "");
        }
        pagar.setEnabled(false);

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        altEfectivo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        altTarjeta = new javax.swing.JRadioButton();
        altMovil = new javax.swing.JRadioButton();
        pagar = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        altEfectivo.setText("Efectivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(altEfectivo, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Pago");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel1, gridBagConstraints);

        altTarjeta.setText("Tarjeta de crédito/débito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(altTarjeta, gridBagConstraints);

        altMovil.setText("Pago móvil");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(altMovil, gridBagConstraints);

        pagar.setText("Pagar");
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pagar, gridBagConstraints);

        total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        total.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(total, gridBagConstraints);

        jLabel2.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jLabel2, gridBagConstraints);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(cancelar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        if (pedido != null) {
            String metodo = "---";
            if (altEfectivo.isSelected()) {
                metodo = "Efectivo";
            } else if (altTarjeta.isSelected()) {
                metodo = "Tarjeta";
            } else if (altMovil.isSelected()) {
                metodo = "Movil";
            }
            pagoDAO.create(new Pago(-1, pedido.getIdPedido(), Timestamp.from(Instant.now()), pedido.getTotal(), metodo));
            JOptionPane.showMessageDialog(this, "Pago registrado");

            sePago = true;
            dispose();
        }
    }//GEN-LAST:event_pagarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        sePago = false;
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton altEfectivo;
    private javax.swing.JRadioButton altMovil;
    private javax.swing.JRadioButton altTarjeta;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton pagar;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
