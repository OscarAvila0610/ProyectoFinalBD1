<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <i class="fas fa-address-card"></i>Control de Clientes</h1>
                    </div>
                </div>
            </div>
        </header>
        <div div class="d-flex">
            <div class="card col col-sm-4">
                <div class="card-body">
                    <form action="ServletControlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" required value="${cliente.nombre}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Apellido</label>
                            <input type="text" required value="${cliente.apellido}" name="txtApellido" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>NIT</label>
                            <input type="text" required value="${cliente.nit}" name="txtNit" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" required value="${cliente.direccion}" name="txtDireccion" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                    <th>ID</th>    
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>NIT</th>
                    <th>Direccion</th>
                    <th>Opciones</th>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${clientes}" varStatus="status" >
                            <tr>
                                <th>${cliente.idCliente}</th>    
                                <th>${cliente.nombre}</th>
                                <th>${cliente.apellido}</th>
                                <th>${cliente.nit}</th>
                                <th>${cliente.direccion}</th>
                                <th>
                                    <a class="btn btn-warning" href="ServletControlador?menu=Cliente&accion=Editar&idCliente=${cliente.idCliente}">Editar</a>
                                    <a class="btn btn-danger" href="ServletControlador?menu=Cliente&accion=Eliminar&idCliente=${cliente.idCliente}">Eliminar</a>
                                </th>
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

