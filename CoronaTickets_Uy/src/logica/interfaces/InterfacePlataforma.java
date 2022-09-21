/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces; 

import java.sql.Date;
import java.util.ArrayList;
import logica.clases.Artista;
import logica.clases.Espectaculo;
import logica.clases.Funcion;
import logica.clases.Paquete;
import logica.clases.Plataforma;

/**
 *
 * @author 59892
 */
public interface InterfacePlataforma {
    boolean crear_Espectaculo(Espectaculo espectaculo);
    ArrayList<Artista> obtener_artistas_disponibles();
    int ExtraerIdDeCombo (String combo);
    int ExtraeridPaquete (String nompaquete);
   
    boolean Alta_de_Funcion (Funcion f );
    boolean Alta_Plataforma (Plataforma p );
    boolean Agregar_espectaculo_a_paquete (int idEspectaculo, String nomPaquete );
    ArrayList<String> obtener_espectaculos_de_paquete(int idPaquete);
    int obtener_idespectaculo (String nomespe);
    int obtener_idfuncion(String nomfunc);
    int obtener_idartista(String nickname_artista);
    
    boolean insertar_Artista_Invitado ( int idartista, int idfuncion);
    ArrayList<Paquete> obtener_paquetes();
    ArrayList<Paquete> obtener_paquetes_de_plataforma(int idplata);
    Paquete obtener_info_paquetes (int idpaquete);
    ArrayList<Espectaculo> obtener_espectaculos_plataforma_quenoformanparte_paquete(String plataforma, String paquete);
    
    Funcion obtener_funcion_con_nombre(String nombre);
}
    
