import java.util.Scanner;

public class RaizQuadradaAproximada {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    int valor;
    float erro;
    double piso;
    double teto;
    double chute;
    
    System.out.print("Digite um número inteiro: ");
    valor = teclado.nextInt();
    System.out.print("Digite a margem de erro: ");
    erro = teclado.nextFloat();

    piso = 0;
    teto = valor;

    //enquanto (teto - piso) > erro, programa continua
    do {
      chute = (teto + piso) / 2;
      //se chute² menor que valor, aumenta o piso
      if ((chute * chute) < valor) {
        piso = chute;
      } else { //se chute² maior que valor, diminui o teto
        teto = chute;
      }
    } while ((teto - piso) > erro);
    System.out.println("A raiz de " + valor + " é " + chute);
  }
}