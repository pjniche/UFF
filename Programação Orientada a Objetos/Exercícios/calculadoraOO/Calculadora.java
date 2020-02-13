import java.util.Scanner;

public class Calculadora {
  private String nome;
  private double memoria = 0;

  public Calculadora(String nome) {
    System.out.println("Calculadora " + nome + " instanciada, memória zerada.");
    this.nome = nome;
  }

  public void soma(double valor) {
    System.out.println("Somou " + valor + " à memória da calculadora " + nome + ".");
    memoria += valor;
  }

  public void subtrai(double valor) {
    System.out.println("Subtraiu " + valor + " da memória na calculadora " + nome + ".");
    memoria -= valor;
  }

  public void multiplica(double valor) {
    System.out.println("Multiplicou a memória por " + valor + " na calculadora " + nome + ".");
    memoria *= valor;
  }

  public void divide(double valor) {
    System.out.println("Dividiu a memória por " + valor + " na calculadora " + nome + ".");
    memoria /= valor;
  }

  public void zera() {
    System.out.println("Zerou a memória da calculadora " + nome + ".");
    memoria = 0;
  }

  public void exibeMemoria() {
    System.out.println("A memória da calculadora " + nome + " contém " + memoria + ".");
  }

  public byte exibeMenu() {
    Scanner teclado = new Scanner(System.in);
    exibeMemoria();
    System.out.println("Menu:");
    System.out.println("1) Somar.");
    System.out.println("2) Subtrair.");
    System.out.println("3) Multiplicar.");
    System.out.println("4) Dividir.");
    System.out.println("5) Zerar.");
    System.out.println("6) Sair.");
    System.out.print("Selecione a opção desejada:");
    return teclado.nextByte();
  }

  public double leValor() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Entre com um valor: ");
    return teclado.nextDouble();
  }

  public void modoInterativo() {
    byte opcao;
    do {
      opcao = exibeMenu();
      switch (opcao) {
        case 1:
          soma(leValor());
          break;
        case 2:
          subtrai(leValor());
          break;
        case 3:
          multiplica(leValor());
          break;
        case 4:
          divide(leValor());
          break;
        case 5:
          zera();
          break;
        case 6:
          System.out.println("Deixando o modo interativo.");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (opcao != 6);
  }
}