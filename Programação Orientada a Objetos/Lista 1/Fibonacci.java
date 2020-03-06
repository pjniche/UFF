import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    //fibo 1 e 2 inicializadas de acordo com o início da sequẽncia
    int fibo1 = 0, fibo2 = 1, valor = 0;

    System.out.print("Entre com um numero: ");
    valor = teclado.nextInt();

    //imprime o 0 e inicia o cálculo da sequência
    System.out.print("0 ");
    for (int i = 0; i < valor; i++) {
      int aux = fibo1 + fibo2;
      fibo1 = fibo2;
      fibo2 = aux;
      System.out.print(fibo1 + " ");
    }
  }
}