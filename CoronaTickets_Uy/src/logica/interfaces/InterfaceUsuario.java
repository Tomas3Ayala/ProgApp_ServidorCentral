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
    int registrar_usuario(Usuario usuario); // retorna -1 si no se pudo registrar el usuario, sino retorna el id del mismo
    void registrar_artista(Artista artista);
    void registrar_espectador(Espectador espectador);
    
    void modificar_espectador(int id, Espectador espectador);
    void modificar_artista(int id, Artista artista);
    
    Espectador obtener_espectador_de_nickname(String nickname);
    Artista obtener_artista_de_nickname(String nickname);
    
    ArrayList<String> obtener_nicknames_de_usuarios();
    
    ArrayList<Funcion> obtener_funciones_a_las_que_se_registro_espectador(int id);
    ArrayList<Espectaculo> obtener_espectaculos_organizados_por_artista(int id);
}
