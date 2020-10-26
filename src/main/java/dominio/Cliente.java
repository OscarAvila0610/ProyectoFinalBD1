
package dominio;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String nit;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String nombre, String apellido, String nit, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nit = nit;
        this.direccion = direccion;
    }

    public Cliente(String nit) {
        this.nit = nit;
    }
    
    
    

    public Cliente(int idCliente, String nombre, String apellido, String nit, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nit = nit;
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", nit=" + nit + ", direccion=" + direccion + '}';
    }
    
    
    
    
}
