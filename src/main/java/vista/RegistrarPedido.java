package vista;

import dao.DAOManager;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Pedido;
import modelo.PedidoPlato;
import modelo.Plato;
import modelo.Usuario;

public class RegistrarPedido extends javax.swing.JFrame {

    private DAOManager dao;
    private Usuario usuario;
    private Principal principal;

    private double totalPedido = 0;
    private ArrayList<Plato> listaPlatos = new ArrayList<>();
    private DefaultComboBoxModel<Plato> modeloCombo = new DefaultComboBoxModel<>();
    private SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(0, 0, 0, 1);
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    private RegistrarPago registrarPago;

    public RegistrarPedido(Principal principal, DAOManager dao, Usuario usuario) {
        this.principal = principal;
        this.dao = dao;
        this.usuario = usuario;

        registrarPago = new RegistrarPago(this, true, dao.getPagoDAO());

        modeloTabla.addColumn("Plato");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Precio Unit");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Subtotal");

        initComponents();
        setLocationRelativeTo(null);

        mesa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        tablaPedidos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                eliminar.setEnabled(true);
                modeloSpinner.setValue(0);
            }
        });
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void abrirVentana() {
        totalPedido = 0;
        cliente.setText(usuario.getNombre());
        obtenerPlatos();
        mesa.setText("");
        descripcion.setText("");
        total.setText("0");
        modeloSpinner.setValue(0);
        modeloTabla.setRowCount(0);//limpia la tabla
        listaPlatos.clear();
        setVisible(true);
    }

    public void actualizarStock(int max) {
        modeloSpinner.setMaximum(max);
    }

    public void obtenerPlatos() {
        modeloCombo.removeAllElements();
        modeloCombo.addAll(dao.getPlatoDAO().readAll());
    }

    public void agregarATabla(Plato p, int cantidad) {
        modeloTabla.addRow(new Object[]{p.getNombre(), p.getDescripcion(), p.getPrecio(), cantidad, p.getPrecio() * cantidad});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mesa = new javax.swing.JTextField();
        platos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        cantidad = new javax.swing.JSpinner();
        regresar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        realizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        cliente.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(cliente, gridBagConstraints);

        jLabel2.setText("Mesa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(mesa, gridBagConstraints);

        platos.setMaximumRowCount(20);
        platos.setModel(modeloCombo);
        platos.setMinimumSize(new java.awt.Dimension(100, 26));
        platos.setPreferredSize(new java.awt.Dimension(150, 26));
        platos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                platosItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(platos, gridBagConstraints);

        jLabel3.setText("Plato");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Descripcion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel4, gridBagConstraints);

        descripcion.setEditable(false);
        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jLabel5.setText("Cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel5, gridBagConstraints);

        cantidad.setModel(modeloSpinner);
        cantidad.setEditor(new javax.swing.JSpinner.NumberEditor(cantidad, ""));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(cantidad, gridBagConstraints);

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(regresar, gridBagConstraints);

        agregar.setText("Agregar plato");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(agregar, gridBagConstraints);

        realizar.setText("Realizar pedido");
        realizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(realizar, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(456, 150));

        tablaPedidos.setModel(modeloTabla);
        tablaPedidos.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(tablaPedidos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        total.setEditable(false);
        total.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(total, gridBagConstraints);

        jLabel6.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel6, gridBagConstraints);

        eliminar.setText("Eliminar plato");
        eliminar.setEnabled(false);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(eliminar, gridBagConstraints);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lista de pedidos registrados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Registrar pedido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jLabel8, gridBagConstraints);

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        Plato platoSeleccionado = (Plato) modeloCombo.getSelectedItem();
        int cant = modeloSpinner.getNumber().intValue();
        if (cant > 0 && platoSeleccionado != null) {
            try {
                dao.getIngredienteDAO().quitarCantidadSegunPlato(platoSeleccionado.getIdPlato(), cant);
                listaPlatos.add(platoSeleccionado);
                agregarATabla(platoSeleccionado, cant);
                totalPedido += platoSeleccionado.getPrecio() * cant;

                modeloSpinner.setValue(0);
                total.setText(totalPedido + "");
                platos.setSelectedIndex(-1);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al agregar el producto");
                Logger.getLogger(RegistrarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "La cantidad selecciona debe ser mayor que 0");
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void platosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_platosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Plato platoSeleccionado = (Plato) modeloCombo.getSelectedItem();
            if (platoSeleccionado != null) {
                actualizarStock(dao.getPlatoDAO().obtenerMaxStockDePlato(platoSeleccionado.getIdPlato()));
                descripcion.setText(platoSeleccionado.getDescripcion());
            }
        }
    }//GEN-LAST:event_platosItemStateChanged

    private void realizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarActionPerformed
        if (!mesa.getText().isBlank()) {
            if (listaPlatos.isEmpty()) {
                return;
            }
            Pedido pedidoAct = new Pedido();
            try {
                pedidoAct.setMesa(Integer.parseInt(mesa.getText()));
                pedidoAct.setIdUsuario(usuario.getIdUsuario());
                pedidoAct.setFechaPedido(Timestamp.valueOf(LocalDateTime.now()));
                pedidoAct.setTotal(totalPedido);
                pedidoAct.setEstado("Por pagar");
                dao.getPedidoDAO().create(pedidoAct);
                for (Plato p : listaPlatos) {
                    dao.getPedidoPlatoDAO().create(new PedidoPlato(-1, pedidoAct.getIdPedido(), p.getIdPlato(), WIDTH));
                }

                registrarPago.setPedido(pedidoAct);
                registrarPago.abrirVentana();

                if (registrarPago.sePago()) {
                    abrirVentana();
                    pedidoAct.setEstado("Por hacer");
                    dao.getPedidoDAO().update(pedidoAct);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La mesa seleccionada no es valida");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona su mesa");
        }
    }//GEN-LAST:event_realizarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int index = tablaPedidos.getSelectedRow();
        if (index >= 0) {
            int cantidad = (int) modeloTabla.getValueAt(index, 3);
            Plato p = listaPlatos.get(index);
            try {
                dao.getIngredienteDAO().agregarCantidadSegunPlato(p.getIdPlato(), cantidad);
                listaPlatos.remove(index);
                modeloTabla.removeRow(index);
                totalPedido -= cantidad * p.getPrecio();
                total.setText(totalPedido + "");
                JOptionPane.showMessageDialog(this, "Plato eliminado");
                eliminar.setEnabled(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar");
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        principal.abrirVentana();
        dispose();
    }//GEN-LAST:event_regresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JSpinner cantidad;
    private javax.swing.JTextField cliente;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField mesa;
    private javax.swing.JComboBox<Plato> platos;
    private javax.swing.JButton realizar;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
