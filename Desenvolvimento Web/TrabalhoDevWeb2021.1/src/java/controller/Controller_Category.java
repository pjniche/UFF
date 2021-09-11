package controller;

import model.Category;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;

@WebServlet(name = "Controller_Category", urlPatterns = {"/Controller_Category"})
public class Controller_Category extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO daoCategory = new DAO();
        String option = (String)request.getParameter("option");
        ArrayList<Category> categorias;
        int id;

        Category categoria = new Category();

        switch (option) {

            case "adicionar":
                categoria.setDescricao("");

                request.setAttribute("categoria", categoria);
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-category.jsp");
                adicionar.forward(request, response);
                break;

            case "exibir":
                categorias = daoCategory.getListaCategory();
                request.setAttribute("categorias", categorias);
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
            Category categoria = new Category();

            categoria.setDescricao(request.getParameter("descricao"));

            DAO daoCategory = new DAO();

            if (daoCategory.gravarCategory(categoria)) {
                mensagem = "Categoria gravada com sucesso!";
            } else {
                mensagem = "Erro ao gravar categoria!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/success.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar categoria!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
}
