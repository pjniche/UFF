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
        User usuario = new User();
        ArrayList<User> usuarios;
        ArrayList<User> administradores;
        int id;

        String option = (String)request.getParameter("option");

        switch (option) {

            case "adicionar":
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-user.jsp");
                adicionar.forward(request, response);
                break;

            case "listar":
                usuarios = daoUser.getListaUser();
                request.setAttribute("usuarios", usuarios);
                RequestDispatcher listar = getServletContext().getRequestDispatcher("/list-user.jsp");
                listar.forward(request, response);
                break;
            
            case "editar":
                id = Integer.parseInt(request.getParameter("id_usuario"));
                usuario = daoUser.getUserByID(id);
                request.setAttribute("usuario", usuario);
                RequestDispatcher editar = getServletContext().getRequestDispatcher("/form-user-edit.jsp");
                editar.forward(request, response);
                break;

            case "excluir":
                id = Integer.parseInt(request.getParameter("id_usuario"));

                if (daoUser.excluirUser(id)) {
                    usuarios = daoUser.getListaUser();
                    request.setAttribute("usuarios", usuarios);
                    RequestDispatcher excluir = getServletContext().getRequestDispatcher("/list-user.jsp");
                    excluir.forward(request, response);
                } else {
                    String mensagem = "Erro ao excluir usuário!";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher excluir = getServletContext().getRequestDispatcher("/dashboard-admin.jsp");
                    excluir.forward(request, response);
                }
                break;
            
            case "suspender":
                id = Integer.parseInt(request.getParameter("id_usuario"));
                usuario = daoUser.getUserByID(id);
                
                if (daoUser.editSuspenso(usuario)) {
                    usuarios = daoUser.getListaUser();
                    request.setAttribute("usuarios", usuarios);
                    RequestDispatcher suspender = getServletContext().getRequestDispatcher("/list-user.jsp");
                    suspender.forward(request, response);
                } else {
                    String mensagem = "Erro ao editar usuário!";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher suspender = getServletContext().getRequestDispatcher("/dashboard-admin.jsp");
                    suspender.forward(request, response);
                }
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
            User aux = new User();

            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setNome(request.getParameter("nome"));
            user.setCpf(request.getParameter("cpf"));
            user.setSenha(request.getParameter("senha"));
            user.setSuspenso(request.getParameter("suspenso"));

            DAO_User daoUser = new DAO_User();

            aux = daoUser.getUserByCpf(user.getCpf());
            if ((user.getCpf().equals(aux.getCpf())) && (user.getId() != aux.getId())) {
                mensagem = "CPF já cadastrado no sistema!";
            } else {
                if (daoUser.gravarUser(user)) {
                    mensagem = "Usuário gravado com sucesso!";
                } else {
                    mensagem = "Erro ao gravar usuário!";
                }
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
