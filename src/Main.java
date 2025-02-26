import Model.Paladin;
import Model.GameState;
import View.GameView;
import Control.GameController;
import Utils.DiceRoller;

// Essa classe inicia o game e sua lógica inicial
public class Main {
    public static void main(String[] args) {
        // Inicializa a View
        GameView gameView = new GameView();

        // Mostra a mensagem de boas vindas e pede pelo nome do paladino
        gameView.showMessage("Bem vindx ao Text RPG Lite!");
        String playerName = gameView.namePlayer();

        // Inicializa o Model, criando o personagem jogável com base na rolagem de 3d6 para cada atributo base
        Paladin player = new Paladin(playerName, DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6), DiceRoller.rollDice(3, 6));
        GameState gameState = new GameState(player);

        // Envia o comando para o GameView mostrar as estatísticas do jogador
        gameView.playerStats(playerName, player.getHealth(), player.getArmorClass(), player.getStrength(), player.getDexterity(), player.getConstitution(), player.getIntelligence(), player.getWisdom(), player.getCharisma());

        // Inicializa o Controller
        GameController gameController = new GameController(gameState, gameView);

        // Inicia o jogo
        gameController.startGame();
    }
}