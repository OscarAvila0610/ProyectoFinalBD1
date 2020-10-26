package datos;

import dominio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoJDBC {

    String texto;

    private static final String SQL_SELECT = "SELECT A.IDARTICULO, M.MARCAVEHICULO, L.NOMBRELINEA, A.IDMODELOVEHICULO, A.NOMBREARTICULO, A.PRECIOVENTA, A.EXISTENCIA FROM ARTICULO A"
            + " JOIN LINEAVEHICULOS L ON A.IDLINEAVEHICULO = L.IDLINEAVEHICULO"
            + " JOIN MARCAVEHICULOS M ON L.IDMARCAVEHICULO = M.IDMARCAVEHICULO"
            + " ORDER BY M.IDMARCAVEHICULO";

    private static final String SQL_SELECT_BYID = "SELECT A.IDARTICULO, M.MARCAVEHICULO, L.NOMBRELINEA, A.IDMODELOVEHICULO, A.NOMBREARTICULO, A.PRECIOVENTA, A.EXISTENCIA FROM ARTICULO A"
            + " JOIN LINEAVEHICULOS L ON A.IDLINEAVEHICULO = L.IDLINEAVEHICULO"
            + " JOIN MARCAVEHICULOS M ON L.IDMARCAVEHICULO = M.IDMARCAVEHICULO"
            + " WHERE A.IDARTICULO=?";

    public List<Producto> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idArticulo = rs.getInt("IDARTICULO");
                String marcaVehiculo = rs.getString("MARCAVEHICULO");
                String nombreLinea = rs.getString("NOMBRELINEA");
                int idModeloVehiculo = rs.getInt("IDMODELOVEHICULO");
                String nombreArticulo = rs.getString("NOMBREARTICULO");
                double precioVenta = rs.getDouble("PRECIOVENTA");
                int existencia = rs.getInt("EXISTENCIA");

                producto = new Producto(idArticulo, marcaVehiculo, nombreLinea, idModeloVehiculo, nombreArticulo, precioVenta, existencia);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }

    public List<Producto> buscar(String texto) {

        String sql;
        sql = "SELECT A.IDARTICULO, M.MARCAVEHICULO, L.NOMBRELINEA, A.IDMODELOVEHICULO, A.NOMBREARTICULO, A.PRECIOVENTA, A.EXISTENCIA FROM ARTICULO A"
                + " JOIN LINEAVEHICULOS L ON A.IDLINEAVEHICULO = L.IDLINEAVEHICULO"
                + " JOIN MARCAVEHICULOS M ON L.IDMARCAVEHICULO = M.IDMARCAVEHICULO"
                + " WHERE M.MARCAVEHICULO LIKE '%" + texto + "%' OR L.NOMBRELINEA LIKE '%" + texto + "%' OR A.NOMBREARTICULO LIKE '%" + texto + "%'";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idArticulo = rs.getInt("IDARTICULO");
                String marcaVehiculo = rs.getString("MARCAVEHICULO");
                String nombreLinea = rs.getString("NOMBRELINEA");
                int idModeloVehiculo = rs.getInt("IDMODELOVEHICULO");
                String nombreArticulo = rs.getString("NOMBREARTICULO");
                double precioVenta = rs.getDouble("PRECIOVENTA");
                int existencia = rs.getInt("EXISTENCIA");

                producto = new Producto(idArticulo, marcaVehiculo, nombreLinea, idModeloVehiculo, nombreArticulo, precioVenta, existencia);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }

    public Producto encontrar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BYID);
            stmt.setInt(1, producto.getIdArticulo());
            rs = stmt.executeQuery();
            rs.next();//nos posicionamos en el primer registro

            int idArticulo = rs.getInt("IDARTICULO");
            String marcaVehiculo = rs.getString("MARCAVEHICULO");
            String nombreLinea = rs.getString("NOMBRELINEA");
            int idModeloVehiculo = rs.getInt("IDMODELOVEHICULO");
            String nombreArticulo = rs.getString("NOMBREARTICULO");
            double precioVenta = rs.getDouble("PRECIOVENTA");
            int existencia = rs.getInt("EXISTENCIA");

            producto.setIdArticulo(idArticulo);
            producto.setMarcaVehiculo(marcaVehiculo);
            producto.setNombreLinea(nombreLinea);
            producto.setIdModeloVehiculo(idModeloVehiculo);
            producto.setNombreArticulo(nombreArticulo);
            producto.setPrecioVenta(precioVenta);
            producto.setExistencia(existencia);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return producto;
    }
}
