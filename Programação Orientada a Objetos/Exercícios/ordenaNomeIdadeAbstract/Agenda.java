public class Agenda {
  private Pessoa[] pessoas;

  public Agenda(int numeroPessoas) {
    pessoas = new Pessoa[numeroPessoas];
    for (int i = 0; i < pessoas.length; i++) {
      pessoas[i] = new Pessoa();
    }
  }

  public Pessoa [] getPessoas(){
    return pessoas;
  }

  public void exibe() {
    for (int i = 0; i < pessoas.length; i++) {
      pessoas[i].exibe();
    }
  }
}