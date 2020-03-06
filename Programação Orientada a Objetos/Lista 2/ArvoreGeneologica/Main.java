public class Main {
  public static void main(String[] args) {
    //pais
		Pessoa joao = new Pessoa("João", 52);
		Pessoa maria = new Pessoa("Maria", 47);

		//filhos
		Pessoa paulo = new Pessoa("Paulo", 25, joao, maria);
		Pessoa roberto = new Pessoa("Roberto", 35, joao, maria);
		Pessoa priscila = new Pessoa("Priscila", 28);

		//netos
		Pessoa junior = new Pessoa("Júnior", 7, roberto, priscila);

    System.out.println(junior);
  }
}