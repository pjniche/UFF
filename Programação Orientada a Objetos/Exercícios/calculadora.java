import java.util.Scanner;

public class calculadora {
  public static double soma(double a) {
    return (a + (leiaDouble("Digite valor para somar com " + a + ": ")));
  }

  public static double subtrair(double a) {
    return (a - (leiaDouble("Digite valor para somar com " + a + ": ")));
  }

  public static double multiplicar(double a) {
    return (a * (leiaDouble("Digite valor para somar com " + a + ": ")));
  }

  public static double dividir(double a) {
    return (a / (leiaDouble("Digite valor para somar com " + a + ": ")));
  }

  public static double leiaDouble(String mensagem) {
    Scanner teclado = new Scanner(System.in);
    System.out.print(mensagem);
    return teclado.nextDouble();
  }

  public static void main(String[] args) {
    double m = 0;
    int op = 0;
    Scanner teclado = new Scanner(System.in);
    do {
      System.out.print("Estado da memória: " + m
          + "\nOpções:\n(1) Somar\n(2) Subtrair\n(3) Multiplicar\n(4) Dividir\n(5) Limpar memória\n(6) Sair\nQual opção você deseja?: ");
      op = teclado.nextInt();
      switch (op) {
      case 1:
        m = soma(m);
        break;
      case 2:
        m = subtrair(m);
        break;
      case 3:
        m = multiplicar(m);
        break;
      case 4:
        m = dividir(m);
        break;
      case 5:
        m = 0;
        break;
      case 6:
        break;
      default:
        System.out.println("Opção invalida!");
      }
    } while (op != 6);
  }
}