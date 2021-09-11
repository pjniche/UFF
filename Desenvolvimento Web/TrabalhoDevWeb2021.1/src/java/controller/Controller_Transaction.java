package controller;

import model.Transaction;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;

@WebServlet(name = "Controller_Transaction", urlPatterns = {"/Controller_Transaction"})
public class Controller_Transaction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO daoTransaction = new DAO();
        String option = (String)request.getParameter("option");
        ArrayList<Transaction> lancamentos;
        int id;

        Transaction lancamento = new Transaction();

        switch (option) {

            case "adicionar":
                //lancamento.setId_conta("");
                //lancamento.setId_categoria("");
                //lancamento.setValor("");
                lancamento.setOperacao("");
                lancamento.setData("");
                lancamento.setDescricao("");

                request.setAttribute("lancamento", lancamento);
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-transaction.jsp");
                adicionar.forward(request, response);
                break;

            case "exibir":
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

            //lancamento.setId_conta(request.getParameter("id_conta"));
            //lancamento.setId_categoria(request.getParameter("id_categoria"));
            //lancamento.setValor(request.getParameter("valor"));
            lancamento.setOperacao(request.getParameter("operacao"));
            lancamento.setData(request.getParameter("data"));
            lancamento.setDescricao(request.getParameter("descricao"));

            DAO daoTransaction = new DAO();

            if (daoTransaction.gravarTransaction(lancamento)) {
                mensagem = "Lançamento gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar lançamento!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/success.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar lançamento!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
}
