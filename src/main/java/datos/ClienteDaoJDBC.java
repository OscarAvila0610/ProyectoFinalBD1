
package datos;

import dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC {
    
    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, nit, direccion "
            + "FROM cliente ORDER BY ID_CLIENTE";
    
    private static final String SQL_INSERT = "INSERT INTO cliente(id_cliente, nombre, apellido, nit, direccion) "
            + " VALUES((SELECT SERIE_CLIENTE FROM CLIENTE GROUP BY SERIE_CLIENTE), ?, ?, ?, ?)";
    
    private static final String SQL_UPDATE = "UPDATE cliente "
            + " SET nombre=?, apellido=?, nit=?, direccion=? where id_cliente=?";
    
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";
    
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, nit, direccion "
            + "FROM cliente WHERE id_cliente = ?";
    
    private static final String SQL_SELECT_BY_NIT = "SELECT id_cliente, nombre, apellido, nit, direccion "
            + "FROM cliente WHERE nit = ?";
    
    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nit = rs.getString("nit");
                String direccion = rs.getString("direccion");


                cliente = new Cliente(idCliente, nombre, apellido, nit, direccion);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }
    
    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro

            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String nit = rs.getString("nit");
            String direccion = rs.getString("direccion");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setNit(nit);
            cliente.setDireccion(direccion);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }
    
    public Cliente encontrarNit(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_NIT);
            stmt.setString(1, cliente.getNit());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro
            int idCliente = rs.getInt("id_cliente");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String nit = rs.getString("nit");
            String direccion = rs.getString("direccion");
            
            cliente.setIdCliente(idCliente);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setNit(nit);
            cliente.setDireccion(direccion);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }
    
    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getNit());
            stmt.setString(4, cliente.getDireccion());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getNit());
            stmt.setString(4, cliente.getDireccion());
            stmt.setInt(5, cliente.getIdCliente());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
