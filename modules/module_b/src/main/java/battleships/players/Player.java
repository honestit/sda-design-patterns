package battleships.players;

import battleships.game.Board;
import battleships.game.Field;
import battleships.game.ShootResult;

public class Player {

    private String name;
    private Board board;
    protected PlayerLogic logic;

    public Player(PlayerLogic logic) {
        this.logic = logic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return this.board;
    }

    public Field salvo() {
        return logic.salvo();
    }

    public ShootResult callOut(Field field) {
        return logic.callOut(field);
    }

    public void use(ShootResult result, Field field) {
        logic.use(result, field);
    }

    public void prepareBoard() {
        this.board = logic.prepareBoard();
    }

    public boolean hasMoreShips() {
        // Implementacja powinna zostać uzupełniona na poziomie tej klasy
        return false;
    }
}
