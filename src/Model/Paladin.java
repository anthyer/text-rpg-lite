package Model;

// Essa classe define as características do personagem jogável
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

    // Construto do personagem, contendo todas as suas características
    public Paladin(String name, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.strength = strength + 2; // A soma de 2 se dá pela classe do paladino
        this.dexterity = dexterity;
        this.constitution = constitution + 2; // A soma de 2 se dá pela classe do paladino
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.health = 20 + Utils.Modifiers.GetModifier(this.constitution); // A vida leva em consideração sua constituição somada a 20
        this.armorClass = 10 + Utils.Modifiers.GetModifier(this.dexterity) + 6; // A classe de armadura leva em consideração sua destreza somada a 10
        this.attackBonus = 2; // Bônus base de ataque pré-definido
    }

    // Getters
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

    // Função que retorna o dano de um ataque bem-sucedido, 1d8 + modificador de força
    public int attack() {
        return Utils.DiceRoller.rollDice(1, 8) + Utils.Modifiers.GetModifier(this.strength);
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