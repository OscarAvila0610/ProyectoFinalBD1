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
                            <i class="fab fa-accusoft"></i>Productos</h1>
                    </div>
                </div>
            </div>
        </header>
        <div class="navbar">
            <form class="form-inline" action="ServletControlador?menu=Producto" method="POST">
                <input type="submit" name="accion" value="Buscar" class="btn btn-outline-success">
                <input type="text" name="txtBuscar" class="form-control">
            </form>
        </div>

        <div class="col-sm-12">
            <table class="table table-hover">
                <thead>
                <th>ID</th>    
                <th>Marca</th>
                <th>Linea</th>
                <th>Modelo</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Existencia</th>
                </thead>
                <tbody>
                    <c:forEach var="producto" items="${productos}" varStatus="status" >
                        <tr>
                            <th>${producto.idArticulo}</th>    
                            <th>${producto.marcaVehiculo}</th>
                            <th>${producto.nombreLinea}</th>
                            <th>${producto.idModeloVehiculo}</th>
                            <th>${producto.nombreArticulo}</th>
                            <th><fmt:formatNumber value="${producto.precioVenta}" type="currency"/></th>
                            <th>${producto.existencia}</th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>