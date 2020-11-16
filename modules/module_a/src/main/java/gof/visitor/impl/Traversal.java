package gof.visitor.impl;

import java.io.File;

public class Traversal {

    public static void traverse(File root, Visitor visitor) {
        if (root == null) {
            return;
        }
        if (visitor.accept(root)) {
            visitor.use(root);
        }
        if (root.isDirectory()) {
            for (File innerFile : root.listFiles()) {
                traverse(innerFile, visitor);
            }
        }
    }
}
