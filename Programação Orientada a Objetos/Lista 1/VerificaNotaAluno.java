import java.util.Scanner;

public class VerificaNotaAluno {
  public static float mediaAluno(float notaP1, float notaP2) {
    float notaFinal = (notaP1 + notaP2) / 2;
    return notaFinal;
  }

  public static void statusAluno(float media) {
    if (media < 4.0) {
      System.out.println("Reprovado.");
    } else if (media >= 4.0 && media < 6.0) {
      System.out.println("Verificação Suplementar.");
    } else {
      System.out.println("Aprovado.");
    }
  }

  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    System.out.print("Digite a nota da P1: ");
    float nota1 = teclado.nextFloat();

    System.out.print("Digite a nota da P2: ");
    float nota2 = teclado.nextFloat();

    statusAluno(mediaAluno(nota1, nota2));
  }
}