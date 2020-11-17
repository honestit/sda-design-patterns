package gof.factory_method.factories;

import gof.factory_method.Coach;

public class CoachFactory {

    public static Coach coach(String firstName, String lastName) {
        Coach coach = new Coach();
        coach.setFirstName(firstName);
        coach.setLastName(lastName);
        return coach;
    }

    public static Coach regular(String firstName, String lastName) {
        Coach coach = CoachFactory.coach(firstName, lastName);
        coach.setYearOfExperience(3);
        return coach;
    }

    public static Coach senior(String firstName, String lastName) {
        Coach coach = CoachFactory.coach(firstName, lastName);
        coach.setYearOfExperience(6);
        return coach;
    }
}
