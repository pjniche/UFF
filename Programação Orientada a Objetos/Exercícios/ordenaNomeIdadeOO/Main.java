public class Main {
  public static void main(String[] args) {
    Agenda agenda = new Agenda(3);
    
    System.out.println("\nAgenda ordenada por nome:");
    agenda.ordenaNome();
    agenda.exibe();
    
    System.out.println("\nAgenda ordenada por idade:");
    agenda.ordenaIdade();
    agenda.exibe();
  }
}