package gui;

import entidades.Usuario;
import interfaces.INegocios;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdministrarUsuarioDialog extends javax.swing.JFrame {

    INegocios negocios;

    public AdministrarUsuarioDialog(java.awt.Frame parent, boolean modal, INegocios negocios) {
        initComponents();
        this.setTitle("Administrar Usuario");
        this.negocios = negocios;
        this.llenarTabla();
        setVisible(true);
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
            String rol = this.txtRol.getText();
            Usuario seAgregoUsuario = this.negocios.agregarUsuario(new Usuario(nombre, rol, correo, contrasenha));
            if (seAgregoUsuario != null) {
                JOptionPane.showMessageDialog(this, "Se agregó el nuevo socio", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.limpiarFormulario();
                this.llenarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No fue posible agregar el socio", "Información", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(AdministrarUsuarioDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizar() {
        Long idUsuario = Long.parseLong(this.txtID.getText());
        String nombre = this.txtNombre.getText();
        String correo = this.txtCorreo.getText();
        String contrasenha = this.txtContrasenha.getText();
        String rol = this.txtRol.getText();
        this.negocios.actualizarUsuario(new Usuario(idUsuario, nombre, rol, correo, contrasenha));
        JOptionPane.showMessageDialog(this, "Se actualizó el usuario", "Información", JOptionPane.INFORMATION_MESSAGE);
        this.limpiarFormulario();
        this.llenarTabla();

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
            JOptionPane.showMessageDialog(this, "Se eliminó el usuario correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
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
        this.txtRol.setText(usuario.getRol());
    }

    private void limpiarFormulario() {
        this.txtID.setText("");
        this.txtNombre.setText("");
        this.txtCorreo.setText("");
        this.txtContrasenha.setText("");
        this.txtRol.setText("");
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
        txtRol = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lblSocioID.setText("Id Usuario");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre");

        lblCorreo.setText("Correo");

        txtID.setEditable(false);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
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

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasenha, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContrasenha)
                                    .addComponent(txtContrasenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblRol)
                                    .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnGuardar)
                                    .addComponent(btnLimpiar))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRegresar)))))
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
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
    private javax.swing.JTextField txtRol;
    // End of variables declaration//GEN-END:variables
}
