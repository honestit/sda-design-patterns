package gof.builder.simple;

import gof.builder.City;
import gof.builder.Country;

public class CityBuilder {

    private City city = new City();

    public CityBuilder name(String name) {
        city.setName(name);
        return this;
    }

    public CityBuilder population(Long population) {
        city.setPopulation(population);
        return this;
    }

    public CityBuilder country(Country country) {
        city.setCountry(country);
        return this;
    }

    public City build() {
        if (city.getName() == null) {
            throw new IllegalStateException("Nie ustawiono pola lub pól `name` oraz `country`");
        }
        return city;
    }
}
