package logica.interfaces;

import java.util.ArrayList;
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
    boolean aceptar_espectaculo (int id);
    boolean rechazar_espectaculo (int id);

    

    ArrayList<Espectador> obtener_espectadores();
    ArrayList<Registro_funcion> obtener_registros_de_espectador(int id);
    Espectador obtener_espectador_de_nickname(String nombre);
    Funcion obtener_funcion_por_id(int id);
    Float obtener_costo_final_de_registro(int id_espectador, int id_espectaculo);
    
    void registrar_espectador_en_funcion_de_espectaculo(int id_espectador, int id_funcion, int costo);
    ArrayList<Funcion> obtener_funciones_de_espectaculo_no_llenas(int id);
    ArrayList<Espectador> obtener_espectadores_no_registrados_en_funcion(int id_funcion);
    void canjear_registro(int id_funcion, int id_espectador);
    
    
    Boolean registrar_paquete(Paquete paquete, byte[] imagen);
    
    Espectaculo obtener_espectaculo(int id);
    
    boolean chequear_si_nombre_de_espectaculo_esta_repetido_para_cierta_plataforma(String espectaculo, String plataforma);

    public boolean existe_id_de_espectaculo(int id_espec);
    public boolean existe_id_de_funcion(int id_func);
    public boolean es_un_espectaculo_aceptado(int id_espec);
    public boolean es_funcion_de_espectaculo(int id_func, int id_espec);
    
    public ArrayList<String> obtener_nombres_de_paquetes_asociados_a_espectaculo(int id_espec);
    
    public Paquete obtener_info_paquete(String nombre);

    public boolean esta_el_espectaculo_lleno(int id_espec);

    public boolean existe_paquete(String paquete);

    public boolean chequear_canje(int id_user, int canje);
    

}
