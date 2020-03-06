import java.util.Scanner;

public class Main {
  static Scanner teclado = new Scanner(System.in);

  static public int leiaInt(String mensagem) {
    System.out.print(mensagem);
    return teclado.nextInt();
  }

  public static void main(String[] args) {
    try {
      int n = leiaInt("Digite: ");
      
      Fibonacci fibonacci1 = new Fibonacci(n-1);
      Fibonacci fibonacci2 = new Fibonacci(n-2);

      Thread t1 = new Thread(fibonacci1);
      Thread t2 = new Thread(fibonacci2);
      
      t1.start();
      t2.start();
      
      t1.join();
      t2.join();

      long resultado = fibonacci1.getResultado() + fibonacci2.getResultado();

      System.out.println(resultado + " ");
    } catch (InterruptedException e) {
      System.out.println("ERRO!");
    }
  }
}