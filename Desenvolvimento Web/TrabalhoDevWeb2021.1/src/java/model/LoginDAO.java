package model;

import aplication.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "LoginDAO", urlPatterns = {"/LoginDAO"})
public class LoginDAO extends HttpServlet {

    private Connection con;

    public LoginDAO() {
        try {
            // Cria a conexão com o banco de dados
            con = Connect.createConnection();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }

    public User validarLogin( String usuario, String senha ) {
        User userLogin = new User();
        try {
            String sql = "SELECT * FROM administradores WHERE cpf = ? and senha = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
        
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                userLogin.setId(rs.getInt("id"));
                userLogin.setNome(rs.getString("nome"));
                userLogin.setCpf(rs.getString("cpf"));
                userLogin.setSenha(rs.getString("senha"));
            } else {
                sql = "SELECT * FROM usuarios WHERE cpf = ? and senha = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, usuario);
                ps.setString(2, senha);
        
                rs = ps.executeQuery();

                if (rs.next()) {
                    userLogin.setId(rs.getInt("id"));
                    userLogin.setNome(rs.getString("nome"));
                    userLogin.setCpf(rs.getString("cpf"));
                    userLogin.setSenha(rs.getString("senha"));
                    userLogin.setSuspenso(rs.getString("suspenso"));
                }
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return userLogin;
    }
}
