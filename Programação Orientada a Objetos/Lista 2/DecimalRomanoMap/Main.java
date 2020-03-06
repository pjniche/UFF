import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
		System.out.print("Digite um número (Até 3 dígitos): ");
    int valor = teclado.nextInt();

    Romano converte = new Romano();
    System.out.println("Número em algarismos Romanos: " + converte.getRomano(valor));
  }
}