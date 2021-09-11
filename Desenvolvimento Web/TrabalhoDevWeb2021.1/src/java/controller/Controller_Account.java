package controller;

import model.Account;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;

@WebServlet(name = "Controller_Account", urlPatterns = {"/Controller_Account"})
public class Controller_Account extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO daoAccount = new DAO();
        String option = (String)request.getParameter("option");
        ArrayList<Account> contas;
        int id;

        Account conta = new Account();

        switch (option) {

            case "adicionar":
                //conta.setId_usuario("");
                conta.setNome_conta("");
                conta.setBanco("");
                conta.setAgencia("");
                conta.setConta_corrente("");

                request.setAttribute("conta", conta);
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-account.jsp");
                adicionar.forward(request, response);
                break;

            case "exibir":
                contas = daoAccount.getListaAccount();
                request.setAttribute("contas", contas);
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
            Account conta = new Account();

            //conta.setId_usuario(request.getParameter("id_usuario"));
            conta.setNome_conta(request.getParameter("nome_conta"));
            conta.setBanco(request.getParameter("banco"));
            conta.setAgencia(request.getParameter("agencia"));
            conta.setConta_corrente(request.getParameter("conta_corrente"));

            DAO daoAccount = new DAO();

            if (daoAccount.gravarAccount(conta)) {
                mensagem = "Conta gravada com sucesso!";
            } else {
                mensagem = "Erro ao gravar conta!";
            }

            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/success.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar conta!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
}
