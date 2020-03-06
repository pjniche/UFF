import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void randomico(List<Integer> lista, int n) {
		for (int i = 0; i < n; i++) {
			lista.add(new Integer((int)(Math.random() * 1000)));
		}
	}
	
	public static void ordenaLista(List<Integer> lista) {
		for (int i = 0; i < lista.size(); i++) {
    	for (int j = i; j < lista.size(); j++) {
      	if (lista.get(i).getInteger() > lista.get(j).getInteger()) {
        	Integer aux = new Integer(lista.get(i).getInteger());
        	lista.set(i, lista.get(j));
        	lista.set(j, aux);
      	}
    	}
  	}
	}

	public static void imprime(List<Integer> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i).getInteger() + " ");
		}
  	System.out.println();
	}
  
	public static void main(String[] args) {
		List<Integer> valores = new ArrayList<>();
		final int MAX = 100;

		//adicionando valores aleatórios a lista
		randomico(valores, MAX);

		//imprime desordenado
    System.out.println("Lista desordenada.");
    imprime(valores);
    
		//ordena a lista
    ordenaLista(valores);

		//imprime ordenado
    System.out.println("Lista ordenada.");
    imprime(valores);
  }
}