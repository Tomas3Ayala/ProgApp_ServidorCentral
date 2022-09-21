package logica.controllers;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.clases.Artista;
import logica.clases.Espectaculo;
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
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.nickname=?");
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
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.nickname='" + nickname + "'");
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
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.correo='" + correo + "'");
            ResultSet usuarios_set = query.executeQuery();
            if (usuarios_set.next()) // si se encontro un usuario con ese correo
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public int registrar_usuario(Usuario usuario) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO `usuario` (`nickname`, `nombre`, `apellido`, `correo`, `nacimiento`) VALUES (?, ?, ?, ?, ?)");
            query.setString(1, usuario.getNickname());
            query.setString(2, usuario.getNombre());
            query.setString(3, usuario.getApellido());
            query.setString(4, usuario.getCorreo());
            query.setDate(5, new java.sql.Date(usuario.getNacimiento().getTime()));
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

        int id_usuario = -1;
        
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM usuario as u WHERE u.nickname='" + usuario.getNickname() + "'");
            ResultSet usuarios_set = query.executeQuery();
            usuarios_set.next();
            id_usuario = usuarios_set.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_usuario;
    }

    @Override
    public void registrar_artista(Artista artista) {
        Connection conn = ConexionDB.getInstance().getConnection();
        int id_usuario = registrar_usuario(artista);
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
    public void registrar_espectador(Espectador espectador) {
        Connection conn = ConexionDB.getInstance().getConnection();
        int id_usuario = registrar_usuario(espectador);
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO `espectador` (`id`) VALUES (?)");
            query.setInt(1, id_usuario);
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
        // "UPDATE `usuario` SET `nickname` = '', `nombre` = '', `apellido` = '', `correo` = '', `nacimiento` = '2022-08-22' WHERE `usuario`.`id` = 1"
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
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.nickname=?");
            query.setString(1, nickname);
            ResultSet usuarios_set = query.executeQuery();
            usuarios_set.next();
            espectador = new Espectador(
                usuarios_set.getString("nickname"),
                usuarios_set.getString("nombre"),
                usuarios_set.getString("apellido"),
                usuarios_set.getString("correo"),
                usuarios_set.getDate("nacimiento"),
                usuarios_set.getInt("id")
            );
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectador;
    }
    
    @Override
    public Artista obtener_artista_de_nickname(String nickname) {
        Artista artista = null;

        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u WHERE u.nickname=?");
            query.setString(1, nickname);
            ResultSet usuarios_set = query.executeQuery();
            usuarios_set.next();
            artista = new Artista(
                "",
                "",
                "",
                usuarios_set.getString("nickname"),
                usuarios_set.getString("nombre"),
                usuarios_set.getString("apellido"),
                usuarios_set.getString("correo"),
                usuarios_set.getDate("nacimiento"),
                usuarios_set.getInt("id")
            );
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return artista;
        }

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM artista as a WHERE a.id=?");
            query.setInt(1, artista.getId());
            ResultSet artistas_set = query.executeQuery();
            artistas_set.next();
            artista.setDescripcion(artistas_set.getString("descripcion"));
            artista.setBiografia(artistas_set.getString("biografia"));
            artista.setSitio_web(artistas_set.getString("sitio_web"));
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
    
}
