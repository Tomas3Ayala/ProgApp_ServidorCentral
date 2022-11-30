package logica.clases;

import java.io.Serializable;
import java.util.Date;

public class Funcion implements Serializable {
    private String nombre;
    private Date fecha;
    private int hora_inicio;
    private Date fecha_registro;
    private int id;
    private int id_espectaculo;

    public Funcion(String nombre, Date fecha, int hora_inicio, Date fecha_registro, int id, int id_espectaculo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.fecha_registro = fecha_registro;
        this.id = id;
        this.id_espectaculo = id_espectaculo;
    }
     public Funcion(String nombre, Date fecha, int hora_inicio, Date fecha_registro, int id_espectaculo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.fecha_registro = fecha_registro;
        this.id_espectaculo = id_espectaculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_espectaculo() {
        return id_espectaculo;
    }

    public void setId_espectaculo(int id_espectaculo) {
        this.id_espectaculo = id_espectaculo;
    }
    
}
