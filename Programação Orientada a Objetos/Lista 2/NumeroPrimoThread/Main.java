import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int numero, metade;
    
		System.out.println("Digite um número: ");
    numero = teclado.nextInt();
    metade = numero / 2;
		
		Thread thread1 = new Thread(1, metade, numero);
		Thread thread2 = new Thread(metade + 1, numero, numero);
    
		Thread t1 = new Thread(thread1);
    Thread t2 = new Thread(thread2);
    
		t1.start();t2.start();
		
		if (!thread1.getValidacao() && !thread2.getValidacao()) {
			System.out.println("Número Primo!");
    } else {
			System.out.println("Não é número Primo!");
    }
  }
}