package logica.controllers;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Fabrica;
import logica.clases.Artista;
import logica.clases.Categoria;
import logica.clases.Espectaculo;
import logica.clases.Espectador;
import logica.clases.Funcion;
import logica.clases.Paquete;
import logica.clases.Plataforma;
import logica.clases.Registro_funcion;
import logica.enums.EstadoEspectaculo;
import logica.interfaces.InterfaceEspectaculo;

public class ControladorEspectaculo implements InterfaceEspectaculo{
    private static ControladorEspectaculo instance;
    public static ControladorEspectaculo getInstance() {
        if (instance == null)
            instance = new ControladorEspectaculo();
        return instance;
    }

    @Override
    public ArrayList<String> obtener_plataformas_disponibles() {
        ArrayList<String> plataformas = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT nombre FROM plataforma;");
            ResultSet plataformas_set = query.executeQuery();
            while (plataformas_set.next())
                plataformas.add(plataformas_set.getString("nombre"));
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plataformas;
    }

    @Override
    public ArrayList<Espectaculo> obtener_espectaculos_con_plataforma(String plataforma) {
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        int id_plataforma = -1;
        
        try {
            PreparedStatement query = conn.prepareStatement("SELECT id FROM plataforma as p WHERE p.nombre=BINARY '" + plataforma + "'");
            ResultSet plataformas_set = query.executeQuery();
            plataformas_set.next();
            id_plataforma = plataformas_set.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM espectaculo WHERE id_plataforma='" + id_plataforma + "';");
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
    public ArrayList<Funcion> obtener_funciones_de_espectaculo(int id) {
        ArrayList<Funcion> funciones = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM funcion WHERE id_espectaculo='" + id + "';");
            ResultSet funciones_set = query.executeQuery();
            while (funciones_set.next())
            {
                Funcion funcion = new Funcion(funciones_set.getString("nombre"), funciones_set.getDate("fecha"), funciones_set.getInt("hora_inicio"), funciones_set.getDate("fecha_registro"), funciones_set.getInt("id"), funciones_set.getInt("id_espectaculo"));
                funciones.add(funcion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funciones;
    }

    @Override
    public ArrayList<Espectador> obtener_espectadores() {
        ArrayList<Espectador> espectadores  = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u, espectador as e WHERE u.id=e.id");
            ResultSet espectadores_set = query.executeQuery();
            while (espectadores_set.next()) {
                espectadores.add(new Espectador(
                        espectadores_set.getString("nickname"),
                        espectadores_set.getString("nombre"),
                        espectadores_set.getString("apellido"),
                        espectadores_set.getString("correo"),
                        espectadores_set.getDate("nacimiento"),
                        espectadores_set.getInt("id"),
                        espectadores_set.getString("contrasenia")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectadores;
    }

    @Override
    public ArrayList<Registro_funcion> obtener_todos_los_registros_de_espectador(int id) { // registros aun no canjeados
        ArrayList<Registro_funcion> registros  = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM espectador as e, registro_funcion as r WHERE e.id=r.id_espectador AND e.id=?");
            query.setInt(1, id);
            ResultSet registros_set = query.executeQuery();
            while (registros_set.next()) {
                registros.add(new Registro_funcion(
                        registros_set.getDate("fecha_registro"),
                        registros_set.getInt("costo"),
                        registros_set.getInt("id_funcion"),
                        registros_set.getInt("id_espectador")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
    
    @Override
    public ArrayList<Registro_funcion> obtener_registros_de_espectador(int id) { // registros aun no canjeados
        ArrayList<Registro_funcion> registros  = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM espectador as e, registro_funcion as r WHERE e.id=r.id_espectador AND e.id='" + Integer.toString(id) + "' AND NOT r.canjeado");
            ResultSet registros_set = query.executeQuery();
            while (registros_set.next()) {
                registros.add(new Registro_funcion(
                        registros_set.getDate("fecha_registro"),
                        registros_set.getInt("costo"),
                        registros_set.getInt("id_funcion"),
                        registros_set.getInt("id_espectador")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
    
    @Override
    public Espectador obtener_espectador_de_nickname(String nick) { // esto funciona porque el nickname es unico
        Espectador espectador = new Espectador("ERROR", "ERROR", "ERROR", "ERROR", new Date(), -1, null);
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u, espectador as e WHERE u.id=e.id and u.nickname=BINARY '" + nick + "'");
            ResultSet espectadores_set = query.executeQuery();
            while (espectadores_set.next()) {
                espectador = new Espectador(
                        espectadores_set.getString("nickname"),
                        espectadores_set.getString("nombre"),
                        espectadores_set.getString("apellido"),
                        espectadores_set.getString("correo"),
                        espectadores_set.getDate("nacimiento"),
                        espectadores_set.getInt("id"),
                        espectadores_set.getString("contrasenia")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectador;
    }
    
    @Override
    public Funcion obtener_funcion_por_id(int id) {
        Funcion funcion = new Funcion("ERROR", new Date(), -1, new Date(), -1, -1);
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM funcion as f WHERE f.id=" + Integer.toString(id) + "");
            ResultSet espectadores_set = query.executeQuery();
            while (espectadores_set.next()) {
                funcion = new Funcion(
                        espectadores_set.getString("nombre"),
                        espectadores_set.getDate("fecha"),
                        espectadores_set.getInt("hora_inicio"),
                        espectadores_set.getDate("fecha_registro"),
                        espectadores_set.getInt("id"),
                        espectadores_set.getInt("id_espectaculo")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcion;
    }
    
    @Override
    public Float obtener_costo_final_de_registro(int id_espectador, int id_espectaculo) { // podria estar mal, hay que testear
        Float r = new Float(0);
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT e.costo FROM espectaculo as e WHERE e.id=" + Integer.toString(id_espectaculo));
            ResultSet costo_set = query.executeQuery();
            costo_set.next(); // se asume que solo hay un costo en la tabla
            r = new Float(costo_set.getInt("costo"));
//            System.out.println("costo base: " + r.toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement query = conn.prepareStatement("SELECT p.descuento FROM compra_paquete as c, paquete as p WHERE p.fecha_inicio <= NOW() AND NOW() <= p.fecha_fin AND c.id_paquete=p.id AND c.id_espectador=" + Integer.toString(id_espectador) + " AND " + Integer.toString(id_espectaculo) + " IN (SELECT pe.id_espectaculo FROM paquete_espectaculo as pe WHERE pe.id_paquete=p.id)");
            ResultSet paquetes_comprados_set = query.executeQuery();
            while (paquetes_comprados_set.next()) { // dentro de este while se aplican todos los descuentos
//                System.out.println("Hola!");
                r *= 1 - paquetes_comprados_set.getInt(1) / 100.0f;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    @Override
    public void registrar_espectador_en_funcion_de_espectaculo(int id_espectador, int id_funcion, int costo) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO registro_funcion (fecha_registro, costo, id_funcion, id_espectador, canjeado) VALUES (NOW(), " + costo + ", " + id_funcion + ", " + id_espectador + ", 0)");
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public ArrayList<Funcion> obtener_funciones_de_espectaculo_no_llenas(int id) {
        Integer cant_max = 0;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT max_espectador FROM espectaculo as e WHERE e.id=" + Integer.toString(id));
            ResultSet cant_max_set = query.executeQuery();
            cant_max_set.next(); // se asume que solo hay un espectaculo en la tabla
            cant_max = cant_max_set.getInt("max_espectador");
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Funcion> funciones = new ArrayList<>();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM funcion WHERE id_espectaculo='" + id + "' AND (SELECT COUNT(*) FROM registro_funcion WHERE id_funcion=funcion.id) < " + cant_max);
            ResultSet funciones_set = query.executeQuery();
            while (funciones_set.next())
            {
                Funcion funcion = new Funcion(funciones_set.getString("nombre"), funciones_set.getDate("fecha"), funciones_set.getInt("hora_inicio"), funciones_set.getDate("fecha_registro"), funciones_set.getInt("id"), funciones_set.getInt("id_espectaculo"));
                funciones.add(funcion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funciones;
    }
    
    @Override
    public ArrayList<Espectador> obtener_espectadores_no_registrados_en_funcion(int id_funcion) {
        ArrayList<Espectador> espectadores  = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();

        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM usuario as u, espectador as e WHERE u.id=e.id AND NOT EXISTS (SELECT * FROM registro_funcion as r WHERE r.id_espectador=e.id AND r.id_funcion=" + id_funcion + ")");
            ResultSet espectadores_set = query.executeQuery();
            while (espectadores_set.next()) {
                espectadores.add(new Espectador(
                        espectadores_set.getString("nickname"),
                        espectadores_set.getString("nombre"),
                        espectadores_set.getString("apellido"),
                        espectadores_set.getString("correo"),
                        espectadores_set.getDate("nacimiento"),
                        espectadores_set.getInt("id"),
                        espectadores_set.getString("contrasenia")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectadores;
    }
    
    @Override
    public void canjear_registro(int id_funcion, int id_espectador) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE registro_funcion SET canjeado = 1 WHERE registro_funcion.id_funcion = " + id_funcion + " AND registro_funcion.id_espectador = " + id_espectador);
            query.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Boolean registrar_paquete(Paquete paquete, byte[] imagen) { // retorna true si se pudo
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("INSERT INTO paquete (nombre, descripcion, fecha_inicio, fecha_fin, descuento, imagen) VALUES (?, ?, ?, ?, ?,?)");
            query.setString(1, paquete.getNombre());
            query.setString(2, paquete.getDescripcion());
            query.setDate(3, new java.sql.Date(paquete.getFecha_inicio().getTime()));
            query.setDate(4, new java.sql.Date(paquete.getFecha_fin().getTime()));
            query.setInt(5, paquete.getDescuento());
            query.setBytes(6, imagen);
            query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paquete creado con exito");
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062){ // 1062 es un error de dato unico duplicado
                JOptionPane.showMessageDialog(null, "El nombre ya esta en uso");
                return false;
            }
            else {
                Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al crear paquete");
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Espectaculo obtener_espectaculo(int id) {
        Espectaculo espectaculo = null;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT p.nombre as plataforma, e.* FROM espectaculo as e, plataforma as p WHERE e.id=? AND e.id_plataforma=p.id");
            query.setInt(1, id);
            ResultSet espectaculos_set = query.executeQuery();

            while (espectaculos_set.next()) {
                // String plataforma, String nombre, String descripcion, int duracion, int min_espectador, int max_espectador, String url, int costo, Date fecha_registro, int id, int id_artista, EstadoEspectaculo estado
                String est = espectaculos_set.getString("estado");
                espectaculo = new Espectaculo(
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
                        espectaculos_set.getInt("id_artista"),
                        EstadoEspectaculo.valueOf(est)
                       
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectaculo;
    }
    
    @Override
    public boolean chequear_si_nombre_de_paquete_esta_repetido(String nompaquete) {
    Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM paquete as p WHERE  p.nombre=BINARY ?");
            query.setString(1, nompaquete);
            ResultSet paquetes_set = query.executeQuery();

            if (paquetes_set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    
    @Override
    public boolean chequear_si_nombre_de_espectaculo_esta_repetido_para_cierta_plataforma(String espectaculo, String plataforma) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM espectaculo as e, plataforma as p WHERE p.id=e.id_plataforma AND p.nombre=BINARY ? AND e.nombre=BINARY ?");
            query.setString(1, plataforma);
            query.setString(2, espectaculo);
            ResultSet espectaculos_set = query.executeQuery();

            if (espectaculos_set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Espectaculo> obtener_espectaculos_ingresados() {
         ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT e.nombre, e.id FROM espectaculo as e where e.estado = 'INGRESADO'");
            ResultSet espectaculos_set = query.executeQuery();
            while (espectaculos_set.next()) 
                
                espectaculos.add( obtener_espectaculo(espectaculos_set.getInt("id")) );
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return espectaculos;
    }

    @Override
    public ArrayList<Espectaculo> obtener_espectaculos_de_artista(String nickname) {
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
           PreparedStatement query = conn.prepareStatement("SELECT e.id FROM espectaculo as e, usuario as u where e.id_artista=u.id AND u.nickname=?");
           query.setString(1, nickname);
           ResultSet espectaculos_set = query.executeQuery();
           while (espectaculos_set.next()) 
               espectaculos.add( obtener_espectaculo(espectaculos_set.getInt("e.id")) );

        } catch (SQLException ex) {
           Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return espectaculos;
    }

    @Override
    public boolean aceptar_espectaculo(int id) {
 Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE espectaculo SET estado = 'ACEPTADO' WHERE espectaculo.id = " + id + "");
            query.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean rechazar_espectaculo(int id) {
Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("UPDATE espectaculo SET estado = 'RECHAZADO' WHERE espectaculo.id = " + id + "");
            query.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    }

    @Override
    public ArrayList<Espectaculo> obtener_espectaculos_aceptados_de_paquete(int id_paqu) {
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT DISTINCT id_espectaculo FROM paquete_espectaculo WHERE id_paquete=?");
            query.setInt(1, id_paqu);
            ResultSet espectaculos_set = query.executeQuery();
            while (espectaculos_set.next()) {
                Espectaculo espectaculo = obtener_espectaculo(espectaculos_set.getInt("id_espectaculo"));
                if (espectaculo.getEstado() == EstadoEspectaculo.ACEPTADO)
                    espectaculos.add(espectaculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectaculos;
    }

    @Override
    public ArrayList<Espectaculo> obtener_espectaculos_aceptados_no_de_paquete(int id_paqu) {
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT e.id FROM espectaculo as e WHERE e.id NOT IN (SELECT p.id_espectaculo FROM paquete_espectaculo as p WHERE p.id_paquete=?)");
            query.setInt(1, id_paqu);
            ResultSet espectaculos_set = query.executeQuery();
            while (espectaculos_set.next()) {
                Espectaculo espectaculo = obtener_espectaculo(espectaculos_set.getInt("e.id"));
                if (espectaculo.getEstado() == EstadoEspectaculo.ACEPTADO)
                    espectaculos.add(espectaculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectaculos;
    }
    
    @Override
    public boolean chequear_si_nombre_de_funcion_esta_repetido(String nomfuncion) {
         Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM funcion as f WHERE f.nombre=BINARY ?");
            query.setString(1, nomfuncion);
            ResultSet espectaculos_set = query.executeQuery();

            if (espectaculos_set.next())
                return true;
                } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean existe_id_de_espectaculo(int id_espec) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM espectaculo WHERE id=?");
            query.setInt(1, id_espec);
            ResultSet espectaculos_set = query.executeQuery();

            if (espectaculos_set.next())

                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
     public ArrayList<String> obtener_espectaculos_aceptados() {
         ArrayList<String> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT e.nombre, e.id FROM espectaculo as e where e.estado = 'ACEPTADO'");
            ResultSet espectaculos_set = query.executeQuery();
             while (espectaculos_set.next())
                espectaculos.add(espectaculos_set.getString("nombre"));
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectaculos;
     }
            

    @Override
    public boolean existe_id_de_funcion(int id_func) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM funcion WHERE id=?");
            query.setInt(1, id_func);
            ResultSet funciones_set = query.executeQuery();

            if (funciones_set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean es_un_espectaculo_aceptado(int id_espec) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM espectaculo WHERE id=? AND estado='ACEPTADO'");
            query.setInt(1, id_espec);
            ResultSet espectaculos_set = query.executeQuery();

            if (espectaculos_set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean es_funcion_de_espectaculo(int id_func, int id_espec) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM funcion WHERE id=? AND id_espectaculo=?");
            query.setInt(1, id_func);
            query.setInt(2, id_espec);
            ResultSet funciones_set = query.executeQuery();

            if (funciones_set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<String> obtener_nombres_de_paquetes_asociados_a_espectaculo(int id_espec) {
        ArrayList<String> paquetes = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT p.nombre FROM paquete_espectaculo as pe, paquete as p where pe.id_espectaculo=? AND p.id=pe.id_paquete");
            query.setInt(1, id_espec);
            ResultSet paquetes_set = query.executeQuery();
            while (paquetes_set.next()) {
                paquetes.add(paquetes_set.getString("nombre"));
            }


        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paquetes;
    }

    @Override
    public Paquete obtener_info_paquete(String nombre) {
         Paquete paquete = null;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM paquete WHERE nombre=BINARY ?");
            query.setString(1, nombre);
            ResultSet paquetes_set = query.executeQuery();
            while (paquetes_set.next()) {
                paquete = new Paquete(
                    paquetes_set.getString("nombre"),
                    paquetes_set.getString("descripcion"),
                    paquetes_set.getDate("fecha_inicio"),
                    paquetes_set.getDate("fecha_fin"),
                    paquetes_set.getInt("descuento"),
                    paquetes_set.getInt("id")
                    // String nombre, String descripcion, Date fecha_inicio, Date fecha_fin, int descuento, int id
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return paquete;
    }

    @Override
    public boolean esta_el_espectaculo_lleno(int id_espec) {
         // "SELECT COUNT(*) FROM registro_funcion WHERE id_funcion=funcion.id"
        Espectaculo espectaculo = obtener_espectaculo(id_espec);
        int registros = -1;
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT COUNT(*) as suma FROM registro_funcion as r, funcion as f WHERE r.id_funcion=f.id AND f.id_espectaculo=?");
            query.setInt(1, id_espec);
            ResultSet set = query.executeQuery();
            set.next();
            registros = set.getInt("suma");

        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros >= espectaculo.getMax_espectador();
    }

    @Override
    public boolean existe_paquete(String paquete) {
    Connection conn = ConexionDB.getInstance().getConnection();
           try {
               PreparedStatement query = conn.prepareStatement("SELECT * FROM paquete WHERE nombre=BINARY ?");
               query.setString(1, paquete);
               ResultSet set = query.executeQuery();

               if (set.next())
                   return true;
           } catch (SQLException ex) {
               Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
           }
           return false;  
    }

    @Override
    public boolean chequear_canje(int id_user, int canje) {
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM registro_funcion as r WHERE r.id_espectador=? AND r.id_funcion=? AND NOT r.canjeado");
            query.setInt(1, id_user);
            query.setInt(2, canje);
            ResultSet set = query.executeQuery();
            if (set.next())
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public byte[] obtener_imagen_funcion(int id_func) {
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT imagen FROM funcion WHERE id=?");
            query.setInt(1, id_func);
            ResultSet set = query.executeQuery();
            if (set.next()) {
                return set.getBytes("imagen");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public byte[] obtener_imagen_espectaculo(int id_espec) {
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT imagen FROM espectaculo WHERE id=?");
            query.setInt(1, id_espec);
            ResultSet set = query.executeQuery();
            if (set.next()) {
                return set.getBytes("imagen");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Espectaculo obtener_espectaculo_de_funcion(int id_func) {
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT id_espectaculo FROM funcion WHERE id=?");
            query.setInt(1, id_func);
            ResultSet set = query.executeQuery();
            if (set.next())
                return obtener_espectaculo(set.getInt("id_espectaculo"));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public byte[] obtener_imagen_paquete(String paquete) {
        Connection con = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = con.prepareStatement("SELECT imagen FROM paquete WHERE nombre=BINARY ?");
            query.setString(1, paquete);
            ResultSet set = query.executeQuery();
            if (set.next()) {
                return set.getBytes("imagen");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Espectaculo> get_espectaculos_aceptados() {
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT e.nombre, e.id FROM espectaculo as e where e.estado = 'ACEPTADO'");
            ResultSet espectaculos_set = query.executeQuery();
            while (espectaculos_set.next()) {
                espectaculos.add(obtener_espectaculo(espectaculos_set.getInt("id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return espectaculos;
    }
    
    @Override
    public boolean existe_id_de_paquete(int id_paquete) {
        Connection conn = ConexionDB.getInstance().getConnection();
           try {
               PreparedStatement query = conn.prepareStatement("SELECT * FROM paquete WHERE id=?");
               query.setInt(1, id_paquete);
               ResultSet set = query.executeQuery();

               if (set.next())
                   return true;
           } catch (SQLException ex) {
               Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
           }
           return false;
    }
    
    @Override
    public ArrayList<Paquete> obtener_paquetes_comprados_por_espectador(String nickname)
    {
        ArrayList<Paquete> paquetes = new ArrayList<>();
        Connection conn = ConexionDB.getInstance().getConnection();
        try {
            PreparedStatement query = conn.prepareStatement("SELECT * FROM paquete as p, compra_paquete cp, usuario as u WHERE p.id=cp.id_paquete AND cp.id_espectador=u.id AND u.nickname=?");
            query.setString(1, nickname);
            ResultSet set = query.executeQuery();
            while (set.next())
            {
                boolean repetido = false;
                String nombre = set.getString("p.nombre");
                for (Paquete paquete : paquetes) {
                    if (paquete.getNombre().equals(nombre))
                        repetido = true;
                }
                if (!repetido)
                    paquetes.add(obtener_info_paquete(nombre));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEspectaculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paquetes;
    }

    @Override
    public void cargar_datos_de_prueba() {
        // eliminando datos
        // registro de datos
        String pass = "123";
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(new Espectador("eleven11", "Eleven", "Ten", "eleven11@gmail.com", new Date(1971, 12, 31), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(new Espectador("costas", "Gerardo", "Costas", "gcostas@gmail.com", new Date(1983, 11, 15), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(new Espectador("waston", "Emma", "Watson", "e.watson@gmail.com", new Date(1990, 4, 15), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(new Espectador("house", "Gregory", "House", "greghouse@gmail.com", new Date(1959, 5, 15), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(new Espectador("sergiop", "Sergio", "Puglia", "puglia@alpanpan.com.uy", new Date(1950, 01, 28), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(new Espectador("chino", "Alvaro", "Recoba", "chino@trico.org.uy", new Date(1976, 03, 17), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(new Espectador("tonyp", "Antonio", "Pacheco", "eltony@manya.org.uy", new Date(1955, 02, 14), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(new Espectador("lachiqui", "Mirtha", "Legrand", "lachiqui@hotmail.com.ar", new Date(1927, 2, 23), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_espectador(new Espectador("cbochinche", "Cacho", "Bochinche", "cbochinche@vera.com.uy", new Date(1937, 5, 8), -1, pass), null);

        Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(new Artista("Village People es una innovadora formación musical de estilo disco de finales de los años 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.","Grupo americano del disco creado por Jacques Morali y Henry Belolo en 1977. Según Marjorie Burgess, todo comenzó cuando Morali fue a un bar gay de Nueva York una noche y notó al bailarín Felipe Rose vestido como un nativo americano.","www.officialvillagepeople.com","vpeople", "Village", "People", "vpeople@tuta.io", new Date(1977, 1, 1), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(new Artista("Depeche Mode es un grupo inglés de música electrónica formado en Basildon, Essex, en 1980 por Vicent Clarke y Andrew John Fletcher, a los que se unieron Martin Lee Gore y poco después David Gahan. Actualmente se le considera como grupo de música alternativa.","NONE","www.depechemode.com","dmode", "Depeche", "Mode", "dmode@tuta.io", new Date(1980, 6, 14), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(new Artista("Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Después de participar en el grupo musical, Blue Angel, en 1983 firmó con Portrait Records (filial de Epic Records) y lanzó su exitoso álbum debut She's So Unusual a finales de ese mismo año. Siguió lanzando una serie de álbumes en los que encontró una inmensa popularidad, superando los límites de contenido de las letras de sus canciones.","Cynthia Ann Stephanie Lauper, (Brooklyn, Nueva York; 22 de junio de 1953). ","cyndilauper.com","clauper", "Cyndi", "Lauper", "clauper@hotmail.com", new Date(1953, 6, 22), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(new Artista("Bruce Frederick Joseph Springsteen (Long Branch, Nueva Jersey, 23 de septiembre de 1949),​ más conocido como Bruce Springsteen, es un cantante, músico y compositor estadounidense. ","NONE","brucespringsteen.net","bruceTheBoss", "Bruce", "Springsteen", "bruceTheBoss@gmail.com", new Date(1949, 9, 23), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(new Artista("La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998 e integrado inicialmente por Christian Cary (guitarra y voz), Fernando \"Paco\" Pintos (bajo y coros) y Rubén Otonello (actualmente su nuevo baterista es Rafael Ugo).","NONE","www.latriplenelson.uy","tripleNelson", "La Triple", "Nelson", "tripleNelson@tuta.io", new Date(1998, 1, 1), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(new Artista("La Ley fue una banda chilena de rock formada en 1987 por iniciativa del tecladista y guitarrista. En un principio, La Ley tenía la aspiración de ser un grupo de música tecno. Este disco resulta ser un éxito de ventas y reciben una invitación al Festival Internacional de Viña del Mar de febrero de 1994.","NONE","www.lasleyesdenewton.com","la_ley", "La", "Ley", "la_ley@tuta.io", new Date(1987, 2, 14), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(new Artista("Pimpinela es un dúo musical argentino compuesto por los hermanos Lucía Galán y Joaquín Galán. Pimpinela ha editado veinticuatro discos","NONE","www.pimpinela.net","lospimpi", "Pimpinela", "Pimpinela", "lospimpi@gmail.com", new Date(1981, 8, 13), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(new Artista("José Gómez Romero, conocido artísticamente como Dyango es un cantante español de música romántica.","NONE","NONE","dyangounchained", "Dyango", "Ango", "dyangounchained@gmail.com", new Date(1940, 3, 5), -1, pass), null);
        Fabrica.getInstance().getInstanceControllerUsuario().registrar_artista(new Artista("Su carrera comienza en 1976 cuando forma la banda Los Playeros junto a su hermano Víctor. Al poco tiempo se mudan a San Luis donde comienzan a hacerse conocidos en la escena musical. Su éxito a nivel nacional llega a comienzos de los años 1990 cuando desembarca en Buenos Aires y graba el éxito \"Violeta\", originalmente compuesta e interpretada en 1985 por el músico brasileño Luiz Caldas bajo el título «Fricote».","NONE","NONE","alcides", "Alcides", "Violeta", "alcides@tuta.io", new Date(1952, 7, 17), -1, pass), null);
        
        Fabrica.getInstance().getInstanceControladorPlataforma().Alta_Plataforma(new Plataforma("Instagram Live","Funcionalidad de la red social Instagram, con la que los usuarios pueden transmitir vídeos en vivo.","https://www.instagram.com/liveoficial", -1));
        Fabrica.getInstance().getInstanceControladorPlataforma().Alta_Plataforma(new Plataforma("Facebook Watch","Servicio de video bajo demanda operado por Facebook. ","https://www.facebook.com/watch/", -1));
        Fabrica.getInstance().getInstanceControladorPlataforma().Alta_Plataforma(new Plataforma("Twitter Live","Aplicación de Twitter para la transmisión de video en directo (streaming).","https://twitter.com/", -1));
        Fabrica.getInstance().getInstanceControladorPlataforma().Alta_Plataforma(new Plataforma("Youtube","Sitio web de origen estadounidense dedicado a compartir videos. ","https://www.youtube.com/", -1));

//        EstadoEspectaculo.ACEPTADO
//        Fabrica.getInstance().getInstanceControladorPlataforma().crear_Espectaculo(new Espectaculo(, pass, pass, 0, 0, 0, pass, 0, fecha_registro, 0, EstadoEspectaculo.ACEPTADO), null);
//        Fabrica.getInstance().getInstanceControladorPlataforma().crear_Espectaculo(new Espectaculo("Instagram Live", "Los Village Volvieron", "Espectáculo de retorno de los Village People.", 90, 10 ,  800, "https://www.instagram.com/realvillagepeople/", 550, new Date(20, 03, 31), 1, EstadoEspectaculo.ACEPTADO));
//        Fabrica.getInstance().getInstanceControladorPlataforma().crear_Espectaculo(new Espectaculo("Facebook Watch", "Global Spirit", "Espectáculo donde se presenta el álbum Spirit.", 120, 30 ,  1300, "https://es-la.facebook.com/depechemode/", 750, new Date(20, 04, 20), 2, EstadoEspectaculo.ACEPTADO));
//        Fabrica.getInstance().getInstanceControladorPlataforma().crear_Espectaculo(new Espectaculo("Twitter Live", "Memphis Blues World ", "Espectáculo promoviendo álbum Memphis Blues.", 110, 5 ,  1000, "https://twitter.com/cyndilauper", 800, new Date(20, 05, 30), 3, EstadoEspectaculo.ACEPTADO));
//        Fabrica.getInstance().getInstanceControladorPlataforma().crear_Espectaculo(new Espectaculo("Youtube", "Springsteen on Broadway", "Springsteen tocando guitarra o piano y relatando anécdotas recogidas en su autobiografía de 2016, Born to Run. ", 100, 100 ,  1500, "https://www.youtube.com/BruceSpringsteen", 980, new Date(20, 06, 07), 4, EstadoEspectaculo.ACEPTADO));
//        Fabrica.getInstance().getInstanceControladorPlataforma().crear_Espectaculo(new Espectaculo("Twitter Live", "Bien de Familia", "El dúo estará presentando sus más sonados éxitos y también nuevas canciones . ", 150, 1 0,  500, "https://twitter.com/PimpinelaNet", 500, new Date(20, 07, 08), 7, EstadoEspectaculo.ACEPTADO));
//        Fabrica.getInstance().getInstanceControladorPlataforma().crear_Espectaculo(new Espectaculo("Twitter Live", "30 años", "Espectáculo conmemorando los 30 años de Violeta.", 80, 30 ,  150, "https://twitter.com/alcides_shows", 450, new Date(20, 07, 31), 9, EstadoEspectaculo.ACEPTADO));
    }

}
