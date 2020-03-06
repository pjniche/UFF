import java.util.Scanner;

public class Contato {
  private static int nextId = 1;
  private int id;
  private String nome;
  private String telefone;

  public Contato(String nome, String telefone) {
    id = nextId++;
    this.nome = nome;
    this.telefone = telefone;
  }

  public int getId() {
    return id;
  }
  
  public String toString() {
    return "id:" + id + " Tel:" + telefone + " Nome: " + nome;
  }
}