public class Board {
  // Attributes
  private int board[][];
  private int row;
  private int col;

  // Methods
    // Constructors
  public Board () {
    this.board = new int[3][3];
    this.row = 0;
    this.col = 0;
    // populate
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.board[i][j] = 0;
      }
    }
  }
    // Setters
  public void setRow (int row) {
    this.row = row;
  }
  public void setCol (int col) {
    this.col = col;
  }
    // No Getters

  public void printBoard () {
    // print board
    for(int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println("");
    }
  }

  public void updateBoard (int turn) {
    this.board[this.row][this.col] = (turn % 2 == 0) ? 1 : 2; 
  }

  public Boolean checkWinner () {
    // check column and row
    if( (this.board[this.row][0] == this.board[this.row][1] && this.board[this.row][1] == this.board[this.row][2]) || (this.board[0][this.col] == this.board[1][this.col] && this.board[1][this.col] == this.board[2][this.col]) ) {
      return true;
    }

    // check diagonal
    if (this.board[1][1] != 0) {
      if( (this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]) || (this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0]) ){
        return true;
      }
    }

    return false;
  }

  public Boolean isValid() {
    if ( (this.row >= 3 || this.row < 0) || (this.col >= 3 || this.col < 0) || (this.board[this.row][this.col] != 0) ) {
      return false;
    }
    return true;
  }
}