/*
a. Qual das duas soluções é a correta?
r: A solução do Programa A.
b. Como a solução incorreta poderia ser corrigida?
r: Segue o código:
*/
import java.util.Scanner;

public class CorrigeProgramaB {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    
    //inicializando a variável
    int codigo = 0;

    do {
      System.out.print("Informe o código: ");
      codigo = teclado.nextInt();
      //para o código "-1" não ser exibido
      if (codigo != -1) {
        System.out.println("Código: " + codigo);
      }  
    } while (codigo != -1);
  }
}