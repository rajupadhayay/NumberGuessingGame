package numberguessinggame;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public void start() {

        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        System.out.println("Welcome to Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {

            System.out.println("\nChoose Difficulty Level");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            int maxNumber;

            switch (choice) {
                case 1:
                    maxNumber = 100;
                    break;

                case 2:
                    maxNumber = 500;
                    break;

                case 3:
                    maxNumber = 1000;
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    continue;
            }

            System.out.println("Guess a number between 1 and " + maxNumber);

            int generateNum = rn.nextInt(maxNumber) + 1;
            int guessNum = 0;
            int attempt = 0;

            while (guessNum != generateNum) {

                System.out.print("Enter your guess: ");
                guessNum = sc.nextInt();
                attempt++;

                if (guessNum == generateNum) {
                    System.out.println("Congratulations! You won.");
                    System.out.println("Attempts: " + attempt);
                } else if (guessNum < generateNum) {
                    System.out.println("Too Low");
                } else {
                    System.out.println("Too High");
                }
            }

            while (true) {

                System.out.print("Do you want to play again? (Y/N): ");
                char ans = sc.next().charAt(0);

                if (ans == 'Y' || ans == 'y') {
                    break;
                } else if (ans == 'N' || ans == 'n') {
                    playAgain = false;
                    System.out.println("Thanks for playing!");
                    break;
                } else {
                    System.out.println("Invalid Input! Please enter Y or N.");
                }
            }
        }

        sc.close();
    }
}