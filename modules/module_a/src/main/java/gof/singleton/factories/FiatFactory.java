package gof.singleton.factories;

import gof.singleton.cars.Car;
import gof.singleton.cars.Combi;
import gof.singleton.cars.SUV;
import gof.singleton.cars.Sedan;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FiatFactory extends CarFactory {

    public FiatFactory() {
        try (Scanner scanner = new Scanner(new File("gof/singleton/skoda.config"))) {
            combiPrototype = fiat(createCarFromConfig(new Combi(), scanner.nextLine()));
            TimeUnit.SECONDS.sleep(1);
            sedanPrototype = fiat(createCarFromConfig(new Sedan(), scanner.nextLine()));
            TimeUnit.SECONDS.sleep(1);
            suvPrototype = fiat(createCarFromConfig(new SUV(), scanner.nextLine()));
            TimeUnit.SECONDS.sleep(1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Combi combi() {
        Combi combi = fiat(new Combi());
        combi.setKM(combiPrototype.getKM());
        combi.setVolume(combiPrototype.getVolume());
        combi.setPrice(combiPrototype.getPrice());
        combi.setName(combiPrototype.getName());
        return combi;
    }

    @Override
    public SUV suv() {
        SUV suv = fiat(new SUV());
        suv.setKM(suvPrototype.getKM());
        suv.setVolume(suvPrototype.getVolume());
        suv.setPrice(suvPrototype.getPrice());
        suv.setName(suvPrototype.getName());
        return suv;
    }

    @Override
    public Sedan sedan() {
        Sedan sedan = fiat(new Sedan());
        sedan.setKM(sedanPrototype.getKM());
        sedan.setVolume(sedanPrototype.getVolume());
        sedan.setPrice(sedanPrototype.getPrice());
        sedan.setName(sedanPrototype.getName());
        return sedan;
    }

    private  <T extends Car> T fiat(T car) {
        car.setMade("Fiat");
        return car;
    }

    private  <T extends Car> T createCarFromConfig(T car, String conf) {
        String[] confValues = conf.split(";");
        car.setName(confValues[0]);
        car.setKM(confValues[1]);
        car.setVolume(confValues[2]);
        car.setPrice(confValues[3]);
        return car;
    }
}
