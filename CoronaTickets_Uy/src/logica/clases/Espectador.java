package logica.clases;

import java.io.Serializable;
import java.util.Date;

public class Espectador extends Usuario implements Serializable {

    public Espectador(String nickname, String nombre, String apellido, String correo, Date nacimiento, int id, String contrasenia) {
        super(nickname, nombre, apellido, correo, nacimiento, id, contrasenia);
    }

}
