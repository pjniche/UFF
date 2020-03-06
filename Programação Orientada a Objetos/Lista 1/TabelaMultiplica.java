import java.util.Scanner;

public class TabelaMultiplica {
  public static void main(String[] args) {
    Scanner teclado = new Scanner (System.in);
    
    final int MAX = 10;
    int valor;

    System.out.print("Digite um valor: ");
    valor = teclado.nextInt();

    //exibe a tabuada de multiplicação do número até 10
    for (int i = 0; i <= MAX-1; i++) {
      System.out.println(valor + " x " + i + " = " + (valor*i));
    }    
  }
}