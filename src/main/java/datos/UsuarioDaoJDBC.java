
package datos;

import dominio.Usuario;
import java.sql.*;
import java.util.*;


public class UsuarioDaoJDBC {
   
    private static final String SQL_SELECT = "select * from usuario where usuario = ? and pass = ?";
    
    public Usuario validar(String user, String pass){
       System.out.println("user = " + user);
       System.out.println("pass = " + pass); 
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs = null; 
       Usuario us = new Usuario(); 
      try {
          conn = Conexion.getConnection();
          stmt = conn.prepareStatement(SQL_SELECT);
          stmt.setString(1, user);
          stmt.setString(2, pass);
          rs=stmt.executeQuery();
          while(rs.next()){
              us.setIdUsuario(rs.getInt("idusuario"));
              us.setUsuario(rs.getString("usuario"));
              us.setPass(rs.getString("pass"));
          }
          System.out.println(us.toString());
      }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
      } 
      System.out.println(us.toString());
      return us;
    }
}
