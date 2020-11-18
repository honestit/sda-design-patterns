package gof.abstract_factory;

import gof.abstract_factory.cars.Car;
import gof.abstract_factory.cars.Combi;
import gof.abstract_factory.cars.SUV;
import gof.abstract_factory.cars.Sedan;

public class AbstractFactoryApp {

    public static void main(String[] args) {
        Car car1 = new Combi();
        car1.setKM("180 KM");
        car1.setVolume("1.8");
        car1.setMade("Fiat");
        car1.setPrice("500000,00");
        car1.setName("Fiat Combi");

        Car car2 = new SUV();
        car2.setKM("180 KM");
        car2.setVolume("2.0");
        car2.setMade("Fiat");
        car2.setPrice("800000,00");
        car2.setName("Fiat SUV");

        Car car3 = new Sedan();
        car3.setKM("130 KM");
        car3.setVolume("1.4");
        car3.setMade("Fiat");
        car3.setPrice("400000,00");
        car3.setName("Fiat Sedan");
    }
}
