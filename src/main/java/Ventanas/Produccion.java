/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Usos.ConexionBDR;
import Usos.Leer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Produccion extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    public Produccion() {
        initComponents();
        RefrescarTablaEmpleados("empleados");
        Leer.transparenciaBoton(jBotonAtras);
        this.setLocationRelativeTo(null);
    }

    public void RefrescarTablaEmpleados(String tabla) {
        String sql = "select * from " + tabla;
        Statement st;
        ConexionBDR con = new ConexionBDR();
        Connection ConexionBDR = con.conectar();
        System.out.println(sql);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Puesto");
        model.addColumn("Salario");
        model.addColumn("Fecha Contratacion");
        model.addColumn("Estado");
        visor.setModel(model);

        String[] datos = new String[6];
        try {
            st = ConexionBDR.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    // Método para mostrar la producción de un empleado
    public void mostrarProduccionPorEmpleado(String idEmpleado) {
         // Modificamos la consulta SQL para obtener los datos que necesitas
    String sql = "SELECT p.id, e.nombre, p.producto, p.cantidad, p.estado, p.fecha_inicio, p.fecha_fin " +
                 "FROM produccion p " +
                 "JOIN empleados e ON p.empleado_id = e.id " +
                 "WHERE p.empleado_id = " + idEmpleado;
    
    Statement st;
    ConexionBDR con = new ConexionBDR();
    Connection conexionBDR = con.conectar();
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Produccion");
    model.addColumn("Empleado");
    model.addColumn("Producto");
    model.addColumn("Cantidad");
    model.addColumn("Estado");
    model.addColumn("Fecha Inicio");
    model.addColumn("Fecha Fin");
    TablaProComple.setModel(model);

    String[] datos = new String[7]; // Ahora tenemos 7 columnas
    try {
        st = conexionBDR.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            datos[0] = rs.getString("id");
            datos[1] = rs.getString("nombre");  // Nombre del empleado
            datos[2] = rs.getString("producto");  // Nombre del producto
            datos[3] = rs.getString("cantidad");
            datos[4] = rs.getString("estado");
            datos[5] = rs.getString("fecha_inicio");
            datos[6] = rs.getString("fecha_fin");
            model.addRow(datos);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.toString());
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogo1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        anadirUsuario = new javax.swing.JButton();
        jempleado = new javax.swing.JTextField();
        jcantidad = new javax.swing.JTextField();
        jestado = new javax.swing.JComboBox<>();
        jproducto = new javax.swing.JComboBox<>();
        jfechaInicio = new javax.swing.JTextField();
        jfechaFin = new javax.swing.JTextField();
        resetear = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jBotonAtras = new javax.swing.JButton();
        jID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProComple = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        fondoprincipal = new javax.swing.JLabel();

        jLabelLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoGestiCor.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("[Empleado]");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel4.setText("[Cantidad] ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel6.setText("[Fecha Inicio]");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel7.setText("[Estado]");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel8.setText("[Fecha Fin]");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jLabel9.setText("[Producto]");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        anadirUsuario.setText("Añadir");
        anadirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(anadirUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, -1));

        jempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jempleadoActionPerformed(evt);
            }
        });
        jPanel1.add(jempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 90, -1));

        jcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcantidadActionPerformed(evt);
            }
        });
        jPanel1.add(jcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 90, -1));

        jestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Finalizado", "En Proceso" }));
        jPanel1.add(jestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 90, -1));

        jproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bandejas", "Cajones", "Pales" }));
        jPanel1.add(jproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 90, -1));

        jfechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfechaInicioActionPerformed(evt);
            }
        });
        jPanel1.add(jfechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 90, -1));

        jfechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfechaFinActionPerformed(evt);
            }
        });
        jPanel1.add(jfechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 90, -1));

        resetear.setText("Resetear");
        resetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetearActionPerformed(evt);
            }
        });
        jPanel1.add(resetear, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 90, 30));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 80, 30));

        modificar.setText("Modificar");
        jPanel1.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 90, 30));

        jBotonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        jBotonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(jBotonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, -1));

        jID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDActionPerformed(evt);
            }
        });
        jPanel1.add(jID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 90, -1));

        jLabel14.setText("[ID]");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        TablaProComple.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Produccion", "Empleado", "Producto", "Cantidad", "Estado", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProComple.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProCompleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaProComple);
        TablaProComple.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 580, 70));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel3.setText("GESTIÓN DE PRODUCCION GESTICOR");
        jLabel3.setMaximumSize(new java.awt.Dimension(280, 20));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 480, 80));

        jLabel10.setText("Formulario De Producción");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 170, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RecuaGris.jpg"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, 340));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoPanel.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 450, 70));

        jLabel1.setText("Consulta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 50, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gradient_800_600.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 600, 100));

        visor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Puesto", "Salario", "Fecha Contratacion", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        visor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(visor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 600, 230));

        jLabel13.setText("Informacion Del Empleado");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        fondoprincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gradient_1920_1080.png"))); // NOI18N
        jPanel1.add(fondoprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 940, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonAtrasActionPerformed
        // TODO add your handling code here:
        Eleccion abrir = new Eleccion();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBotonAtrasActionPerformed

    private void jfechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfechaInicioActionPerformed

    private void jfechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jfechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jfechaFinActionPerformed

    private void jempleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jempleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jempleadoActionPerformed

    private void jcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcantidadActionPerformed

    private void anadirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirUsuarioActionPerformed
        String nombreEmpleado = jempleado.getText();
        String cantTexto = jcantidad.getText();
        String estadoProd = (String) jestado.getSelectedItem();
        String fechaInicioTexto = jfechaInicio.getText();
        String fechaFinTexto = jfechaFin.getText();

        if (nombreEmpleado.isEmpty() || cantTexto.isEmpty() || fechaInicioTexto.isEmpty() || fechaFinTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
            return;
        }

        try {
            int cantidadValor = Integer.parseInt(cantTexto);
            boolean resultado = Controlador.ControladorProducción.añadir(nombreEmpleado, cantidadValor, estadoProd, fechaInicioTexto, fechaFinTexto);
            if (resultado) {
                JOptionPane.showMessageDialog(null, "Producción añadida correctamente.");
                RefrescarTablaEmpleados("empleados");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero.");
        }
    }//GEN-LAST:event_anadirUsuarioActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarActionPerformed

    private void visorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visorMouseClicked
         int filaSeleccionada = visor.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun empleado.");
    } else {
        // Obtener el ID del empleado seleccionado
        String idEmpleado = visor.getValueAt(filaSeleccionada, 0).toString();
        
        // Llamar al método para mostrar la producción del empleado
        mostrarProduccionPorEmpleado(idEmpleado);
    }
    }//GEN-LAST:event_visorMouseClicked

    private void resetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetearActionPerformed
//        jTexto.setText("");
//        jTextoNombre.setText("");
//        jTextoPuesto.setText("");
//        jTextoSalario.setText(String.valueOf(""));
//        jComboBoxEstado.setSelectedItem(-1);
    }//GEN-LAST:event_resetearActionPerformed

    private void jIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDActionPerformed

    private void TablaProCompleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProCompleMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = TablaProComple.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun empleado.");
        } else {
            // Cogemos los valores que estan la fila seleccionada
            String idStr = TablaProComple.getValueAt(filaSeleccionada, 0).toString();
            String empleado = (String) TablaProComple.getValueAt(filaSeleccionada, 1);
            String tipoProducto = (String) TablaProComple.getValueAt(filaSeleccionada, 2);
            String cantidad = (String) TablaProComple.getValueAt(filaSeleccionada, 3);
            String estado = (String) TablaProComple.getValueAt(filaSeleccionada, 4);
            String fechaInicio = (String) TablaProComple.getValueAt(filaSeleccionada, 5);
            String fechaFin = (String) TablaProComple.getValueAt(filaSeleccionada, 6);
            
            //double salario = Double.parseDouble((String) visor.getValueAt(filaSeleccionada, 3).toString());
            //String fechaContratacion = (String) visor.getValueAt(filaSeleccionada,4);
            
            
            // Se establecen los datos que han sido seleccionados previamente
            jID.setText(idStr);
            jempleado.setText(empleado);
            jproducto.setSelectedItem(tipoProducto);
            jcantidad.setText(cantidad);
            jestado.setSelectedItem(estado);
            jfechaInicio.setText(fechaInicio);
            jfechaFin.setText(fechaFin);
}

    }//GEN-LAST:event_TablaProCompleMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProComple;
    private javax.swing.JButton anadirUsuario;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fondoprincipal;
    private javax.swing.JButton jBotonAtras;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLogo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jcantidad;
    private javax.swing.JTextField jempleado;
    private javax.swing.JComboBox<String> jestado;
    private javax.swing.JTextField jfechaFin;
    private javax.swing.JTextField jfechaInicio;
    private javax.swing.JComboBox<String> jproducto;
    private javax.swing.JButton modificar;
    private javax.swing.JButton resetear;
    public javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
