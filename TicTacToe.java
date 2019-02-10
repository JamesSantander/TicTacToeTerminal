import java.util.Scanner;

public class TicTacToe {
  public static void main(String[] args) {
    int board[][] = new int[3][3];
    //populate
    for(int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++) {
        board[i][j] = 0;
      }
    }

    Boolean draw = true;

    // game start
    for(int turn = 0; turn < 9; turn++){
      // print board
      for(int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++) {
          System.out.print(board[i][j]);
        }
        System.out.println("");
      }

      // Get user input 
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter row: ");
      int row = scan.nextInt();
      System.out.print("Enter col: ");
      int col = scan.nextInt();

      if ( (row >= 3 || row < 0) || (col >= 3 || col < 0) || (board[row][col] != 0) ) {
        System.out.println("You have entered an invalid row and column.");
        turn--;
        continue;
      }

      // player 1 and player 2
      board[row][col] = (turn % 2 == 0) ? 1 : 2; 

      // check winner
      if (turn >= 4) {
        // check column and row
        if( (board[row][0] == board[row][1] && board[row][1] == board[row][2]) || (board[0][col] == board[1][col] && board[1][col] == board[2][col]) ) {
          System.out.println("Player " + ((turn % 2 == 0) ? 1 : 2) + " wins");
          draw = false;
          break;
        }

        // check diagonal
        if (board[1][1] != 0) {
          if( (board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0]) ){
            System.out.println("Player " + ((turn % 2 == 0) ? 1 : 2) + " wins");
            draw = false;
            break;
          }
        }
      }
    }

    // print board
    for(int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println("");
    }

    if(draw){
      System.out.println("Its a draw.");
    }
  }
}