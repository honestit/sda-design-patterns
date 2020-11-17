package gof.factory_method.factories;

import gof.factory_method.Manager;
import gof.factory_method.Trainee;

public class TraineeFactory {

    public static Trainee withManager(String firstName, String lastName, Manager manager) {
        Trainee trainee = new Trainee(firstName, lastName);
        trainee.setManager(manager);
        return trainee;
    }

    public static Trainee trainee(String firstName, String lastName) {
        Trainee trainee = new Trainee(firstName, lastName);
        return trainee;
    }
}
