package Model;

public class Paladin {
    private String name;
    private int health;
    private int armorClass;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int attackBonus;


    public Paladin(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.strength = strength + 2;
        this.dexterity = dexterity;
        this.constitution = constitution + 2;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.health = 20 + Utils.Modifiers.GetModifier(this.constitution);
        this.armorClass = 10 + Utils.Modifiers.GetModifier(this.dexterity) + 6;
        this.attackBonus = 2;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() { return strength; }

    public int getDexterity() { return dexterity; }

    public int getConstitution() { return constitution; }

    public int getIntelligence() { return intelligence; }

    public int getWisdom() { return wisdom; }

    public int getCharisma() { return charisma; }

    public int getArmorClass() { return armorClass; }

    public int getAttackBonus() { return attackBonus; }

    public int attack() {
        return Utils.DiceRoller.rollDice(1, 8) + Utils.Modifiers.GetModifier(this.strength);
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