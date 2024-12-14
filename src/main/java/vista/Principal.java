package vista;

import dao.DAOManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Usuario;

public class Principal extends javax.swing.JFrame {

    private DAOManager dao = new DAOManager();
    private Usuario usuario = null;
    private Login login;
    private RegistrarPedido registrarPedido;
    private ListarPedidos listarPedidos;
    private RecepcionPedidos recepcionPedidos;
    private VerInventario verInventario;

    public Principal() {

        login = new Login(this, true, dao.getUsuarioDAO());

        initComponents();
        setLocationRelativeTo(null);

        registrarPedido = new RegistrarPedido(this, dao, usuario);
        listarPedidos = new ListarPedidos(this, dao, usuario);
        abrirLogin();
        recepcionPedidos = new RecepcionPedidos(this, dao);
        verInventario = new VerInventario(this, dao);

        abrirVentana();
    }

    public void abrirLogin() {
        dispose();
        login.setVisible(true);
        setVisible(true);
        usuario = login.getUsuario();
        registrarPedido.setUsuario(usuario);
        listarPedidos.setUsuario(usuario);
        comprobarRol();
    }

    public void comprobarRol() {
        if (usuario != null) {
            switch (usuario.getIdRol()) {
                case 2: //Trabajador
                    btnRegistrarPedido.setVisible(false);
                    btnListarPedidos.setVisible(false);
                    break;
                case 3: //Cliente
                    btnVerInventario.setVisible(false);
                    btnVerPedidos.setVisible(false);
                    break;
            }
        }
    }

    public void abrirVentana() {
        usuario = login.getUsuario();
        if (usuario == null) {
            System.exit(0);
        }

        comprobarRol();

        txfBienvenido.setText("Bienvenido " + usuario.getNombre());
        txfFecha.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/LL/yyyy")));

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarPedido = new javax.swing.JButton();
        btnListarPedidos = new javax.swing.JButton();
        btnVerInventario = new javax.swing.JButton();
        btnVerPedidos = new javax.swing.JButton();
        cerrarSesion = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        txfBienvenido = new javax.swing.JLabel();
        txfFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 200));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de acciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnRegistrarPedido.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnRegistrarPedido.setText("Registrar nuevo pedido");
        btnRegistrarPedido.setAlignmentX(0.5F);
        btnRegistrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPedidoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(btnRegistrarPedido, gridBagConstraints);

        btnListarPedidos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnListarPedidos.setText("Listar pedidos");
        btnListarPedidos.setAlignmentX(0.5F);
        btnListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPedidosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(btnListarPedidos, gridBagConstraints);

        btnVerInventario.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnVerInventario.setText("Ver inventario");
        btnVerInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInventarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(btnVerInventario, gridBagConstraints);

        btnVerPedidos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnVerPedidos.setText("Ver pedidos");
        btnVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(btnVerPedidos, gridBagConstraints);

        cerrarSesion.setText("Cerrar sesión");
        cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(cerrarSesion, gridBagConstraints);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(salir, gridBagConstraints);

        jScrollPane1.setViewportView(jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        txfBienvenido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txfBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txfBienvenido.setText("Bienvenido [nombre]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(txfBienvenido, gridBagConstraints);

        txfFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txfFecha.setText("dd/MM/yyyy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(txfFecha, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPedidoActionPerformed
        registrarPedido.setUsuario(usuario);
        registrarPedido.abrirVentana();
        dispose();
    }//GEN-LAST:event_btnRegistrarPedidoActionPerformed

    private void btnListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPedidosActionPerformed
        listarPedidos.setUsuario(usuario);
        listarPedidos.abrirVentana();
        dispose();
    }//GEN-LAST:event_btnListarPedidosActionPerformed

    private void btnVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosActionPerformed
        recepcionPedidos.abrirVentana();
        dispose();
    }//GEN-LAST:event_btnVerPedidosActionPerformed

    private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionActionPerformed
        abrirLogin();
    }//GEN-LAST:event_cerrarSesionActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void btnVerInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInventarioActionPerformed
        verInventario.abrirVentana();
        dispose();
    }//GEN-LAST:event_btnVerInventarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarPedidos;
    private javax.swing.JButton btnRegistrarPedido;
    private javax.swing.JButton btnVerInventario;
    private javax.swing.JButton btnVerPedidos;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JLabel txfBienvenido;
    private javax.swing.JLabel txfFecha;
    // End of variables declaration//GEN-END:variables
}
