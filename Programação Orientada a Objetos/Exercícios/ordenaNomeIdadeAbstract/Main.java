class Main {
  public static void main(String[] args) {
    Agenda agenda = new Agenda(3);
    
    System.out.println("\nAgenda ordenada por NOME:");
    Ordenador ordenador = new OrdenadorNome();
    ordenador.ordena(agenda.getPessoas());

    agenda.exibe();
    
    System.out.println("\nAgenda ordenada por IDADE:");
    ordenador = new OrdenadorIdade();
    ordenador.ordena(agenda.getPessoas());

    agenda.exibe();
  }
}