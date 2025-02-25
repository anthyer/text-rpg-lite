package Model;

public class GameState {
    private Paladin player;
    private Enemy currentEnemy;

    public GameState(Paladin player) {
        this.player = player;
        this.currentEnemy = new Enemy("Goblin", 30, 5); // Exemplo de inimigo
    }

    public Paladin getPlayer() {
        return player;
    }

    public Enemy getCurrentEnemy() {
        return currentEnemy;
    }

    public void attackEnemy() {
        currentEnemy.takeDamage(player.getAttack());
        if (currentEnemy.isAlive()) {
            player.takeDamage(currentEnemy.getAttack());
        }
    }
}