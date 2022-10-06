package logica.interfaces;

import java.util.ArrayList;
import logica.clases.Artista;
import logica.clases.Espectaculo;
import logica.clases.Espectador;
import logica.clases.Funcion;
import logica.clases.Usuario;

public interface InterfaceUsuario {
    boolean chequear_si_nickname_es_de_artista(String nickname);
    boolean chequear_nickname_repetido(String nickname); // true si esta repetido
    boolean chequear_correo_repetido(String correo); // true si esta repetido
    int registrar_usuario(Usuario usuario, byte[] imagen); // retorna -1 si no se pudo registrar el usuario, sino retorna el id del mismo
    void registrar_artista(Artista artista, byte[] imagen);
    void registrar_espectador(Espectador espectador, byte[] imagen);
    
    void modificar_espectador(int id, Espectador espectador);
    void modificar_artista(int id, Artista artista);
   // byte[] obtener_imagen_usuario (int id);
    
    Espectador obtener_espectador_de_nickname(String nickname); // retorna siempre que halla un usuario con ese nickname, independientemente de si es un espectador (si no hay, lanza excepcion)
    Artista obtener_artista_de_nickname(String nickname); // retorna null si el usuario con ese nickname no es artista
    
    ArrayList<String> obtener_nicknames_de_usuarios();
    boolean existe_nickname_de_usuario(String nickname);
    
    ArrayList<Funcion> obtener_funciones_a_las_que_se_registro_espectador(int id);
    ArrayList<Espectaculo> obtener_espectaculos_organizados_por_artista(int id);
}
