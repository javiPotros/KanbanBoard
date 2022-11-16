/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import entidades.Usuario;
import implementaciones.Negocios;
import interfaces.INegocios;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author jjavi
 */
public class LogIn extends javax.swing.JDialog {

    private INegocios negocios;

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
        this.setTitle("Log In");
        this.setVisible(true);
        this.negocios = new Negocios();
    }

    private boolean validaCorreo(String correo) {
        Pattern patron = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        boolean emailValido = patron.matcher(correo).matches();
        if (correo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Introduzca un correo", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (correo.length() > 100) {
            JOptionPane.showMessageDialog(null, "El correo debe tener máximo 100 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (!emailValido) {
            JOptionPane.showMessageDialog(null, "Introduzca un correo válido", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validaPassword(String password) {
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Introduzca una contraseña", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (password.length() > 100) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener máximo 100 caracteres", "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogIn = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCorreo.setText("Correo");

        lblPassword.setText("Password");

        btnLogIn.setText("Log In");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setFocusable(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword)
                    .addComponent(lblCorreo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnLogIn)
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogIn)
                    .addComponent(btnLimpiar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.txtCorreo.setText("");
        this.txtPassword.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        if (validaCorreo(this.txtCorreo.getText()) && validaPassword(this.txtPassword.getText())) {
            Usuario usuario;
			try {
				usuario = negocios.consultarPorCorreoYContrasenha(txtCorreo.getText(), txtPassword.getText());
				if (usuario != null) {
					Board board = new Board(negocios, usuario);
					board.setVisible(true);
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(rootPane, "Usuario y/o Clave incorrecta");
				}
			} catch (Exception ex) {
				Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
			}
            
        }
    }//GEN-LAST:event_btnLogInActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
