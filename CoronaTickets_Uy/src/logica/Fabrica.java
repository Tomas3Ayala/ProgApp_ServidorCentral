/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.controllers.ControladorEspectaculo;

import logica.controllers.ControladorPlataforma;
import logica.controllers.ControllerUsuario;
import logica.interfaces.InterfaceEspectaculo;

/**
 *
 * @author 59892
 */
public class Fabrica {
    public static String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    public static String WEB_REGEX = "^(https?:\\/\\/)?([\\w\\Q$-_+!*'(),%\\E]+\\.)+(\\w{2,63})(:\\d{1,4})?([\\w\\Q/$-_+!*'(),%\\E]+\\.?[\\w])*\\/?$";
    private static Fabrica instance = null;

    private Fabrica() {};
    
    public static Fabrica getInstance() {
    	if (instance == null) {
            instance = new Fabrica();
    	}
    	return instance;
    }
    
    //Descomenten mientras vayan creando/necesitando
    
    public InterfaceEspectaculo getInstanceControladorEspectaculo() {
    	return (InterfaceEspectaculo) ControladorEspectaculo.getInstance();
    }

    public ControladorPlataforma getInstanceControladorPlataforma() {
    	return ControladorPlataforma.getInstance();
    }
    
    public ControllerUsuario getInstanceControllerUsuario() {
        return ControllerUsuario.getInstance();
    }

}
