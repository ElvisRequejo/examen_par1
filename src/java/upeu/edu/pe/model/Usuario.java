/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author luis
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {
    private int idusuario;
    private String username;
    private String password;
    private int idpersona;
    private int idrol;
    private String fecha;
    private boolean estado;
    
    
    public boolean getEstado() {
		return this.estado;
	}

          
}
