/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controllers;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.clases.Artista;
import logica.clases.Categoria;
import logica.clases.Espectaculo;
import logica.clases.Funcion;
import logica.clases.Paquete;
import logica.clases.Plataforma;
import logica.interfaces.InterfacePlataforma;

/**
 *
 * @author 59892
 */
public class ControladorPlataforma implements InterfacePlataforma {
 private static ControladorPlataforma instance;
    public static ControladorPlataforma getInstance() {
        if (instance == null)
            instance = new ControladorPlataforma();
        return instance;
    }
    
    @Override
    public boolean crear_Espectaculo(Espectaculo espectaculo, byte[] imagen) {
        Connection conn = ConexionDB.getInstance().getConnection();
        
        String nombrePlataforma = espectaculo.getPlataforma();
        int id_Plataforma = 0;
         try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM plataforma as p WHERE p.nombre='" + nombrePlataforma + "'");
            ResultSet plataformas_set = query.executeQuery();
            plataformas_set.next();
            id_Plataforma = plataformas_set.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO `espectaculo` (`nombre`, `descripcion`, `duracion`, `min_espectador`,`max_espectador`,`url`,`costo`,`fecha_registro`,`id_artista`, `id_plataforma`, `estado`, `imagen`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            query.setString(1, espectaculo.getNombre());
            query.setString(2, espectaculo.getDescripcion());
            query.setInt(3, espectaculo.getDuracion());
            query.setInt(4, espectaculo.getMin_espectador());
            query.setInt(5, espectaculo.getMax_espectador());
            query.setString(6, espectaculo.getUrl());
            query.setInt(7, espectaculo.getCosto());
            query.setDate(8, new java.sql.Date(espectaculo.getFecha_registro().getTime()));
            query.setInt(9, espectaculo.getId_artista());
            query.setInt(10, id_Plataforma);
            query.setString(11, espectaculo.getEstado().toString());
            query.setBytes(12, imagen);
            query.executeUpdate();
            // System.out.println("FECHA: " + nacimiento);
            
            

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062){ // 1062 es un error de dato unico duplicado 
//                JOptionPane.showMessageDialog(null, "Ya existe un Espectaculo "+espectaculo.getNombre()+" para la plataforma "+espectaculo.getPlataforma()+"");
                return false;
            }
            else
                Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    @Override
    public int ExtraerIdDeCombo (String combo){
     String [] extracion = combo.split("-");
        int id =  Integer.parseInt(extracion[0]); 
        return id;
    }
 /*@Override
    public int ExtraerIdEspectaculo (String nombre, String Plataforma ){
        
       Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM espectaculo where espectaculo.plataforma='" + Plataforma + "' and  espectaculo.nombre = '" + nombre + "';");
            ResultSet artistaid = query.executeQuery();
            int id = Integer.parseInt(artistaid.toString());
            return id;
        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(ControladorAgustin.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }  
    }*/
 @Override
    public  boolean Alta_de_Funcion (Funcion f, byte[] imagen){
     Connection conn = ConexionDB.getInstance().getConnection();
     try {
         PreparedStatement query = conn.prepareStatement("INSERT INTO `funcion` (`nombre`, `fecha`, `hora_inicio`, `fecha_registro`, `id_espectaculo`, `imagen`) VALUES (?,?,?,?,?,?)");
         query.setString(1, f.getNombre());
         query.setDate(2, (Date) f.getFecha());
         query.setInt(3, f.getHora_inicio());
         query.setDate(4, (Date) f.getFecha_registro());
         query.setInt(5, f.getId_espectaculo());
         query.setBytes(6, imagen);
         query.executeUpdate();



     } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062){ // 1062 es un error de dato unico duplicado 
                
                return false;}
            else
                Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
     return true;
    }
 @Override
   public boolean insertar_Artista_Invitado ( int idartista, int idfuncion){
       Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO `artista_invitado` (`id_artista`, `id_funcion`) VALUES (?,?)");
            query.setInt(1, idartista);
           query.setInt(2, idfuncion);
            query.executeUpdate();
            
    } catch (SQLException ex) {
         Logger.getLogger(ControladorPlataforma.class.getName()).log(Level.SEVERE, null, ex);
       return false;
     }
     return true;
   }
 @Override
   public boolean Alta_Plataforma (Plataforma p ){
        Connection conn = ConexionDB.getInstance().getConnection();
         try {
         PreparedStatement query = conn.prepareStatement("INSERT INTO `plataforma` (`nombre`, `descripcion`, `url`) VALUES (?,?,?)");
         query.setString(1, p.getNombre());
         query.setString(2, p.getDescripcion());
         query.setString(3, p.getUrl());
         query.executeUpdate();

     } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062){ // 1062 es un error de dato unico duplicado 

                return false;}
            else
                Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
     return true;
   }
    @Override
    public ArrayList<Artista> obtener_artistas_disponibles() {
       ArrayList<Artista> artistas = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM artista, usuario where usuario.id = artista.id ;");
            ResultSet artista_set = query.executeQuery();
            while  (artista_set.next()){
                
                    Artista artis = new Artista( 
                            
                            artista_set.getString("descripcion"),
                            artista_set.getString("biografia"),
                            artista_set.getString("sitio_web"),
                            artista_set.getString("nickname"),
                            artista_set.getString("nombre"),
                            artista_set.getString("apellido"),
                            artista_set.getString("correo"),
                            artista_set.getDate("nacimiento"),
                            artista_set.getInt("id"),
                            artista_set.getString("contrasenia")
                    );
                artistas.add(artis);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPlataforma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artistas;
    }
    @Override
    public ArrayList<Paquete> obtener_paquetes() {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM paquete");
            ResultSet paquetes_set = query.executeQuery();

            while (paquetes_set.next()) {
                paquetes.add(new Paquete(
                    paquetes_set.getString("nombre"),
                    paquetes_set.getString("descripcion"),
                    paquetes_set.getDate("fecha_inicio"),
                    paquetes_set.getDate("fecha_fin"),
                    paquetes_set.getInt("descuento"),
                    paquetes_set.getInt("id")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paquetes;
    }
 @Override
 public ArrayList<Paquete> obtener_paquetes_de_plataforma(int idplata){
     ArrayList<Paquete> paquetes = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * from paquete as p, espectaculo as e, paquete_espectaculo as pe where p.id = pe.id_paquete and e.id = pe.id_espectaculo and e.id = '" + idplata + "' ");
            ResultSet paquetes_set = query.executeQuery();

            while (paquetes_set.next()) {
                paquetes.add(new Paquete(
                    paquetes_set.getString("nombre"),
                    paquetes_set.getString("descripcion"),
                    paquetes_set.getDate("fecha_inicio"),
                    paquetes_set.getDate("fecha_fin"),
                    paquetes_set.getInt("descuento"),
                    paquetes_set.getInt("id")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paquetes;
 }
 @Override
 public int ExtraeridPaquete (String nompaquete){
     int idpaquete = 0;
     Connection conn = ConexionDB.getInstance().getConnection();
     try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM paquete WHERE nombre='" + nompaquete + "'");
            ResultSet paquete_set = query.executeQuery();
            paquete_set.next();
            idpaquete = paquete_set.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return idpaquete;
 }
 @Override
 public ArrayList<String> obtener_espectaculos_de_paquete(int idPaquete){
       ArrayList<String> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT e.nombre FROM espectaculo as e INNER JOIN plataforma on e.id_plataforma = plataforma.id where EXISTS (select * from paquete_espectaculo as pe where pe.id_paquete ='" + idPaquete + "' and e.id = pe.id_espectaculo)");
            ResultSet espectaculos_set = query.executeQuery();
            while (espectaculos_set.next())
                espectaculos.add(espectaculos_set.getString("nombre"));
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectaculos;
 }
 @Override
    public Paquete obtener_info_paquetes (int idpaquete){
        Paquete paquete = null;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM paquete WHERE paquete.id =?");
            query.setInt(1, idpaquete);
            ResultSet paquete_set = query.executeQuery();

            while (paquete_set.next()) {
                paquete = new Paquete(
                    paquete_set.getString("nombre"),
                    paquete_set.getString("descripcion"),
                    paquete_set.getDate("fecha_inicio"),
                    paquete_set.getDate("fecha_fin"),
                    paquete_set.getInt("descuento"),
                    paquete_set.getInt("id")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paquete;
    }

    @Override
    public int obtener_idespectaculo(String nomespe, String plataforma) {
        int idplata = obtener_id_plataforma(plataforma);
        
        int idespe = -1;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM espectaculo WHERE nombre ='" + nomespe + "' AND id_plataforma=?");
            query.setInt(1, idplata);
            ResultSet idespe_set = query.executeQuery();
            idespe_set.next();
            idespe = idespe_set.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return idespe;
    }
    
    @Override
    public int obtener_idespectaculo (String nomespe){
       int idespe = 0;
       Connection conn = ConexionDB.getInstance().getConnection();
       try {
         PreparedStatement query = conn.prepareStatement("SELECT id FROM espectaculo WHERE nombre ='" + nomespe + "'");
         ResultSet idespe_set = query.executeQuery();
         idespe_set.next();
            idespe = idespe_set.getInt("id");         
     } catch (SQLException ex) {
          Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
     }
       return idespe;
    }
    
 @Override
    public int obtener_idartista(String nickname_artista){
         int idartista = 0;
        Connection conn = ConexionDB.getInstance().getConnection();
         try {
         PreparedStatement query = conn.prepareStatement("SELECT id FROM usuario WHERE nickname ='" + nickname_artista + "'");
         ResultSet idartis_set = query.executeQuery();
         idartis_set.next();
            idartista = idartis_set.getInt("id");         
     } catch (SQLException ex) {
          Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        return idartista;
    }
    
 @Override
    public int obtener_idfuncion(String nomfunc){
        int idfuncion = 0;
        Connection conn = ConexionDB.getInstance().getConnection();
         try {
         PreparedStatement query = conn.prepareStatement("SELECT id FROM funcion WHERE nombre ='" + nomfunc + "'");
         ResultSet idespe_set = query.executeQuery();
         idespe_set.next();
            idfuncion = idespe_set.getInt("id");         
     } catch (SQLException ex) {
          Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        return idfuncion;
    }

    @Override
    public ArrayList<Espectaculo> obtener_espectaculos_plataforma_quenoformanparte_paquete(String plataforma, String paquete) {
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        int id_plataforma = -1;
        int id_paquete = -1;
        
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM plataforma as p WHERE p.nombre='" + plataforma + "'");
            ResultSet plataformas_set = query.executeQuery();
            plataformas_set.next();
            id_plataforma = plataformas_set.getInt("id");
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM paquete as p WHERE p.nombre='" + paquete + "'");
            ResultSet paquetes_set = query.executeQuery();
            paquetes_set.next();
            id_paquete = paquetes_set.getInt("id");
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM espectaculo as e INNER JOIN plataforma on e.id_plataforma = plataforma.id where not EXISTS (select * from paquete_espectaculo as pe where pe.id_paquete ='" + id_paquete + "' and e.id = pe.id_espectaculo) and e.id_plataforma = '" + id_plataforma + "';");
            ResultSet espectaculos_set = query.executeQuery();

            while (espectaculos_set.next()) {
                espectaculos.add(new Espectaculo(
                        plataforma,
                        espectaculos_set.getString("nombre"),
                        espectaculos_set.getString("descripcion"),
                        espectaculos_set.getInt("duracion"),
                        espectaculos_set.getInt("min_espectador"),
                        espectaculos_set.getInt("max_espectador"),
                        espectaculos_set.getString("url"),
                        espectaculos_set.getInt("costo"),
                        espectaculos_set.getDate("fecha_registro"),
                        espectaculos_set.getInt("id"),
                        espectaculos_set.getInt("id_artista")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectaculos;
    }
   
 @Override
    public boolean Agregar_espectaculo_a_paquete (int idEspectaculo, String nomPaquete ){
        Connection conn = ConexionDB.getInstance().getConnection();
        int id_paquete = 0;
        String nombreEspectaculo = "";
        //try para traer id paquete
         try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM paquete WHERE nombre='" + nomPaquete + "'");
            ResultSet paquete_set = query.executeQuery();
            paquete_set.next();
            id_paquete = paquete_set.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
         //try para traer el nombre del espectaculo
          try {
            PreparedStatement query = conn.prepareStatement("SELECT nombre FROM espectaculo WHERE id='" + idEspectaculo + "'");
            ResultSet nomespectaculo_set = query.executeQuery();
            nomespectaculo_set.next();
            nombreEspectaculo = nomespectaculo_set.getString("nombre");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        // try para agregar espectaculo al paquete
        try {
         PreparedStatement query = conn.prepareStatement("INSERT INTO `paquete_espectaculo` (`id_espectaculo`, `id_paquete`) VALUES (?,?)");
         query.setInt(1, idEspectaculo);
         query.setInt(2, id_paquete);
         
         query.executeUpdate();

         JOptionPane.showMessageDialog(null, "Se agrego el espectaculo '" + nombreEspectaculo + "' al paquete '" + nomPaquete + "' ");

     } catch (SQLException ex) {
         Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
     return true;
        
    }
    
    @Override
    public Funcion obtener_funcion_con_nombre(String nombre) {
        Funcion funcion = null;
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM funcion WHERE nombre='" + nombre + "';");
            ResultSet funciones_set = query.executeQuery();
            while (funciones_set.next())
                funcion = new Funcion(funciones_set.getString("nombre"), funciones_set.getDate("fecha"), funciones_set.getInt("hora_inicio"), funciones_set.getDate("fecha_registro"), funciones_set.getInt("id"), funciones_set.getInt("id_espectaculo"));
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcion;
    }

    @Override
    public ArrayList<Categoria> obtener_categorias() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM categoria");
            ResultSet categoria_set = query.executeQuery();
            while (categoria_set.next()) 
                
                categorias.add(new Categoria(categoria_set.getString("nombre"),categoria_set.getInt("id")));
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }
    
    
    @Override
    public boolean Alta_Categoria(Categoria c) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO `categoria` (`nombre`) VALUES (?)");
            query.setString(1, c.getNombre());
            

            query.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) { // 1062 es un error de dato unico duplicado 

                return false;
            } else {
                Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

  /*  @Override
    public ArrayList<String> obtener_categorias_en_paquete(int idPaquete) {
         ArrayList<String> categorias = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT e.categoria FROM espectaculo as e INNER JOIN plataforma on e.id_plataforma = plataforma.id where EXISTS (select * from paquete_espectaculo as pe where pe.id_paquete ='" + idPaquete + "' and e.id = pe.id_espectaculo)");
            ResultSet categorias_set = query.executeQuery();
            while (categorias_set.next())
                categorias.add(categorias_set.getString("nombre"));
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorias;

    }*/

    @Override
    public int obtener_id_plataforma(String nombre_plataforma) {
        int idplataforma = 0;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM plataforma WHERE nombre ='" + nombre_plataforma + "'");
            ResultSet idplataforma_set = query.executeQuery();
            idplataforma_set.next();
            idplataforma = idplataforma_set.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idplataforma;
    }
    
    @Override
    public int obtener_id_categoria(String nombre_categoria) {
       int idcategoria = 0;
       Connection conn = ConexionDB.getInstance().getConnection();
       try {
         PreparedStatement query = conn.prepareStatement("SELECT id FROM categoria WHERE nombre ='" + nombre_categoria + "'");
         ResultSet idcategoria_set = query.executeQuery();
         idcategoria_set.next();
            idcategoria = idcategoria_set.getInt("id");         
     } catch (SQLException ex) {
          Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
     }
       return idcategoria;
    }

    @Override
    public boolean insertar_en_categoria_espectaculo(int idecategoria, int idespectaculo) {
         Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO `categoria_espectaculo` (`id_categoria`, `id_espectaculo`) VALUES (?,?)");
            query.setInt(1, idecategoria);
            query.setInt(2, idespectaculo);
            query.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ControladorPlataforma.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    @Override
    public ArrayList<String> obtener_categorias_espectaculo(int idespec) {
         ArrayList<String> categorias = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT c.nombre FROM espectaculo as e, categoria as c, categoria_espectaculo as ce where ce.id_espectaculo = e.id and ce.id_categoria = c.id and  ce.id_espectaculo = "+idespec+" ");
            ResultSet categoria_set = query.executeQuery();
            while (categoria_set.next()) 
                
                categorias.add(categoria_set.getString("nombre"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }

}
    



