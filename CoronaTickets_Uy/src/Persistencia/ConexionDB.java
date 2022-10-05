
package Persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    public static Properties getProperties() {
        try {
            FileInputStream file = new FileInputStream("../config.properties");
            Properties prop = new Properties();
            prop.load(file);
            return prop;
        } catch (FileNotFoundException ex) {
            try {
                FileInputStream file = new FileInputStream(System.getProperty("user.home") + "\\Documents\\GitHub\\ProgApp_ServidorCentral\\config.properties");
                Properties prop = new Properties();
                prop.load(file);
                return prop;
            } catch (FileNotFoundException ex2) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex2) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Properties();
    }
    
    public static final Properties properties = getProperties();
//    
    public static final String host = properties.getProperty("host");
    public static final String port = properties.getProperty("port");
    public static final String db = properties.getProperty("db");
    public static final String user = properties.getProperty("user");
    public static final String pass = properties.getProperty("pass");
  
    public Connection conexion = null;

    private static ConexionDB instance;
    public static ConexionDB getInstance() {
        if (instance == null)
            instance = new ConexionDB();
        return instance;
    }
    
    public Connection getConnection() {
        if (conexion == null) {
            try {
                com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(driver);
                conexion = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
//        try {
//            FileOutputStream out = new FileOutputStream("config.properties");
//            Properties properties = new Properties();
//            properties.setProperty("host", "localhost");
//            properties.setProperty("port", "3306");
//            properties.setProperty("db", "empleadosgestor");
//            properties.setProperty("user", "user");
//            properties.setProperty("pass", "");
//            try {
//                properties.store(out, "---No Comment---");
//            } catch (IOException ex) {
//                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
//            } finally {
//                try {
//                    out.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return conexion;
    }
   
    public void close() {
        System.out.println("cerrando...");
        if (conexion != null) {
            try {
                conexion.close();
                conexion = null;
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
}