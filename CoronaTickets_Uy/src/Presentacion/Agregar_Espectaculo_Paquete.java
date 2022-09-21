/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import logica.Fabrica;
import logica.clases.Artista;
import logica.clases.Espectaculo;
import logica.clases.Paquete;
import logica.interfaces.InterfacePlataforma;

/**
 *
 * @author 59892
 */
public class Agregar_Espectaculo_Paquete extends javax.swing.JFrame {
            ArrayList<Paquete> listaPaquetes = new ArrayList<>();
            ArrayList<Espectaculo> listaEspectaculo = new ArrayList<>();
            private InterfacePlataforma ICU;
            DefaultListModel paquetes = new DefaultListModel();
            DefaultListModel espectaculo = new DefaultListModel();
            
    /**
     * Creates new form Agregar_Espectaculo_Paquete
     */
    public Agregar_Espectaculo_Paquete() {
       
        initComponents();
        this.ICU = Fabrica.getInstance().getInstanceControladorPlataforma();
        ArrayList<String> plataformas =  Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_plataformas_disponibles();
        plataformas.forEach((plataforma)->{
        combo_Plataformas.addItem(plataforma);
      });
        listaPaquetes = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_paquetes();
        ArrayList<String> listap = new ArrayList<>();
         listaPaquetes.forEach((paquete) -> {
                listap.add(paquete.getNombre());
            });
         lista_paquetes_registrados.setListData((String[]) listap.toArray(new String[listap.size()]));
         
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista_paquetes_registrados = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        combo_Plataformas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_espectaculos_noestan_paquete = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar_espectaculo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar espectaculo a paquete");

        jScrollPane1.setViewportView(lista_paquetes_registrados);

        jLabel1.setText("Paquetes existentes ");

        combo_Plataformas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_PlataformasItemStateChanged(evt);
            }
        });
        combo_Plataformas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_PlataformasActionPerformed(evt);
            }
        });

        jLabel2.setText("Plataformas");

        jScrollPane2.setViewportView(lista_espectaculos_noestan_paquete);

        jLabel3.setText("Espectaculos que no forman parte del paquete seleccionado");

        btnAgregar_espectaculo.setText("Agregar espectaculo a paquete");
        btnAgregar_espectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar_espectaculoActionPerformed(evt);
            }
        });

        jButton1.setText("Ver espectaculos de paquetes");
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(combo_Plataformas, 0, 148, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar_espectaculo)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar_espectaculo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(combo_Plataformas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_PlataformasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_PlataformasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_PlataformasActionPerformed

    private void combo_PlataformasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_PlataformasItemStateChanged
      String itemplataforma = (String) combo_Plataformas.getSelectedItem();
      String itempaquete= (String) lista_paquetes_registrados.getSelectedValue();
      if (itemplataforma != null && itempaquete != null ){
            ArrayList<Espectaculo> espectaculos = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_espectaculos_plataforma_quenoformanparte_paquete(itemplataforma, itempaquete);
            ArrayList<String> lista = new ArrayList<>();
            espectaculos.forEach((espectaculo) -> {
            lista.add(espectaculo.getId()+"-"+espectaculo.getNombre()+"-"+espectaculo.getPlataforma());
            lista_espectaculos_noestan_paquete.setListData((String[]) lista.toArray(new String[lista.size()]));
            });
      }
    }//GEN-LAST:event_combo_PlataformasItemStateChanged

    private void btnAgregar_espectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar_espectaculoActionPerformed
        int idEspectaculo = 0;
        String nombrePaquete = "";
        if (lista_paquetes_registrados.getSelectedValue() == null){
       JOptionPane.showMessageDialog(null, "Debe seleccional un paquete");
        }else if (lista_espectaculos_noestan_paquete.getSelectedValue()==null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un espectaculo que no forma parte del paquete");
        } else{
         nombrePaquete = lista_paquetes_registrados.getSelectedValue();
         idEspectaculo = this.ICU.ExtraerIdDeCombo(lista_espectaculos_noestan_paquete.getSelectedValue());
         this.ICU.Agregar_espectaculo_a_paquete(idEspectaculo, nombrePaquete); 
        }
        
    }//GEN-LAST:event_btnAgregar_espectaculoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Consulta_paquete_espectaculo().setVisible(true);
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
            java.util.logging.Logger.getLogger(Agregar_Espectaculo_Paquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar_Espectaculo_Paquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar_Espectaculo_Paquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar_Espectaculo_Paquete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar_Espectaculo_Paquete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar_espectaculo;
    private javax.swing.JComboBox<String> combo_Plataformas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lista_espectaculos_noestan_paquete;
    private javax.swing.JList<String> lista_paquetes_registrados;
    // End of variables declaration//GEN-END:variables
}