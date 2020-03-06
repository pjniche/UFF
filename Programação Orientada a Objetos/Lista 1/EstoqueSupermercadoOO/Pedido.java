class Pedido {
  private final int MAX = 100;
  private String nomeProdutos[] = new String[MAX];
  private int itensPedido[] = new int[MAX];
  private int contadorProdutos = 0;
  private int contadorPedido = 1;
  private double precoTotal = 0;

  public Pedido(String nomeProdutos, int itensPedido, double precoUnidade) {
    this.nomeProdutos[contadorProdutos] = new String();
    this.nomeProdutos[contadorProdutos] = nomeProdutos;
    this.itensPedido[contadorProdutos] = itensPedido;
    this.precoTotal = precoTotal + (precoUnidade * this.itensPedido[contadorProdutos]);
    setContadorProduto();
  }

  public void acrescentarProdutoPedido(String nomeProdutos, int itensPedido, double precoUnidade) {
    this.nomeProdutos[contadorProdutos] = new String();
    this.nomeProdutos[contadorProdutos] = nomeProdutos;
    this.itensPedido[contadorProdutos] = itensPedido;
    this.precoTotal = precoTotal + (precoUnidade * this.itensPedido[contadorProdutos]);
    setContadorProduto();
  }

  public void produtoString() {
    for (int i = 0; i < contadorProdutos; i++) {
      System.out.println(nomeProdutos[i] + " Quantidade: " + itensPedido[i]);
    }
  }

  public void setCodigoPedido() {
    contadorPedido++;
  }

  public void setContadorProduto() {
    contadorProdutos++;
  }

  public String getNomeProduto() {
    return(nomeProdutos[contadorProdutos]);
  }

  public String toString() {
    System.out.println("Itens pedido:");
    produtoString();
    return "\nPedido: " + contadorPedido + "\nPreco total: " + precoTotal;
  }
}