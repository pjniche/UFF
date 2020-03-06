import java.util.Scanner;

public class Biblioteca {
  private Cliente[] clientes;
  private int numClientes = 0;

  private Livro[] livros;
  private int numLivros = 0;

  private Emprestimo[] emprestimos;
  private int numEmprestimos = 0;
  
  private String nome;

  public Biblioteca(String nome, int tamanho) {
    this.nome = nome;
    clientes = new Cliente[tamanho];
    livros = new Livro[tamanho];
    emprestimos = new Emprestimo[tamanho];
  }

  public Cliente getCliente(int matricula) {
    for (int i = 0; i < numClientes; i++) {
      if (clientes[i].getMatricula() == matricula) {
        return clientes[i];
      }
    }
    return null;
  }

  public Livro getLivro(int codigo) {
    for (int i = 0; i < numLivros; i++) {
      if (livros[i].getCodigo() == codigo) {
        return livros[i];
      }
    }
    return null;
  }

  public Emprestimo getEmprestimoEmAndamento(Livro livro) {
    for (int i = 0; i < numEmprestimos; i++) {
      if ((emprestimos[i].getLivro() == livro) && (!emprestimos[i].finalizado())) {
        return emprestimos[i];
      }
    }
    return null;
  }


  public void cadastraCliente() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Entre com o nome do cliente: ");
    String nome = teclado.nextLine();
    System.out.print("Entre com o endereço do cliente: ");
    String endereco = teclado.nextLine();
    clientes[numClientes++] = new Cliente(nome, endereco);
  }

  public void listaClientes() {
    System.out.println("\nClientes cadastrados:");
    for (int i = 0; i < numClientes; i++) {
      System.out.println(clientes[i]);
    }
  }

  public void cadastraLivro() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Entre com o título do livro: ");
    String titulo = teclado.nextLine();
    System.out.print("Entre com o número de páginas do livro: ");
    int paginas = teclado.nextInt();
    livros[numLivros++] = new Livro(titulo, paginas);
  }

  public void listaLivros() {
    System.out.println("\nLivros cadastrados:");
    for (int i = 0; i < numLivros; i++) {
      System.out.println(livros[i]);
    }
  }

  public void emprestaLivro() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Entre com a matrícula do cliente: ");
    Cliente cliente = getCliente(teclado.nextInt());
    if (cliente != null) {
      System.out.print("Entre com o código do livro: ");
      Livro livro = getLivro(teclado.nextInt());
      if (livro != null) {
        Emprestimo emprestimo = getEmprestimoEmAndamento(livro);
        if (emprestimo == null) {
          emprestimos[numEmprestimos++] = new Emprestimo(livro, cliente);
        } else {
          System.out.println("Livro encontra-se emprestado no momento.");  
        }
      } else {
        System.out.println("Livro inexistente.");
      }
    } else {
      System.out.println("Cliente inexistente.");
    }
  }

  public void devolveLivro() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Entre com o código do livro: ");
    Livro livro = getLivro(teclado.nextInt());
    if (livro != null) {
      Emprestimo emprestimo = getEmprestimoEmAndamento(livro);
      if (emprestimo != null) {
        emprestimo.finaliza();
      } else {
        System.out.println("Não há registro de empréstimo constando esse livro.");  
      }
    } else {
      System.out.println("Livro inexistente.");
    }
  }

  public void listaEmprestimos() {
    System.out.println("\nEmpréstimos realizados:");
    for (int i = 0; i < numEmprestimos; i++) {
      System.out.println(emprestimos[i]);
    }
  }

  public byte exibeMenu() {
    Scanner teclado = new Scanner(System.in);
    System.out.println("\nA biblioteca " + nome + " contém " + numClientes + " clientes, " + numLivros + " livros e " + numEmprestimos + " emprestimos.");
    System.out.println("Menu:");
    System.out.println("1) Cadastrar Cliente.");
    System.out.println("2) Listar Clientes.");
    System.out.println("3) Cadastrar Livro.");
    System.out.println("4) Listar Livros.");
    System.out.println("5) Emprestar Livro.");
    System.out.println("6) Devolver Livro.");
    System.out.println("7) Listar Empréstimos.");
    System.out.println("8) Sair.");
    System.out.print("Selecione a opção desejada: ");
    return teclado.nextByte();
  }

  public void inicia() {
    byte opcao;
    do {
      opcao = exibeMenu();
      switch (opcao) {
        case 1:
          cadastraCliente();
          break;
        case 2:
          listaClientes();
          break;
        case 3:
          cadastraLivro();
          break;
        case 4:
          listaLivros();
          break;
        case 5:
          emprestaLivro();
          break;
        case 6:
          devolveLivro();
          break;
        case 7:
          listaEmprestimos();
          break;
        case 8:
          System.out.println("Obrigado por usar a biblioteca " + nome + "!");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (opcao != 8);
  }
}