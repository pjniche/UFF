import java.util.HashSet;
import java.util.Set;

public class Pessoa {
	private Set<Pessoa> filhos = new HashSet<>();
	private Pessoa pai = null;
  private Pessoa mae = null;
  private String nome;
  private int idade;

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

	//get set
  private String getNome() {
    return nome;
  }
  private int getIdade() {
    return idade;
  }
  private void setNome(String nome) {
    this.nome = nome;
  }
  private void setIdade(int idade) {
    this.idade = idade;
  }
  private void setPai(Pessoa pai) {
    this.pai = pai;
		if (pai != null) {
			pai.addFilho(this);
		}
  }
  private void setMae(Pessoa mae) {
    this.mae = mae;
		if (mae != null) {
			mae.addFilho(this);
		}
  }

	//metodos
	public void addFilho(Pessoa filho) {
		filhos.add(filho);
	}

	//to String
  public String toString() {
    return (nome + ", " + idade + " anos. Filhos: " + filhos);
  }
}