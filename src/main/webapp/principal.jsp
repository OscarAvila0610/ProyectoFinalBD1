
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
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="ServletControlador?menu=Inicio" target="myframe">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="ServletControlador?menu=Producto&accion=Listar" target="myframe">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="ServletControlador?menu=Cliente&accion=Listar" target="myframe">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="ServletControlador?menu=Venta&accion=default" target="myframe">Venta</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border:none" class="btn btn-outline-light" href="ServletControlador?menu=Reportes" target="myframe">Reportes</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button style = "border:none"class="btn btn-danger dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Usuario Conectado
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">Activo</a>
                    <a class="dropdown-item" href="#">${usuario.getUsuario()}</a>
                    <div class="dropdown-divider"></div>
                    <form action="Aceptar" method="POST">
                        <button name="accion" value="salir"class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
        </nav>   
        <div class="m-4" style="height: 550px;">
            <iframe src="Inicio.jsp" name="myframe" style="height:100%; width: 100%; border: none">
            </iframe>
        </div>            
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

