public class Quadrado extends Geometria {
  private double lado;

  public Quadrado(double lado) {
    this.lado = lado;
  }

  public double calculaArea() {
    return lado * lado;
  }
}