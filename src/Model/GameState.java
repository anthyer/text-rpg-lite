package Model;

import View.GameView;

// Essa classe define o fluxo de jogo, mantendo salvas as características dos personagens
public class GameState {
    private Paladin player;
    private Enemy currentEnemy;
    GameView gameView = new GameView();

    // Construto do GameState
    public GameState(Paladin player) {
        this.player = player;
        this.currentEnemy = new Enemy("Bugbear", 15, 18, 3); // Exemplo de inimigo
    }

    // Função que retorna o estado do jogador atual
    public Paladin getPlayer() {
        return player;
    }

    // Função que retorna o estado do inimigo atual
    public Enemy getCurrentEnemy() {
        return currentEnemy;
    }

    // Função que define a jogada de ataque, 1d20 + Modificador de Força + Bônus Base de Ataque
    public int attackRoll(int strength, int attackBonus) {
        return Utils.DiceRoller.rollDice(1, 20) + Utils.Modifiers.GetModifier(strength) + attackBonus;
    }

    // Função que define o ataque ao inimigo, bem como se o ataque foi bem-sucedido ou não
    public void attackEnemy() {
        int attackRoll = attackRoll(player.getStrength(), player.getAttackBonus());
        int damage;

        // Se a jogada de ataque supera a classe de armadura do inimigo
        if (attackRoll > currentEnemy.getArmorClass()) {
            if (attackRoll >= 999) // Caso acerto crítico
            {
                damage = 3 * (player.attack()); // Multiplica o dano por 3

                gameView.showMessage("\nAcerto crítico!!!");
                gameView.showMessage("Boom!!! " + player.getName() + " causa " + damage + " de dano!");
                currentEnemy.takeDamage(damage); // Chama a função que diminui a vida do inimigo
            } else {
                damage = player.attack();

                gameView.showMessage("\n" + player.getName() + " acerta e causa " + damage + " de dano!");
                currentEnemy.takeDamage(damage); // Chama a função que diminui a vida do inimigo
            }
        } else {
            gameView.showMessage("\n" + player.getName() + " erra o ataque."); // Errou o ataque
        }

        attackPlayer(); // Agora é chamado o turno do oponente
    }

    // Função que define o ataque ao jogador
    public void attackPlayer() {
        int attackRoll = attackRoll(16, currentEnemy.getAttackBonus());
        int damage;

        // Se a jogada de ataque supera a classe de armadura do jogador
        if (currentEnemy.isAlive() && attackRoll > player.getArmorClass() ) {
            if (attackRoll >= 999) {
                damage = 3 * (currentEnemy.attack()); // Multiplica o dano por 3

                gameView.showMessage("Acerto crítico!!!");
                gameView.showMessage("Bang!!! " + currentEnemy.getName() + " causa " + damage + " de dano!");
                player.takeDamage(damage); // Chama a função que diminui a vida do jogador
            } else {
                damage = currentEnemy.attack();

                gameView.showMessage(currentEnemy.getName() + " acerta e causa " + damage + " de dano!");
                player.takeDamage(damage); // Chama a função que diminui a vida do jogador
            }
        } else if (currentEnemy.isAlive()) {
            gameView.showMessage(currentEnemy.getName() + " erra o ataque."); // Errou o ataque
        }
    }
}