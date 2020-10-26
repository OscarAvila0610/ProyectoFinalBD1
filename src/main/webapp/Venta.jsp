<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/cb702da7aa.js" crossorigin="anonymous"></script>
        <title>Sistema de Facturacion</title>
    </head>
    <body>
        <header id="main-header" class="py-2 bg-info text-white">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>
                            <i class="fas fa-file-invoice-dollar"></i>Ventas</h1>
                    </div>
                </div>
            </div>
        </header>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="ServletControlador?menu=Venta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col col-sm-6 d-flex">
                                    <input type="text" name="nit" value ="${cliente.nit}"class="form-control" placeholder="NIT">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                </div>
                                <div class="col col-sm-6">
                                    <input type="text" name="nombrescliente" value="${cliente.nombre} ${cliente.apellido}" placeholder="Datos Cliente" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col col-sm-6 d-flex">
                                    <input type="text" name="codigoarticulo" value="${producto.idArticulo}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">
                                </div>
                                <div class="col col-sm-6">
                                    <input type="text" name="nombresproducto" value="${producto.nombreArticulo}"placeholder="Datos Producto" class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class=" col col-sm-6 d-flex">
                                    <input type="text" name="precio" value ="${producto.precioVenta}" class="form-control" placeholder="Q.0.00">
                                </div>
                                <div class="col col-sm-3">
                                    <input type="number" name="cantidad" value="1" class="form-control">
                                </div>
                                <div class="col col-sm-3">
                                    <input type="text" name="stock" value ="${producto.existencia}"class="form-control" placeholder="Stock">
                                </div>
                            </div>
                            <div class="form-group">
                                <Button type="submit" onclick="alert('Producto Agregado Correctamente')" name="accion" value="Agregar" class="btn btn-outline-info">Agregar Producto</Button>
                            </div>
                        </div>
                    </form>    
                </div>
            </div>
            <div class ="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdProducto()}</td>
                                        <td>${list.getDescripcion()}</td>
                                        <td><fmt:formatNumber value="${list.getPrecio()}" type="currency"/></td>
                                        <td>${list.getCantidad()}</td>
                                        <td><fmt:formatNumber value="${list.getSubtotal()}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col col-sm-6" >
                            <a href="ServletControlador?menu=Venta&accion=GenerarVenta" onclick="alert('Venta Generada Correctamente')" class="btn btn-success">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="<fmt:formatNumber value="${totalPagar}" type="currency"/>"class="form-control">
                        </div>
                    </div>   
                </div>

            </div>
        </div>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
