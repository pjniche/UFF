import java.util.Scanner;

public class DecimalRomano {
  public static int leitura() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite um número (Até 3 dígitos): ");
    int valorLido = teclado.nextInt();
    return valorLido;
  }

  public static void escrita(String valorEscrito) {
    System.out.println("Número em algarismos Romanos: " + valorEscrito);
  }

  //converte decimal em romano.
  public static String decimalRomano(int valor) {
    final int decimal[] = {900,  500,  400, 100,
                            90,   50,   40,  19,  10,
                             9,    5,    4,   1};
    final String romanos[] = {"CM", "D", "CD", "C",
                              "XC", "L", "XL", "XIX", "X",
                              "IX", "V", "IV", "I"};
    
    String resultado = new String();
    
    for (int i = 0; i < decimal.length; i++) {
      int parteInteira = valor / decimal[i];
      for (int j = 0; j < parteInteira; j++) {
        //concatena a string de saída
        resultado = resultado.concat(romanos[i]);
      }
      valor = valor % decimal[i];
    }
    return resultado;
  }

  public static void main(String[] args) {
    escrita(decimalRomano(leitura()));
  }
}