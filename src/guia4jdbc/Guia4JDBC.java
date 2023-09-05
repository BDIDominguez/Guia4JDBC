/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia4jdbc;

import controlador.ControladorLogin;
import db.Conexion;
import vista.Login;

/**
 *
 * @author Dario
 */
public class Guia4JDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Conexion conexion = new Conexion();
       Login login = new Login();
       
       ControladorLogin crLogin = new ControladorLogin(conexion, login);
       crLogin.iniciarLogin();
       login.setVisible(true);
       
       
    }
    
}
