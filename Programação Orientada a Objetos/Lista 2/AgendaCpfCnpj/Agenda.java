import java.util.Scanner;

public class Agenda {
  Scanner teclado = new Scanner(System.in);
  Pessoa[] pessoas = new Pessoa[100];
  int cont = 0;

  public void cadastraPessoaFisica() {
    pessoas[cont] = new PessoaFisica(leiaString("Nome: "), leiaString("CPF: "),leiaString("Endereço: "));
    cont++;
  }

  public void cadastaPessoaJuiridica() {
    pessoas[cont] = new PessoaJuridica(leiaString("Razão Social: "), leiaString("CNPJ: "),leiaString("Endereco: "));
    cont++;
  }

  public void exibeContatos() {
    for (int i = 0; i < cont; i++) {
      System.out.println(pessoas[i]);
    }
  }

  public void buscaContato() {
    String id = leiaString("Digite o CPF/CNPJ da pessoa ou empresa a ser pesquisado: ");
    int i = 0;

    while (!(id.equals(pessoas[i].getId()))) {
      i++;
    }

    if (id.equals(pessoas[i].getId())) {
      System.out.println(pessoas[i]);
    }else {
      System.out.println("CPF/CNPJ não cadastrado!");
    }  
  }

  public void escolha(int opcao) {
    switch (opcao) {
      case 1: cadastraPessoaFisica();
              break;
      case 2: cadastaPessoaJuiridica();
              break;
      case 3: exibeContatos();
              break;
      case 4: buscaContato();
              break;
      case 5: break;
      default:System.out.println("Valor invalido!");
    }
  }

  public double leiaDouble(String mensagem) {
    System.out.print(mensagem);
    return teclado.nextDouble();
  }

  public int leiaInt(String mensagem) {
    System.out.print(mensagem);
    return teclado.nextInt();
  }

  public String leiaString(String mensagem) {
    System.out.print(mensagem);
    return teclado.nextLine();
  }

  public void menu() {
    int opcao = 0;
    do {
    opcao = leiaInt("AGENDA" +
										"\n1) Cadastrar Pessoa Física." +
                    "\n2) Cadastrar Pessoa Jurídica." +
                    "\n3) Exibir contatos." +
                    "\n4) Buscar contato." +
                    "\n5) Sair." +
                    "\nDigite a opção desejada: ");
    teclado.nextLine();
    escolha(opcao);
    } while (opcao != 5);
  }
}