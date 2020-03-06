import java.lang.Math;

public class CombinaVetorOrdenado {
  public static void main(String[] args) {

    final int MAX = 5;
    int vetor1[] = new int[MAX];
    int vetor2[] = new int[MAX];
    int vetor3[] = new int[MAX * 2];

    //carrega o primeiro vetor com números aleatórios
    for (int i = 0; i < vetor1.length; i++) {
      vetor1[i] = (int)(Math.random() * 10);
    }

    //carrega o segundo vetor com números aleatórios
    for (int i = 0; i < vetor2.length; i++) {
      vetor2[i] = (int)(Math.random() * 10);
    }
    
    //ordena o primeiro vetor
    for (int i = 0; i < vetor1.length-1; i++) {
      for (int j = i+1; j < vetor1.length; j++) { 
        if (vetor1[i] > vetor1[j]) {
          int aux = vetor1[i];
          vetor1[i] = vetor1[j];
          vetor1[j] = aux;
        }
      }
    }

    //ordena o segundo vetor
    for (int i = 0; i < vetor2.length-1; i++) {
      for (int j = i+1; j < vetor2.length; j++) { 
        if (vetor2[i] > vetor2[j]) {
          int aux = vetor2[i];
          vetor2[i] = vetor2[j];
          vetor2[j] = aux;
        }
      }
    }

    //imprime o primeiro vetor ordenado
    System.out.print("Vetor 1: ");
    for (int i = 0; i < vetor1.length; i++) {
      System.out.print(vetor1[i] + " ");
    }
    System.out.println();

    //imprime o segundo vetor ordenado
    System.out.print("Vetor 2: ");
    for (int i = 0; i < vetor2.length; i++) {
      System.out.print(vetor2[i] + " ");
    }
    System.out.println();

    //cria o terceiro vetor ordenando na entrada
    int aux = 0, i = 0, j = 0;
    //corre os vetores até um dos dois terminar
    while (i < vetor1.length && j < vetor2.length) {
      if (vetor1[i] < vetor2[j]) { //vetor 1 maior
        vetor3[aux] = vetor1[i];
        aux++;
        i++;
      } else if (vetor1[i] > vetor2[j]) { //vetor 2 maior
        vetor3[aux] = vetor2[j];
        aux++;
        j++;
      } else { //vetor 1 e 2 iguais
        vetor3[aux] = vetor1[i];
        aux++;
        i++;
        vetor3[aux] = vetor2[j];
        aux++;
        j++;
      }
    }
    //termina de correr o vetor restante
    while (i < vetor1.length) {
      vetor3[aux] = vetor1[i];
      aux++;
      i++;
    }
    while (j < vetor2.length) {
      vetor3[aux] = vetor2[j];
      aux++;
      j++;
    }

    //imprime o terceiro vetor ordenado
    System.out.print("Vetor 3: ");
    for (i = 0; i < (vetor3.length); i++){
      System.out.print(vetor3[i] + " ");
    }
  }
}