import java.util.Scanner;

public class numeroDeDivisores {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    
    int numero = 0, continuar = 1;
    
    do {
      System.out.print("Digite valor do número: ");
      numero = teclado.nextInt();
      
      if(numero>1){
        int divisores[] = new int[numero], cont = 0;
        for(int i = numero; i>0; i--) {
          if(numero%i==0) {
            divisores[cont] = i;
            cont++;
          }
        }
        if(cont > 2) {
          System.out.print("Divisores de "+numero+" = ");
          for(int i = 0; i < cont; i++ ){
            System.out.print(divisores[i]+" ");
          }
        } else {
          System.out.println("Número é primo!");
        }
      } else {
        System.out.println("Número não é primo, valor digitado foi "+numero+" não possui divisores além dele próprio!");
      }
      System.out.print("\n\nDeseja analisar outro número?\n  1- Sim \n  2- Não \nDigite opção desejada = ");
      continuar = teclado.nextInt();
    }while(continuar == 1);
  }
}