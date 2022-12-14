/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Persistencia.ConexionDB;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.clases.Espectaculo;
import logica.clases.Funcion;
import java.util.ArrayList;
import logica.Fabrica;
import logica.clases.Artista;
import java.sql.Date;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logica.clases.Categoria;
import logica.enums.EstadoEspectaculo;

import logica.interfaces.InterfaceEspectaculo;
import logica.interfaces.InterfacePlataforma;

/**
 *
 * @author 59892
 */
public class AltaEspectaculo extends javax.swing.JFrame {
ArrayList<String> listaCategorias = new ArrayList<>();

private InterfacePlataforma ICU;
DefaultListModel categorias = new DefaultListModel();
    /**
     * Creates new form AltaEspectaculo
     */
   public AltaEspectaculo() {
        
        initComponents();
        this.ICU = Fabrica.getInstance().getInstanceControladorPlataforma();
        lista_categorias.setModel(categorias);      
        
          ArrayList<Artista> artistas = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_artistas_disponibles();
         for (int i = 0; i<artistas.size(); i++ )
       {
           combobox_artista.addItem(artistas.get(i).getIdtoString()+"-"+ artistas.get(i).getNombre()+"-"+ artistas.get(i).getApellido());
       } 
        ArrayList<String> plataformas = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_plataformas_disponibles();

        plataformas.forEach((plataforma) -> {
            combobox_plataformas.addItem(plataforma);
        });
        
        ArrayList<Categoria> categoriass = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_categorias();

        categoriass.forEach((categoria) -> {
            comboCategoria.addItem(categoria.getNombre());
        });
        
        
        jDateFechaRegistro.setDate(new java.util.Date());
        
        
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
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        txtMinEspectadores = new javax.swing.JTextField();
        txtMaxEspectadores = new javax.swing.JTextField();
        txtUrl = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        combobox_artista = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jDateFechaRegistro = new com.toedter.calendar.JDateChooser();
        btnCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        imagen = new javax.swing.JLabel();
        btnagregar_categoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_categorias = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de Espectaculo");

        jLabel1.setText("Elija plataforma");

        combobox_plataformas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_plataformasActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripcion");

        jLabel4.setText("Duracion");

        jLabel5.setText("Minimo de espectadores");

        jLabel6.setText("Maximo de espectadores");

        jLabel7.setText("Url");

        jLabel8.setText("Costo");

        jLabel9.setText("Fecha de registro");

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        combobox_artista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_artistaActionPerformed(evt);
            }
        });

        jLabel10.setText("Artista Organizador");

        jDateFechaRegistro.setDateFormatString("yyyy-MM-dd");
        jDateFechaRegistro.setFocusCycleRoot(true);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButton1.setText("Ver espectaculos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Categorias");

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                imagenMouseReleased(evt);
            }
        });

        btnagregar_categoria.setText("Agregar categoria");
        btnagregar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar_categoriaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lista_categorias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaxEspectadores, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMinEspectadores, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combobox_artista, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addComponent(combobox_plataformas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCrear))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(90, 90, 90)
                                    .addComponent(btnagregar_categoria))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combobox_plataformas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMinEspectadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMaxEspectadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jDateFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(combobox_artista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnagregar_categoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(jButton1)
                            .addComponent(btnCrear))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(327, 327, 327))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combobox_plataformasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_plataformasActionPerformed
/*ArrayList<String> plataformas = Fabrica.getInstance().getInstanceControladorEspectaculo().obtener_plataformas_disponibles();

        plataformas.forEach((plataforma) -> {
            combobox_plataformas.addItem(plataforma);
        });  */ //No es necesario sino me trae las plataformas 2 veces    
    }//GEN-LAST:event_combobox_plataformasActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void combobox_artistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_artistaActionPerformed
       ArrayList<Artista> artistas = Fabrica.getInstance().getInstanceControladorPlataforma().obtener_artistas_disponibles();
        
    }//GEN-LAST:event_combobox_artistaActionPerformed
 public void limpiar() {
        txtNombre.setText(null);
        txtDescripcion.setText(null);
        txtDuracion.setText(null);
        txtMinEspectadores.setText(null);
        txtMaxEspectadores.setText(null);
        txtUrl.setText(null);
        txtCosto.setText(null);
        jDateFechaRegistro.setCalendar(null);
       
    }
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String plataforma = combobox_plataformas.getSelectedItem().toString();
//        String categoria = comboCategoria.getSelectedItem().toString();
        String nombre = txtNombre.getText();
//        if (categoria.length() == 0) {
//            JOptionPane.showMessageDialog(this, "Debe especificarse categoria");
//            return;
//        }
        
        if (nombre.length() == 0) {
            JOptionPane.showMessageDialog(this, "Debe especificarse un nombre para el nuevo espectaculo");
            return;
        }
        if (Fabrica.getInstance().getInstanceControladorEspectaculo().chequear_si_nombre_de_espectaculo_esta_repetido_para_cierta_plataforma(nombre, plataforma)) {
            JOptionPane.showMessageDialog(this, "El nombre del espectaculo ya esta siendo usado por otro en la plataforma " + plataforma);
            return;
        }
        
        int idArtista = this.ICU.ExtraerIdDeCombo(combobox_artista.getSelectedItem().toString());
        String descripcion = txtDescripcion.getText();
        int duracion = -1;
        try {
            duracion = Integer.parseInt(txtDuracion.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La duracion debe ser un numero");
            return;
        }
        int min_espectadores = 0;
        try {
            min_espectadores = Integer.parseInt(txtMinEspectadores.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El minimo de espectadores debe ser un numero");
            return;
        }
        int max_espectadores = 0;
        try {
            max_espectadores = Integer.parseInt(txtMaxEspectadores.getText());
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El maximo de espectadores debe ser un numero");
            return;
        }
        if (max_espectadores < min_espectadores) {
            JOptionPane.showMessageDialog(this, "El maximo de espectadores debe ser un numero mayor o igual al minimo de espectadores");
            return;
        }

        String url = txtUrl.getText();
        if (!url.matches(Fabrica.WEB_REGEX)) {
            JOptionPane.showMessageDialog(this, "La url no tiene un formato valido");
            return;
        }
        int costo = -1;
        try {
            costo = Integer.parseInt(txtCosto.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El costo debe ser un numero");
            return;
        }
        if (costo < 0) {
            JOptionPane.showMessageDialog(this, "El costo debe ser positivo");
            return;
        }
        if (min_espectadores <= 0) {
            JOptionPane.showMessageDialog(this, "El minimo de espectadores debe ser positivo");
            return;
        }
        if (max_espectadores <= 0) {
            JOptionPane.showMessageDialog(this, "La duracion debe ser un numero positivo");
            return;
        }
        if (duracion <= 0) {
            JOptionPane.showMessageDialog(this, "La duracion debe ser un numero positivo");
            return;
        }
        if (jDateFechaRegistro.getCalendar() == null) {
            JOptionPane.showMessageDialog(this, "La fecha de registro no tiene un formato valido");
            return;
        }
        String fecha = ((JTextField) jDateFechaRegistro.getDateEditor().getUiComponent()).getText();
        EstadoEspectaculo estado = EstadoEspectaculo.INGRESADO;
       
        Espectaculo es = new Espectaculo(plataforma,nombre,descripcion,duracion,min_espectadores,max_espectadores,url,costo,Date.valueOf(fecha), idArtista, estado);
        if (this.ICU.crear_Espectaculo(es, imageEspectaculo)) {
            int idespec = this.ICU.obtener_idespectaculo(nombre);
            for (int i = 0; i < listaCategorias.size(); i++) {
                String nomCategoria = listaCategorias.get(i);
                int idCategoria = this.ICU.obtener_id_categoria(nomCategoria);
                this.ICU.insertar_en_categoria_espectaculo(idCategoria, idespec);
            }
            //int idecatego = this.ICU.obtener_id_categoria(categoria);
            JOptionPane.showMessageDialog(this, "Se agrego el espectaculo correctamente");
        }
       else {
           JOptionPane.showMessageDialog(this, "Hubo un problema en agregar el espectaculo");
       }
       
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Consulta_de_espectaculo().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void imagenMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenMouseReleased
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                imageEspectaculo = Files.readAllBytes(file.toPath());
                imagen.setIcon(new ImageIcon(new ImageIcon(imageEspectaculo).getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), java.awt.Image.SCALE_SMOOTH)));

            } catch (IOException ex) {
                Logger.getLogger(RegistraUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_imagenMouseReleased

    private void btnagregar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar_categoriaActionPerformed
       String categorias_string = comboCategoria.getSelectedItem().toString();
        boolean existe = listaCategorias.contains(categorias_string);
        if(!existe){
        listaCategorias.add(categorias_string);
        categorias.addElement(categorias_string);
       // JOptionPane.showMessageDialog(null, "La categoria se agrego a la lista");
        }else{
            JOptionPane.showMessageDialog(null, "La categoria ya se encuentra en la lista");
        }
    }//GEN-LAST:event_btnagregar_categoriaActionPerformed

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
            java.util.logging.Logger.getLogger(AltaEspectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaEspectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaEspectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaEspectaculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaEspectaculo().setVisible(true);
            }
        });
    }
       private byte[] imageEspectaculo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnagregar_categoria;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> combobox_artista;
    private javax.swing.JComboBox<String> combobox_plataformas;
    private javax.swing.JLabel imagen;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateFechaRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista_categorias;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtMaxEspectadores;
    private javax.swing.JTextField txtMinEspectadores;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
