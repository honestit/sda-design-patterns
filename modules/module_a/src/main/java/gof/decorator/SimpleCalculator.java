package gof.decorator;

public class SimpleCalculator implements Calculator {

    @Override
    public long factorial(int n) {
        System.out.println("Obliczam silnię z " + n);
        if (n < 0) throw new IllegalArgumentException("Wartość ujemna niedozwolona");
        if (n == 0 || n == 1) return 1;
        for (int i = 2; i < n; i++) {
            n *= i;
        }
        return n;
    }

    @Override
    public long fibonacci(int n) {
        System.out.println("Obliczam " + n + " element fibonacciego");
        if (n < 1) throw new IllegalArgumentException("Nie obliczymy dla wartości poniżej 1");
        if (n == 1 || n == 2) return 1;
        long prev = 1;
        long next = 2;
        for (int i = 3; i <= n; i++) {
            long tmp = next;
            next = next + prev;
            prev = tmp;
        }
        return next;
    }
}
