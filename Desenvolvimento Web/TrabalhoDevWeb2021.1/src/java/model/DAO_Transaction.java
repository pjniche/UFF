package model;

import aplication.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "DAO_Transaction", urlPatterns = {"/DAO_Transaction"})
public class DAO_Transaction extends HttpServlet {

    private Connection con;

    public DAO_Transaction() {
        try {
            // Cria a conexão com o banco de dados
            con = Connect.createConnection();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }

    public boolean gravarTransaction( Transaction lancamento ) {
        try {
            String sql;
            if ( lancamento.getId() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO lancamentos (id_conta, id_categoria, valor, operacao, data, descricao) VALUES (?,?,?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE lancamentos SET id_conta=?, id_categoria=?, valor=?, operacao=?, data=?, descricao=? WHERE id=?";
            }
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, lancamento.getId_conta());
            ps.setInt(2, lancamento.getId_categoria());
            ps.setFloat(3, lancamento.getValor());
            ps.setString(4, lancamento.getOperacao());
            ps.setString(5, lancamento.getData());
            ps.setString(6, lancamento.getDescricao());
            
            if ( lancamento.getId()> 0 )
                ps.setInt(7, lancamento.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean excluirTransaction( int id ) {
        try {
            String sql = "DELETE FROM lancamentos WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public Transaction getTransactionByID( int id ) {
        Transaction lancamento = new Transaction();
        try {
            String sql = "SELECT * FROM lancamentos WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lancamento.setId(rs.getInt("id"));
                lancamento.setId_conta(rs.getInt("id_conta"));
                lancamento.setId_categoria(rs.getInt("id_categoria"));
                lancamento.setValor(rs.getFloat("valor"));
                lancamento.setOperacao(rs.getString("operacao"));
                lancamento.setData(rs.getString("data")); // <<<------ Mudar para o tipo Date!!!
                lancamento.setDescricao(rs.getString("descricao"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return lancamento;
    }

    public ArrayList<Transaction> getListaTransaction() {
        //Cria o objeto que irá armazenar os registros retornados do BD.
        ArrayList<Transaction> resultado = new ArrayList<>();
        try {            
            // Cria o objeto que será utilizado para enviar comandos SQL para o BD.
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM lancamentos");
            // rs.next() Aponta para o próximo registro do BD, se houver um.
            while( rs.next() ) {
                Transaction lancamento = new Transaction();
                
                lancamento.setId_conta(rs.getInt("id_conta") );
                lancamento.setId_categoria( rs.getInt("id_categoria") );
                lancamento.setValor(rs.getFloat("valor") );
                lancamento.setOperacao(rs.getString("operacao") );
                lancamento.setData(rs.getString("data") );
                lancamento.setDescricao(rs.getString("descricao") );
                
                resultado.add(lancamento);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }
}
