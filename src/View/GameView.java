package View;

import java.util.Scanner;

// Essa classe é responsável pela interface gráfica do jogo
public class GameView {
    private Scanner scanner; // Cria o objeto Scanner

    // Construto do GameView
    public GameView() {
        scanner = new Scanner(System.in);
    }

    // Função para mostrar uma mensagem qualquer
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Função para leitura do comando do jogador
    public String getInput() {
        return scanner.nextLine();
    }

    // Função para mostrar a vida do personagem do jogador
    public void showCharacterStatus(String name, int health) {
        System.out.println("\n" + name + " - Saúde atual: " + health);
    }

    // Função para mostrar a vida do inimigo
    public void showEnemyStatus(String name, int health) {
        System.out.println(name + " - Saúde atual: " + health);
    }

    // Função para pedir ao jogador inserir o nome do paladino
    public String namePlayer() {
        System.out.println("Digite o nome do seu herói:");
        return getInput();
    }

    // Função para mostrar as características do personagem criado
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