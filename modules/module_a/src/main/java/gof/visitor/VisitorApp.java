package gof.visitor;

import java.io.File;

public class VisitorApp {

    public static void main(String[] args) {

        File currentDir = new File(".");

        System.out.println("--- Przechodzimy po katalogu bieżącym");
        traverse(currentDir);
    }

    public static void traverse(File root) {
        if (root == null) {
            return;
        }
        if (root.isDirectory()) {
            for (File innerFile : root.listFiles()) {
                traverse(innerFile);
            }
        }
    }
}
