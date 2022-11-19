package gui;

import entidades.Comentario;
import entidades.Tarea;
import interfaces.INegocios;

public class Comentarios extends javax.swing.JFrame {
	private INegocios negocios;
	private Long id;
	public Comentarios(INegocios negocios, Tarea tarea) {
		initComponents();
		 this.negocios = negocios;
		 this.id = tarea.getId();
		 llenarComentarios();
	}
	
	public void llenarComentarios(){
		Tarea tarea = negocios.consultarTarea(id);
		String mensaje="";
		for (Comentario com : tarea.getComentario()) {
			mensaje += com.getMensajero() +": "+ com.getMensaje() + "\n";
		}
		this.txtComentarios.setText(mensaje);
	}
	
	public void limpiarChat(){
		this.txtChat.setText("");
	}
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        txtChat = new javax.swing.JTextField();
        btnComentar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtComentarios.setEditable(false);
        txtComentarios.setColumns(20);
        txtComentarios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtComentarios.setRows(5);
        jScrollPane1.setViewportView(txtComentarios);

        txtChat.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnComentar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnComentar.setText("Comentar");
        btnComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnComentar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComentar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentarActionPerformed
	this.txtComentarios.setText("");
	String mensaje = this.txtChat.getText();
	String mensajero = "admin";
	Tarea tarea = negocios.consultarTarea(id);
	Comentario comentario = new Comentario(tarea, mensajero, mensaje);
	negocios.agregarComentario(comentario);
	limpiarChat();
	llenarComentarios();
    }//GEN-LAST:event_btnComentarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComentar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtChat;
    private javax.swing.JTextArea txtComentarios;
    // End of variables declaration//GEN-END:variables
}
