package gof.factory_method.factories;

import gof.factory_method.Manager;

public class ManagerFactory {

    public static Manager manager(String firstName, String lastName) {
        Manager manager = new Manager();
        manager.setFirstName(firstName);
        manager.setLastName(lastName);
        return manager;
    }
}
