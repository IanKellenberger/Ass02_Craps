import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            playGame();
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
    }

    private static void playGame() {
        int point = rollDice();
        switch (point) {
            case 2:
            case 3:
            case 12:
                System.out.println("Craps! You crapped out and lost.");
                break;
            case 7:
            case 11:
                System.out.println("Natural! You win.");
                break;
            default:
                System.out.println("Point is " + point);
                boolean pointAchieved = false;
                while (!pointAchieved) {
                    int roll = rollDice();
                    if (roll == point) {
                        System.out.println("Made point! You win.");
                        pointAchieved = true;
                    } else if (roll == 7) {
                        System.out.println("Got a seven! You lost.");
                        pointAchieved = true;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
                break;
        }
    }

    private static int rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Rolled: " + die1 + " + " + die2 + " = " + sum);
        return sum;
    }
}