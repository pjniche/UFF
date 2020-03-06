import java.util.Scanner;
import java.util.InputMismatchException;

public class ProgramaComDefeitoException {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		try {
			float x1, y1, x2, y2;
			double distancia;
		
			System.out.println("Entre com as coordenadas do Ponto A.");
			System.out.print("X: ");
			x1 = teclado.nextFloat();
			System.out.print("Y: ");
			y1 = teclado.nextFloat();
			System.out.println("Entre com as coordenadas do Ponto B.");
			System.out.print("X: ");
			x2 = teclado.nextFloat();
			System.out.print("Y: ");
			y2 = teclado.nextFloat();
		
			//fazendo o casting do "1/2" resolve o problema
			distancia = Math.pow(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2), (double)1/2);
			System.out.println("A distância é: " + distancia);
		} catch (InputMismatchException e) {
			System.out.println("ERRO! (" + e + ") Digite um número Real válido!");
		}
	}
}