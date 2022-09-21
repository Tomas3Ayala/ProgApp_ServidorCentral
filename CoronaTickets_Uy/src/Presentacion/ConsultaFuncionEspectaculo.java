/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.ArrayList;
import logica.Fabrica;
import logica.clases.Espectaculo;
import logica.clases.Funcion;

/**
 *
 * @author Tomas
 */
public class ConsultaFuncionEspectaculo extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaFuncionEspectaculo
     */
    public ConsultaFuncionEspectaculo() {
        initComponents();
        
        panel_de_funcion_no_seleccion.setVisible(true);
        panel_de_funcion_datos.setVisible(false);
        
        ArrayList<String> plataformas = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_plataformas_disponibles();

        plataformas.forEach((plataforma) -> {
            combobox_plataformas.addItem(plataforma);
        });
    }

    
     


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        combobox_plataformas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_espectaculos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_funciones = new javax.swing.JList<>();
        panel_de_funcion = new javax.swing.JLayeredPane();
        panel_de_funcion_datos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        label_nombre_funcion = new javax.swing.JLabel();
        label_fecha_funcion = new javax.swing.JLabel();
        label_fecha_registro_funcion = new javax.swing.JLabel();
        label_hora_funcion = new javax.swing.JLabel();
        label_datos_funcion = new javax.swing.JLabel();
        panel_de_funcion_no_seleccion = new javax.swing.JPanel();
        label_no_datos_funcion = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Plataforma en la se ofrece el espectáculo:");

        combobox_plataformas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_plataformasItemStateChanged(evt);
            }
        });
        combobox_plataformas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                combobox_plataformasMouseReleased(evt);
            }
        });

        lista_espectaculos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_espectaculos.setToolTipText("");
        lista_espectaculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_espectaculosMouseClicked(evt);
            }
        });
        lista_espectaculos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_espectaculosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista_espectaculos);

        jLabel2.setText("Elija el espectáculo:");

        jLabel3.setText("Elija la función:");

        lista_funciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_funciones.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_funcionesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lista_funciones);

        panel_de_funcion_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setText("Nombre:");

        jLabel6.setText("Fecha:");

        jLabel7.setText("Hora:");

        jLabel8.setText("Fecha en la que se registró:");

        label_nombre_funcion.setText("nombre");

        label_fecha_funcion.setText("fecha");

        label_fecha_registro_funcion.setText("fecha_registro");

        label_hora_funcion.setText("hora");

        label_datos_funcion.setText("Datos de la función:");

        javax.swing.GroupLayout panel_de_funcion_datosLayout = new javax.swing.GroupLayout(panel_de_funcion_datos);
        panel_de_funcion_datos.setLayout(panel_de_funcion_datosLayout);
        panel_de_funcion_datosLayout.setHorizontalGroup(
            panel_de_funcion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_de_funcion_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_de_funcion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_de_funcion_datosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_fecha_registro_funcion)
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addComponent(label_datos_funcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_de_funcion_datosLayout.createSequentialGroup()
                        .addGroup(panel_de_funcion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(panel_de_funcion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nombre_funcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_fecha_funcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_hora_funcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panel_de_funcion_datosLayout.setVerticalGroup(
            panel_de_funcion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_de_funcion_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_datos_funcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_de_funcion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(label_nombre_funcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_de_funcion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(label_fecha_funcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_de_funcion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_hora_funcion)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_de_funcion_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(label_fecha_registro_funcion))
                .addContainerGap())
        );

        label_no_datos_funcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_no_datos_funcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_no_datos_funcion.setText("[No se ha seleccionado función]");

        javax.swing.GroupLayout panel_de_funcion_no_seleccionLayout = new javax.swing.GroupLayout(panel_de_funcion_no_seleccion);
        panel_de_funcion_no_seleccion.setLayout(panel_de_funcion_no_seleccionLayout);
        panel_de_funcion_no_seleccionLayout.setHorizontalGroup(
            panel_de_funcion_no_seleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
            .addGroup(panel_de_funcion_no_seleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(label_no_datos_funcion, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
        );
        panel_de_funcion_no_seleccionLayout.setVerticalGroup(
            panel_de_funcion_no_seleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
            .addGroup(panel_de_funcion_no_seleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(label_no_datos_funcion, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );

        panel_de_funcion.setLayer(panel_de_funcion_datos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel_de_funcion.setLayer(panel_de_funcion_no_seleccion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel_de_funcionLayout = new javax.swing.GroupLayout(panel_de_funcion);
        panel_de_funcion.setLayout(panel_de_funcionLayout);
        panel_de_funcionLayout.setHorizontalGroup(
            panel_de_funcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_de_funcion_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_de_funcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_de_funcion_no_seleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_de_funcionLayout.setVerticalGroup(
            panel_de_funcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_de_funcion_datos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_de_funcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel_de_funcion_no_seleccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_de_funcion_datos.getAccessibleContext().setAccessibleDescription("");

        jButton1.setText("Registrar funcion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combobox_plataformas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_de_funcion)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combobox_plataformas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_de_funcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lista_espectaculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_espectaculosMouseClicked
        //
    }//GEN-LAST:event_lista_espectaculosMouseClicked

    private void combobox_plataformasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combobox_plataformasMouseReleased
        //
    }//GEN-LAST:event_combobox_plataformasMouseReleased

    private void combobox_plataformasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_plataformasItemStateChanged
        String item = (String) combobox_plataformas.getSelectedItem();
        if (item != prev_plataformas_item && item != null) {
//            System.out.println(item);
            prev_plataformas_item = item;

            ArrayList<Espectaculo> espectaculos = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_con_plataforma(item);
            ArrayList<String> lista = new ArrayList<>();
            espectaculos.forEach((espectaculo) -> {
                lista.add(espectaculo.getNombre());
            });

            lista_espectaculos.setListData((String[]) lista.toArray(new String[lista.size()]));
        }
    }//GEN-LAST:event_combobox_plataformasItemStateChanged

    private void lista_espectaculosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_espectaculosValueChanged
        String item = (String) lista_espectaculos.getSelectedValue();
        if (item != prev_espectaculos_item && item != null) {
            System.out.println(item);
            prev_espectaculos_item = item;

            int index = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_con_plataforma(prev_plataformas_item).get(lista_espectaculos.getSelectedIndex()).getId();
            ArrayList<Funcion> funciones = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_funciones_de_espectaculo(index);
            ArrayList<String> lista = new ArrayList<>();
            funciones.forEach((funcion) -> {
                lista.add(funcion.getNombre());
            });

            lista_funciones.setListData((String[]) lista.toArray(new String[lista.size()]));
        }
    }//GEN-LAST:event_lista_espectaculosValueChanged

    private void lista_funcionesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_funcionesValueChanged
        String item = (String) lista_funciones.getSelectedValue();
        if (item != prev_funciones_item && item != null) {
            System.out.println(item);
            prev_funciones_item = item;
            
            panel_de_funcion_no_seleccion.setVisible(false);
            panel_de_funcion_datos.setVisible(true);
            
            int index = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_con_plataforma(prev_plataformas_item).get(lista_espectaculos.getSelectedIndex()).getId();
            ArrayList<Funcion> funciones = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_funciones_de_espectaculo(index);
            
            Funcion funcion = funciones.get(lista_funciones.getSelectedIndex());
            label_nombre_funcion.setText(funcion.getNombre());
            label_fecha_funcion.setText(funcion.getFecha().toString());
//            label_hora_funcion.setText(toString(funcion.getHora_inicio()));
            int hora = funcion.getHora_inicio();
            label_hora_funcion.setText(Integer.toString(hora));
            label_fecha_registro_funcion.setText(funcion.getFecha_registro().toString());
        }
    }//GEN-LAST:event_lista_funcionesValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Alta_funcion_espectaculo().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaFuncionEspectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaFuncionEspectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaFuncionEspectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaFuncionEspectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaFuncionEspectaculo().setVisible(true);
            }
        });
    }
    
    private String prev_funciones_item;
    private String prev_espectaculos_item;
    private String prev_plataformas_item;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combobox_plataformas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_datos_funcion;
    private javax.swing.JLabel label_fecha_funcion;
    private javax.swing.JLabel label_fecha_registro_funcion;
    private javax.swing.JLabel label_hora_funcion;
    private javax.swing.JLabel label_no_datos_funcion;
    private javax.swing.JLabel label_nombre_funcion;
    private javax.swing.JList<String> lista_espectaculos;
    private javax.swing.JList<String> lista_funciones;
    private javax.swing.JLayeredPane panel_de_funcion;
    private javax.swing.JPanel panel_de_funcion_datos;
    private javax.swing.JPanel panel_de_funcion_no_seleccion;
    // End of variables declaration//GEN-END:variables
}