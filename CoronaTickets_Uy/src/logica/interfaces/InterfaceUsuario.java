package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Artista;
import logica.clases.Espectaculo;
import logica.clases.Espectador;
import logica.clases.Paquete;
import logica.clases.Funcion;
import logica.clases.Usuario;

public interface InterfaceUsuario {
    boolean chequear_si_nickname_es_de_artista(String nickname);
    boolean chequear_nickname_repetido(String nickname); // true si esta repetido
    boolean chequear_correo_repetido(String correo); // true si esta repetido
    int registrar_usuario(Usuario usuario, byte[] imagen); // retorna -1 si no se pudo registrar el usuario, sino retorna el id del mismo
    void registrar_artista(Artista artista, byte[] imagen);
    void registrar_espectador(Espectador espectador, byte[] imagen);
    void modificar_imagen_de_usuario(int id, byte[] imagen);
    
    void modificar_espectador(int id, Espectador espectador);
    void modificar_artista(int id, Artista artista);
    
    Espectador obtener_espectador_de_nickname(String nickname); // retorna siempre que halla un usuario con ese nickname, independientemente de si es un espectador (si no hay, lanza excepcion)
    Artista obtener_artista_de_nickname(String nickname); // retorna null si el usuario con ese nickname no es artista
    Artista obtener_artista_de_id(int id); // retorna null si el usuario con ese nickname no es artista
    
    ArrayList<String> obtener_nicknames_de_usuarios();
    ArrayList<Usuario> obtener_usuarios();
    boolean existe_nickname_de_usuario(String nickname);
    boolean existe_correo_de_usuario(String correo);
    String obtener_nickname_de_correo(String correo);

    byte[] obtener_imagen_usuario_con_nickname(String nickname);
    
    ArrayList<Funcion> obtener_funciones_a_las_que_se_registro_espectador(int id);
    ArrayList<Espectaculo> obtener_espectaculos_organizados_por_artista(int id);
    
    boolean esta_usuario_registrado_a_funcion(int id_user, int id_func);

    public ArrayList<Artista> obtener_artistas_invitados(int id_func);
    
    boolean paquete_comprado(int idespectador,int  idpaquete);
    boolean comprar_paquete(int idespectador,int  idpaquete);
    
    void seguir_a(String nick1, String nick2);
    void dejar_de_seguir(String nick1, String nick2);
    void marcar_favorito(String nick, int id_espectaculo);
    void desmarcar_favorito(String nick, int id_espectaculo);
    boolean esta_siguiendo_a(String nick1, String nick2);
    boolean tiene_favorito_a(String nick1, int id_espectaculo);
    int obtener_id_de_usuario(String nick);
    String obtener_nick_de_usuario(int id);
    
    ArrayList<String> obtener_nicknames_de_usuarios_que_siguen_a(String nickname);
    ArrayList<String> obtener_nicknames_de_usuarios_a_los_que_sigue(String nickname);
    
    int obtener_cantidad_de_usuarios_que_siguen_a(String nickname);
    int obtener_cantidad_de_usuarios_a_los_que_sigue(String nickname);
}
