package logica.clases;

import java.io.Serializable;

public class Compra_paquete implements Serializable {
    private int id_espectador;
    private int id_paquete;

    public Compra_paquete(int id_espectador, int id_paquete) {
        this.id_espectador = id_espectador;
        this.id_paquete = id_paquete;
    }

    public int getId_espectador() {
        return id_espectador;
    }

    public void setId_espectador(int id_espectador) {
        this.id_espectador = id_espectador;
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }
    
    
}
