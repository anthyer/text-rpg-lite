package Model;

import View.GameView;

public class GameState {
    private Paladin player;
    private Enemy currentEnemy;
    GameView gameView = new GameView();

    public GameState(Paladin player) {
        this.player = player;
        this.currentEnemy = new Enemy("Bugbear", 15, 18, 3); // Exemplo de inimigo
    }

    public Paladin getPlayer() {
        return player;
    }

    public Enemy getCurrentEnemy() {
        return currentEnemy;
    }

    public int attackRoll(int strength, int attackBonus) {
        return Utils.DiceRoller.rollDice(1, 20) + Utils.Modifiers.GetModifier(strength) + attackBonus;
    }

    public void attackEnemy() {
        int attackRoll = attackRoll(player.getStrength(), player.getAttackBonus());
        int damage;

        if (attackRoll > currentEnemy.getArmorClass()) {
            if (attackRoll >= 999)
            {
                damage = 3 * (player.attack());

                gameView.showMessage("\nAcerto crítico!!!");
                gameView.showMessage("Boom!!! " + player.getName() + " causa " + damage + " de dano!");
                currentEnemy.takeDamage(damage);
            } else {
                damage = player.attack();

                gameView.showMessage("\n" + player.getName() + " acerta e causa " + damage + " de dano!");
                currentEnemy.takeDamage(damage);
            }
        } else {
            gameView.showMessage("\n" + player.getName() + " erra o ataque.");
        }

        attackPlayer();
    }

    public void attackPlayer() {
        int attackRoll = attackRoll(16, currentEnemy.getAttackBonus());
        int damage;

        if (currentEnemy.isAlive() && attackRoll > player.getArmorClass() ) {
            if (attackRoll >= 999) {
                damage = 3 * (currentEnemy.attack());

                gameView.showMessage("Acerto crítico!!!");
                gameView.showMessage("Bang!!! " + currentEnemy.getName() + " causa " + damage + " de dano!");
                player.takeDamage(damage);
            } else {
                damage = currentEnemy.attack();

                gameView.showMessage(currentEnemy.getName() + " acerta e causa " + damage + " de dano!");
                player.takeDamage(damage);
            }
        } else if (currentEnemy.isAlive()) {
            gameView.showMessage(currentEnemy.getName() + " erra o ataque.");
        }
    }
}