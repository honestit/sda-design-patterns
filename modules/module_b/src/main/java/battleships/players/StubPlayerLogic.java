package battleships.players;

import battleships.game.Board;
import battleships.game.Field;
import battleships.game.ShootResult;

public class StubPlayerLogic implements PlayerLogic {
    @Override
    public Field salvo() {
        return null;
    }

    @Override
    public ShootResult callOut(Field field) {
        return null;
    }

    @Override
    public Board prepareBoard() {
        return new Board();
    }
}
