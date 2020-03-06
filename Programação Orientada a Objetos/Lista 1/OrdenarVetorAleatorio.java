import java.util.Scanner;
 
public class OrdenarVetorAleatorio {
  public static void main(String[] args) {
 
    final int MAX = 10;
    int vetor[] = new int[MAX];

    //adicionando valores aleatórios ao vetor
    for(int i = 0; i < MAX; i++) {
      vetor[i] = (int)(Math.random() * 100);
    }

    System.out.println("Vetor desordenado.");
    for (int i = 0; i < MAX; i++) {
      System.out.print(vetor[i] + " ");
    }
    System.out.println();
    
    for (int i = 0; i < MAX-1; i++) {
      for (int j = i+1; j < MAX; j++) {
        if (vetor[i] > vetor[j]) {
          int aux = vetor[i];
          vetor[i] = vetor[j];
          vetor[j] = aux;
        }
      }
    }

    System.out.println("Vetor ordenado.");
    for (int i = 0; i < MAX; i++) {
      System.out.print(vetor[i] + " ");
    }
    System.out.println();
  }
}