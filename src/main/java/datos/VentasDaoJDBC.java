
package datos;


import dominio.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentasDaoJDBC {
    
    private static final String SQL_INSERT="INSERT INTO VENTA(ID_VENTA,ID_CLIENTE,FECHA) VALUES ((SELECT SERIE_VENTAS FROM VENTA GROUP BY SERIE_VENTAS),?,SYSDATE)";
    
    private static final String SQL_INSERT_DV="INSERT INTO DETALLE_VENTA(ID_VENTA, IDARTICULO,DESCRIPCION,CANTIDAD,PRECIOUNITARIO) VALUES ((SELECT MAX(ID_VENTA) FROM VENTA),?,?,?,?)";
    
    private static final String SQL_INSERT_FACT="INSERT INTO FACTURA(SERIE, FACTURA, ID_VENTA,TOTAL) VALUES ('A-1',(SELECT MAX(ID_VENTA) FROM VENTA),(SELECT MAX(ID_VENTA) FROM VENTA),?)";
    
    public int guardarVenta(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, venta.getIdCliente());
//            stmt.setString(2, venta.getFecha());
            

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int guardarDetalleVenta(Venta venta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_DV);
            stmt.setInt(1, venta.getIdProducto());
            stmt.setString(2, venta.getDescripcion());
            stmt.setInt(3, venta.getCantidad());
            stmt.setDouble(4, venta.getPrecio());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int guardarFactura(Venta venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_FACT);
            stmt.setDouble(1, venta.getMonto());
//            stmt.setString(2, venta.getFecha());
            

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
