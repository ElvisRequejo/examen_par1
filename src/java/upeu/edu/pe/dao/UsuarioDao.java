/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.dao;

import java.util.List;
import upeu.edu.pe.model.Usuario;
import upeu.edu.pe.model.UsuarioLista;

/**
 *
 * @author luis
 */
public interface UsuarioDao {
      int create(Usuario usuario);
    int update(Usuario usuario);
    int delete(int id);
        UsuarioLista read(String user);
    List<UsuarioLista> readAll();
}
