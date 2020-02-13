public class Agenda {
  Pessoa[] pessoas;

  public Agenda(int numeroPessoas) {
    pessoas = new Pessoa[numeroPessoas];
    for (int i = 0; i < pessoas.length; i++) {
      pessoas[i] = new Pessoa();
    }
  }

  public void ordenaNome() {
    for (int i = 0; i < pessoas.length; i++) {
        for (int j = i+1; j < pessoas.length; j++) {
            if (pessoas[i].getNome().compareTo(pessoas[j].getNome()) > 0) {
                Pessoa aux = pessoas[i];
                pessoas[i] = pessoas[j];
                pessoas[j] = aux;
            }            
        }
    }
  }
    
  public void ordenaIdade() {
    for (int i = 0; i < pessoas.length; i++) {
        for (int j = i+1; j < pessoas.length; j++) {
            if (pessoas[i].getIdade() > pessoas[j].getIdade()) {
                Pessoa aux = pessoas[i];
                pessoas[i] = pessoas[j];
                pessoas[j] = aux;
            }            
        }
    }
  }

  public void exibe() {
    System.out.println("----------");
    for (int i = 0; i < pessoas.length; i++) {
      pessoas[i].exibe();
      System.out.println("----------");
    }
  }
}