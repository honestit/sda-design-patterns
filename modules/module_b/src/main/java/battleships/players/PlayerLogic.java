package battleships.players;

import battleships.game.Board;
import battleships.game.Field;
import battleships.game.ShootResult;

public interface PlayerLogic {

    Field salvo();

    ShootResult callOut(Field field);

    default void use(ShootResult result, Field field) {}

    Board prepareBoard();
}
