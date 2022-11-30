package gui;

import entidades.Tablero;
import entidades.Tarea;
import entidades.Usuario;
import interfaces.INegocios;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class NuevaTareaDialog extends javax.swing.JDialog {

    private INegocios negocios;
    private Integer estado;
    private List<Usuario> usuarios;
    Tarea tarea;
    private Integer tipo;
	private Usuario usuario;
    private Tablero tablero;

    public NuevaTareaDialog(java.awt.Frame parent, boolean modal, INegocios negocios, Integer estado, Integer tipo, Tarea tarea, Usuario usuario, Tablero tablero) {
        super(parent, modal);
        initComponents();
        this.negocios = negocios;
        this.estado = estado;
        this.usuarios = negocios.consultarUsuarios();
        this.tarea = tarea;
        this.tipo = tipo;
        this.usuario = usuario;
        this.tablero = tablero;
        switch (tipo) {
            case 0:
                configurarVer();
                break;

            case 1:
                configurarAgregar();
                break;
        }

        llenarCmbBoxUsuarios();
        setVisible(true);
    }

    private void agregarTarea() {
        Tarea tarea = new Tarea();
        tarea.setTitulo(this.txtTitulo.getText());
        tarea.setDescripcion(this.txtDescripcion.getText());
	tarea.setFechaLim(Date.from(this.fechaPicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        tarea.setUsuario((Usuario) this.cmbBoxUsuarios.getSelectedItem());
        tarea.setEstado(this.estado);
        tarea.setTablero(tablero);
        try {
            negocios.agregarTarea(tarea);
            JOptionPane.showMessageDialog(null, "Se ha guardado la tarea correctamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarTarea() {
        Tarea tarea = negocios.consultarTarea(this.tarea.getId());
        tarea.setTitulo(this.txtTitulo.getText());
        tarea.setDescripcion(this.txtDescripcion.getText());
        if (this.fechaPicker.getDate() != null) {
            tarea.setFechaLim(java.sql.Date.valueOf(this.fechaPicker.getDate()));
        } else {
            tarea.setFechaLim(null);
        }
        tarea.setUsuario((Usuario) this.cmbBoxUsuarios.getSelectedItem());
        tarea.setEstado(this.estado);
        try {
            negocios.actualizarTarea(tarea);
            JOptionPane.showMessageDialog(null, "Se ha actualizado la tarea correctamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarTarea() {
        try {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la tarea?", "Eliminar Tarea", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                negocios.eliminarTarea(tarea.getId());
                setVisible(false);
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        this.txtTitulo.setText("");
        this.txtDescripcion.setText("");
        this.fechaPicker.setText("");
        this.cmbBoxUsuarios.setSelectedIndex(0);
    }

    private void llenarCmbBoxUsuarios() {
        if (usuarios != null) {
            cmbBoxUsuarios.setModel(new DefaultComboBoxModel(usuarios.toArray()));
        }
    }

    private void llenarCampos(Tarea tarea) {
        txtTitulo.setText(tarea.getTitulo());
        txtDescripcion.setText(tarea.getDescripcion());
        fechaPicker.setDate(tarea.getFechaLim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cmbBoxUsuarios.setSelectedItem(tarea.getUsuario());
    }

    private void configurarVer() {
        this.setTitle("Ver Tarea");
        btnAceptar.setText("Aceptar");
        fechaPicker.setDate(null);
        deshabilitarEditarCampos();
        llenarCampos(tarea);
    }

    private void configurarAgregar() {
        this.setTitle("Nueva tarea");
        btnAceptar.setText("Aceptar");
        habilitarEditarCampos();
        ocultarBotonesLaterales();
        this.setSize(460, 350);
    }

    private void configuracionEditar() {
        tipo = 2;
        this.setTitle("Actualizar tarea");
        btnAceptar.setText("Actualizar");
        habilitarEditarCampos();
        ocultarBotonesLaterales();
    }

    private void configuracionEliminar() {
        tipo = 3;
        this.setTitle("Eliminar tarea");
        btnAceptar.setText("Eliminar");
        deshabilitarEditarCampos();
        ocultarBotonesLaterales();
    }

    private void habilitarEditarCampos() {
        btnLimpiar.setEnabled(true);
        btnCancelar.setEnabled(true);
        txtTitulo.setEditable(true);
        txtDescripcion.setEditable(true);
        fechaPicker.setEnabled(true);
        cmbBoxUsuarios.setEnabled(true);
    }

    private void deshabilitarEditarCampos() {
        btnLimpiar.setEnabled(false);
        btnCancelar.setEnabled(false);
        txtTitulo.setEditable(false);
        txtDescripcion.setEditable(false);
        fechaPicker.setEnabled(false);
        cmbBoxUsuarios.setEnabled(false);
    }

    private void ocultarBotonesLaterales() {
        btnEditar.setVisible(false);
        btnEditar.setEnabled(false);
        btnEliminar.setVisible(false);
        btnEliminar.setEnabled(false);
        btnComentarios.setVisible(false);
        btnComentarios.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTarea = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        cmbBoxUsuarios = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        lblTarea1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblTarea2 = new javax.swing.JLabel();
        fechaPicker = new com.github.lgooddatepicker.components.DatePicker();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnComentarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTarea.setText("Título");

        lblUsuario.setText("Usuario");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblTarea1.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        lblTarea2.setText("Fecha");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnComentarios.setText("Comentarios");
        btnComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTarea2)
                            .addComponent(lblTarea1)
                            .addComponent(lblTarea)
                            .addComponent(lblUsuario))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbBoxUsuarios, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(fechaPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnComentarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnComentarios)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTarea)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblTarea1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTarea2)
                                    .addComponent(fechaPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(cmbBoxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnAceptar)
                            .addComponent(btnLimpiar))
                        .addGap(27, 27, 27))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        switch (tipo) {
            case 0:
                setVisible(false);
                dispose();
                break;

            case 1:
                agregarTarea();
                break;

            case 2:
                editarTarea();
                break;

            case 3:
                eliminarTarea();
                break;
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        configuracionEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarTarea();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentariosActionPerformed
        this.setVisible(false);
		Comentarios comentarios = new Comentarios(negocios, tarea,usuario);
		comentarios.setVisible(true);
    }//GEN-LAST:event_btnComentariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComentarios;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbBoxUsuarios;
    private com.github.lgooddatepicker.components.DatePicker fechaPicker;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTarea;
    private javax.swing.JLabel lblTarea1;
    private javax.swing.JLabel lblTarea2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
