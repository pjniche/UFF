import java.util.Scanner;

public class ordenaNomeIdade {
  public static void trocaInt(int[] a, int i, int j) {
    int temp;
    temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void trocaString(String[] a, int i, int j) {
    String temp;
    temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void imprimiString(String[] a, int total) {
    int i;
    for (i = 0; i < total; i++) {
      System.out.println(a[i] + " ");
    }
  }

  public static void imprimiInt(int[] a, int total) {
    int i;
    for (i = 0; i < total; i++) {
      System.out.println(a[i] + " ");
    }
  }

  public static void main(String[] args) {
    final int NUMERO_PESSOAS = 3;
    Scanner teclado = new Scanner(System.in);
    String nome[] = new String[NUMERO_PESSOAS];
    int idade[] = new int[NUMERO_PESSOAS], i, j;
    for (i = 0; i < NUMERO_PESSOAS; i++) {
      System.out.print("Digite nome da " + (i + 1) + "ª pessoa: ");
      nome[i] = teclado.nextLine();
      System.out.print("Digite idade de " + nome[i] + ": ");
      idade[i] = teclado.nextInt();
      teclado.nextLine();
    }

    // Ordenar lista por ordem alfabetica
    for (i = 0; i < NUMERO_PESSOAS; i++) {
      for (j = i + 1; j < NUMERO_PESSOAS; j++) {
        if (nome[i].compareToIgnoreCase(nome[j]) > 0) {
          trocaString(nome, i, j);
          trocaInt(idade, i, j);
        }
      }
    }
    System.out.println("Lista ordenada alfabeticamente:");
    imprimiString(nome, NUMERO_PESSOAS);
    imprimiInt(idade, NUMERO_PESSOAS);

    // Ordenar lista por idade crescente
    for (i = 0; i < NUMERO_PESSOAS; i++) {
      for (j = i + 1; j < NUMERO_PESSOAS; j++) {
        if (idade[i] > idade[j]) {
          trocaString(nome, i, j);
          trocaInt(idade, i, j);
        }
      }
    }
    System.out.println("Lista ordenada por idade crescente:");
    imprimiString(nome, NUMERO_PESSOAS);
    imprimiInt(idade, NUMERO_PESSOAS);
  }
}