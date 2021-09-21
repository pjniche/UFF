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
        User administrador = new User();
        ArrayList<User> administradores;
        int id;

        String option = (String)request.getParameter("option");

        switch (option) {

            case "adicionar":
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-admin.jsp");
                adicionar.forward(request, response);
                break;

            case "listar":
                administradores = daoAdmin.getListaAdmin();
                request.setAttribute("administradores", administradores);
                RequestDispatcher listarAdmin = getServletContext().getRequestDispatcher("/list-admin.jsp");
                listarAdmin.forward(request, response);
                break;
            
            case "editar":
                id = Integer.parseInt(request.getParameter("id_admin"));
                administrador = daoAdmin.getAdminByID(id);
                request.setAttribute("administrador", administrador);
                RequestDispatcher editar = getServletContext().getRequestDispatcher("/form-admin-edit.jsp");
                editar.forward(request, response);
                break;

            case "excluir":
                id = Integer.parseInt(request.getParameter("id_admin"));

                if (daoAdmin.excluirAdmin(id)) {
                    administradores = daoAdmin.getListaAdmin();
                    request.setAttribute("administradores", administradores);
                    RequestDispatcher excluir = getServletContext().getRequestDispatcher("/list-admin.jsp");
                    excluir.forward(request, response);
                } else {
                    String mensagem = "Erro ao excluir administrador!";
                    request.setAttribute("mensagem", mensagem);
                    RequestDispatcher excluir = getServletContext().getRequestDispatcher("/dashboard-admin.jsp");
                    excluir.forward(request, response);
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
            User admin = new User();
            User aux = new User();

            admin.setId(Integer.parseInt(request.getParameter("id")));
            admin.setNome(request.getParameter("nome"));
            admin.setCpf(request.getParameter("cpf"));
            admin.setSenha(request.getParameter("senha"));

            DAO_Admin daoAdmin = new DAO_Admin();

            aux = daoAdmin.getAdminByCpf(admin.getCpf());
            if ((admin.getCpf().equals(aux.getCpf())) && (admin.getId() != aux.getId())) {
                mensagem = "CPF já cadastrado no sistema!";
            } else {
                if (daoAdmin.gravarAdmin(admin)) {
                    mensagem = "Administrador gravado com sucesso!";
                } else {
                    mensagem = "Erro ao gravar administrador!";
                }
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
