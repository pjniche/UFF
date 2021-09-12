package controller;

import aplication.Admin;
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
        ArrayList<Admin> administradores;
        int id;

        Admin admin = new Admin();

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

            case "exibir":
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
            Admin admin = new Admin();

            admin.setNome(request.getParameter("nome"));
            admin.setCpf(request.getParameter("cpf"));
            admin.setSenha(request.getParameter("senha"));

            DAO_Admin daoAdmin = new DAO_Admin();

            if (daoAdmin.gravarAdmin(admin)) {
                mensagem = "Usuário gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar usuário!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/success-admin.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar usuário!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/success-admin.jsp");
            rd.forward(request, response);
        }
    }
}
