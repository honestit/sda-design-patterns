package gof.builder.advanced;

import gof.builder.City;
import gof.builder.Country;

public class AdvancedCityBuilder  {

    private City city = new City();
    private AdvancedCountryBuilder countryBuilder;

    public AdvancedCityBuilder(AdvancedCountryBuilder countryBuilder) {
        this.countryBuilder = countryBuilder;
    }

    public AdvancedCityBuilder name(String name) {
        city.setName(name);
        return this;
    }

    public AdvancedCityBuilder population(Long population) {
        city.setPopulation(population);
        return this;
    }

    public AdvancedCityBuilder country(Country country) {
        city.setCountry(country);
        return this;
    }

    public City build() {
        if (city.getName() == null) {
            throw new IllegalStateException("Pole `name` musi być ustawione");
        }
        return city;
    }

    public AdvancedCountryBuilder asCity() {
        countryBuilder.city(this.build());
        return countryBuilder;
    }

    public AdvancedCountryBuilder asCapital() {
        countryBuilder.capital(this.build());
        return countryBuilder;
    }
}
