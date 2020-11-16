package battleships.ships;

public class Ship {

    private final int size;
    private int life;
    private final String name;

    public Ship(int size, String name) {
        this.size = size;
        this.life = size;
        this.name = name;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDestroied() {
        return life <= 0;
    }

    public boolean hit() {
        if (isDestroied()) {
            life--;
        }
        return isDestroied();
    }
}