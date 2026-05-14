package Orochi.Menu;

import Orochi.IO.FileModifier;
import Orochi.Logic.Game;
import Orochi.Validator;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    FileModifier fileMod = new FileModifier();
    Validator validator = new Validator();
    Game game = new Game();

    public void start() throws IOException {
        System.out.println("Current high score:" + fileMod.readHighScore());
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Please select a difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.println("4. Unlimited (infinite chances)");
        System.out.println("5. Exit");
        Scanner sc = new Scanner(System.in);
        int input = validator.validateInput(sc.nextLine());
        switch (input)
        {
            case 1:
                game.playGame(10,sc);
                break;
            case 2:
                game.playGame(5,sc);
                break;
            case 3:
                game.playGame(3,sc);
                break;
            case 4:
                game.playGame(Integer.MAX_VALUE,sc);
                break;
            case 5:
                System.out.println("Thank you for playing! Goodbye!");
                break;
            default:
                System.out.println("Invalid selection. Please restart the game and choose a valid difficulty level.");
                break;
        }
        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = sc.nextLine();
        if (playAgain.equalsIgnoreCase("yes")) {
            start();
        } else {    
            System.out.println("Thank you for playing! Goodbye!");
        }
        sc.close();
    }
}
