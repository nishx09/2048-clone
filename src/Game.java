package src;

import java.util.Scanner;

/**
 *
 * View for the game 2048
 *
 * @author Nishant Garg
 * @version April 11, 2021
 *
 */
public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        board.spawnRandom();
        board.spawnRandom();
        Scanner move = new Scanner(System.in);
        boolean continueGame = true;

        System.out.println("Game 2048!");
        System.out.println("Available moves: (w,a,s,d)" +"\n");
        System.out.println("Score: " + board.getScore());
        do {

            System.out.println(board);

            if(board.gameWon()){
                System.out.println("Congratulations, you won!");
                break;
            }

            if(board.gameOver()){
                System.out.println("Game Over!");
                break;
            }

            System.out.print("your move (w,a,s,d): ");
            String nextMove = move.nextLine();

            switch (nextMove){
                case "w":
                    board.move(MoveT.w);
                    break;
                case "a":
                    board.move(MoveT.a);
                    break;
                case "d":
                    board.move(MoveT.d);
                    break;
                case "s":
                    board.move(MoveT.s);
                    break;
                case "exit":
                    continueGame = false;
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
            System.out.println("Score: " + board.getScore());


        } while(continueGame);
    }
}