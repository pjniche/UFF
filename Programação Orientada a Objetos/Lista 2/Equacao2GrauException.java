import java.util.Scanner;
import java.util.InputMismatchException;

public class Equacao2GrauException {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double a, b, c;// ax² + bx + c = 0
		double delta;// b² – 4 * a * c
		double x1, x2;// primeira e segunda raizes da equação

		try {
			System.out.print("Insira o valor de A: ");
			a = input.nextDouble();
			System.out.print("Insira o valor de B: ");
			b = input.nextDouble();
			System.out.print("Insira o valor de C: ");
			c = input.nextDouble();
			delta = ((Math.pow(b, 2)) - 4 * (a * c));// calculando o Delta
			if (delta >= 0) {
				// se o delta >= 0 podemos resolver.
				try {
					x1 = ((-b + (Math.sqrt(delta))) / (2 * a));// equação do x1
     			x2 = ((-b - (Math.sqrt(delta))) / (2 * a));// equação do x2
     			System.out.println("x1 vale: " + x1);
     			System.out.println("x2 vale: " + x2);
				} catch (ArithmeticException e) {
					// ERRO Aqui! Não está pegando a exceção, não entendi o motivo.
					System.out.println("ERRO! (" + e + ") Divisão por ZERO!");
				}
   		} else {
				// se o delta < 0 não podemos resolver.
     		System.out.println("Delta invalido!");
   		}
		} catch (InputMismatchException e) {
			System.out.println("ERRO! (" + e + ") Digite um número Real válido!");
		}
 	}
}