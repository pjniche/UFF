public class Pessoa {
  private String nome;
  private int idade;
  private Pessoa pai = null;
  private Pessoa mae = null;

	//construtor
  public Pessoa(String nome, int idade) {
    this(nome, idade, null, null);
  }

  public Pessoa(String nome, int idade, Pessoa pai, Pessoa mae) {
    setNome(nome);
    setIdade(idade);
    setPai(pai);
    setMae(mae);
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public void setPai(Pessoa pai) {
    this.pai = pai;
  }

  public void setMae(Pessoa mae) {
    this.mae = mae;
  }

  public String toString() {
		if (pai == null || mae == null) {
			return ("(" + nome + ", " + idade + " anos");
		} else {
			return ("(" + nome + ", " + idade + " anos (" + pai + " | " + mae + ")");
		}
  }
}