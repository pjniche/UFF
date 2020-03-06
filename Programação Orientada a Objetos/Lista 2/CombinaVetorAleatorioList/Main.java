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

	public static List<Integer> criaListaOrdenada(List<Integer> lista1, List<Integer> lista2) {
		List<Integer> aux = new ArrayList<>();
		//corre as listas até uma das duas terminar
		int i = 0, j = 0;
    while (i < lista1.size() && j < lista2.size()) {
      if (lista1.get(i).getInteger() < lista2.get(j).getInteger()) { //elemento da lista1 maior
        aux.add(lista1.get(i));
        i++;
      } else if (lista1.get(i).getInteger() > lista2.get(j).getInteger()) { //elemento da lista2 maior
        aux.add(lista2.get(j));
        j++;
      } else { //elementos iguais
        aux.add(lista1.get(i));
        i++;
        aux.add(lista2.get(j));
        j++;
      }
    }
    //termina de correr a lista restante
    while (i < lista1.size()) {
      aux.add(lista1.get(i));
      i++;
    }
    while (j < lista2.size()) {
      aux.add(lista2.get(j));
      j++;
    }
		return aux;
	}

	public static void imprime(List<Integer> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i).getInteger() + " ");
		}
  	System.out.println();
	}

  public static void main(String[] args) {
		List<Integer> lista1 = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();
		List<Integer> lista3 = new ArrayList<>();
    final int MAX = 50;

    //carrega a primeira lista com números aleatórios
    randomico(lista1, MAX);

    //carrega a segunda lista com números aleatórios
    randomico(lista2, MAX);
    
    //ordena a primeira lista
    ordenaLista(lista1);

    //ordena a segunda lista
    ordenaLista(lista2);

    //imprime a primeira lista ordenada
		System.out.println("Lista 1.");
    imprime(lista1);

    //imprime a segunda lista ordenada
		System.out.println("Lista 2.");
    imprime(lista2);

		//cria o terceiro vetor ordenando na entrada
		lista3 = criaListaOrdenada(lista1, lista2);

    //imprime a terceira lista ordenada
		System.out.println("Lista 3.");
    imprime(lista3);
  }
}