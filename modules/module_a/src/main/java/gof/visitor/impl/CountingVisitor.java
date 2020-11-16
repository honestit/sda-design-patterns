package gof.visitor.impl;

import java.io.File;
import java.util.function.Predicate;

public class CountingVisitor implements Visitor {

    private final Predicate<File> condition;
    private long count;

    public CountingVisitor(Predicate<File> condition) {
        this.condition = condition;
    }

    @Override
    public void use(File file) {
        count++;
    }

    @Override
    public boolean accept(File file) {
        return condition.test(file);
    }

    public long getCount() {
        return this.count;
    }
}
