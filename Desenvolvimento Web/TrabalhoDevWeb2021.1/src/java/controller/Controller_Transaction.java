package controller;

import aplication.Transaction;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO_Transaction;

@WebServlet(name = "Controller_Transaction", urlPatterns = {"/Controller_Transaction"})
public class Controller_Transaction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO_Transaction daoTransaction = new DAO_Transaction();
        String option = (String)request.getParameter("option");
        ArrayList<Transaction> lancamentos;
        int id;

        Transaction lancamento = new Transaction();

        switch (option) {

            case "adicionar":
                lancamento.setId(0);
                lancamento.setId_conta(0);
                lancamento.setId_categoria(0);
                lancamento.setValor(0);
                lancamento.setOperacao("");
                lancamento.setData("");
                lancamento.setDescricao("");

                request.setAttribute("lancamento", lancamento);
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-transaction.jsp");
                adicionar.forward(request, response);
                break;

            case "listar":
                lancamentos = daoTransaction.getListaTransaction();
                request.setAttribute("lancamentos", lancamentos);
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
            Transaction lancamento = new Transaction();

            lancamento.setValor(Double.parseDouble(request.getParameter("valor")));
            lancamento.setOperacao(request.getParameter("operacao"));
            lancamento.setData(request.getParameter("data"));
            lancamento.setDescricao(request.getParameter("descricao"));

            DAO_Transaction daoTransaction = new DAO_Transaction();

            if (daoTransaction.gravarTransaction(lancamento)) {
                mensagem = "Lançamento gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar lançamento!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-user.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro de exceção ao gravar lançamento!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-user.jsp");
            rd.forward(request, response);
        }
    }
}
