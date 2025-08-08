import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1; // Random number between 1–100
        int guess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have 7 chances to guess it.");

        for (int attempt = 1; attempt <= 7; attempt++) {
            System.out.print("Attempt " + attempt + " - Enter your guess: ");
            guess = input.nextInt();

            if (guess == numberToGuess) {
                System.out.println("Correct! You guessed it in " + attempt + " attempt(s).");
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            if (attempt == 7) {
                System.out.println("You've used all attempts! The correct number was: " + numberToGuess);
            }
        }

        input.close();
    }
}
