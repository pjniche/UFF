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

@WebServlet(name = "DAO_Admin", urlPatterns = {"/DAO_Admin"})
public class DAO_Admin extends HttpServlet {

    private Connection con;

    public DAO_Admin() {
        try {
            // Cria a conexão com o banco de dados
            con = Connect.createConnection();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    
    public ArrayList<User> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<User> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = con.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("SELECT * FROM administradores");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                User administrador = new User();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                administrador.setId(rs.getInt("id") );
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                administrador.setNome( rs.getString("nome") );
                //Pega o conteúdo da coluna "cpf" do ResultSet (rs)
                administrador.setCpf(rs.getString("cpf") );
                //Pega o conteúdo da coluna "senha" do ResultSet (rs)
                administrador.setSenha(rs.getString("senha") );
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(administrador);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }
    
    public User getAdminPorID( int codigo ) {
        User administrador = new User();
        try {
            String sql = "SELECT * FROM administradores WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                administrador.setId(rs.getInt("id"));
                administrador.setNome( rs.getString("nome") );
                administrador.setCpf(rs.getString("cpf") );
                administrador.setSenha(rs.getString("senha") );
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return administrador;
    }
    
    public boolean gravar( User administrador ) {
        try {
            String sql;
            if ( administrador.getId() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO administradores (nome, cpf, senha) VALUES (?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE administradores SET nome=?, cpf=?, senha=? WHERE id=?";
            }
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getCpf());
            ps.setString(3, administrador.getSenha());
            
            if ( administrador.getId()> 0 )
                ps.setInt(4, administrador.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM contato WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
