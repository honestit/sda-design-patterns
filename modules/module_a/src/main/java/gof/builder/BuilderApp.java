package gof.builder;

import java.util.ArrayList;

public class BuilderApp {

    public static void main(String[] args) {

        Country poland = new Country();
        poland.setName("Polska");
        poland.setPopulation(38_000_000L);

        City warsaw = new City();
        warsaw.setName("Warszawa");
        warsaw.setPopulation(1_600_000L);

        warsaw.setCountry(poland);
        poland.setCapital(warsaw);
        poland.setCities(new ArrayList<>());
        poland.getCities().add(warsaw);

        City wroclaw = new City();
        wroclaw.setName("Wrocław");
        wroclaw.setPopulation(650_000L);

        poland.getCities().add(wroclaw);

    }
}
