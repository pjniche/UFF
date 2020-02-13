public class OrdenaIdade extends Ordenador {

  public boolean compara(Pessoa p1, Pessoa p2) {
    return p1.getIdade() > p2.getIdade();
  }
}