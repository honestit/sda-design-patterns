package gof.decorator;

public class CalculatorApp {

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.factorial(10);
        calculator.fibonacci(10);

        Calculator cached = CachedCalculator.cached(calculator);
        cached.factorial(10);
        cached.fibonacci(10);

        long factorial = cached.factorial(10);
        System.out.println(factorial);
        long fibonacci = cached.fibonacci(10);
        System.out.println(fibonacci);
    }
}
