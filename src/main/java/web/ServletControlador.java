package web;

import datos.ClienteDaoJDBC;
import datos.ProductoDaoJDBC;
import datos.VentasDaoJDBC;
import dominio.Cliente;
import dominio.Producto;
import dominio.Venta;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")

public class ServletControlador extends HttpServlet {

    Cliente cliente = new Cliente();
    ClienteDaoJDBC cldao = new ClienteDaoJDBC();
    int idCliente;
    String nit;
    String dato;
    int codart;
    Venta venta = new Venta();
    VentasDaoJDBC vdao = new VentasDaoJDBC();
    List<Venta> lista = new ArrayList<>();
    int item;
    int idProducto;
    String descripcion;
    double precio;
    int cantidad;
    double subTotal;
    double totalPagar;
    int idVenta;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }

        if (menu.equals("Inicio")) {
            request.getRequestDispatcher("Inicio.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Agregar":
                    this.insertarCliente(request, response);
                    response.sendRedirect("ServletControlador?menu=Cliente&accion=Listar");
                    break;
                case "Actualizar":
                    String nombre = request.getParameter("txtNombre");
                    String apellido = request.getParameter("txtApellido");
                    String nit = request.getParameter("txtNit");
                    String direccion = request.getParameter("txtDireccion");

                    //Creamos el objeto de cliente (modelo)
                    Cliente cliente = new Cliente(idCliente, nombre, apellido, nit, direccion);

                    //Modificar el objeto en la base de datos
                    int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
                    System.out.println("registrosModificados = " + registrosModificados);
                    response.sendRedirect("ServletControlador?menu=Cliente&accion=Listar");
                    break;
            }
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Buscar":
                    dato = request.getParameter("txtBuscar");
                    List<Producto> productos = new ProductoDaoJDBC().buscar(dato);
                    System.out.println("producto = " + productos);
                    request.setAttribute("productos", productos);

            }
            request.getRequestDispatcher("Productos.jsp").forward(request, response);
        }
        if (menu.equals("Venta")) {
            switch (accion) {
                case "BuscarCliente":
                    nit = request.getParameter("nit");
                    cliente = new ClienteDaoJDBC().encontrarNit(new Cliente(nit));
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;

                case "BuscarProducto":
                    codart = Integer.parseInt(request.getParameter("codigoarticulo"));
                    Producto producto = new ProductoDaoJDBC().encontrar(new Producto(codart));
                    request.setAttribute("producto", producto);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("cliente", cliente);
                    break;

                case "Agregar":
                    totalPagar = 0.0;
                    item = item + 1;
                    idProducto = codart;
                    descripcion = request.getParameter("nombresproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    subTotal = precio * cantidad;
                    venta = new Venta();
                    venta.setItem(item);
                    venta.setIdProducto(idProducto);
                    venta.setDescripcion(descripcion);
                    venta.setPrecio(precio);
                    venta.setCantidad(cantidad);
                    venta.setSubtotal(subTotal);
                    lista.add(venta);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("cliente", cliente);
                    break;

                default:
                    request.getRequestDispatcher("Venta.jsp").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Venta.jsp").forward(request, response);
        }
        
        if (menu.equals("Reportes")) {
            request.getRequestDispatcher("reportes.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        System.out.println(menu);
        System.out.println(accion);
        if (menu.equals("Inicio")) {
            request.getRequestDispatcher("Inicio.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    this.accionDefault(request, response);
                    break;
                case "Editar":
                    idCliente = Integer.parseInt(request.getParameter("idCliente"));
                    Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
                    request.setAttribute("cliente", cliente);
                    break;
                case "Eliminar":
                    this.eliminarCliente(request, response);
                    break;
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    this.accionDefaultProducto(request, response);
                    break;
//                case "Buscar":
//                    dato = request.getParameter("txtBuscar");
//                    System.out.println("dato = " + dato);

            }
            request.getRequestDispatcher("Productos.jsp").forward(request, response);
        }
        if (menu.equals("Venta")) {
            switch (accion) {
                case "GenerarVenta":
                    //Guardar Venta
                    venta.setIdCliente(cliente.getIdCliente());
//                    venta.setFecha("2020-10-20");
                    vdao.guardarVenta(venta);
//                    //Guardar DetalleVenta
                    for (int i = 0; i < lista.size(); i++) {
                        venta = new Venta();
                        venta.setIdProducto(lista.get(i).getIdProducto());
                        venta.setDescripcion(lista.get(i).getDescripcion());
                        venta.setCantidad(lista.get(i).getCantidad());
                        venta.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVenta(venta);
                    }
                    venta.setMonto(totalPagar);
                    vdao.guardarFactura(venta);
                    lista = new ArrayList<>();
                    request.setAttribute("lista", lista);
                    break;

                default:
                    request.getRequestDispatcher("Venta.jsp").forward(request, response);
            }

            request.getRequestDispatcher("Venta.jsp").forward(request, response);
        }
        
        if (menu.equals("Reportes")) {
            request.getRequestDispatcher("reportes.jsp").forward(request, response);
        }

    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCliente
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String nit = request.getParameter("txtNit");
        String direccion = request.getParameter("txtDireccion");
        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(nombre, apellido, nit, direccion);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        idCliente = Integer.parseInt(request.getParameter("idCliente"));

        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void accionDefaultProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> productos = new ProductoDaoJDBC().listar();
        System.out.println("producto = " + productos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("productos", productos);
    }

}
