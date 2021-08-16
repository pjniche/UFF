package controller;

import aplication.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ValidarLogin", urlPatterns = { "/ValidarLogin" })
public class ValidarLogin extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    rd.forward(request, response);
  }

  @Override
  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    String cpf = request.getParameter("cpf");
    String senha = request.getParameter("senha");

    //Verifica os dados do login
    if ((cpf.equals("111")) && (senha.equals("111"))) {
      //Retorna para o formulario de login
      request.setAttribute("mensagem", "Usuário logado");

      //Contruindo o objeto
      User loginUsuario = new User();
      loginUsuario.setCpf("111");
      loginUsuario.setNome("Teste");
      loginUsuario.setSenha("111");

      HttpSession session = request.getSession();
      session.setAttribute("loginUsuario", loginUsuario);

      // redireciona para área restrita
      RequestDispatcher rd = request.getRequestDispatcher("home-admin.jsp");
      rd.forward(request, response);
    } else {
      request.setAttribute("mensagem", "Usuário não identificado");
      RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
      rd.forward(request, response);
    }
  }
}
