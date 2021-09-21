package controller;

import aplication.Category;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO_Category;

@WebServlet(name = "Controller_Category", urlPatterns = {"/Controller_Category"})
public class Controller_Category extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO_Category daoCategory = new DAO_Category();
        Category categoria = new Category();
        ArrayList<Category> categorias;
        int id;

        String option = (String)request.getParameter("option");

        switch (option) {

            case "adicionar":
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-category.jsp");
                adicionar.forward(request, response);
                break;

            case "listar":
                categorias = daoCategory.getListaCategory();
                request.setAttribute("categorias", categorias);
                RequestDispatcher exibir = getServletContext().getRequestDispatcher("/list-category.jsp");
                exibir.forward(request, response);
                break;

            case "editar":
                id = Integer.parseInt(request.getParameter("id_categoria"));
                categoria = daoCategory.getCategoryByID(id);
                request.setAttribute("categoria", categoria);
                RequestDispatcher editar = getServletContext().getRequestDispatcher("/form-category-edit.jsp");
                editar.forward(request, response);
                break;

            case "excluir":
                id = Integer.parseInt(request.getParameter("id_categoria"));

                if (daoCategory.excluirCategory(id)) {
                    categorias = daoCategory.getListaCategory();
                    request.setAttribute("categorias", categorias);
                    RequestDispatcher excluir = getServletContext().getRequestDispatcher("/list-category.jsp");
                    excluir.forward(request, response);
                } else {
                    String mensagem = "Erro ao excluir categoria!";
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
            Category categoria = new Category();

            categoria.setId(Integer.parseInt(request.getParameter("id")));
            categoria.setDescricao(request.getParameter("categoria"));

            DAO_Category daoCategory = new DAO_Category();

            if (daoCategory.gravarCategory(categoria)) {
                mensagem = "Categoria gravada com sucesso!";
            } else {
                mensagem = "Erro ao gravar categoria!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-admin.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro de exceção ao gravar categoria!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-admin.jsp");
            rd.forward(request, response);
        }
    }
}
