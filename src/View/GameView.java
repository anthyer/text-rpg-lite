package View;

import java.util.Scanner;

public class GameView {
    private Scanner scanner;

    public GameView() {
        scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public void showCharacterStatus(String name, int health) {
        System.out.println("\n" + name + " - Saúde atual: " + health);
    }

    public void showEnemyStatus(String name, int health) {
        System.out.println(name + " - Saúde atual: " + health);
    }

    public String namePlayer() {
        System.out.println("Digite o nome do seu herói:");
        return getInput();
    }

    public void playerStats(String name, int maxHealth, int armorClass, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        showMessage("\nNome do paladino: " + name);
        showMessage("\nVida máxima: " + maxHealth);
        showMessage("Classe de armadura: " + armorClass);
        showMessage("\n-Estatísticas\n");
        showMessage("Força: " + strength + " (" + Utils.Modifiers.GetModifier(strength) + ")");
        showMessage("Destreza: " + dexterity + " (" + Utils.Modifiers.GetModifier(dexterity) + ")");
        showMessage("Constituição: " + constitution + " (" + Utils.Modifiers.GetModifier(constitution) + ")");
        showMessage("Inteligência: " + intelligence + " (" + Utils.Modifiers.GetModifier(intelligence) + ")");
        showMessage("Sabedoria: " + wisdom + " (" + Utils.Modifiers.GetModifier(wisdom) + ")");
        showMessage("Carisma: " + charisma + " (" + Utils.Modifiers.GetModifier(charisma) + ")");
    }
}