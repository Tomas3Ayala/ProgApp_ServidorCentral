package logica.clases;

import java.io.Serializable;
import java.util.Date;

public class Registro_funcion implements Serializable {
    private Date fecha_registro;
    private int costo;
    private int id_funcion;
    private int id_espectador;

    public Registro_funcion(Date fecha_registro, int costo, int id_funcion, int id_espectador) {
        this.fecha_registro = fecha_registro;
        this.costo = costo;
        this.id_funcion = id_funcion;
        this.id_espectador = id_espectador;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public int getId_espectador() {
        return id_espectador;
    }

    public void setId_espectador(int id_espectador) {
        this.id_espectador = id_espectador;
    }
    
    
}
