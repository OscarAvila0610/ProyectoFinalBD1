<!<!doctype html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

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
                            <i class="fab fa-accusoft"></i>Reportes</h1>
                    </div>
                </div>
            </div>
        </header>
        <div class="form-group d-flex">
            <div class="col col-sm-6 d-flex">
                <form name="form4" action="pdfFactura.jsp" target="black">
                    <input type="text" name="txtfactura" class="form-control" placeholder="Ingresar numero de factura">
                    <br>
                    <input type="submit" value="Generar PDF factura" class="btn btn-outline-info">
                </form>
            </div>
        </div>
        <div class="card-footer d-flex">
            <div class="col col-sm-3" >
                <form name="form1" action="reporteVentas.jsp" target="black">
                    <input type="submit" class="btn btn-success" value="Generar reporte de ventas" width="150"/>
                </form>
            </div>
            <div class="col col-sm-3 ml-auto">
                <form name="form2" action="reporteProdCli.jsp" target="black">
                    <input type="submit" class="btn btn-success" value="Generar reporte productos por cliente" width="150"/>
                </form>
            </div>
            <div class="col col-sm-3 ml-auto">
                <form name="form3" action="reporteFacturas.jsp" target="black">
                    <input type="submit" class="btn btn-success" value="Generar reporte de facturas" width="150"/>
                </form>
            </div>
            <div class="col col-sm-3 ml-auto">
                <form name="form3" action="VentaCliente.jsp" target="black">
                    <input type="submit" class="btn btn-success" value="Generar reporte ventas por cliente" width="150"/>
                </form>
            </div>
        </div>  
    </body>
</html>
