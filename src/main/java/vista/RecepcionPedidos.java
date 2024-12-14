package vista;

import dao.DAOManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import modelo.Pedido;
import modelo.Plato;

public class RecepcionPedidos extends javax.swing.JFrame {

    private Principal principal;
    private DAOManager dao;

    private Pedido pedSeleccionado;
    private List<Pedido> pedidos = new ArrayList<>();
    private DefaultListModel modeloPedidos = new DefaultListModel();
    private DefaultListModel modeloPlatos = new DefaultListModel();
    private ActualizarEstado actualizarEstado;

    public RecepcionPedidos(Principal principal, DAOManager dao) {
        this.principal = principal;
        this.dao = dao;
        actualizarEstado = new ActualizarEstado(this, true, pedSeleccionado, dao.getPedidoDAO());
        initComponents();
        setLocationRelativeTo(null);
    }

    public void cargarPedidos() {
        pedidos = dao.getPedidoDAO().readAll();
        modeloPedidos.removeAllElements();
        for (Pedido p : pedidos) {
            modeloPedidos.addElement(p.getIdPedido() + " | " + p.getFechaPedido().toString());
        }
    }

    public void cargarPlatos() {
        if (pedSeleccionado != null) {
            List<Plato> platos = dao.getPlatoDAO().buscarPlatosPorIdPedido(pedSeleccionado.getIdPedido());
            modeloPlatos.removeAllElements();
            for (Plato p : platos) {
                modeloPlatos.addElement(p.getNombre() + " | " + p.getPrecio());
            }
        }
    }

    public void abrirVentana() {
        total.setText("");
        fecha.setText("");
        estado.setText("");
        modeloPlatos.removeAllElements();
        actualizar.setEnabled(false);
        cargarPedidos();
        setVisible(true);
    }

    public void actualizarEstado() {
        dispose();
        actualizarEstado.abrirVentana();
        setVisible(true);
    }

    public void cargarDatosPedido() {
        total.setText(pedSeleccionado.getTotal() + "");
        fecha.setText(pedSeleccionado.getFechaPedido().toString());
        usuarioNombre.setText(dao.getUsuarioDAO().read(pedSeleccionado.getIdPedido()).getNombre());
        estado.setText(pedSeleccionado.getEstado());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPedidos = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        actualizar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaPlatos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        estado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        usuarioNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        listaPedidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        listaPedidos.setModel(modeloPedidos);
        listaPedidos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaPedidos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de pedidos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        actualizar.setText("Actualizar estado");
        actualizar.setEnabled(false);
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(actualizar, gridBagConstraints);

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(regresar, gridBagConstraints);

        listaPlatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Platos"));
        listaPlatos.setModel(modeloPlatos);
        jScrollPane3.setViewportView(listaPlatos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jScrollPane3, gridBagConstraints);

        jLabel2.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(total, gridBagConstraints);

        jLabel3.setText("Fecha");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(fecha, gridBagConstraints);

        jLabel4.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(estado, gridBagConstraints);

        jLabel5.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(usuarioNombre, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaPedidosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosValueChanged
        if (listaPedidos.getSelectedIndex() != -1) {
            pedSeleccionado = pedidos.get(listaPedidos.getSelectedIndex());
            cargarPlatos();
            cargarDatosPedido();
            actualizar.setEnabled(true);
        }
    }//GEN-LAST:event_listaPedidosValueChanged

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        actualizarEstado.setPedido(pedSeleccionado);
        actualizarEstado.abrirVentana();
        abrirVentana();
    }//GEN-LAST:event_actualizarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        principal.abrirVentana();
        dispose();
    }//GEN-LAST:event_regresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JTextField estado;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaPedidos;
    private javax.swing.JList<String> listaPlatos;
    private javax.swing.JButton regresar;
    private javax.swing.JTextField total;
    private javax.swing.JTextField usuarioNombre;
    // End of variables declaration//GEN-END:variables
}
