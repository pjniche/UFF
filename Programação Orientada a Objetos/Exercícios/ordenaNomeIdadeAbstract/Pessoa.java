import java.util.Scanner;

public class Pessoa {
  private String nome;
  private int idade;

  public Pessoa() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Entre com o nome: ");
    nome = teclado.nextLine();
    System.out.print("Entre com a idade de " + nome + ": ");
    idade = teclado.nextInt();
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }
  
  public void exibe() {
    System.out.println("\nNome: " + nome);
    System.out.println("Idade: " + idade);
  }
}