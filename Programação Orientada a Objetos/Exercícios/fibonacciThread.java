import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fibonacci implements Runnable {

    private final int n;
    private long result;
    private static Map<Integer, Long> cache = new HashMap<>();
    
    static {
        cache.put(0, 0L);
        cache.put(1, 1L);
    }
    
    public Fibonacci(int n) {
        this.n = n;
    }
    
    public long getResult() {
        return result;
    }
    
    public static long calcula(int n) {
        if (n < 2) {
            return n;
        } else {
            return calcula(n-1) + calcula(n-2);
        }
    }
    
    public static long calculaParalelo(int n) throws InterruptedException {
        Fibonacci f1 = new Fibonacci(n-1);
        Fibonacci f2 = new Fibonacci(n-2);
        
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        return f1.getResult() + f2.getResult();
    }
    
    public static long calculaCache(int n) {
        Long fib = cache.get(n);
        if (fib == null) {
            fib = calculaCache(n-1) + calculaCache(n-2);
            cache.put(n, fib);
        }
        return fib;
    }
    
    @Override
    public void run() {
        result = calcula(n);
    }
    
    public static void main(String[] args) {
        int n = 45;

        long antes = System.currentTimeMillis();
        System.out.println("*** Execução sequencial ***");
        System.out.println("Fibonacci de " + n + " é " + Fibonacci.calcula(n));
        System.out.println("Levou " + (System.currentTimeMillis() - antes) + " ms.");

        
        try {        
            antes = System.currentTimeMillis();
            System.out.println("*** Execução paralela ***");
            System.out.println("Fibonacci de " + n + " é " + Fibonacci.calculaParalelo(n));
            System.out.println("Levou " + (System.currentTimeMillis() - antes) + " ms.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Fibonacci.class.getName()).log(Level.SEVERE, null, ex);
        }

        antes = System.currentTimeMillis();
        System.out.println("*** Execução sequencial com cache ***");
        System.out.println("Fibonacci de " + n + " é " + Fibonacci.calculaCache(n));
        System.out.println("Levou " + (System.currentTimeMillis() - antes) + " ms.");

        for (int chave : cache.keySet()) {
            System.out.println("fib(" + chave + ") = " + cache.get(chave));
        }
    }
}