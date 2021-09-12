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

@WebServlet(name = "DAO_User", urlPatterns = {"/DAO_User"})
public class DAO_User extends HttpServlet {

    private Connection con;

    public DAO_User() {
        try {
            // Cria a conexão com o banco de dados
            con = Connect.createConnection();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }

    public boolean gravarUser( User usuario ) {
        try {
            String sql;
            if ( usuario.getId() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO usuarios (nome, cpf, senha, suspenso) VALUES (?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE usuarios SET nome=?, cpf=?, senha=?, suspenso=? WHERE id=?";
            }
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getSuspenso());
            
            if ( usuario.getId()> 0 )
                ps.setInt(5, usuario.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean excluirUser( int id ) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public User getUserByID( int id ) {
        User user = new User();
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setSenha(rs.getString("senha"));
                user.setSuspenso(rs.getString("suspenso"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return user;
    }

    public ArrayList<User> getListaUser() {
        //Cria o objeto que irá armazenar os registros retornados do BD.
        ArrayList<User> resultado = new ArrayList<>();
        try {            
            // Cria o objeto que será utilizado para enviar comandos SQL para o BD.
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios ORDER BY nome");
            // rs.next() Aponta para o próximo registro do BD, se houver um. 
            while( rs.next() ) {
                User usuario = new User();
                
                usuario.setId(rs.getInt("id") );
                usuario.setNome( rs.getString("nome") );
                usuario.setCpf(rs.getString("cpf") );
                usuario.setSenha(rs.getString("senha") );
                usuario.setSuspenso(rs.getString("suspenso") );
                
                resultado.add(usuario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
}
