package gof.singleton.impl;

import gof.singleton.factories.SkodaFactory;

public class SingletonSkodaFactory extends SkodaFactory {

    public static SingletonSkodaFactory instance() {
        return InstanceWrapper.instance;
    }

    private SingletonSkodaFactory() {
        super();
    }

    private static class InstanceWrapper {
        public static final SingletonSkodaFactory instance = new SingletonSkodaFactory();
    }
}
