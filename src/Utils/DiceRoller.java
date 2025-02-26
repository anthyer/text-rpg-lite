package Utils;

import java.util.Random;

public class DiceRoller {
    private static final Random random = new Random();

    // Função para rolar dados
    public static int rollDice(int numberOfDice, int numberOfFaces) {
        int total = 0;
        for (int i = 0; i < numberOfDice; i++) {
            // Gera um número aleatório entre 1 e numberOfFaces
            int roll = random.nextInt(numberOfFaces) + 1;
            if (numberOfDice == 1 && numberOfFaces == 20 && roll == 20) {
                return 999;
            }
            total += roll;
        }
        return total;
    }
}