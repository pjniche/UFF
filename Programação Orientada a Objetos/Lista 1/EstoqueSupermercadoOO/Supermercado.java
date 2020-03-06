import java.util.Scanner;

class Supermercado {
  Scanner teclado = new Scanner(System.in);

  private final int MAX = 100;
  private Cliente clientes[] = new Cliente[MAX];
  private Produto produtos[] = new Produto[MAX];
  private Pedido pedidos[] = new Pedido[MAX];
  private int contadorCliente = 0;
  private int contadorProduto = 0;
  private int contadorPedido = 0;

  public double leiaDouble(String mensagem) {
    System.out.print(mensagem);
    return teclado.nextDouble();
  }

  public int leiaInt(String mensagem) {
    System.out.print(mensagem);
    return teclado.nextInt();
  }

  public String leiaString(String mensagem) {
    System.out.print(mensagem);
    return teclado.nextLine();
  }

  public boolean leiaBoolean(String mensagem) {
    System.out.print(mensagem);
    String resposta = teclado.nextLine();
    if (resposta.equals("S") || resposta.equals("s")) {
      return true;
    } else if (resposta.equals("N") || resposta.equals("n")) {
      return false;
    } else {
      System.out.print("\nOpção inválida! Tente novamente.");
      return false;
    }
  }
  
  public void alterarProduto() {
    System.out.print("\n1) Alterar ESTOQUE do produto."+
                        "\n2) Alterar PREÇO do produto."+
                        "\n3) Alterar NOME do produto.");
    int opcao = leiaInt("\nDigite a opção: ");
    teclado.nextLine();

    switch(opcao){
      case 1: 
        System.out.print("\n1) Acrescentar produto ao estoque."+
                          "\n2) Retirar produtos do estoque.");
        int op = leiaInt("\nDigite a opção: ");
        teclado.nextLine();
        produtos[buscaProduto(leiaString("Digite nome do produto: "))].setEstoqueProduto(op, leiaInt("Digite quantidade do produto: "));
        teclado.nextLine();
        break;
      case 2: produtos[buscaProduto(leiaString("Digite nome do produto: "))].setPrecoProduto(leiaDouble("Digite novo preço do produto: ")); 
      teclado.nextLine(); break;
      case 3: produtos[buscaProduto(leiaString("Digite nome do produto: "))].setNomeProduto(leiaString("Digite novo nome do produto: "));
      teclado.nextLine();
    }
  }

  public int buscaProduto(String nome) {
    for (int i = 0; i < produtos.length; i++) {
      if (produtos[i].nome.equals(nome)) {
        return i;
      }
    }
    return 0;
  }

  public void cadastrarCliente() {
    System.out.print("Digite nome do cliente: ");
    String nome = teclado.nextLine();
    System.out.print("Digite endereço de " + nome + ": ");
    String endereco = teclado.nextLine();
    System.out.print("Digite CPF de " + nome + ": ");
    String cpf = teclado.nextLine();
    clientes[contadorCliente] = new Cliente (nome, endereco, cpf);
    contadorCliente++;
  }

  public void efetuarCompra() {
    boolean resposta = true;
    int i = 0;

    while (resposta == true) {
      System.out.print("Digite nome do produto que será adicionado ao pedido: ");
      String nomeProduto = teclado.nextLine();
      int indice = buscaProduto(nomeProduto);
      int quantidade = leiaInt("Digite quantidade do produto a ser adicionada: ");
      if (i == 0) {
        pedidos[contadorPedido] = new Pedido(produtos[indice].getNomeProduto(),quantidade,produtos[indice].getPrecoProduto());
      } else {
        pedidos[contadorPedido].acrescentarProdutoPedido(produtos[indice].getNomeProduto(),quantidade,produtos[indice].getPrecoProduto());
      }
      i++;
      teclado.nextLine();
      resposta = leiaBoolean("Deseja adicionar mais algum produto ao pedido? [S/N]: ");
      produtos[indice].setEstoqueProduto(2, quantidade);
    }
    System.out.println(pedidos[contadorPedido]);
    contadorPedido++;
  }

  public void removerProduto() {
    System.out.print("Digite NOME do produto a ser removido: ");
    String nome = teclado.nextLine();
    int indice = buscaProduto(nome);
    while (produtos[indice] != null) {
      produtos[indice] = produtos[indice+1];
    }
    contadorProduto--;
  }

  public void cadastroProduto() {
    produtos[contadorProduto] = new Produto(leiaString("Digite nome do produto: "), leiaDouble("Digite preço do produto: "), leiaInt("Digite a quantidade em estoque do produto: "));
    contadorProduto++;
  }

  public void mostrarProdutos() {
    int i = 0;
    while (produtos[i] != null) {
      System.out.println(produtos[i]);
      i++;
    }
  }

  public void menu() {
    int opcao = -1;
    while (opcao != 0) {
      System.out.print("\n1) Cadastrar produto."+
                        "\n2) Remover produto."+
                        "\n3) Alterar produto."+
                        "\n4) Mostrar produtos."+
                        "\n5) Cadastrar cliente."+
                        "\n6) Efetuar compra."+
                        "\n0) Sair"+
                        "\nDigite opção: ");
      opcao = teclado.nextInt();
      teclado.nextLine();

      switch (opcao) {
        case 1:
          cadastroProduto();
          break;
        case 2:
          removerProduto();
          break;
        case 3:
          alterarProduto();
          break;
        case 4:
          mostrarProdutos();
          break;
        case 5:
          cadastrarCliente();
          break;
        case 6:
          efetuarCompra();
          break;
        case 0:
          System.out.println("Volte sempre!");
          break;
        default:
          System.out.println("Opção inválida! Tente novamente.");
          menu();
      }
    }
  }
}