package logica.clases;

import java.io.Serializable;
import java.util.Date;

public class Artista extends Usuario implements Serializable{
    private String descripcion;
    private String biografia;
    private String sitio_web;

    public Artista(String descripcion, String biografia, String sitio_web, String nickname, String nombre, String apellido, String correo, Date nacimiento, int id, String contrasenia) {
        super(nickname, nombre, apellido, correo, nacimiento, id, contrasenia);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitio_web = sitio_web;
    }
     public Artista(String descripcion, String nickname, String nombre, String apellido, String correo, Date nacimiento, int id, String contrasenia) {
        super(nickname, nombre, apellido, correo, nacimiento, id, contrasenia);
        this.descripcion = descripcion;
        
    }

    public String getDescripcion() {
        return descripcion;
    }
  
    

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }
    @Override
    public String toString() {
        return getNombre();
    }

}
