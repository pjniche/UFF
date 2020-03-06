import java.util.Scanner;

public class Livro {
  private static int proximoCodigo = 1;
  private int codigo;
  private String titulo;
  private int paginas;

  public Livro(String titulo, int paginas) {
    this.codigo = proximoCodigo++;
    this.titulo = titulo;
    this.paginas = paginas;
  }

  public int getCodigo() {
    return codigo;
  }

  public String toString() {
    return titulo + " (código " + codigo + ")";
  }
}