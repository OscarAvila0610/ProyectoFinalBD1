<%@page import="java.sql.SQLException"%>
<%@page import="datos.Conexion"%>
<%@page contentType = "text/html" pageEncoding="UTF-8"%>
<%@page import ="java.io.*"%>
<%@page import ="java.util.*"%>
<%@page import="net.sf.jasperreports.engine.*" %>
<%@page import="net.sf.jasperreports.view.JasperViewer" %>
<%@page import="javax.servlet.ServletResponse" %>
<%@page import="java.sql.Connection" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
            File reportfile = new File(application.getRealPath("ventasCliente.jasper"));

            Map<String, Object> parameter = new HashMap<String, Object>();
            Connection con = null;
            try {
                con = Conexion.getConnection();

                byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, con);

                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outputstream = response.getOutputStream();
                outputstream.write(bytes, 0, bytes.length);

                outputstream.flush();
                outputstream.close();

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {

                Conexion.close(con);
            }


        %>
    </body>
</html>