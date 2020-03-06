import java.util.Scanner;

public class DescontoProdutos {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    String produto;
    int quantidade;
    float preco;

    //recebe os dados do produto
    System.out.println("Informe os Dados do Produto");
    System.out.print("Nome: ");
    produto = teclado.nextLine();
    System.out.print("Preço: ");
    preco = teclado.nextFloat();
    System.out.print("Quantidade: ");
    quantidade = teclado.nextInt();
    
    //até 10 unidades preço normal
    if (quantidade <= 10) {
      preco *= quantidade;
      System.out.println();
      System.out.println("Produto: " + produto);
      System.out.println("Quantidade: " + quantidade);
      System.out.println("Preço Total: " + preco);
    }
    
    //de 11 a 20 unidades 10% de desconto
    if (quantidade > 10 && quantidade <= 20) {
      preco *= quantidade;
      System.out.println("Produto: " + produto);
      System.out.println("Quantidade: " + quantidade + " (10% de Desconto)");
      System.out.println("Preço Total: " + (preco - (preco*10)/100) );
    }
    
    //de 21 a 50 unidades 20% de desconto
    if (quantidade > 20 && quantidade <= 50) {
      preco *= quantidade;
      System.out.println("Produto: " + produto);
      System.out.println("Quantidade: " + quantidade + " (20% de Desconto)");
      System.out.println("Preço Total: " + (preco - (preco*20)/100) );
    }
    
    //acima de 50 unidades 25% de desconto
    if (quantidade > 50) {
      preco *= quantidade;
      System.out.println("Produto: " + produto);
      System.out.println("Quantidade: " + quantidade + " (25% de Desconto)");
      System.out.println("Preço Total: " + (preco - (preco*25)/100) );
    }
  }
}