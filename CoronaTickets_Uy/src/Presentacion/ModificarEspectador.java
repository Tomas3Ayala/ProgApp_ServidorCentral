/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.util.Arrays;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import logica.Fabrica;
import logica.clases.Artista;
import logica.clases.Espectador;

/**
 *
 * @author Tomas
 */
public class ModificarEspectador extends javax.swing.JFrame {

    /**
     * Creates new form RegistraUsuario
     */
    public ModificarEspectador(String prefix, Espectador espectador) {
        initComponents();
        this.setTitle(prefix + " - " + this.getTitle());
        
        field_nickname.setText(espectador.getNickname());
        field_nombre.setText(espectador.getNombre());
        field_apellido.setText(espectador.getApellido());
        field_correo.setText(espectador.getCorreo());
        fecha_nacimiento.setDate(espectador.getNacimiento());
        id = espectador.getId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_de_usuario = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        field_nickname = new javax.swing.JTextField();
        field_nombre = new javax.swing.JTextField();
        field_apellido = new javax.swing.JTextField();
        field_correo = new javax.swing.JTextField();
        button_cancelar = new javax.swing.JButton();
        button_registrar = new javax.swing.JButton();
        fecha_nacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar espectador");

        jLabel1.setText("Nickname:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Correo:");

        jLabel5.setText("Fecha de nacimiento:");

        field_nickname.setEnabled(false);

        field_correo.setEnabled(false);

        button_cancelar.setText("Cancelar");
        button_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelarActionPerformed(evt);
            }
        });

        button_registrar.setText("Modificar");
        button_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(field_nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(field_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(field_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(field_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_registrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(44, 44, 44)
                        .addComponent(fecha_nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(field_nickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(field_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(field_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(field_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_cancelar)
                    .addComponent(button_registrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_button_cancelarActionPerformed

    private void button_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_registrarActionPerformed

        if (field_nombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "El nombre del usuario no puede estar en blanco");
            return;
        }
        if (field_apellido.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "El apellido del usuario no puede estar en blanco");
            return;
        }
        if (fecha_nacimiento.getCalendar() == null) {
            JOptionPane.showMessageDialog(this, "La fecha de nacimiento no tiene un formato válido");
            return;
        }

        Espectador espectador = new Espectador(field_nickname.getText(), field_nombre.getText(), field_apellido.getText(), field_correo.getText(), fecha_nacimiento.getCalendar().getTime(), -1);
        Fabrica.getInstance().getInstanceControllerUsuario().modificar_espectador(id, espectador);
        JOptionPane.showMessageDialog(this, "Se ha modificado con exito el espectador");
    }//GEN-LAST:event_button_registrarActionPerformed

    private int id;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_cancelar;
    private javax.swing.JButton button_registrar;
    private com.toedter.calendar.JDateChooser fecha_nacimiento;
    private javax.swing.JTextField field_apellido;
    private javax.swing.JTextField field_correo;
    private javax.swing.JTextField field_nickname;
    private javax.swing.JTextField field_nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.ButtonGroup tipo_de_usuario;
    // End of variables declaration//GEN-END:variables
}