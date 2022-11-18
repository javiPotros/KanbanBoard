package gui;

import entidades.Usuario;
import interfaces.INegocios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdministrarUsuarioDialog extends javax.swing.JFrame {

    private INegocios negocios;

    public AdministrarUsuarioDialog(java.awt.Frame parent, boolean modal, INegocios negocios) {
        initComponents();
        this.setTitle("Administrar Usuario");
        this.negocios = negocios;
        this.llenarTabla();
        this.llenarCmbBoxRoles();
        setVisible(true);
    }

    private void llenarCmbBoxRoles() {
        List<String> listaRoles = new ArrayList<>();
        listaRoles.add("-Seleccionar-");
        listaRoles.add("admin");
        listaRoles.add("manager");
        listaRoles.add("developer");
        listaRoles.add("tester");
        this.cbRoles.setModel(new DefaultComboBoxModel(listaRoles.toArray()));
    }

    private void guardar() {
        if (this.txtID.getText().isEmpty()) {
            this.agregar();
        } else {
            this.actualizar();
        }
    }

    private void agregar() {
        try {
            String nombre = this.txtNombre.getText();
            String correo = this.txtCorreo.getText();
            String contrasenha = this.txtContrasenha.getText();
            String rol = this.cbRoles.getSelectedItem().toString();
            Usuario seAgregoUsuario = this.negocios.agregarUsuario(new Usuario(nombre, rol, correo, contrasenha));
            JOptionPane.showMessageDialog(this, "Se agregó el nuevo usuario", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);;
        }
    }

    private void actualizar() {
        try {
            Long idUsuario = Long.parseLong(this.txtID.getText());
            String nombre = this.txtNombre.getText();
            String correo = this.txtCorreo.getText();
            String contrasenha = this.txtContrasenha.getText();
            String rol = this.cbRoles.getSelectedItem().toString();
            this.negocios.actualizarUsuario(new Usuario(idUsuario, nombre, rol, correo, contrasenha));
            JOptionPane.showMessageDialog(this, "Se actualizó el usuario", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
            this.llenarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);;
        }
    }

    private void editar() {
        Long idUsuarioSeleccionado = this.getIdSocioSeleccionado();
        if (idUsuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario", "Información", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Usuario usuario = this.negocios.consultarUsuario(idUsuarioSeleccionado);
        if (usuario != null) {
            this.llenarFormulario(usuario);
        }
    }

    private void eliminar() {
        Long idUsuarioSeleccionado = this.getIdSocioSeleccionado();
        if (idUsuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario", "Información", JOptionPane.WARNING_MESSAGE);
        } else {
            int opcionSeleccionada = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar al usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (opcionSeleccionada == JOptionPane.NO_OPTION) {
                return;
            }

            this.negocios.eliminarUsuario(idUsuarioSeleccionado);
            //JOptionPane.showMessageDialog(this, "Se eliminó el usuario correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.llenarTabla();
        }
    }

    private Long getIdSocioSeleccionado() {
        int indiceFilaSeleccionada = this.tblUsuarios.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblUsuarios.getModel();
            int indiceColumnaId = 0;
            Long idUsuarioSeleccionado = (Long) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            return idUsuarioSeleccionado;
        } else {
            return null;
        }
    }

    private void llenarTabla() {
        List<Usuario> listaUsuarios = this.negocios.consultarUsuarios();
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblUsuarios.getModel();
        modeloTabla.setRowCount(0);
        listaUsuarios.forEach(usuario -> {
            Object[] fila = new Object[5];
            fila[0] = usuario.getId();
            fila[1] = usuario.getNombre();
            fila[2] = usuario.getCorreo();
            fila[3] = usuario.getContrasenha();
            fila[4] = usuario.getRol();
            modeloTabla.addRow(fila);
        });

    }

    private void llenarFormulario(Usuario usuario) {
        this.txtID.setText(usuario.getId().toString());
        this.txtNombre.setText(usuario.getNombre());
        this.txtCorreo.setText(usuario.getCorreo());
        this.txtContrasenha.setText(usuario.getContrasenha());
        this.cbRoles.setSelectedItem(usuario.getRol());
    }

    private void limpiarFormulario() {
        this.txtID.setText("");
        this.txtNombre.setText("");
        this.txtCorreo.setText("");
        this.txtContrasenha.setText("");
        this.cbRoles.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEditar = new javax.swing.JButton();
        lblSocioID = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        lblContrasenha = new javax.swing.JLabel();
        txtContrasenha = new javax.swing.JTextField();
        lblRol = new javax.swing.JLabel();
        cbRoles = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnEditar.setText("Editar");
        btnEditar.setFocusable(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lblSocioID.setText("Id Usuario");

        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre");

        lblCorreo.setText("Correo");

        txtID.setEditable(false);
        txtID.setFocusable(false);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Usuario", "Nombre", "Correo", "Contraseña", "Rol"
            }
        ));
        jScrollPane1.setViewportView(tblUsuarios);

        lblContrasenha.setText("Contraseña");

        lblRol.setText("Rol");

        cbRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSocioID)
                    .addComponent(lblNombre)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCorreo)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID)
                            .addComponent(txtNombre)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContrasenha)
                            .addComponent(lblRol))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtContrasenha, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar))
                            .addComponent(cbRoles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSocioID)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorreo)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContrasenha)
                            .addComponent(txtContrasenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRol)
                            .addComponent(cbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnLimpiar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiarFormulario();
    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbRoles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContrasenha;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblSocioID;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtContrasenha;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
