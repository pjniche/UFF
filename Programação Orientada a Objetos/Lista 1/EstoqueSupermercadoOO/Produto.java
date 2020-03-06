class Produto {
  /*private*/ String nome;
  private double preco;
  private int estoque;

  public Produto(String nome, double preco, int estoque) {
    this.nome = nome;
    this.preco = preco;
    this.estoque = estoque;
  }

  public String getNomeProduto() {
    return nome;
  }

  public double getPrecoProduto() {
    return preco;
  }

  public int getEstoqueProduto() {
    return estoque;
  }

  public void setEstoqueProduto(int opcao, int estoque) {
    if(opcao == 1) {
      this.estoque += estoque;
    } else if (opcao == 2) {
      this.estoque -= estoque;
    }
  }

  public void setPrecoProduto(double preco) {
    this.preco = preco;
  }

  public void setNomeProduto(String nome) {
    this.nome = nome;
  }

  public String toString() {
    return nome + "[Preco unidade: " + preco + " | Estoque: " + estoque + "]";
  }
}