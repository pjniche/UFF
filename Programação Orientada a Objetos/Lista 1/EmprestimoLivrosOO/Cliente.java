import java.util.Scanner;

public class Cliente {
  private static int proximaMatricula = 1;
  private int matricula;
  private String nome;
  private String endereco;

  public Cliente(String nome, String endereco) {
    matricula = proximaMatricula++;
    this.nome = nome;
    this.endereco = endereco;
  }

  public int getMatricula() {
    return matricula;
  }
  
  public String toString() {
    return nome + " (matrícula " + matricula + ")";
  }
}