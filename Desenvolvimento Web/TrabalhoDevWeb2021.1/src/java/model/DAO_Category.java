package model;

import aplication.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "DAO_Category", urlPatterns = {"/DAO_Category"})
public class DAO_Category extends HttpServlet {

    private Connection con;

    public DAO_Category() {
        try {
            // Cria a conexão com o banco de dados
            con = Connect.createConnection();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }

    public boolean gravarCategory( Category categoria ) {
        try {
            String sql;
            if ( categoria.getId() == 0 ) {
                sql = "INSERT INTO categorias (descricao) VALUES (?)";
            } else {
                sql = "UPDATE categorias SET descricao=? WHERE id=?";
            }
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoria.getDescricao());
            
            if ( categoria.getId()> 0 )
                ps.setInt(2, categoria.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean excluirCategory( int id ) {
        try {
            String sql = "DELETE FROM categorias WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public Category getCategoryByID( int id ) {
        Category categoria = new Category();
        try {
            String sql = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setDescricao(rs.getString("descricao"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return categoria;
    }

    public ArrayList<Category> getListaCategory() {
        ArrayList<Category> resultado = new ArrayList<>();
        try {            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categorias");
            
            while( rs.next() ) {
                Category categoria = new Category();
                
                categoria.setId(rs.getInt("id"));
                categoria.setDescricao(rs.getString("descricao") );
                
                resultado.add(categoria);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
}
