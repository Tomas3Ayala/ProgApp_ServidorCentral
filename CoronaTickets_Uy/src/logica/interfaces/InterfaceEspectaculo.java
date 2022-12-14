package logica.interfaces;

import java.util.ArrayList;
import java.util.Date;
import logica.clases.Artista;
import logica.clases.Categoria;
import logica.clases.Espectaculo;
import logica.clases.Espectador;
import logica.clases.Funcion;
import logica.clases.Paquete;
import logica.clases.Registro_funcion;

public interface InterfaceEspectaculo {
    
    ArrayList<String> obtener_plataformas_disponibles();
    ArrayList<Espectaculo> obtener_espectaculos_con_plataforma(String plataforma);
    ArrayList<Funcion> obtener_funciones_de_espectaculo(int id);
    ArrayList<Espectaculo> obtener_espectaculos_ingresados();
    ArrayList<Espectaculo> obtener_espectaculos_de_artista(String nickname);
    ArrayList<String> obtener_espectaculos_aceptados();
    ArrayList<Espectaculo> get_espectaculos_aceptados();
    boolean aceptar_espectaculo (int id);
    boolean rechazar_espectaculo (int id);
    
    ArrayList<Espectaculo> obtener_espectaculos_aceptados_de_paquete(int id_paqu);
    ArrayList<Espectaculo> obtener_espectaculos_aceptados_no_de_paquete(int id_paqu);

    

    ArrayList<Espectador> obtener_espectadores();
    ArrayList<Registro_funcion> obtener_todos_los_registros_de_espectador(int id);
    ArrayList<Registro_funcion> obtener_registros_de_espectador(int id);
    Espectador obtener_espectador_de_nickname(String nombre);
    Funcion obtener_funcion_por_id(int id);
    Float obtener_costo_final_de_registro(int id_espectador, int id_espectaculo);
    
    void registrar_espectador_en_funcion_de_espectaculo(int id_espectador, int id_funcion, int costo);
    void registrar_espectador_en_funcion_de_espectaculo_con_fecha(int id_espectador, int id_funcion, int costo, Date fecha_registro);
    ArrayList<Funcion> obtener_funciones_de_espectaculo_no_llenas(int id);
    ArrayList<Espectador> obtener_espectadores_no_registrados_en_funcion(int id_funcion);
    void canjear_registro(int id_funcion, int id_espectador);
    
    
    Boolean registrar_paquete(Paquete paquete, byte[] imagen);
    
    Espectaculo obtener_espectaculo(int id);
    
    boolean chequear_si_nombre_de_espectaculo_esta_repetido_para_cierta_plataforma(String espectaculo, String plataforma);

    boolean chequear_si_nombre_de_funcion_esta_repetido(String nomfuncion);
    boolean chequear_si_nombre_de_paquete_esta_repetido(String nompaquete);

    public boolean existe_id_de_paquete(int id_paquete);
    public boolean existe_id_de_espectaculo(int id_espec);
    public boolean existe_id_de_funcion(int id_func);
    public boolean es_un_espectaculo_aceptado(int id_espec);
    public boolean es_funcion_de_espectaculo(int id_func, int id_espec);
    
    public ArrayList<String> obtener_nombres_de_paquetes_asociados_a_espectaculo(int id_espec);
    public ArrayList<String> obtener_nombres_de_paquetes_asociados_a_espectaculo_y_comprado_por(int id_espec, int id_user);
    
    public Paquete obtener_info_paquete(String nombre);

    public boolean esta_el_espectaculo_lleno(int id_espec);

    public boolean existe_paquete(String paquete);

    public boolean chequear_canje(int id_user, int canje);
    
    public byte[] obtener_imagen_funcion(int id_func);
    
    public Espectaculo obtener_espectaculo_de_funcion(int id_func);

    public byte[] obtener_imagen_espectaculo(int id_espec);

    public byte[] obtener_imagen_paquete(String paquete);
    
    public ArrayList<Paquete> obtener_paquetes_comprados_por_espectador(String nickname);
    
    void finalizar_espectaculo(int id_espectador);
    
    public void cargar_datos_de_prueba();
    

}
