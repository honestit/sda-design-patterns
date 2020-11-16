package gof.singleton.impl;

import gof.singleton.factories.FiatFactory;

public class SingletonFiatFactory extends FiatFactory {

    private static SingletonFiatFactory INSTANCE;

    public synchronized static SingletonFiatFactory instance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonFiatFactory();
        }
        return INSTANCE;
    }

    private SingletonFiatFactory() {
        super();
    }
}
