import java.util.Scanner;

public class NumeroDigitos {
  public static void main(String[] args) {
    Scanner teclado = new Scanner (System.in);

    //inicializa nDigitos com o número mínimo de digitos
    int nDigitos = 1;
    int valor;

    System.out.print("Digite um valor: ");
    valor = teclado.nextInt();

    //se resto for >= 10, valor possui mais de 1 dígito
    do {
      nDigitos++;
      valor /= 10;
    } while (valor >= 10);

    System.out.println("O número de digitos é: " + nDigitos);
  }
}