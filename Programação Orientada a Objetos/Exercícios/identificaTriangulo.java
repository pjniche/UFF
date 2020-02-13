import java.util.Scanner;
 
public class identificaTriangulo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
 
        System.out.println("Entre com x do ponto 1:");
        double x1 = teclado.nextDouble();
        System.out.println("Entre com y do ponto 1:");
        double y1 = teclado.nextDouble();
        System.out.println("Entre com x do ponto 2:");
        double x2 = teclado.nextDouble();
        System.out.println("Entre com y do ponto 2:");
        double y2 = teclado.nextDouble();
        System.out.println("Entre com x do ponto 3:");
        double x3 = teclado.nextDouble();
        System.out.println("Entre com y do ponto 3:");
        double y3 = teclado.nextDouble();
       
        double l1 = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
        double l2 = Math.sqrt(Math.pow(x2-x3,2) + Math.pow(y2-y3,2));
        double l3 = Math.sqrt(Math.pow(x1-x3,2) + Math.pow(y1-y3,2));
       
        if ((l1 + l2 == l3) || (l1 + l3 == l2) || (l2 + l3 == l1)) {
            System.out.println("Não é triângulo");
        } else if (l1 == l2 && l2 == l3) {
            System.out.println("O triângulo é equilátero.");//3 lados iguais.
        } else if (l1 == l2 || l2 == l3 || l1 == l3) {
            System.out.println("O triângulo é isósceles.");//2 lados iguais.
        } else {
            System.out.println("O triângulo é escaleno.");//3 lados diferentes.
        }
    }
}