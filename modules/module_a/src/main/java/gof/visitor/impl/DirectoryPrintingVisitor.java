package gof.visitor.impl;

import java.io.File;

public class DirectoryPrintingVisitor implements Visitor {

    @Override
    public void use(File file) {
        System.out.println(file.getAbsolutePath());
    }

    @Override
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
