import java.util.Scanner;

public class Agenda {
  private Contato[] contatos;
  private int numContatos = 0;
  
  private String nome;

  public Agenda(int tamanho) {
    contatos = new Contato[tamanho];
  }

  public Contato getContato(int id) {
    for (int i = 0; i < numContatos; i++) {
      if (contatos[i].getId() == id) {
        return contatos[i];
      }
    }
    return null;
  }

  public void cadastraContato() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Entre com o nome do contato: ");
    String nome = teclado.nextLine();
    System.out.print("Entre com o telefone do contato: ");
    String telefone = teclado.nextLine();
    contatos[numContatos++] = new Contato(nome, telefone);
  }

  public void excluiContato() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("\nEntre com o ID do contato: ");
    Contato aux = getContato(teclado.nextInt());
    if (aux != null) {
      aux = null;
      numContatos--;
      System.out.println("Contato excluído com sucesso!");
    }
  }

  public void listaContatos() {
    System.out.println("\nContatos cadastrados:");
    for (int i = 0; i < numContatos; i++) {
      System.out.println(contatos[i]);
    }
  }

  public byte exibeMenu() {
    Scanner teclado = new Scanner(System.in);
    System.out.println("\nA agenda contém " + numContatos + " contato(s).");
    System.out.println("Menu:");
    System.out.println("1) Cadastrar Contato.");
    System.out.println("2) Listar Contato.");
    System.out.println("3) Excluir Contatos.");
    System.out.println("0) Sair.");
    System.out.print("Selecione a opção desejada: ");
    return teclado.nextByte();
  }

  public void inicia() {
    byte opcao;
    do {
      opcao = exibeMenu();
      switch (opcao) {
        case 1:
          cadastraContato();
          break;
        case 2:
          listaContatos();
          break;
        case 3:
          excluiContato();
          break;
        case 0:
          System.out.println("Obrigado por usar a agenda!");
          break;
        default:
          System.out.println("Opção inválida! Tente novamente.");
      }
    } while (opcao != 0);
  }
}