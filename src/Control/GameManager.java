package Control;
import java.util.Scanner;

public class GameManager {
    private Scanner scanner;

    public GameManager() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.GameMenu();

        gameManager.scanner.close();
    }

    public void GameMenu() {
        System.out.println("Text RPG Lite\n\nEscreva 'inicar' para começar...");
        String input = scanner.next();
        boolean start = input.equals("start");

        while (!start) {
            System.out.println("Comando inválido, escreva 'iniciar' para começar.");
            input = scanner.next();
            start = input.equals("iniciar");
        }

        System.out.println("O jogo começou!");
    }
}