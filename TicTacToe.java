import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToe {
  public static void main(String[] args) {
    // populate
    Board board = new Board();
    
    Boolean draw = true;

    // game start
    for(int turn = 0; turn < 9; turn++){
      // print board
      board.printBoard();   

      // Get user input
      try {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter row: ");
        board.setRow(scan.nextInt());
        System.out.print("Enter col: ");
        board.setCol(scan.nextInt());
      } catch (InputMismatchException e) {
        System.out.println("Please enter a number");
        turn--;
        continue;
      }

      //validate
      if (!board.isValid()) {
        System.out.println("You have entered an invalid row and column.");
        turn--;
        continue;
      }

      // player 1 and player 2
      board.updateBoard(turn);

      // check winner
      if (turn >= 4) {
        if(board.checkWinner()) {
          System.out.println("Player " + ((turn % 2 == 0) ? 1 : 2) + " wins");
          draw = false;
          return;
        }
      }
    }

    // print board
    board.printBoard();
    

    if(draw){
      System.out.println("Its a draw.");
    }
  }
}