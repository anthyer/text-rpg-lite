package Model;

public class Enemy {
    private String name;
    private int health;
    private int armorClass;
    private int attackBonus;

    public Enemy(String name, int health, int armorClass, int attackBonus) {
        this.name = name;
        this.health = health;
        this.armorClass = armorClass;
        this.attackBonus = attackBonus;
    }

    // Getters e Setters
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

    public int attack() {
        return Utils.DiceRoller.rollDice(1, 8) + 4;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}