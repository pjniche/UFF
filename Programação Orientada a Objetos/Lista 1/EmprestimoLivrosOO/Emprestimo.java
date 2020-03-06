import java.util.Date;

public class Emprestimo {
  private Livro livro;
  private Cliente cliente;
  private Date retirada;
  private Date devolucao = null;

  public Emprestimo(Livro livro, Cliente cliente) {
    this.livro = livro;
    this.cliente = cliente;
    retirada = new Date();
  }

  public Livro getLivro() {
    return livro;
  }

  public boolean finalizado() {
    return devolucao != null;
  }

  public void finaliza() {
    devolucao = new Date();
  }
  
  public String toString() {
    String texto = "O livro " + livro + " foi emprestado para o cliente " + cliente + " no dia " + retirada;
    if (devolucao != null) {
      texto += " e devolvido no dia " + devolucao + ".";
    } else {
      texto += " e ainda não foi devolvido.";
    }
    return texto;
  }
}