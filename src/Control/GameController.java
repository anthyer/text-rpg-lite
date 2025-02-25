package Control;

import Model.GameState;
import View.GameView;

public class GameController {
    private GameState gameState;
    private GameView gameView;

    public GameController(GameState gameState, GameView gameView) {
        this.gameState = gameState;
        this.gameView = gameView;
    }

    public void startGame() {
        gameView.showMessage("Welcome to Text RPG Lite!");
        gameView.showMessage("Type 'attack' to fight the enemy or 'quit' to exit.");

        while (true) {
            gameView.showCharacterStatus(
                    gameState.getPlayer().getName(),
                    gameState.getPlayer().getHealth()
            );
            gameView.showEnemyStatus(
                    gameState.getCurrentEnemy().getName(),
                    gameState.getCurrentEnemy().getHealth()
            );

            String input = gameView.getInput();

            if ("attack".equalsIgnoreCase(input)) {
                gameState.attackEnemy();
                if (!gameState.getCurrentEnemy().isAlive()) {
                    gameView.showMessage("You defeated the enemy!");
                    break;
                }
                if (!gameState.getPlayer().isAlive()) {
                    gameView.showMessage("You were defeated... Game Over!");
                    break;
                }
            } else if ("quit".equalsIgnoreCase(input)) {
                gameView.showMessage("Thanks for playing!");
                break;
            } else {
                gameView.showMessage("Invalid command. Try 'attack' or 'quit'.");
            }
        }
    }
}