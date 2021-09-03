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

            case "exibir":
                administradores = daoAdmin.getLista();
                request.setAttribute("administradores", administradores);
                RequestDispatcher exibir = getServletContext().getRequestDispatcher("/.jsp");
                exibir.forward(request, response);
                break;
            
            /*
            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                contato = contatodao.getContatoPorID(id);

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
            User admin = new User();

            admin.setId(Integer.parseInt(request.getParameter("id")));
            admin.setNome(request.getParameter("nome"));
            admin.setCpf(request.getParameter("cpf"));
            admin.setSenha(request.getParameter("senha"));

            DAO_Admin daoAdmin = new DAO_Admin();

            if (daoAdmin.gravar(admin)) {
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
