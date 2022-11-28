package Presentacion;

import Persistencia.ConexionDB;
import java.awt.event.ActionEvent;
import static java.util.Calendar.PM;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 59892
 */
public class Menu extends javax.swing.JFrame {
	

	
    /**
     * Creates new form Menu
     */
    public Menu() {
//        ConexionDB.getInstance().getConnection();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_inicio = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menu_registros = new javax.swing.JMenu();
        reg_usuario = new javax.swing.JMenuItem();
        editar_perfil_usuario = new javax.swing.JMenuItem();
        reg_funcion = new javax.swing.JMenuItem();
        reg_espectaculo = new javax.swing.JMenuItem();
        reg_paquete = new javax.swing.JMenuItem();
        reg_paquete1 = new javax.swing.JMenuItem();
        reg_Plataforma = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menu_consultas = new javax.swing.JMenu();
        consulta_de_usuario = new javax.swing.JMenuItem();
        consulta_funcion_de_espectaculo = new javax.swing.JMenuItem();
        Consulta_paquete_espectaculo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        menu_inicio.setText("Inicio");

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        menu_inicio.add(salir);

        jMenuItem4.setText("Aceptar/Rechazar espectaculo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu_inicio.add(jMenuItem4);

        jMenuItem5.setText("jMenuItem5");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menu_inicio.add(jMenuItem5);

        jMenuBar1.add(menu_inicio);

        menu_registros.setText("Registros");

        reg_usuario.setText("Registrar usuario");
        reg_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_usuarioActionPerformed(evt);
            }
        });
        menu_registros.add(reg_usuario);

        editar_perfil_usuario.setText("Editar perfil de usuario");
        editar_perfil_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_perfil_usuarioActionPerformed(evt);
            }
        });
        menu_registros.add(editar_perfil_usuario);

        reg_funcion.setText("Registrar función");
        reg_funcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_funcionActionPerformed(evt);
            }
        });
        menu_registros.add(reg_funcion);

        reg_espectaculo.setText("Registrar espectáculo");
        reg_espectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_espectaculoActionPerformed(evt);
            }
        });
        menu_registros.add(reg_espectaculo);

        reg_paquete.setText("Registrar paquete de espectáculos");
        reg_paquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_paqueteActionPerformed(evt);
            }
        });
        menu_registros.add(reg_paquete);

        reg_paquete1.setText("Registrar espectador en función de espectaculo");
        reg_paquete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_paquete1ActionPerformed(evt);
            }
        });
        menu_registros.add(reg_paquete1);

        reg_Plataforma.setText("Alta plataforma");
        reg_Plataforma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_PlataformaActionPerformed(evt);
            }
        });
        menu_registros.add(reg_Plataforma);

        jMenuItem2.setText("Agregar espectaculo a paquete");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menu_registros.add(jMenuItem2);

        jMenuItem3.setText("Alta Categoria");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu_registros.add(jMenuItem3);

        jMenuBar1.add(menu_registros);

        menu_consultas.setText("Consultas");

        consulta_de_usuario.setText("Consulta usuario");
        consulta_de_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consulta_de_usuarioActionPerformed(evt);
            }
        });
        menu_consultas.add(consulta_de_usuario);

        consulta_funcion_de_espectaculo.setText("Consultar función de espectaculo");
        consulta_funcion_de_espectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consulta_funcion_de_espectaculoActionPerformed(evt);
            }
        });
        menu_consultas.add(consulta_funcion_de_espectaculo);

        Consulta_paquete_espectaculo.setText("Consulta de paquetes de espectaculo");
        Consulta_paquete_espectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consulta_paquete_espectaculoActionPerformed(evt);
            }
        });
        menu_consultas.add(Consulta_paquete_espectaculo);

        jMenuItem1.setText("Consulta de espectaculos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_consultas.add(jMenuItem1);

        jMenuBar1.add(menu_consultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reg_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_usuarioActionPerformed
        if (ventana_registra_usuario != null && ventana_registra_usuario.isDisplayable())
            ventana_registra_usuario.dispose();

        ventana_registra_usuario = new RegistraUsuario(this.getTitle());
        ventana_registra_usuario.setVisible(true);
    }//GEN-LAST:event_reg_usuarioActionPerformed

    private void reg_funcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_funcionActionPerformed
        Alta_funcion_espectaculo AltaFuncion = new Alta_funcion_espectaculo();
      
          AltaFuncion.setVisible(true);
    }//GEN-LAST:event_reg_funcionActionPerformed

    private void reg_espectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_espectaculoActionPerformed

        // TODO add your handling code here:

         
        AltaEspectaculo AltaEspe = new AltaEspectaculo();
      
          AltaEspe.setVisible(true);
        

    }//GEN-LAST:event_reg_espectaculoActionPerformed

    private void reg_paqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_paqueteActionPerformed
        if (ventana_registra_paquete != null && ventana_registra_paquete.isDisplayable())
            ventana_registra_paquete.dispose();

        ventana_registra_paquete = new RegistraPaquete(this.getTitle());
        ventana_registra_paquete.setVisible(true);
    }//GEN-LAST:event_reg_paqueteActionPerformed

    private void consulta_funcion_de_espectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consulta_funcion_de_espectaculoActionPerformed
        if (ventana_consulta_funcion_espectaculo != null && ventana_consulta_funcion_espectaculo.isDisplayable())
            ventana_consulta_funcion_espectaculo.dispose();

        ventana_consulta_funcion_espectaculo = new ConsultaFuncionEspectaculo();

       ventana_consulta_funcion_espectaculo.setVisible(true);
                                      

    }//GEN-LAST:event_consulta_funcion_de_espectaculoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ConexionDB.getInstance().close();
    }//GEN-LAST:event_formWindowClosing

    private void editar_perfil_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_perfil_usuarioActionPerformed
        if (ventana_editar_perfil_usuario != null && ventana_editar_perfil_usuario.isDisplayable())
            ventana_editar_perfil_usuario.dispose();

        ventana_editar_perfil_usuario = new ModificarUsuarioSeleccion(this.getTitle());
        ventana_editar_perfil_usuario.setVisible(true);
    }//GEN-LAST:event_editar_perfil_usuarioActionPerformed

    private void reg_paquete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_paquete1ActionPerformed
        if (ventana_registro_a_funcion_de_espectaculo != null && ventana_registro_a_funcion_de_espectaculo.isDisplayable())
            ventana_registro_a_funcion_de_espectaculo.dispose();

        ventana_registro_a_funcion_de_espectaculo = new RegistraEspectadorEnFuncionEspectaculo(this.getTitle());
        ventana_registro_a_funcion_de_espectaculo.setVisible(true);
    }//GEN-LAST:event_reg_paquete1ActionPerformed

    private void reg_PlataformaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_PlataformaActionPerformed
           Alta_Plataforma altaplataforma = new Alta_Plataforma();
           altaplataforma.setVisible(true);
    }//GEN-LAST:event_reg_PlataformaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       Agregar_Espectaculo_Paquete EspectaculoaPaquete= new Agregar_Espectaculo_Paquete();
       EspectaculoaPaquete.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void Consulta_paquete_espectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consulta_paquete_espectaculoActionPerformed
        Consulta_paquete_espectaculo ConsulPaqueEspe = new Consulta_paquete_espectaculo();
        ConsulPaqueEspe.setVisible(true);
    }//GEN-LAST:event_Consulta_paquete_espectaculoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void consulta_de_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consulta_de_usuarioActionPerformed
        if (ventana_usuario_seleccion != null && ventana_usuario_seleccion.isDisplayable())
            ventana_usuario_seleccion.dispose();

        ventana_usuario_seleccion = new ConsultaUsuarioSeleccion(this.getTitle());
        ventana_usuario_seleccion.setVisible(true);
    }//GEN-LAST:event_consulta_de_usuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Consulta_de_espectaculo consultaespec = new Consulta_de_espectaculo();
        consultaespec.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Alta_Categoria altacategoria = new Alta_Categoria();
        altacategoria.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Aceptar_Rechazar_Espectaculo ventana = new Aceptar_Rechazar_Espectaculo();
        ventana.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
     Date fecha =  new Date ("Nov 17, 2022 11:14:13 PM");
        System.out.println(fecha);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    private ConsultaUsuarioSeleccion ventana_usuario_seleccion;
    private ConsultaFuncionEspectaculo ventana_consulta_funcion_espectaculo;
    private RegistraEspectadorEnFuncionEspectaculo ventana_registro_a_funcion_de_espectaculo;
    private RegistraPaquete ventana_registra_paquete;
    private RegistraUsuario ventana_registra_usuario;
    private ModificarUsuarioSeleccion ventana_editar_perfil_usuario;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Consulta_paquete_espectaculo;
    private javax.swing.JMenuItem consulta_de_usuario;
    private javax.swing.JMenuItem consulta_funcion_de_espectaculo;
    private javax.swing.JMenuItem editar_perfil_usuario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menu_consultas;
    private javax.swing.JMenu menu_inicio;
    private javax.swing.JMenu menu_registros;
    private javax.swing.JMenuItem reg_Plataforma;
    private javax.swing.JMenuItem reg_espectaculo;
    private javax.swing.JMenuItem reg_funcion;
    private javax.swing.JMenuItem reg_paquete;
    private javax.swing.JMenuItem reg_paquete1;
    private javax.swing.JMenuItem reg_usuario;
    private javax.swing.JMenuItem salir;
    // End of variables declaration//GEN-END:variables
}
