import java.util.Scanner;

public class DistanciaEntre2Pontos {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    //2 pontos com 3 dimensões e a distancia
    double ax, ay, az, bx, by, bz, distancia;

    System.out.println("Entre com as coordenadas do ponto A");
    System.out.print("X = ");
    ax = teclado.nextDouble();
    System.out.print("Y = ");
    ay = teclado.nextDouble();
    System.out.print("Z = ");
    az = teclado.nextDouble();
    System.out.println("Entre com as coordenadas do ponto B");
    System.out.print("X = ");
    bx = teclado.nextDouble();
    System.out.print("Y = ");
    by = teclado.nextDouble();
    System.out.print("Z = ");
    bz = teclado.nextDouble();

    //calculando a distancia
    //distancia = raiz quadrada de (Ax - Bx)² + (Ay - By)² + (Az - Bz)²
    distancia = Math.sqrt((Math.pow(ax - bx, 2) + Math.pow(ay - by, 2)) + Math.pow(az - bz, 2));    
    System.out.println("A distancia é: " + distancia);
  }
}