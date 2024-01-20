import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    int roundScore = calculateScore(maxAttempts, attempts);
                    totalScore += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else {
                    System.out.println("Incorrect guess. Try again.");

                    if (userGuess < targetNumber) {
                        System.out.println("The target number is higher.");
                    } else {
                        System.out.println("The target number is lower.");
                    }
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Game Over. Your Total Score: " + totalScore);
        scanner.close();
    }

    private static int calculateScore(int maxAttempts, int attempts) {
        int baseScore = 100;
        int penalty = 10;
        int maxScore = baseScore * maxAttempts;

        return maxScore - ((attempts - 1) * penalty);
    }
}
