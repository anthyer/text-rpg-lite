import Model.Paladin;
import Model.GameState;
import View.GameView;
import Control.GameController;
import Utils.DiceRoller;

public class Main {
    public static void main(String[] args) {
        // Inicializa a View
        GameView gameView = new GameView();

        gameView.showMessage("Bem vindx ao Text RPG Lite!");
        String playerName = gameView.namePlayer();

        // Inicializa o Model
        Paladin player = new Paladin(playerName, DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6));
        GameState gameState = new GameState(player);

        gameView.playerStats(playerName, player.getHealth(), player.getArmorClass(), player.getStrength(), player.getDexterity(), player.getConstitution(), player.getIntelligence(), player.getWisdom(), player.getCharisma());

        // Inicializa o Controller
        GameController gameController = new GameController(gameState, gameView);

        // Inicia o jogo
        gameController.startGame();
    }
}