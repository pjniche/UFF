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
import model.DAO_Admin;

@WebServlet(name = "Controller_Admin", urlPatterns = {"/Controller_Admin"})
public class Controller_Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO_Admin daoAdmin = new DAO_Admin();
        String option = (String)request.getParameter("option");
        ArrayList<User> administradores;
        int id;

        User admin = new User();

        switch (option) {

            case "adicionar":
                admin.setId(0);
                admin.setNome("");
                admin.setCpf("");
                admin.setSenha("");

                request.setAttribute("admin", admin);
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-admin.jsp");
                adicionar.forward(request, response);
                break;

            case "listar":
                administradores = daoAdmin.getListaAdmin();
                request.setAttribute("administradores", administradores);
                RequestDispatcher exibir = getServletContext().getRequestDispatcher("");
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
            User admin = new User();

            admin.setNome(request.getParameter("nome"));
            admin.setCpf(request.getParameter("cpf"));
            admin.setSenha(request.getParameter("senha"));

            DAO_Admin daoAdmin = new DAO_Admin();

            if (daoAdmin.gravarAdmin(admin)) {
                mensagem = "Administrador gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar administrador!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = request.getRequestDispatcher("/dashboard-admin.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro de exceção ao gravar administrador!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = request.getRequestDispatcher("/dashboard-admin.jsp");
            rd.forward(request, response);
        }
    }
}
