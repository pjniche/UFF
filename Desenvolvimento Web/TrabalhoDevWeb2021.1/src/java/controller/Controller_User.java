package controller;

import model.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;

@WebServlet(name = "Controller_User", urlPatterns = {"/Controller_User"})
public class Controller_User extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO daoUser = new DAO();
        String option = (String)request.getParameter("option");
        ArrayList<User> usuarios;
        int id;

        User user = new User();

        switch (option) {

            case "adicionar":
                user.setNome("");
                user.setCpf("");
                user.setSenha("");
                user.setSuspenso("");

                request.setAttribute("user", user);
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-user.jsp");
                adicionar.forward(request, response);
                break;

            case "exibir":
                usuarios = daoUser.getListaUser();
                request.setAttribute("usuarios", usuarios);
                RequestDispatcher exibir = getServletContext().getRequestDispatcher("/user-list.jsp");
                exibir.forward(request, response);
                break;
        
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        try {
            User user = new User();

            user.setNome(request.getParameter("nome"));
            user.setCpf(request.getParameter("cpf"));
            user.setSenha(request.getParameter("senha"));
            user.setSuspenso(request.getParameter("suspenso"));

            DAO daoUser = new DAO();

            if (daoUser.gravarUser(user)) {
                mensagem = "Usuário gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar usuário!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/success.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar usuário!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
}
