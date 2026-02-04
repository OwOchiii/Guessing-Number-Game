package Orochi.Logic;
import Orochi.IO.FileModifier;
import Orochi.Validator;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Random random = new Random();
    FileModifier fileMod = new FileModifier();
    Validator validator = new Validator();

    public int generatedNumber() {
        return random.nextInt(1,100);
    }

    public boolean checkGuess(int generatedNumber, int userGuess) {
        return generatedNumber == userGuess;
    }

    public boolean isHigher(int generatedNumber, int userGuess) {
        return userGuess > generatedNumber;
    }

    public boolean isLower(int generatedNumber, int userGuess) {
        return userGuess < generatedNumber;
    }

    public void playGame(int chances, Scanner sc) throws IOException {
        int guessNumber = generatedNumber();
        for (int i = 0; i < chances; i++) {
            System.out.println("You have " + (chances - i) + " chances left. Make your guess:");
            int userGuess = validator.validateInput(sc.nextLine());
            if (checkGuess(guessNumber, userGuess)) {
                System.out.println("Congratulations! You've guessed the correct number: " + guessNumber + " in " + (i + 1) + " attempts.");
                fileMod.writeHighScore(String.valueOf(i+ 1));
                return;
            } else if (isHigher(guessNumber, userGuess)) {
                System.out.println("Your guess is too high.");
            } else if (isLower(guessNumber, userGuess)) {
                System.out.println("Your guess is too low.");
            }
            if (i == chances - 1) {
                System.out.println("Sorry, you've used all your chances. The correct number was: " + guessNumber);
            }
        }
    }
}
