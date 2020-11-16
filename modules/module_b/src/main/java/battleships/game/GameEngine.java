package battleships.game;

import battleships.players.Player;

public class GameEngine {

    private Player playerOne;
    private Player playerTwo;
    private GameResult gameResult = GameResult.NOT_FINISHED_YET;

    public void prepareGame(Player p1, Player p2) {
        gameResult = GameResult.NOT_FINISHED_YET;
        this.playerOne = p1;
        this.playerTwo = p2;
    }

    public void prepareBoards() {
        playerOne.prepareBoard();
        playerTwo.prepareBoard();
    }

    public void startGame() {
        while (true) {
            Field field = playerOne.salvo();
            ShootResult shootResult = playerTwo.callOut(field);
            playerOne.use(shootResult, field);

            field = playerTwo.salvo();
            shootResult  = playerOne.callOut(field);
            playerTwo.use(shootResult, field);

            if (checkIfFirstPlayerWon()) {
                gameResult = GameResult.FIRST_PLAYER_WON;
                return;
            }
            else if (checkIfSecondPlayerWon()) {
                gameResult = GameResult.SECOND_PLAYER_WON;
                return;
            }
            else if(checkIfItsDraw()) {
                gameResult = GameResult.DRAW;
                return;
            }
        }
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    private boolean checkIfItsDraw() {
        return !playerOne.hasMoreShips() && !playerTwo.hasMoreShips();
    }

    private boolean checkIfSecondPlayerWon() {
        return !playerOne.hasMoreShips() && playerTwo.hasMoreShips();
    }

    private boolean checkIfFirstPlayerWon() {
        return playerOne.hasMoreShips() && !playerTwo.hasMoreShips();
    }
}