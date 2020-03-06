public class PessoaFisica extends Pessoa {
  private String nome;
  private String cpf;

  public PessoaFisica(String nome, String cpf, String endereco) {
    setNome(nome);
    setCPF(cpf);
    setEndereco(endereco);
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCPF(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public String getId() {
    return cpf;
  }

  public String toString(){
    return ("Nome: " + nome + "\nCPF: " + cpf + "\nEndereço: " + endereco + "\n");
  }
}