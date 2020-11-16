package battleships.game;

import battleships.ships.Ship;

public class Board {

    private final Field[][] fields;
    private static final int SIZE = 10;

    public Board() {
        this.fields = new Field[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                fields[i][j] = new Field((char) ('A' + i), j + 1);
            }
        }
    }

    public Field[][] getFields() {
        return fields;
    }

    public void setShip(Ship ship, char row, int col) {
        if (col < 1 || col > 10) throw new IllegalArgumentException("Niepoprawny numer kolumny: " + col);
        if (Character.isLowerCase(row)) {
            row = Character.toUpperCase(row);
        }
        if (row < 'A' || row > ('A' + 9)) throw new IllegalArgumentException("Niepoprawny numer wiersza: " + row);
        fields[row - 'A'][col - 1].setShip(ship);
    }
}
