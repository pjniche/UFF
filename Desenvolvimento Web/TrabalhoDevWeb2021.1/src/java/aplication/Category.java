package aplication;

public class Category {
    private int id;
    private String descricao;
    
    //Construtor da classe
    public void Category(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public void Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
