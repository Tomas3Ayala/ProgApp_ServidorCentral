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
import logica.clases.Paquete;
import logica.clases.Plataforma;
import logica.interfaces.InterfacePlataforma;

/**
 *
 * @author 59892
 */
public class Consulta_de_espectaculo extends javax.swing.JFrame {
   private InterfacePlataforma ICU;
   
    private ArrayList<Espectaculo> espectaculos_aux;
    /**
     * Creates new form Consulta_de_espectaculo
     */
    public Consulta_de_espectaculo() {
        this.ICU = Fabrica.getInstance().getInstanceControladorPlataforma();
        initComponents();
        ArrayList<String> plataformas = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_plataformas_disponibles();

        plataformas.forEach((plataforma) -> {
            combobox_plataforma.addItem(plataforma);
        });
        
        label_nombre_funcion.setText("N/A");
        label_fecha_funcion.setText("N/A");
        label_hora_funcion.setText("N/A");
        label_fecha_registro_funcion.setText("N/A");
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
        combobox_plataforma = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_espectaculo_plataforma = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_info_espectaculo = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista_paquetes_asociados = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lista_funciones_espectaculo = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lista_info_paquete = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lista_espectaculos_de_paquete = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        label_datos_funcion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_nombre_funcion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_fecha_funcion = new javax.swing.JLabel();
        label_hora_funcion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        label_fecha_registro_funcion = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de espectaculos");

        jLabel1.setText("Elija plataforma");

        combobox_plataforma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobox_plataformaItemStateChanged(evt);
            }
        });

        lista_espectaculo_plataforma.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_espectaculo_plataformaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista_espectaculo_plataforma);

        jScrollPane2.setViewportView(lista_info_espectaculo);

        jLabel2.setText("Espectaculos de la plataforma");

        jLabel10.setText("Informacion del espectaculo");

        lista_paquetes_asociados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_paquetes_asociadosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lista_paquetes_asociados);

        jLabel3.setText("Paquetes asociados:");

        lista_funciones_espectaculo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_funciones_espectaculo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_funciones_espectaculoValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lista_funciones_espectaculo);

        jLabel4.setText("Funciones del espectaculo");

        jScrollPane6.setViewportView(lista_info_paquete);

        jLabel12.setText("Lista de espectaculos incluidos en el paquete:");

        lista_espectaculos_de_paquete.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_espectaculos_de_paqueteValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(lista_espectaculos_de_paquete);

        jLabel13.setText("Informacion del paquete seleccionado");

        label_datos_funcion.setText("Datos de la función:");

        jLabel5.setText("Nombre:");

        label_nombre_funcion.setText("nombre");

        jLabel6.setText("Fecha:");

        jLabel7.setText("Hora:");

        label_fecha_funcion.setText("fecha");

        label_hora_funcion.setText("hora");

        jLabel8.setText("Fecha en la que se registró:");

        label_fecha_registro_funcion.setText("fecha_registro");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Registrar espectaculo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(combobox_plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jLabel13)))
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_datos_funcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_nombre_funcion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_hora_funcion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_fecha_funcion, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_fecha_registro_funcion))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combobox_plataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_datos_funcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(label_nombre_funcion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(label_fecha_funcion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(label_hora_funcion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(label_fecha_registro_funcion))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combobox_plataformaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobox_plataformaItemStateChanged
       String item = (String) combobox_plataforma.getSelectedItem();
        if (item != prev_plataformas_item && item != null) {
//            System.out.println(item);
            prev_plataformas_item = item;

            espectaculos_aux = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculos_con_plataforma(item);
            ArrayList<String> lista = new ArrayList<>();
            espectaculos_aux.forEach((espectaculo) -> {
                lista.add(espectaculo.getNombre());
            });

            lista_espectaculo_plataforma.setListData((String[]) lista.toArray(new String[lista.size()]));
        }
    }//GEN-LAST:event_combobox_plataformaItemStateChanged

    private void lista_espectaculo_plataformaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_espectaculo_plataformaValueChanged
        String item2 = (String) lista_espectaculo_plataforma.getSelectedValue();
        if (lista_espectaculo_plataforma.getSelectedValue()!= null){
        int idespec = espectaculos_aux.get(lista_espectaculo_plataforma.getSelectedIndex()).getId();
        if (item2 != prev_espectaculo_item && item2 != null) {
            prev_espectaculo_item = item2;
            Espectaculo espectaculo = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculo(idespec);
            ArrayList<String> listaEspectaculos = new ArrayList<>();
                listaEspectaculos.add("Nombre: "+espectaculo.getNombre());
                listaEspectaculos.add("Descripcion: "+espectaculo.getDescripcion());
                String duracion = String.valueOf(espectaculo.getDuracion());//duracion convertida a string
                listaEspectaculos.add("Duracion: "+duracion);
                String min_espectadores = String.valueOf(espectaculo.getMin_espectador());//minimo de espectadores
                listaEspectaculos.add("Minimo de espectadores: "+min_espectadores);
                String max_espectadores = String.valueOf(espectaculo.getMax_espectador());//maximo de espectadores
                listaEspectaculos.add("Maximo de escpectadores: "+max_espectadores);
                listaEspectaculos.add("URL: "+espectaculo.getUrl());
                String costo = String.valueOf(espectaculo.getCosto());//costo
                listaEspectaculos.add("Costo: "+costo);
                listaEspectaculos.add("Fecha de registro: "+espectaculo.getFecha_registro().toString());
                listaEspectaculos.add("Categoria: "+espectaculo.getCategoria());
                String idPlataforma = String.valueOf(espectaculo.getPlataforma());//id de Plataforma
                listaEspectaculos.add("Plataforma: "+idPlataforma);  
                
            lista_info_espectaculo.setListData((String[]) listaEspectaculos.toArray(new String[listaEspectaculos.size()]));
            
            }
         ArrayList<Funcion> funciones = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_funciones_de_espectaculo(idespec);
         ArrayList<String> lista = new ArrayList<>();
            funciones.forEach((funcion) -> {
                lista.add(funcion.getNombre());
            });
            lista_funciones_espectaculo.setListData((String[]) lista.toArray(new String[lista.size()]));
        ArrayList<Paquete> paquetes = this.ICU.obtener_paquetes_de_plataforma(idespec);
        ArrayList<String> listaPaquetes = new ArrayList();
        paquetes.forEach((paquete)->{
           listaPaquetes.add(paquete.getNombre());
        });
            lista_paquetes_asociados.setListData((String[]) listaPaquetes.toArray(new String[lista.size()]));
        }
    }//GEN-LAST:event_lista_espectaculo_plataformaValueChanged

    private void lista_paquetes_asociadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_paquetes_asociadosValueChanged
           String item = (String) lista_paquetes_asociados.getSelectedValue();  
        if (item != prev_paquete_item && item != null) {
            prev_paquete_item = item;
             
            int idpaquete = this.ICU.ExtraeridPaquete(item);
            Paquete paquete = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_info_paquetes(idpaquete);
            ArrayList<String> lista = new ArrayList<>();
                lista.add(paquete.getNombre());
                lista.add("Descripcion: "+paquete.getDescripcion());
                lista.add("Fecha de incio: "+paquete.getFecha_inicio().toString());
                lista.add("Fecha de fin: "+paquete.getFecha_fin().toString());
                String descuento = String.valueOf(paquete.getDescuento());
                lista.add("Descuento: "+descuento);
                String id =  String.valueOf(paquete.getId());
                lista.add(id);
                
            lista_info_paquete.setListData((String[]) lista.toArray(new String[lista.size()]));
            ArrayList <String> espectaculos = this.ICU.obtener_espectaculos_de_paquete(idpaquete);
            lista_espectaculos_de_paquete.setListData((String[]) espectaculos.toArray(new String[espectaculos.size()]));
       
        }
    }//GEN-LAST:event_lista_paquetes_asociadosValueChanged

    private void lista_espectaculos_de_paqueteValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_espectaculos_de_paqueteValueChanged
        String item2 = (String) lista_espectaculos_de_paquete.getSelectedValue();
        if (lista_espectaculos_de_paquete.getSelectedValue()!= null){
            int idespec = this.ICU.obtener_idespectaculo(item2);
            System.out.println(item2);
            if (item2 != prev_espectaculo_item && item2 != null) {
                prev_espectaculo_item = item2;
                Espectaculo espectaculo = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_espectaculo(idespec);
                ArrayList<String> listaEspectaculos = new ArrayList<>();
                listaEspectaculos.add("Nombre: "+espectaculo.getNombre());
                listaEspectaculos.add("Descripcion: "+espectaculo.getDescripcion());
                String duracion = String.valueOf(espectaculo.getDuracion());//duracion convertida a string
                listaEspectaculos.add("Duracion: "+duracion);
                String min_espectadores = String.valueOf(espectaculo.getMin_espectador());//minimo de espectadores
                listaEspectaculos.add("Min espectadores: "+min_espectadores);
                String max_espectadores = String.valueOf(espectaculo.getMax_espectador());//maximo de espectadores
                listaEspectaculos.add("Max espectadores: "+max_espectadores);
                listaEspectaculos.add("URL "+espectaculo.getUrl());
                String costo = String.valueOf(espectaculo.getCosto());//costo
                listaEspectaculos.add("Costo: "+costo);
                listaEspectaculos.add("Fecha de registro: "+espectaculo.getFecha_registro().toString());
                String idEspectaculo = String.valueOf(espectaculo.getId()); //idEspectaculo
                listaEspectaculos.add("ID: "+idEspectaculo);
                String idArtista = String.valueOf(espectaculo.getId_artista());//idArtista
                listaEspectaculos.add("ID Artista organizador: "+idArtista);
                String idPlataforma = String.valueOf(espectaculo.getPlataforma());//id de Plataforma
                listaEspectaculos.add("Plataforma: "+idPlataforma);  

                lista_info_espectaculo.setListData((String[]) listaEspectaculos.toArray(new String[listaEspectaculos.size()]));

            }
        }
    }//GEN-LAST:event_lista_espectaculos_de_paqueteValueChanged

    private void lista_funciones_espectaculoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_funciones_espectaculoValueChanged
        int index = lista_funciones_espectaculo.getSelectedIndex();
        if (index != -1) {
            String item = lista_funciones_espectaculo.getSelectedValue();
            Funcion funcion = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_funcion_con_nombre(item);
            label_nombre_funcion.setText(funcion.getNombre());
            label_fecha_funcion.setText(funcion.getFecha().toString());
            label_hora_funcion.setText(Integer.toString(funcion.getHora_inicio()));
            label_fecha_registro_funcion.setText(funcion.getFecha_registro().toString());
        }
    }//GEN-LAST:event_lista_funciones_espectaculoValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new AltaEspectaculo().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Consulta_de_espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_de_espectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta_de_espectaculo().setVisible(true);
            }
        });
    }
    private String prev_espectaculo_item;
    private String prev_plataformas_item;
    private String prev_paquete_item;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combobox_plataforma;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel label_datos_funcion;
    private javax.swing.JLabel label_fecha_funcion;
    private javax.swing.JLabel label_fecha_registro_funcion;
    private javax.swing.JLabel label_hora_funcion;
    private javax.swing.JLabel label_nombre_funcion;
    private javax.swing.JList<String> lista_espectaculo_plataforma;
    private javax.swing.JList<String> lista_espectaculos_de_paquete;
    private javax.swing.JList<String> lista_funciones_espectaculo;
    private javax.swing.JList<String> lista_info_espectaculo;
    private javax.swing.JList<String> lista_info_paquete;
    private javax.swing.JList<String> lista_paquetes_asociados;
    // End of variables declaration//GEN-END:variables
}
