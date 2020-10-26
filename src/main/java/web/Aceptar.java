
package web;

import datos.UsuarioDaoJDBC;
import dominio.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Aceptar")
public class Aceptar extends HttpServlet{
    
    UsuarioDaoJDBC udao= new UsuarioDaoJDBC();
    Usuario us = new Usuario();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        processRequest(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Acceder")){
            String user=request.getParameter("textuser");
            String pass=request.getParameter("textpass");
            System.out.println("user = " + user);
            System.out.println("pass = " + pass);
            us=udao.validar(user, pass);
            System.out.println(us.getUsuario());
            System.out.println(us.getPass());
            if(us.getUsuario()!=null){
                request.setAttribute("usuario", us);
                request.getRequestDispatcher("ServletControlador?menu=Principal").forward(request, response);
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
