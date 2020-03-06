import java.util.Scanner;
 
public class JurosCompostos {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
 
    float juros;
    double valor, saldo = 0;
    String resposta = new String();
 
    System.out.print("Digite o valor do investimento mensal: ");
    valor = teclado.nextDouble();
    System.out.print("Digite a porcentagem de juros por mês: ");
    juros = teclado.nextFloat();
   
    //calcula os juros compostos
    do {
      for (int i = 1; i <= 12; i++) {
        saldo = (saldo) + (valor + ((saldo + valor) * (juros/100)));
      }
      System.out.println("Saldo do investimento após 1 ano: " + saldo);
      System.out.print("Deseja processar mais 1 ano? (Y/N): ");
      resposta = teclado.next();
    } while ("y".compareToIgnoreCase(resposta) == 0);
  }
}