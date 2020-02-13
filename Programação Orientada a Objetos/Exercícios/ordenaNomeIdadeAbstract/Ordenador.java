public abstract class Ordenador {
	
	public abstract boolean compara(Pessoa p1, Pessoa p2);

  public void ordena(Pessoa[] pessoas) {
		for (int i = 0; i < pessoas.length; i++) {
			for (int j = i+1; j < pessoas.length; j++) {
				if (compara(pessoas[i], pessoas[j])) {
					Pessoa aux = pessoas[i];
					pessoas[i] = pessoas[j];
					pessoas[j] = aux;
				}            
      }
    }
  }
}