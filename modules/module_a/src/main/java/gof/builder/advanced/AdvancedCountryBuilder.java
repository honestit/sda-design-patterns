package gof.builder.advanced;

import gof.builder.City;
import gof.builder.Country;

import java.util.LinkedList;

public class AdvancedCountryBuilder {

    private Country country = new Country();

    public AdvancedCountryBuilder name(String name) {
        country.setName(name);
        return this;
    }

    public AdvancedCountryBuilder population(Long population) {
        country.setPopulation(population);
        return this;
    }

    public AdvancedCityBuilder city() {
        AdvancedCityBuilder cityBuilder = new AdvancedCityBuilder(this);
        cityBuilder.country(country);
        return cityBuilder;
    }

    public AdvancedCountryBuilder city(City city) {
        if (country.getCities() == null) {
            country.setCities(new LinkedList<>());
        }
        country.getCities().add(city);
        return this;
    }

    public AdvancedCountryBuilder capital(City capital) {
        country.setCapital(capital);
        return this;
    }

    public Country build() {
        if (country.getName() == null) {
            throw new IllegalStateException("Pole `name` musi być ustawione");
        }
        return country;
    }




}
