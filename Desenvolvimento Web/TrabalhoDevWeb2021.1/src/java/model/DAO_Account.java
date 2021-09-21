package model;

import aplication.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "DAO_Account", urlPatterns = {"/DAO_Account"})
public class DAO_Account extends HttpServlet {

    private Connection con;

    public DAO_Account() {
        try {
            // Cria a conexão com o banco de dados
            con = Connect.createConnection();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }

    public boolean gravarAccount( Account conta ) {
        try {
            String sql = "INSERT INTO contas (id_usuario, nome_conta, banco, agencia, conta_corrente) VALUES (?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, conta.getId_usuario());
            ps.setString(2, conta.getNome_conta());
            ps.setString(3, conta.getBanco());
            ps.setString(4, conta.getAgencia());
            ps.setString(5, conta.getConta_corrente());
            
            if ( conta.getId()> 0 )
                ps.setInt(6, conta.getId());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean excluirAccount( int id ) {
        try {
            String sql = "DELETE FROM contas WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public Account getAccountByID( int id ) {
        Account conta = new Account();
        try {
            String sql = "SELECT * FROM contas WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                conta.setId(rs.getInt("id"));
                conta.setId_usuario(rs.getInt("id_usuario"));
                conta.setNome_conta(rs.getString("nome_conta"));
                conta.setBanco(rs.getString("banco"));
                conta.setAgencia(rs.getString("agencia"));
                conta.setConta_corrente(rs.getString("conta_corrente"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return conta;
    }

    public Account getAccountByUserID( int id ) {
        Account conta = new Account();
        try {
            String sql = "SELECT * FROM contas WHERE id_usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                conta.setId(rs.getInt("id"));
                conta.setId_usuario(rs.getInt("id_usuario"));
                conta.setNome_conta(rs.getString("nome_conta"));
                conta.setBanco(rs.getString("banco"));
                conta.setAgencia(rs.getString("agencia"));
                conta.setConta_corrente(rs.getString("conta_corrente"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return conta;
    }

    public ArrayList<Account> getListaAccount() {
        ArrayList<Account> resultado = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contas");
            
            while( rs.next() ) {
                Account conta = new Account();
                
                conta.setId(rs.getInt("id") );
                conta.setId_usuario(rs.getInt("id_usuario") );
                conta.setNome_conta( rs.getString("nome_conta") );
                conta.setBanco(rs.getString("banco") );
                conta.setAgencia(rs.getString("agencia") );
                conta.setConta_corrente(rs.getString("conta_corrente") );
                
                resultado.add(conta);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return resultado;
    }
}
