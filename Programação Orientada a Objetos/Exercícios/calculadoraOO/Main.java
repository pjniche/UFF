class Main {
  public static void main(String[] args) {
    Calculadora hp = new Calculadora("HP");
    Calculadora casio = new Calculadora("Casio");

    hp.soma(5);
    hp.multiplica(3);

    casio.soma(1000);
    casio.divide(10);

    hp.exibeMemoria();
    casio.exibeMemoria();

    // hp.zera();
    // hp.modoInterativo();
  }
}