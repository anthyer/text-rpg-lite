package Control;

import Model.GameState;
import View.GameView;

// Classe que dita o fluxo do jogo/combate
public class GameController {
    private GameState gameState;
    private GameView gameView;

    // Construto do GameController
    public GameController(GameState gameState, GameView gameView) {
        this.gameState = gameState;
        this.gameView = gameView;
    }

    // Função para iniciar o jogo
    public void startGame() {
        // Mostrar as mensagens iniciais
        gameView.showMessage("\n" + gameState.getPlayer().getName() + " se depara com um " + gameState.getCurrentEnemy().getName() + " em seu caminho, e por mais que tente, não consegue evitar a batalha.");
        gameView.showMessage("\nEscreva 'atacar' para enfrentar o inimigo ou 'sair' para finalizar.");

        // Loop que mantém o combate ativo até alguém morrer ou jogador digitar sair
        while (true) {
            // Mostrar a vida atual do jogador e do inimigo
            gameView.showCharacterStatus(
                    gameState.getPlayer().getName(),
                    gameState.getPlayer().getHealth()
            );
            gameView.showEnemyStatus(
                    gameState.getCurrentEnemy().getName(),
                    gameState.getCurrentEnemy().getHealth()
            );

            // Solicitar o input do jogador
            gameView.showMessage("Escreva sua ação:");
            String input = gameView.getInput();

            // Realizar ação escolhida pelo jogador ou sair do jogo
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