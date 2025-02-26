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
        gameView.showMessage("\n" + gameState.getPlayer().getName() + " se depara com um " + gameState.getCurrentEnemy().getName() + " em seu caminho, e por mais que tente, não consegue evitar a batalha.");
        gameView.showMessage("\nEscreva 'atacar' para enfrentar o inimigo ou 'sair' para finalizar.");

        while (true) {
            gameView.showCharacterStatus(
                    gameState.getPlayer().getName(),
                    gameState.getPlayer().getHealth()
            );
            gameView.showEnemyStatus(
                    gameState.getCurrentEnemy().getName(),
                    gameState.getCurrentEnemy().getHealth()
            );

            gameView.showMessage("Escreva sua ação:");
            String input = gameView.getInput();

            if ("atacar".equalsIgnoreCase(input)) {
                gameState.attackEnemy();
                if (!gameState.getCurrentEnemy().isAlive()) {
                    gameView.showMessage("\nVocê derrotou o inimigo, parabéns!\n\nObrigado por jogar!");
                    break;
                }
                if (!gameState.getPlayer().isAlive()) {
                    gameView.showMessage("\nVocê foi derrotado... Fim de jogo!");
                    break;
                }
            } else if ("sair".equalsIgnoreCase(input)) {
                gameView.showMessage("\nObrigado por jogar!");
                break;
            } else {
                gameView.showMessage("\nComando inválido. Tente 'atacar' ou 'sair'.");
            }
        }
    }
}