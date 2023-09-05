/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import db.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Login;

/**
 *
 * @author Dario
 */
public class ControladorLogin implements ActionListener {
    private Conexion conexion;
    private Login login;

    public ControladorLogin(Conexion conexion, Login login) {
        this.conexion = conexion;
        this.login = login;
        this.login.jbtConectar.addActionListener(this);
        //this.login.jbtCancelar.addActionListener(this);
        
    }
    
    public void iniciarLogin(){
        login.setTitle("Ingrese Usuarios y Contraseña");
        login.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        conexion.setUsuario(login.jtxUsuario.getText());
        conexion.setClave(login.jtxClave.getText());
        conexion.setDb(login.jtxBaseDatos.getText());
        conexion.setPuerto(Integer.parseInt(login.jtxPuerto.getText()));
        conexion.setServidor(login.jtxServidor.getText());
        
        conexion.conectar();
        conexion.desconectar();
        
        
    }
    
}
