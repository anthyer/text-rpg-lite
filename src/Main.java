import Model.Paladin;
import Model.Enemy;
import Model.GameState;
import View.GameView;
import Control.GameController;
import Utils.DiceRoller;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        // Inicializa a View
        GameView gameView = new GameView();
        String playerName = gameView.namePlayer();

        // Inicializa o Model
        Paladin player = new Paladin(playerName, 100, 10, DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6));
        GameState gameState = new GameState(player);

        System.out.println("Nome do paladino: " + player.getName());
        System.out.println("Força: " + player.getStrength());
        System.out.println("Destreza: " + player.getDexterity());
        System.out.println("Constituição: " + player.getConstitution());
        System.out.println("Inteligência: " + player.getIntelligence());
        System.out.println("Sabedoria: " + player.getWisdom());
        System.out.println("Carisma: " + player.getCharisma());

        // Inicializa o Controller
        GameController gameController = new GameController(gameState, gameView);

        // Inicia o jogo
        gameController.startGame();
    }
}