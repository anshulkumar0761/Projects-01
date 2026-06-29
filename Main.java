import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Create objects to read user input and generate random numbers
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Game variables
        int secretNumber = random.nextInt(100) + 1; // Random number between 1-100
        int userGuess = 0;
        int attempts = 0;
        boolean hasWon = false;

        // Display welcome message
        System.out.println("========================================");
        System.out.println("   Welcome to Number Guessing Game!");
        System.out.println("========================================");
        System.out.println("I'm thinking of a number between 1-100.");
        System.out.println("Can you guess it?\n");

        // Main game loop - continues until player wins
        while (!hasWon) {
            System.out.print("Enter your guess: ");

            // Input validation - check if user entered a valid number
            if (scanner.hasNextInt()) {
                userGuess = scanner.nextInt();
                attempts++;

                // Check if guess is in valid range
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100!\n");
                    continue;
                }

                // Compare guess with secret number
                if (userGuess == secretNumber) {
                    // Player won!
                    hasWon = true;
                    System.out.println("\n========================================");
                    System.out.println("🎉 Congratulations! You won!");
                    System.out.println("The number was: " + secretNumber);
                    System.out.println("Attempts taken: " + attempts);
                    System.out.println("========================================\n");

                    // Calculate and display performance
                    if (attempts <= 3) {
                        System.out.println("Wow! You're a master guesser! 🏆");
                    } else if (attempts <= 7) {
                        System.out.println("Great job! You guessed well! 👍");
                    } else {
                        System.out.println("Good try! Practice makes perfect! 💪");
                    }
                }
                // If guess is too low
                else if (userGuess < secretNumber) {
                    System.out.println("❌ Too low! Try a higher number.\n");
                }
                // If guess is too high
                else {
                    System.out.println("❌ Too high! Try a lower number.\n");
                }
            }
            // Handle invalid input (non-integer)
            else {
                System.out.println("⚠️ Invalid input! Please enter a valid number.\n");
                scanner.nextLine(); // Clear the invalid input from buffer
            }
        }

        // Offer to play again
        playAgain(scanner);

        // Close the scanner
        scanner.close();
    }

    // Method to ask if player wants to play again
    public static void playAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();

        // Simple loop to handle replay
        if (response.equals("yes") || response.equals("y")) {
            // Clear console and start new game
            main(new String[]{});
        } else {
            System.out.println("\nThanks for playing! Goodbye! 👋");
        }
    }
}