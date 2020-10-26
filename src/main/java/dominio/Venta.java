
package dominio;


public class Venta {
    int idVenta;
    int item;
    int idCliente;
    int idUsuario;
    int idProducto;
    String NumSerie;
    String Descripcion;
    String fecha;
    Double precio;
    int cantidad;
    double subtotal;
    double monto;
    String estado;

    public Venta() {
    }

    public Venta(int idVenta, int item, int idCliente, int idUsuario, int idProducto, String NumSerie, String Descripcion, String fecha, Double precio, int cantidad, double subtotal, double monto, String estado) {
        this.idVenta = idVenta;
        this.item = item;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.NumSerie = NumSerie;
        this.Descripcion = Descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monto = monto;
        this.estado = estado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(String NumSerie) {
        this.NumSerie = NumSerie;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", item=" + item + ", idCliente=" + idCliente + ", idUsuario=" + idUsuario + ", idProducto=" + idProducto + ", NumSerie=" + NumSerie + ", Descripcion=" + Descripcion + ", fecha=" + fecha + ", precio=" + precio + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", monto=" + monto + ", estado=" + estado + '}';
    }
    
    
}
