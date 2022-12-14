/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import logica.Fabrica;
import logica.clases.Categoria;
import logica.clases.Espectaculo;
import logica.interfaces.InterfaceEspectaculo;


/**
 *
 * @author 59892
 */
public class Aceptar_Rechazar_Espectaculo extends javax.swing.JFrame {
   

    private InterfaceEspectaculo ICU;
    DefaultListModel Espectaculos = new DefaultListModel();
    /**
     * Creates new form Acceptar_Rechazar_Espectaculo
     */
    public Aceptar_Rechazar_Espectaculo() {
        initComponents();
        this.ICU = Fabrica.getInstance().getInstanceControladorEspectaculo();
        lista_espectaculos_ingresados.setModel(Espectaculos);
        ArrayList<Espectaculo> espectaculosi = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_ingresados();
        ArrayList<String> lista = new ArrayList<>();
        espectaculosi.forEach((espectaculo) -> {
            lista.add(espectaculo.getId() + "-" + espectaculo.getNombre());
        });

        lista_espectaculos_ingresados.setListData((String[]) lista.toArray(new String[lista.size()]));
    }
    public void actualizar_combo (){
         lista_espectaculos_ingresados.setModel(Espectaculos);
        ArrayList<Espectaculo> espectaculosi = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_ingresados();
        ArrayList<String> lista = new ArrayList<>();
        espectaculosi.forEach((espectaculo) -> {
            lista.add(espectaculo.getId() + "-" + espectaculo.getNombre());
        });

        lista_espectaculos_ingresados.setListData((String[]) lista.toArray(new String[lista.size()]));
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
        lista_espectaculos_ingresados = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnRechazar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aceptar/Rechazar Espectaculo");

        jScrollPane1.setViewportView(lista_espectaculos_ingresados);

        jLabel1.setText("Espectaculos Ingresados ");

        btnRechazar.setText("Rechazar espectaculo");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar espectaculo");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(btnRechazar))
                            .addComponent(jLabel1))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRechazar)
                    .addComponent(btnAceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       String espectaculo = lista_espectaculos_ingresados.getSelectedValue();
       String[] parts = espectaculo.split("-");
       String idString = parts[0];
       int id = Integer.parseInt(idString);
       if (ICU.aceptar_espectaculo(id)){
            JOptionPane.showMessageDialog(null, "Espectaculo aceptado");
            actualizar_combo();
       }else 
       {
           JOptionPane.showMessageDialog(null, "Hubo algun problema al aceptar el espectaculo");
       }
       
       
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        String espectaculo = lista_espectaculos_ingresados.getSelectedValue();
       String[] parts = espectaculo.split("-");
       String idString = parts[0];
       int id = Integer.parseInt(idString);
       if (ICU.rechazar_espectaculo(id)){
            JOptionPane.showMessageDialog(null, "Espectaculo rechazado");
            actualizar_combo();
            
       }else 
       {
           JOptionPane.showMessageDialog(null, "Hubo algun problema al rechazar el espectaculo");
       }
    }//GEN-LAST:event_btnRechazarActionPerformed

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
            java.util.logging.Logger.getLogger(Aceptar_Rechazar_Espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aceptar_Rechazar_Espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aceptar_Rechazar_Espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aceptar_Rechazar_Espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aceptar_Rechazar_Espectaculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista_espectaculos_ingresados;
    // End of variables declaration//GEN-END:variables
}
