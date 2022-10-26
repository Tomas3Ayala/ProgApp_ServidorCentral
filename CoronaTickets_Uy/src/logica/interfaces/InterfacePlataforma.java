/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces; 

import java.sql.Date;
import java.util.ArrayList;
import logica.clases.Artista;
import logica.clases.Categoria;
import logica.clases.Espectaculo;
import logica.clases.Funcion;
import logica.clases.Paquete;
import logica.clases.Plataforma;

/**
 *
 * @author 59892
 */
public interface InterfacePlataforma {
    boolean crear_Espectaculo(Espectaculo espectaculo, byte[] imagen);
    ArrayList<Artista> obtener_artistas_disponibles();
    ArrayList<Categoria> obtener_categorias();
    int ExtraerIdDeCombo (String combo);
    int ExtraeridPaquete (String nompaquete);

    int obtener_id_plataforma(String nombre_categoria);
    ArrayList<String> obtener_categorias_espectaculo(int idespec);

    int obtener_id_categoria(String nombre_categoria);
    
    
    boolean Alta_Categoria (Categoria c);
    boolean Alta_de_Funcion (Funcion f, byte[] imagen );
    boolean Alta_Plataforma (Plataforma p );
    boolean Agregar_espectaculo_a_paquete (int idEspectaculo, String nomPaquete );
    ArrayList<String> obtener_espectaculos_de_paquete(int idPaquete);
    ArrayList<Espectaculo> obtener_espectaculos_sin_plataforma(int idPaquete);
    int obtener_idespectaculo (String nomespe, String plataforma);
    int obtener_idespectaculo (String nomespe); // esto no esta bien
    int obtener_idfuncion(String nomfunc);
    int obtener_idartista(String nickname_artista);
    
    boolean insertar_Artista_Invitado ( int idartista, int idfuncion);
    boolean insertar_en_categoria_espectaculo (int idecategoria, int idespectaculo);
    ArrayList<Paquete> obtener_paquetes();
    ArrayList<Paquete> obtener_paquetes_de_plataforma(int idplata);
    Paquete obtener_info_paquetes (int idpaquete);
   // ArrayList<String> obtener_categorias_en_paquete(int idPaquete);
    ArrayList<Espectaculo> obtener_espectaculos_plataforma_quenoformanparte_paquete(String plataforma, String paquete);
    
    Funcion obtener_funcion_con_nombre(String nombre);
}
    

