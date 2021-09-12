package controller;

import aplication.User;
import aplication.Admin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("form-login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String usuario = (String)request.getParameter("usuario");
        String senha = (String)request.getParameter("senha");

        // verifica os dados
        if ((usuario != null) && (senha != null)) {

            request.setAttribute("mensagem", "Usuário autenticado!");

            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            // redireciona para área restrita
            RequestDispatcher rd = request.getRequestDispatcher("dashboard-admin.jsp");
            rd.forward(request, response);

        } else {

            request.setAttribute("mensagem", "Usuário não identificado!");
            RequestDispatcher rd = request.getRequestDispatcher("form-login.jsp");
            rd.forward(request, response);

        }
    }
}
