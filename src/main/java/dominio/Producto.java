
package dominio;


public class Producto {
    int idArticulo;
    String marcaVehiculo;
    String nombreLinea;
    int idModeloVehiculo;
    String nombreArticulo;
    double precioVenta;
    int existencia;

    public Producto() {
    }

    public Producto(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Producto(String marcaVehiculo, String nombreLinea, int idModeloVehiculo, String nombreArticulo, double precioVenta, int existencia) {
        this.marcaVehiculo = marcaVehiculo;
        this.nombreLinea = nombreLinea;
        this.idModeloVehiculo = idModeloVehiculo;
        this.nombreArticulo = nombreArticulo;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
    }

    public Producto(int idArticulo, String marcaVehiculo, String nombreLinea, int idModeloVehiculo, String nombreArticulo, double precioVenta, int existencia) {
        this.idArticulo = idArticulo;
        this.marcaVehiculo = marcaVehiculo;
        this.nombreLinea = nombreLinea;
        this.idModeloVehiculo = idModeloVehiculo;
        this.nombreArticulo = nombreArticulo;
        this.precioVenta = precioVenta;
        this.existencia = existencia;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getNombreLinea() {
        return nombreLinea;
    }

    public void setNombreLinea(String nombreLinea) {
        this.nombreLinea = nombreLinea;
    }

    public int getIdModeloVehiculo() {
        return idModeloVehiculo;
    }

    public void setIdModeloVehiculo(int idModeloVehiculo) {
        this.idModeloVehiculo = idModeloVehiculo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    @Override
    public String toString() {
        return "Producto{" + "idArticulo=" + idArticulo + ", marcaVehiculo=" + marcaVehiculo + ", nombreLinea=" + nombreLinea + ", idModeloVehiculo=" + idModeloVehiculo + ", nombreArticulo=" + nombreArticulo + ", precioVenta=" + precioVenta + ", existencia=" + existencia + '}';
    }
    
    
}
