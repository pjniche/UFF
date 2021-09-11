package model;

public class User extends Admin {
    private String suspenso;
    
    //Construtor da classe
    public void User(int id, String nome, String cpf, String senha, String suspenso) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSenha(senha);
        this.suspenso = suspenso;
    }

    public void User() {

    }

    public String getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(String suspenso) {
        this.suspenso = suspenso;
    }
}
