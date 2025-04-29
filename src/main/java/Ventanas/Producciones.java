/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Controlador.ControladorEmpleados;
import Controlador.ControladorProducción;
import Modelo.Produccion;
import Usos.ConexionBDR;
import Usos.Leer;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Producciones extends javax.swing.JFrame {

    private ControladorEmpleados controladorEmpleados;
    private Object[][] matrizDatos;
    private String[] columnas = {"ID", "Nombre", "Puesto", "Salario", "Fecha Contratacion", "Estado"};
    private DefaultTableModel dtm;

    private ControladorProducción controladorproduccion;
    private Object[][] matrizDatosProduccion;
    private String[] columnaspro = {"ID Produccion", "Empleado", "Cantidad", "Producto", "Estado", "Fecha Inicio", "Fecha Fin"};
    private DefaultTableModel dtmpro;

    /**
     * Creates new form Empleados
     */
    public Producciones() {

        controladorEmpleados = new ControladorEmpleados();
        initComponents();
        this.setLocationRelativeTo(null);
        Leer.transparenciaBoton(jBotonAtras);

        // Inicializamos el modelo de tabla con las columnas vacías
        dtm = new DefaultTableModel(matrizDatos, columnas);
        visor.setModel(dtm);

        // Llenamos matrizDatos y actualizamos tabla
        actualizarMatrizDato();

        controladorproduccion = new ControladorProducción();
        // Inicializamos el modelo de tabla con las columnas vacías
        dtmpro = new DefaultTableModel(matrizDatosProduccion, columnaspro);
        TablaProComple.setModel(dtmpro);
        int idEmpleado = -1;

        // Llenamos matrizDatosProduccion y actualizamos tabla
        actualizarMatrizDatoProduccion(idEmpleado);

    }

    public void actualizarMatrizDato() {

        ConexionBDR con = new ConexionBDR();
        Connection conexion = con.conectar();

        String sql = "SELECT * FROM empleados";
        List<Object[]> datos = new ArrayList<>();

        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("puesto");
                fila[3] = rs.getInt("salario");
                fila[4] = rs.getString("fecha_contratacion");
                fila[5] = rs.getString("estado");
                datos.add(fila);
            }

            // Pasamos de lista a matriz
            matrizDatos = new Object[datos.size()][columnas.length];
            for (int i = 0; i < datos.size(); i++) {
                matrizDatos[i] = datos.get(i);
            }

            // Actualizamos el modelo de la tabla
            dtm.setDataVector(matrizDatos, columnas);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar empleados: " + e.getMessage());
        }
    }

    public void actualizarMatrizDatoProduccion(int idEmpleado) {
        if (idEmpleado < 0) {
            return;
        }

        //TablaProComple.setVisible(false);
        ConexionBDR con = new ConexionBDR();
        Connection conexion = con.conectar();

        String sql = "SELECT p.id, e.nombre, p.cantidad, p.producto, p.estado_f, p.fecha_inicio, p.fecha_fin "
                + "FROM produccion p "
                + "JOIN empleados e ON p.empleado_id = e.id "
                + "WHERE p.empleado_id = " + idEmpleado;

        List<Object[]> datos = new ArrayList<>();

        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getInt("cantidad");
                fila[3] = rs.getString("producto");
                fila[4] = rs.getString("estado_f");
                fila[5] = rs.getString("fecha_inicio");
                fila[6] = rs.getString("fecha_fin");
                datos.add(fila);
            }

            // Pasamos de lista a matriz
            matrizDatosProduccion = new Object[datos.size()][columnaspro.length];
            for (int i = 0; i < datos.size(); i++) {
                matrizDatosProduccion[i] = datos.get(i);
            }

            // Actualizamos el modelo de la tabla
            dtmpro.setDataVector(matrizDatosProduccion, columnaspro);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar empleados: " + e.getMessage());
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
        jestado_f = new javax.swing.JComboBox<>();
        jproducto = new javax.swing.JComboBox<>();
        jfechaInicio = new javax.swing.JTextField();
        jfechaFin = new javax.swing.JTextField();
        resetear = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jBotonAtras = new javax.swing.JButton();
        jID = new javax.swing.JTextField();
        jIDProduccion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProComple = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CargarDatosBin = new javax.swing.JButton();
        guardaDatosBin = new javax.swing.JButton();
        CargarDatosXML = new javax.swing.JButton();
        guardaDatosXML = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        fondoprincipal = new javax.swing.JLabel();

        jLabelLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoGestiCor.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("[Empleado]");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel4.setText("[Cantidad] ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel6.setText("[Fecha Inicio]");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel7.setText("[Estado]");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel8.setText("[Fecha Fin]");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel9.setText("[Producto]");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        anadirUsuario.setText("Añadir");
        anadirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(anadirUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 590, 80, 30));

        jempleado.setEditable(false);
        jempleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jempleadoActionPerformed(evt);
            }
        });
        jPanel1.add(jempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 120, -1));

        jcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcantidadActionPerformed(evt);
            }
        });
        jPanel1.add(jcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 120, -1));

        jestado_f.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Finalizado", "En Proceso" }));
        jPanel1.add(jestado_f, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 120, -1));

        jproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bandejas", "Cajones", "Palets" }));
        jproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jproductoActionPerformed(evt);
            }
        });
        jPanel1.add(jproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 120, -1));

        jfechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfechaInicioActionPerformed(evt);
            }
        });
        jPanel1.add(jfechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 120, -1));

        jfechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jfechaFinActionPerformed(evt);
            }
        });
        jPanel1.add(jfechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 120, -1));

        resetear.setText("Resetear");
        resetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetearActionPerformed(evt);
            }
        });
        jPanel1.add(resetear, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 90, 30));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 590, 80, 30));

        modificar.setText("Modificar");
        modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarMouseClicked(evt);
            }
        });
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel1.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 90, 30));

        jBotonAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        jBotonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(jBotonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, -1));

        jID.setEditable(false);
        jID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDActionPerformed(evt);
            }
        });
        jPanel1.add(jID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 120, -1));

        jIDProduccion.setEditable(false);
        jIDProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIDProduccionActionPerformed(evt);
            }
        });
        jPanel1.add(jIDProduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 120, -1));

        jLabel15.setText("[ID Produccion]");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel14.setText("[ID Empleado]");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        TablaProComple.setAutoCreateRowSorter(true);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TablaProCompleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TablaProCompleMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(TablaProComple);
        TablaProComple.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 680, 160));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel3.setText("GESTIÓN DE PRODUCCION GESTICOR");
        jLabel3.setMaximumSize(new java.awt.Dimension(280, 20));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 480, 80));

        jLabel10.setText("Formulario De Producción");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 170, -1));

        CargarDatosBin.setText("Cargar Datos  ");
        CargarDatosBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarDatosBinActionPerformed(evt);
            }
        });
        jPanel1.add(CargarDatosBin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, -1, 30));

        guardaDatosBin.setText("Guardar Datos");
        guardaDatosBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaDatosBinActionPerformed(evt);
            }
        });
        jPanel1.add(guardaDatosBin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, 30));

        CargarDatosXML.setText("Cargar Datos  ");
        CargarDatosXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarDatosXMLActionPerformed(evt);
            }
        });
        jPanel1.add(CargarDatosXML, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, 30));

        guardaDatosXML.setText("Guardar Datos");
        guardaDatosXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaDatosXMLActionPerformed(evt);
            }
        });
        jPanel1.add(guardaDatosXML, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 30));

        jLabel18.setText("BIN");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        jLabel17.setText("XML");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RecuaGris.jpg"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 280, 140));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoPanel.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, 450, 70));

        jLabel1.setText("Consulta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 50, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gradient_800_600.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 700, 200));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 700, 230));

        jLabel13.setText("Informacion Del Empleado");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RecuaGris.jpg"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 280, 300));

        fondoprincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gradient_1920_1080.png"))); // NOI18N
        jPanel1.add(fondoprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1030, 680));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        String idStr = jID.getText();
        String empleado = jempleado.getText();
        String producto = (String) jproducto.getSelectedItem();
        String cantidadStr = jcantidad.getText();
        String estado_f = (String) jestado_f.getSelectedItem();
        String fechaInicio = jfechaInicio.getText();
        String fechaFin = jfechaFin.getText();

        if (empleado.isEmpty() || cantidadStr.isEmpty() || fechaInicio.isEmpty() || fechaFin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadStr);
            boolean resultado = Controlador.ControladorProducción.añadir(idStr, cantidad, producto, estado_f, fechaInicio, fechaFin);

            if (resultado) {
                JOptionPane.showMessageDialog(null, "Producción añadida correctamente.");
                int idEmpleado = Integer.parseInt(jID.getText());
                actualizarMatrizDatoProduccion(idEmpleado);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero.");
        }

    }//GEN-LAST:event_anadirUsuarioActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        String idProduccion = jIDProduccion.getText();

        // Probar mas tarde a ver si funcionan juntas:
        String idEmpleado = jID.getText();
        String tipoProducto = (String) jproducto.getSelectedItem();
        String cantidad = jcantidad.getText();
        String estado = (String) jestado_f.getSelectedItem();
        //

        Controlador.ControladorProducción.eliminar(idProduccion);

        //mostrarProduccionPorEmpleado(idEmpleado);
    }//GEN-LAST:event_eliminarActionPerformed

    private void visorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visorMouseClicked
        int filaSeleccionada = visor.getSelectedRow();
        if (filaSeleccionada >= 0) {
            int idEmpleado = (int) visor.getValueAt(filaSeleccionada, 0); // columna 0 = ID
            // empleado
            String id = visor.getValueAt(filaSeleccionada, 0).toString();
            jID.setText(id);
            actualizarMatrizDatoProduccion(idEmpleado);

            String nombre = visor.getValueAt(filaSeleccionada, 1).toString();
            jempleado.setText(nombre);

            // resetear
            jIDProduccion.setText("");
            jproducto.setSelectedIndex(-1);
            jcantidad.setText("");
            jestado_f.setSelectedIndex(-1);
            jfechaInicio.setText("");
            jfechaFin.setText("");
        }
    }//GEN-LAST:event_visorMouseClicked

    private void resetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetearActionPerformed
        jID.setText("");
        jIDProduccion.setText("");
        jempleado.setText("");
        jproducto.setSelectedIndex(-1);
        jcantidad.setText("");
        jestado_f.setSelectedIndex(-1);
        jfechaInicio.setText("");
        jfechaFin.setText("");
    }//GEN-LAST:event_resetearActionPerformed

    private void jIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDActionPerformed

    private void TablaProCompleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProCompleMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = TablaProComple.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna producción.");
        } else {
            // Obtenemos los valores en el orden correcto según las columnaspro

            String idStr = TablaProComple.getValueAt(filaSeleccionada, 0).toString();  // ID Producción
            //String empleado = TablaProComple.getValueAt(filaSeleccionada, 1).toString();  // Empleado
            String cantidad = TablaProComple.getValueAt(filaSeleccionada, 2).toString();  // Cantidad
            String tipoProducto = TablaProComple.getValueAt(filaSeleccionada, 3).toString();  // Producto
            String estado_f = TablaProComple.getValueAt(filaSeleccionada, 4).toString();  // Estado
            String fechaInicio = TablaProComple.getValueAt(filaSeleccionada, 5).toString();  // Fecha Inicio
            String fechaFin = TablaProComple.getValueAt(filaSeleccionada, 6).toString();  // Fecha Fin

            // Asignamos a los campos del formulario
            jIDProduccion.setText(idStr);
            //jempleado.setText(empleado);
            jcantidad.setText(cantidad);
            jproducto.setSelectedItem(tipoProducto);
            jestado_f.setSelectedItem(estado_f);
            jfechaInicio.setText(fechaInicio);
            jfechaFin.setText(fechaFin);
        }
    }//GEN-LAST:event_TablaProCompleMouseClicked

    private void jIDProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIDProduccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIDProduccionActionPerformed

    private void jproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jproductoActionPerformed

    private void TablaProCompleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProCompleMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaProCompleMouseEntered

    private void TablaProCompleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProCompleMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaProCompleMouseExited

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarActionPerformed
    private void modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseClicked
        // TODO add your handling code here:
        int idProduccion = Integer.parseInt(jIDProduccion.getText());  // ID Producción
        String producto = (String) jproducto.getSelectedItem();        // Producto
        int cantidad = Integer.parseInt(jcantidad.getText());          // Cantidad
        String estado_f = (String) jestado_f.getSelectedItem();        // Estado
        String fechaInicio = jfechaInicio.getText();                   // Fecha Inicio
        String fechaFin = jfechaFin.getText();                         // Fecha Fin

        try (Connection conexion = new ConexionBDR().conectar()) {
            Statement stmt = conexion.createStatement();

            String sql = "UPDATE produccion SET producto = '" + producto
                    + "', cantidad = " + cantidad
                    + ", estado_f = '" + estado_f
                    + "', fecha_inicio = '" + fechaInicio
                    + "', fecha_fin = '" + fechaFin
                    + "' WHERE id = " + idProduccion;

            int filasAfectadas = stmt.executeUpdate(sql);

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Producción actualizada.");
                int idEmpleado = Integer.parseInt(jID.getText());
                actualizarMatrizDatoProduccion(idEmpleado);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la producción con ese ID.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
        }
    }//GEN-LAST:event_modificarMouseClicked

    private void CargarDatosBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarDatosBinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarDatosBinActionPerformed

    private void guardaDatosBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaDatosBinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardaDatosBinActionPerformed

    private void CargarDatosXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarDatosXMLActionPerformed
        // TODO add your handling code here:
        try {
            // Abrimos el archivo XML con las producciones
            FileInputStream fis = new FileInputStream("listadoProduccion.xml");
            XMLDecoder xmld = new XMLDecoder(new BufferedInputStream(fis));

            // Leemos la lista de producciones del archivo
            List<Produccion> listaProduccion = (List<Produccion>) xmld.readObject();
            xmld.close();

            // Obtenemos el modelo de la tabla de producciones
            DefaultTableModel model = (DefaultTableModel) TablaProComple.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de cargar

            // Añadir cada producción como una fila
            for (Produccion produccion : listaProduccion) {
                Object[] fila = {
                    produccion.getIdProduccion(),
                    produccion.getEmpleado(),
                    produccion.getProducto(),
                    produccion.getCantidad(),
                    produccion.getEstado(),
                    produccion.getFechaInicio(),
                    produccion.getFechaFin()
                };
                model.addRow(fila);
            }

        } catch (Exception e) {
            System.err.println("\tERROR al leer el archivo listadoProduccion.xml");
            e.printStackTrace();
        }
    }//GEN-LAST:event_CargarDatosXMLActionPerformed

    private void guardaDatosXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaDatosXMLActionPerformed
        try {
            // Se crea un flujo de salida para escribir en el archivo "listadoEmpleados.xml"
            FileOutputStream fos = new FileOutputStream("listadoProduccion.xml");

            // Se crea un codificador XML que escribirá en el flujo de salida, con buffer para mayor eficiencia
            XMLEncoder xmle = new XMLEncoder(new BufferedOutputStream(fos));

            // Se crea una lista vacía donde se guardarán todos los empleados
            List<Produccion> listaProduccion = new ArrayList<>();

            // Se obtiene el modelo de datos (las filas y columnas) de la tabla "visor"
            DefaultTableModel model = (DefaultTableModel) TablaProComple.getModel();
            int filas = model.getRowCount(); // Se obtiene el número de filas de la tabla

            // Se recorre cada fila de la tabla
            for (int i = 0; i < model.getRowCount(); i++) {
                int IDproduccion = Integer.parseInt(model.getValueAt(i, 0).toString());      // Columna 0: ID Producción
                String empleado = ""; // Si no se usa en la tabla, puedes ignorar o ajustar según sea necesario
                int cantidad = Integer.parseInt(model.getValueAt(i, 2).toString());          // Columna 2: Cantidad
                Produccion.Producto producto = Produccion.Producto.valueOf(model.getValueAt(i, 3).toString()); // Columna 3: Producto
                Produccion.Estado estado = Produccion.Estado.valueOf(model.getValueAt(i, 4).toString());       // Columna 4: Estado
                String fechaInicio = model.getValueAt(i, 5).toString();                     // Columna 5: Fecha Inicio
                String fechaFin = model.getValueAt(i, 6).toString();                        // Columna 6: Fecha Fin

                Produccion produccion = new Produccion(IDproduccion, empleado, cantidad, producto, estado, fechaInicio, fechaFin);
                listaProduccion.add(produccion);    
            }

            // Se escribe la lista completa de empleados en el archivo XML
            xmle.writeObject(listaProduccion);

            // Se cierra el codificador para finalizar la escritura
            xmle.close();
        } catch (Exception e) {
            // En caso de error, se muestra un mensaje en consola
            System.err.println("\tERROR en la escritura de datos del archivo: listadoEmpleados.xml");
            e.printStackTrace(); // Opcional: muestra detalles técnicos del error
        }
    }//GEN-LAST:event_guardaDatosXMLActionPerformed

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
            java.util.logging.Logger.getLogger(Producciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargarDatosBin;
    private javax.swing.JButton CargarDatosXML;
    private javax.swing.JTable TablaProComple;
    private javax.swing.JButton anadirUsuario;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fondoprincipal;
    private javax.swing.JButton guardaDatosBin;
    private javax.swing.JButton guardaDatosXML;
    private javax.swing.JButton jBotonAtras;
    private javax.swing.JTextField jID;
    private javax.swing.JTextField jIDProduccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JComboBox<String> jestado_f;
    private javax.swing.JTextField jfechaFin;
    private javax.swing.JTextField jfechaInicio;
    private javax.swing.JComboBox<String> jproducto;
    private javax.swing.JButton modificar;
    private javax.swing.JButton resetear;
    public javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables
}
