package gof.builder;

import gof.builder.simple.CityBuilder;
import gof.builder.simple.CountryBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class BuilderApp {

    public static void main(String[] args) {

        {
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

//        CountryBuilder countryBuilder = new CountryBuilder();
//        countryBuilder = countryBuilder.name("Polska");

        City warsaw = new CityBuilder()
                .name("Warszawa")
                .population(1_600_000L)
                .build();

        City wroclaw = new CityBuilder().name("Wrocław").population(650_000L).build();

        Country poland = new CountryBuilder()
                .name("Polska").population(38_000_000L)
                .city(warsaw)
                .city(wroclaw)
                .capital(warsaw)
                .build();

        System.out.println(poland);

    }
}
