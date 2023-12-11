simport java.util.Scanner;

class NumberGenerator {
    public int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberGenerator numberGenerator = new NumberGenerator();
        int totalAttempts = 0;
        int wins = 0;

        while (true) {
            System.out.println("====================================");
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("====================================");
            System.out.println("Enter the maximum number:");
            int max = scanner.nextInt();
            System.out.println("Enter the minimum number:");
            int min = scanner.nextInt();
            scanner.nextLine();

            int secretNumber = numberGenerator.generateRandomNumber(min, max);
            int attempts = 0;

            while (true) {
                System.out.println("Guess a number between " + min + " and " + max);
                int guessedNumber = scanner.nextInt();
                attempts++;

                if (guessedNumber > secretNumber) {
                    System.out.println("Your guess is higher. Try again");
                } else if (guessedNumber < secretNumber) {
                    System.out.println("Your guess is lower. Try again");
                } else {
                    System.out.println("Congratulations! You guessed the correct number");
                    wins++;
                    break;
                }
            }

            totalAttempts += attempts;
            System.out.println("Attempts = " + attempts);
            System.out.println("Wins = " + wins);

            double winRate = (double) wins / totalAttempts * 100;
            System.out.printf("Your win rate is %.2f%%\n", winRate);

            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                scanner.close();
                System.exit(0);
            }
            scanner.nextLine();
        }
    }
}