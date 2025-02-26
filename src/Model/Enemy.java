package Model;

// Essa classe define as características do inimigo
public class Enemy {
    private String name;
    private int health;
    private int armorClass;
    private int attackBonus;

    // Construto do inimigo
    public Enemy(String name, int health, int armorClass, int attackBonus) {
        this.name = name;
        this.health = health;
        this.armorClass = armorClass;
        this.attackBonus = attackBonus;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    // Função que retorna o dano de um ataque bem-sucedido, 1d8 + 4
    public int attack() {
        return Utils.DiceRoller.rollDice(1, 8) + 4;
    }

    // Função para o recebimento de dano, diminuindo a vida com base no dano recebido
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    // Função que retorna um booleano com base na vida do personagem, indicando se esse está vivo ou não
    public boolean isAlive() {
        return health > 0;
    }
}