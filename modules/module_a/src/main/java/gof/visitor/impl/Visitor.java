package gof.visitor.impl;

import java.io.File;

public interface Visitor {

    void use(File file);

    boolean accept(File file);
}
