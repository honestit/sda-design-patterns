package gof.singleton;

import gof.singleton.cars.Car;
import gof.singleton.cars.Combi;
import gof.singleton.cars.SUV;
import gof.singleton.cars.Sedan;
import gof.singleton.factories.CarFactory;
import gof.singleton.factories.SkodaFactory;

public class SingletonApp {

    public static void main(String[] args) {
        Car car1 = new Combi();
        car1.setKM("180 KM");
        car1.setVolume("1.8");
        car1.setMade("Skoda");
        car1.setPrice("750000,00");
        car1.setName("Octavia III Combi");

        Car car2 = new SUV();
        car2.setKM("210 KM");
        car2.setVolume("2.0");
        car2.setMade("Skoda");
        car2.setPrice("1100000,00");
        car2.setName("Karoq");

        Car car3 = new Sedan();
        car3.setKM("150 KM");
        car3.setVolume("1.5");
        car3.setMade("Skoda");
        car3.setPrice("700000,00");
        car3.setName("Octavia III");

        SkodaFactory skodaFactory = new SkodaFactory();
        Car car4 = skodaFactory.combi();
        Car car5 = skodaFactory.suv();
        Car car6 = skodaFactory.sedan();

        Car car7 = CarFactory.getFactory(CarFactory.Made.SKODA).combi();
        Car car8 = CarFactory.getFactory(CarFactory.Made.SKODA).suv();
        Car car9 = CarFactory.getFactory(CarFactory.Made.SKODA).sedan();

        Car car10 = CarFactory.getDefaultFactory().combi();
        Car car11 = CarFactory.getDefaultFactory().suv();
        Car car12 = CarFactory.getDefaultFactory().sedan();

    }
}
