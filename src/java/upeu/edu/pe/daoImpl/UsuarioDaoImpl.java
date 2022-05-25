/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.pe.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import upeu.edu.pe.config.Conexion;
import upeu.edu.pe.dao.UsuarioDao;
import upeu.edu.pe.model.Usuario;
import upeu.edu.pe.model.UsuarioLista;

/**
 *
 * @author luis
 */
public class UsuarioDaoImpl implements UsuarioDao {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    
    @Override
    public int delete(int id) {
         String SQL = "DELETE FROM usuarios WHERE idusuario=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;  
    }
    
    @Override
    public int create(Usuario usuario) {
          String SQL = "select fc_create_usuario(?,?,?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setInt(3, usuario.getIdpersona());
            ps.setInt(4, usuario.getIdrol());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

   @Override
    public int update(Usuario usuario) {
         String SQL = "SELECT fc_update_usuario(?,?,?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
           ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
           
             ps.setInt(3, usuario.getIdusuario());
             ps.setBoolean(4, usuario.getEstado());
            
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return x;
    }

@Override
    public UsuarioLista read(String user) {
            String SQL = "select *from fc_validar_usuario2(?);";
        UsuarioLista usuario = new UsuarioLista();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while(rs.next()){
               usuario.setIdpersona(rs.getInt("idpersona"));
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setApelido(rs.getString("apellidos"));
                usuario.setNombrep(rs.getString("nombres"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombrer(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return usuario;
    }
    @Override
    public List<UsuarioLista> readAll() {
        String SQL = "SELECT *FROM fc_listar_usuario()";
        List<UsuarioLista> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                UsuarioLista usuario = new UsuarioLista();
                  
                usuario.setIdpersona(rs.getInt("idpersona"));
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setApelido(rs.getString("apellidos"));
                usuario.setNombrep(rs.getString("nombres"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombrer(rs.getString("nombre"));
                lista.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
        }
        return lista;
    }
    
}
