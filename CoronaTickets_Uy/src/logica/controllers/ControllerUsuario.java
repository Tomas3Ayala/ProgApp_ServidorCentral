package logica.controllers;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.clases.Artista;
import logica.clases.Espectaculo;
import logica.clases.Paquete;
import logica.clases.Espectador;
import logica.clases.Funcion;
import logica.clases.Usuario;
import logica.interfaces.InterfaceUsuario;

public class ControllerUsuario implements InterfaceUsuario{
    private static ControllerUsuario instance;
    public static ControllerUsuario getInstance() {
        if (instance == null)
            instance = new ControllerUsuario();
        return instance;
    }

    @Override
    public boolean chequear_si_nickname_es_de_artista(String nickname) {
        Connection conn = ConexionDB.getInstance().getConnection();
        int id = -1;
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.nickname=BINARY ?");
            query.setString(1, nickname);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next())
                id = usuarios_set.getInt("id");
            else // si no se encontro ningun usuario con ese nickname
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM artista as a WHERE a.id=?");
            query.setInt(1, id);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean chequear_nickname_repetido(String nickname) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.nickname=BINARY '" + nickname + "'");
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next()) // si se encontro un usuario con ese nickname
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean chequear_correo_repetido(String correo) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.correo=BINARY '" + correo + "'");
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next()) // si se encontro un usuario con ese correo
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public int registrar_usuario(Usuario usuario, byte[] imagen) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO `usuario` (`nickname`, `nombre`, `apellido`, `correo`, `nacimiento`, `contrasenia`, `imagen`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            query.setString(1, usuario.getNickname());
            query.setString(2, usuario.getNombre());
            query.setString(3, usuario.getApellido());
            query.setString(4, usuario.getCorreo());
            query.setDate(5, new java.sql.Date(usuario.getNacimiento().getTime()));
            query.setString(6, usuario.getContrasenia());
            query.setBytes(7, imagen);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

        int id_usuario = -1;
        
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM usuario as u WHERE u.nickname=BINARY '" + usuario.getNickname() + "'");
            ResultSet usuarios_set = query.executeQuery();
            usuarios_set.next();
            id_usuario = usuarios_set.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_usuario;
    }

    @Override
    public void registrar_artista(Artista artista, byte[] imagen) {
        Connection conn = ConexionDB.getInstance().getConnection();
        int id_usuario = registrar_usuario(artista, imagen);
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO `artista` (`descripcion`, `biografia`, `sitio_web`, `id`) VALUES (?, ?, ?, ?)");
            query.setString(1, artista.getDescripcion());
            query.setString(2, artista.getBiografia());
            query.setString(3, artista.getSitio_web());
            query.setInt(4, id_usuario);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void registrar_espectador(Espectador espectador, byte[] imagen) {
        Connection conn = ConexionDB.getInstance().getConnection();
        int id_usuario = registrar_usuario(espectador, imagen);
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO `espectador` (`id`) VALUES (?)");
            query.setInt(1, id_usuario);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void modificar_imagen_de_usuario(int id, byte[] imagen) {
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("UPDATE `usuario` SET `imagen` = ? WHERE `usuario`.`id` = ?");
            query.setBytes(1, imagen);
            query.setInt(2, id);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void modificar_espectador(int id, Espectador espectador) {
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("UPDATE `usuario` SET `nombre` = ?, `apellido` = ?, `nacimiento` = ? WHERE `usuario`.`id` = ?");
            query.setString(1, espectador.getNombre());
            query.setString(2, espectador.getApellido());
            query.setDate(3, new java.sql.Date(espectador.getNacimiento().getTime()));
            query.setInt(4, id);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (espectador.getContrasenia() != null) {
            try {
                PreparedStatement query = conn.prepareStatement("UPDATE `usuario` SET `contrasenia` = ? WHERE `usuario`.`id` = ?");
                query.setString(1, espectador.getContrasenia());
                query.setInt(2, id);
                query.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar_artista(int id, Artista artista) {
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("UPDATE `usuario` SET `nombre` = ?, `apellido` = ?, `nacimiento` = ? WHERE `usuario`.`id` = ?");
            query.setString(1, artista.getNombre());
            query.setString(2, artista.getApellido());
            query.setDate(3, new java.sql.Date(artista.getNacimiento().getTime()));
            query.setInt(4, id);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        if (artista.getContrasenia() != null) {
            if (artista.getContrasenia() != null) {
                try {
                    PreparedStatement query = conn.prepareStatement("UPDATE `usuario` SET `contrasenia` = ? WHERE `usuario`.`id` = ?");
                    query.setString(1, artista.getContrasenia());
                    query.setInt(2, id);
                    query.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        try {
            PreparedStatement query = conn.prepareStatement("UPDATE `artista` SET `descripcion` = ?, `biografia` = ?, `sitio_web` = ? WHERE `artista`.`id` = ?");
            query.setString(1, artista.getDescripcion());
            query.setString(2, artista.getBiografia());
            query.setString(3, artista.getSitio_web());
            query.setInt(4, id);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Espectador obtener_espectador_de_nickname(String nickname) {
        Espectador espectador = null;

        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.nickname=BINARY ?");
            query.setString(1, nickname);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next()) {
                espectador = new Espectador(
                        usuarios_set.getString("nickname"),
                        usuarios_set.getString("nombre"),
                        usuarios_set.getString("apellido"),
                        usuarios_set.getString("correo"),
                        usuarios_set.getDate("nacimiento"),
                        usuarios_set.getInt("id"),
                        usuarios_set.getString("contrasenia")
                );
            } else {
                return null;
            }
        }
            catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectador;
    }
    
    @Override
    public Artista obtener_artista_de_nickname(String nickname) {
        Artista artista = null;

        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.nickname=BINARY ?");
            query.setString(1, nickname);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next()) {
                artista = new Artista(
                    "",
                    "",
                    "",
                    usuarios_set.getString("nickname"),
                    usuarios_set.getString("nombre"),
                    usuarios_set.getString("apellido"),
                    usuarios_set.getString("correo"),
                    usuarios_set.getDate("nacimiento"),
                    usuarios_set.getInt("id"),
                    usuarios_set.getString("contrasenia")
                );
            }
            else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return artista;
        }

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM artista as a WHERE a.id=?");
            query.setInt(1, artista.getId());
            ResultSet artistas_set = query.executeQuery();
            if (artistas_set.next()) {
                artista.setDescripcion(artistas_set.getString("descripcion"));
                artista.setBiografia(artistas_set.getString("biografia"));
                artista.setSitio_web(artistas_set.getString("sitio_web"));
            }
            else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return artista;
        }
        return artista;
    }

    @Override
    public Artista obtener_artista_de_id(int id) {
        Artista artista = null;

        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.id=?");
            query.setInt(1, id);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next()) {
                artista = new Artista(
                    "",
                    "",
                    "",
                    usuarios_set.getString("nickname"),
                    usuarios_set.getString("nombre"),
                    usuarios_set.getString("apellido"),
                    usuarios_set.getString("correo"),
                    usuarios_set.getDate("nacimiento"),
                    usuarios_set.getInt("id"),
                    usuarios_set.getString("contrasenia")
                );
            }
            else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return artista;
        }

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM artista as a WHERE a.id=?");
            query.setInt(1, artista.getId());
            ResultSet artistas_set = query.executeQuery();
            if (artistas_set.next()) {
                artista.setDescripcion(artistas_set.getString("descripcion"));
                artista.setBiografia(artistas_set.getString("biografia"));
                artista.setSitio_web(artistas_set.getString("sitio_web"));
            }
            else
                return null;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return artista;
        }
        return artista;
    }
    
    @Override
    public ArrayList<String> obtener_nicknames_de_usuarios() {
        ArrayList<String> nicknames = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT nickname FROM usuario");
            ResultSet usuarios_set = query.executeQuery();
            while (usuarios_set.next()) {
                nicknames.add(usuarios_set.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nicknames;
    }
    
    @Override
    public boolean existe_nickname_de_usuario(String nickname) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT nickname FROM usuario WHERE nickname=BINARY ?");
            query.setString(1, nickname);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean existe_correo_de_usuario(String correo) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT nickname FROM usuario WHERE correo=BINARY ?");
            query.setString(1, correo);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public String obtener_nickname_de_correo(String correo) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT nickname FROM usuario WHERE correo=BINARY ?");
            query.setString(1, correo);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next())
                return usuarios_set.getString("nickname");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public byte[] obtener_imagen_usuario_con_nickname(String nickname) {
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT imagen FROM usuario WHERE nickname=BINARY ?");
            query.setString(1, nickname);
            ResultSet naves_set = query.executeQuery();
            if (naves_set.next()) {
                return naves_set.getBytes("imagen");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<Funcion> obtener_funciones_a_las_que_se_registro_espectador(int id) {
        ArrayList<Funcion> funciones = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT f.* FROM funcion as f, registro_funcion as r WHERE r.id_espectador=? AND r.id_funcion=f.id");
            query.setInt(1, id);
            ResultSet funciones_set = query.executeQuery();
            while (funciones_set.next()) {
                funciones.add(new Funcion(
                    funciones_set.getString("nombre"),
                    funciones_set.getDate("fecha"),
                    funciones_set.getInt("hora_inicio"),
                    funciones_set.getDate("fecha_registro"),
                    funciones_set.getInt("id"),
                    funciones_set.getInt("id_espectaculo")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funciones;
    }
    
    @Override
    public ArrayList<Espectaculo> obtener_espectaculos_organizados_por_artista(int id) {
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT p.nombre as plataforma, e.* FROM espectaculo as e, plataforma as p WHERE e.id_artista=? AND e.id_plataforma=p.id");
            query.setInt(1, id);
            ResultSet espectaculos_set = query.executeQuery();
            while (espectaculos_set.next()) {
                espectaculos.add(new Espectaculo(
                        espectaculos_set.getString("plataforma"),
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
    public boolean esta_usuario_registrado_a_funcion(int id_user, int id_func) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM registro_funcion as r WHERE r.id_espectador=? AND r.id_funcion=?");
            query.setInt(1, id_user);
            query.setInt(2, id_func);
            ResultSet set = query.executeQuery();
            if (set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Artista> obtener_artistas_invitados(int id_func) {
        ArrayList<Artista> artistas = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_artista FROM `artista_invitado` WHERE id_funcion=?");
            query.setInt(1, id_func);
            ResultSet set = query.executeQuery();
            while (set.next())
                artistas.add(obtener_artista_de_id(set.getInt("id_artista")));
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artistas;
    }

    @Override
    public boolean paquete_comprado( int idespectador,int  idpaquete) {
       Connection conn = ConexionDB.getInstance().getConnection();
       try {
           PreparedStatement query = conn.prepareStatement("SELECT * FROM compra_paquete WHERE id_espectador = ? and id_paquete = ?");
           query.setInt(1, idespectador);
           query.setInt(2, idpaquete);
           ResultSet set = query.executeQuery();
           if (set.next())
               return true;
            } 
       catch(SQLException e) {
          Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, e);      
       }
       return false;
    }

    @Override
    public boolean comprar_paquete(int idespectador, int idpaquete) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO compra_paquete (id_espectador,id_paquete ) VALUES (?,?)");
            query.setInt(1, idespectador);
            query.setInt(2, idpaquete);
            query.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Compra realizada con exito");
 
        } catch (SQLException e) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, e);
//            JOptionPane.showMessageDialog(null, "Compra NO realizada ");
        return false;
        }
        return false;
        
    }

    @Override
    public void seguir_a(String nick1, String nick2) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO seguido VALUES (?,?)");
            query.setInt(1, obtener_id_de_usuario(nick1));
            query.setInt(2, obtener_id_de_usuario(nick2));
            query.executeUpdate();
 
        } catch (SQLException e) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void dejar_de_seguir(String nick1, String nick2) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("DELETE FROM seguido WHERE id_seguidor=? AND id_seguido=?");
            query.setInt(1, obtener_id_de_usuario(nick1));
            query.setInt(2, obtener_id_de_usuario(nick2));
            query.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void marcar_favorito(String nick, int id_espectaculo) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO favoritos VALUES (?,?)");
            query.setInt(1, obtener_id_de_usuario(nick));
            query.setInt(2, id_espectaculo);
            query.executeUpdate();
 
        } catch (SQLException e) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, e);
        }  
    }

    @Override
    public void desmarcar_favorito(String nick, int id_espectaculo) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("DELETE FROM favoritos WHERE id_espectador=? AND id_espectaculo=?");
            query.setInt(1, obtener_id_de_usuario(nick));
            query.setInt(2, id_espectaculo);
            query.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, e);
        }   
    }
    
    @Override
    public boolean tiene_favorito_a(String nick1, int id_espectaculo) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM favoritos WHERE id_espectador=? AND id_espectaculo=?");
            query.setInt(1, obtener_id_de_usuario(nick1));
            query.setInt(2, id_espectaculo);
            ResultSet set = query.executeQuery();
            if (set.next())
                return true;
 
        } catch (SQLException e) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return false;    }
    

    @Override
    public boolean esta_siguiendo_a(String nick1, String nick2) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM seguido WHERE id_seguidor=? AND id_seguido=?");
            query.setInt(1, obtener_id_de_usuario(nick1));
            query.setInt(2, obtener_id_de_usuario(nick2));
            ResultSet set = query.executeQuery();
            if (set.next())
                return true;
 
        } catch (SQLException e) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
        return false;
    }

    @Override
    public int obtener_id_de_usuario(String nick) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM usuario WHERE nickname=BINARY ?");
            query.setString(1, nick);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next())
                return usuarios_set.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public String obtener_nick_de_usuario(int id) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT nickname FROM usuario WHERE id=?");
            query.setInt(1, id);
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next())
                return usuarios_set.getString("nickname");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public ArrayList<String> obtener_nicknames_de_usuarios_que_siguen_a(String nickname) {
        ArrayList<String> lista = new ArrayList<>();
        int id = obtener_id_de_usuario(nickname);
        if (id == -1)
            return null;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_seguidor FROM seguido WHERE id_seguido=?");
            query.setInt(1, id);
            ResultSet usuarios_set = query.executeQuery();
            while (usuarios_set.next())
                lista.add(obtener_nick_de_usuario(usuarios_set.getInt("id_seguidor")));
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public ArrayList<String> obtener_nicknames_de_usuarios_a_los_que_sigue(String nickname) {
        ArrayList<String> lista = new ArrayList<>();
        int id = obtener_id_de_usuario(nickname);
        if (id == -1)
            return null;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id_seguido FROM seguido WHERE id_seguidor=?");
            query.setInt(1, id);
            ResultSet usuarios_set = query.executeQuery();
            while (usuarios_set.next())
                lista.add(obtener_nick_de_usuario(usuarios_set.getInt("id_seguido")));
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public ArrayList<Usuario> obtener_usuarios() {
         ArrayList<Usuario> usuarios = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM `usuario`");
            
            ResultSet set = query.executeQuery();
            while (set.next()) {
                Artista artista = obtener_artista_de_id(set.getInt("id"));
                if (artista == null){
                    Espectador espectador = obtener_espectador_de_nickname(set.getString("nickname"));
                    usuarios.add(espectador);
                }
                else 
                    usuarios.add(artista);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public int obtener_cantidad_de_usuarios_que_siguen_a(String nickname) {
        int cant = 0;
         int id = obtener_id_de_usuario(nickname);
        if (id == -1)
          return cant;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT COUNT(id_seguidor) FROM seguido WHERE id_seguido=?");
            query.setInt(1, id);
            ResultSet usuarios_set = query.executeQuery();
            usuarios_set.next();
            cant = ((Number) usuarios_set.getObject(1)).intValue();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;  
    }

    @Override
    public int obtener_cantidad_de_usuarios_a_los_que_sigue(String nickname) {
        int cant = 0;
        int id = obtener_id_de_usuario(nickname);
        if (id == -1)
            return cant;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT COUNT(id_seguido) FROM seguido WHERE id_seguidor=?");
            query.setInt(1, id);
            ResultSet usuarios_set = query.executeQuery();
            usuarios_set.next();
            cant = ((Number) usuarios_set.getObject(1)).intValue();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;    
    }
    
}
