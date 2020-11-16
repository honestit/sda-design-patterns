package gof.factory_method;

public class FactoryMethodApp {

    public static void main(String[] args) {

        Trainee janNowak = new Trainee("Jan", "Nowak");
        Trainee zosiaWojt = new Trainee("Zosia", "Wójt");

        Manager lukasz = new Manager();
        lukasz.setFirstName("Lukasz");
        lukasz.setLastName("Kowalski");

        janNowak.setManager(lukasz);
        zosiaWojt.setManager(lukasz);

        Coach coach = new Coach();
        coach.setFirstName("Michał");
        coach.setLastName("K.");
        coach.setYearOfExperience(10);

        Coach coach2 = new Coach();
        coach.setFirstName("Kuba");
        coach.setLastName("Z.");
        coach.setYearOfExperience(5);



    }
}
