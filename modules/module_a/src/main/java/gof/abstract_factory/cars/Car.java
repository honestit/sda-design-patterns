package gof.abstract_factory.cars;

public class Car {

    private String name;
    private String made;
    private String KM;
    private String price;
    private String volume;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public String getKM() {
        return KM;
    }

    public void setKM(String KM) {
        this.KM = KM;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", made='" + made + '\'' +
                ", KM='" + KM + '\'' +
                ", price='" + price + '\'' +
                ", volume='" + volume + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
