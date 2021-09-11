package model;

import model.User;
import model.Admin;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /*
    String usuario = request.getParameter("cpf");
    String senha = request.getParameter("senha");
    
    if (cpf != null && !cpf.isEmpty() && senha != null && !senha.isEmpty()) {
        session.getAttribute("usuario", usuario);
        response.sendRedirect("home-admin.jsp");
    }
    */
}