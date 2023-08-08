package src.game;

import src.thread.GameController;

public class OldMaidGame implements Game {
    private final GameController gameController;
    public OldMaidGame(int numPlayers) {
        gameController = new GameController(numPlayers);
    }
    @Override
    public void start() {
        gameController.startGame();
    }
    @Override
    public void end() {
        System.out.println("Game Over!");
    }

}
