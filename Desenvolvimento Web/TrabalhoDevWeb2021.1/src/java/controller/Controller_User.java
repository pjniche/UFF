package controller;

import aplication.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO_User;

@WebServlet(name = "Controller_User", urlPatterns = {"/Controller_User"})
public class Controller_User extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO_User daoUser = new DAO_User();
        String option = (String)request.getParameter("option");
        ArrayList<User> usuarios;
        int id;

        User user = new User();

        switch (option) {

            case "adicionar":
                user.setId(0);
                user.setNome("");
                user.setCpf("");
                user.setSenha("");
                user.setSuspenso("");

                request.setAttribute("user", user);
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-user.jsp");
                adicionar.forward(request, response);
                break;

            case "listar":
                usuarios = daoUser.getListaUser();
                request.setAttribute("usuarios", usuarios);
                RequestDispatcher exibir = getServletContext().getRequestDispatcher("/list-user.jsp");
                exibir.forward(request, response);
                break;
            
            /*
            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                user = contatodao.getContatoPorID(id);

                if (contato.getId() > 0) {
                    request.setAttribute("contato", contato);
                    RequestDispatcher rs = request.getRequestDispatcher("FormContato.jsp");
                    rs.forward(request, response);
                } else {
                    String mensagem = "Erro ao gravar usuário!";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensagem.jsp");
                    rd.forward(request, response);
                }
                break;

            case "excluir":

                id = Integer.parseInt(request.getParameter("id"));
                contatodao.excluir(id);

                meusContatos = contatodao.getLista();
                request.setAttribute("meusContatos", meusContatos);
                RequestDispatcher aposexcluir = getServletContext().getRequestDispatcher("/ListaContatoView.jsp");
                aposexcluir.forward(request, response);
                break;
            */
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

            DAO_User daoUser = new DAO_User();

            if (daoUser.gravarUser(user)) {
                mensagem = "Usuário gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar usuário!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-admin.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro de exceção ao gravar usuário!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-admin.jsp");
            rd.forward(request, response);
        }
    }
}
