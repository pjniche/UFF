import java.util.Scanner;

public class HoraMinutoSegundo {
  public static int leitura() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite um valor em Segundos: ");
    int valorLido = teclado.nextInt();
    return valorLido;
  }

  public static void escrita(int valorEscrito) {
    System.out.println(horas(valorEscrito) + ":" +
                       minutos(valorEscrito) + ":" +
                       segundos(valorEscrito));
  }

  public static int horas(int valor) {
    //6000 segundos = 1 hora
    int hora = valor / 6000;
    return hora;
  }

  public static int minutos(int valor) {
    //100 segundos = 1 minuto
    //retorna o resto da divisão das horas / 100
    int min = (valor % 6000) / 100;
    return min;
  }

  public static int segundos(int valor) {
    //retorna somente o resto das divisões dos minutos e das horas
    int seg = ((valor % 6000) % 100);
    return seg;
  }

  public static void main(String[] args) {
    escrita(leitura());
  }
}