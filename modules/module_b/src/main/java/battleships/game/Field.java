package battleships.game;

import battleships.ships.Ship;

import java.util.Objects;

public class Field {

    private final int col;
    private final char row;
    private Ship ship;

    public Field(char row, int col) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public char getRow() {
        return row;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Ship getShip() {
        return this.ship;
    }

    public boolean isEmpty() {
        return ship == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return col == field.col &&
                row == field.row;
    }

    @Override
    public int hashCode() {

        return Objects.hash(col, row);
    }
}