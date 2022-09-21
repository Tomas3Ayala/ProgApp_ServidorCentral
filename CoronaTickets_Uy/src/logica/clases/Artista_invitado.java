package logica.clases;

public class Artista_invitado {
    private int id_artista;
    private int id_funcion;

    public Artista_invitado(int id_artista, int id_funcion) {
        this.id_artista = id_artista;
        this.id_funcion = id_funcion;
    }

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }
    
    
}
