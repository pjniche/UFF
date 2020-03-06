public class Thread implements Runnable {
	
	private Boolean validacao = false;
	private int inicio;
	private int fim;
	private int numero;
	
	public void run() {
		for (;this.inicio < this.fim; inicio++) {
			if (this.numero % inicio == 0) {
				this.validacao = true;
      }
    }
  }
  
	public Boolean getValidacao() {
		return (this.validacao);
  }
  
	public void Thread(int inicio, int fim, int numero) {
		this.inicio = inicio;
		this.fim = fim;
		this.numero = numero;
  }
}