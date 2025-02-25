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
        System.out.println(name + " - Health: " + health);
    }

    public void showEnemyStatus(String name, int health) {
        System.out.println("Enemy: " + name + " - Health: " + health);
    }

    public String namePlayer() {
        System.out.println("Digite o nome do seu herói:");
        return getInput();
    }
}