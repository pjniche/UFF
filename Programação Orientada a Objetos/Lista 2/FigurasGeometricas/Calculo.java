import java.util.Scanner;

class Calculo {
  Scanner teclado = new Scanner(System.in);
  
  private Geometria[] figurasGeometricas = new Geometria[100];
  int indiceDeFiguras = 0;

  public void menu() {
    int opcao = 0;

    do {
      System.out.println("\nCÁLCULO DE ÁREA:" +
      										"\n1) Quadrado" +
      										"\n2) Retângulo" +
      										"\n3) Triângulo" +
      										"\n4) Círculo" +
      										"\n5) Sair");
			System.out.print("Digite a opção desejada: ");
      opcao = teclado.nextInt();

      switch(opcao){
        case 1: figurasGeometricas[indiceDeFiguras] = new Quadrado(leiaDouble("Digite valor dos Lados: "));
                indiceDeFiguras++;
                break;
        case 2: figurasGeometricas[indiceDeFiguras] = new Retangulo(leiaDouble("Digite base do Retângulo: "),leiaDouble("Digite altura do Retângulo: ")); 
                indiceDeFiguras++;
                break;
        case 3: figurasGeometricas[indiceDeFiguras] = new Triangulo(leiaDouble("Digite base do Retângulo: "),leiaDouble("Digite altura do Retângulo: "));
                indiceDeFiguras++;
                break;
        case 4: figurasGeometricas[indiceDeFiguras] = new Circulo(leiaDouble("Digite valor da Circuferência: "));
                indiceDeFiguras++;
                break;
        case 5: System.out.println("Obrigado por usar o programa!"); 
                break;
        default:System.out.println("Valor invalido!");
                break;        
      }
      System.out.println("Resultado = " + figurasGeometricas[indiceDeFiguras-1].calculaArea());
    } while (opcao != 5);
    exibeFiguras();
  }

  public double leiaDouble(String mensagem) {
    System.out.print(mensagem);
    return teclado.nextDouble();
  }

  public void exibeFiguras() {
    System.out.println("\n Resultados: \n");
    for(int i = 0; i < indiceDeFiguras; i++) {
      System.out.println("figurasGeometricas [" + i + "] = " + figurasGeometricas[i].calculaArea());
    }
  }
}