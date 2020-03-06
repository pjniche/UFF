class Cliente {
  private String nome;
  private String endereco;
  private String cpf;

  public Cliente (String nome, String endereco, String cpf) {
    this.nome = nome;
    this.endereco = endereco;
    this.cpf = cpf;
  }

  public String getNomeCliente() {
    return nome;
  }

  public String getEnderecoCliente() {
    return endereco;
  }

  public String getCpfCliente() {
    return cpf;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String toString() {
    return "\nNome: " + nome + " Endereco: " + endereco + " CPF: " + cpf;
  }
}