package aplication;

public class User {
    private int id;
    private String nome;
    private String cpf;
    private String senha;
    private String suspenso;
    
    //Construtor da classe
    public void User(int id, String nome, String cpf, String senha, String suspenso) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.suspenso = suspenso;
    }

    public void User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(String suspenso) {
        this.suspenso = suspenso;
    }
}
