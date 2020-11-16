package gof.singleton.impl;

import gof.singleton.cars.Combi;
import gof.singleton.cars.SUV;
import gof.singleton.cars.Sedan;
import gof.singleton.factories.CarFactory;

public abstract class SingletonCarFactory extends CarFactory {

    public static CarFactory getFactory(Made made) {
        switch (made) {
            case FIAT:
                return SingletonFiatFactory.instance();
            case SKODA:
                return SingletonSkodaFactory.instance();
            default:
                return new CarFactory() {

                    @Override
                    public Combi combi() {
                        return new Combi();
                    }

                    @Override
                    public SUV suv() {
                        return new SUV();
                    }

                    @Override
                    public Sedan sedan() {
                        return new Sedan();
                    }
                };
        }
    }

    public static CarFactory getDefaultFactory() {
        if (DEFAULT_MADE == null) {
            throw new IllegalStateException("Nie ustawiono marki domyślnej");
        }
        return getFactory(DEFAULT_MADE);
    }
}
