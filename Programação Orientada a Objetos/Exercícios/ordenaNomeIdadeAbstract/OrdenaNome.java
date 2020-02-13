public class OrdenaNome extends Ordenador {

    public boolean compara(Pessoa p1, Pessoa p2) {
      return p1.getNome().compareToIgnoreCase(p2.getNome()) > 0;
    }
  }