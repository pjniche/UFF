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
        Account conta = new Account();
        ArrayList<Account> contas;
        int id;

        String option = (String)request.getParameter("option");

        switch (option) {

            case "adicionar":
                RequestDispatcher adicionar = getServletContext().getRequestDispatcher("/form-account.jsp");
                adicionar.forward(request, response);
                break;

            case "listar":
                contas = daoAccount.getListaAccount();
                request.setAttribute("contas", contas);
                RequestDispatcher listar = getServletContext().getRequestDispatcher("/list-account.jsp");
                listar.forward(request, response);
                break;
            
            case "editar":
                id = Integer.parseInt(request.getParameter("id_conta"));
                conta = daoAccount.getAccountByID(id);
                request.setAttribute("conta", conta);
                RequestDispatcher editar = getServletContext().getRequestDispatcher("/form-account-edit.jsp");
                editar.forward(request, response);
                break;

            case "excluir":
                id = Integer.parseInt(request.getParameter("id_conta"));

                if (daoAccount.excluirAccount(id)) {
                    contas = daoAccount.getListaAccount();
                    request.setAttribute("contas", contas);
                    RequestDispatcher excluir = getServletContext().getRequestDispatcher("/list-account.jsp");
                    excluir.forward(request, response);
                } else {
                    String mensagem = "Erro ao excluir conta corrente!";
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
            DAO_Account daoAccount = new DAO_Account();
            Account conta = new Account();
            
            int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
            conta = daoAccount.getAccountByUserID(id_usuario);

            if (id_usuario == conta.getId_usuario()) {
                mensagem = "Usuário já possui uma conta cadastrada!";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-user.jsp");
                rd.forward(request, response);
            
            } else {

                conta.setId(Integer.parseInt(request.getParameter("id")));
                conta.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
                conta.setNome_conta(request.getParameter("nome_conta"));
                conta.setBanco(request.getParameter("banco"));
                conta.setAgencia(request.getParameter("agencia"));
                conta.setConta_corrente(request.getParameter("conta_corrente"));

                if (daoAccount.gravarAccount(conta)) {
                    mensagem = "Conta Corrente adicionada com sucesso!";
                } else {
                    mensagem = "Erro ao gravar Conta Corrente!";
                }

                request.setAttribute("mensagem", mensagem);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-user.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            mensagem = "Erro de exceção ao adicionar Conta Corrente!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard-user.jsp");
            rd.forward(request, response);
        }
    }
}
