package model;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "DAO", urlPatterns = {"/DAO"})
public class DAO extends HttpServlet {

    private Connection con;

    public DAO() {
        try {
            // Cria a conexão com o banco de dados
            con = Connect.createConnection();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }

    // CONTAS -----------------------------------------------------------------------
    public boolean gravarAccount( Account conta ) {
        try {
            String sql;
            if ( conta.getId() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO contas (id_usuario, nome_conta, banco, agencia, conta_corrente) VALUES (?,?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE contas SET id_usuario=?, nome_conta=?, banco=?, agencia=?, conta_corrente=? WHERE id=?";
            }
            
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

    public ArrayList<Account> getListaAccount() {
        //Cria o objeto que irá armazenar os registros retornados do BD.
        ArrayList<Account> resultado = new ArrayList<>();
        try {            
            // Cria o objeto que será utilizado para enviar comandos SQL para o BD.
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contas");
            // rs.next() Aponta para o próximo registro do BD, se houver um.
            while( rs.next() ) {
                Account conta = new Account();
                
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

    // ADMINISTRADORES ---------------------------------------------------------------
    public boolean gravarAdmin( Admin administrador ) {
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

    public ArrayList<Admin> getListaAdmin() {
        //Cria o objeto que irá armazenar os registros retornados do BD.
        ArrayList<Admin> resultado = new ArrayList<>();
        try {            
            // Cria o objeto que será utilizado para enviar comandos SQL para o BD.
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM administradores");
            // rs.next() Aponta para o próximo registro do BD, se houver um.
            while( rs.next() ) {
                Admin administrador = new Admin();

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

    // CATEGORIAS -------------------------------------------------------------------------
    public boolean gravarCategory( Category categoria ) {
        try {
            String sql;
            if ( categoria.getId() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO categorias (descricao) VALUES (?)";
            } else {
                // Realizar uma alteração
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

    public ArrayList<Category> getListaCategory() {
        //Cria o objeto que irá armazenar os registros retornados do BD.
        ArrayList<Category> resultado = new ArrayList<>();
        try {            
            // Cria o objeto que será utilizado para enviar comandos SQL para o BD.
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categorias");
            // rs.next() Aponta para o próximo registro do BD, se houver um.
            while( rs.next() ) {
                Category categoria = new Category();
                
                categoria.setDescricao(rs.getString("descricao") );
                
                resultado.add(categoria);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return resultado;
    }

    // LANÇAMENTOS ------------------------------------------------------------------------
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

    // USUÁRIOS ---------------------------------------------------------------------------
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
