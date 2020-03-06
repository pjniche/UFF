public class Circulo extends Geometria{
 private double circunferencia;

 public Circulo(double circunferencia) {
  this.circunferencia = circunferencia;
 }

  public double calculaArea() {
    double r = calculaRaio();
    return (Math.PI * (r * r));
  }

  public double calculaRaio() {
    return circunferencia / (2 * Math.PI);
  }
}