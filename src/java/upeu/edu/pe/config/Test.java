/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.config;

/**
 *
 * @author luis
 */
public class Test {
    public static void main(String[] args) {
            if(Conexion.getConexion()!=null){
            System.out.println("Conectado");
        }else{
            System.out.println("No conectado");
        }

        }
}
