package gof.abstract_factory.factories;

import gof.abstract_factory.cars.Car;
import gof.abstract_factory.cars.Combi;
import gof.abstract_factory.cars.SUV;
import gof.abstract_factory.cars.Sedan;

public class FiatFactory extends CarFactory {

    @Override
    public Combi combi() {
        Combi combi = fiat(new Combi());
        combi.setKM("140 KM");
        combi.setVolume("1.8");
        combi.setPrice("50.000");
        combi.setName("Fiat Kombi");
        return combi;
    }

    @Override
    public SUV suv() {
        SUV suv = fiat(new SUV());
        suv.setKM("180 KM");
        suv.setVolume("2.0");
        suv.setPrice("80.000");
        suv.setName("Fiat SUV");
        return suv;
    }

    @Override
    public Sedan sedan() {
        Sedan sedan = fiat(new Sedan());
        sedan.setKM("130 KM");
        sedan.setVolume("1.4");
        sedan.setPrice("40.000");
        sedan.setName("Fiat Sedan");

//        Sedan sedan2 = (Sedan) fiat2(new Sedan());

        return sedan;
    }

    private <T extends Car> T fiat(T car) {
        car.setMade("Fiat");
        return car;
    }

//    private Car fiat2(Car car) {
//        car.setMade("Fiat");
//        return car;
//    }
}
