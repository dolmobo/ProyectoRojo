/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Usos.ConexionBDR;
import Controlador.ControladorEmpleados;
import Usos.AutenticadorBDO;
import Usos.Leer;
import Usos.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Usuarios extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    public Usuarios() {
        initComponents();
        cargarUsuariosEnTabla();
        this.setLocationRelativeTo(null);
        Leer.transparenciaBoton(jBotonAtras);

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBotonAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jAñadir = new javax.swing.JButton();
        jEliminar = new javax.swing.JButton();
        jPanelDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jUsuarioLogin = new javax.swing.JTextField();
        jContraseñaLogin = new javax.swing.JTextField();
        jComboRol = new javax.swing.JComboBox<>();
        jButtonRefrescar = new javax.swing.JButton();
        fondoprincipal = new javax.swing.JLabel();

        jLabelLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoGestiCor.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("GESTIÓN DE USUARIOS GESTICOR");
        jLabel3.setMaximumSize(new java.awt.Dimension(280, 20));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -10, 450, 80));

        jLabel4.setFont(new java.awt.Font("Georgia Pro", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("¡Le damos la Bienvenida Administrador/a!");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 310, 20));

        jBotonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        jBotonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(jBotonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, -1));

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Contraseña", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 510, 380));

        jAñadir.setText("Añadir");
        jAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAñadirMouseClicked(evt);
            }
        });
        jAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAñadirActionPerformed(evt);
            }
        });
        jPanel1.add(jAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 80, -1));

        jEliminar.setText("Eliminar");
        jEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 80, -1));

        jLabel2.setText("Nombre:");

        jLabel5.setText("Contraseña:");

        jLabel7.setText("Estado:");

        jComboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "usuario" }));
        jComboRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboRol, 0, 159, Short.MAX_VALUE)
                    .addComponent(jUsuarioLogin)
                    .addComponent(jContraseñaLogin))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jContraseñaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 240, 130));

        jButtonRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        jButtonRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefrescarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 70, -1));

        fondoprincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gradient_800_600.png"))); // NOI18N
        jPanel1.add(fondoprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void cargarUsuariosEnTabla() {
    // Obtener los usuarios de la base de datos
    List<User> usuarios = AutenticadorBDO.obtenerTodosLosUsuariosLogIn();

    // Crear el modelo de la tabla
    DefaultTableModel model = new DefaultTableModel();
    
    // Añadir las columnas
    model.addColumn("Usuario");
    model.addColumn("Contraseña");
    model.addColumn("Rol");

    // Asignar el modelo a la JTable
    jTableUsuarios.setModel(model);

    // Llenar los datos de la tabla
    for (User u : usuarios) {
        String[] datos = new String[3];
        datos[0] = u.getNombreUsuario();
        datos[1] = u.getContraseña(); // ¡Cuidado con mostrar contraseñas reales!
        datos[2] = u.getRol();
        model.addRow(datos); // Añadir la fila al modelo
    }
}


    private void jBotonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonAtrasActionPerformed
        // TODO add your handling code here:
        Eleccion abrir = new Eleccion();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBotonAtrasActionPerformed

    private void jAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAñadirActionPerformed

    }//GEN-LAST:event_jAñadirActionPerformed

    private void jEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarActionPerformed
        String usuario = jUsuarioLogin.getText(); // o de otro campo si tienes uno para eliminar

    if (AutenticadorBDO.eliminarUsuario(usuario)) {
        JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
    } else {
        JOptionPane.showMessageDialog(this, "El usuario no existe o no pudo ser eliminado.");
    }
    }//GEN-LAST:event_jEliminarActionPerformed

    private void jButtonRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefrescarActionPerformed
    cargarUsuariosEnTabla();
    }//GEN-LAST:event_jButtonRefrescarActionPerformed

    private void jComboRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboRolActionPerformed

    private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMouseClicked
        // TODO add your handling code here:
        
        int filaSeleccionada = jTableUsuarios.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun empleado.");
        } else {
            // Cogemos los valores que estan la fila seleccionada
            String usuario = jTableUsuarios.getValueAt(filaSeleccionada, 0).toString();  
            String contraseña = (String) jTableUsuarios.getValueAt(filaSeleccionada,1);
            String rolSeleccionado = (String) jTableUsuarios.getValueAt(filaSeleccionada, 2);
            
            // Se establecen los datos que han sido seleccionados previamente
            jUsuarioLogin.setText(usuario);
            jContraseñaLogin.setText(contraseña);
            jComboRol.setSelectedItem(rolSeleccionado);
        }

    }//GEN-LAST:event_jTableUsuariosMouseClicked

    private void jAñadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAñadirMouseClicked
        // TODO add your handling code here:

        //Recoge toda la informacion para añadir al usuario
        
        String usuario = jUsuarioLogin.getText();
        String contrasena = new String(jContraseñaLogin.getText());
        String rolSeleccionado = jComboRol.getSelectedItem().toString(); // o jRolInput.getText();

        // Si ya existe usuario, te salta un mensaje emergente.
        if (AutenticadorBDO.existeUsuario(usuario)) {
            JOptionPane.showMessageDialog(this, "El usuario ya existe. Intenta con otro.");
        } else {
        
        // Si no existe, lo crea.
            User nuevoUsuario = new User(usuario, contrasena, rolSeleccionado);
            AutenticadorBDO.insertarUsuario(nuevoUsuario);
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente con rol: " + rolSeleccionado);
            cargarUsuariosEnTabla();
        }
    }//GEN-LAST:event_jAñadirMouseClicked

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondoprincipal;
    private javax.swing.JButton jAñadir;
    private javax.swing.JButton jBotonAtras;
    private javax.swing.JButton jButtonRefrescar;
    private javax.swing.JComboBox<String> jComboRol;
    private javax.swing.JTextField jContraseñaLogin;
    private javax.swing.JButton jEliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelLogo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}
