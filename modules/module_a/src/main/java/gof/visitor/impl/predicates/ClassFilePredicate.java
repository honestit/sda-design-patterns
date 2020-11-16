package gof.visitor.impl.predicates;

import java.io.File;
import java.util.function.Predicate;

public class ClassFilePredicate implements Predicate<File> {

    @Override
    public boolean test(File file) {
        return file.getName().endsWith(".class");
    }
}
