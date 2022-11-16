package gui;

import entidades.Tarea;
import entidades.Usuario;
import implementaciones.Negocios;
import interfaces.INegocios;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Board extends javax.swing.JFrame {

    private Integer POR_HACER = 0;
    private Integer EN_PROGRESO = 1;
    private Integer REALIZADO = 2;

    private List<Tarea> listaPorHacer;
    private List<Tarea> listaEnProgreso;
    private List<Tarea> listaRealizado;
    private INegocios negocios;

    public Board() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);

        this.listaPorHacer = new ArrayList<>();
        this.listaEnProgreso = new ArrayList<>();
        this.listaRealizado = new ArrayList<>();
        this.negocios = new Negocios();
        this.listaPorHacer = negocios.consultarTareasPorHacer();

        if (listaPorHacer != null) {
            llenarTablaPorHacer();
        }

        llenarTablaEnProgreso();
        llenarTablaRealizado();
        agregarListener();
    }

    private void verTarea(MouseEvent me) {
        this.listaPorHacer = negocios.consultarTareasPorHacer();
        JTable target = (JTable) me.getSource();
        int row = target.getSelectedRow();
        Tarea tarea = listaPorHacer.get(row);
        NuevaTareaDialog tareaDlg = new NuevaTareaDialog(this, true, negocios, POR_HACER, 0, tarea);
        llenarTablaPorHacer();
    }

    private void llenarTablaPorHacer() {
        this.listaPorHacer = negocios.consultarTareasPorHacer();
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaPorHacer.getModel();
        modeloTabla.setRowCount(0);
        listaPorHacer.forEach(tarea -> {
            Object[] fila = new Object[2];
            if (tarea != null) {
                fila[0] = tarea.getTitulo();
                fila[1] = tarea.getUsuario().getNombre();
                modeloTabla.addRow(fila);
            }
        });
    }

    private void llenarTablaEnProgreso() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaEnProgreso.getModel();
        modeloTabla.setRowCount(0);
        listaEnProgreso.forEach(tarea -> {
            Object[] fila = new Object[2];
            fila[0] = tarea.getTitulo();
            fila[1] = tarea.getUsuario().getNombre();
            modeloTabla.addRow(fila);
        });
    }

    private void llenarTablaRealizado() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaRealizado.getModel();
        modeloTabla.setRowCount(0);
        listaRealizado.forEach(tarea -> {
            Object[] fila = new Object[2];
            fila[0] = tarea.getTitulo();
            fila[1] = tarea.getUsuario().getNombre();
            modeloTabla.addRow(fila);
        });
    }

    public void eliminarPorHacer() {
        int row = tablaPorHacer.getSelectedRow();
        Tarea tarea = listaPorHacer.get(row);
        int tareaEliminar = 0;
        for (int i = 0; i < listaPorHacer.size(); i++) {
            Tarea tareaLista = listaPorHacer.get(i);
            if (Objects.equals(tareaLista.getId(), tarea.getId())) {
                negocios.eliminarTarea(tarea.getId());
                tareaEliminar = i;
            }
        }
        listaPorHacer.remove(tareaEliminar);
        llenarTablaPorHacer();
    }

    private void agregarListener() {
        tablaPorHacer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    verTarea(me);
                }
            }
        });
    }

//    public void eliminarEnProgreso() {
//        int row = tablaEnProgreso.getSelectedRow();
//        String tarea = tablaEnProgreso.getModel().getValueAt(row, 0).toString();
//        String usuario = tablaEnProgreso.getModel().getValueAt(row, 1).toString();
//        int tareaEliminar = 0;
//        for (int i = 0; i < listaEnProgreso.size(); i++) {
//            Tarea tareaLista = listaEnProgreso.get(i);
//            if (tareaLista.getNombre().equalsIgnoreCase(tarea) && tareaLista.getUsuario().equalsIgnoreCase(usuario)) {
//                tareaEliminar = i;
//            }
//        }
//        listaEnProgreso.remove(tareaEliminar);
//        llenarTablaEnProgreso();
//    }
//    
//    public void eliminarRealizado() {
//        int row = tablaRealizado.getSelectedRow();
//        String tarea = tablaRealizado.getModel().getValueAt(row, 0).toString();
//        String usuario = tablaRealizado.getModel().getValueAt(row, 1).toString();
//        int tareaEliminar = 0;
//        for (int i = 0; i < listaRealizado.size(); i++) {
//            Tarea tareaLista = listaRealizado.get(i);
//            if (tareaLista.getNombre().equalsIgnoreCase(tarea) && tareaLista.getUsuario().equalsIgnoreCase(usuario)) {
//                tareaEliminar = i;
//            }
//        }
//        listaRealizado.remove(tareaEliminar);
//        llenarTablaRealizado();
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPorHacerToProgreso = new javax.swing.JButton();
        btnProgresoToPorHacer = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCrearPorHacer = new javax.swing.JButton();
        btnEliminarPorHacer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPorHacer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnCrearEnProgreso = new javax.swing.JButton();
        btnEliminarEnProgreso = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEnProgreso = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnCrearRealizado = new javax.swing.JButton();
        btnEliminarRealizado = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRealizado = new javax.swing.JTable();
        btnRealizadoToProgreso = new javax.swing.JButton();
        btnProgresoToRealizado = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuAdministrar = new javax.swing.JMenu();
        administrarUsuariosItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kanban Board");
        setResizable(false);

        btnPorHacerToProgreso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPorHacerToProgreso.setText("→");

        btnProgresoToPorHacer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnProgresoToPorHacer.setText("←");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCrearPorHacer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCrearPorHacer.setText("+");
        btnCrearPorHacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPorHacerActionPerformed(evt);
            }
        });

        btnEliminarPorHacer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnEliminarPorHacer.setText("-");
        btnEliminarPorHacer.setPreferredSize(new java.awt.Dimension(28, 28));
        btnEliminarPorHacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPorHacerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Por hacer");

        tablaPorHacer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tarea", "Asignado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPorHacer);
        if (tablaPorHacer.getColumnModel().getColumnCount() > 0) {
            tablaPorHacer.getColumnModel().getColumn(0).setResizable(false);
            tablaPorHacer.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(btnCrearPorHacer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarPorHacer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel1)))
                        .addGap(0, 137, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCrearPorHacer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPorHacer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCrearEnProgreso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCrearEnProgreso.setText("+");
        btnCrearEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEnProgresoActionPerformed(evt);
            }
        });

        btnEliminarEnProgreso.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnEliminarEnProgreso.setText("-");
        btnEliminarEnProgreso.setPreferredSize(new java.awt.Dimension(28, 28));
        btnEliminarEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEnProgresoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("En progreso");

        tablaEnProgreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tarea", "Asignado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaEnProgreso);
        if (tablaEnProgreso.getColumnModel().getColumnCount() > 0) {
            tablaEnProgreso.getColumnModel().getColumn(0).setResizable(false);
            tablaEnProgreso.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(btnCrearEnProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarEnProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel2)))
                        .addGap(0, 137, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCrearEnProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarEnProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCrearRealizado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCrearRealizado.setText("+");
        btnCrearRealizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRealizadoActionPerformed(evt);
            }
        });

        btnEliminarRealizado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnEliminarRealizado.setText("-");
        btnEliminarRealizado.setPreferredSize(new java.awt.Dimension(28, 28));
        btnEliminarRealizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRealizadoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Realizado");

        tablaRealizado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tarea", "Asignado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaRealizado);
        if (tablaRealizado.getColumnModel().getColumnCount() > 0) {
            tablaRealizado.getColumnModel().getColumn(0).setResizable(false);
            tablaRealizado.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(btnCrearRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel3)
                        .addGap(160, 160, 160)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCrearRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        btnRealizadoToProgreso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRealizadoToProgreso.setText("←");

        btnProgresoToRealizado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnProgresoToRealizado.setText("→");

        menuAdministrar.setText("Administrar");

        administrarUsuariosItem.setText("Usuarios");
        administrarUsuariosItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarUsuariosItemActionPerformed(evt);
            }
        });
        menuAdministrar.add(administrarUsuariosItem);

        menu.add(menuAdministrar);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProgresoToPorHacer)
                    .addComponent(btnPorHacerToProgreso))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRealizadoToProgreso)
                    .addComponent(btnProgresoToRealizado))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPorHacerToProgreso)
                                .addGap(18, 18, 18)
                                .addComponent(btnProgresoToPorHacer))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnProgresoToRealizado)
                                .addGap(18, 18, 18)
                                .addComponent(btnRealizadoToProgreso)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPorHacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPorHacerActionPerformed
        NuevaTareaDialog tareaDlg = new NuevaTareaDialog(this, true, negocios, POR_HACER, 1, null);
        this.listaPorHacer = negocios.consultarTareasPorHacer();
        llenarTablaPorHacer();
        this.listaPorHacer = negocios.consultarTareasPorHacer();
    }//GEN-LAST:event_btnCrearPorHacerActionPerformed

    private void btnCrearEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEnProgresoActionPerformed
        NuevaTareaDialog tareaDlg = new NuevaTareaDialog(this, true, negocios, EN_PROGRESO, 1, null);
        llenarTablaEnProgreso();
        this.listaPorHacer = negocios.consultarTareasPorHacer();
    }//GEN-LAST:event_btnCrearEnProgresoActionPerformed

    private void btnCrearRealizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRealizadoActionPerformed
        NuevaTareaDialog tareaDlg = new NuevaTareaDialog(this, true, negocios, REALIZADO, 1, null);
        llenarTablaRealizado();
    }//GEN-LAST:event_btnCrearRealizadoActionPerformed

    private void btnEliminarPorHacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPorHacerActionPerformed
        eliminarPorHacer();
    }//GEN-LAST:event_btnEliminarPorHacerActionPerformed

    private void btnEliminarEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEnProgresoActionPerformed
//        eliminarEnProgreso();
    }//GEN-LAST:event_btnEliminarEnProgresoActionPerformed

    private void btnEliminarRealizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRealizadoActionPerformed
//        eliminarRealizado();
    }//GEN-LAST:event_btnEliminarRealizadoActionPerformed

    private void administrarUsuariosItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarUsuariosItemActionPerformed
        AdministrarUsuarioDialog  adminUsuarioDlg = new AdministrarUsuarioDialog(this, true, negocios);
    }//GEN-LAST:event_administrarUsuariosItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem administrarUsuariosItem;
    private javax.swing.JButton btnCrearEnProgreso;
    private javax.swing.JButton btnCrearPorHacer;
    private javax.swing.JButton btnCrearRealizado;
    private javax.swing.JButton btnEliminarEnProgreso;
    private javax.swing.JButton btnEliminarPorHacer;
    private javax.swing.JButton btnEliminarRealizado;
    private javax.swing.JButton btnPorHacerToProgreso;
    private javax.swing.JButton btnProgresoToPorHacer;
    private javax.swing.JButton btnProgresoToRealizado;
    private javax.swing.JButton btnRealizadoToProgreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAdministrar;
    private javax.swing.JTable tablaEnProgreso;
    private javax.swing.JTable tablaPorHacer;
    private javax.swing.JTable tablaRealizado;
    // End of variables declaration//GEN-END:variables
}
