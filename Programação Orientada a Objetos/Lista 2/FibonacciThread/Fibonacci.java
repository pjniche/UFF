public class Fibonacci implements Runnable {
  private long resultado;
	private int n;

  public Fibonacci(int n) {
    this.n = n;
  }

  public long getResultado() {
    return resultado;
  }

  private long fib(int n) {
    if (n < 2) {
      return n;
    } else {
      return (fib(n - 1) + fib(n - 2));
    }
  }

  @Override
  public void run() {
    resultado = fib(n);
  }
}