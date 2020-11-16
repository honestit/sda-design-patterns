package gof.abstract_factory.factories;

import gof.abstract_factory.cars.Car;
import gof.abstract_factory.cars.Combi;
import gof.abstract_factory.cars.SUV;
import gof.abstract_factory.cars.Sedan;

public class SkodaFactory extends CarFactory {

    @Override
    public Combi combi() {
        Combi combi = skoda(new Combi());
        combi.setKM("180 KM");
        combi.setVolume("1.8");
        combi.setPrice("75.000");
        combi.setName("Octavia III Kombi");
        return combi;
    }

    @Override
    public SUV suv() {
        SUV suv = skoda(new SUV());
        suv.setKM("210 KM");
        suv.setVolume("2.0");
        suv.setPrice("110.000");
        suv.setName("Karoq");
        return suv;
    }

    @Override
    public Sedan sedan() {
        Sedan sedan = skoda(new Sedan());
        sedan.setKM("150 KM");
        sedan.setVolume("1.5");
        sedan.setPrice("70.000");
        sedan.setName("Octavia III");
        return sedan;
    }

    private <T extends Car> T skoda(T car) {
        car.setMade("Skoda");
        return car;
    }
}
