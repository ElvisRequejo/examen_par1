/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luis
 */

    public class Conexion {
    private static final String URL="jdbc:postgresql://ec2-34-231-177-125.compute-1.amazonaws.com:5432/d7o9b15vh80ef4";
    private static final String DRIVER ="org.postgresql.Driver";
    private static final String PASS="658637e2f2da42bac2e9dee15459f8d0662df6ec060997b8e126a9804ce8fca5";
    private static final String USER="cicojussvcipoe";
    private static Connection cx = null;
    
    public static Connection getConexion(){
        try {
            Class.forName(DRIVER);
            if(cx==null){
                cx = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error:"+e);
        }
    return cx;
    }
}

