package gof.singleton.factories;

import gof.singleton.cars.Car;
import gof.singleton.cars.Combi;
import gof.singleton.cars.SUV;
import gof.singleton.cars.Sedan;

public abstract class CarFactory {

    protected static final Made DEFAULT_MADE;
    static {
        String defaultMadeProp = System.getProperty("default.car.made");
        Made defaultMadeValue = null;
        if (defaultMadeProp != null) {
            try {
                defaultMadeValue = Made.valueOf(defaultMadeProp);
            } catch (IllegalArgumentException iae) {
                iae.printStackTrace();
                System.err.println("Błędna nazwa marki domyślnej");
            }
        }
        DEFAULT_MADE = defaultMadeValue;
    }

    public static CarFactory getFactory(Made made) {
        switch (made) {
            case FIAT:
                return new FiatFactory();
            case SKODA:
                return new SkodaFactory();
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

    protected Car combiPrototype;
    protected Car suvPrototype;
    protected Car sedanPrototype;

    public abstract Combi combi();

    public abstract SUV suv();

    public abstract Sedan sedan();

    public static enum Made {

        FIAT("Fiat"),
        SKODA("Skoda");

        private final String madeName;

        Made(String madeName) {
            this.madeName = madeName;
        }

        public String getMadeName() {
            return this.madeName;
        }
    }
}
