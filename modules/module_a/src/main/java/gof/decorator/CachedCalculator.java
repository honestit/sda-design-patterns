package gof.decorator;

import java.util.HashMap;
import java.util.Map;

public class CachedCalculator implements Calculator {

    private Calculator decorated;

    private CachedCalculator(Calculator decorated) {
        this.decorated = decorated;
    }

    public static Calculator cached(Calculator calculator) {
        return new CachedCalculator(calculator);
    }

    private Map<String, Map<Integer, Long>> cache = new HashMap<>();
    {
        cache.put("factorial", new HashMap<>());
        cache.put("fibonacci", new HashMap<>());
    }

    @Override
    public long factorial(int n) {
        return cache.get("factorial").computeIfAbsent(n, decorated::factorial);
    }

    @Override
    public long fibonacci(int n) {
        return cache.get("fibonacci").computeIfAbsent(n, decorated::fibonacci);
    }
}
