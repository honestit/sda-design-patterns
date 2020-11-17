package gof.factory_method;

import gof.factory_method.factories.CoachFactory;
import gof.factory_method.factories.ManagerFactory;
import gof.factory_method.factories.TraineeFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FactoryMethodApp {

    public static void main(String[] args) {

        Manager lukasz = new Manager();
        lukasz.setFirstName("Lukasz");
        lukasz.setLastName("Kowalski");

        Trainee janNowak = new Trainee("Jan", "Nowak");
        Trainee zosiaWojt = new Trainee("Zosia", "Wójt");

        janNowak.setManager(lukasz);
        zosiaWojt.setManager(lukasz);

        Coach coach = new Coach();
        coach.setFirstName("Michał");
        coach.setLastName("K.");
        coach.setYearOfExperience(5);

        Coach coach2 = new Coach();
        coach.setFirstName("Kuba");
        coach.setLastName("Z.");
        coach.setYearOfExperience(2);

        System.out.println(coach2);

        Manager lukaszG = ManagerFactory.manager("Lukasz", "G.");
        Coach regular = CoachFactory.regular("Kuba", "Z.");
        Coach senior = CoachFactory.senior("Michał", "K.");

        Trainee trainee1 = TraineeFactory.withManager("Jan", "Nowak", lukaszG);
        Trainee trainee2 = TraineeFactory.withManager("Zosia", "Wójt", lukaszG);

        System.out.println(CoachFactory.senior("Michał", "K."));

        List.of();
        List<String> list = List.of("1", "2");
    }
}
