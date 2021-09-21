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

    public boolean gravarAdmin( User administrador ) {
        try {
            String sql;
            if ( administrador.getId() == 0 ) {
                sql = "INSERT INTO administradores (nome, cpf, senha) VALUES (?,?,?)";
            } else {
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

    public boolean excluirAdmin( int id ) {
        try {
            String sql = "DELETE FROM administradores WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public User getAdminByID( int id ) {
        User admin = new User();
        try {
            String sql = "SELECT * FROM administradores WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                admin.setId(rs.getInt("id"));
                admin.setNome(rs.getString("nome"));
                admin.setCpf(rs.getString("cpf"));
                admin.setSenha(rs.getString("senha"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return admin;
    }

    public User getAdminByCpf( String cpf ) {
        User admin = new User();
        try {
            String sql = "SELECT * FROM administradores WHERE cpf = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                admin.setId(rs.getInt("id"));
                admin.setNome(rs.getString("nome"));
                admin.setCpf(rs.getString("cpf"));
                admin.setSenha(rs.getString("senha"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return admin;
    }

    public ArrayList<User> getListaAdmin() {
        ArrayList<User> resultado = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM administradores");
            
            while( rs.next() ) {
                User administrador = new User();

                administrador.setId(rs.getInt("id") );
                administrador.setNome( rs.getString("nome") );
                administrador.setCpf(rs.getString("cpf") );
                administrador.setSenha(rs.getString("senha") );

                resultado.add(administrador);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }

        return resultado;
    }
}
