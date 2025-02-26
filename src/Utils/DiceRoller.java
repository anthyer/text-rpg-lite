package Utils;

import java.util.Random;

// Essa classe faz a rolagem de dados, com base na aleatoriedade
public class DiceRoller {
    private static final Random random = new Random();

    // Função para rolar dados, recebe o número de dados a serem rolados e o número de faces dos dados a serem rolados
    public static int rollDice(int numberOfDice, int numberOfFaces) {
        int total = 0;
        for (int i = 0; i < numberOfDice; i++) {
            // Gera um número aleatório entre 1 e o número de faces
            int roll = random.nextInt(numberOfFaces) + 1;
            // Se for um acerto crítico o retorno será 999 (acerto crítico é apenas para o d20)
            if (numberOfDice == 1 && numberOfFaces == 20 && roll == 20) {
                return 999;
            }
            total += roll;
        }
        return total;
    }
}