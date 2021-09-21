package controller;

import aplication.Transaction;
import aplication.Category;
import aplication.Account;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO_Transaction;
import model.DAO_Category;
import model.DAO_Account;

@WebServlet(name = "Controller_Transaction", urlPatterns = {"/Controller_Transaction"})
public class Controller_Transaction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO_Account daoAccount = new DAO_Account();
        Account conta = new Account();
        DAO_Transaction daoTransaction = new DAO_Transaction();
        DAO_Category daoCategory = new DAO_Category();
        ArrayList<Transaction> lancamentos;
        ArrayList<Category> categorias;
        ArrayList<Account> contas;
        int id_usuario;

        String option = (String)request.getParameter("option");

        switch (option) {

            case "adicionar":
                id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
                conta = daoAccount.getAccountByUserID(id_usuario);
                categorias = daoCategory.getListaCategory();

                request.setAttribute("conta", conta);
                request.setAttribute("categorias", categorias);
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-transaction.jsp");
                adicionar.forward(request, response);
                break;

            case "listar":
                lancamentos = daoTransaction.getListaTransaction();
                categorias = daoCategory.getListaCategory();
                contas = daoAccount.getListaAccount();
                
                request.setAttribute("contas", contas);
                request.setAttribute("categorias", categorias);
                request.setAttribute("lancamentos", lancamentos);
                RequestDispatcher exibir = getServletContext().getRequestDispatcher("/list-transaction.jsp");
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

            lancamento.setId(Integer.parseInt(request.getParameter("id")));
            lancamento.setId_conta(Integer.parseInt(request.getParameter("id_conta")));
            lancamento.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
            lancamento.setValor(Double.valueOf(request.getParameter("valor")));
            lancamento.setOperacao(request.getParameter("operacao"));
            // formatando a data =============================================
            String stringData = request.getParameter("data");
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
            Date data = new Date(formatoData.parse(stringData).getTime());
            lancamento.setData(data);
            // ---------------------------------------------------------------
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
