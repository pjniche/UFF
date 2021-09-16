package controller;

import aplication.Account;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO_Account;

@WebServlet(name = "Controller_Account", urlPatterns = {"/Controller_Account"})
public class Controller_Account extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO_Account daoAccount = new DAO_Account();
        String option = (String)request.getParameter("option");
        ArrayList<Account> contas;
        int id;

        Account conta = new Account();

        switch (option) {

            case "adicionar":
                conta.setId(0);
                conta.setId_usuario(0);
                conta.setNome_conta("");
                conta.setBanco("");
                conta.setAgencia("");
                conta.setConta_corrente("");

                request.setAttribute("conta", conta);
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-account.jsp");
                adicionar.forward(request, response);
                break;
        
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        try {
            Account conta = new Account();

            conta.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
            conta.setNome_conta(request.getParameter("nome_conta"));
            conta.setBanco(request.getParameter("banco"));
            conta.setAgencia(request.getParameter("agencia"));
            conta.setConta_corrente(request.getParameter("conta_corrente"));

            DAO_Account daoAccount = new DAO_Account();

            if (daoAccount.gravarAccount(conta)) {
                mensagem = "Conta Corrente adicionada com sucesso!";
            } else {
                mensagem = "Erro ao gravar Conta Corrente!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-user.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro de exceção ao adicionar Conta Corrente!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-user.jsp");
            rd.forward(request, response);
        }
    }
}
