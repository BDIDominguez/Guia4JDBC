/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dario
 */
public class Conexion {
    private String usuario;
    private String clave;
    private String servidor;
    private String db;
    private String driver = "com.mysql.cj.jdbc.Driver"; // com.mysql.cj.jdbc.Driver
    private Connection cSQL;
    private int puerto;
    // url "jdbc:mysql://localhost:3306/"
    
    public Conexion() {
    }

    public Conexion(String usuario, String clave, String servidor, String bd, int puerto) {
        this.usuario = usuario;
        this.clave = clave;
        this.servidor = servidor;
        this.db = bd;
        this.puerto = puerto;
        
    }
    
    public void conectar(){
        try {
            Class.forName(driver);
            cSQL = DriverManager.getConnection("jdbc:mysql://"+servidor+":" + puerto + "/"+db,usuario,clave);
            System.out.println("Conectado!!!");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se puede conectar con la Base de Datos \n" + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        /*
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
            
    }
    
    public void desconectar(){
        try {
            cSQL.close();
            System.out.println("Desconectando ...");
        } catch (SQLException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se puede cerrar la conexion con la Base de Datos \n" + ex.getMessage());
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Connection getcSQL() {
        return cSQL;
    }

    public void setcSQL(Connection cSQL) {
        this.cSQL = cSQL;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
    
    
}
