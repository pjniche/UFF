import java.util.Scanner;

public class contaMoedas {
  public static void main (String[] args) {
    Scanner teclado = new Scanner(System.in);//Leitor do teclado
    
    int centavos; //Dados de entrada 
    int moedaUmCentavo, moedaCincoCentavos, moedaDezCentavos, moedaVinteCincoCentavos,moedaCinquentaCentavos, moedaUmReal; //Dados de saida
    
    System.out.print("Informe um valor em centavos: ");
    
    centavos = teclado.nextInt();
    
    moedaUmReal =centavos/100;
    centavos = centavos%100;
    
    moedaCinquentaCentavos = centavos/50;
    centavos = centavos%50;
    
    moedaVinteCincoCentavos =  centavos/25;
    centavos =  centavos%25;
    
    moedaDezCentavos = centavos/10;
    centavos =  centavos%10;
    
    moedaCincoCentavos = centavos/5;
    centavos = centavos%5;
    
    moedaUmCentavo =  centavos/1;
    centavos = centavos%1;
    
    System.out.println("A menor quantidade de moedas é:");
    System.out.println(moedaUmReal+" de um real");
    System.out.println(moedaCinquentaCentavos+" de 50 centavos");
    System.out.println(moedaVinteCincoCentavos+" de 25 centavos");
    System.out.println(moedaDezCentavos+" de 10 centavos");
    System.out.println(moedaCincoCentavos+" de 5 centavos");
    System.out.println(moedaUmCentavo+" de 1 centavo.");
  }
}